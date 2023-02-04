package io.javalin.compression;

import com.nixxcode.jvmbrotli.common.BrotliLoader;
import io.javalin.util.CoreDependency;
import io.javalin.util.DependencyUtil;
import io.javalin.util.JavalinLogger;
import io.javalin.util.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000,\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020 \n\002\020\016\n\002\b\007\n\002\020\b\n\002\b\007\030\000 \0312\0020\001:\001\031B\035\022\n\b\002\020\002\032\004\030\0010\003\022\n\b\002\020\004\032\004\030\0010\005¢\006\002\020\006J\022\020\030\032\004\030\0010\0032\006\020\002\032\0020\003H\002R\023\020\002\032\004\030\0010\003¢\006\b\n\000\032\004\b\007\020\bR \020\t\032\b\022\004\022\0020\0130\nX\016¢\006\016\n\000\032\004\b\f\020\r\"\004\b\016\020\017R\023\020\004\032\004\030\0010\005¢\006\b\n\000\032\004\b\020\020\021R\032\020\022\032\0020\023X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027¨\006\032"}, d2 = {"Lio/javalin/compression/CompressionStrategy;", "", "brotli", "Lio/javalin/compression/Brotli;", "gzip", "Lio/javalin/compression/Gzip;", "(Lio/javalin/compression/Brotli;Lio/javalin/compression/Gzip;)V", "getBrotli", "()Lio/javalin/compression/Brotli;", "excludedMimeTypesFromCompression", "", "", "getExcludedMimeTypesFromCompression", "()Ljava/util/List;", "setExcludedMimeTypesFromCompression", "(Ljava/util/List;)V", "getGzip", "()Lio/javalin/compression/Gzip;", "minSizeForCompression", "", "getMinSizeForCompression", "()I", "setMinSizeForCompression", "(I)V", "tryLoadBrotli", "Companion", "javalin"})
public final class CompressionStrategy {
  public CompressionStrategy(@Nullable Brotli brotli, @Nullable Gzip gzip) {
    this.brotli = (brotli != null) ? tryLoadBrotli(brotli) : null;
    this.gzip = gzip;
    this.minSizeForCompression = 1500;
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "image/";
    arrayOfString[1] = 
      "audio/";
    arrayOfString[2] = "video/";
    arrayOfString[3] = "application/compress";
    arrayOfString[4] = "application/zip";
    arrayOfString[5] = "application/gzip";
    arrayOfString[6] = "application/bzip2";
    arrayOfString[7] = "application/brotli";
    arrayOfString[8] = "application/x-xz";
    arrayOfString[9] = "application/x-rar-compressed";
    this.excludedMimeTypesFromCompression = CollectionsKt.listOf((Object[])arrayOfString);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000R\020\020\005\032\0020\0048\006X\004¢\006\002\n\000¨\006\006"}, d2 = {"Lio/javalin/compression/CompressionStrategy$Companion;", "", "()V", "GZIP", "Lio/javalin/compression/CompressionStrategy;", "NONE", "javalin"})
  public static final class Companion {
    private Companion() {}
  }
  
  @NotNull
  public static final Companion Companion = new Companion(null);
  
  @Nullable
  private final Brotli brotli;
  
  @Nullable
  private final Gzip gzip;
  
  private int minSizeForCompression;
  
  @NotNull
  private List<String> excludedMimeTypesFromCompression;
  
  @JvmField
  @NotNull
  public static final CompressionStrategy NONE = new CompressionStrategy(null, null, 3, null);
  
  @JvmField
  @NotNull
  public static final CompressionStrategy GZIP = new CompressionStrategy(null, new Gzip(0, 1, null));
  
  @Nullable
  public final Brotli getBrotli() {
    return this.brotli;
  }
  
  @Nullable
  public final Gzip getGzip() {
    return this.gzip;
  }
  
  public final int getMinSizeForCompression() {
    return this.minSizeForCompression;
  }
  
  public final void setMinSizeForCompression(int <set-?>) {
    this.minSizeForCompression = <set-?>;
  }
  
  @NotNull
  public final List<String> getExcludedMimeTypesFromCompression() {
    return this.excludedMimeTypesFromCompression;
  }
  
  public final void setExcludedMimeTypesFromCompression(@NotNull List<String> <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    this.excludedMimeTypesFromCompression = <set-?>;
  }
  
  private final Brotli tryLoadBrotli(Brotli brotli) {
    if (!Util.INSTANCE.classExists(CoreDependency.JVMBROTLI.getTestClass()))
      throw new IllegalStateException(DependencyUtil.INSTANCE.missingDependencyMessage(CoreDependency.JVMBROTLI)); 
    JavalinLogger.warn$default(







        
        "\nFailed to enable Brotli compression, because the jvm-brotli native library couldn't be loaded.\njvm-brotli is currently only supported on Windows, Linux and Mac OSX.\nIf you are running Javalin on a supported system, but are still getting this error,\ntry re-importing your Maven and/or Gradle dependencies. If that doesn't resolve it,\nplease create an issue at https://github.com/tipsy/javalin/\n---------------------------------------------------------------\nIf you still want compression, please ensure GZIP is enabled!\n---------------------------------------------------------------", null, 2, null);
    return BrotliLoader.isBrotliAvailable() ? brotli : (Brotli)null;
  }
  
  public CompressionStrategy() {
    this(null, null, 3, null);
  }
}
