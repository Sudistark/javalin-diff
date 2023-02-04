package io.javalin.config;

import io.javalin.http.RequestLogger;
import io.javalin.websocket.WsConfig;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000(\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\016\020\005\032\0020\0062\006\020\007\032\0020\bJ\024\020\t\032\0020\0062\f\020\t\032\b\022\004\022\0020\0130\nR\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\f"}, d2 = {"Lio/javalin/config/RequestLoggerConfig;", "", "pvt", "Lio/javalin/config/PrivateConfig;", "(Lio/javalin/config/PrivateConfig;)V", "http", "", "requestLogger", "Lio/javalin/http/RequestLogger;", "ws", "Ljava/util/function/Consumer;", "Lio/javalin/websocket/WsConfig;", "javalin"})
public final class RequestLoggerConfig {
  @NotNull
  private final PrivateConfig pvt;
  
  public RequestLoggerConfig(@NotNull PrivateConfig pvt) {
    this.pvt = pvt;
  }
  
  public final void http(@NotNull RequestLogger requestLogger) {
    Intrinsics.checkNotNullParameter(requestLogger, "requestLogger");
    this.pvt.requestLogger = requestLogger;
  }
  
  public final void ws(@NotNull Consumer<WsConfig> ws) {
    Intrinsics.checkNotNullParameter(ws, "ws");
    WsConfig logger = new WsConfig();
    ws.accept(logger);
    this.pvt.wsLogger = logger;
  }
}
