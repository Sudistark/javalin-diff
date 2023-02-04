package io.javalin.plugin.bundled;

import io.javalin.Javalin;
import io.javalin.event.EventListener;
import io.javalin.event.HandlerMetaInfo;
import io.javalin.http.Context;
import io.javalin.plugin.Plugin;
import io.javalin.plugin.PluginLifecycleInit;
import io.javalin.routing.PathMatcher;
import io.javalin.util.JavalinLogger;
import io.javalin.websocket.WsConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\002\b\002\b\000\030\0002\0020\0012\0020\002B\005¢\006\002\020\003J\020\020\n\032\0020\0132\006\020\f\032\0020\rH\026J\020\020\016\032\0020\0132\006\020\f\032\0020\rH\026R\032\020\004\032\0020\005X.¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\t¨\006\017"}, d2 = {"Lio/javalin/plugin/bundled/DevLoggingPlugin;", "Lio/javalin/plugin/Plugin;", "Lio/javalin/plugin/PluginLifecycleInit;", "()V", "matcher", "Lio/javalin/routing/PathMatcher;", "getMatcher", "()Lio/javalin/routing/PathMatcher;", "setMatcher", "(Lio/javalin/routing/PathMatcher;)V", "apply", "", "app", "Lio/javalin/Javalin;", "init", "javalin"})
public final class DevLoggingPlugin implements Plugin, PluginLifecycleInit {
  public PathMatcher matcher;
  
  @NotNull
  public final PathMatcher getMatcher() {
    if (this.matcher != null)
      return this.matcher; 
    Intrinsics.throwUninitializedPropertyAccessException("matcher");
    return null;
  }
  
  public final void setMatcher(@NotNull PathMatcher <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    this.matcher = <set-?>;
  }
  
  public void apply(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    app.cfg.requestLogger.http(this::apply$lambda-0);
    app.cfg.requestLogger.ws(DevLoggingPlugin::apply$lambda-1);
    setMatcher(app.javalinServlet().getMatcher());
  }
  
  private static final void apply$lambda-0(DevLoggingPlugin this$0, Context ctx, float ms) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    DevLoggerPluginKt.requestDevLogger(this$0.getMatcher(), ctx, ms);
  }
  
  private static final void apply$lambda-1(WsConfig it) {
    Intrinsics.checkNotNullParameter(it, "it");
    DevLoggerPluginKt.wsDevLogger(it);
  }
  
  public void init(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    app.events(DevLoggingPlugin::init$lambda-3);
  }
  
  private static final void init$lambda-3(EventListener on) {
    on.handlerAdded(DevLoggingPlugin::init$lambda-3$lambda-2);
  }
  
  private static final void init$lambda-3$lambda-2(HandlerMetaInfo handlerMetaInfo) {
    JavalinLogger.info$default("JAVALIN HANDLER REGISTRATION DEBUG LOG: " + handlerMetaInfo.getHttpMethod() + "[" + handlerMetaInfo.getPath() + "]", null, 2, null);
  }
}
