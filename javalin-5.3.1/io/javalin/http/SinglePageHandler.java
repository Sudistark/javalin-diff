package io.javalin.http;

import io.javalin.http.servlet.JavalinServletContextKt;
import io.javalin.http.staticfiles.Location;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000<\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020%\n\002\020\016\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\030\0002\0020\001:\001\024B\005¢\006\002\020\002J\026\020\t\032\0020\n2\006\020\013\032\0020\0052\006\020\f\032\0020\006J\036\020\t\032\0020\n2\006\020\013\032\0020\0052\006\020\r\032\0020\0052\006\020\016\032\0020\017J\016\020\020\032\0020\0212\006\020\022\032\0020\023R\032\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0060\004X\004¢\006\002\n\000R\032\020\007\032\016\022\004\022\0020\005\022\004\022\0020\b0\004X\004¢\006\002\n\000¨\006\025"}, d2 = {"Lio/javalin/http/SinglePageHandler;", "", "()V", "pathHandlerMap", "", "", "Lio/javalin/http/Handler;", "pathPageMap", "Lio/javalin/http/SinglePageHandler$Page;", "add", "", "hostedPath", "handler", "filePath", "location", "Lio/javalin/http/staticfiles/Location;", "handle", "", "ctx", "Lio/javalin/http/Context;", "Page", "javalin"})
public final class SinglePageHandler {
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000(\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\t\n\002\020\013\n\002\b\004\n\002\020\b\n\002\b\002\b\b\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\t\020\013\032\0020\003HÆ\003J\t\020\f\032\0020\005HÆ\003J\035\020\r\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\005HÆ\001J\023\020\016\032\0020\0172\b\020\020\032\004\030\0010\001HÖ\003J\016\020\021\032\0020\0052\006\020\022\032\0020\017J\t\020\023\032\0020\024HÖ\001J\t\020\025\032\0020\005HÖ\001R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\026"}, d2 = {"Lio/javalin/http/SinglePageHandler$Page;", "", "url", "Ljava/net/URL;", "cachedHtml", "", "(Ljava/net/URL;Ljava/lang/String;)V", "getCachedHtml", "()Ljava/lang/String;", "getUrl", "()Ljava/net/URL;", "component1", "component2", "copy", "equals", "", "other", "getHtml", "reRead", "hashCode", "", "toString", "javalin"})
  public static final class Page {
    @NotNull
    private final URL url;
    
    @NotNull
    private final String cachedHtml;
    
    public Page(@NotNull URL url, @NotNull String cachedHtml) {
      this.url = url;
      this.cachedHtml = cachedHtml;
    }
    
    @NotNull
    public final URL getUrl() {
      return this.url;
    }
    
    @NotNull
    public final String getCachedHtml() {
      return this.cachedHtml;
    }
    
    @NotNull
    public final String getHtml(boolean reRead) {
      URL uRL = this.url;
      Charset charset = Charsets.UTF_8;
      byte[] arrayOfByte = TextStreamsKt.readBytes(uRL);
      return reRead ? new String(arrayOfByte, charset) : this.cachedHtml;
    }
    
    @NotNull
    public final URL component1() {
      return this.url;
    }
    
    @NotNull
    public final String component2() {
      return this.cachedHtml;
    }
    
    @NotNull
    public final Page copy(@NotNull URL url, @NotNull String cachedHtml) {
      Intrinsics.checkNotNullParameter(url, "url");
      Intrinsics.checkNotNullParameter(cachedHtml, "cachedHtml");
      return new Page(url, cachedHtml);
    }
    
    @NotNull
    public String toString() {
      return "Page(url=" + this.url + ", cachedHtml=" + this.cachedHtml + ")";
    }
    
    public int hashCode() {
      result = this.url.hashCode();
      return result * 31 + this.cachedHtml.hashCode();
    }
    
    public boolean equals(@Nullable Object other) {
      if (this == other)
        return true; 
      if (!(other instanceof Page))
        return false; 
      Page page = (Page)other;
      return !Intrinsics.areEqual(this.url, page.url) ? false : (!!Intrinsics.areEqual(this.cachedHtml, page.cachedHtml));
    }
  }
  
  @NotNull
  private final Map<String, Page> pathPageMap = new LinkedHashMap<>();
  
  @NotNull
  private final Map<String, Handler> pathHandlerMap = new LinkedHashMap<>();
  
  public final void add(@NotNull String hostedPath, @NotNull String filePath, @NotNull Location location) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'hostedPath'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 'filePath'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_3
    //   13: ldc 'location'
    //   15: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_3
    //   19: getstatic io/javalin/http/SinglePageHandler$WhenMappings.$EnumSwitchMapping$0 : [I
    //   22: swap
    //   23: invokevirtual ordinal : ()I
    //   26: iaload
    //   27: tableswitch default -> 105, 1 -> 48, 2 -> 79
    //   48: aload_2
    //   49: ldc '/'
    //   51: checkcast java/lang/CharSequence
    //   54: invokestatic removePrefix : (Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   57: invokestatic getResourceUrl : (Ljava/lang/String;)Ljava/net/URL;
    //   60: dup
    //   61: ifnonnull -> 113
    //   64: pop
    //   65: new java/lang/IllegalArgumentException
    //   68: dup
    //   69: aload_2
    //   70: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   75: invokespecial <init> : (Ljava/lang/String;)V
    //   78: athrow
    //   79: getstatic io/javalin/util/Util.INSTANCE : Lio/javalin/util/Util;
    //   82: aload_2
    //   83: invokevirtual getFileUrl : (Ljava/lang/String;)Ljava/net/URL;
    //   86: dup
    //   87: ifnonnull -> 113
    //   90: pop
    //   91: new java/lang/IllegalArgumentException
    //   94: dup
    //   95: aload_2
    //   96: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   101: invokespecial <init> : (Ljava/lang/String;)V
    //   104: athrow
    //   105: new kotlin/NoWhenBranchMatchedException
    //   108: dup
    //   109: invokespecial <init> : ()V
    //   112: athrow
    //   113: astore #4
    //   115: aload_0
    //   116: getfield pathPageMap : Ljava/util/Map;
    //   119: astore #5
    //   121: new io/javalin/http/SinglePageHandler$Page
    //   124: dup
    //   125: aload #4
    //   127: aload #4
    //   129: astore #6
    //   131: getstatic kotlin/text/Charsets.UTF_8 : Ljava/nio/charset/Charset;
    //   134: astore #7
    //   136: aload #6
    //   138: invokestatic readBytes : (Ljava/net/URL;)[B
    //   141: astore #8
    //   143: new java/lang/String
    //   146: dup
    //   147: aload #8
    //   149: aload #7
    //   151: invokespecial <init> : ([BLjava/nio/charset/Charset;)V
    //   154: invokespecial <init> : (Ljava/net/URL;Ljava/lang/String;)V
    //   157: astore #6
    //   159: aload #5
    //   161: aload_1
    //   162: aload #6
    //   164: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   169: pop
    //   170: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #33	-> 18
    //   #34	-> 48
    //   #35	-> 79
    //   #33	-> 113
    //   #37	-> 115
    //   #37	-> 154
    //   #38	-> 170
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   115	56	4	url	Ljava/net/URL;
    //   0	171	0	this	Lio/javalin/http/SinglePageHandler;
    //   0	171	1	hostedPath	Ljava/lang/String;
    //   0	171	2	filePath	Ljava/lang/String;
    //   0	171	3	location	Lio/javalin/http/staticfiles/Location;
  }
  
