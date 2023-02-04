package io.javalin.compression;

import io.javalin.http.Context;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.WriteListener;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000D\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007\n\002\020\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\022\n\000\n\002\020\b\n\002\b\003\b\000\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\b\020\017\032\0020\020H\026J\b\020\021\032\0020\022H\026J\022\020\023\032\0020\0202\b\020\024\032\004\030\0010\025H\026J \020\026\032\0020\0202\006\020\027\032\0020\0302\006\020\031\032\0020\0322\006\020\033\032\0020\032H\026J\020\020\026\032\0020\0202\006\020\034\032\0020\032H\026R\020\020\007\032\004\030\0010\bX\016¢\006\002\n\000R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\013\020\fR\026\020\r\032\n \016*\004\030\0010\0010\001X\004¢\006\002\n\000¨\006\035"}, d2 = {"Lio/javalin/compression/CompressedOutputStream;", "Ljakarta/servlet/ServletOutputStream;", "compression", "Lio/javalin/compression/CompressionStrategy;", "ctx", "Lio/javalin/http/Context;", "(Lio/javalin/compression/CompressionStrategy;Lio/javalin/http/Context;)V", "compressedStream", "Ljava/io/OutputStream;", "getCompression", "()Lio/javalin/compression/CompressionStrategy;", "getCtx", "()Lio/javalin/http/Context;", "originStream", "kotlin.jvm.PlatformType", "close", "", "isReady", "", "setWriteListener", "writeListener", "Ljakarta/servlet/WriteListener;", "write", "bytes", "", "offset", "", "length", "byte", "javalin"})
public final class CompressedOutputStream extends ServletOutputStream {
  @NotNull
  private final CompressionStrategy compression;
  
  @NotNull
  private final Context ctx;
  
  private final ServletOutputStream originStream;
  
  @Nullable
  private OutputStream compressedStream;
  
  public CompressedOutputStream(@NotNull CompressionStrategy compression, @NotNull Context ctx) {
    this.compression = compression;
    this.ctx = ctx;
    this.originStream = this.ctx.res().getOutputStream();
  }
  
  @NotNull
  public final CompressionStrategy getCompression() {
    return this.compression;
  }
  
  @NotNull
  public final Context getCtx() {
    return this.ctx;
  }
  
  public void write(@NotNull byte[] bytes, int offset, int length) {
    Intrinsics.checkNotNullParameter(bytes, "bytes");
    if (this.compressedStream == null && length >= this.compression.getMinSizeForCompression() && CompressedStreamKt.access$allowsForCompression(this.compression, this.ctx.res().getContentType()) && !this.ctx.res().containsHeader("Content-Encoding")) {
      Intrinsics.checkNotNullExpressionValue(this.originStream, "originStream");
      Pair pair1 = CompressedStreamKt.access$tryMatchCompression(this.compression, this.ctx, (OutputStream)this.originStream), pair2 = pair1;
      int $i$a$-also-CompressedOutputStream$write$1 = 0;
      CompressionType type = (CompressionType)pair2.component1();
      OutputStream stream = (OutputStream)pair2.component2();
      this.compressedStream = stream;
      this.ctx.header("Content-Encoding", type.getTypeName());
      CompressedStreamKt.access$tryMatchCompression(this.compression, this.ctx, (OutputStream)this.originStream);
    } 
    if (this.compressedStream == null);
    ((OutputStream)this.originStream).write(bytes, offset, length);
  }
  
  public void write(int byte) {
    this.originStream.write(byte);
  }
  
  public void setWriteListener(@Nullable WriteListener writeListener) {
    this.originStream.setWriteListener(writeListener);
  }
  
  public boolean isReady() {
    return this.originStream.isReady();
  }
  
  public void close() {
    if (this.compressedStream != null) {
      this.compressedStream.close();
    } else {
    
    } 
  }
}
