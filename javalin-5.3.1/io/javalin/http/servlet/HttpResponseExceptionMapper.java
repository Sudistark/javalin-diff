package io.javalin.http.servlet;

import io.javalin.http.ContentType;
import io.javalin.http.Context;
import io.javalin.http.HttpResponseException;
import io.javalin.http.util.JsonEscapeUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0000\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\020\013\n\000\n\002\020\003\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\005\032\0020\0062\006\020\007\032\0020\bJ\020\020\t\032\0020\0042\006\020\n\032\0020\013H\002J\020\020\f\032\0020\0042\006\020\n\032\0020\013H\002J\026\020\r\032\0020\0162\006\020\n\032\0020\0132\006\020\017\032\0020\016J\020\020\020\032\0020\0042\006\020\n\032\0020\013H\002J\020\020\021\032\0020\0042\006\020\n\032\0020\013H\002J\f\020\022\032\0020\004*\0020\004H\002R\016\020\003\032\0020\004XT¢\006\002\n\000¨\006\023"}, d2 = {"Lio/javalin/http/servlet/HttpResponseExceptionMapper;", "", "()V", "docsUrl", "", "canHandle", "", "t", "", "classUrl", "e", "Lio/javalin/http/HttpResponseException;", "getTypeUrl", "handle", "Lio/javalin/http/Context;", "ctx", "jsonResult", "plainResult", "jsonEscape", "javalin"})
public final class HttpResponseExceptionMapper {
  @NotNull
  public static final HttpResponseExceptionMapper INSTANCE = new HttpResponseExceptionMapper();
  
  @NotNull
  private static final String docsUrl = "https://javalin.io/documentation#";
  
  public final boolean canHandle(@NotNull Throwable t) {
    Intrinsics.checkNotNullParameter(t, "t");
    return HttpResponseException.class.isAssignableFrom(t.getClass());
  }
  
  @NotNull
  public final Context handle(@NotNull HttpResponseException e, @NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(e, "e");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    ctx.header("Accept");
    ctx.header("Accept");
    return (((ctx.header("Accept") != null) ? ((StringsKt.contains$default(ctx.header("Accept"), "text/html", false, 2, null) == true)) : false) || Intrinsics.areEqual(ctx.res().getContentType(), "text/html")) ? ctx.status(e.getStatus()).result(plainResult(e)).contentType(ContentType.TEXT_PLAIN) : ((((ctx.header("Accept") != null) ? ((StringsKt.contains$default(ctx.header("Accept"), "application/json", false, 2, null) == true)) : false) || Intrinsics.areEqual(ctx.res().getContentType(), "application/json")) ? ctx.status(e.getStatus()).result(jsonResult(e)).contentType(ContentType.APPLICATION_JSON) : 
      ctx.status(e.getStatus()).result(plainResult(e)).contentType(ContentType.TEXT_PLAIN));
  }
  
  private final String jsonResult(HttpResponseException e) {
    e.getMessage();
    String str1 = getTypeUrl(e);
    Intrinsics.checkNotNullExpressionValue(Locale.ROOT, "ROOT");
    Intrinsics.checkNotNullExpressionValue(str1.toLowerCase(Locale.ROOT), "this as java.lang.String).toLowerCase(locale)");
    Map<String, String> map1 = e.getDetails();
    String str3 = str1.toLowerCase(Locale.ROOT);
    int i = e.getStatus();
    String str2 = (e.getMessage() != null) ? jsonEscape(e.getMessage()) : null;
    int $i$f$map = 0;
    Map<String, String> map2 = map1;
    Collection<String> destination$iv$iv = new ArrayList(map1.size());
    int $i$f$mapTo = 0;
    for (Map.Entry<String, String> item$iv$iv : map2.entrySet()) {
      Map.Entry<String, String> entry1 = item$iv$iv;
      Collection<String> collection = destination$iv$iv;
      int $i$a$-map-HttpResponseExceptionMapper$jsonResult$1 = 0;
      collection.add("\"" + entry1.getKey() + "\":\"" + INSTANCE.jsonEscape((String)entry1.getValue()) + "\"");
    } 
    List list = (List)destination$iv$iv;
    return StringsKt.trimMargin$default("|{\n           |    \"title\": \"" + str2 + "\",\n           |    \"status\": " + i + ",\n           |    \"type\": \"" + str3 + "\",\n           |    \"details\": {" + CollectionsKt.joinToString$default(list, ",", null, null, 0, null, null, 62, null) + "}\n           |}", null, 1, null);
  }
  
  private final String plainResult(HttpResponseException e) {
    Map<String, String> map1 = e.getDetails();
    String str = e.getMessage();
    int $i$f$map = 0;
    Map<String, String> map2 = map1;
    Collection<String> destination$iv$iv = new ArrayList(map1.size());
    int $i$f$mapTo = 0;
    for (Map.Entry<String, String> item$iv$iv : map2.entrySet()) {
      Map.Entry<String, String> entry1 = item$iv$iv;
      Collection<String> collection = destination$iv$iv;
      int $i$a$-map-HttpResponseExceptionMapper$plainResult$1 = 0;
      collection.add("\n" + entry1.getKey() + ":\n" + entry1.getValue());
    } 
    return e.getDetails().isEmpty() ? String.valueOf(e.getMessage()) : StringsKt.trimMargin$default("\n                |" + str + "\n                |" + CollectionsKt.joinToString$default(destination$iv$iv, "", null, null, 0, null, null, 62, null) + "\n                |", null, 1, null);
  }
  
  private final String classUrl(HttpResponseException e) {
    return "https://javalin.io/documentation#" + e.getClass().getSimpleName();
  }
  
  private final String getTypeUrl(HttpResponseException e) {
    HttpResponseException httpResponseException = e;
    return (httpResponseException instanceof io.javalin.http.RedirectResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.BadRequestResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.UnauthorizedResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.ForbiddenResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.NotFoundResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.MethodNotAllowedResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.ConflictResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.GoneResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.InternalServerErrorResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.ServiceUnavailableResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.BadGatewayResponse) ? classUrl(e) : ((httpResponseException instanceof io.javalin.http.GatewayTimeoutResponse) ? classUrl(e) : "https://javalin.io/documentation#error-responses")))))))))));
  }
  
  private final String jsonEscape(String $this$jsonEscape) {
    return JsonEscapeUtil.INSTANCE.escape($this$jsonEscape);
  }
}
