package io.javalin.plugin.bundled;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\002\n\002\020\b\n\002\b\013\n\002\020\013\n\002\b\004\b\b\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\006\020\005\032\0020\006¢\006\002\020\007J\t\020\r\032\0020\003HÆ\003J\t\020\016\032\0020\003HÆ\003J\t\020\017\032\0020\006HÆ\003J'\020\020\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\006HÆ\001J\023\020\021\032\0020\0222\b\020\023\032\004\030\0010\001HÖ\003J\t\020\024\032\0020\006HÖ\001J\t\020\025\032\0020\003HÖ\001R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\b\020\tR\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\n\020\013R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\f\020\t¨\006\026"}, d2 = {"Lio/javalin/plugin/bundled/OriginParts;", "", "scheme", "", "host", "port", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getHost", "()Ljava/lang/String;", "getPort", "()I", "getScheme", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "javalin"})
public final class OriginParts {
  @NotNull
  private final String scheme;
  
  @NotNull
  private final String host;
  
  private final int port;
  
  public OriginParts(@NotNull String scheme, @NotNull String host, int port) {
    this.scheme = scheme;
    this.host = host;
    this.port = port;
  }
  
  @NotNull
  public final String getScheme() {
    return this.scheme;
  }
  
  @NotNull
  public final String getHost() {
    return this.host;
  }
  
  public final int getPort() {
    return this.port;
  }
  
  @NotNull
  public final String component1() {
    return this.scheme;
  }
  
  @NotNull
  public final String component2() {
    return this.host;
  }
  
  public final int component3() {
    return this.port;
  }
  
  @NotNull
  public final OriginParts copy(@NotNull String scheme, @NotNull String host, int port) {
    Intrinsics.checkNotNullParameter(scheme, "scheme");
    Intrinsics.checkNotNullParameter(host, "host");
    return new OriginParts(scheme, host, port);
  }
  
  @NotNull
  public String toString() {
    return "OriginParts(scheme=" + this.scheme + ", host=" + this.host + ", port=" + this.port + ")";
  }
  
  public int hashCode() {
    result = this.scheme.hashCode();
    result = result * 31 + this.host.hashCode();
    return result * 31 + Integer.hashCode(this.port);
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof OriginParts))
      return false; 
    OriginParts originParts = (OriginParts)other;
    return !Intrinsics.areEqual(this.scheme, originParts.scheme) ? false : (!Intrinsics.areEqual(this.host, originParts.host) ? false : (!(this.port != originParts.port)));
  }
}
