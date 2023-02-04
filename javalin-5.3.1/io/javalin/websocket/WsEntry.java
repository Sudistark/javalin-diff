package io.javalin.websocket;

import io.javalin.config.RoutingConfig;
import io.javalin.routing.PathParser;
import io.javalin.security.RouteRole;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000L\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\"\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\017\n\002\020\013\n\002\b\002\n\002\020$\n\000\n\002\020\b\n\002\b\003\b\b\030\0002\0020\001B3\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t\022\f\020\n\032\b\022\004\022\0020\f0\013¢\006\002\020\rJ\t\020\032\032\0020\003HÆ\003J\t\020\033\032\0020\005HÆ\003J\t\020\034\032\0020\007HÆ\003J\t\020\035\032\0020\tHÆ\003J\017\020\036\032\b\022\004\022\0020\f0\013HÆ\003JA\020\037\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0052\b\b\002\020\006\032\0020\0072\b\b\002\020\b\032\0020\t2\016\b\002\020\n\032\b\022\004\022\0020\f0\013HÆ\001J\023\020 \032\0020!2\b\020\"\032\004\030\0010\001HÖ\003J\032\020#\032\016\022\004\022\0020\005\022\004\022\0020\0050$2\006\020\004\032\0020\005J\t\020%\032\0020&HÖ\001J\016\020'\032\0020!2\006\020\004\032\0020\005J\t\020(\032\0020\005HÖ\001R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\016\020\017R\016\020\020\032\0020\021X\004¢\006\002\n\000R\027\020\n\032\b\022\004\022\0020\f0\013¢\006\b\n\000\032\004\b\022\020\023R\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\024\020\025R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\026\020\027R\021\020\b\032\0020\t¢\006\b\n\000\032\004\b\030\020\031¨\006)"}, d2 = {"Lio/javalin/websocket/WsEntry;", "", "type", "Lio/javalin/websocket/WsHandlerType;", "path", "", "routingConfig", "Lio/javalin/config/RoutingConfig;", "wsConfig", "Lio/javalin/websocket/WsConfig;", "roles", "", "Lio/javalin/security/RouteRole;", "(Lio/javalin/websocket/WsHandlerType;Ljava/lang/String;Lio/javalin/config/RoutingConfig;Lio/javalin/websocket/WsConfig;Ljava/util/Set;)V", "getPath", "()Ljava/lang/String;", "pathParser", "Lio/javalin/routing/PathParser;", "getRoles", "()Ljava/util/Set;", "getRoutingConfig", "()Lio/javalin/config/RoutingConfig;", "getType", "()Lio/javalin/websocket/WsHandlerType;", "getWsConfig", "()Lio/javalin/websocket/WsConfig;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "extractPathParams", "", "hashCode", "", "matches", "toString", "javalin"})
public final class WsEntry {
  @NotNull
  private final WsHandlerType type;
  
  @NotNull
  private final String path;
  
  @NotNull
  private final RoutingConfig routingConfig;
  
  @NotNull
  private final WsConfig wsConfig;
  
  @NotNull
  private final Set<RouteRole> roles;
  
  @NotNull
  private final PathParser pathParser;
  
  public WsEntry(@NotNull WsHandlerType type, @NotNull String path, @NotNull RoutingConfig routingConfig, @NotNull WsConfig wsConfig, @NotNull Set<RouteRole> roles) {
    this.type = type;
    this.path = path;
    this.routingConfig = routingConfig;
    this.wsConfig = wsConfig;
    this.roles = roles;
    this.pathParser = new PathParser(this.path, this.routingConfig);
  }
  
  @NotNull
  public final WsHandlerType getType() {
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
  public final WsConfig getWsConfig() {
    return this.wsConfig;
  }
  
  @NotNull
  public final Set<RouteRole> getRoles() {
    return this.roles;
  }
  
  public final boolean matches(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    return this.pathParser.matches(path);
  }
  
  @NotNull
  public final Map<String, String> extractPathParams(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    return this.pathParser.extractPathParams(path);
  }
  
  @NotNull
  public final WsHandlerType component1() {
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
  public final WsConfig component4() {
    return this.wsConfig;
  }
  
  @NotNull
  public final Set<RouteRole> component5() {
    return this.roles;
  }
  
  @NotNull
  public final WsEntry copy(@NotNull WsHandlerType type, @NotNull String path, @NotNull RoutingConfig routingConfig, @NotNull WsConfig wsConfig, @NotNull Set<? extends RouteRole> roles) {
    Intrinsics.checkNotNullParameter(type, "type");
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullParameter(routingConfig, "routingConfig");
    Intrinsics.checkNotNullParameter(wsConfig, "wsConfig");
    Intrinsics.checkNotNullParameter(roles, "roles");
    return new WsEntry(type, path, routingConfig, wsConfig, roles);
  }
  
  @NotNull
  public String toString() {
    return "WsEntry(type=" + this.type + ", path=" + this.path + ", routingConfig=" + this.routingConfig + ", wsConfig=" + this.wsConfig + ", roles=" + this.roles + ")";
  }
  
  public int hashCode() {
    result = this.type.hashCode();
    result = result * 31 + this.path.hashCode();
    result = result * 31 + this.routingConfig.hashCode();
    result = result * 31 + this.wsConfig.hashCode();
    return result * 31 + this.roles.hashCode();
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof WsEntry))
      return false; 
    WsEntry wsEntry = (WsEntry)other;
    return (this.type != wsEntry.type) ? false : (!Intrinsics.areEqual(this.path, wsEntry.path) ? false : (!Intrinsics.areEqual(this.routingConfig, wsEntry.routingConfig) ? false : (!Intrinsics.areEqual(this.wsConfig, wsEntry.wsConfig) ? false : (!!Intrinsics.areEqual(this.roles, wsEntry.roles)))));
  }
}
