package io.javalin.http.staticfiles;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000>\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020$\n\000\n\002\030\002\n\002\030\002\n\002\b\f\n\002\020\b\n\002\b\004\b\b\030\0002\0020\001Be\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\b\022\n\b\002\020\t\032\004\030\0010\n\022\024\b\002\020\013\032\016\022\004\022\0020\003\022\004\022\0020\0030\f\022\024\b\002\020\r\032\016\022\004\022\0020\017\022\004\022\0020\b0\016¢\006\002\020\020J\t\020\021\032\0020\003HÆ\003J\t\020\022\032\0020\003HÆ\003J\t\020\023\032\0020\006HÆ\003J\t\020\024\032\0020\bHÆ\003J\013\020\025\032\004\030\0010\nHÆ\003J\025\020\026\032\016\022\004\022\0020\003\022\004\022\0020\0030\fHÆ\003J\025\020\027\032\016\022\004\022\0020\017\022\004\022\0020\b0\016HÆ\003Ji\020\030\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\0062\b\b\002\020\007\032\0020\b2\n\b\002\020\t\032\004\030\0010\n2\024\b\002\020\013\032\016\022\004\022\0020\003\022\004\022\0020\0030\f2\024\b\002\020\r\032\016\022\004\022\0020\017\022\004\022\0020\b0\016HÆ\001J\023\020\031\032\0020\b2\b\020\032\032\004\030\0010\001HÖ\003J\t\020\033\032\0020\034HÖ\001J\r\020\035\032\0020\003H\000¢\006\002\b\036J\t\020\037\032\0020\003HÖ\001R\024\020\t\032\004\030\0010\n8\006@\006X\016¢\006\002\n\000R\022\020\004\032\0020\0038\006@\006X\016¢\006\002\n\000R\036\020\013\032\016\022\004\022\0020\003\022\004\022\0020\0030\f8\006@\006X\016¢\006\002\n\000R\022\020\002\032\0020\0038\006@\006X\016¢\006\002\n\000R\022\020\005\032\0020\0068\006@\006X\016¢\006\002\n\000R\022\020\007\032\0020\b8\006@\006X\016¢\006\002\n\000R\036\020\r\032\016\022\004\022\0020\017\022\004\022\0020\b0\0168\006@\006X\016¢\006\002\n\000¨\006 "}, d2 = {"Lio/javalin/http/staticfiles/StaticFileConfig;", "", "hostedPath", "", "directory", "location", "Lio/javalin/http/staticfiles/Location;", "precompress", "", "aliasCheck", "Lorg/eclipse/jetty/server/handler/ContextHandler$AliasCheck;", "headers", "", "skipFileFunction", "Lkotlin/Function1;", "Ljakarta/servlet/http/HttpServletRequest;", "(Ljava/lang/String;Ljava/lang/String;Lio/javalin/http/staticfiles/Location;ZLorg/eclipse/jetty/server/handler/ContextHandler$AliasCheck;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "refinedToString", "refinedToString$javalin", "toString", "javalin"})
public final class StaticFileConfig {
  @JvmField
  @NotNull
  public String hostedPath;
  
  @JvmField
  @NotNull
  public String directory;
  
  @JvmField
  @NotNull
  public Location location;
  
  @JvmField
  public boolean precompress;
  
  @JvmField
  @Nullable
  public ContextHandler.AliasCheck aliasCheck;
  
  @JvmField
  @NotNull
  public Map<String, String> headers;
  
  @JvmField
  @NotNull
  public Function1<? super HttpServletRequest, Boolean> skipFileFunction;
  
  public StaticFileConfig(@NotNull String hostedPath, @NotNull String directory, @NotNull Location location, boolean precompress, @Nullable ContextHandler.AliasCheck aliasCheck, @NotNull Map<String, String> headers, @NotNull Function1<? super HttpServletRequest, Boolean> skipFileFunction) {
    this.hostedPath = hostedPath;
    this.directory = directory;
    this.location = location;
    this.precompress = precompress;
    this.aliasCheck = aliasCheck;
    this.headers = headers;
    this.skipFileFunction = skipFileFunction;
  }
  
  @NotNull
  public final String refinedToString$javalin() {
    return StringsKt.replace$default(toString(), ", skipFileFunction=(jakarta.servlet.http.HttpServletRequest) -> kotlin.Boolean", "", false, 4, null);
  }
  
  @NotNull
  public final String component1() {
    return this.hostedPath;
  }
  
  @NotNull
  public final String component2() {
    return this.directory;
  }
  
  @NotNull
  public final Location component3() {
    return this.location;
  }
  
  public final boolean component4() {
    return this.precompress;
  }
  
  @Nullable
  public final ContextHandler.AliasCheck component5() {
    return this.aliasCheck;
  }
  
  @NotNull
  public final Map<String, String> component6() {
    return this.headers;
  }
  
  @NotNull
  public final Function1<HttpServletRequest, Boolean> component7() {
    return (Function1)this.skipFileFunction;
  }
  
  @NotNull
  public final StaticFileConfig copy(@NotNull String hostedPath, @NotNull String directory, @NotNull Location location, boolean precompress, @Nullable ContextHandler.AliasCheck aliasCheck, @NotNull Map<String, String> headers, @NotNull Function1<? super HttpServletRequest, Boolean> skipFileFunction) {
    Intrinsics.checkNotNullParameter(hostedPath, "hostedPath");
    Intrinsics.checkNotNullParameter(directory, "directory");
    Intrinsics.checkNotNullParameter(location, "location");
    Intrinsics.checkNotNullParameter(headers, "headers");
    Intrinsics.checkNotNullParameter(skipFileFunction, "skipFileFunction");
    return new StaticFileConfig(hostedPath, directory, location, precompress, aliasCheck, headers, skipFileFunction);
  }
  
  @NotNull
  public String toString() {
    return "StaticFileConfig(hostedPath=" + this.hostedPath + ", directory=" + this.directory + ", location=" + this.location + ", precompress=" + this.precompress + ", aliasCheck=" + this.aliasCheck + ", headers=" + this.headers + ", skipFileFunction=" + this.skipFileFunction + ")";
  }
  
  public int hashCode() {
    result = this.hostedPath.hashCode();
    result = result * 31 + this.directory.hashCode();
    result = result * 31 + this.location.hashCode();
    if (this.precompress);
    result = result * 31 + 1;
    result = result * 31 + ((this.aliasCheck == null) ? 0 : this.aliasCheck.hashCode());
    result = result * 31 + this.headers.hashCode();
    return result * 31 + this.skipFileFunction.hashCode();
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof StaticFileConfig))
      return false; 
    StaticFileConfig staticFileConfig = (StaticFileConfig)other;
    return !Intrinsics.areEqual(this.hostedPath, staticFileConfig.hostedPath) ? false : (!Intrinsics.areEqual(this.directory, staticFileConfig.directory) ? false : ((this.location != staticFileConfig.location) ? false : ((this.precompress != staticFileConfig.precompress) ? false : (!Intrinsics.areEqual(this.aliasCheck, staticFileConfig.aliasCheck) ? false : (!Intrinsics.areEqual(this.headers, staticFileConfig.headers) ? false : (!!Intrinsics.areEqual(this.skipFileFunction, staticFileConfig.skipFileFunction)))))));
  }
  
  public StaticFileConfig() {
    this(null, null, null, false, null, null, null, 127, null);
  }
}
