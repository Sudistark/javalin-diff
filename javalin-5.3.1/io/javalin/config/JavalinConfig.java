package io.javalin.config;

import io.javalin.Javalin;
import io.javalin.json.JavalinJackson;
import io.javalin.json.JsonMapper;
import io.javalin.rendering.FileRenderer;
import io.javalin.rendering.LegacyFileRenderer;
import io.javalin.security.AccessManager;
import io.javalin.validation.JavalinValidation;
import io.javalin.vue.JavalinVueConfig;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000l\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\030\000 \"2\0020\001:\001\"B\005¢\006\002\020\002J\016\020\033\032\0020\0342\006\020\033\032\0020\035J\016\020\036\032\0020\0342\006\020\036\032\0020\037J\016\020 \032\0020\0342\006\020 \032\0020!R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\020\020\005\032\0020\0068\006X\004¢\006\002\n\000R\020\020\007\032\0020\b8\006X\004¢\006\002\n\000R\020\020\t\032\0020\n8\006X\004¢\006\002\n\000R\020\020\013\032\0020\f8\006X\004¢\006\002\n\000R\020\020\r\032\0020\0168\006X\004¢\006\002\n\000R\020\020\017\032\0020\0208\006X\004¢\006\002\n\000R\020\020\021\032\0020\0228\006X\004¢\006\002\n\000R\022\020\023\032\0020\0248\006@\006X\016¢\006\002\n\000R\020\020\025\032\0020\0268\006X\004¢\006\002\n\000R\020\020\027\032\0020\0308\006X\004¢\006\002\n\000R\020\020\031\032\0020\0328\006X\004¢\006\002\n\000¨\006#"}, d2 = {"Lio/javalin/config/JavalinConfig;", "", "()V", "compression", "Lio/javalin/config/CompressionConfig;", "contextResolver", "Lio/javalin/config/ContextResolverConfig;", "http", "Lio/javalin/config/HttpConfig;", "jetty", "Lio/javalin/config/JettyConfig;", "plugins", "Lio/javalin/config/PluginConfig;", "pvt", "Lio/javalin/config/PrivateConfig;", "requestLogger", "Lio/javalin/config/RequestLoggerConfig;", "routing", "Lio/javalin/config/RoutingConfig;", "showJavalinBanner", "", "spaRoot", "Lio/javalin/config/SpaRootConfig;", "staticFiles", "Lio/javalin/config/StaticFilesConfig;", "vue", "Lio/javalin/vue/JavalinVueConfig;", "accessManager", "", "Lio/javalin/security/AccessManager;", "fileRenderer", "Lio/javalin/rendering/FileRenderer;", "jsonMapper", "Lio/javalin/json/JsonMapper;", "Companion", "javalin"})
public final class JavalinConfig {
  @NotNull
  public static final Companion Companion = new Companion(null);
  
  @JvmField
  @NotNull
  public final PrivateConfig pvt = new PrivateConfig();
  
  @JvmField
  @NotNull
  public final HttpConfig http = new HttpConfig();
  
  @JvmField
  @NotNull
  public final RoutingConfig routing = new RoutingConfig();
  
  @JvmField
  @NotNull
  public final JettyConfig jetty = new JettyConfig(this.pvt);
  
  @JvmField
  @NotNull
  public final StaticFilesConfig staticFiles = new StaticFilesConfig(this.pvt);
  
  @JvmField
  @NotNull
  public final SpaRootConfig spaRoot = new SpaRootConfig(this.pvt);
  
  @JvmField
  @NotNull
  public final CompressionConfig compression = new CompressionConfig(this.pvt);
  
  @JvmField
  @NotNull
  public final RequestLoggerConfig requestLogger = new RequestLoggerConfig(this.pvt);
  
  @JvmField
  @NotNull
  public final PluginConfig plugins = new PluginConfig();
  
  @JvmField
  @NotNull
  public final JavalinVueConfig vue = new JavalinVueConfig();
  
