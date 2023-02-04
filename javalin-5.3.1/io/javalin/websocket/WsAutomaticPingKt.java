package io.javalin.websocket;

import io.javalin.util.ConcurrencyUtil;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\0004\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\003\n\002\020\t\n\000\n\002\030\002\n\000\n\002\030\002\n\000\032\016\020\r\032\0020\0162\006\020\017\032\0020\b\032(\020\020\032\0020\0162\006\020\017\032\0020\b2\006\020\021\032\0020\0222\006\020\023\032\0020\0242\b\020\025\032\004\030\0010\026\"\033\020\000\032\0020\0018FX\002¢\006\f\n\004\b\004\020\005\032\004\b\002\020\003\"-\020\006\032\024\022\004\022\0020\b\022\n\022\b\022\002\b\003\030\0010\t0\0078FX\002¢\006\f\n\004\b\f\020\005\032\004\b\n\020\013¨\006\027"}, d2 = {"executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "executor$delegate", "Lkotlin/Lazy;", "pingFutures", "Ljava/util/concurrent/ConcurrentHashMap;", "Lio/javalin/websocket/WsContext;", "Ljava/util/concurrent/ScheduledFuture;", "getPingFutures", "()Ljava/util/concurrent/ConcurrentHashMap;", "pingFutures$delegate", "disableAutomaticPings", "", "ctx", "enableAutomaticPings", "interval", "", "unit", "Ljava/util/concurrent/TimeUnit;", "applicationData", "Ljava/nio/ByteBuffer;", "javalin"})
public final class WsAutomaticPingKt {
  @NotNull
  private static final Lazy executor$delegate = LazyKt.lazy(WsAutomaticPingKt$executor$2.INSTANCE);
  
  @NotNull
  public static final ScheduledExecutorService getExecutor() {
    Lazy lazy = executor$delegate;
    return (ScheduledExecutorService)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ScheduledExecutorService;", "invoke"})
  static final class WsAutomaticPingKt$executor$2 extends Lambda implements Function0<ScheduledExecutorService> {
    public static final WsAutomaticPingKt$executor$2 INSTANCE = new WsAutomaticPingKt$executor$2();
    
    WsAutomaticPingKt$executor$2() {
      super(0);
    }
    
    @NotNull
    public final ScheduledExecutorService invoke() {
      return ConcurrencyUtil.newSingleThreadScheduledExecutor("JavalinWebSocketPingThread");
    }
  }
  
  @NotNull
  private static final Lazy pingFutures$delegate = LazyKt.lazy(WsAutomaticPingKt$pingFutures$2.INSTANCE);
  
  @NotNull
  public static final ConcurrentHashMap<WsContext, ScheduledFuture<?>> getPingFutures() {
    Lazy lazy = pingFutures$delegate;
    return (ConcurrentHashMap<WsContext, ScheduledFuture<?>>)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\020\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\020\000\032\024\022\004\022\0020\002\022\n\022\b\022\002\b\003\030\0010\0030\001H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "Ljava/util/concurrent/ConcurrentHashMap;", "Lio/javalin/websocket/WsContext;", "Ljava/util/concurrent/ScheduledFuture;", "invoke"})
  static final class WsAutomaticPingKt$pingFutures$2 extends Lambda implements Function0<ConcurrentHashMap<WsContext, ScheduledFuture<?>>> {
    public static final WsAutomaticPingKt$pingFutures$2 INSTANCE = new WsAutomaticPingKt$pingFutures$2();
    
    WsAutomaticPingKt$pingFutures$2() {
      super(0);
    }
    
    @NotNull
    public final ConcurrentHashMap<WsContext, ScheduledFuture<?>> invoke() {
      return new ConcurrentHashMap<>();
    }
  }
  
  public static final void enableAutomaticPings(@NotNull WsContext ctx, long interval, @NotNull TimeUnit unit, @Nullable ByteBuffer applicationData) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'ctx'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_3
    //   7: ldc 'unit'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: astore #5
    //   15: aload #5
    //   17: monitorenter
    //   18: nop
    //   19: iconst_0
    //   20: istore #6
    //   22: aload_0
    //   23: invokestatic disableAutomaticPings : (Lio/javalin/websocket/WsContext;)V
    //   26: invokestatic getPingFutures : ()Ljava/util/concurrent/ConcurrentHashMap;
    //   29: checkcast java/util/Map
    //   32: aload_0
    //   33: invokestatic getExecutor : ()Ljava/util/concurrent/ScheduledExecutorService;
    //   36: aload_0
    //   37: aload #4
    //   39: <illegal opcode> run : (Lio/javalin/websocket/WsContext;Ljava/nio/ByteBuffer;)Ljava/lang/Runnable;
    //   44: lload_1
    //   45: lload_1
    //   46: aload_3
    //   47: invokeinterface scheduleAtFixedRate : (Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    //   52: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   57: pop
    //   58: nop
    //   59: getstatic kotlin/Unit.INSTANCE : Lkotlin/Unit;
    //   62: astore #6
    //   64: aload #5
    //   66: monitorexit
    //   67: goto -> 78
    //   70: astore #6
    //   72: aload #5
    //   74: monitorexit
    //   75: aload #6
    //   77: athrow
    //   78: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #14	-> 12
    //   #15	-> 22
    //   #16	-> 26
    //   #18	-> 44
    //   #16	-> 47
    //   #19	-> 58
    //   #14	-> 62
    //   #20	-> 78
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   22	37	6	$i$a$-synchronized-WsAutomaticPingKt$enableAutomaticPings$1	I
    //   0	79	0	ctx	Lio/javalin/websocket/WsContext;
    //   0	79	1	interval	J
    //   0	79	3	unit	Ljava/util/concurrent/TimeUnit;
    //   0	79	4	applicationData	Ljava/nio/ByteBuffer;
    // Exception table:
    //   from	to	target	type
    //   18	64	70	finally
    //   70	72	70	finally
  }
  
  private static final void enableAutomaticPings$lambda-1$lambda-0(WsContext $ctx, ByteBuffer $applicationData) {
    Intrinsics.checkNotNullParameter($ctx, "$ctx");
    $ctx.sendPing($applicationData);
  }
  
  public static final void disableAutomaticPings(@NotNull WsContext ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    synchronized (ctx) {
      int $i$a$-synchronized-WsAutomaticPingKt$disableAutomaticPings$1 = 0;
      if ((ScheduledFuture)getPingFutures().get(ctx) != null) {
        ((ScheduledFuture)getPingFutures().get(ctx)).cancel(false);
      } else {
        (ScheduledFuture)getPingFutures().get(ctx);
      } 
      ScheduledFuture scheduledFuture = getPingFutures().remove(ctx);
    } 
  }
}
