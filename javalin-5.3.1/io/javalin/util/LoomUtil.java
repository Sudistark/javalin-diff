package io.javalin.util;

import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0006\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\003\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\002\bÀ\002\030\0002\0020\001:\001\023B\007\b\002¢\006\002\020\002J\016\020\007\032\0020\b2\006\020\t\032\0020\nJ\016\020\013\032\0020\f2\006\020\t\032\0020\nJ\016\020\r\032\0020\0042\006\020\016\032\0020\fJ\016\020\017\032\0020\0202\006\020\021\032\0020\022R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006\024"}, d2 = {"Lio/javalin/util/LoomUtil;", "", "()V", "loomAvailable", "", "getLoomAvailable", "()Z", "getExecutorService", "Ljava/util/concurrent/ExecutorService;", "name", "", "getThreadPool", "Lorg/eclipse/jetty/util/thread/ThreadPool;", "isLoomThreadPool", "threadPool", "logIfLoom", "", "server", "Lorg/eclipse/jetty/server/Server;", "LoomThreadPool", "javalin"})
public final class LoomUtil {
  static {
    Object object;
  }
  
  public final boolean getLoomAvailable() {
    return loomAvailable;
  }
  
  static {
    LoomUtil loomUtil = INSTANCE;
    try {
      LoomUtil $this$loomAvailable_u24lambda_u2d0 = loomUtil;
      int $i$a$-runCatching-LoomUtil$loomAvailable$1 = 0;
      Method factoryMethod = Executors.class.getMethod("newVirtualThreadPerTaskExecutor", new Class[0]);
      Intrinsics.checkNotNull(factoryMethod.invoke(Executors.class, new Object[0]), "null cannot be cast to non-null type java.util.concurrent.ExecutorService");
      object = Result.constructor-impl(factoryMethod.invoke(Executors.class, new Object[0]));
    } catch (Throwable throwable) {
      object = Result.constructor-impl(ResultKt.createFailure(throwable));
    } 
    loomAvailable = Result.isSuccess-impl(object);
  }
  
  @NotNull
  public static final LoomUtil INSTANCE = new LoomUtil();
  
  private static final boolean loomAvailable;
  
  @NotNull
  public final ExecutorService getExecutorService(@NotNull String name) {
    Intrinsics.checkNotNullParameter(name, "name");
    if (!loomAvailable) {
      int $i$a$-require-LoomUtil$getExecutorService$1 = 0;
      String str = "Your Java version (" + System.getProperty("java.version") + ") doesn't support Loom";
      throw new IllegalArgumentException(str.toString());
    } 
    Class[] arrayOfClass = new Class[1];
    arrayOfClass[0] = ThreadFactory.class;
    Method factoryMethod = Executors.class.getMethod("newThreadPerTaskExecutor", arrayOfClass);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = new NamedVirtualThreadFactory(name);
    Intrinsics.checkNotNull(factoryMethod.invoke(Executors.class, arrayOfObject), "null cannot be cast to non-null type java.util.concurrent.ExecutorService");
    return (ExecutorService)factoryMethod.invoke(Executors.class, arrayOfObject);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0004\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\002\n\002\020\013\n\002\b\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\026J\b\020\013\032\0020\fH\026J\b\020\r\032\0020\fH\026J\b\020\016\032\0020\017H\026J\b\020\020\032\0020\bH\026R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\021"}, d2 = {"Lio/javalin/util/LoomUtil$LoomThreadPool;", "Lorg/eclipse/jetty/util/thread/ThreadPool;", "name", "", "(Ljava/lang/String;)V", "executorService", "Ljava/util/concurrent/ExecutorService;", "execute", "", "command", "Ljava/lang/Runnable;", "getIdleThreads", "", "getThreads", "isLowOnThreads", "", "join", "javalin"})
  private static final class LoomThreadPool implements ThreadPool {
    @NotNull
    private final ExecutorService executorService;
    
    public LoomThreadPool(@NotNull String name) {
      this.executorService = LoomUtil.INSTANCE.getExecutorService(name);
    }
    
    public void join() {}
    
    public int getThreads() {
      return 1;
    }
    
    public int getIdleThreads() {
      return 1;
    }
    
    public boolean isLowOnThreads() {
      return false;
    }
    
    public void execute(@NotNull Runnable command) {
      Intrinsics.checkNotNullParameter(command, "command");
      this.executorService.submit(command);
    }
  }
  
  @NotNull
  public final ThreadPool getThreadPool(@NotNull String name) {
    Intrinsics.checkNotNullParameter(name, "name");
    return new LoomThreadPool(name);
  }
  
  public final boolean isLoomThreadPool(@NotNull ThreadPool threadPool) {
    Intrinsics.checkNotNullParameter(threadPool, "threadPool");
    return threadPool instanceof LoomThreadPool;
  }
  
  public final void logIfLoom(@NotNull Server server) {
    Intrinsics.checkNotNullParameter(server, "server");
    Intrinsics.checkNotNullExpressionValue(server.getThreadPool(), "server.threadPool");
    if (!isLoomThreadPool(server.getThreadPool()))
      return; 
    JavalinLogger.startup("Your JDK supports Loom. Javalin will prefer Virtual Threads by default. Disable with `ConcurrencyUtil.useLoom = false`.");
  }
}
