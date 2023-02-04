package io.javalin.plugin.bundled;

import io.javalin.Javalin;
import io.javalin.event.EventListener;
import io.javalin.event.HandlerMetaInfo;
import io.javalin.http.Context;
import io.javalin.plugin.Plugin;
import io.javalin.plugin.PluginLifecycleInit;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020%\n\002\020\016\n\002\020#\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\003\030\0002\0020\0012\0020\002B\005¢\006\002\020\003J\020\020\t\032\0020\n2\006\020\013\032\0020\bH\002J\020\020\f\032\0020\n2\006\020\r\032\0020\016H\026J\020\020\017\032\0020\n2\006\020\r\032\0020\016H\002J\020\020\020\032\0020\n2\006\020\r\032\0020\016H\026R \020\004\032\024\022\004\022\0020\006\022\n\022\b\022\004\022\0020\b0\0070\005X\004¢\006\002\n\000¨\006\021"}, d2 = {"Lio/javalin/plugin/bundled/HttpAllowedMethodsPlugin;", "Lio/javalin/plugin/Plugin;", "Lio/javalin/plugin/PluginLifecycleInit;", "()V", "endpoints", "", "", "", "Lio/javalin/event/HandlerMetaInfo;", "addOptionsToList", "", "handlerMetaInfo", "apply", "app", "Lio/javalin/Javalin;", "createOptionsEndPoint", "init", "javalin"})
public final class HttpAllowedMethodsPlugin implements Plugin, PluginLifecycleInit {
  @NotNull
  private final Map<String, Set<HandlerMetaInfo>> endpoints = new LinkedHashMap<>();
  
  public void init(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    app.events(this::init$lambda-1);
  }
  
  private static final void init$lambda-1(HttpAllowedMethodsPlugin this$0, EventListener it) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    it.handlerAdded(this$0::init$lambda-1$lambda-0);
  }
  
  private static final void init$lambda-1$lambda-0(HttpAllowedMethodsPlugin this$0, HandlerMetaInfo handlerInfo) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullExpressionValue(handlerInfo, "handlerInfo");
    this$0.addOptionsToList(handlerInfo);
  }
  
  public void apply(@NotNull Javalin app) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'app'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: aload_0
    //   8: aload_1
    //   9: <illegal opcode> accept : (Lio/javalin/plugin/bundled/HttpAllowedMethodsPlugin;Lio/javalin/Javalin;)Ljava/util/function/Consumer;
    //   14: invokevirtual events : (Ljava/util/function/Consumer;)Lio/javalin/Javalin;
    //   17: pop
    //   18: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #28	-> 6
    //   #33	-> 18
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	19	0	this	Lio/javalin/plugin/bundled/HttpAllowedMethodsPlugin;
    //   0	19	1	app	Lio/javalin/Javalin;
  }
  
  private static final void apply$lambda-3(HttpAllowedMethodsPlugin this$0, Javalin $app, EventListener it) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'this$0'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc '$app'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_2
    //   13: aload_0
    //   14: aload_1
    //   15: <illegal opcode> handleEvent : (Lio/javalin/plugin/bundled/HttpAllowedMethodsPlugin;Lio/javalin/Javalin;)Lio/javalin/event/EventHandler;
    //   20: invokevirtual serverStarted : (Lio/javalin/event/EventHandler;)V
    //   23: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #29	-> 12
    //   #32	-> 23
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	24	0	this$0	Lio/javalin/plugin/bundled/HttpAllowedMethodsPlugin;
    //   0	24	1	$app	Lio/javalin/Javalin;
    //   0	24	2	it	Lio/javalin/event/EventListener;
  }
  
  private static final void apply$lambda-3$lambda-2(HttpAllowedMethodsPlugin this$0, Javalin $app) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter($app, "$app");
    this$0.createOptionsEndPoint($app);
  }
  
  private final void addOptionsToList(HandlerMetaInfo handlerMetaInfo) {
    Map<String, Set<HandlerMetaInfo>> map = this.endpoints;
    Object key$iv = handlerMetaInfo.getPath();
    int $i$f$getOrPut = 0;
    Object<HandlerMetaInfo> value$iv = (Object<HandlerMetaInfo>)map.get(key$iv);
    if (value$iv == null) {
      int $i$a$-getOrPut-HttpAllowedMethodsPlugin$addOptionsToList$endpoint$1 = 0;
      HandlerMetaInfo[] arrayOfHandlerMetaInfo = new HandlerMetaInfo[1];
      arrayOfHandlerMetaInfo[0] = handlerMetaInfo;
      Object answer$iv = SetsKt.mutableSetOf((Object[])arrayOfHandlerMetaInfo);
      map.put(key$iv, answer$iv);
    } 
    Set<HandlerMetaInfo> endpoint = (Set)value$iv;
    endpoint.add(handlerMetaInfo);
  }
  
  private final void createOptionsEndPoint(Javalin app) {
    Map<String, Set<HandlerMetaInfo>> $this$forEach$iv = this.endpoints;
    int $i$f$forEach = 0;
    Iterator<Map.Entry> iterator = $this$forEach$iv.entrySet().iterator();
    if (iterator.hasNext()) {
      Map.Entry element$iv = iterator.next(), endpoint = element$iv;
      int $i$a$-forEach-HttpAllowedMethodsPlugin$createOptionsEndPoint$1 = 0;
      app.options((String)endpoint.getKey(), endpoint::createOptionsEndPoint$lambda-6$lambda-5);
    } 
  }
  
  private static final void createOptionsEndPoint$lambda-6$lambda-5(Map.Entry $endpoint, Context ctx) {
    Intrinsics.checkNotNullParameter($endpoint, "$endpoint");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    ctx.header("Access-Control-Allow-Methods", CollectionsKt.joinToString$default((Iterable)$endpoint.getValue(), ",", null, null, 0, null, HttpAllowedMethodsPlugin$createOptionsEndPoint$1$1$1.INSTANCE, 30, null));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\r\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/event/HandlerMetaInfo;", "invoke"})
  static final class HttpAllowedMethodsPlugin$createOptionsEndPoint$1$1$1 extends Lambda implements Function1<HandlerMetaInfo, CharSequence> {
    public static final HttpAllowedMethodsPlugin$createOptionsEndPoint$1$1$1 INSTANCE = new HttpAllowedMethodsPlugin$createOptionsEndPoint$1$1$1();
    
    HttpAllowedMethodsPlugin$createOptionsEndPoint$1$1$1() {
      super(1);
    }
    
    @NotNull
    public final CharSequence invoke(@NotNull HandlerMetaInfo it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it.getHttpMethod().toString();
    }
  }
}
