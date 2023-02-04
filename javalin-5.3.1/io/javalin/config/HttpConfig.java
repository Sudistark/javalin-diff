package io.javalin.config;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\000\n\002\020\016\n\000\n\002\020\013\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002R\022\020\003\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\005\032\0020\0068\006@\006X\016¢\006\002\n\000R\022\020\007\032\0020\b8\006@\006X\016¢\006\002\n\000R\022\020\t\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\n\032\0020\b8\006@\006X\016¢\006\002\n\000¨\006\013"}, d2 = {"Lio/javalin/config/HttpConfig;", "", "()V", "asyncTimeout", "", "defaultContentType", "", "generateEtags", "", "maxRequestSize", "prefer405over404", "javalin"})
public final class HttpConfig {
  @JvmField
  public boolean generateEtags;
  
  @JvmField
  public boolean prefer405over404;
  
  @JvmField
  public long maxRequestSize = 1000000L;
  
  @JvmField
  @NotNull
  public String defaultContentType = "text/plain";
  
  @JvmField
  public long asyncTimeout;
}
