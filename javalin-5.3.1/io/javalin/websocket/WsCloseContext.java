package io.javalin.websocket;

import kotlin.Metadata;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\004\030\0002\0020\001B'\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\b\020\b\032\004\030\0010\003¢\006\002\020\tJ\b\020\b\032\004\030\0010\003J\006\020\n\032\0020\007R\020\020\b\032\004\030\0010\003X\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000¨\006\013"}, d2 = {"Lio/javalin/websocket/WsCloseContext;", "Lio/javalin/websocket/WsContext;", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "statusCode", "", "reason", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;ILjava/lang/String;)V", "status", "javalin"})
public final class WsCloseContext extends WsContext {
  private final int statusCode;
  
  @Nullable
  private final String reason;
  
  public WsCloseContext(@NotNull String sessionId, @NotNull Session session, int statusCode, @Nullable String reason) {
    super(sessionId, session);
    this.statusCode = statusCode;
    this.reason = reason;
  }
  
  public final int status() {
    return this.statusCode;
  }
  
  @Nullable
  public final String reason() {
    return this.reason;
  }
}
