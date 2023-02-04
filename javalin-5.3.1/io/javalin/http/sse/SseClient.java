package io.javalin.http.sse;

import io.javalin.http.Context;
import io.javalin.json.JsonMapper;
import io.javalin.json.JsonMapperKt;
import io.javalin.util.JavalinLogger;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000H\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\005\n\002\020\016\n\002\b\002\n\002\020\000\n\002\b\002\n\002\020\013\n\000\030\0002\0020\001B\017\b\000\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\r\032\0020\016H\026J\006\020\002\032\0020\003J\006\020\017\032\0020\016J\b\020\020\032\0020\016H\002J\016\020\021\032\0020\0162\006\020\007\032\0020\bJ\016\020\022\032\0020\0162\006\020\023\032\0020\024J\016\020\025\032\0020\0162\006\020\026\032\0020\027J$\020\025\032\0020\0162\006\020\030\032\0020\0242\006\020\026\032\0020\0272\n\b\002\020\031\032\004\030\0010\024H\007J\006\020\013\032\0020\032R\024\020\005\032\b\022\002\b\003\030\0010\006X\016¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000¨\006\033"}, d2 = {"Lio/javalin/http/sse/SseClient;", "Ljava/io/Closeable;", "ctx", "Lio/javalin/http/Context;", "(Lio/javalin/http/Context;)V", "blockingFuture", "Ljava/util/concurrent/CompletableFuture;", "closeCallback", "Ljava/lang/Runnable;", "emitter", "Lio/javalin/http/sse/Emitter;", "terminated", "Ljava/util/concurrent/atomic/AtomicBoolean;", "close", "", "keepAlive", "logTerminated", "onClose", "sendComment", "comment", "", "sendEvent", "data", "", "event", "id", "", "javalin"})
public final class SseClient implements Closeable {
  @NotNull
  private final Context ctx;
  
  @NotNull
  private final AtomicBoolean terminated;
  
  @NotNull
  private final Emitter emitter;
  
  @Nullable
  private CompletableFuture<?> blockingFuture;
  
  @NotNull
  private Runnable closeCallback;
  
  public SseClient(@NotNull Context ctx) {
    this.ctx = ctx;
    this.terminated = new AtomicBoolean(false);
    this.emitter = new Emitter(this.ctx.res());
    this.closeCallback = SseClient::closeCallback$lambda-0;
  }
  
  private static final void closeCallback$lambda-0() {}
  
  @NotNull
  public final Context ctx() {
    return this.ctx;
  }
  
  public final boolean terminated() {
    return this.terminated.get();
  }
  
  public final void keepAlive() {
    CompletableFuture<?> completableFuture1 = new CompletableFuture(), completableFuture2 = completableFuture1;
    SseClient sseClient = this;
    int $i$a$-also-SseClient$keepAlive$1 = 0;
    this.ctx.future(completableFuture2::keepAlive$lambda-2$lambda-1);
    sseClient.blockingFuture = completableFuture1;
  }
  
  private static final CompletableFuture keepAlive$lambda-2$lambda-1(CompletableFuture $it) {
    Intrinsics.checkNotNullParameter($it, "$it");
    return $it;
  }
  
  public final void onClose(@NotNull Runnable closeCallback) {
    Intrinsics.checkNotNullParameter(closeCallback, "closeCallback");
    this.closeCallback = closeCallback;
  }
  
  public void close() {
    if (this.terminated.getAndSet(true))
      return; 
    this.closeCallback.run();
    if (this.blockingFuture != null) {
      this.blockingFuture.complete(null);
    } else {
    
    } 
  }
  
  public final void sendEvent(@NotNull Object data) {
    Intrinsics.checkNotNullParameter(data, "data");
    sendEvent$default(this, "message", data, null, 4, null);
  }
  
  @JvmOverloads
  public final void sendEvent(@NotNull String event, @NotNull Object data, @Nullable String id) {
    Intrinsics.checkNotNullParameter(event, "event");
    Intrinsics.checkNotNullParameter(data, "data");
    if (this.terminated.get()) {
      logTerminated();
      return;
    } 
    Object object = data;
    if (object instanceof InputStream) {
      this.emitter.emit(event, (InputStream)data, id);
    } else if (object instanceof String) {
      String str = (String)data;
      Charset charset = Charsets.UTF_8;
      Intrinsics.checkNotNullExpressionValue(str.getBytes(charset), "this as java.lang.String).getBytes(charset)");
      this.emitter.emit(event, new ByteArrayInputStream(str.getBytes(charset)), id);
    } else {
      JsonMapper $this$toJsonString$iv = JsonMapperKt.jsonMapper(this.ctx);
      int $i$f$toJsonString = 0;
      String str = $this$toJsonString$iv.toJsonString(data, TypesJVMKt.getJavaType(Reflection.typeOf(Object.class)));
      Charset charset = Charsets.UTF_8;
      Intrinsics.checkNotNullExpressionValue(str.getBytes(charset), "this as java.lang.String).getBytes(charset)");
      this.emitter.emit(event, new ByteArrayInputStream(str.getBytes(charset)), id);
    } 
    if (this.emitter.getClosed())
      close(); 
  }
  
  public final void sendComment(@NotNull String comment) {
    Intrinsics.checkNotNullParameter(comment, "comment");
    if (this.terminated.get()) {
      logTerminated();
      return;
    } 
    this.emitter.emit(comment);
    if (this.emitter.getClosed())
      close(); 
  }
  
  private final void logTerminated() {
    JavalinLogger.warn$default("Cannot send data, SseClient has been terminated.", null, 2, null);
  }
  
  @JvmOverloads
  public final void sendEvent(@NotNull String event, @NotNull Object data) {
    Intrinsics.checkNotNullParameter(event, "event");
    Intrinsics.checkNotNullParameter(data, "data");
    sendEvent$default(this, event, data, null, 4, null);
  }
}
