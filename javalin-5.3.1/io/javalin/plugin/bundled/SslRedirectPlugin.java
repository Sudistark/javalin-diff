package io.javalin.plugin.bundled;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import io.javalin.http.servlet.JavalinServletContextKt;
import io.javalin.plugin.Plugin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\026¨\006\007"}, d2 = {"Lio/javalin/plugin/bundled/SslRedirectPlugin;", "Lio/javalin/plugin/Plugin;", "()V", "apply", "", "app", "Lio/javalin/Javalin;", "javalin"})
public final class SslRedirectPlugin implements Plugin {
  public void apply(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    app.before(SslRedirectPlugin::apply$lambda-0);
  }
  
  private static final void apply$lambda-0(Context ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    if (JavalinServletContextKt.isLocalhost(ctx))
      return; 
    String xForwardedProto = ctx.header("X-Forwarded-Proto");
    if (Intrinsics.areEqual(xForwardedProto, "http") || (xForwardedProto == null && Intrinsics.areEqual(ctx.scheme(), "http")))
      ctx.redirect(StringsKt.replace$default(ctx.fullUrl(), "http", "https", false, 4, null), HttpStatus.MOVED_PERMANENTLY); 
  }
}