  @JvmField
  @NotNull
  public final ContextResolverConfig contextResolver = new ContextResolverConfig();
  
  @JvmField
  public boolean showJavalinBanner = true;
  
  public final void accessManager(@NotNull AccessManager accessManager) {
    Intrinsics.checkNotNullParameter(accessManager, "accessManager");
    this.pvt.accessManager = accessManager;
  }
  
  public final void jsonMapper(@NotNull JsonMapper jsonMapper) {
    Intrinsics.checkNotNullParameter(jsonMapper, "jsonMapper");
    this.pvt.appAttributes.put("javalin-json-mapper", jsonMapper);
  }
  
  public final void fileRenderer(@NotNull FileRenderer fileRenderer) {
    Intrinsics.checkNotNullParameter(fileRenderer, "fileRenderer");
    this.pvt.appAttributes.put("javalin-file-renderer", fileRenderer);
  }
  
  @JvmStatic
  public static final void applyUserConfig(@NotNull Javalin app, @NotNull JavalinConfig cfg, @NotNull Consumer<JavalinConfig> userConfig) {
    Companion.applyUserConfig(app, cfg, userConfig);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000$\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J&\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\f\020\t\032\b\022\004\022\0020\b0\nH\007¨\006\013"}, d2 = {"Lio/javalin/config/JavalinConfig$Companion;", "", "()V", "applyUserConfig", "", "app", "Lio/javalin/Javalin;", "cfg", "Lio/javalin/config/JavalinConfig;", "userConfig", "Ljava/util/function/Consumer;", "javalin"})
  public static final class Companion {
    private Companion() {}
    
    @JvmStatic
    public final void applyUserConfig(@NotNull Javalin app, @NotNull JavalinConfig cfg, @NotNull Consumer<JavalinConfig> userConfig) {
      Intrinsics.checkNotNullParameter(app, "app");
      Intrinsics.checkNotNullParameter(cfg, "cfg");
      Intrinsics.checkNotNullParameter(userConfig, "userConfig");
      JavalinValidation.addValidationExceptionMapper(app);
      userConfig.accept(cfg);
      cfg.plugins.getPluginManager().initializePlugins(app);
      cfg.pvt.appAttributes.computeIfAbsent("javalin-json-mapper", Companion::applyUserConfig$lambda-0);
      cfg.pvt.appAttributes.computeIfAbsent("javalin-file-renderer", Companion::applyUserConfig$lambda-1);
      cfg.pvt.appAttributes.computeIfAbsent("javalin-context-resolver", cfg::applyUserConfig$lambda-2);
      cfg.pvt.appAttributes.computeIfAbsent("javalin-max-request-size", cfg::applyUserConfig$lambda-3);
      cfg.pvt.appAttributes.computeIfAbsent("javalin-javalinvue-config", cfg::applyUserConfig$lambda-4);
    }
    
    private static final Object applyUserConfig$lambda-0(String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return new JavalinJackson(null, 1, null);
    }
    
    private static final Object applyUserConfig$lambda-1(String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return new LegacyFileRenderer();
    }
    
    private static final Object applyUserConfig$lambda-2(JavalinConfig $cfg, String it) {
      Intrinsics.checkNotNullParameter($cfg, "$cfg");
      Intrinsics.checkNotNullParameter(it, "it");
      return $cfg.contextResolver;
    }
    
    private static final Object applyUserConfig$lambda-3(JavalinConfig $cfg, String it) {
      Intrinsics.checkNotNullParameter($cfg, "$cfg");
      Intrinsics.checkNotNullParameter(it, "it");
      return Long.valueOf($cfg.http.maxRequestSize);
    }
    
    private static final Object applyUserConfig$lambda-4(JavalinConfig $cfg, String it) {
      Intrinsics.checkNotNullParameter($cfg, "$cfg");
      Intrinsics.checkNotNullParameter(it, "it");
      return $cfg.vue;
    }
  }
}
