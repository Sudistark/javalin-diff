package io.javalin.jetty;

import io.javalin.config.PrivateConfig;
import io.javalin.http.staticfiles.ResourceHandler;
import io.javalin.http.staticfiles.StaticFileConfig;
import io.javalin.util.JavalinLogger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.resource.Resource;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000V\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\003\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\f\032\0020\r2\006\020\016\032\0020\tH\026J \020\017\032\n \021*\004\030\0010\0200\0202\006\020\022\032\0020\0232\006\020\024\032\0020\025H\002J\030\020\026\032\0020\r2\006\020\027\032\0020\0302\006\020\031\032\0020\032H\026J\006\020\033\032\0020\034J\036\020\035\032\0020\r*\004\030\0010\0202\006\020\022\032\0020\0232\006\020\024\032\0020\025H\002J\016\020\036\032\0020\r*\004\030\0010\020H\002R\024\020\005\032\b\022\004\022\0020\0070\006X\004¢\006\002\n\000R\024\020\b\032\b\022\004\022\0020\t0\006X\004¢\006\002\n\000R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\n\020\013¨\006\037"}, d2 = {"Lio/javalin/jetty/JettyResourceHandler;", "Lio/javalin/http/staticfiles/ResourceHandler;", "pvt", "Lio/javalin/config/PrivateConfig;", "(Lio/javalin/config/PrivateConfig;)V", "handlers", "", "Lio/javalin/jetty/ConfigurableHandler;", "lateInitConfigs", "Lio/javalin/http/staticfiles/StaticFileConfig;", "getPvt", "()Lio/javalin/config/PrivateConfig;", "addStaticFileConfig", "", "config", "getWelcomeFile", "Lorg/eclipse/jetty/util/resource/Resource;", "kotlin.jvm.PlatformType", "handler", "Lorg/eclipse/jetty/server/handler/ResourceHandler;", "target", "", "handle", "httpRequest", "Ljakarta/servlet/http/HttpServletRequest;", "httpResponse", "Ljakarta/servlet/http/HttpServletResponse;", "init", "", "isDirectoryWithWelcomeFile", "isFile", "javalin"})
public final class JettyResourceHandler implements ResourceHandler {
  @NotNull
  private final PrivateConfig pvt;
  
  @NotNull
  private final List<StaticFileConfig> lateInitConfigs;
  
  @NotNull
  private final List<ConfigurableHandler> handlers;
  
  public JettyResourceHandler(@NotNull PrivateConfig pvt) {
    this.pvt = pvt;
    this.lateInitConfigs = new ArrayList<>();
    this.handlers = new ArrayList<>();
  }
  
  @NotNull
  public final PrivateConfig getPvt() {
    return this.pvt;
  }
  
