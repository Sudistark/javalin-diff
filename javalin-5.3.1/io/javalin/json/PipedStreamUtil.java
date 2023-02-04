package io.javalin.json;

import io.javalin.util.ConcurrencyUtil;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.ExecutorService;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\020\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\t\032\0020\n2\022\020\013\032\016\022\004\022\0020\r\022\004\022\0020\0160\fR\033\020\003\032\0020\0048BX\002¢\006\f\n\004\b\007\020\b\032\004\b\005\020\006¨\006\017"}, d2 = {"Lio/javalin/json/PipedStreamUtil;", "", "()V", "executorService", "Ljava/util/concurrent/ExecutorService;", "getExecutorService", "()Ljava/util/concurrent/ExecutorService;", "executorService$delegate", "Lkotlin/Lazy;", "getInputStream", "Ljava/io/InputStream;", "userCallback", "Lkotlin/Function1;", "Ljava/io/PipedOutputStream;", "", "javalin"})
public final class PipedStreamUtil {
  @NotNull
  public static final PipedStreamUtil INSTANCE = new PipedStreamUtil();
  
  @NotNull
  private static final Lazy executorService$delegate = LazyKt.lazy(PipedStreamUtil$executorService$2.INSTANCE);
  
  private final ExecutorService getExecutorService() {
    Lazy lazy = executorService$delegate;
    return (ExecutorService)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ExecutorService;", "invoke"})
  static final class PipedStreamUtil$executorService$2 extends Lambda implements Function0<ExecutorService> {
    public static final PipedStreamUtil$executorService$2 INSTANCE = new PipedStreamUtil$executorService$2();
    
    PipedStreamUtil$executorService$2() {
      super(0);
    }
    
    @NotNull
    public final ExecutorService invoke() {
      return ConcurrencyUtil.executorService("JavalinPipedStreamingThreadPool");
    }
  }
  
  @NotNull
  public final InputStream getInputStream(@NotNull Function1 userCallback) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'userCallback'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: new java/io/PipedOutputStream
    //   9: dup
    //   10: invokespecial <init> : ()V
    //   13: astore_2
    //   14: new io/javalin/json/PipedStreamUtil$getInputStream$pipedInputStream$1
    //   17: dup
    //   18: aload_2
    //   19: invokespecial <init> : (Ljava/io/PipedOutputStream;)V
    //   22: astore_3
    //   23: aload_0
    //   24: invokespecial getExecutorService : ()Ljava/util/concurrent/ExecutorService;
    //   27: aload_1
    //   28: aload_2
    //   29: aload_3
    //   30: <illegal opcode> run : (Lkotlin/jvm/functions/Function1;Ljava/io/PipedOutputStream;Lio/javalin/json/PipedStreamUtil$getInputStream$pipedInputStream$1;)Ljava/lang/Runnable;
    //   35: invokeinterface execute : (Ljava/lang/Runnable;)V
    //   40: aload_3
    //   41: checkcast java/io/InputStream
    //   44: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #13	-> 6
    //   #14	-> 14
    //   #18	-> 23
    //   #27	-> 40
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   14	31	2	pipedOutputStream	Ljava/io/PipedOutputStream;
    //   23	22	3	pipedInputStream	Lio/javalin/json/PipedStreamUtil$getInputStream$pipedInputStream$1;
    //   0	45	0	this	Lio/javalin/json/PipedStreamUtil;
    //   0	45	1	userCallback	Lkotlin/jvm/functions/Function1;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\035\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000*\001\000\b\n\030\0002\0020\001J\b\020\t\032\0020\nH\026R\"\020\002\032\n\030\0010\003j\004\030\001`\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\b¨\006\013"}, d2 = {"io/javalin/json/PipedStreamUtil$getInputStream$pipedInputStream$1", "Ljava/io/PipedInputStream;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getException", "()Ljava/lang/Exception;", "setException", "(Ljava/lang/Exception;)V", "close", "", "javalin"})
  public static final class PipedStreamUtil$getInputStream$pipedInputStream$1 extends PipedInputStream {
    @Nullable
    private Exception exception;
    
    PipedStreamUtil$getInputStream$pipedInputStream$1(PipedOutputStream $pipedOutputStream) {
      super($pipedOutputStream);
    }
    
    @Nullable
    public final Exception getException() {
      return this.exception;
    }
    
    public final void setException(@Nullable Exception <set-?>) {
      this.exception = <set-?>;
    }
    
    public void close() {
      if (this.exception != null) {
        Exception it = this.exception;
        int $i$a$-let-PipedStreamUtil$getInputStream$pipedInputStream$1$close$1 = 0;
        throw it;
      } 
      super.close();
    }
  }
  
  private static final void getInputStream$lambda-0(Function1 $userCallback, PipedOutputStream $pipedOutputStream, PipedStreamUtil$getInputStream$pipedInputStream$1 $pipedInputStream) {
    Intrinsics.checkNotNullParameter($userCallback, "$userCallback");
    Intrinsics.checkNotNullParameter($pipedOutputStream, "$pipedOutputStream");
    Intrinsics.checkNotNullParameter($pipedInputStream, "$pipedInputStream");
    try {
      $userCallback.invoke($pipedOutputStream);
    } catch (Exception userException) {
      $pipedInputStream.setException(userException);
    } finally {
      $pipedOutputStream.close();
    } 
  }
}
