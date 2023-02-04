package io.javalin.config;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\020\013\n\002\b\002\030\0002\0020\001B\005¢\006\002\020\002R\022\020\003\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\005\032\0020\0068\006@\006X\016¢\006\002\n\000R\022\020\007\032\0020\0068\006@\006X\016¢\006\002\n\000¨\006\b"}, d2 = {"Lio/javalin/config/RoutingConfig;", "", "()V", "contextPath", "", "ignoreTrailingSlashes", "", "treatMultipleSlashesAsSingleSlash", "javalin"})
public final class RoutingConfig {
  @JvmField
  @NotNull
  public String contextPath = "/";
  
  @JvmField
  public boolean ignoreTrailingSlashes = true;
  
  @JvmField
  public boolean treatMultipleSlashesAsSingleSlash;
}
