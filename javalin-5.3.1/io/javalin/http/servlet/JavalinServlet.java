package io.javalin.http.servlet;

import io.javalin.config.JavalinConfig;
import io.javalin.http.HttpStatus;
import io.javalin.http.util.AsyncUtil;
import io.javalin.http.util.ETagGenerator;
import io.javalin.routing.PathMatcher;
import jakarta.servlet.AsyncContext;
import jakarta.servlet.AsyncEvent;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000T\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\030\020\023\032\0020\0242\006\020\025\032\0020\0262\006\020\027\032\0020\030H\024J\f\020\031\032\0020\024*\0020\032H\002J'\020\033\032\004\030\001H\034\"\004\b\000\020\034*\0020\0322\f\020\035\032\b\022\004\022\002H\0340\036H\002¢\006\002\020\037J\f\020 \032\0020\024*\0020\032H\002J\024\020!\032\n #*\004\030\0010\"0\"*\0020\032H\002J\f\020$\032\0020\024*\0020\032H\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\b¢\006\b\n\000\032\004\b\t\020\nR\021\020\013\032\0020\f¢\006\b\n\000\032\004\b\r\020\016R\021\020\017\032\0020\020¢\006\b\n\000\032\004\b\021\020\022¨\006%"}, d2 = {"Lio/javalin/http/servlet/JavalinServlet;", "Ljakarta/servlet/http/HttpServlet;", "cfg", "Lio/javalin/config/JavalinConfig;", "(Lio/javalin/config/JavalinConfig;)V", "getCfg", "()Lio/javalin/config/JavalinConfig;", "errorMapper", "Lio/javalin/http/servlet/ErrorMapper;", "getErrorMapper", "()Lio/javalin/http/servlet/ErrorMapper;", "exceptionMapper", "Lio/javalin/http/servlet/ExceptionMapper;", "getExceptionMapper", "()Lio/javalin/http/servlet/ExceptionMapper;", "matcher", "Lio/javalin/routing/PathMatcher;", "getMatcher", "()Lio/javalin/routing/PathMatcher;", "service", "", "request", "Ljakarta/servlet/http/HttpServletRequest;", "response", "Ljakarta/servlet/http/HttpServletResponse;", "handleSync", "Lio/javalin/http/servlet/JavalinServletContext;", "handleTask", "R", "handler", "Lio/javalin/http/servlet/TaskHandler;", "(Lio/javalin/http/servlet/JavalinServletContext;Lio/javalin/http/servlet/TaskHandler;)Ljava/lang/Object;", "handleUserFuture", "startAsyncAndAddDefaultTimeoutListeners", "Ljakarta/servlet/AsyncContext;", "kotlin.jvm.PlatformType", "writeResponseAndLog", "javalin"})
public final class JavalinServlet extends HttpServlet {
  @NotNull
  private final JavalinConfig cfg;
  
  @NotNull
  private final PathMatcher matcher;
  
  @NotNull
  private final ExceptionMapper exceptionMapper;
  
  @NotNull
  private final ErrorMapper errorMapper;
  
  public JavalinServlet(@NotNull JavalinConfig cfg) {
    this.cfg = cfg;
    this.matcher = new PathMatcher();
    this.exceptionMapper = new ExceptionMapper(this.cfg);
    this.errorMapper = new ErrorMapper();
  }
  
  @NotNull
  public final JavalinConfig getCfg() {
    return this.cfg;
  }
  
  @NotNull
  public final PathMatcher getMatcher() {
    return this.matcher;
  }
  
  @NotNull
  public final ExceptionMapper getExceptionMapper() {
    return this.exceptionMapper;
  }
  
  @NotNull
  public final ErrorMapper getErrorMapper() {
    return this.errorMapper;
  }
  
