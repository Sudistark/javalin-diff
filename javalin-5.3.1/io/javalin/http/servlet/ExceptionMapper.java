package io.javalin.http.servlet;

import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import io.javalin.http.ExceptionHandler;
import io.javalin.http.HttpResponseException;
import io.javalin.http.HttpStatus;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.jetty.JettyUtil;
import io.javalin.util.JavalinLogger;
import io.javalin.util.Util;
import jakarta.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000T\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\004\n\002\020%\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\003\n\002\b\002\n\002\020\001\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\003\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\035\020\017\032\0020\0202\006\020\021\032\0020\0222\006\020\023\032\0020\024H\000¢\006\002\b\025J\037\020\026\032\004\030\0010\0272\006\020\030\032\0020\0312\006\020\032\032\0020\024H\000¢\006\002\b\033J\024\020\034\032\0020\0352\n\020\036\032\0060\nj\002`\013H\002J\034\020\037\032\0020\0202\006\020\021\032\0020\0222\n\020\036\032\0060\nj\002`\013H\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006R5\020\007\032&\022\020\022\016\022\n\b\001\022\0060\nj\002`\0130\t\022\020\022\016\022\b\022\0060\nj\002`\013\030\0010\f0\b¢\006\b\n\000\032\004\b\r\020\016¨\006 "}, d2 = {"Lio/javalin/http/servlet/ExceptionMapper;", "", "cfg", "Lio/javalin/config/JavalinConfig;", "(Lio/javalin/config/JavalinConfig;)V", "getCfg", "()Lio/javalin/config/JavalinConfig;", "handlers", "", "Ljava/lang/Class;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lio/javalin/http/ExceptionHandler;", "getHandlers", "()Ljava/util/Map;", "handle", "", "ctx", "Lio/javalin/http/Context;", "t", "", "handle$javalin", "handleUnexpectedThrowable", "", "res", "Ljakarta/servlet/http/HttpServletResponse;", "throwable", "handleUnexpectedThrowable$javalin", "noUserHandler", "", "exception", "uncaughtException", "javalin"})
public final class ExceptionMapper {
  @NotNull
  private final JavalinConfig cfg;
  
  @NotNull
  private final Map<Class<? extends Exception>, ExceptionHandler<Exception>> handlers;
  
  public ExceptionMapper(@NotNull JavalinConfig cfg) {
    this.cfg = cfg;
    this.handlers = new LinkedHashMap<>();
  }
  
  @NotNull
  public final JavalinConfig getCfg() {
    return this.cfg;
  }
  
  @NotNull
  public final Map<Class<? extends Exception>, ExceptionHandler<Exception>> getHandlers() {
    return this.handlers;
  }
  
  public final void handle$javalin(@NotNull Context ctx, @NotNull Throwable t) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    Intrinsics.checkNotNullParameter(t, "t");
    if (t instanceof java.util.concurrent.CompletionException && t.getCause() instanceof Exception) {
      Intrinsics.checkNotNull(t.getCause(), "null cannot be cast to non-null type java.lang.Exception{ kotlin.TypeAliasesKt.Exception }");
      handle$javalin(ctx, t.getCause());
      return;
    } 
    if (t instanceof Exception && HttpResponseExceptionMapper.INSTANCE.canHandle(t) && noUserHandler((Exception)t)) {
      HttpResponseExceptionMapper.INSTANCE.handle((HttpResponseException)t, ctx);
    } else if (t instanceof Exception) {
      ((ExceptionHandler<Exception>)Util.INSTANCE.findByClass((Map)this.handlers, (Class)t.getClass())).handle((Exception)t, ctx);
      (ExceptionHandler<Exception>)Util.INSTANCE.findByClass((Map)this.handlers, (Class)t.getClass());
      if ((((ExceptionHandler<Exception>)Util.INSTANCE.findByClass((Map)this.handlers, (Class)t.getClass()) != null) ? Unit.INSTANCE : null) == null)
        uncaughtException(ctx, (Exception)t); 
    } else {
      handleUnexpectedThrowable$javalin(ctx.res(), t);
    } 
  }
  
  private final void uncaughtException(Context ctx, Exception exception) {
    JavalinLogger.warn("Uncaught exception", exception);
    HttpResponseExceptionMapper.INSTANCE.handle(new InternalServerErrorResponse(null, null, 3, null), ctx);
  }
  
  @Nullable
  public final Void handleUnexpectedThrowable$javalin(@NotNull HttpServletResponse res, @NotNull Throwable throwable) {
    Intrinsics.checkNotNullParameter(res, "res");
    Intrinsics.checkNotNullParameter(throwable, "throwable");
    if (((throwable instanceof java.util.concurrent.CompletionException) ? throwable : null) == null || ((throwable instanceof java.util.concurrent.CompletionException) ? throwable : null).getCause() == null)
      ((throwable instanceof java.util.concurrent.CompletionException) ? throwable : null).getCause(); 
    Throwable unwrapped = throwable;
    if (JettyUtil.INSTANCE.isClientAbortException(unwrapped) || JettyUtil.INSTANCE.isJettyTimeoutException(unwrapped)) {
      JavalinLogger.debug("Client aborted or timed out", throwable);
      return null;
    } 
    res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.getCode());
    JavalinLogger.error("Exception occurred while servicing http-request", throwable);
    return null;
  }
  
  private final boolean noUserHandler(Exception exception) {
    return (this.handlers.get(exception.getClass()) == null && this.handlers.get(HttpResponseException.class) == null);
  }
}
