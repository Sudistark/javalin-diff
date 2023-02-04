package io.javalin.config;

import io.javalin.compression.Brotli;
import io.javalin.compression.CompressionStrategy;
import io.javalin.compression.Gzip;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000(\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\003\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\034\020\005\032\0020\0062\b\b\002\020\007\032\0020\b2\b\b\002\020\t\032\0020\bH\007J\022\020\n\032\0020\0062\b\b\002\020\013\032\0020\bH\007J\016\020\f\032\0020\0062\006\020\r\032\0020\016J\022\020\017\032\0020\0062\b\b\002\020\013\032\0020\bH\007J\006\020\020\032\0020\006R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\021"}, d2 = {"Lio/javalin/config/CompressionConfig;", "", "pvt", "Lio/javalin/config/PrivateConfig;", "(Lio/javalin/config/PrivateConfig;)V", "brotliAndGzip", "", "gzipLevel", "", "brotliLevel", "brotliOnly", "level", "custom", "compressionStrategy", "Lio/javalin/compression/CompressionStrategy;", "gzipOnly", "none", "javalin"})
public final class CompressionConfig {
  @NotNull
  private final PrivateConfig pvt;
  
  public CompressionConfig(@NotNull PrivateConfig pvt) {
    this.pvt = pvt;
  }
  
  public final void custom(@NotNull CompressionStrategy compressionStrategy) {
    Intrinsics.checkNotNullParameter(compressionStrategy, "compressionStrategy");
    this.pvt.compressionStrategy = compressionStrategy;
  }
  
  @JvmOverloads
  public final void brotliAndGzip(int gzipLevel, int brotliLevel) {
    this.pvt.compressionStrategy = new CompressionStrategy(new Brotli(brotliLevel), new Gzip(gzipLevel));
  }
  
  @JvmOverloads
  public final void gzipOnly(int level) {
    this.pvt.compressionStrategy = new CompressionStrategy(null, new Gzip(level));
  }
  
  @JvmOverloads
  public final void brotliOnly(int level) {
    this.pvt.compressionStrategy = new CompressionStrategy(new Brotli(level), null);
  }
  
  public final void none() {
    this.pvt.compressionStrategy = new CompressionStrategy(null, null);
  }
  
  @JvmOverloads
  public final void brotliAndGzip(int gzipLevel) {
    brotliAndGzip$default(this, gzipLevel, 0, 2, null);
  }
  
  @JvmOverloads
  public final void brotliAndGzip() {
    brotliAndGzip$default(this, 0, 0, 3, null);
  }
  
  @JvmOverloads
  public final void gzipOnly() {
    gzipOnly$default(this, 0, 1, null);
  }
  
  @JvmOverloads
  public final void brotliOnly() {
    brotliOnly$default(this, 0, 1, null);
  }
}
