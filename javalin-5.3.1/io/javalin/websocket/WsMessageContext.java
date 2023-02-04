package io.javalin.websocket;

import io.javalin.json.JsonMapperKt;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.TypesJVMKt;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0000\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\004\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\003¢\006\002\020\007J\006\020\006\032\0020\003J\032\020\b\032\002H\t\"\n\b\000\020\t\030\001*\0020\nH\b¢\006\002\020\013J\037\020\b\032\002H\t\"\004\b\000\020\t2\f\020\f\032\b\022\004\022\002H\t0\r¢\006\002\020\016J\031\020\b\032\002H\t\"\004\b\000\020\t2\006\020\017\032\0020\020¢\006\002\020\021R\016\020\006\032\0020\003X\004¢\006\002\n\000¨\006\022"}, d2 = {"Lio/javalin/websocket/WsMessageContext;", "Lio/javalin/websocket/WsContext;", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "message", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;Ljava/lang/String;)V", "messageAsClass", "T", "", "()Ljava/lang/Object;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;", "javalin"})
public final class WsMessageContext extends WsContext {
  @NotNull
  private final String message;
  
  public WsMessageContext(@NotNull String sessionId, @NotNull Session session, @NotNull String message) {
    super(sessionId, session);
    this.message = message;
  }
  
  @NotNull
  public final String message() {
    return this.message;
  }
  
  public final <T> T messageAsClass(@NotNull Type type) {
    Intrinsics.checkNotNullParameter(type, "type");
    return JsonMapperKt.jsonMapper(getUpgradeCtx$javalin()).fromJsonString(this.message, type);
  }
  
  public final <T> T messageAsClass(@NotNull Class clazz) {
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return messageAsClass(clazz);
  }
}