  public final void init() {
    List<StaticFileConfig> list1 = this.lateInitConfigs;
    List<ConfigurableHandler> list = this.handlers;
    int $i$f$map = 0;
    List<StaticFileConfig> list2 = list1;
    Collection<ConfigurableHandler> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(list1, 10));
    int $i$f$mapTo = 0;
    for (StaticFileConfig item$iv$iv : list2) {
      StaticFileConfig staticFileConfig1 = item$iv$iv;
      Collection<ConfigurableHandler> collection = destination$iv$iv;
      int $i$a$-map-JettyResourceHandler$init$1 = 0;
      Intrinsics.checkNotNull(this.pvt.server);
      collection.add(new ConfigurableHandler(staticFileConfig1, this.pvt.server));
    } 
    list.addAll(destination$iv$iv);
  }
  
  public boolean addStaticFileConfig(@NotNull StaticFileConfig config) {
    Intrinsics.checkNotNullParameter(config, "config");
    Intrinsics.checkNotNull(this.pvt.server);
    return ((this.pvt.server != null) ? ((this.pvt.server.isStarted() == true)) : false) ? this.handlers.add(new ConfigurableHandler(config, this.pvt.server)) : this.lateInitConfigs.add(config);
  }
  
  public boolean handle(@NotNull HttpServletRequest httpRequest, @NotNull HttpServletResponse httpResponse) {
    Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
    Intrinsics.checkNotNullParameter(httpResponse, "httpResponse");
    Intrinsics.checkNotNull(httpRequest.getAttribute("jetty-target-and-request"), "null cannot be cast to non-null type kotlin.Pair<kotlin.String, org.eclipse.jetty.server.Request>");
    Pair pair = (Pair)httpRequest.getAttribute("jetty-target-and-request");
    String target = (String)pair.component1();
    Request baseRequest = (Request)pair.component2();
    Iterable<ConfigurableHandler> $this$filter$iv = this.handlers;
    int $i$f$filter = 0;
    Iterable<ConfigurableHandler> iterable1 = $this$filter$iv;
    Collection<Object> destination$iv$iv = new ArrayList();
    int $i$f$filterTo = 0;
    for (ConfigurableHandler element$iv$iv : iterable1) {
      ConfigurableHandler it = element$iv$iv;
      int $i$a$-filter-JettyResourceHandler$handle$1 = 0;
      if (!((Boolean)(it.getConfig()).skipFileFunction.invoke(httpRequest)).booleanValue())
        destination$iv$iv.add(element$iv$iv); 
    } 
    $this$filter$iv = destination$iv$iv;
    int $i$f$forEach = 0;
    Iterator<ConfigurableHandler> iterator = $this$filter$iv.iterator();
    if (iterator.hasNext()) {
      Object element$iv = iterator.next();
      ConfigurableHandler handler = (ConfigurableHandler)element$iv;
      int $i$a$-forEach-JettyResourceHandler$handle$2 = 0;
      try {
        Resource resource = handler.getResource(target);
        if (isFile(resource) || isDirectoryWithWelcomeFile(resource, handler, target)) {
          Object object;
          Map<String, String> $this$forEach$iv = (handler.getConfig()).headers;
          int i = 0;
          for (Iterator<Map.Entry> iterator1 = $this$forEach$iv.entrySet().iterator(); iterator1.hasNext(); httpResponse.setHeader((String)it.getKey(), (String)it.getValue())) {
            Map.Entry entry1 = iterator1.next(), it = entry1;
            int $i$a$-forEach-JettyResourceHandler$handle$2$1 = 0;
          } 
          if ((handler.getConfig()).precompress) {
            Intrinsics.checkNotNullExpressionValue(getWelcomeFile(handler, target), "getWelcomeFile(handler, target)");
            return isDirectoryWithWelcomeFile(resource, handler, target) ? JettyPrecompressingResourceHandler.INSTANCE.handle(target, getWelcomeFile(handler, target), httpRequest, httpResponse) : JettyPrecompressingResourceHandler.INSTANCE.handle(target, resource, httpRequest, httpResponse);
          } 
          httpResponse.setContentType(null);
          JettyResourceHandler jettyResourceHandler = this;
          try {
            JettyResourceHandler $this$handle_u24lambda_u2d4_u24lambda_u2d3 = jettyResourceHandler;
            int $i$a$-runCatching-JettyResourceHandler$handle$2$2 = 0;
            handler.handle(target, baseRequest, httpRequest, httpResponse);
            object = Result.constructor-impl(Unit.INSTANCE);
          } catch (Throwable throwable) {
            object = Result.constructor-impl(ResultKt.createFailure(throwable));
          } 
          return Result.isSuccess-impl(object);
        } 
      } catch (Exception e) {
        if (!JettyUtil.INSTANCE.isClientAbortException(e))
          JavalinLogger.info("Exception occurred while handling static resource", e); 
      } 
    } 
    return false;
  }
  
  private final boolean isFile(Resource $this$isFile) {
    return ($this$isFile != null && $this$isFile.exists() && !$this$isFile.isDirectory());
  }
  
  private final Resource getWelcomeFile(ResourceHandler handler, String target) {
    return handler.getResource(StringsKt.removeSuffix(target, "/") + "/index.html");
  }
  
  private final boolean isDirectoryWithWelcomeFile(Resource $this$isDirectoryWithWelcomeFile, ResourceHandler handler, String target) {
    if ($this$isDirectoryWithWelcomeFile != null && $this$isDirectoryWithWelcomeFile.isDirectory()) {
      getWelcomeFile(handler, target);
      if ((getWelcomeFile(handler, target) != null) ? ((getWelcomeFile(handler, target).exists() == true)) : false);
    } 
    return false;
  }
}
