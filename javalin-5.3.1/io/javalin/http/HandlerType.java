package io.javalin.http;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\024\n\002\030\002\n\002\020\020\n\002\b\002\n\002\020\013\n\002\b\016\b\001\030\000 \0212\b\022\004\022\0020\0000\001:\001\021B\007\b\002¢\006\002\020\002J\006\020\003\032\0020\004j\002\b\005j\002\b\006j\002\b\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013j\002\b\fj\002\b\rj\002\b\016j\002\b\017j\002\b\020¨\006\022"}, d2 = {"Lio/javalin/http/HandlerType;", "", "(Ljava/lang/String;I)V", "isHttpMethod", "", "GET", "POST", "PUT", "PATCH", "DELETE", "HEAD", "TRACE", "CONNECT", "OPTIONS", "BEFORE", "AFTER", "INVALID", "Companion", "javalin"})
public enum HandlerType {
  GET, POST, PUT, PATCH, DELETE, HEAD, TRACE, CONNECT, OPTIONS, BEFORE, AFTER, INVALID;
  
  @NotNull
  public static final Companion Companion;
  
  @NotNull
  private static final Map<String, HandlerType> methodMap;
  
  static {
    Companion = new Companion(null);
    HandlerType[] arrayOfHandlerType1 = values();
    int $i$f$associateBy = 0;
    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(arrayOfHandlerType1.length), 16);
    HandlerType[] arrayOfHandlerType2 = arrayOfHandlerType1;
    Map<Object, Object> destination$iv$iv = new LinkedHashMap<>(capacity$iv);
    int $i$f$associateByTo = 0;
    byte b;
    int i;
    for (b = 0, i = arrayOfHandlerType2.length; b < i; ) {
      Object element$iv$iv = arrayOfHandlerType2[b];
      Object object1 = element$iv$iv;
      Map<Object, Object> map = destination$iv$iv;
      int $i$a$-associateBy-HandlerType$Companion$methodMap$1 = 0;
      map.put(object1.toString(), element$iv$iv);
      b++;
    } 
    methodMap = (Map)destination$iv$iv;
  }
  
  public final boolean isHttpMethod() {
    switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      
    } 
    return false;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020$\n\002\020\016\n\002\030\002\n\002\b\003\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\007\032\0020\0062\006\020\b\032\0020\005R\032\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004X\004¢\006\002\n\000¨\006\t"}, d2 = {"Lio/javalin/http/HandlerType$Companion;", "", "()V", "methodMap", "", "", "Lio/javalin/http/HandlerType;", "findByName", "name", "javalin"})
  public static final class Companion {
    private Companion() {}
    
    @NotNull
    public final HandlerType findByName(@NotNull String name) {
      Intrinsics.checkNotNullParameter(name, "name");
      Intrinsics.checkNotNullExpressionValue(name.toUpperCase(Locale.ROOT), "this as java.lang.String).toUpperCase(Locale.ROOT)");
      if ((HandlerType)HandlerType.methodMap.get(name.toUpperCase(Locale.ROOT)) == null)
        (HandlerType)HandlerType.methodMap.get(name.toUpperCase(Locale.ROOT)); 
      return HandlerType.INVALID;
    }
  }
}
