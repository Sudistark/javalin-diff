package io.javalin.config;

import io.javalin.http.Handler;
import io.javalin.http.staticfiles.Location;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000.\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\"\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\b2\b\b\002\020\n\032\0020\013H\007J\026\020\f\032\0020\0062\006\020\007\032\0020\b2\006\020\r\032\0020\016R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\017"}, d2 = {"Lio/javalin/config/SpaRootConfig;", "", "pvt", "Lio/javalin/config/PrivateConfig;", "(Lio/javalin/config/PrivateConfig;)V", "addFile", "", "hostedPath", "", "filePath", "location", "Lio/javalin/http/staticfiles/Location;", "addHandler", "customHandler", "Lio/javalin/http/Handler;", "javalin"})
public final class SpaRootConfig {
  @NotNull
  private final PrivateConfig pvt;
  
  public SpaRootConfig(@NotNull PrivateConfig pvt) {
    this.pvt = pvt;
  }
  
  @JvmOverloads
  public final void addFile(@NotNull String hostedPath, @NotNull String filePath, @NotNull Location location) {
    Intrinsics.checkNotNullParameter(hostedPath, "hostedPath");
    Intrinsics.checkNotNullParameter(filePath, "filePath");
    Intrinsics.checkNotNullParameter(location, "location");
    this.pvt.singlePageHandler.add(hostedPath, filePath, location);
  }
  
  public final void addHandler(@NotNull String hostedPath, @NotNull Handler customHandler) {
    Intrinsics.checkNotNullParameter(hostedPath, "hostedPath");
    Intrinsics.checkNotNullParameter(customHandler, "customHandler");
    this.pvt.singlePageHandler.add(hostedPath, customHandler);
  }
  
  @JvmOverloads
  public final void addFile(@NotNull String hostedPath, @NotNull String filePath) {
    Intrinsics.checkNotNullParameter(hostedPath, "hostedPath");
    Intrinsics.checkNotNullParameter(filePath, "filePath");
    addFile$default(this, hostedPath, filePath, null, 4, null);
  }
}
