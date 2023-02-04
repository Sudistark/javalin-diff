package io.javalin.jetty;

import io.javalin.config.JavalinConfig;
import io.javalin.config.PrivateConfig;
import io.javalin.http.staticfiles.ResourceHandler;
import io.javalin.util.JavalinLogger;
import io.javalin.util.LoomUtil;
import io.javalin.util.Util;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.BindException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.http.HttpCookie;
import org.eclipse.jetty.http.UriCompliance;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.HttpConnectionFactory;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.server.handler.AbstractHandlerContainer;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.websocket.server.JettyWebSocketServerContainer;
import org.eclipse.jetty.websocket.server.config.JettyWebSocketServletContainerInitializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000^\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\004\n\002\020\016\n\002\b\005\n\002\020\b\n\002\b\005\n\002\020\013\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\031\032\0020\0262\006\020\032\032\0020\033H\002J\b\020\034\032\0020\035H\002J\006\020\032\032\0020\033J\016\020\036\032\0020\0372\006\020 \032\0020!J\024\020\"\032\0020#*\0020$2\006\020%\032\0020&H\002J\f\020'\032\0020$*\0020(H\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\034\020\007\032\004\030\0010\bX\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\fR\032\020\r\032\0020\016X\016¢\006\016\n\000\032\004\b\017\020\020\"\004\b\021\020\022R\022\020\023\032\0020\0248\006@\006X\016¢\006\002\n\000R\030\020\025\032\0020\b*\0020\0268BX\004¢\006\006\032\004\b\027\020\030¨\006)"}, d2 = {"Lio/javalin/jetty/JettyServer;", "", "cfg", "Lio/javalin/config/JavalinConfig;", "(Lio/javalin/config/JavalinConfig;)V", "getCfg", "()Lio/javalin/config/JavalinConfig;", "serverHost", "", "getServerHost", "()Ljava/lang/String;", "setServerHost", "(Ljava/lang/String;)V", "serverPort", "", "getServerPort", "()I", "setServerPort", "(I)V", "started", "", "protocol", "Lorg/eclipse/jetty/server/ServerConnector;", "getProtocol", "(Lorg/eclipse/jetty/server/ServerConnector;)Ljava/lang/String;", "defaultConnector", "server", "Lorg/eclipse/jetty/server/Server;", "defaultSessionHandler", "Lorg/eclipse/jetty/server/session/SessionHandler;", "start", "", "wsAndHttpServlet", "Lio/javalin/jetty/JavalinJettyServlet;", "attachHandler", "Lorg/eclipse/jetty/server/handler/AbstractHandlerContainer;", "Lorg/eclipse/jetty/server/Handler;", "servletContextHandler", "Lorg/eclipse/jetty/servlet/ServletContextHandler;", "unwrap", "Lorg/eclipse/jetty/server/handler/HandlerWrapper;", "javalin"})
public final class JettyServer {
  @NotNull
  private final JavalinConfig cfg;
  
  @JvmField
  public boolean started;
  
  private int serverPort;
  
  @Nullable
  private String serverHost;
  
  public JettyServer(@NotNull JavalinConfig cfg) {
    this.cfg = cfg;
    this.serverPort = -1;
  }
  
  @NotNull
  public final JavalinConfig getCfg() {
    return this.cfg;
  }
  
  public final int getServerPort() {
    return this.serverPort;
  }
  
  public final void setServerPort(int <set-?>) {
    this.serverPort = <set-?>;
  }
  
  @Nullable
  public final String getServerHost() {
    return this.serverHost;
  }
  
  public final void setServerHost(@Nullable String <set-?>) {
    this.serverHost = <set-?>;
  }
  
  @NotNull
  public final Server server() {
    if (this.cfg.pvt.server == null);
    ((PrivateConfig)this.cfg.pvt.server).server = JettyUtil.getOrDefault(this.cfg.pvt.server);
    Intrinsics.checkNotNull(this.cfg.pvt.server);
    return this.cfg.pvt.server;
  }
  
