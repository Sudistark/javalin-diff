package io.javalin.plugin.bundled;

import io.javalin.event.HandlerMetaInfo;
import io.javalin.event.WsHandlerMetaInfo;
import io.javalin.http.HandlerType;
import io.javalin.security.RouteRole;
import io.javalin.websocket.WsHandlerType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\006\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J$\020\t\032\0020\0042\f\020\n\032\b\022\004\022\0020\f0\0132\f\020\r\032\b\022\004\022\0020\0160\013H\007J$\020\017\032\0020\0042\f\020\n\032\b\022\004\022\0020\f0\0132\f\020\r\032\b\022\004\022\0020\0160\013H\007R\036\020\003\032\0020\004*\0020\0018FX\004¢\006\f\022\004\b\005\020\006\032\004\b\007\020\b¨\006\020"}, d2 = {"Lio/javalin/plugin/bundled/RouteOverviewUtil;", "", "()V", "metaInfo", "", "getMetaInfo$annotations", "(Ljava/lang/Object;)V", "getMetaInfo", "(Ljava/lang/Object;)Ljava/lang/String;", "createHtmlOverview", "handlerInfo", "", "Lio/javalin/event/HandlerMetaInfo;", "wsHandlerInfo", "Lio/javalin/event/WsHandlerMetaInfo;", "createJsonOverview", "javalin"})
public final class RouteOverviewUtil {
  @NotNull
  public static final RouteOverviewUtil INSTANCE = new RouteOverviewUtil();
  
