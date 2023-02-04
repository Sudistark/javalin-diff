package io.javalin.http.servlet;

import io.javalin.http.Context;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponseWrapper;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\005\032\0020\006H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\007"}, d2 = {"Lio/javalin/http/servlet/JavalinResourceResponseWrapper;", "Ljakarta/servlet/http/HttpServletResponseWrapper;", "ctx", "Lio/javalin/http/Context;", "(Lio/javalin/http/Context;)V", "getOutputStream", "Ljakarta/servlet/ServletOutputStream;", "javalin"})
final class JavalinResourceResponseWrapper extends HttpServletResponseWrapper {
  @NotNull
  private final Context ctx;
  
  public JavalinResourceResponseWrapper(@NotNull Context ctx) {
    super(ctx.res());
    this.ctx = ctx;
  }
  
  @NotNull
  public ServletOutputStream getOutputStream() {
    return this.ctx.outputStream();
  }
}
