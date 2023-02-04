package io.javalin.jetty;

import io.javalin.util.ConcurrencyUtil;
import io.javalin.util.JavalinLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.server.LowResourceMonitor;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.eclipse.jetty.util.thread.ThreadPool;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0004\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\003\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\003\032\0020\004H\002J\022\020\005\032\0020\0062\b\020\007\032\004\030\0010\006H\007J\016\020\b\032\0020\t2\006\020\n\032\0020\013J\016\020\f\032\0020\t2\006\020\n\032\0020\013J\020\020\r\032\0020\0162\006\020\017\032\0020\020H\007¨\006\021"}, d2 = {"Lio/javalin/jetty/JettyUtil;", "", "()V", "defaultThreadPool", "Lorg/eclipse/jetty/util/thread/ThreadPool;", "getOrDefault", "Lorg/eclipse/jetty/server/Server;", "server", "isClientAbortException", "", "t", "", "isJettyTimeoutException", "maybeLogIfServerNotStarted", "", "jettyServer", "Lio/javalin/jetty/JettyServer;", "javalin"})
public final class JettyUtil {
  @NotNull
  public static final JettyUtil INSTANCE = new JettyUtil();
  
  @JvmStatic
  @NotNull
  public static final Server getOrDefault(@Nullable Server server) {
    if (server == null) {
      Server server1 = new Server(INSTANCE.defaultThreadPool()), $this$getOrDefault_u24lambda_u2d0 = server1;
      int $i$a$-apply-JettyUtil$getOrDefault$1 = 0;
      $this$getOrDefault_u24lambda_u2d0.addBean(new LowResourceMonitor($this$getOrDefault_u24lambda_u2d0));
      $this$getOrDefault_u24lambda_u2d0.insertHandler((HandlerWrapper)new StatisticsHandler());
      $this$getOrDefault_u24lambda_u2d0.setAttribute("is-default-server", Boolean.valueOf(true));
    } 
    return server1;
  }
  
  private final ThreadPool defaultThreadPool() {
    return ConcurrencyUtil.jettyThreadPool("JettyServerThreadPool", 8, 250);
  }
  
  @JvmStatic
  public static final void maybeLogIfServerNotStarted(@NotNull JettyServer jettyServer) {
    Intrinsics.checkNotNullParameter(jettyServer, "jettyServer");
    (new Thread(





        
        jettyServer::maybeLogIfServerNotStarted$lambda-1)).start();
  }
  
  private static final void maybeLogIfServerNotStarted$lambda-1(JettyServer $jettyServer) {
    Intrinsics.checkNotNullParameter($jettyServer, "$jettyServer");
    Thread.sleep(5000L);
    if (!$jettyServer.started) {
      JavalinLogger.startup("It looks like you created a Javalin instance, but you never started it.");
      JavalinLogger.startup("Try: Javalin app = Javalin.create().start();");
      JavalinLogger.startup("For more help, visit https://javalin.io/documentation#server-setup");
    } 
  }
  
  public final boolean isClientAbortException(@NotNull Throwable t) {
    Intrinsics.checkNotNullParameter(t, "t");
    return Intrinsics.areEqual(t.getClass().getName(), "org.eclipse.jetty.io.EofException");
  }
  
  public final boolean isJettyTimeoutException(@NotNull Throwable t) {
    Intrinsics.checkNotNullParameter(t, "t");
    return (t instanceof java.io.IOException && t.getCause() instanceof java.util.concurrent.TimeoutException);
  }
}
