package io.javalin.http.servlet;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000<\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020#\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\b\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\003\030\0002\0020\001:\001\022B\005¢\006\002\020\002J\036\020\006\032\0020\0072\006\020\b\032\0020\t2\006\020\n\032\0020\0132\006\020\f\032\0020\rJ\026\020\016\032\0020\0172\006\020\b\032\0020\t2\006\020\020\032\0020\021R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000¨\006\023²\006\n\020\024\032\0020\007X\002"}, d2 = {"Lio/javalin/http/servlet/ErrorMapper;", "", "()V", "errorHandlers", "", "Lio/javalin/http/servlet/ErrorMapper$MapperEntry;", "addHandler", "", "statusCode", "", "contentType", "", "handler", "Lio/javalin/http/Handler;", "handle", "", "ctx", "Lio/javalin/http/Context;", "MapperEntry", "javalin", "contentTypeMatches"})
public final class ErrorMapper {
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\f\n\002\020\013\n\002\b\004\b\b\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\t\020\017\032\0020\003HÆ\003J\t\020\020\032\0020\005HÆ\003J\t\020\021\032\0020\007HÆ\003J'\020\022\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0052\b\b\002\020\006\032\0020\007HÆ\001J\023\020\023\032\0020\0242\b\020\025\032\004\030\0010\001HÖ\003J\t\020\026\032\0020\003HÖ\001J\t\020\027\032\0020\005HÖ\001R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\t\020\nR\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\013\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016¨\006\030"}, d2 = {"Lio/javalin/http/servlet/ErrorMapper$MapperEntry;", "", "statusCode", "", "contentType", "", "handler", "Lio/javalin/http/Handler;", "(ILjava/lang/String;Lio/javalin/http/Handler;)V", "getContentType", "()Ljava/lang/String;", "getHandler", "()Lio/javalin/http/Handler;", "getStatusCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "javalin"})
  public static final class MapperEntry {
    private final int statusCode;
    
    @NotNull
    private final String contentType;
    
    @NotNull
    private final Handler handler;
    
    public MapperEntry(int statusCode, @NotNull String contentType, @NotNull Handler handler) {
      this.statusCode = statusCode;
      this.contentType = contentType;
      this.handler = handler;
    }
    
    public final int getStatusCode() {
      return this.statusCode;
    }
    
    @NotNull
    public final String getContentType() {
      return this.contentType;
    }
    
    @NotNull
    public final Handler getHandler() {
      return this.handler;
    }
    
    public final int component1() {
      return this.statusCode;
    }
    
    @NotNull
    public final String component2() {
      return this.contentType;
    }
    
    @NotNull
    public final Handler component3() {
      return this.handler;
    }
    
    @NotNull
    public final MapperEntry copy(int statusCode, @NotNull String contentType, @NotNull Handler handler) {
      Intrinsics.checkNotNullParameter(contentType, "contentType");
      Intrinsics.checkNotNullParameter(handler, "handler");
      return new MapperEntry(statusCode, contentType, handler);
    }
    
    @NotNull
    public String toString() {
      return "MapperEntry(statusCode=" + this.statusCode + ", contentType=" + this.contentType + ", handler=" + this.handler + ")";
    }
    
    public int hashCode() {
      result = Integer.hashCode(this.statusCode);
      result = result * 31 + this.contentType.hashCode();
      return result * 31 + this.handler.hashCode();
    }
    
    public boolean equals(@Nullable Object other) {
      if (this == other)
        return true; 
      if (!(other instanceof MapperEntry))
        return false; 
      MapperEntry mapperEntry = (MapperEntry)other;
      return (this.statusCode != mapperEntry.statusCode) ? false : (!Intrinsics.areEqual(this.contentType, mapperEntry.contentType) ? false : (!!Intrinsics.areEqual(this.handler, mapperEntry.handler)));
    }
  }
  
  @NotNull
  private final Set<MapperEntry> errorHandlers = new LinkedHashSet<>();
  
  public final boolean addHandler(int statusCode, @NotNull String contentType, @NotNull Handler handler) {
    Intrinsics.checkNotNullParameter(contentType, "contentType");
    Intrinsics.checkNotNullParameter(handler, "handler");
    return this.errorHandlers.add(new MapperEntry(statusCode, contentType, handler));
  }
  
  public final void handle(int statusCode, @NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    Iterable<MapperEntry> $this$filter$iv = this.errorHandlers;
    int $i$f$filter = 0;
    Iterable<MapperEntry> iterable1 = $this$filter$iv;
    Collection<Object> destination$iv$iv = new ArrayList();
    int $i$f$filterTo = 0;
    for (MapperEntry element$iv$iv : iterable1) {
      MapperEntry it = element$iv$iv;
      int $i$a$-filter-ErrorMapper$handle$1 = 0;
      if ((it.getStatusCode() == statusCode))
        destination$iv$iv.add(element$iv$iv); 
    } 
    $this$filter$iv = destination$iv$iv;
    int $i$f$forEach = 0;
    Iterator<MapperEntry> iterator = $this$filter$iv.iterator();
    if (iterator.hasNext()) {
      Object element$iv = iterator.next();
      MapperEntry it = (MapperEntry)element$iv;
      int $i$a$-forEach-ErrorMapper$handle$2 = 0;
      Lazy contentTypeMatches$delegate = LazyKt.lazy(new ErrorMapper$handle$2$contentTypeMatches$2(ctx, it));
    } 
  }
  
  private static final boolean handle$lambda-2$lambda-1(Lazy $contentTypeMatches$delegate) {
    Lazy lazy = $contentTypeMatches$delegate;
    return ((Boolean)lazy.getValue()).booleanValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\n\n\000\n\002\020\013\n\002\b\002\020\000\032\0020\001H\n¢\006\004\b\002\020\003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Boolean;"})
  static final class ErrorMapper$handle$2$contentTypeMatches$2 extends Lambda implements Function0<Boolean> {
    ErrorMapper$handle$2$contentTypeMatches$2(Context $ctx, ErrorMapper.MapperEntry $it) {
      super(0);
    }
    
    @NotNull
    public final Boolean invoke() {
      this.$ctx.header("Accept");
      return Boolean.valueOf((this.$ctx.header("Accept") != null) ? ((StringsKt.contains(this.$ctx.header("Accept"), this.$it.getContentType(), true) == true)) : false);
    }
  }
}
