package io.javalin.config;

import io.javalin.http.util.MultipartUtil;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.http.HttpServletRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0004\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\002\n\002\020\t\n\000\n\002\020\b\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\005¢\006\002\020\002J\016\020\003\032\0020\0132\006\020\f\032\0020\004J\026\020\006\032\0020\0132\006\020\r\032\0020\0072\006\020\016\032\0020\017J\026\020\b\032\0020\0132\006\020\r\032\0020\t2\006\020\016\032\0020\017J\026\020\n\032\0020\0132\006\020\r\032\0020\0072\006\020\016\032\0020\017J\b\020\020\032\0020\021H\002R\026\020\003\032\n \005*\004\030\0010\0040\004X\016¢\006\002\n\000R\016\020\006\032\0020\007X\016¢\006\002\n\000R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\007X\016¢\006\002\n\000¨\006\022"}, d2 = {"Lio/javalin/config/MultipartConfig;", "", "()V", "cacheDirectory", "", "kotlin.jvm.PlatformType", "maxFileSize", "", "maxInMemoryFileSize", "", "maxTotalRequestSize", "", "path", "size", "sizeUnit", "Lio/javalin/config/SizeUnit;", "multipartConfigElement", "Ljakarta/servlet/MultipartConfigElement;", "javalin"})
public final class MultipartConfig {
  private String cacheDirectory;
  
  private long maxFileSize;
  
  private int maxInMemoryFileSize;
  
  private long maxTotalRequestSize;
  
  public MultipartConfig() {
    this.cacheDirectory = System.getProperty("java.io.tmpdir");
    this.maxFileSize = -1L;
    this.maxInMemoryFileSize = -1;
    this.maxTotalRequestSize = -1L;
    MultipartUtil.INSTANCE.setPreUploadFunction(new Function1<HttpServletRequest, Unit>() {
          public final void invoke(@NotNull HttpServletRequest req) {
            Intrinsics.checkNotNullParameter(req, "req");
            if (req.getAttribute("org.eclipse.jetty.multipartConfig") == null)
              req.setAttribute("org.eclipse.jetty.multipartConfig", MultipartConfig.this.multipartConfigElement()); 
          }
        });
  }
  
  public final void cacheDirectory(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    this.cacheDirectory = path;
  }
  
  public final void maxFileSize(long size, @NotNull SizeUnit sizeUnit) {
    Intrinsics.checkNotNullParameter(sizeUnit, "sizeUnit");
    this.maxFileSize = size * sizeUnit.getMultiplier();
  }
  
  public final void maxInMemoryFileSize(int size, @NotNull SizeUnit sizeUnit) {
    Intrinsics.checkNotNullParameter(sizeUnit, "sizeUnit");
    this.maxInMemoryFileSize = size * sizeUnit.getMultiplier();
  }
  
  public final void maxTotalRequestSize(long size, @NotNull SizeUnit sizeUnit) {
    Intrinsics.checkNotNullParameter(sizeUnit, "sizeUnit");
    this.maxTotalRequestSize = size * sizeUnit.getMultiplier();
  }
  
  private final MultipartConfigElement multipartConfigElement() {
    return new MultipartConfigElement(this.cacheDirectory, this.maxFileSize, this.maxTotalRequestSize, this.maxInMemoryFileSize);
  }
}
