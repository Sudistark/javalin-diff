package io.javalin.http.sse;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000(\n\002\030\002\n\002\030\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\037\b\007\022\b\b\002\020\002\032\0020\003\022\f\020\004\032\b\022\004\022\0020\0060\005¢\006\002\020\007J\020\020\b\032\0020\t2\006\020\n\032\0020\013H\026R\024\020\004\032\b\022\004\022\0020\0060\005X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\f"}, d2 = {"Lio/javalin/http/sse/SseHandler;", "Lio/javalin/http/Handler;", "timeout", "", "clientConsumer", "Ljava/util/function/Consumer;", "Lio/javalin/http/sse/SseClient;", "(JLjava/util/function/Consumer;)V", "handle", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
public final class SseHandler implements Handler {
  private final long timeout;
  
  @NotNull
  private final Consumer<SseClient> clientConsumer;
  
  @JvmOverloads
  public SseHandler(long timeout, @NotNull Consumer<SseClient> clientConsumer) {
    this.timeout = timeout;
    this.clientConsumer = clientConsumer;
  }
  
  public void handle(@NotNull Context ctx) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'ctx'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'Accept'
    //   9: invokeinterface header : (Ljava/lang/String;)Ljava/lang/String;
    //   14: ldc 'text/event-stream'
    //   16: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   19: ifeq -> 115
    //   22: aload_1
    //   23: invokeinterface res : ()Ljakarta/servlet/http/HttpServletResponse;
    //   28: astore_2
    //   29: aload_2
    //   30: astore_3
    //   31: iconst_0
    //   32: istore #4
    //   34: aload_3
    //   35: sipush #200
    //   38: invokeinterface setStatus : (I)V
    //   43: aload_3
    //   44: ldc 'UTF-8'
    //   46: invokeinterface setCharacterEncoding : (Ljava/lang/String;)V
    //   51: aload_3
    //   52: ldc 'text/event-stream'
    //   54: invokeinterface setContentType : (Ljava/lang/String;)V
    //   59: aload_3
    //   60: ldc 'Connection'
    //   62: ldc 'close'
    //   64: invokeinterface addHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_3
    //   70: ldc 'Cache-Control'
    //   72: ldc 'no-cache'
    //   74: invokeinterface addHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_3
    //   80: ldc 'X-Accel-Buffering'
    //   82: ldc 'no'
    //   84: invokeinterface addHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_3
    //   90: invokeinterface flushBuffer : ()V
    //   95: nop
    //   96: nop
    //   97: aload_1
    //   98: aload_0
    //   99: getfield timeout : J
    //   102: aconst_null
    //   103: aload_0
    //   104: aload_1
    //   105: <illegal opcode> run : (Lio/javalin/http/sse/SseHandler;Lio/javalin/http/Context;)Lio/javalin/util/function/ThrowingRunnable;
    //   110: iconst_2
    //   111: aconst_null
    //   112: invokestatic async$default : (Lio/javalin/http/Context;JLjava/lang/Runnable;Lio/javalin/util/function/ThrowingRunnable;ILjava/lang/Object;)V
    //   115: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #14	-> 6
    //   #15	-> 22
    //   #16	-> 34
    //   #17	-> 43
    //   #18	-> 51
    //   #19	-> 59
    //   #20	-> 69
    //   #21	-> 79
    //   #22	-> 89
    //   #23	-> 95
    //   #15	-> 96
    //   #24	-> 97
    //   #28	-> 115
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   34	62	4	$i$a$-apply-SseHandler$handle$1	I
    //   31	65	3	$this$handle_u24lambda_u2d0	Ljakarta/servlet/http/HttpServletResponse;
    //   0	116	0	this	Lio/javalin/http/sse/SseHandler;
    //   0	116	1	ctx	Lio/javalin/http/Context;
  }
  
  @JvmOverloads
  public SseHandler(@NotNull Consumer clientConsumer) {
    this(0L, clientConsumer, 1, null);
  }
  
  private static final void handle$lambda-1(SseHandler this$0, Context $ctx) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter($ctx, "$ctx");
    this$0.clientConsumer.accept(new SseClient($ctx));
  }
}
