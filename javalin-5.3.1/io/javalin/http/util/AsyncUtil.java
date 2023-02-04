package io.javalin.http.util;

import io.javalin.http.Context;
import io.javalin.util.ConcurrencyUtil;
import io.javalin.util.function.ThrowingRunnable;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.AsyncEvent;
import jakarta.servlet.AsyncListener;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000V\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\004\n\002\020\013\n\002\b\002\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J<\020\007\032\0020\b2\006\020\t\032\0020\n2\b\020\013\032\004\030\0010\0042\006\020\f\032\0020\r2\b\020\016\032\004\030\0010\0172\020\020\020\032\f\022\b\022\0060\022j\002`\0230\021Ji\020\024\032\0020\025*\0020\0252\024\b\002\020\026\032\016\022\004\022\0020\030\022\004\022\0020\b0\0272\024\b\002\020\031\032\016\022\004\022\0020\030\022\004\022\0020\b0\0272\024\b\002\020\032\032\016\022\004\022\0020\030\022\004\022\0020\b0\0272\024\b\002\020\016\032\016\022\004\022\0020\030\022\004\022\0020\b0\027H\000¢\006\002\b\033J\021\020\034\032\0020\035*\0020\nH\000¢\006\002\b\036R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\037"}, d2 = {"Lio/javalin/http/util/AsyncUtil;", "", "()V", "defaultExecutor", "Ljava/util/concurrent/ExecutorService;", "getDefaultExecutor", "()Ljava/util/concurrent/ExecutorService;", "submitAsyncTask", "", "context", "Lio/javalin/http/Context;", "executor", "timeout", "", "onTimeout", "Ljava/lang/Runnable;", "task", "Lio/javalin/util/function/ThrowingRunnable;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "addListener", "Ljakarta/servlet/AsyncContext;", "onComplete", "Lkotlin/Function1;", "Ljakarta/servlet/AsyncEvent;", "onError", "onStartAsync", "addListener$javalin", "isAsync", "", "isAsync$javalin", "javalin"})
public final class AsyncUtil {
  @NotNull
  public static final AsyncUtil INSTANCE = new AsyncUtil();
  
  @NotNull
  private static final ExecutorService defaultExecutor = ConcurrencyUtil.executorService("JavalinDefaultAsyncThreadPool");
  
  @NotNull
  public final ExecutorService getDefaultExecutor() {
    return defaultExecutor;
  }
  
  public final void submitAsyncTask(@NotNull Context context, @Nullable ExecutorService executor, long timeout, @Nullable Runnable onTimeout, @NotNull ThrowingRunnable task) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'context'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload #6
    //   8: ldc 'task'
    //   10: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_1
    //   14: aload_2
    //   15: aload #6
    //   17: lload_3
    //   18: aload #5
    //   20: <illegal opcode> get : (Ljava/util/concurrent/ExecutorService;Lio/javalin/util/function/ThrowingRunnable;JLjava/lang/Runnable;)Ljava/util/function/Supplier;
    //   25: invokeinterface future : (Ljava/util/function/Supplier;)V
    //   30: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #20	-> 13
    //   #31	-> 30
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	31	0	this	Lio/javalin/http/util/AsyncUtil;
    //   0	31	1	context	Lio/javalin/http/Context;
    //   0	31	2	executor	Ljava/util/concurrent/ExecutorService;
    //   0	31	3	timeout	J
    //   0	31	5	onTimeout	Ljava/lang/Runnable;
    //   0	31	6	task	Lio/javalin/util/function/ThrowingRunnable;
  }
  
  private static final void submitAsyncTask$lambda-4$lambda-0(ThrowingRunnable $task) {
    Intrinsics.checkNotNullParameter($task, "$task");
    $task.run();
  }
  
  private static final CompletableFuture submitAsyncTask$lambda-4(ExecutorService $executor, ThrowingRunnable $task, long $timeout, Runnable $onTimeout) {
    Intrinsics.checkNotNullParameter($task, "$task");
    if ($executor == null);
    CompletableFuture<Void> completableFuture = CompletableFuture.runAsync((Runnable)$executor, defaultExecutor);
    int $i$a$-let-AsyncUtil$submitAsyncTask$1$2 = 0;
    CompletableFuture it = ($timeout > 0L) ? completableFuture.orTimeout($timeout, TimeUnit.MILLISECONDS) : completableFuture;
    int $i$a$-let-AsyncUtil$submitAsyncTask$1$3 = 0;
    return ($onTimeout == null) ? it : it.exceptionally($onTimeout::submitAsyncTask$lambda-4$lambda-3$lambda-2);
  }
  
  private static final Void submitAsyncTask$lambda-4$lambda-3$lambda-2(Runnable $onTimeout, Throwable exception) {
    if (((exception instanceof java.util.concurrent.TimeoutException) ? exception : null) == null) {
      (exception instanceof java.util.concurrent.TimeoutException) ? exception : null;
      Throwable throwable = (exception != null) ? exception.getCause() : null;
      if (((throwable instanceof java.util.concurrent.TimeoutException) ? throwable : null) == null) {
        (throwable instanceof java.util.concurrent.TimeoutException) ? throwable : null;
        Intrinsics.checkNotNullExpressionValue(exception, "exception");
        throw exception;
      } 
    } 
    (exception instanceof java.util.concurrent.TimeoutException) ? exception : null;
    $onTimeout.run();
    return null;
  }
  
  public final boolean isAsync$javalin(@NotNull Context $this$isAsync) {
    Intrinsics.checkNotNullParameter($this$isAsync, "<this>");
    return $this$isAsync.req().isAsyncStarted();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Ljakarta/servlet/AsyncEvent;", "invoke"})
  static final class AsyncUtil$addListener$1 extends Lambda implements Function1<AsyncEvent, Unit> {
    public static final AsyncUtil$addListener$1 INSTANCE = new AsyncUtil$addListener$1();
    
    AsyncUtil$addListener$1() {
      super(1);
    }
    
    public final void invoke(@NotNull AsyncEvent it) {
      Intrinsics.checkNotNullParameter(it, "it");
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Ljakarta/servlet/AsyncEvent;", "invoke"})
  static final class AsyncUtil$addListener$2 extends Lambda implements Function1<AsyncEvent, Unit> {
    public static final AsyncUtil$addListener$2 INSTANCE = new AsyncUtil$addListener$2();
    
    AsyncUtil$addListener$2() {
      super(1);
    }
    
    public final void invoke(@NotNull AsyncEvent it) {
      Intrinsics.checkNotNullParameter(it, "it");
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Ljakarta/servlet/AsyncEvent;", "invoke"})
  static final class AsyncUtil$addListener$3 extends Lambda implements Function1<AsyncEvent, Unit> {
    public static final AsyncUtil$addListener$3 INSTANCE = new AsyncUtil$addListener$3();
    
    AsyncUtil$addListener$3() {
      super(1);
    }
    
    public final void invoke(@NotNull AsyncEvent it) {
      Intrinsics.checkNotNullParameter(it, "it");
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Ljakarta/servlet/AsyncEvent;", "invoke"})
  static final class AsyncUtil$addListener$4 extends Lambda implements Function1<AsyncEvent, Unit> {
    public static final AsyncUtil$addListener$4 INSTANCE = new AsyncUtil$addListener$4();
    
    AsyncUtil$addListener$4() {
      super(1);
    }
    
    public final void invoke(@NotNull AsyncEvent it) {
      Intrinsics.checkNotNullParameter(it, "it");
    }
  }
  
  @NotNull
  public final AsyncContext addListener$javalin(@NotNull AsyncContext $this$addListener, @NotNull Function1<? super AsyncEvent, Unit> onComplete, @NotNull Function1<? super AsyncEvent, Unit> onError, @NotNull Function1<? super AsyncEvent, Unit> onStartAsync, @NotNull Function1<? super AsyncEvent, Unit> onTimeout) {
    Intrinsics.checkNotNullParameter($this$addListener, "<this>");
    Intrinsics.checkNotNullParameter(onComplete, "onComplete");
    Intrinsics.checkNotNullParameter(onError, "onError");
    Intrinsics.checkNotNullParameter(onStartAsync, "onStartAsync");
    Intrinsics.checkNotNullParameter(onTimeout, "onTimeout");
    AsyncContext asyncContext1 = $this$addListener, $this$addListener_u24lambda_u2d5 = asyncContext1;
    int $i$a$-apply-AsyncUtil$addListener$5 = 0;
    $this$addListener_u24lambda_u2d5.addListener(new AsyncUtil$addListener$5$1(onComplete, onError, onStartAsync, onTimeout));
    return asyncContext1;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\031\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\004*\001\000\b\n\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H\026J\020\020\006\032\0020\0032\006\020\004\032\0020\005H\026J\020\020\007\032\0020\0032\006\020\004\032\0020\005H\026J\020\020\b\032\0020\0032\006\020\004\032\0020\005H\026¨\006\t"}, d2 = {"io/javalin/http/util/AsyncUtil$addListener$5$1", "Ljakarta/servlet/AsyncListener;", "onComplete", "", "event", "Ljakarta/servlet/AsyncEvent;", "onError", "onStartAsync", "onTimeout", "javalin"})
  public static final class AsyncUtil$addListener$5$1 implements AsyncListener {
    AsyncUtil$addListener$5$1(Function1<AsyncEvent, Unit> $onComplete, Function1<AsyncEvent, Unit> $onError, Function1<AsyncEvent, Unit> $onStartAsync, Function1<AsyncEvent, Unit> $onTimeout) {}
    
    public void onComplete(@NotNull AsyncEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      this.$onComplete.invoke(event);
    }
    
    public void onError(@NotNull AsyncEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      this.$onError.invoke(event);
    }
    
    public void onStartAsync(@NotNull AsyncEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      this.$onStartAsync.invoke(event);
    }
    
    public void onTimeout(@NotNull AsyncEvent event) {
      Intrinsics.checkNotNullParameter(event, "event");
      this.$onTimeout.invoke(event);
    }
  }
}