  public final void add(@NotNull String hostedPath, @NotNull Handler handler) {
    Intrinsics.checkNotNullParameter(hostedPath, "hostedPath");
    Intrinsics.checkNotNullParameter(handler, "handler");
    this.pathHandlerMap.put(hostedPath, handler);
  }
  
  public final boolean handle(@NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    if (ctx.header("Accept") == null)
      ctx.header("Accept"); 
    String accept = "";
    if (!StringsKt.contains$default(accept, "text/html", false, 2, null) && !StringsKt.contains$default(accept, "*/*", false, 2, null) && !Intrinsics.areEqual(accept, ""))
      return false; 
    Page page = (Page)SinglePageHandlerKt.access$findByPath(this.pathPageMap, ctx.path());
    if (page != null) {
      Page page1 = page;
      int $i$a$-let-SinglePageHandler$handle$1 = 0;
      ctx.html(page1.getHtml(JavalinServletContextKt.isLocalhost(ctx)));
      return true;
    } 
    Handler handler = (Handler)SinglePageHandlerKt.access$findByPath(this.pathHandlerMap, ctx.path());
    if (handler != null) {
      Handler handler1 = handler;
      int $i$a$-let-SinglePageHandler$handle$2 = 0;
      handler1.handle(ctx);
      return true;
    } 
    return false;
  }
}
