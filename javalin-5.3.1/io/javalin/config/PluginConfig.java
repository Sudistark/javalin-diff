package io.javalin.config;

import io.javalin.plugin.Plugin;
import io.javalin.plugin.PluginManager;
import io.javalin.plugin.bundled.BasicAuthPlugin;
import io.javalin.plugin.bundled.CorsContainer;
import io.javalin.plugin.bundled.CorsPlugin;
import io.javalin.plugin.bundled.CorsPluginConfig;
import io.javalin.plugin.bundled.DevLoggingPlugin;
import io.javalin.plugin.bundled.GlobalHeaderConfig;
import io.javalin.plugin.bundled.GlobalHeadersPlugin;
import io.javalin.plugin.bundled.HttpAllowedMethodsPlugin;
import io.javalin.plugin.bundled.RedirectToLowercasePathPlugin;
import io.javalin.plugin.bundled.RouteOverviewPlugin;
import io.javalin.plugin.bundled.SslRedirectPlugin;
import io.javalin.security.RouteRole;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000L\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\020\016\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\b\005\n\002\020\021\n\002\030\002\n\002\b\004\n\002\030\002\n\000\030\0002\0020\001B\005¢\006\002\020\002J\026\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\nJ\024\020\f\032\0020\b2\f\020\r\032\b\022\004\022\0020\0170\016J\006\020\020\032\0020\bJ\026\020\021\032\0020\b2\016\020\022\032\n\022\006\022\004\030\0010\0240\023J\006\020\025\032\0020\bJ\006\020\026\032\0020\bJ)\020\027\032\0020\b2\006\020\030\032\0020\n2\024\b\002\020\031\032\n\022\006\b\001\022\0020\0330\032\"\0020\033¢\006\002\020\034J\006\020\035\032\0020\bJ\016\020\036\032\0020\b2\006\020\037\032\0020 R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006¨\006!"}, d2 = {"Lio/javalin/config/PluginConfig;", "", "()V", "pluginManager", "Lio/javalin/plugin/PluginManager;", "getPluginManager", "()Lio/javalin/plugin/PluginManager;", "enableBasicAuth", "", "username", "", "password", "enableCors", "userConfig", "Ljava/util/function/Consumer;", "Lio/javalin/plugin/bundled/CorsContainer;", "enableDevLogging", "enableGlobalHeaders", "globalHeaderConfig", "Ljava/util/function/Supplier;", "Lio/javalin/plugin/bundled/GlobalHeaderConfig;", "enableHttpAllowedMethodsOnRoutes", "enableRedirectToLowercasePaths", "enableRouteOverview", "path", "roles", "", "Lio/javalin/security/RouteRole;", "(Ljava/lang/String;[Lio/javalin/security/RouteRole;)V", "enableSslRedirects", "register", "plugin", "Lio/javalin/plugin/Plugin;", "javalin"})
public final class PluginConfig {
  @NotNull
  private final PluginManager pluginManager = new PluginManager();
  
  @NotNull
  public final PluginManager getPluginManager() {
    return this.pluginManager;
  }
  
  public final void register(@NotNull Plugin plugin) {
    Intrinsics.checkNotNullParameter(plugin, "plugin");
    this.pluginManager.register(plugin);
  }
  
  public final void enableHttpAllowedMethodsOnRoutes() {
    register(new HttpAllowedMethodsPlugin());
  }
  
  public final void enableDevLogging() {
    register(new DevLoggingPlugin());
  }
  
  public final void enableGlobalHeaders(@NotNull Supplier globalHeaderConfig) {
    Intrinsics.checkNotNullParameter(globalHeaderConfig, "globalHeaderConfig");
    Intrinsics.checkNotNull(globalHeaderConfig.get());
    register(new GlobalHeadersPlugin((GlobalHeaderConfig)globalHeaderConfig.get()));
  }
  
  public final void enableRouteOverview(@NotNull String path, @NotNull RouteRole... roles) {
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullParameter(roles, "roles");
    register(new RouteOverviewPlugin(path, Arrays.<RouteRole>copyOf(roles, roles.length)));
  }
  
  public final void enableRedirectToLowercasePaths() {
    register(new RedirectToLowercasePathPlugin());
  }
  
  public final void enableBasicAuth(@NotNull String username, @NotNull String password) {
    Intrinsics.checkNotNullParameter(username, "username");
    Intrinsics.checkNotNullParameter(password, "password");
    register(new BasicAuthPlugin(username, password));
  }
  
  public final void enableSslRedirects() {
    register(new SslRedirectPlugin());
  }
  
  public final void enableCors(@NotNull Consumer<CorsContainer> userConfig) {
    Intrinsics.checkNotNullParameter(userConfig, "userConfig");
    CorsContainer corsContainer1 = new CorsContainer(), it = corsContainer1;
    int $i$a$-also-PluginConfig$enableCors$corsConfigs$1 = 0;
    userConfig.accept(it);
    List<Consumer<CorsPluginConfig>> corsConfigs = corsContainer1.corsConfigs();
    register(new CorsPlugin(corsConfigs));
  }
}