  public final void start(@NotNull JavalinJettyServlet wsAndHttpServlet) throws BindException {
    Intrinsics.checkNotNullParameter(wsAndHttpServlet, "wsAndHttpServlet");
    if (this.serverPort == -1 && this.cfg.pvt.server == null) {
      this.serverPort = 8080;
      JavalinLogger.startup("No port specified, starting on port " + this.serverPort + ". Call start(port) to change ports.");
    } 
    if (this.cfg.pvt.sessionHandler == null);
    ((PrivateConfig)this.cfg.pvt.sessionHandler).sessionHandler = defaultSessionHandler();
    Void nullParent = null;
    String str = Util.normalizeContextPath(this.cfg.routing.contextPath);
    JettyServer$start$wsAndHttpHandler$1 jettyServer$start$wsAndHttpHandler$11 = new JettyServer$start$wsAndHttpHandler$1(nullParent, str);
    JettyServer$start$wsAndHttpHandler$1 $this$start_u24lambda_u2d1 = jettyServer$start$wsAndHttpHandler$11;
    int $i$a$-apply-JettyServer$start$wsAndHttpHandler$2 = 0;
    $this$start_u24lambda_u2d1.setSessionHandler(this.cfg.pvt.sessionHandler);
    if (this.cfg.pvt.servletContextHandlerConsumer != null) {
      this.cfg.pvt.servletContextHandlerConsumer.accept($this$start_u24lambda_u2d1);
    } else {
    
    } 
    $this$start_u24lambda_u2d1.addServlet(new ServletHolder((Servlet)wsAndHttpServlet), "/*");
    JettyWebSocketServletContainerInitializer.configure($this$start_u24lambda_u2d1, JettyServer::start$lambda-1$lambda-0);
    JettyServer$start$wsAndHttpHandler$1 wsAndHttpHandler = jettyServer$start$wsAndHttpHandler$11;
    Server server1 = server(), $this$start_u24lambda_u2d2 = server1;
    int $i$a$-apply-JettyServer$start$1 = 0;
    Intrinsics.checkNotNullExpressionValue($this$start_u24lambda_u2d2.getHandler(), "handler");
    $this$start_u24lambda_u2d2.setHandler(($this$start_u24lambda_u2d2.getHandler() == null) ? (Handler)wsAndHttpHandler : (Handler)attachHandler($this$start_u24lambda_u2d2.getHandler(), wsAndHttpHandler));
    Intrinsics.checkNotNullExpressionValue($this$start_u24lambda_u2d2.getConnectors(), "connectors");
    if ((((Object[])$this$start_u24lambda_u2d2.getConnectors()).length == 0)) {
      ServerConnector[] arrayOfServerConnector = new ServerConnector[1];
      arrayOfServerConnector[0] = defaultConnector($this$start_u24lambda_u2d2);
      $this$start_u24lambda_u2d2.setConnectors((Connector[])arrayOfServerConnector);
    } 
    server1.start();
    Util.logJavalinBanner(this.cfg.showJavalinBanner);
    LoomUtil.INSTANCE.logIfLoom(server());
    ResourceHandler resourceHandler = this.cfg.pvt.resourceHandler;
    if (((resourceHandler instanceof JettyResourceHandler) ? resourceHandler : null) != null) {
      ((resourceHandler instanceof JettyResourceHandler) ? resourceHandler : null).init();
    } else {
      (resourceHandler instanceof JettyResourceHandler) ? resourceHandler : null;
    } 
    Intrinsics.checkNotNullExpressionValue(server().getConnectors(), "server().connectors");
    Object[] $this$filterIsInstance$iv = (Object[])server().getConnectors();
    int $i$f$filterIsInstance = 0;
    Object[] arrayOfObject2 = $this$filterIsInstance$iv;
    Collection<Object> collection1 = new ArrayList();
    int $i$f$filterIsInstanceTo = 0;
    byte b;
    int j;
    for (b = 0, j = arrayOfObject2.length; b < j; ) {
      Object element$iv$iv = arrayOfObject2[b];
      if (element$iv$iv instanceof ServerConnector)
        collection1.add(element$iv$iv); 
      b++;
    } 
    List list = (List)collection1;
    int i = 0;
    Iterator iterator2 = list.iterator();
    if (iterator2.hasNext()) {
      Object element$iv = iterator2.next();
      ServerConnector it = (ServerConnector)element$iv;
      int $i$a$-forEach-JettyServer$start$2 = 0;
      String str1 = it.getHost();
      Intrinsics.checkNotNullExpressionValue(str1, "it.host ?: \"localhost\"");
    } 
    Intrinsics.checkNotNullExpressionValue(server().getConnectors(), "server().connectors");
    Object[] $this$filter$iv = (Object[])server().getConnectors();
    int $i$f$filter = 0;
    Object[] arrayOfObject1 = $this$filter$iv;
    Collection<Object> destination$iv$iv = new ArrayList();
    int $i$f$filterTo = 0;
    for (b = 0, j = arrayOfObject1.length; b < j; ) {
      Object element$iv$iv = arrayOfObject1[b];
      Connector it = (Connector)element$iv$iv;
      int $i$a$-filter-JettyServer$start$3 = 0;
      if (!(it instanceof ServerConnector))
        destination$iv$iv.add(element$iv$iv); 
    } 
    Iterable $this$forEach$iv = destination$iv$iv;
    int $i$f$forEach = 0;
    Iterator iterator1 = $this$forEach$iv.iterator();
    if (iterator1.hasNext()) {
      Object element$iv = iterator1.next();
      Connector it = (Connector)element$iv;
      int $i$a$-forEach-JettyServer$start$4 = 0;
      JavalinLogger.startup("Binding to: " + it);
    } 
    Connector connector = server().getConnectors()[0];
    (connector instanceof ServerConnector) ? connector : null;
    this.serverPort = (((connector instanceof ServerConnector) ? connector : null) != null) ? ((connector instanceof ServerConnector) ? connector : null).getLocalPort() : -1;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000)\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000*\001\000\b\n\030\0002\0020\001J(\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\t2\006\020\n\032\0020\013H\026¨\006\f"}, d2 = {"io/javalin/jetty/JettyServer$start$wsAndHttpHandler$1", "Lorg/eclipse/jetty/servlet/ServletContextHandler;", "doHandle", "", "target", "", "jettyRequest", "Lorg/eclipse/jetty/server/Request;", "request", "Ljakarta/servlet/http/HttpServletRequest;", "response", "Ljakarta/servlet/http/HttpServletResponse;", "javalin"})
  public static final class JettyServer$start$wsAndHttpHandler$1 extends ServletContextHandler {
    JettyServer$start$wsAndHttpHandler$1(Void $nullParent, String $super_call_param$1) {
      super((HandlerContainer)$nullParent, $super_call_param$1, 1);
    }
    
    public void doHandle(@NotNull String target, @NotNull Request jettyRequest, @NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
      Intrinsics.checkNotNullParameter(target, "target");
      Intrinsics.checkNotNullParameter(jettyRequest, "jettyRequest");
      Intrinsics.checkNotNullParameter(request, "request");
      Intrinsics.checkNotNullParameter(response, "response");
      request.setAttribute("jetty-target-and-request", new Pair(target, jettyRequest));
      nextHandle(target, jettyRequest, request, response);
    }
  }
  
  private static final void start$lambda-1$lambda-0(ServletContext paramServletContext, JettyWebSocketServerContainer paramJettyWebSocketServerContainer) {}
  
  private final ServerConnector defaultConnector(Server server) {
    HttpConfiguration httpConfiguration = new HttpConfiguration();
    httpConfiguration.setUriCompliance(UriCompliance.RFC3986);
    ConnectionFactory[] arrayOfConnectionFactory = new ConnectionFactory[1];
    arrayOfConnectionFactory[0] = (ConnectionFactory)new HttpConnectionFactory(httpConfiguration);
    ServerConnector serverConnector1 = new ServerConnector(server, arrayOfConnectionFactory), $this$defaultConnector_u24lambda_u2d7 = serverConnector1;
    int $i$a$-apply-JettyServer$defaultConnector$1 = 0;
    $this$defaultConnector_u24lambda_u2d7.setPort(this.serverPort);
    $this$defaultConnector_u24lambda_u2d7.setHost(this.serverHost);
    Intrinsics.checkNotNullExpressionValue($this$defaultConnector_u24lambda_u2d7.getConnectionFactories(), "this.connectionFactories");
    Iterable $this$forEach$iv = $this$defaultConnector_u24lambda_u2d7.getConnectionFactories();
    int $i$f$forEach = 0;
    Iterator iterator = $this$forEach$iv.iterator();
    if (iterator.hasNext()) {
      Object element$iv = iterator.next();
      ConnectionFactory it = (ConnectionFactory)element$iv;
      int $i$a$-forEach-JettyServer$defaultConnector$1$1 = 0;
      if (it instanceof HttpConnectionFactory)
        ((HttpConnectionFactory)it).getHttpConfiguration().setSendServerVersion(false); 
    } 
    return serverConnector1;
  }
  
  private final SessionHandler defaultSessionHandler() {
    SessionHandler sessionHandler1 = new SessionHandler(), $this$defaultSessionHandler_u24lambda_u2d8 = sessionHandler1;
    int $i$a$-apply-JettyServer$defaultSessionHandler$1 = 0;
    $this$defaultSessionHandler_u24lambda_u2d8.setHttpOnly(true);
    $this$defaultSessionHandler_u24lambda_u2d8.setSameSite(HttpCookie.SameSite.LAX);
    return sessionHandler1;
  }
  
  private final String getProtocol(ServerConnector $this$protocol) {
    return $this$protocol.getProtocols().contains("ssl") ? "https" : "http";
  }
  
  private final AbstractHandlerContainer attachHandler(Handler $this$attachHandler, ServletContextHandler servletContextHandler) {
    Handler handler1 = $this$attachHandler;
    Handler handler2 = $this$attachHandler;
    HandlerCollection $this$attachHandler_u24lambda_u2d9 = (HandlerCollection)handler2;
    int $i$a$-apply-JettyServer$attachHandler$1 = 0;
    $this$attachHandler_u24lambda_u2d9.addHandler((Handler)servletContextHandler);
    if (handler1 instanceof HandlerWrapper) {
      handler2 = $this$attachHandler;
      HandlerWrapper $this$attachHandler_u24lambda_u2d10 = (HandlerWrapper)handler2;
      int $i$a$-apply-JettyServer$attachHandler$2 = 0;
      Handler handler = unwrap($this$attachHandler_u24lambda_u2d10);
      if (((handler instanceof HandlerCollection) ? handler : null) != null) {
        ((handler instanceof HandlerCollection) ? handler : null).addHandler((Handler)servletContextHandler);
      } else {
        (handler instanceof HandlerCollection) ? handler : null;
      } 
      handler = unwrap($this$attachHandler_u24lambda_u2d10);
      if (((handler instanceof HandlerWrapper) ? handler : null) == null) {
        (handler instanceof HandlerWrapper) ? handler : null;
      } else {
        ((handler instanceof HandlerWrapper) ? handler : null).setHandler((Handler)servletContextHandler);
      } 
    } else {
      throw new IllegalStateException("Server has unsupported Handler attached to it (must be HandlerCollection or HandlerWrapper)");
    } 
    return (handler1 instanceof HandlerCollection) ? (AbstractHandlerContainer)handler2 : (AbstractHandlerContainer)"JD-Core does not support Kotlin";
  }
  
  private final Handler unwrap(HandlerWrapper $this$unwrap) {
    Handler handler = $this$unwrap.getHandler();
    Intrinsics.checkNotNullExpressionValue($this$unwrap.getHandler(), "this.handler");
    if (handler instanceof HandlerWrapper) {
      Intrinsics.checkNotNull($this$unwrap.getHandler(), "null cannot be cast to non-null type org.eclipse.jetty.server.handler.HandlerWrapper");
    } else {
      throw new IllegalStateException("HandlerWrapper has unsupported Handler type (must be HandlerCollection or HandlerWrapper");
    } 
    return (handler == null) ? (Handler)$this$unwrap : ((handler instanceof HandlerCollection) ? $this$unwrap.getHandler() : (Handler)"JD-Core does not support Kotlin");
  }
}
