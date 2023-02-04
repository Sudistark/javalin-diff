package io.javalin.config;

import io.javalin.http.staticfiles.Location;
import io.javalin.http.staticfiles.StaticFileConfig;
import io.javalin.jetty.JettyResourceHandler;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\024\020\005\032\0020\0062\f\020\007\032\b\022\004\022\0020\t0\bJ\032\020\005\032\0020\0062\006\020\n\032\0020\0132\b\b\002\020\f\032\0020\rH\007J\006\020\016\032\0020\006R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\017"}, d2 = {"Lio/javalin/config/StaticFilesConfig;", "", "pvt", "Lio/javalin/config/PrivateConfig;", "(Lio/javalin/config/PrivateConfig;)V", "add", "", "userConfig", "Ljava/util/function/Consumer;", "Lio/javalin/http/staticfiles/StaticFileConfig;", "directory", "", "location", "Lio/javalin/http/staticfiles/Location;", "enableWebjars", "javalin"})
public final class StaticFilesConfig {
  @NotNull
  private final PrivateConfig pvt;
  
  public StaticFilesConfig(@NotNull PrivateConfig pvt) {
    this.pvt = pvt;
  }
  
  public final void enableWebjars() {
    add(StaticFilesConfig::enableWebjars$lambda-0);
  }
  
  private static final void enableWebjars$lambda-0(StaticFileConfig staticFiles) {
    Intrinsics.checkNotNullParameter(staticFiles, "staticFiles");
    staticFiles.directory = "META-INF/resources/webjars";
    staticFiles.headers = MapsKt.mapOf(TuplesKt.to("Cache-Control", "max-age=31622400"));
  }
  
  @JvmOverloads
  public final void add(@NotNull String directory, @NotNull Location location) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'directory'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 'location'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: aload_1
    //   14: aload_2
    //   15: <illegal opcode> accept : (Ljava/lang/String;Lio/javalin/http/staticfiles/Location;)Ljava/util/function/Consumer;
    //   20: invokevirtual add : (Ljava/util/function/Consumer;)V
    //   23: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #17	-> 12
    //   #20	-> 23
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	24	0	this	Lio/javalin/config/StaticFilesConfig;
    //   0	24	1	directory	Ljava/lang/String;
    //   0	24	2	location	Lio/javalin/http/staticfiles/Location;
  }
  
  private static final void add$lambda-1(String $directory, Location $location, StaticFileConfig staticFiles) {
    Intrinsics.checkNotNullParameter($directory, "$directory");
    Intrinsics.checkNotNullParameter($location, "$location");
    Intrinsics.checkNotNullParameter(staticFiles, "staticFiles");
    staticFiles.directory = $directory;
    staticFiles.location = $location;
  }
  
  public final void add(@NotNull Consumer<StaticFileConfig> userConfig) {
    Intrinsics.checkNotNullParameter(userConfig, "userConfig");
    if (this.pvt.resourceHandler == null)
      this.pvt.resourceHandler = new JettyResourceHandler(this.pvt); 
    StaticFileConfig finalConfig = new StaticFileConfig(null, null, null, false, null, null, null, 127, null);
    userConfig.accept(finalConfig);
    Intrinsics.checkNotNull(this.pvt.resourceHandler);
    this.pvt.resourceHandler.addStaticFileConfig(finalConfig);
  }
  
  @JvmOverloads
  public final void add(@NotNull String directory) {
    Intrinsics.checkNotNullParameter(directory, "directory");
    add$default(this, directory, null, 2, null);
  }
}
