package io.javalin.routing;

import io.javalin.config.RoutingConfig;
import io.javalin.http.Handler;
import io.javalin.http.HandlerType;
import io.javalin.http.servlet.JavalinServletContext;
import io.javalin.security.RouteRole;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000Z\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\"\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\r\n\002\020\013\n\002\b\002\n\002\020$\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\003\b\b\030\0002\0020\001B3\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\f\020\b\032\b\022\004\022\0020\n0\t\022\006\020\013\032\0020\f¢\006\002\020\rJ\t\020\032\032\0020\003HÆ\003J\t\020\033\032\0020\005HÆ\003J\t\020\034\032\0020\007HÆ\003J\017\020\035\032\b\022\004\022\0020\n0\tHÆ\003J\t\020\036\032\0020\fHÆ\003JA\020\037\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0052\b\b\002\020\006\032\0020\0072\016\b\002\020\b\032\b\022\004\022\0020\n0\t2\b\b\002\020\013\032\0020\fHÆ\001J\023\020 \032\0020!2\b\020\"\032\004\030\0010\001HÖ\003J\032\020#\032\016\022\004\022\0020\005\022\004\022\0020\0050$2\006\020%\032\0020\005J\026\020&\032\0020'2\006\020(\032\0020)2\006\020%\032\0020\005J\t\020*\032\0020+HÖ\001J\016\020,\032\0020!2\006\020%\032\0020\005J\t\020-\032\0020\005HÖ\001R\021\020\013\032\0020\f¢\006\b\n\000\032\004\b\016\020\017R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\020\020\021R\016\020\022\032\0020\023X\004¢\006\002\n\000R\027\020\b\032\b\022\004\022\0020\n0\t¢\006\b\n\000\032\004\b\024\020\025R\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\026\020\027R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\030\020\031¨\006."}, d2 = {"Lio/javalin/routing/HandlerEntry;", "", "type", "Lio/javalin/http/HandlerType;", "path", "", "routingConfig", "Lio/javalin/config/RoutingConfig;", "roles", "", "Lio/javalin/security/RouteRole;", "handler", "Lio/javalin/http/Handler;", "(Lio/javalin/http/HandlerType;Ljava/lang/String;Lio/javalin/config/RoutingConfig;Ljava/util/Set;Lio/javalin/http/Handler;)V", "getHandler", "()Lio/javalin/http/Handler;", "getPath", "()Ljava/lang/String;", "pathParser", "Lio/javalin/routing/PathParser;", "getRoles", "()Ljava/util/Set;", "getRoutingConfig", "()Lio/javalin/config/RoutingConfig;", "getType", "()Lio/javalin/http/HandlerType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "extractPathParams", "", "requestUri", "handle", "", "ctx", "Lio/javalin/http/servlet/JavalinServletContext;", "hashCode", "", "matches", "toString", "javalin"})
public final class HandlerEntry {
  @NotNull
  private final HandlerType type;
  
  @NotNull
  private final String path;
  
  @NotNull
  private final RoutingConfig routingConfig;
  
  @NotNull
  private final Set<RouteRole> roles;
  
  @NotNull
  private final Handler handler;
  
  @NotNull
  private final PathParser pathParser;
  
  public HandlerEntry(@NotNull HandlerType type, @NotNull String path, @NotNull RoutingConfig routingConfig, @NotNull Set<RouteRole> roles, @NotNull Handler handler) {
    this.type = type;
    this.path = path;
    this.routingConfig = routingConfig;
    this.roles = roles;
    this.handler = handler;
    this.pathParser = new PathParser(this.path, this.routingConfig);
  }
  
  @NotNull
  public final HandlerType getType() {
    return this.type;
  }
  
  @NotNull
  public final String getPath() {
    return this.path;
  }
  
  @NotNull
  public final RoutingConfig getRoutingConfig() {
    return this.routingConfig;
  }
  
  @NotNull
  public final Set<RouteRole> getRoles() {
    return this.roles;
  }
  
  @NotNull
  public final Handler getHandler() {
    return this.handler;
  }
  
  public final boolean matches(@NotNull String requestUri) {
    Intrinsics.checkNotNullParameter(requestUri, "requestUri");
    return this.pathParser.matches(requestUri);
  }
  
  @NotNull
  public final Map<String, String> extractPathParams(@NotNull String requestUri) {
    Intrinsics.checkNotNullParameter(requestUri, "requestUri");
    return this.pathParser.extractPathParams(requestUri);
  }
  
  public final void handle(@NotNull JavalinServletContext ctx, @NotNull String requestUri) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    Intrinsics.checkNotNullParameter(requestUri, "requestUri");
    this.handler.handle(ctx.update(this, requestUri));
  }
  
  @NotNull
  public final HandlerType component1() {
    return this.type;
  }
  
  @NotNull
  public final String component2() {
    return this.path;
  }
  
  @NotNull
  public final RoutingConfig component3() {
    return this.routingConfig;
  }
  
  @NotNull
  public final Set<RouteRole> component4() {
    return this.roles;
  }
  
  @NotNull
  public final Handler component5() {
    return this.handler;
  }
  
  @NotNull
  public final HandlerEntry copy(@NotNull HandlerType type, @NotNull String path, @NotNull RoutingConfig routingConfig, @NotNull Set<? extends RouteRole> roles, @NotNull Handler handler) {
    Intrinsics.checkNotNullParameter(type, "type");
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullParameter(routingConfig, "routingConfig");
    Intrinsics.checkNotNullParameter(roles, "roles");
    Intrinsics.checkNotNullParameter(handler, "handler");
    return new HandlerEntry(type, path, routingConfig, roles, handler);
  }
  
  @NotNull
  public String toString() {
    return "HandlerEntry(type=" + this.type + ", path=" + this.path + ", routingConfig=" + this.routingConfig + ", roles=" + this.roles + ", handler=" + this.handler + ")";
  }
  
  public int hashCode() {
    result = this.type.hashCode();
    result = result * 31 + this.path.hashCode();
    result = result * 31 + this.routingConfig.hashCode();
    result = result * 31 + this.roles.hashCode();
    return result * 31 + this.handler.hashCode();
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof HandlerEntry))
      return false; 
    HandlerEntry handlerEntry = (HandlerEntry)other;
    return (this.type != handlerEntry.type) ? false : (!Intrinsics.areEqual(this.path, handlerEntry.path) ? false : (!Intrinsics.areEqual(this.routingConfig, handlerEntry.routingConfig) ? false : (!Intrinsics.areEqual(this.roles, handlerEntry.roles) ? false : (!!Intrinsics.areEqual(this.handler, handlerEntry.handler)))));
  }
}
