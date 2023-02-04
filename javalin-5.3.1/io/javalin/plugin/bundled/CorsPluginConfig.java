package io.javalin.plugin.bundled;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000@\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\002\b\002\n\002\020\016\n\002\b\002\n\002\020!\n\002\b\003\n\002\020\002\n\002\b\002\n\002\020\021\n\000\n\002\020 \n\002\b\r\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001BM\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003\022\b\b\002\020\005\032\0020\006\022\b\b\002\020\007\032\0020\006\022\016\b\002\020\b\032\b\022\004\022\0020\0060\t\022\016\b\002\020\n\032\b\022\004\022\0020\0060\t¢\006\002\020\013J'\020\f\032\0020\r2\006\020\016\032\0020\0062\022\020\017\032\n\022\006\b\001\022\0020\0060\020\"\0020\006¢\006\002\020\021J\f\020\b\032\b\022\004\022\0020\0060\022J\006\020\023\032\0020\rJ\t\020\024\032\0020\003HÆ\003J\t\020\025\032\0020\003HÆ\003J\t\020\026\032\0020\006HÆ\003J\t\020\027\032\0020\006HÆ\003J\017\020\030\032\b\022\004\022\0020\0060\tHÂ\003J\017\020\031\032\b\022\004\022\0020\0060\tHÂ\003JQ\020\032\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\0062\b\b\002\020\007\032\0020\0062\016\b\002\020\b\032\b\022\004\022\0020\0060\t2\016\b\002\020\n\032\b\022\004\022\0020\0060\tHÆ\001J\023\020\033\032\0020\0032\b\020\034\032\004\030\0010\001HÖ\003J\016\020\035\032\0020\r2\006\020\036\032\0020\006J\t\020\037\032\0020 HÖ\001J\f\020\n\032\b\022\004\022\0020\0060\022J\t\020!\032\0020\006HÖ\001R\022\020\002\032\0020\0038\006@\006X\016¢\006\002\n\000R\024\020\b\032\b\022\004\022\0020\0060\tX\004¢\006\002\n\000R\022\020\005\032\0020\0068\006@\006X\016¢\006\002\n\000R\024\020\n\032\b\022\004\022\0020\0060\tX\004¢\006\002\n\000R\022\020\007\032\0020\0068\006@\006X\016¢\006\002\n\000R\022\020\004\032\0020\0038\006@\006X\016¢\006\002\n\000¨\006\""}, d2 = {"Lio/javalin/plugin/bundled/CorsPluginConfig;", "", "allowCredentials", "", "reflectClientOrigin", "defaultScheme", "", "path", "allowedOrigins", "", "headersToExpose", "(ZZLjava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "allowHost", "", "host", "others", "", "(Ljava/lang/String;[Ljava/lang/String;)V", "", "anyHost", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "exposeHeader", "header", "hashCode", "", "toString", "javalin"})
public final class CorsPluginConfig {
  @JvmField
  public boolean allowCredentials;
  
  @JvmField
  public boolean reflectClientOrigin;
  
  @JvmField
  @NotNull
  public String defaultScheme;
  
  @JvmField
  @NotNull
  public String path;
  
  @NotNull
  private final List<String> allowedOrigins;
  
  @NotNull
  private final List<String> headersToExpose;
  
  public CorsPluginConfig(boolean allowCredentials, boolean reflectClientOrigin, @NotNull String defaultScheme, @NotNull String path, @NotNull List<String> allowedOrigins, @NotNull List<String> headersToExpose) {
    this.allowCredentials = allowCredentials;
    this.reflectClientOrigin = reflectClientOrigin;
    this.defaultScheme = defaultScheme;
    this.path = path;
    this.allowedOrigins = allowedOrigins;
    this.headersToExpose = headersToExpose;
  }
  
  @NotNull
  public final List<String> allowedOrigins() {
    Intrinsics.checkNotNullExpressionValue(Collections.unmodifiableList(this.allowedOrigins), "unmodifiableList(allowedOrigins)");
    return Collections.unmodifiableList(this.allowedOrigins);
  }
  
  @NotNull
  public final List<String> headersToExpose() {
    Intrinsics.checkNotNullExpressionValue(Collections.unmodifiableList(this.headersToExpose), "unmodifiableList(headersToExpose)");
    return Collections.unmodifiableList(this.headersToExpose);
  }
  
  public final void anyHost() {
    this.allowedOrigins.add("*");
  }
  
