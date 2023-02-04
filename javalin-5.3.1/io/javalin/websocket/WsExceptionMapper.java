package io.javalin.websocket;

import io.javalin.util.JavalinLogger;
import io.javalin.util.Util;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0002\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020%\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\002\n\002\b\002\n\002\030\002\n\000\030\0002\0020\001B\005¢\006\002\020\002J\032\020\013\032\0020\f2\n\020\r\032\0060\006j\002`\0072\006\020\016\032\0020\017R5\020\003\032&\022\020\022\016\022\n\b\001\022\0060\006j\002`\0070\005\022\020\022\016\022\b\022\0060\006j\002`\007\030\0010\b0\004¢\006\b\n\000\032\004\b\t\020\n¨\006\020"}, d2 = {"Lio/javalin/websocket/WsExceptionMapper;", "", "()V", "handlers", "", "Ljava/lang/Class;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lio/javalin/websocket/WsExceptionHandler;", "getHandlers", "()Ljava/util/Map;", "handle", "", "exception", "ctx", "Lio/javalin/websocket/WsContext;", "javalin"})
public final class WsExceptionMapper {
  @NotNull
  private final Map<Class<? extends Exception>, WsExceptionHandler<Exception>> handlers = new LinkedHashMap<>();
  
  @NotNull
  public final Map<Class<? extends Exception>, WsExceptionHandler<Exception>> getHandlers() {
    return this.handlers;
  }
  
  public final void handle(@NotNull Exception exception, @NotNull WsContext ctx) {
    Intrinsics.checkNotNullParameter(exception, "exception");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    WsExceptionHandler<Exception> handler = Util.INSTANCE.<WsExceptionHandler>findByClass((Map)this.handlers, (Class)exception.getClass());
    if (handler != null) {
      handler.handle(exception, ctx);
    } else {
      JavalinLogger.warn("Uncaught exception in WebSocket handler", exception);
      ctx.session.close(1011, exception.getMessage());
    } 
  }
}
