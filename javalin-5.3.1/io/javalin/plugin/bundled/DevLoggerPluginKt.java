package io.javalin.plugin.bundled;

import io.javalin.http.Context;
import io.javalin.http.HandlerType;
import io.javalin.routing.HandlerEntry;
import io.javalin.routing.PathMatcher;
import io.javalin.util.JavalinLogger;
import io.javalin.websocket.WsBinaryMessageContext;
import io.javalin.websocket.WsCloseContext;
import io.javalin.websocket.WsConfig;
import io.javalin.websocket.WsConnectContext;
import io.javalin.websocket.WsContext;
import io.javalin.websocket.WsErrorContext;
import io.javalin.websocket.WsMessageContext;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\0006\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\007\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\000\032\036\020\000\032\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\007\032\020\020\b\032\0020\t2\006\020\004\032\0020\005H\002\032\016\020\n\032\0020\0012\006\020\013\032\0020\f\032\036\020\r\032\0020\001*\0020\0162\006\020\017\032\0020\t2\b\b\002\020\020\032\0020\tH\002\032\f\020\021\032\0020\022*\0020\tH\002¨\006\023"}, d2 = {"requestDevLogger", "", "matcher", "Lio/javalin/routing/PathMatcher;", "ctx", "Lio/javalin/http/Context;", "time", "", "resBody", "", "wsDevLogger", "ws", "Lio/javalin/websocket/WsConfig;", "logEvent", "Lio/javalin/websocket/WsContext;", "event", "additionalInfo", "probablyFormData", "", "javalin"})
public final class DevLoggerPluginKt {
  public static final void requestDevLogger(@NotNull PathMatcher matcher, @NotNull Context ctx, float time) {
    Intrinsics.checkNotNullParameter(matcher, "matcher");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    try {
      String requestUri = ctx.path();
      Context $this$requestDevLogger_u24lambda_u2d3 = ctx;
      int $i$a$-with-DevLoggerPluginKt$requestDevLogger$1 = 0;
      List list1 = CollectionsKt.plus(CollectionsKt.plus(matcher.findEntries(HandlerType.BEFORE, requestUri), 
            matcher.findEntries(ctx.method(), requestUri)), 
          matcher.findEntries(HandlerType.AFTER, requestUri));
      int $i$f$map = 0;
      List list2 = list1;
      Collection<String> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(list1, 10));
      int $i$f$mapTo = 0;
      for (Object item$iv$iv : list2) {
        HandlerEntry handlerEntry = (HandlerEntry)item$iv$iv;
        Collection<String> collection = destination$iv$iv;
        int $i$a$-map-DevLoggerPluginKt$requestDevLogger$1$allMatching$1 = 0;
        collection.add(handlerEntry.getType().name() + "=" + handlerEntry.getType().name());
      } 
      List allMatching = (List)destination$iv$iv;
      Intrinsics.checkNotNullExpressionValue($this$requestDevLogger_u24lambda_u2d3.res().getHeaderNames(), "res().headerNames");
      Map resHeaders = MapsKt.toMap(SequencesKt.map(CollectionsKt.asSequence($this$requestDevLogger_u24lambda_u2d3.res().getHeaderNames()), new DevLoggerPluginKt$requestDevLogger$1$resHeaders$1($this$requestDevLogger_u24lambda_u2d3)));
      Map<String, List<String>> map1 = $this$requestDevLogger_u24lambda_u2d3.queryParamMap();
      String str1 = $this$requestDevLogger_u24lambda_u2d3.queryString(), str2 = $this$requestDevLogger_u24lambda_u2d3.isMultipart() ? "Multipart data ..." : $this$requestDevLogger_u24lambda_u2d3.body();
      Map<String, String> map5 = $this$requestDevLogger_u24lambda_u2d3.cookieMap(), map6 = $this$requestDevLogger_u24lambda_u2d3.headerMap();
      List list3 = allMatching;
      String str3 = $this$requestDevLogger_u24lambda_u2d3.path();
      HandlerType handlerType = $this$requestDevLogger_u24lambda_u2d3.method();
      int $i$f$mapValues = 0;
      Map<String, List<String>> map2 = map1;
      Map<Object, Object> map4 = new LinkedHashMap<>(MapsKt.mapCapacity(map1.size()));
      int $i$f$mapValuesTo = 0;
      Iterable<Map.Entry<String, List<String>>> iterable = map2.entrySet();
      int $i$f$associateByTo = 0;
      for (Object<String, List<String>> element$iv$iv$iv : iterable) {
        Map.Entry entry1 = (Map.Entry)element$iv$iv$iv;
        Map<Object, Object> map9 = map4;
        int $i$a$-associateByTo-MapsKt__MapsKt$mapValuesTo$1$iv$iv = 0;
        Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
        Object object = entry1.getKey();
        Map<Object, Object> map10 = map9;
        int $i$a$-mapValues-DevLoggerPluginKt$requestDevLogger$1$1 = 0;
      } 
      Map<Object, Object> map8 = map4;
      Map $this$mapValues$iv = probablyFormData($this$requestDevLogger_u24lambda_u2d3.body()) ? $this$requestDevLogger_u24lambda_u2d3.formParamMap() : MapsKt.emptyMap();
      map8 = map8;
      str1 = str1;
      str2 = str2;
      map5 = map5;
      map6 = map6;
      list3 = list3;
      str3 = str3;
      handlerType = handlerType;
      $i$f$mapValues = 0;
      Map $this$mapValuesTo$iv$iv = $this$mapValues$iv;
      Map<Object, Object> map3 = new LinkedHashMap<>(MapsKt.mapCapacity($this$mapValues$iv.size()));
      $i$f$mapValuesTo = 0;
      Iterable $this$associateByTo$iv$iv$iv = $this$mapValuesTo$iv$iv.entrySet();
      $i$f$associateByTo = 0;
      for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
        Map.Entry it$iv$iv = (Map.Entry)element$iv$iv$iv;
        Map<Object, Object> map9 = map3;
        int $i$a$-associateByTo-MapsKt__MapsKt$mapValuesTo$1$iv$iv = 0;
        Map.Entry entry1 = (Map.Entry)element$iv$iv$iv;
        Object object1 = it$iv$iv.getKey();
        Map<Object, Object> map10 = map9;
        int $i$a$-mapValues-DevLoggerPluginKt$requestDevLogger$1$2 = 0;
      } 
      Map<Object, Object> map7 = map3;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Float.valueOf(time);
      JavalinLogger.info$default(StringsKt.trimMargin$default("|JAVALIN REQUEST DEBUG LOG:\n               |Request: " + handlerType + " [" + str3 + "]\n               |    Matching endpoint-handlers: " + list3 + "\n               |    Headers: " + map6 + "\n               |    Cookies: " + map5 + "\n               |    Body: " + str2 + "\n               |    QueryString: " + str1 + "\n               |    QueryParams: " + map8 + "\n               |    FormParams: " + map7 + "\n               |Response: [" + $this$requestDevLogger_u24lambda_u2d3.status() + "], execution took " + (new Formatter(Locale.US)).format("%.2f", arrayOfObject) + " ms\n               |    Headers: " + resHeaders + "\n               |    " + resBody(ctx) + "\n               |----------------------------------------------------------------------------------", null, 1, null), null, 2, null);
    } catch (Exception e) {
      JavalinLogger.info("An exception occurred while logging debug-info", e);
    } 
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\030\002\n\002\020\016\n\002\b\003\020\000\032\036\022\f\022\n \003*\004\030\0010\0020\002\022\f\022\n \003*\004\030\0010\0020\0020\0012\016\020\004\032\n \003*\004\030\0010\0020\002H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "it", "invoke"})
  static final class DevLoggerPluginKt$requestDevLogger$1$resHeaders$1 extends Lambda implements Function1<String, Pair<? extends String, ? extends String>> {
    DevLoggerPluginKt$requestDevLogger$1$resHeaders$1(Context $receiver) {
      super(1);
    }
    
    @NotNull
    public final Pair<String, String> invoke(String it) {
      return TuplesKt.to(it, this.$this_with.res().getHeader(it));
    }
  }
  
  private static final boolean probablyFormData(String $this$probablyFormData) {
    StringsKt.firstOrNull(StringsKt.trim($this$probablyFormData).toString());
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "=";
    return (((StringsKt.firstOrNull(StringsKt.trim($this$probablyFormData).toString()) != null) ? ((Character.isLetter(StringsKt.firstOrNull(StringsKt.trim($this$probablyFormData).toString()).charValue()) == true)) : false) && StringsKt.split$default($this$probablyFormData, arrayOfString, false, 0, 6, null).size() >= 2);
  }
  
  private static final String resBody(Context ctx) {
    InputStream stream;
    if (ctx.resultInputStream() == null) {
      ctx.resultInputStream();
      return "No body was set";
    } 
    if (!stream.markSupported())
      return "Body is binary (not logged)"; 
    boolean gzipped = Intrinsics.areEqual(ctx.res().getHeader("Content-Encoding"), "gzip");
    boolean brotlied = Intrinsics.areEqual(ctx.res().getHeader("Content-Encoding"), "br");
    Intrinsics.checkNotNull(ctx.result());
    String resBody = ctx.result();
    return gzipped ? ("Body is gzipped (" + resBody.length() + " bytes, not logged)") : (brotlied ? ("Body is brotlied (" + resBody.length() + " bytes, not logged)") : (StringsKt.contains$default(resBody, "resultString unavailable", false, 2, null) ? "Body is an InputStream which can't be reset, so it can't be logged" : ("Body is " + resBody.length() + " bytes (starts on next line):\n    " + resBody)));
  }
  
  public static final void wsDevLogger(@NotNull WsConfig ws) {
    Intrinsics.checkNotNullParameter(ws, "ws");
    ws.onConnect(DevLoggerPluginKt::wsDevLogger$lambda-4);
    ws.onMessage(DevLoggerPluginKt::wsDevLogger$lambda-5);
    ws.onBinaryMessage(DevLoggerPluginKt::wsDevLogger$lambda-6);
    ws.onClose(DevLoggerPluginKt::wsDevLogger$lambda-7);
    ws.onError(DevLoggerPluginKt::wsDevLogger$lambda-8);
  }
  
  private static final void wsDevLogger$lambda-4(WsConnectContext ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    logEvent$default(ctx, "onConnect", null, 2, null);
  }
  
  private static final void wsDevLogger$lambda-5(WsMessageContext ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    logEvent(ctx, "onMessage", "Message (next line):\n" + ctx.message());
  }
  
  private static final void wsDevLogger$lambda-6(WsBinaryMessageContext ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    logEvent(ctx, "onBinaryMessage", "Offset: " + ctx.offset() + ", Length: " + ctx.length() + "\nMessage (next line):\n" + ctx.data());
  }
  
  private static final void wsDevLogger$lambda-7(WsCloseContext ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    if (ctx.reason() == null)
      ctx.reason(); 
    logEvent((WsContext)"onClose", ctx.status(), "StatusCode: " + ctx.reason() + "\nReason: " + "No reason was provided");
  }
  
  private static final void wsDevLogger$lambda-8(WsErrorContext ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    ctx.error();
    logEvent(ctx, "onError", "Throwable:  " + ((ctx.error() != null) ? (String)ctx.error() : "No throwable was provided"));
  }
  
  private static final void logEvent(WsContext $this$logEvent, String event, String additionalInfo) {
    Map<String, List<String>> map1 = $this$logEvent.queryParamMap();
    Map<String, String> map = $this$logEvent.pathParamMap();
    String str4 = $this$logEvent.matchedPath(), str3 = $this$logEvent.host(), str2 = $this$logEvent.getSessionId(), str1 = event;
    int $i$f$mapValues = 0;
    Map<String, List<String>> map2 = map1;
    Map<Object, Object> destination$iv$iv = new LinkedHashMap<>(MapsKt.mapCapacity(map1.size()));
    int $i$f$mapValuesTo = 0;
    Iterable<Map.Entry<String, List<String>>> $this$associateByTo$iv$iv$iv = map2.entrySet();
    int $i$f$associateByTo = 0;
    for (Object<String, List<String>> element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
      Map.Entry entry1 = (Map.Entry)element$iv$iv$iv;
      Map<Object, Object> map4 = destination$iv$iv;
      int $i$a$-associateByTo-MapsKt__MapsKt$mapValuesTo$1$iv$iv = 0;
      Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
      Object object = entry1.getKey();
      Map<Object, Object> map5 = map4;
      int $i$a$-mapValues-DevLoggerPluginKt$logEvent$1 = 0;
    } 
    Map<Object, Object> map3 = destination$iv$iv;
    JavalinLogger.info$default(StringsKt.trimMargin$default("|JAVALIN WEBSOCKET DEBUG LOG\n           |WebSocket Event: " + str1 + "\n           |Session Id: " + str2 + "\n           |Host: " + str3 + "\n           |Matched Path: " + str4 + "\n           |PathParams: " + map + "\n           |QueryParams: " + (($this$logEvent.queryString() != null) ? map3.toString() : "No query string was provided") + "\n           |" + additionalInfo + "\n           |----------------------------------------------------------------------------------", null, 1, null), null, 2, null);
  }
}