  @JvmStatic
  @NotNull
  public static final String createHtmlOverview(@NotNull List handlerInfo, @NotNull List wsHandlerInfo) {
    Intrinsics.checkNotNullParameter(handlerInfo, "handlerInfo");
    Intrinsics.checkNotNullParameter(wsHandlerInfo, "wsHandlerInfo");
    Iterable $this$map$iv = handlerInfo;
    int $i$f$map = 0;
    Iterable iterable1 = $this$map$iv;
    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : iterable1) {
      HandlerMetaInfo handlerMetaInfo = (HandlerMetaInfo)item$iv$iv;
      Collection collection = destination$iv$iv;
      int $i$a$-map-RouteOverviewUtil$createHtmlOverview$1 = 0;
      HandlerType handlerType = handlerMetaInfo.component1();
      String path = handlerMetaInfo.component2();
      Object handler = handlerMetaInfo.component3();
      Set<RouteRole> roles = handlerMetaInfo.component4();
    } 
    $this$map$iv = wsHandlerInfo;
    String str = CollectionsKt.joinToString$default(destination$iv$iv, "", null, null, 0, null, null, 62, null);
    $i$f$map = 0;
    Iterable $this$mapTo$iv$iv = $this$map$iv;
    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
    $i$f$mapTo = 0;
    for (Object item$iv$iv : $this$mapTo$iv$iv) {
      WsHandlerMetaInfo wsHandlerMetaInfo = (WsHandlerMetaInfo)item$iv$iv;
      Collection collection = destination$iv$iv;
      int $i$a$-map-RouteOverviewUtil$createHtmlOverview$2 = 0;
      WsHandlerType wsHandlerType = wsHandlerMetaInfo.component1();
      String path = wsHandlerMetaInfo.component2();
      Object handler = wsHandlerMetaInfo.component3();
      Set<RouteRole> roles = wsHandlerMetaInfo.component4();
    } 
    return "\n        <meta name='viewport' content='width=device-width, initial-scale=1'>\n        <style>\n            * {\n                box-sizing: border-box;\n            }\n            b, thead {\n                font-weight: 700;\n            }\n            html {\n                background: #363e4c;\n            }\n            body {\n                font-family: monospace;\n                padding: 25px;\n            }\n            table {\n                background: #fff;\n                border-spacing: 0;\n                font-size: 14px;\n                width: 100%;\n                white-space: pre;\n                box-shadow: 0 5px 25px rgba(0,0,0,0.25);\n            }\n            thead {\n                background: #1a202b;\n                color: #fff;\n            }\n            thead td {\n                border-bottom: 2px solid #000;\n                cursor: pointer;\n            }\n            tr + tr td {\n                border-top: 1px solid rgba(0, 0, 0, 0.25);\n            }\n            tr + tr td:first-of-type {\n                border-top: 1px solid rgba(0, 0, 0, 0.35);\n            }\n            td {\n                padding: 10px 15px;\n            }\n            tbody td:not(:first-of-type) {\n                background-color: rgba(255,255,255,0.925);\n            }\n            tbody tr:hover td:not(:first-of-type) {\n                background-color: rgba(255,255,255,0.85);\n            }\n            .method td:first-of-type {\n                text-align: center;\n                max-width: 90px;\n            }\n            tbody .method td:first-of-type {\n                font-weight: 700;\n                color: #fff;\n                text-shadow: 1px 1px 0px rgba(0,0,0,0.5);\n                border-left: 6px solid rgba(0, 0, 0, 0.35);\n                border-right: 1px solid rgba(0, 0, 0, 0.15);\n            }\n            .GET {\n                background: #5a76ff;\n            }\n            .POST {\n                background: #5dca5d;\n            }\n            .PUT {\n                background: #d9cc00;\n            }\n            .PATCH {\n                background: #ef9a00;\n            }\n            .DELETE {\n                background: #e44848;\n            }\n            .HEAD, .TRACE, .OPTIONS, .CONNECT  {\n                background: #00b9b9;\n            }\n            .BEFORE, .AFTER {\n                background: #777;\n            }\n            .WEBSOCKET, .WS_BEFORE, .WS_AFTER {\n                background: #546E7A;\n            }\n        </style>\n        <body>\n            <table>\n                <thead>\n                    <tr class=\"method\">\n                        <td width=\"105px\">Method</td>\n                        <td>Path</td>\n                        <td>Handler</td>\n                        <td>Roles</td>\n                    </tr>\n                </thead>\n                " + str + "\n                " + CollectionsKt.joinToString$default(destination$iv$iv, "", null, null, 0, null, null, 62, null) + "\n            </table>\n            <script>\n                const cachedRows = Array.from(document.querySelectorAll(\"tbody tr\"));\n                const verbOrder = [\"BEFORE\", \"GET\", \"POST\", \"PUT\", \"PATCH\", \"DELETE\", \"CONNECT\", \"OPTIONS\", \"TRACE\", \"HEAD\", \"AFTER\", \"WS_BEFORE\", \"WEBSOCKET\", \"WS_AFTER\"];\n                document.querySelector(\"thead\").addEventListener(\"click\", function (e) {\n                    cachedRows.map(function (el) {\n                        return {key: el.children[e.target.cellIndex].textContent, row: el};\n                    }).sort((a, b) => {\n                        if (e.target.textContent === \"Method\") {\n                            return verbOrder.indexOf(a.key) - verbOrder.indexOf(b.key);\n                        }\n                        return a.key.localeCompare(b.key);\n                    }).forEach((pair, i) => {\n                        document.querySelector(\"tbody\").children[i].outerHTML = pair.row.outerHTML\n                    });\n                });\n            </script>\n        </body>\n    ";
  }
  
  @JvmStatic
  @NotNull
  public static final String createJsonOverview(@NotNull List handlerInfo, @NotNull List wsHandlerInfo) {
    Intrinsics.checkNotNullParameter(handlerInfo, "handlerInfo");
    Intrinsics.checkNotNullParameter(wsHandlerInfo, "wsHandlerInfo");
    Iterable $this$map$iv = handlerInfo;
    int $i$f$map = 0;
    Iterable iterable1 = $this$map$iv;
    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : iterable1) {
      HandlerMetaInfo handlerMetaInfo = (HandlerMetaInfo)item$iv$iv;
      Collection collection = destination$iv$iv;
      int $i$a$-map-RouteOverviewUtil$createJsonOverview$1 = 0;
      HandlerType handlerType = handlerMetaInfo.component1();
      String path = handlerMetaInfo.component2();
      Object handler = handlerMetaInfo.component3();
      Set<RouteRole> roles = handlerMetaInfo.component4();
    } 
    $this$map$iv = wsHandlerInfo;
    String str = CollectionsKt.joinToString$default(destination$iv$iv, ",", null, null, 0, null, null, 62, null);
    $i$f$map = 0;
    Iterable $this$mapTo$iv$iv = $this$map$iv;
    destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
    $i$f$mapTo = 0;
    for (Object item$iv$iv : $this$mapTo$iv$iv) {
      WsHandlerMetaInfo wsHandlerMetaInfo = (WsHandlerMetaInfo)item$iv$iv;
      Collection collection = destination$iv$iv;
      int $i$a$-map-RouteOverviewUtil$createJsonOverview$2 = 0;
      WsHandlerType wsHandlerType = wsHandlerMetaInfo.component1();
      String path = wsHandlerMetaInfo.component2();
      Object handler = wsHandlerMetaInfo.component3();
      Set<RouteRole> roles = wsHandlerMetaInfo.component4();
    } 
    return "\n            {\n                \"handlers\": [\n                " + str + "\n                ],\n                \"wsHandlers\": [\n                " + CollectionsKt.joinToString$default(destination$iv$iv, ",", null, null, 0, null, null, 62, null) + "\n                ]\n            }\n    ";
  }
  
  @NotNull
  public static final String getMetaInfo(@NotNull Object $this$metaInfo) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '<this>'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: nop
    //   7: aload_0
    //   8: invokestatic isClass : (Ljava/lang/Object;)Z
    //   11: ifeq -> 29
    //   14: aload_0
    //   15: checkcast java/lang/Class
    //   18: invokevirtual getName : ()Ljava/lang/String;
    //   21: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   26: goto -> 335
    //   29: aload_0
    //   30: invokestatic isKotlinMethodReference : (Ljava/lang/Object;)Z
    //   33: ifeq -> 230
    //   36: aload_0
    //   37: invokevirtual getClass : ()Ljava/lang/Class;
    //   40: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
    //   43: dup
    //   44: ldc 'this.javaClass.declaredFields'
    //   46: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   49: checkcast [Ljava/lang/Object;
    //   52: astore_3
    //   53: iconst_0
    //   54: istore #4
    //   56: aload_3
    //   57: arraylength
    //   58: istore #5
    //   60: iload #4
    //   62: iload #5
    //   64: if_icmpge -> 128
    //   67: aload_3
    //   68: iload #4
    //   70: aaload
    //   71: astore #6
    //   73: aload #6
    //   75: checkcast java/lang/reflect/Field
    //   78: astore #7
    //   80: iconst_0
    //   81: istore #8
    //   83: aload #7
    //   85: invokevirtual getName : ()Ljava/lang/String;
    //   88: ldc 'function'
    //   90: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   93: ifne -> 109
    //   96: aload #7
    //   98: invokevirtual getName : ()Ljava/lang/String;
    //   101: ldc '$tmp0'
    //   103: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   106: ifeq -> 113
    //   109: iconst_1
    //   110: goto -> 114
    //   113: iconst_0
    //   114: ifeq -> 122
    //   117: aload #6
    //   119: goto -> 129
    //   122: iinc #4, 1
    //   125: goto -> 60
    //   128: aconst_null
    //   129: dup
    //   130: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   133: checkcast java/lang/reflect/Field
    //   136: invokevirtual getName : ()Ljava/lang/String;
    //   139: astore_1
    //   140: aload_0
    //   141: invokevirtual getClass : ()Ljava/lang/Class;
    //   144: aload_1
    //   145: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   148: astore_3
    //   149: aload_3
    //   150: astore #4
    //   152: iconst_0
    //   153: istore #5
    //   155: aload #4
    //   157: iconst_1
    //   158: invokevirtual setAccessible : (Z)V
    //   161: aload_3
    //   162: aload_0
    //   163: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   166: astore_2
    //   167: aload_1
    //   168: ldc 'function'
    //   170: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   173: ifeq -> 212
    //   176: aload_2
    //   177: ldc 'field'
    //   179: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   182: aload_2
    //   183: ldc 'getOwner'
    //   185: invokestatic runMethod : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   188: ldc 'getJClass'
    //   190: invokestatic runMethod : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   193: ldc 'getName'
    //   195: invokestatic runMethod : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   198: aload_2
    //   199: ldc 'getName'
    //   201: invokestatic runMethod : (Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   204: <illegal opcode> makeConcatWithConstants : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/String;
    //   209: goto -> 335
    //   212: aload_2
    //   213: ldc 'field'
    //   215: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   218: aload_2
    //   219: invokestatic getImplementingClassName : (Ljava/lang/Object;)Ljava/lang/String;
    //   222: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   227: goto -> 335
    //   230: aload_0
    //   231: invokestatic isKotlinAnonymousLambda : (Ljava/lang/Object;)Z
    //   234: ifeq -> 252
    //   237: aload_0
    //   238: invokestatic getParentClass : (Ljava/lang/Object;)Ljava/lang/Class;
    //   241: invokevirtual getName : ()Ljava/lang/String;
    //   244: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   249: goto -> 335
    //   252: aload_0
    //   253: invokestatic isKotlinField : (Ljava/lang/Object;)Z
    //   256: ifeq -> 278
    //   259: aload_0
    //   260: invokestatic getParentClass : (Ljava/lang/Object;)Ljava/lang/Class;
    //   263: invokevirtual getName : ()Ljava/lang/String;
    //   266: aload_0
    //   267: invokestatic getKotlinFieldName : (Ljava/lang/Object;)Ljava/lang/String;
    //   270: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   275: goto -> 335
    //   278: aload_0
    //   279: invokestatic isJavaField : (Ljava/lang/Object;)Z
    //   282: ifeq -> 304
    //   285: aload_0
    //   286: invokestatic getParentClass : (Ljava/lang/Object;)Ljava/lang/Class;
    //   289: invokevirtual getName : ()Ljava/lang/String;
    //   292: aload_0
    //   293: invokestatic getJavaFieldName : (Ljava/lang/Object;)Ljava/lang/String;
    //   296: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   301: goto -> 335
    //   304: aload_0
    //   305: invokestatic isJavaAnonymousLambda : (Ljava/lang/Object;)Z
    //   308: ifeq -> 326
    //   311: aload_0
    //   312: invokestatic getParentClass : (Ljava/lang/Object;)Ljava/lang/Class;
    //   315: invokevirtual getName : ()Ljava/lang/String;
    //   318: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   323: goto -> 335
    //   326: aload_0
    //   327: invokestatic getImplementingClassName : (Ljava/lang/Object;)Ljava/lang/String;
    //   330: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   335: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #206	-> 6
    //   #207	-> 7
    //   #208	-> 29
    //   #209	-> 36
    //   #245	-> 80
    //   #209	-> 83
    //   #209	-> 114
    //   #209	-> 136
    //   #210	-> 140
    //   #245	-> 152
    //   #210	-> 155
    //   #210	-> 161
    //   #210	-> 162
    //   #211	-> 167
    //   #212	-> 168
    //   #213	-> 212
    //   #217	-> 230
    //   #218	-> 252
    //   #219	-> 278
    //   #220	-> 304
    //   #221	-> 326
    //   #206	-> 335
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   83	31	8	$i$a$-find-RouteOverviewUtil$metaInfo$fieldName$1	I
    //   80	34	7	it	Ljava/lang/reflect/Field;
    //   155	6	5	$i$a$-apply-RouteOverviewUtil$metaInfo$field$1	I
    //   152	9	4	$this$_get_metaInfo__u24lambda_u2d5	Ljava/lang/reflect/Field;
    //   140	87	1	fieldName	Ljava/lang/String;
    //   167	60	2	field	Ljava/lang/Object;
    //   0	336	0	$this$metaInfo	Ljava/lang/Object;
  }
}
