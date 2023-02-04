package io.javalin.http.servlet;

import io.javalin.http.Context;
import io.javalin.http.HttpResponseException;
import io.javalin.http.HttpStatus;
import io.javalin.security.BasicAuthCredentials;
import io.javalin.util.JavalinLogger;
import jakarta.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000X\n\000\n\002\020\016\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020$\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\b\006\032\016\020\003\032\0020\0042\006\020\005\032\0020\006\0327\020\007\032\004\030\001H\b\"\004\b\000\020\b2\022\020\t\032\016\022\004\022\0020\006\022\004\022\002H\b0\n2\006\020\013\032\0020\0012\006\020\005\032\0020\006¢\006\002\020\f\032 \020\r\032\0020\0162\006\020\013\032\0020\0012\b\020\017\032\004\030\0010\0202\006\020\021\032\0020\022\0327\020\023\032\004\030\001H\b\"\004\b\000\020\b2\022\020\t\032\016\022\004\022\0020\006\022\004\022\002H\b0\n2\006\020\013\032\0020\0012\006\020\005\032\0020\006¢\006\002\020\f\032\022\020\024\032\004\030\0010\0252\b\020\026\032\004\030\0010\001\032#\020\027\032\004\030\001H\b\"\004\b\000\020\b2\006\020\013\032\0020\0012\006\020\021\032\0020\022¢\006\002\020\030\032\020\020\031\032\004\030\0010\0012\006\020\005\032\0020\006\032,\020\032\032\0020\0012\024\020\033\032\020\022\004\022\0020\001\022\006\022\004\030\0010\0010\0342\006\020\013\032\0020\0012\006\020\035\032\0020\001\032\032\020\036\032\004\030\0010\0012\b\020\037\032\004\030\0010 2\006\020!\032\0020\"\032(\020#\032\024\022\004\022\0020\001\022\n\022\b\022\004\022\0020\0010$0\0342\006\020%\032\0020\0012\006\020!\032\0020\001\032\016\020&\032\0020\0012\006\020'\032\0020\001\032\n\020(\032\0020\004*\0020\006\032\n\020)\032\0020\016*\0020\006\"\016\020\000\032\0020\001XT¢\006\002\n\000\"\016\020\002\032\0020\001XT¢\006\002\n\000¨\006*"}, d2 = {"MAX_REQUEST_SIZE_KEY", "", "SESSION_CACHE_KEY_PREFIX", "acceptsHtml", "", "ctx", "Lio/javalin/http/Context;", "attributeOrCompute", "T", "callback", "Lkotlin/Function1;", "key", "(Lkotlin/jvm/functions/Function1;Ljava/lang/String;Lio/javalin/http/Context;)Ljava/lang/Object;", "cacheAndSetSessionAttribute", "", "value", "", "req", "Ljakarta/servlet/http/HttpServletRequest;", "cachedSessionAttributeOrCompute", "getBasicAuthCredentials", "Lio/javalin/security/BasicAuthCredentials;", "authorizationHeader", "getCachedRequestAttributeOrSessionAttribute", "(Ljava/lang/String;Ljakarta/servlet/http/HttpServletRequest;)Ljava/lang/Object;", "getRequestCharset", "pathParamOrThrow", "pathParams", "", "url", "readAndResetStreamIfPossible", "stream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "splitKeyValueStringAndGroupByKey", "", "string", "urlDecode", "s", "isLocalhost", "throwContentTooLargeIfContentTooLarge", "javalin"})
public final class JavalinServletContextKt {
  @NotNull
  public static final String MAX_REQUEST_SIZE_KEY = "javalin-max-request-size";
  
  @NotNull
  public static final String SESSION_CACHE_KEY_PREFIX = "javalin-session-attribute-cache-";
  
  @Nullable
  public static final String getRequestCharset(@NotNull Context ctx) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'ctx'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokeinterface req : ()Ljakarta/servlet/http/HttpServletRequest;
    //   12: ldc 'Content-Type'
    //   14: invokeinterface getHeader : (Ljava/lang/String;)Ljava/lang/String;
    //   19: dup
    //   20: ifnull -> 184
    //   23: astore_1
    //   24: iconst_0
    //   25: istore_2
    //   26: aload_1
    //   27: checkcast java/lang/CharSequence
    //   30: iconst_1
    //   31: anewarray java/lang/String
    //   34: astore_3
    //   35: aload_3
    //   36: iconst_0
    //   37: ldc ';'
    //   39: aastore
    //   40: aload_3
    //   41: iconst_0
    //   42: iconst_0
    //   43: bipush #6
    //   45: aconst_null
    //   46: invokestatic split$default : (Ljava/lang/CharSequence;[Ljava/lang/String;ZIILjava/lang/Object;)Ljava/util/List;
    //   49: checkcast java/lang/Iterable
    //   52: astore #4
    //   54: aload #4
    //   56: invokeinterface iterator : ()Ljava/util/Iterator;
    //   61: astore #5
    //   63: aload #5
    //   65: invokeinterface hasNext : ()Z
    //   70: ifeq -> 117
    //   73: aload #5
    //   75: invokeinterface next : ()Ljava/lang/Object;
    //   80: astore #6
    //   82: aload #6
    //   84: checkcast java/lang/String
    //   87: astore #7
    //   89: iconst_0
    //   90: istore #8
    //   92: aload #7
    //   94: checkcast java/lang/CharSequence
    //   97: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   100: invokevirtual toString : ()Ljava/lang/String;
    //   103: ldc 'charset'
    //   105: iconst_1
    //   106: invokestatic startsWith : (Ljava/lang/String;Ljava/lang/String;Z)Z
    //   109: ifeq -> 63
    //   112: aload #6
    //   114: goto -> 118
    //   117: aconst_null
    //   118: checkcast java/lang/String
    //   121: dup
    //   122: ifnull -> 179
    //   125: astore #4
    //   127: iconst_0
    //   128: istore #5
    //   130: aload #4
    //   132: checkcast java/lang/CharSequence
    //   135: iconst_1
    //   136: anewarray java/lang/String
    //   139: astore #6
    //   141: aload #6
    //   143: iconst_0
    //   144: ldc '='
    //   146: aastore
    //   147: aload #6
    //   149: iconst_0
    //   150: iconst_0
    //   151: bipush #6
    //   153: aconst_null
    //   154: invokestatic split$default : (Ljava/lang/CharSequence;[Ljava/lang/String;ZIILjava/lang/Object;)Ljava/util/List;
    //   157: iconst_1
    //   158: invokeinterface get : (I)Ljava/lang/Object;
    //   163: checkcast java/lang/String
    //   166: checkcast java/lang/CharSequence
    //   169: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   172: invokevirtual toString : ()Ljava/lang/String;
    //   175: nop
    //   176: goto -> 181
    //   179: pop
    //   180: aconst_null
    //   181: goto -> 186
    //   184: pop
    //   185: aconst_null
    //   186: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #136	-> 6
    //   #137	-> 26
    //   #218	-> 89
    //   #137	-> 92
    //   #137	-> 103
    //   #137	-> 109
    //   #137	-> 118
    //   #218	-> 127
    //   #137	-> 130
    //   #137	-> 175
    //   #137	-> 176
    //   #137	-> 179
    //   #136	-> 181
    //   #136	-> 184
    //   #138	-> 186
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   92	17	8	$i$a$-find-JavalinServletContextKt$getRequestCharset$1$1	I
    //   89	20	7	it	Ljava/lang/String;
    //   130	46	5	$i$a$-let-JavalinServletContextKt$getRequestCharset$1$2	I
    //   127	49	4	it	Ljava/lang/String;
    //   26	155	2	$i$a$-let-JavalinServletContextKt$getRequestCharset$1	I
    //   24	157	1	value	Ljava/lang/String;
    //   0	187	0	ctx	Lio/javalin/http/Context;
  }
  
  @NotNull
  public static final Map<String, List<String>> splitKeyValueStringAndGroupByKey(@NotNull String string, @NotNull String charset) {
    Intrinsics.checkNotNullParameter(string, "string");
    Intrinsics.checkNotNullParameter(charset, "charset");
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "&";
    Iterable $this$map$iv = StringsKt.split$default(string, arrayOfString, false, 0, 6, null);
    int $i$f$map = 0;
    Iterable iterable1 = $this$map$iv;
    Collection<List> collection = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : iterable1) {
      String str = (String)item$iv$iv;
      Collection<List> collection1 = collection;
      int $i$a$-map-JavalinServletContextKt$splitKeyValueStringAndGroupByKey$1 = 0;
      String[] arrayOfString1 = new String[1];
      arrayOfString1[0] = "=";
      collection1.add(StringsKt.split$default(str, arrayOfString1, false, 2, 2, null));
    } 
    $this$map$iv = collection;
    int $i$f$groupBy = 0;
    Iterable $this$mapTo$iv$iv = $this$map$iv;
    Map<Object, Object> map3 = new LinkedHashMap<>();
    int $i$f$groupByTo = 0;
    for (Object element$iv$iv : $this$mapTo$iv$iv) {
      List<String> it = (List)element$iv$iv;
      int $i$a$-groupBy-JavalinServletContextKt$splitKeyValueStringAndGroupByKey$2 = 0;
      Object key$iv$iv = URLDecoder.decode(it.get(0), charset);
      Map<Object, Object> $this$getOrPut$iv$iv$iv = map3;
      int $i$f$getOrPut = 0;
      Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
    } 
    Map<Object, Object> map1 = map3;
    int $i$f$mapValues = 0;
    Map<Object, Object> map2 = map1, destination$iv$iv = new LinkedHashMap<>(MapsKt.mapCapacity(map1.size()));
    int $i$f$mapValuesTo = 0;
    Iterable<Map.Entry<Object, Object>> $this$associateByTo$iv$iv$iv = map2.entrySet();
    int $i$f$associateByTo = 0;
    for (Object<Object, Object> element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
      Map.Entry entry1 = (Map.Entry)element$iv$iv$iv;
      Map<Object, Object> map4 = destination$iv$iv;
      int $i$a$-associateByTo-MapsKt__MapsKt$mapValuesTo$1$iv$iv = 0;
      Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
      Object object = entry1.getKey();
      Map<Object, Object> map5 = map4;
      int $i$a$-mapValues-JavalinServletContextKt$splitKeyValueStringAndGroupByKey$4 = 0;
    } 
    return ((((CharSequence)string).length() == 0)) ? MapsKt.emptyMap() : (Map)destination$iv$iv;
  }
  
  @NotNull
  public static final String pathParamOrThrow(@NotNull Map pathParams, @NotNull String key, @NotNull String url) {
    Intrinsics.checkNotNullParameter(pathParams, "pathParams");
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(url, "url");
    if ((String)pathParams.get(StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(key, "{", "", false, 4, null), "}", "", false, 4, null)) == null) {
      (String)pathParams.get(StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(key, "{", "", false, 4, null), "}", "", false, 4, null));
      throw new IllegalArgumentException("'" + key + "' is not a valid path-param for '" + url + "'.");
    } 
    return (String)pathParams.get(StringsKt.replaceFirst$default(StringsKt.replaceFirst$default(key, "{", "", false, 4, null), "}", "", false, 4, null));
  }
  
  @NotNull
  public static final String urlDecode(@NotNull String s) {
    Intrinsics.checkNotNullParameter(s, "s");
    Intrinsics.checkNotNullExpressionValue(URLDecoder.decode(StringsKt.replace$default(s, "+", "%2B", false, 4, null), "UTF-8"), "decode(s.replace(\"+\", \"%2B\"), \"UTF-8\")");
    return StringsKt.replace$default(URLDecoder.decode(StringsKt.replace$default(s, "+", "%2B", false, 4, null), "UTF-8"), "%2B", "+", false, 4, null);
  }
  
  @Nullable
  public static final BasicAuthCredentials getBasicAuthCredentials(@Nullable String authorizationHeader) {
    if (authorizationHeader != null) {
      String str2 = authorizationHeader;
      String it = str2;
      int $i$a$-takeIf-JavalinServletContextKt$getBasicAuthCredentials$1 = 0;
      String str1 = StringsKt.startsWith$default(authorizationHeader, "Basic ", false, 2, null) ? str2 : null;
      if (str1 != null) {
        str2 = StringsKt.removePrefix(str1, "Basic ");
        if (str2 != null) {
          String str = str2;
          int $i$a$-let-JavalinServletContextKt$getBasicAuthCredentials$2 = 0;
          Intrinsics.checkNotNullExpressionValue(Base64.getDecoder().decode(str), "getDecoder().decode(it)");
          it = StringsKt.decodeToString(Base64.getDecoder().decode(str));
          if (it != null) {
            char[] arrayOfChar = new char[1];
            arrayOfChar[0] = ':';
            List<String> list = StringsKt.split$default(it, arrayOfChar, false, 2, 2, null);
            if (list != null) {
              List<String> list1 = list;
              int $i$a$-let-JavalinServletContextKt$getBasicAuthCredentials$3 = 0;
              String username = list1.get(0), password = list1.get(1);
            } 
          } 
        } 
      } 
    } 
    return null;
  }
  
  public static final boolean acceptsHtml(@NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    ctx.header("Accept");
    return (ctx.header("Accept") != null) ? ((StringsKt.contains$default(ctx.header("Accept"), "text/html", false, 2, null) == true)) : false;
  }
  
  public static final boolean isLocalhost(@NotNull Context $this$isLocalhost) {
    boolean bool;
    Intrinsics.checkNotNullParameter($this$isLocalhost, "<this>");
    try {
      String it = (new URL($this$isLocalhost.url())).getHost();
      int $i$a$-let-JavalinServletContextKt$isLocalhost$1 = 0;
      bool = (Intrinsics.areEqual(it, "localhost") || Intrinsics.areEqual(it, "127.0.0.1")) ? true : false;
    } catch (Exception e) {
      bool = false;
    } 
    return bool;
  }
  
  public static final void throwContentTooLargeIfContentTooLarge(@NotNull Context $this$throwContentTooLargeIfContentTooLarge) {
    Intrinsics.checkNotNullParameter($this$throwContentTooLargeIfContentTooLarge, "<this>");
    long maxRequestSize = ((Number)$this$throwContentTooLargeIfContentTooLarge.<Number>appAttribute("javalin-max-request-size")).longValue();
    if ($this$throwContentTooLargeIfContentTooLarge.req().getContentLength() > maxRequestSize) {
      JavalinLogger.warn$default("Body greater than max size (" + maxRequestSize + " bytes)", null, 2, null);
      throw new HttpResponseException(HttpStatus.CONTENT_TOO_LARGE, HttpStatus.CONTENT_TOO_LARGE.getMessage(), null, 4, null);
    } 
  }
  
  public static final void cacheAndSetSessionAttribute(@NotNull String key, @Nullable Object value, @NotNull HttpServletRequest req) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(req, "req");
    req.setAttribute("javalin-session-attribute-cache-" + key, value);
    req.getSession().setAttribute(key, value);
  }
  
  @Nullable
  public static final <T> T getCachedRequestAttributeOrSessionAttribute(@NotNull String key, @NotNull HttpServletRequest req) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(req, "req");
    Object cachedAttribute = req.getAttribute("javalin-session-attribute-cache-" + key);
    if (cachedAttribute == null)
      req.setAttribute("javalin-session-attribute-cache-" + key, req.getSession().getAttribute(key)); 
    return (T)req.getAttribute("javalin-session-attribute-cache-" + key);
  }
  
  @Nullable
  public static final <T> T cachedSessionAttributeOrCompute(@NotNull Function1 callback, @NotNull String key, @NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(callback, "callback");
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    if (getCachedRequestAttributeOrSessionAttribute(key, ctx.req()) == null)
      cacheAndSetSessionAttribute(key, callback.invoke(ctx), ctx.req()); 
    return getCachedRequestAttributeOrSessionAttribute(key, ctx.req());
  }
  
  @Nullable
  public static final <T> T attributeOrCompute(@NotNull Function1 callback, @NotNull String key, @NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(callback, "callback");
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    if (ctx.attribute(key) == null)
      ctx.attribute(key, callback.invoke(ctx)); 
    return ctx.attribute(key);
  }
  
  @Nullable
  public static final String readAndResetStreamIfPossible(@Nullable InputStream stream, @NotNull Charset charset) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'charset'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: nop
    //   7: aload_0
    //   8: ifnull -> 45
    //   11: aload_0
    //   12: astore_3
    //   13: aload_3
    //   14: astore #4
    //   16: iconst_0
    //   17: istore #5
    //   19: aload #4
    //   21: invokevirtual reset : ()V
    //   24: aload_3
    //   25: invokestatic readBytes : (Ljava/io/InputStream;)[B
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 45
    //   33: new java/lang/String
    //   36: dup
    //   37: aload_3
    //   38: aload_1
    //   39: invokespecial <init> : ([BLjava/nio/charset/Charset;)V
    //   42: goto -> 46
    //   45: aconst_null
    //   46: astore_2
    //   47: aload_2
    //   48: astore_3
    //   49: iconst_0
    //   50: istore #4
    //   52: aload_0
    //   53: dup
    //   54: ifnull -> 63
    //   57: invokevirtual reset : ()V
    //   60: goto -> 64
    //   63: pop
    //   64: aload_2
    //   65: astore_2
    //   66: goto -> 74
    //   69: astore_3
    //   70: ldc_w 'resultString unavailable (resultStream couldn't be reset)'
    //   73: astore_2
    //   74: aload_2
    //   75: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #212	-> 6
    //   #213	-> 7
    //   #218	-> 16
    //   #213	-> 19
    //   #213	-> 24
    //   #213	-> 25
    //   #213	-> 45
    //   #218	-> 49
    //   #213	-> 52
    //   #213	-> 64
    //   #214	-> 69
    //   #215	-> 70
    //   #216	-> 75
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   19	5	5	$i$a$-apply-JavalinServletContextKt$readAndResetStreamIfPossible$1	I
    //   16	8	4	$this$readAndResetStreamIfPossible_u24lambda_u2d11	Ljava/io/InputStream;
    //   52	12	4	$i$a$-also-JavalinServletContextKt$readAndResetStreamIfPossible$2	I
    //   49	15	3	it	Ljava/lang/String;
    //   70	4	3	e	Ljava/lang/Exception;
    //   0	76	0	stream	Ljava/io/InputStream;
    //   0	76	1	charset	Ljava/nio/charset/Charset;
    // Exception table:
    //   from	to	target	type
    //   6	66	69	java/lang/Exception
  }
}
