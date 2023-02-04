package io.javalin.config;

import io.javalin.http.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\030\002\n\002\020\016\n\002\b\005\030\0002\0020\001B\005¢\006\002\020\002R\036\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\0048\006@\006X\016¢\006\002\n\000R \020\007\032\020\022\004\022\0020\005\022\006\022\004\030\0010\0060\0048\006@\006X\016¢\006\002\n\000R\036\020\b\032\016\022\004\022\0020\005\022\004\022\0020\0060\0048\006@\006X\016¢\006\002\n\000R\036\020\t\032\016\022\004\022\0020\005\022\004\022\0020\0060\0048\006@\006X\016¢\006\002\n\000R\036\020\n\032\016\022\004\022\0020\005\022\004\022\0020\0060\0048\006@\006X\016¢\006\002\n\000¨\006\013"}, d2 = {"Lio/javalin/config/ContextResolverConfig;", "", "()V", "fullUrl", "Lkotlin/Function1;", "Lio/javalin/http/Context;", "", "host", "ip", "scheme", "url", "javalin"})
public final class ContextResolverConfig {
  @JvmField
  @NotNull
  public Function1<? super Context, String> ip = ContextResolverConfig$ip$1.INSTANCE;
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\020\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\020\000\032\n \002*\004\030\0010\0010\0012\006\020\003\032\0020\004H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lio/javalin/http/Context;", "invoke"})
  static final class ContextResolverConfig$ip$1 extends Lambda implements Function1<Context, String> {
    public static final ContextResolverConfig$ip$1 INSTANCE = new ContextResolverConfig$ip$1();
    
    ContextResolverConfig$ip$1() {
      super(1);
    }
    
    public final String invoke(@NotNull Context it) {
      Intrinsics.checkNotNullParameter(it, "it");
      Intrinsics.checkNotNullExpressionValue(it.req().getRemoteAddr(), "it.req().remoteAddr");
      return it.req().getRemoteAddr();
    }
  }
  
  @JvmField
  @NotNull
  public Function1<? super Context, String> host = ContextResolverConfig$host$1.INSTANCE;
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\016\n\000\n\002\030\002\n\000\020\000\032\004\030\0010\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/http/Context;", "invoke"})
  static final class ContextResolverConfig$host$1 extends Lambda implements Function1<Context, String> {
    public static final ContextResolverConfig$host$1 INSTANCE = new ContextResolverConfig$host$1();
    
    ContextResolverConfig$host$1() {
      super(1);
    }
    
    @Nullable
    public final String invoke(@NotNull Context it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it.header("Host");
    }
  }
  
  @JvmField
  @NotNull
  public Function1<? super Context, String> scheme = ContextResolverConfig$scheme$1.INSTANCE;
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\020\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\020\000\032\n \002*\004\030\0010\0010\0012\006\020\003\032\0020\004H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lio/javalin/http/Context;", "invoke"})
  static final class ContextResolverConfig$scheme$1 extends Lambda implements Function1<Context, String> {
    public static final ContextResolverConfig$scheme$1 INSTANCE = new ContextResolverConfig$scheme$1();
    
    ContextResolverConfig$scheme$1() {
      super(1);
    }
    
    public final String invoke(@NotNull Context it) {
      Intrinsics.checkNotNullParameter(it, "it");
      Intrinsics.checkNotNullExpressionValue(it.req().getScheme(), "it.req().scheme");
      return it.req().getScheme();
    }
  }
  
  @JvmField
  @NotNull
  public Function1<? super Context, String> url = ContextResolverConfig$url$1.INSTANCE;
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\016\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/http/Context;", "invoke"})
  static final class ContextResolverConfig$url$1 extends Lambda implements Function1<Context, String> {
    public static final ContextResolverConfig$url$1 INSTANCE = new ContextResolverConfig$url$1();
    
    ContextResolverConfig$url$1() {
      super(1);
    }
    
    @NotNull
    public final String invoke(@NotNull Context it) {
      Intrinsics.checkNotNullParameter(it, "it");
      Intrinsics.checkNotNullExpressionValue(it.req().getRequestURL().toString(), "it.req().requestURL.toString()");
      return it.req().getRequestURL().toString();
    }
  }
  
  @JvmField
  @NotNull
  public Function1<? super Context, String> fullUrl = ContextResolverConfig$fullUrl$1.INSTANCE;
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\016\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/http/Context;", "invoke"})
  static final class ContextResolverConfig$fullUrl$1 extends Lambda implements Function1<Context, String> {
    public static final ContextResolverConfig$fullUrl$1 INSTANCE = new ContextResolverConfig$fullUrl$1();
    
    ContextResolverConfig$fullUrl$1() {
      super(1);
    }
    
    @NotNull
    public final String invoke(@NotNull Context it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it.url() + it.url();
    }
  }
}
