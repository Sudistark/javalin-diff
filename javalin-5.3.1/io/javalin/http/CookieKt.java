package io.javalin.http;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000$\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\002\030\002\n\002\b\004\032\022\020\002\032\0020\001*\0020\0012\006\020\003\032\0020\004\032\024\020\005\032\004\030\0010\001*\0020\0062\006\020\007\032\0020\001\032\034\020\b\032\0020\t*\0020\n2\006\020\007\032\0020\0012\b\020\013\032\004\030\0010\001\032\022\020\f\032\0020\t*\0020\n2\006\020\r\032\0020\004\"\016\020\000\032\0020\001XT¢\006\002\n\000¨\006\016"}, d2 = {"SAME_SITE", "", "addSameSite", "cookie", "Lio/javalin/http/Cookie;", "getCookie", "Ljakarta/servlet/http/HttpServletRequest;", "name", "removeCookie", "", "Ljakarta/servlet/http/HttpServletResponse;", "path", "setJavalinCookie", "javalinCookie", "javalin"})
public final class CookieKt {
  @NotNull
  public static final String SAME_SITE = "SameSite";
  
  public static final void setJavalinCookie(@NotNull HttpServletResponse $this$setJavalinCookie, @NotNull Cookie javalinCookie) {
    Intrinsics.checkNotNullParameter($this$setJavalinCookie, "<this>");
    Intrinsics.checkNotNullParameter(javalinCookie, "javalinCookie");
    Cookie cookie1 = new Cookie(javalinCookie.getName(), javalinCookie.getValue()), $this$setJavalinCookie_u24lambda_u2d0 = cookie1;
    int $i$a$-apply-CookieKt$setJavalinCookie$cookie$1 = 0;
    $this$setJavalinCookie_u24lambda_u2d0.setPath(javalinCookie.getPath());
    $this$setJavalinCookie_u24lambda_u2d0.setMaxAge(javalinCookie.getMaxAge());
    $this$setJavalinCookie_u24lambda_u2d0.setSecure(javalinCookie.getSecure());
    $this$setJavalinCookie_u24lambda_u2d0.setVersion(javalinCookie.getVersion());
    $this$setJavalinCookie_u24lambda_u2d0.setHttpOnly(javalinCookie.isHttpOnly());
    $this$setJavalinCookie_u24lambda_u2d0.setComment(javalinCookie.getComment());
    if (javalinCookie.getDomain() != null)
      $this$setJavalinCookie_u24lambda_u2d0.setDomain(javalinCookie.getDomain()); 
    Cookie cookie = cookie1;
    $this$setJavalinCookie.addCookie(cookie);
    Collection collection = $this$setJavalinCookie.getHeaders("Set-Cookie");
    List cookies = CollectionsKt.toMutableList((collection == null) ? CollectionsKt.emptyList() : collection);
    int $i$a$-let-CookieKt$setJavalinCookie$1 = 0;
    cookies.removeIf(cookie::setJavalinCookie$lambda-4$lambda-1);
    String str = (String)CollectionsKt.removeFirst(cookies);
    if (str != null) {
      Intrinsics.checkNotNullExpressionValue(str, "removeFirst()");
      String first = str;
      int $i$a$-let-CookieKt$setJavalinCookie$1$2 = 0;
      $this$setJavalinCookie.setHeader("Set-Cookie", addSameSite(first, javalinCookie));
    } else {
    
    } 
    Iterable $this$forEach$iv = cookies;
    int $i$f$forEach = 0;
    for (Object element$iv : $this$forEach$iv) {
      String remaining = (String)element$iv;
      int $i$a$-forEach-CookieKt$setJavalinCookie$1$3 = 0;
      Intrinsics.checkNotNullExpressionValue(remaining, "remaining");
      $this$setJavalinCookie.addHeader("Set-Cookie", addSameSite(remaining, javalinCookie));
    } 
  }
  
  private static final boolean setJavalinCookie$lambda-4$lambda-1(Cookie $cookie, String it) {
    Intrinsics.checkNotNullParameter($cookie, "$cookie");
    Intrinsics.checkNotNullExpressionValue(it, "it");
    Intrinsics.checkNotNullExpressionValue($cookie.getValue(), "cookie.value");
    return (StringsKt.startsWith$default(it, $cookie.getName() + "=", false, 2, null) && !StringsKt.contains$default(it, $cookie.getValue(), false, 2, null));
  }
  
  public static final void removeCookie(@NotNull HttpServletResponse $this$removeCookie, @NotNull String name, @Nullable String path) {
    Intrinsics.checkNotNullParameter($this$removeCookie, "<this>");
    Intrinsics.checkNotNullParameter(name, "name");
    Cookie cookie1 = new Cookie(name, ""), cookie2 = cookie1;
    HttpServletResponse httpServletResponse = $this$removeCookie;
    int $i$a$-apply-CookieKt$removeCookie$1 = 0;
    cookie2.setPath(path);
    cookie2.setMaxAge(0);
    httpServletResponse.addCookie(cookie1);
  }
  
  @Nullable
  public static final String getCookie(@NotNull HttpServletRequest $this$getCookie, @NotNull String name) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '<this>'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'name'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: invokeinterface getCookies : ()[Ljakarta/servlet/http/Cookie;
    //   18: dup
    //   19: ifnull -> 81
    //   22: astore_2
    //   23: iconst_0
    //   24: istore_3
    //   25: aload_2
    //   26: arraylength
    //   27: istore #4
    //   29: iload_3
    //   30: iload #4
    //   32: if_icmpge -> 70
    //   35: aload_2
    //   36: iload_3
    //   37: aaload
    //   38: astore #5
    //   40: aload #5
    //   42: astore #6
    //   44: iconst_0
    //   45: istore #7
    //   47: aload #6
    //   49: invokevirtual getName : ()Ljava/lang/String;
    //   52: aload_1
    //   53: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   56: ifeq -> 64
    //   59: aload #5
    //   61: goto -> 71
    //   64: iinc #3, 1
    //   67: goto -> 29
    //   70: aconst_null
    //   71: dup
    //   72: ifnull -> 81
    //   75: invokevirtual getValue : ()Ljava/lang/String;
    //   78: goto -> 83
    //   81: pop
    //   82: aconst_null
    //   83: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #60	-> 12
    //   #67	-> 44
    //   #60	-> 47
    //   #60	-> 56
    //   #60	-> 71
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   47	9	7	$i$a$-find-CookieKt$getCookie$1	I
    //   44	12	6	it	Ljakarta/servlet/http/Cookie;
    //   0	84	0	$this$getCookie	Ljakarta/servlet/http/HttpServletRequest;
    //   0	84	1	name	Ljava/lang/String;
  }
  
  @NotNull
  public static final String addSameSite(@NotNull String $this$addSameSite, @NotNull Cookie cookie) {
    Intrinsics.checkNotNullParameter($this$addSameSite, "<this>");
    Intrinsics.checkNotNullParameter(cookie, "cookie");
    if (cookie.getSameSite() == null || StringsKt.contains$default($this$addSameSite, "SameSite", false, 2, null))
      return $this$addSameSite; 
    return $this$addSameSite + "; " + $this$addSameSite;
  }
}