  public final void allowHost(@NotNull String host, @NotNull String... others) {
    Intrinsics.checkNotNullParameter(host, "host");
    Intrinsics.checkNotNullParameter(others, "others");
    List origins = CollectionsKt.plus(CollectionsKt.listOf(host), ArraysKt.toList((Object[])others));
    Iterable $this$map$iv = origins;
    int $i$f$map = 0;
    Iterable iterable1 = $this$map$iv;
    Collection<String> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : iterable1) {
      String str = (String)item$iv$iv;
      Collection<String> collection = destination$iv$iv;
      int $i$a$-map-CorsPluginConfig$allowHost$1 = 0;
      collection.add(CorsUtils.INSTANCE.addSchemeIfMissing$javalin(str, this.defaultScheme));
    } 
    $this$map$iv = destination$iv$iv;
    int $i$f$forEachIndexed = 0;
    int index$iv = 0;
    Iterator iterator = $this$map$iv.iterator();
    if (iterator.hasNext()) {
      Object item$iv = iterator.next();
      int i = index$iv++;
      if (i < 0)
        CollectionsKt.throwIndexOverflow(); 
      String str = (String)item$iv;
      int idx = i, $i$a$-forEachIndexed-CorsPluginConfig$allowHost$2 = 0;
      if (!(!Intrinsics.areEqual(str, "null") ? 1 : 0)) {
        int $i$a$-require-CorsPluginConfig$allowHost$2$1 = 0;
        String str1 = "Adding the string null as an allowed host is forbidden. Consider calling anyHost() instead";
        throw new IllegalArgumentException(str1.toString());
      } 
    } 
  }
  
  public final void exposeHeader(@NotNull String header) {
    Intrinsics.checkNotNullParameter(header, "header");
    this.headersToExpose.add(header);
  }
  
  public final boolean component1() {
    return this.allowCredentials;
  }
  
  public final boolean component2() {
    return this.reflectClientOrigin;
  }
  
  @NotNull
  public final String component3() {
    return this.defaultScheme;
  }
  
  @NotNull
  public final String component4() {
    return this.path;
  }
  
  private final List<String> component5() {
    return this.allowedOrigins;
  }
  
  private final List<String> component6() {
    return this.headersToExpose;
  }
  
  @NotNull
  public final CorsPluginConfig copy(boolean allowCredentials, boolean reflectClientOrigin, @NotNull String defaultScheme, @NotNull String path, @NotNull List<String> allowedOrigins, @NotNull List<String> headersToExpose) {
    Intrinsics.checkNotNullParameter(defaultScheme, "defaultScheme");
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullParameter(allowedOrigins, "allowedOrigins");
    Intrinsics.checkNotNullParameter(headersToExpose, "headersToExpose");
    return new CorsPluginConfig(allowCredentials, reflectClientOrigin, defaultScheme, path, allowedOrigins, headersToExpose);
  }
  
  @NotNull
  public String toString() {
    return "CorsPluginConfig(allowCredentials=" + this.allowCredentials + ", reflectClientOrigin=" + this.reflectClientOrigin + ", defaultScheme=" + this.defaultScheme + ", path=" + this.path + ", allowedOrigins=" + this.allowedOrigins + ", headersToExpose=" + this.headersToExpose + ")";
  }
  
  public int hashCode() {
    if (this.allowCredentials);
    result = 1;
    if (this.reflectClientOrigin);
    result = result * 31 + 1;
    result = result * 31 + this.defaultScheme.hashCode();
    result = result * 31 + this.path.hashCode();
    result = result * 31 + this.allowedOrigins.hashCode();
    return result * 31 + this.headersToExpose.hashCode();
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof CorsPluginConfig))
      return false; 
    CorsPluginConfig corsPluginConfig = (CorsPluginConfig)other;
    return (this.allowCredentials != corsPluginConfig.allowCredentials) ? false : ((this.reflectClientOrigin != corsPluginConfig.reflectClientOrigin) ? false : (!Intrinsics.areEqual(this.defaultScheme, corsPluginConfig.defaultScheme) ? false : (!Intrinsics.areEqual(this.path, corsPluginConfig.path) ? false : (!Intrinsics.areEqual(this.allowedOrigins, corsPluginConfig.allowedOrigins) ? false : (!!Intrinsics.areEqual(this.headersToExpose, corsPluginConfig.headersToExpose))))));
  }
  
  public CorsPluginConfig() {
    this(false, false, null, null, null, null, 63, null);
  }
}
