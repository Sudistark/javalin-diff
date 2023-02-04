package io.javalin.plugin.bundled;

import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.plugin.Plugin;
import io.javalin.plugin.PluginLifecycleInit;
import io.javalin.security.RouteRole;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0006\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\021\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\0012\0020\002B#\022\006\020\003\032\0020\004\022\024\b\002\020\005\032\n\022\006\b\001\022\0020\0070\006\"\0020\007¢\006\002\020\bJ\020\020\020\032\0020\0212\006\020\022\032\0020\023H\026J\020\020\024\032\0020\0212\006\020\022\032\0020\023H\026R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\t\020\nR\016\020\013\032\0020\fX.¢\006\002\n\000R\033\020\005\032\n\022\006\b\001\022\0020\0070\006¢\006\n\n\002\020\017\032\004\b\r\020\016¨\006\025"}, d2 = {"Lio/javalin/plugin/bundled/RouteOverviewPlugin;", "Lio/javalin/plugin/Plugin;", "Lio/javalin/plugin/PluginLifecycleInit;", "path", "", "roles", "", "Lio/javalin/security/RouteRole;", "(Ljava/lang/String;[Lio/javalin/security/RouteRole;)V", "getPath", "()Ljava/lang/String;", "renderer", "Lio/javalin/plugin/bundled/RouteOverviewRenderer;", "getRoles", "()[Lio/javalin/security/RouteRole;", "[Lio/javalin/security/RouteRole;", "apply", "", "app", "Lio/javalin/Javalin;", "init", "javalin"})
public final class RouteOverviewPlugin implements Plugin, PluginLifecycleInit {
  @NotNull
  private final String path;
  
  @NotNull
  private final RouteRole[] roles;
  
  private RouteOverviewRenderer renderer;
  
  public RouteOverviewPlugin(@NotNull String path, @NotNull RouteRole... roles) {
    this.path = path;
    this.roles = roles;
  }
  
  @NotNull
  public final String getPath() {
    return this.path;
  }
  
  @NotNull
  public final RouteRole[] getRoles() {
    return this.roles;
  }
  
  public void init(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    this.renderer = new RouteOverviewRenderer(app);
  }
  
  public void apply(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    if (this.renderer == null)
      Intrinsics.throwUninitializedPropertyAccessException("renderer"); 
    RouteRole[] arrayOfRouteRole = this.roles;
    this.path.get((String)this.renderer, (Handler)null, Arrays.<RouteRole>copyOf(arrayOfRouteRole, arrayOfRouteRole.length));
  }
}