  protected void service(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
    Intrinsics.checkNotNullParameter(request, "request");
    Intrinsics.checkNotNullParameter(response, "response");
    try {
      JavalinConfig javalinConfig = this.cfg;
      JavalinServletContext ctx = new JavalinServletContext(javalinConfig, null, false, null, request, response, null, null, null, null, null, null, null, null, null, 32718, null);
      Function2<? super SubmitOrder, ? super Task, Unit> submitTask = new JavalinServlet$service$submitTask$1(ctx);
      String requestUri = StringsKt.removePrefix(ctx.path(), ctx.contextPath());
      Iterable<? extends TaskInitializer<JavalinServletContext>> $this$forEach$iv = this.cfg.pvt.servletRequestLifecycle;
      int $i$f$forEach = 0;
      for (Object<JavalinServletContext> element$iv : $this$forEach$iv) {
        TaskInitializer<JavalinServletContext> it = (TaskInitializer)element$iv;
        int $i$a$-forEach-JavalinServlet$service$1 = 0;
        it.createTasks(submitTask, this, ctx, requestUri);
      } 
      handleSync(ctx);
    } catch (Throwable throwable) {
      this.exceptionMapper.handleUnexpectedThrowable$javalin(response, throwable);
    } 
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\024\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\005H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "order", "Lio/javalin/http/servlet/SubmitOrder;", "task", "Lio/javalin/http/servlet/Task;", "invoke"})
  static final class JavalinServlet$service$submitTask$1 extends Lambda implements Function2<SubmitOrder, Task, Unit> {
    public final void invoke(@NotNull SubmitOrder order, @NotNull Task task) {
      Intrinsics.checkNotNullParameter(order, "order");
      Intrinsics.checkNotNullParameter(task, "task");
      switch (WhenMappings.$EnumSwitchMapping$0[order.ordinal()]) {
        case 1:
          this.$ctx.getTasks().offerFirst(task);
          break;
        case 2:
          this.$ctx.getTasks().add(task);
          break;
      } 
    }
    
    JavalinServlet$service$submitTask$1(JavalinServletContext $ctx) {
      super(2);
    }
  }
  
  private final void handleSync(JavalinServletContext $this$handleSync) {
    while ($this$handleSync.getUserFutureSupplier$javalin() == null && (!$this$handleSync.getTasks().isEmpty())) {
      Task task = $this$handleSync.getTasks().poll();
      if ($this$handleSync.getExceptionOccurred() && task.getSkipIfExceptionOccurred())
        continue; 
      handleTask($this$handleSync, task.getHandler());
    } 
    if ($this$handleSync.getUserFutureSupplier$javalin() != null) {
      handleUserFuture($this$handleSync);
    } else {
      writeResponseAndLog($this$handleSync);
    } 
  }
  
  private final void handleUserFuture(JavalinServletContext $this$handleUserFuture) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getUserFutureSupplier$javalin : ()Ljava/util/function/Supplier;
    //   4: dup
    //   5: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   8: astore_3
    //   9: aload_3
    //   10: astore #4
    //   12: iconst_0
    //   13: istore #5
    //   15: aload_1
    //   16: aconst_null
    //   17: invokevirtual setUserFutureSupplier$javalin : (Ljava/util/function/Supplier;)V
    //   20: aload_3
    //   21: astore_2
    //   22: aload_0
    //   23: aload_1
    //   24: aload_2
    //   25: <illegal opcode> handle : (Ljava/util/function/Supplier;)Lio/javalin/http/servlet/TaskHandler;
    //   30: invokespecial handleTask : (Lio/javalin/http/servlet/JavalinServletContext;Lio/javalin/http/servlet/TaskHandler;)Ljava/lang/Object;
    //   33: checkcast java/util/concurrent/CompletableFuture
    //   36: dup
    //   37: ifnonnull -> 47
    //   40: pop
    //   41: aload_0
    //   42: aload_1
    //   43: invokespecial handleSync : (Lio/javalin/http/servlet/JavalinServletContext;)V
    //   46: return
    //   47: astore_3
    //   48: getstatic io/javalin/http/util/AsyncUtil.INSTANCE : Lio/javalin/http/util/AsyncUtil;
    //   51: aload_1
    //   52: checkcast io/javalin/http/Context
    //   55: invokevirtual isAsync$javalin : (Lio/javalin/http/Context;)Z
    //   58: ifne -> 67
    //   61: aload_0
    //   62: aload_1
    //   63: invokespecial startAsyncAndAddDefaultTimeoutListeners : (Lio/javalin/http/servlet/JavalinServletContext;)Ljakarta/servlet/AsyncContext;
    //   66: pop
    //   67: getstatic io/javalin/http/util/AsyncUtil.INSTANCE : Lio/javalin/http/util/AsyncUtil;
    //   70: aload_1
    //   71: invokevirtual req : ()Ljakarta/servlet/http/HttpServletRequest;
    //   74: invokeinterface getAsyncContext : ()Ljakarta/servlet/AsyncContext;
    //   79: dup
    //   80: ldc 'req().asyncContext'
    //   82: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   85: aconst_null
    //   86: aconst_null
    //   87: aconst_null
    //   88: new io/javalin/http/servlet/JavalinServlet$handleUserFuture$1
    //   91: dup
    //   92: aload_3
    //   93: invokespecial <init> : (Ljava/util/concurrent/CompletableFuture;)V
    //   96: checkcast kotlin/jvm/functions/Function1
    //   99: bipush #7
    //   101: aconst_null
    //   102: invokestatic addListener$javalin$default : (Lio/javalin/http/util/AsyncUtil;Ljakarta/servlet/AsyncContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljakarta/servlet/AsyncContext;
    //   105: pop
    //   106: aload_3
    //   107: aload_0
    //   108: aload_1
    //   109: <illegal opcode> apply : (Lio/javalin/http/servlet/JavalinServlet;Lio/javalin/http/servlet/JavalinServletContext;)Ljava/util/function/Function;
    //   114: invokevirtual thenApply : (Ljava/util/function/Function;)Ljava/util/concurrent/CompletableFuture;
    //   117: aload_0
    //   118: aload_1
    //   119: <illegal opcode> apply : (Lio/javalin/http/servlet/JavalinServlet;Lio/javalin/http/servlet/JavalinServletContext;)Ljava/util/function/Function;
    //   124: invokevirtual exceptionally : (Ljava/util/function/Function;)Ljava/util/concurrent/CompletableFuture;
    //   127: pop
    //   128: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #62	-> 0
    //   #114	-> 12
    //   #62	-> 15
    //   #62	-> 20
    //   #62	-> 21
    //   #63	-> 22
    //   #64	-> 48
    //   #65	-> 67
    //   #66	-> 106
    //   #67	-> 107
    //   #68	-> 117
    //   #72	-> 128
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   15	5	5	$i$a$-also-JavalinServlet$handleUserFuture$userFutureSupplier$1	I
    //   12	8	4	it	Ljava/util/function/Supplier;
    //   22	107	2	userFutureSupplier	Ljava/util/function/Supplier;
    //   48	81	3	userFuture	Ljava/util/concurrent/CompletableFuture;
    //   0	129	0	this	Lio/javalin/http/servlet/JavalinServlet;
    //   0	129	1	$this$handleUserFuture	Lio/javalin/http/servlet/JavalinServletContext;
  }
  
  private static final CompletableFuture handleUserFuture$lambda-2(Supplier<CompletableFuture> $userFutureSupplier) {
    Intrinsics.checkNotNullParameter($userFutureSupplier, "$userFutureSupplier");
    return $userFutureSupplier.get();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Ljakarta/servlet/AsyncEvent;", "invoke"})
  static final class JavalinServlet$handleUserFuture$1 extends Lambda implements Function1<AsyncEvent, Unit> {
    JavalinServlet$handleUserFuture$1(CompletableFuture<?> $userFuture) {
      super(1);
    }
    
    public final void invoke(@NotNull AsyncEvent it) {
      Intrinsics.checkNotNullParameter(it, "it");
      this.$userFuture.cancel(true);
    }
  }
  
  private static final Unit handleUserFuture$lambda-3(JavalinServlet this$0, JavalinServletContext $this_handleUserFuture, Object it) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter($this_handleUserFuture, "$this_handleUserFuture");
    this$0.handleSync($this_handleUserFuture);
    return Unit.INSTANCE;
  }
  
  private static final Unit handleUserFuture$lambda-4(JavalinServlet this$0, JavalinServletContext $this_handleUserFuture, Throwable it) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter($this_handleUserFuture, "$this_handleUserFuture");
    Intrinsics.checkNotNullExpressionValue(it, "it");
    this$0.exceptionMapper.handle$javalin($this_handleUserFuture, it);
    this$0.writeResponseAndLog($this_handleUserFuture);
    return Unit.INSTANCE;
  }
  
  private final AsyncContext startAsyncAndAddDefaultTimeoutListeners(JavalinServletContext $this$startAsyncAndAddDefaultTimeoutListeners) {
    AsyncContext asyncContext1 = $this$startAsyncAndAddDefaultTimeoutListeners.req().startAsync(), it = asyncContext1;
    int $i$a$-also-JavalinServlet$startAsyncAndAddDefaultTimeoutListeners$1 = 0;
    it.setTimeout(this.cfg.http.asyncTimeout);
    Intrinsics.checkNotNullExpressionValue(it, "it");
    AsyncUtil.addListener$javalin$default(AsyncUtil.INSTANCE, it, null, null, null, new JavalinServlet$startAsyncAndAddDefaultTimeoutListeners$1$1(this), 7, null);
    return asyncContext1;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Ljakarta/servlet/AsyncEvent;", "invoke"})
  static final class JavalinServlet$startAsyncAndAddDefaultTimeoutListeners$1$1 extends Lambda implements Function1<AsyncEvent, Unit> {
    public final void invoke(@NotNull AsyncEvent it) {
      Intrinsics.checkNotNullParameter(it, "it");
      this.$this_startAsyncAndAddDefaultTimeoutListeners.status(HttpStatus.INTERNAL_SERVER_ERROR);
      JavalinServlet.this.getErrorMapper().handle(this.$this_startAsyncAndAddDefaultTimeoutListeners.statusCode(), this.$this_startAsyncAndAddDefaultTimeoutListeners);
      if (this.$this_startAsyncAndAddDefaultTimeoutListeners.resultInputStream() == null)
        this.$this_startAsyncAndAddDefaultTimeoutListeners.result(HttpStatus.REQUEST_TIMEOUT.getMessage()); 
      JavalinServlet.this.writeResponseAndLog(this.$this_startAsyncAndAddDefaultTimeoutListeners);
    }
    
    JavalinServlet$startAsyncAndAddDefaultTimeoutListeners$1$1(JavalinServlet javalinServlet) {
      super(1);
    }
  }
  
  private final <R> R handleTask(JavalinServletContext $this$handleTask, TaskHandler<Object> handler) {
    // Byte code:
    //   0: nop
    //   1: aload_2
    //   2: invokeinterface handle : ()Ljava/lang/Object;
    //   7: astore_3
    //   8: goto -> 52
    //   11: astore #4
    //   13: aload_1
    //   14: iconst_1
    //   15: invokevirtual setExceptionOccurred : (Z)V
    //   18: aload_1
    //   19: aconst_null
    //   20: invokevirtual setUserFutureSupplier$javalin : (Ljava/util/function/Supplier;)V
    //   23: aload_1
    //   24: invokevirtual getTasks : ()Ljava/util/Deque;
    //   27: new io/javalin/http/servlet/Task
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: aload_1
    //   34: aload #4
    //   36: <illegal opcode> handle : (Lio/javalin/http/servlet/JavalinServlet;Lio/javalin/http/servlet/JavalinServletContext;Ljava/lang/Throwable;)Lio/javalin/http/servlet/TaskHandler;
    //   41: invokespecial <init> : (ZLio/javalin/http/servlet/TaskHandler;)V
    //   44: invokeinterface offerFirst : (Ljava/lang/Object;)Z
    //   49: pop
    //   50: aconst_null
    //   51: astore_3
    //   52: aload_3
    //   53: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #85	-> 0
    //   #86	-> 1
    //   #87	-> 11
    //   #88	-> 13
    //   #89	-> 18
    //   #90	-> 23
    //   #91	-> 50
    //   #92	-> 53
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   13	39	4	throwable	Ljava/lang/Throwable;
    //   0	54	0	this	Lio/javalin/http/servlet/JavalinServlet;
    //   0	54	1	$this$handleTask	Lio/javalin/http/servlet/JavalinServletContext;
    //   0	54	2	handler	Lio/javalin/http/servlet/TaskHandler;
    // Exception table:
    //   from	to	target	type
    //   0	8	11	java/lang/Throwable
  }
  
  private static final Unit handleTask$lambda-6(JavalinServlet this$0, JavalinServletContext $this_handleTask, Throwable $throwable) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter($this_handleTask, "$this_handleTask");
    Intrinsics.checkNotNullParameter($throwable, "$throwable");
    this$0.exceptionMapper.handle$javalin($this_handleTask, $throwable);
    return Unit.INSTANCE;
  }
  
  private final void writeResponseAndLog(JavalinServletContext $this$writeResponseAndLog) {
    try {
      if ($this$writeResponseAndLog.getResponseWritten().getAndSet(true))
        return; 
      if ($this$writeResponseAndLog.resultInputStream() != null) {
        InputStream inputStream = $this$writeResponseAndLog.resultInputStream();
        Throwable throwable = null;
        try {
          InputStream resultStream = inputStream;
          int $i$a$-use-JavalinServlet$writeResponseAndLog$1 = 0;
          boolean etagWritten = ETagGenerator.INSTANCE.tryWriteEtagAndClose(this.cfg.http.generateEtags, $this$writeResponseAndLog, resultStream);
          if (!etagWritten)
            ByteStreamsKt.copyTo(resultStream, (OutputStream)$this$writeResponseAndLog.outputStream(), 4096); 
          Unit unit = Unit.INSTANCE;
        } catch (Throwable throwable1) {
          throwable = throwable1 = null;
          throw throwable1;
        } finally {
          CloseableKt.closeFinally(inputStream, throwable);
        } 
      } else {
        $this$writeResponseAndLog.resultInputStream();
      } 
      if (this.cfg.pvt.requestLogger != null) {
        this.cfg.pvt.requestLogger.handle($this$writeResponseAndLog, Float.valueOf($this$writeResponseAndLog.executionTimeMs()));
      } else {
      
      } 
    } catch (Throwable throwable) {
      this.exceptionMapper.handleUnexpectedThrowable$javalin($this$writeResponseAndLog.res(), throwable);
    } finally {
      if ($this$writeResponseAndLog.getOutputStreamWrapper$javalin().isReady())
        $this$writeResponseAndLog.outputStream().close(); 
      if (AsyncUtil.INSTANCE.isAsync$javalin($this$writeResponseAndLog))
        $this$writeResponseAndLog.req().getAsyncContext().complete(); 
    } 
  }
}
