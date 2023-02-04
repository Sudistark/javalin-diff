package io.javalin.plugin.bundled;

import io.javalin.Javalin;
import io.javalin.event.EventListener;
import io.javalin.event.HandlerMetaInfo;
import io.javalin.event.WsHandlerMetaInfo;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020!\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\f\032\0020\r2\006\020\016\032\0020\017H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R\024\020\007\032\b\022\004\022\0020\t0\bX\004¢\006\002\n\000R\024\020\n\032\b\022\004\022\0020\0130\bX\004¢\006\002\n\000¨\006\020"}, d2 = {"Lio/javalin/plugin/bundled/RouteOverviewRenderer;", "Lio/javalin/http/Handler;", "app", "Lio/javalin/Javalin;", "(Lio/javalin/Javalin;)V", "getApp", "()Lio/javalin/Javalin;", "handlerMetaInfoList", "", "Lio/javalin/event/HandlerMetaInfo;", "wsHandlerMetaInfoList", "Lio/javalin/event/WsHandlerMetaInfo;", "handle", "", "ctx", "Lio/javalin/http/Context;", "javalin"})
public final class RouteOverviewRenderer implements Handler {
  @NotNull
  private final Javalin app;
  
  @NotNull
  private final List<HandlerMetaInfo> handlerMetaInfoList;
  
  @NotNull
  private final List<WsHandlerMetaInfo> wsHandlerMetaInfoList;
  
  public RouteOverviewRenderer(@NotNull Javalin app) {
    this.app = app;
    this.handlerMetaInfoList = new ArrayList<>();
    this.wsHandlerMetaInfoList = new ArrayList<>();
    this.app.events(this::_init_$lambda-1);
    this.app.events(this::_init_$lambda-3);
  }
  
  @NotNull
  public final Javalin getApp() {
    return this.app;
  }
  
  private static final void lambda-1$lambda-0(RouteOverviewRenderer this$0, HandlerMetaInfo handlerInfo) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullExpressionValue(handlerInfo, "handlerInfo");
    this$0.handlerMetaInfoList.add(handlerInfo);
  }
  
  private static final void _init_$lambda-1(RouteOverviewRenderer this$0, EventListener it) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    it.handlerAdded(this$0::lambda-1$lambda-0);
  }
  
  private static final void lambda-3$lambda-2(RouteOverviewRenderer this$0, WsHandlerMetaInfo handlerInfo) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullExpressionValue(handlerInfo, "handlerInfo");
    this$0.wsHandlerMetaInfoList.add(handlerInfo);
  }
  
  private static final void _init_$lambda-3(RouteOverviewRenderer this$0, EventListener it) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    it.wsHandlerAdded(this$0::lambda-3$lambda-2);
  }
  
  public void handle(@NotNull Context ctx) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'ctx'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'Accept'
    //   9: invokeinterface header : (Ljava/lang/String;)Ljava/lang/String;
    //   14: dup
    //   15: ifnull -> 69
    //   18: astore_2
    //   19: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   22: dup
    //   23: ldc 'ROOT'
    //   25: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   28: aload_2
    //   29: swap
    //   30: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   33: dup
    //   34: ldc 'this as java.lang.String).toLowerCase(locale)'
    //   36: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   39: dup
    //   40: ifnull -> 69
    //   43: checkcast java/lang/CharSequence
    //   46: ldc 'application/json'
    //   48: checkcast java/lang/CharSequence
    //   51: iconst_0
    //   52: iconst_2
    //   53: aconst_null
    //   54: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
    //   57: iconst_1
    //   58: if_icmpne -> 65
    //   61: iconst_1
    //   62: goto -> 71
    //   65: iconst_0
    //   66: goto -> 71
    //   69: pop
    //   70: iconst_0
    //   71: ifeq -> 106
    //   74: aload_1
    //   75: ldc 'Content-Type'
    //   77: ldc 'application/json'
    //   79: invokeinterface header : (Ljava/lang/String;Ljava/lang/String;)Lio/javalin/http/Context;
    //   84: pop
    //   85: aload_1
    //   86: aload_0
    //   87: getfield handlerMetaInfoList : Ljava/util/List;
    //   90: aload_0
    //   91: getfield wsHandlerMetaInfoList : Ljava/util/List;
    //   94: invokestatic createJsonOverview : (Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   97: invokeinterface result : (Ljava/lang/String;)Lio/javalin/http/Context;
    //   102: pop
    //   103: goto -> 124
    //   106: aload_1
    //   107: aload_0
    //   108: getfield handlerMetaInfoList : Ljava/util/List;
    //   111: aload_0
    //   112: getfield wsHandlerMetaInfoList : Ljava/util/List;
    //   115: invokestatic createHtmlOverview : (Ljava/util/List;Ljava/util/List;)Ljava/lang/String;
    //   118: invokeinterface html : (Ljava/lang/String;)Lio/javalin/http/Context;
    //   123: pop
    //   124: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #43	-> 6
    //   #43	-> 39
    //   #44	-> 74
    //   #45	-> 85
    //   #47	-> 106
    //   #49	-> 124
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	125	0	this	Lio/javalin/plugin/bundled/RouteOverviewRenderer;
    //   0	125	1	ctx	Lio/javalin/http/Context;
  }
}
