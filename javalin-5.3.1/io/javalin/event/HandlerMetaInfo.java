package io.javalin.event;

import io.javalin.http.HandlerType;
import io.javalin.security.RouteRole;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0004\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\020\"\n\002\030\002\n\002\b\017\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001B+\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\001\022\f\020\007\032\b\022\004\022\0020\t0\b¢\006\002\020\nJ\t\020\023\032\0020\003HÆ\003J\t\020\024\032\0020\005HÆ\003J\t\020\025\032\0020\001HÆ\003J\017\020\026\032\b\022\004\022\0020\t0\bHÆ\003J7\020\027\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0052\b\b\002\020\006\032\0020\0012\016\b\002\020\007\032\b\022\004\022\0020\t0\bHÆ\001J\023\020\030\032\0020\0312\b\020\032\032\004\030\0010\001HÖ\003J\t\020\033\032\0020\034HÖ\001J\t\020\035\032\0020\005HÖ\001R\021\020\006\032\0020\001¢\006\b\n\000\032\004\b\013\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\017\020\020R\027\020\007\032\b\022\004\022\0020\t0\b¢\006\b\n\000\032\004\b\021\020\022¨\006\036"}, d2 = {"Lio/javalin/event/HandlerMetaInfo;", "", "httpMethod", "Lio/javalin/http/HandlerType;", "path", "", "handler", "roles", "", "Lio/javalin/security/RouteRole;", "(Lio/javalin/http/HandlerType;Ljava/lang/String;Ljava/lang/Object;Ljava/util/Set;)V", "getHandler", "()Ljava/lang/Object;", "getHttpMethod", "()Lio/javalin/http/HandlerType;", "getPath", "()Ljava/lang/String;", "getRoles", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "javalin"})
public final class HandlerMetaInfo {
  @NotNull
  private final HandlerType httpMethod;
  
  @NotNull
  private final String path;
  
  @NotNull
  private final Object handler;
  
  @NotNull
  private final Set<RouteRole> roles;
  
  public HandlerMetaInfo(@NotNull HandlerType httpMethod, @NotNull String path, @NotNull Object handler, @NotNull Set<RouteRole> roles) {
    this.httpMethod = httpMethod;
    this.path = path;
    this.handler = handler;
    this.roles = roles;
  }
  
  @NotNull
  public final HandlerType getHttpMethod() {
    return this.httpMethod;
  }
  
  @NotNull
  public final String getPath() {
    return this.path;
  }
  
  @NotNull
  public final Object getHandler() {
    return this.handler;
  }
  
  @NotNull
  public final Set<RouteRole> getRoles() {
    return this.roles;
  }
  
  @NotNull
  public final HandlerType component1() {
    return this.httpMethod;
  }
  
  @NotNull
  public final String component2() {
    return this.path;
  }
  
  @NotNull
  public final Object component3() {
    return this.handler;
  }
  
  @NotNull
  public final Set<RouteRole> component4() {
    return this.roles;
  }
  
  @NotNull
  public final HandlerMetaInfo copy(@NotNull HandlerType httpMethod, @NotNull String path, @NotNull Object handler, @NotNull Set<? extends RouteRole> roles) {
    Intrinsics.checkNotNullParameter(httpMethod, "httpMethod");
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullParameter(handler, "handler");
    Intrinsics.checkNotNullParameter(roles, "roles");
    return new HandlerMetaInfo(httpMethod, path, handler, roles);
  }
  
  @NotNull
  public String toString() {
    return "HandlerMetaInfo(httpMethod=" + this.httpMethod + ", path=" + this.path + ", handler=" + this.handler + ", roles=" + this.roles + ")";
  }
  
  public int hashCode() {
    result = this.httpMethod.hashCode();
    result = result * 31 + this.path.hashCode();
    result = result * 31 + this.handler.hashCode();
    return result * 31 + this.roles.hashCode();
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof HandlerMetaInfo))
      return false; 
    HandlerMetaInfo handlerMetaInfo = (HandlerMetaInfo)other;
    return (this.httpMethod != handlerMetaInfo.httpMethod) ? false : (!Intrinsics.areEqual(this.path, handlerMetaInfo.path) ? false : (!Intrinsics.areEqual(this.handler, handlerMetaInfo.handler) ? false : (!!Intrinsics.areEqual(this.roles, handlerMetaInfo.roles))));
  }
}
