package io.javalin.config;

import java.util.function.Consumer;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.server.JettyWebSocketServletFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000@\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\024\020\007\032\0020\b2\f\020\t\032\b\022\004\022\0020\0130\nJ\026\020\f\032\0020\b2\016\020\f\032\n\022\006\022\004\030\0010\0160\rJ\024\020\017\032\0020\b2\f\020\020\032\b\022\004\022\0020\0210\rJ\024\020\022\032\0020\b2\f\020\022\032\b\022\004\022\0020\0230\nR\020\020\005\032\0020\0068\006X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\024"}, d2 = {"Lio/javalin/config/JettyConfig;", "", "pvt", "Lio/javalin/config/PrivateConfig;", "(Lio/javalin/config/PrivateConfig;)V", "multipartConfig", "Lio/javalin/config/MultipartConfig;", "contextHandlerConfig", "", "consumer", "Ljava/util/function/Consumer;", "Lorg/eclipse/jetty/servlet/ServletContextHandler;", "server", "Ljava/util/function/Supplier;", "Lorg/eclipse/jetty/server/Server;", "sessionHandler", "sessionHandlerSupplier", "Lorg/eclipse/jetty/server/session/SessionHandler;", "wsFactoryConfig", "Lorg/eclipse/jetty/websocket/server/JettyWebSocketServletFactory;", "javalin"})
public final class JettyConfig {
  @NotNull
  private final PrivateConfig pvt;
  
  @JvmField
  @NotNull
  public final MultipartConfig multipartConfig;
  
  public JettyConfig(@NotNull PrivateConfig pvt) {
    this.pvt = pvt;
    this.multipartConfig = new MultipartConfig();
  }
  
  public final void server(@NotNull Supplier<Server> server) {
    Intrinsics.checkNotNullParameter(server, "server");
    this.pvt.server = server.get();
  }
  
  public final void contextHandlerConfig(@NotNull Consumer<ServletContextHandler> consumer) {
    Intrinsics.checkNotNullParameter(consumer, "consumer");
    this.pvt.servletContextHandlerConsumer = consumer;
  }
  
  public final void sessionHandler(@NotNull Supplier<SessionHandler> sessionHandlerSupplier) {
    Intrinsics.checkNotNullParameter(sessionHandlerSupplier, "sessionHandlerSupplier");
    this.pvt.sessionHandler = sessionHandlerSupplier.get();
  }
  
  public final void wsFactoryConfig(@NotNull Consumer<JettyWebSocketServletFactory> wsFactoryConfig) {
    Intrinsics.checkNotNullParameter(wsFactoryConfig, "wsFactoryConfig");
    this.pvt.wsFactoryConfig = wsFactoryConfig;
  }
}
