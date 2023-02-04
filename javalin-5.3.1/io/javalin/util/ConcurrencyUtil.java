package io.javalin.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0006\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\006\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\n\032\0020\0132\006\020\f\032\0020\rH\007J\b\020\016\032\0020\004H\007J \020\017\032\0020\0202\006\020\f\032\0020\r2\006\020\021\032\0020\0222\006\020\023\032\0020\022H\007J\020\020\024\032\0020\0252\006\020\f\032\0020\rH\007R \020\003\032\0020\004X\016¢\006\024\n\000\022\004\b\005\020\002\032\004\b\006\020\007\"\004\b\b\020\t¨\006\026"}, d2 = {"Lio/javalin/util/ConcurrencyUtil;", "", "()V", "useLoom", "", "getUseLoom$annotations", "getUseLoom", "()Z", "setUseLoom", "(Z)V", "executorService", "Ljava/util/concurrent/ExecutorService;", "name", "", "isLoomAvailable", "jettyThreadPool", "Lorg/eclipse/jetty/util/thread/ThreadPool;", "minThreads", "", "maxThreads", "newSingleThreadScheduledExecutor", "Ljava/util/concurrent/ScheduledExecutorService;", "javalin"})
public final class ConcurrencyUtil {
  @NotNull
  public static final ConcurrencyUtil INSTANCE = new ConcurrencyUtil();
  
  private static boolean useLoom = true;
  
  public final boolean getUseLoom() {
    return useLoom;
  }
  
  public final void setUseLoom(boolean <set-?>) {
    useLoom = <set-?>;
  }
  
  @JvmStatic
  @NotNull
  public static final ExecutorService executorService(@NotNull String name) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'name'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: getstatic io/javalin/util/ConcurrencyUtil.INSTANCE : Lio/javalin/util/ConcurrencyUtil;
    //   9: pop
    //   10: getstatic io/javalin/util/ConcurrencyUtil.useLoom : Z
    //   13: ifeq -> 30
    //   16: getstatic io/javalin/util/ConcurrencyUtil.INSTANCE : Lio/javalin/util/ConcurrencyUtil;
    //   19: pop
    //   20: invokestatic isLoomAvailable : ()Z
    //   23: ifeq -> 30
    //   26: iconst_1
    //   27: goto -> 31
    //   30: iconst_0
    //   31: istore_1
    //   32: iload_1
    //   33: iconst_1
    //   34: if_icmpne -> 47
    //   37: getstatic io/javalin/util/LoomUtil.INSTANCE : Lio/javalin/util/LoomUtil;
    //   40: aload_0
    //   41: invokevirtual getExecutorService : (Ljava/lang/String;)Ljava/util/concurrent/ExecutorService;
    //   44: goto -> 82
    //   47: iload_1
    //   48: ifne -> 74
    //   51: new io/javalin/util/NamedThreadFactory
    //   54: dup
    //   55: aload_0
    //   56: invokespecial <init> : (Ljava/lang/String;)V
    //   59: checkcast java/util/concurrent/ThreadFactory
    //   62: invokestatic newCachedThreadPool : (Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ExecutorService;
    //   65: dup
    //   66: ldc 'newCachedThreadPool(NamedThreadFactory(name))'
    //   68: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   71: goto -> 82
    //   74: new kotlin/NoWhenBranchMatchedException
    //   77: dup
    //   78: invokespecial <init> : ()V
    //   81: athrow
    //   82: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #22	-> 6
    //   #23	-> 32
    //   #24	-> 47
    //   #25	-> 82
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	83	0	name	Ljava/lang/String;
  }
  
  @JvmStatic
  @NotNull
  public static final ScheduledExecutorService newSingleThreadScheduledExecutor(@NotNull String name) {
    Intrinsics.checkNotNullParameter(name, "name");
    Intrinsics.checkNotNullExpressionValue(Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory(name)), "newSingleThreadScheduled…NamedThreadFactory(name))");
    return Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory(name));
  }
  
  @JvmStatic
  @NotNull
  public static final ThreadPool jettyThreadPool(@NotNull String name, int minThreads, int maxThreads) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'name'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: getstatic io/javalin/util/ConcurrencyUtil.INSTANCE : Lio/javalin/util/ConcurrencyUtil;
    //   9: pop
    //   10: getstatic io/javalin/util/ConcurrencyUtil.useLoom : Z
    //   13: ifeq -> 30
    //   16: getstatic io/javalin/util/ConcurrencyUtil.INSTANCE : Lio/javalin/util/ConcurrencyUtil;
    //   19: pop
    //   20: invokestatic isLoomAvailable : ()Z
    //   23: ifeq -> 30
    //   26: iconst_1
    //   27: goto -> 31
    //   30: iconst_0
    //   31: istore_3
    //   32: iload_3
    //   33: iconst_1
    //   34: if_icmpne -> 47
    //   37: getstatic io/javalin/util/LoomUtil.INSTANCE : Lio/javalin/util/LoomUtil;
    //   40: aload_0
    //   41: invokevirtual getThreadPool : (Ljava/lang/String;)Lorg/eclipse/jetty/util/thread/ThreadPool;
    //   44: goto -> 93
    //   47: iload_3
    //   48: ifne -> 85
    //   51: new org/eclipse/jetty/util/thread/QueuedThreadPool
    //   54: dup
    //   55: iload_2
    //   56: iload_1
    //   57: ldc 60000
    //   59: invokespecial <init> : (III)V
    //   62: astore #4
    //   64: aload #4
    //   66: astore #5
    //   68: iconst_0
    //   69: istore #6
    //   71: aload #5
    //   73: aload_0
    //   74: invokevirtual setName : (Ljava/lang/String;)V
    //   77: aload #4
    //   79: checkcast org/eclipse/jetty/util/thread/ThreadPool
    //   82: goto -> 93
    //   85: new kotlin/NoWhenBranchMatchedException
    //   88: dup
    //   89: invokespecial <init> : ()V
    //   92: athrow
    //   93: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #32	-> 6
    //   #33	-> 32
    //   #34	-> 47
    //   #121	-> 68
    //   #34	-> 71
    //   #34	-> 77
    //   #35	-> 93
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   71	6	6	$i$a$-apply-ConcurrencyUtil$jettyThreadPool$1	I
    //   68	9	5	$this$jettyThreadPool_u24lambda_u2d0	Lorg/eclipse/jetty/util/thread/QueuedThreadPool;
    //   0	94	0	name	Ljava/lang/String;
    //   0	94	1	minThreads	I
    //   0	94	2	maxThreads	I
  }
  
  @JvmStatic
  public static final boolean isLoomAvailable() {
    return LoomUtil.INSTANCE.getLoomAvailable();
  }
}
