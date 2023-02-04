package io.javalin.plugin.bundled;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.plugin.Plugin;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\t"}, d2 = {"Lio/javalin/plugin/bundled/GlobalHeadersPlugin;", "Lio/javalin/plugin/Plugin;", "globalHeaderConfig", "Lio/javalin/plugin/bundled/GlobalHeaderConfig;", "(Lio/javalin/plugin/bundled/GlobalHeaderConfig;)V", "apply", "", "app", "Lio/javalin/Javalin;", "javalin"})
public final class GlobalHeadersPlugin implements Plugin {
  @NotNull
  private final GlobalHeaderConfig globalHeaderConfig;
  
  public GlobalHeadersPlugin(@NotNull GlobalHeaderConfig globalHeaderConfig) {
    this.globalHeaderConfig = globalHeaderConfig;
  }
  
  public void apply(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    app.before(this::apply$lambda-1);
  }
  
  private static final void apply$lambda-1(GlobalHeadersPlugin this$0, Context ctx) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    Map<String, String> $this$forEach$iv = this$0.globalHeaderConfig.getHeaders();
    int $i$f$forEach = 0;
    Iterator<Map.Entry> iterator = $this$forEach$iv.entrySet().iterator();
    if (iterator.hasNext()) {
      Map.Entry element$iv = iterator.next(), entry1 = element$iv;
      int $i$a$-forEach-GlobalHeadersPlugin$apply$1$1 = 0;
      String name = (String)entry1.getKey(), value = (String)entry1.getValue();
      ctx.header(name, value);
    } 
  }
}
