package io.javalin.config;

import io.javalin.compression.CompressionStrategy;
import io.javalin.http.RequestLogger;
import io.javalin.http.SinglePageHandler;
import io.javalin.http.servlet.DefaultTasks;
import io.javalin.http.servlet.JavalinServletContext;
import io.javalin.http.servlet.TaskInitializer;
import io.javalin.http.staticfiles.ResourceHandler;
import io.javalin.security.AccessManager;
import io.javalin.websocket.WsConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.websocket.server.JettyWebSocketServletFactory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000d\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020%\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\005¢\006\002\020\002R\024\020\003\032\004\030\0010\0048\006@\006X\016¢\006\002\n\000R\036\020\005\032\016\022\004\022\0020\007\022\004\022\0020\0010\0068\006@\006X\016¢\006\002\n\000R\022\020\b\032\0020\t8\006@\006X\016¢\006\002\n\000R\024\020\n\032\004\030\0010\0138\006@\006X\016¢\006\002\n\000R\024\020\f\032\004\030\0010\r8\006@\006X\016¢\006\002\n\000R\024\020\016\032\004\030\0010\0178\006@\006X\016¢\006\002\n\000R\032\020\020\032\n\022\004\022\0020\022\030\0010\0218\006@\006X\016¢\006\002\n\000R\036\020\023\032\016\022\n\022\b\022\004\022\0020\0260\0250\0248\006@\006X\016¢\006\002\n\000R\024\020\027\032\004\030\0010\0308\006@\006X\016¢\006\002\n\000R\022\020\031\032\0020\0328\006@\006X\016¢\006\002\n\000R\032\020\033\032\n\022\004\022\0020\034\030\0010\0218\006@\006X\016¢\006\002\n\000R\024\020\035\032\004\030\0010\0368\006@\006X\016¢\006\002\n\000¨\006\037"}, d2 = {"Lio/javalin/config/PrivateConfig;", "", "()V", "accessManager", "Lio/javalin/security/AccessManager;", "appAttributes", "", "", "compressionStrategy", "Lio/javalin/compression/CompressionStrategy;", "requestLogger", "Lio/javalin/http/RequestLogger;", "resourceHandler", "Lio/javalin/http/staticfiles/ResourceHandler;", "server", "Lorg/eclipse/jetty/server/Server;", "servletContextHandlerConsumer", "Ljava/util/function/Consumer;", "Lorg/eclipse/jetty/servlet/ServletContextHandler;", "servletRequestLifecycle", "", "Lio/javalin/http/servlet/TaskInitializer;", "Lio/javalin/http/servlet/JavalinServletContext;", "sessionHandler", "Lorg/eclipse/jetty/server/session/SessionHandler;", "singlePageHandler", "Lio/javalin/http/SinglePageHandler;", "wsFactoryConfig", "Lorg/eclipse/jetty/websocket/server/JettyWebSocketServletFactory;", "wsLogger", "Lio/javalin/websocket/WsConfig;", "javalin"})
public final class PrivateConfig {
  @JvmField
  @NotNull
  public Map<String, Object> appAttributes = new HashMap<>();
  
  @JvmField
  @Nullable
  public RequestLogger requestLogger;
  
  @JvmField
  @Nullable
  public ResourceHandler resourceHandler;
  
  @JvmField
  @Nullable
  public AccessManager accessManager;
  
  @JvmField
  @NotNull
  public SinglePageHandler singlePageHandler = new SinglePageHandler();
  
  @JvmField
  @Nullable
  public SessionHandler sessionHandler;
  
  @JvmField
  @Nullable
  public Consumer<JettyWebSocketServletFactory> wsFactoryConfig;
  
  @JvmField
  @Nullable
  public WsConfig wsLogger;
  
  @JvmField
  @Nullable
  public Server server;
  
  @JvmField
  @Nullable
  public Consumer<ServletContextHandler> servletContextHandlerConsumer;
  
  @JvmField
  @NotNull
  public CompressionStrategy compressionStrategy = CompressionStrategy.GZIP;
  
  @JvmField
  @NotNull
  public List<? extends TaskInitializer<JavalinServletContext>> servletRequestLifecycle;
  
  public PrivateConfig() {
    TaskInitializer[] arrayOfTaskInitializer = new TaskInitializer[4];
    arrayOfTaskInitializer[0] = DefaultTasks.INSTANCE.getBEFORE();
    arrayOfTaskInitializer[1] = DefaultTasks.INSTANCE.getHTTP();
    arrayOfTaskInitializer[2] = DefaultTasks.INSTANCE.getERROR();
    arrayOfTaskInitializer[3] = DefaultTasks.INSTANCE.getAFTER();
    this.servletRequestLifecycle = CollectionsKt.listOf((Object[])arrayOfTaskInitializer);
  }
}
