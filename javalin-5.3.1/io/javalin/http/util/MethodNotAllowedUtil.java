package io.javalin.http.util;

import io.javalin.http.Context;
import io.javalin.http.HandlerType;
import io.javalin.http.servlet.JavalinServletContextKt;
import io.javalin.routing.PathMatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0000\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020$\n\000\n\002\030\002\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\034\020\003\032\b\022\004\022\0020\0050\0042\006\020\006\032\0020\0072\006\020\b\032\0020\tJ(\020\n\032\016\022\004\022\0020\t\022\004\022\0020\t0\0132\006\020\f\032\0020\r2\f\020\016\032\b\022\004\022\0020\0050\004¨\006\017"}, d2 = {"Lio/javalin/http/util/MethodNotAllowedUtil;", "", "()V", "findAvailableHttpHandlerTypes", "", "Lio/javalin/http/HandlerType;", "matcher", "Lio/javalin/routing/PathMatcher;", "requestUri", "", "getAvailableHandlerTypes", "", "ctx", "Lio/javalin/http/Context;", "availableHandlerTypes", "javalin"})
public final class MethodNotAllowedUtil {
  @NotNull
  public static final MethodNotAllowedUtil INSTANCE = new MethodNotAllowedUtil();
  
  @NotNull
  public final List<HandlerType> findAvailableHttpHandlerTypes(@NotNull PathMatcher matcher, @NotNull String requestUri) {
    Intrinsics.checkNotNullParameter(matcher, "matcher");
    Intrinsics.checkNotNullParameter(requestUri, "requestUri");
    HandlerType[] arrayOfHandlerType1 = HandlerType.values();
    int $i$f$filter = 0;
    HandlerType[] arrayOfHandlerType2 = arrayOfHandlerType1;
    Collection destination$iv$iv = new ArrayList();
    int $i$f$filterTo = 0;
    byte b;
    int i;
    for (b = 0, i = arrayOfHandlerType2.length; b < i; ) {
      Object element$iv$iv = arrayOfHandlerType2[b], object1 = element$iv$iv;
      int $i$a$-filter-MethodNotAllowedUtil$findAvailableHttpHandlerTypes$1 = 0;
    } 
    return (List<HandlerType>)destination$iv$iv;
  }
  
  @NotNull
  public final Map<String, String> getAvailableHandlerTypes(@NotNull Context ctx, @NotNull List availableHandlerTypes) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    Intrinsics.checkNotNullParameter(availableHandlerTypes, "availableHandlerTypes");
    return MapsKt.mapOf(TuplesKt.to(JavalinServletContextKt.acceptsHtml(ctx) ? "Available methods" : "availableMethods", CollectionsKt.joinToString$default(availableHandlerTypes, ", ", null, null, 0, null, null, 62, null)));
  }
}
