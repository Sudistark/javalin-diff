package io.javalin.websocket;

import kotlin.Metadata;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\003\n\002\b\002\030\0002\0020\001B\037\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\b\020\006\032\004\030\0010\007¢\006\002\020\bJ\b\020\006\032\004\030\0010\007R\020\020\006\032\004\030\0010\007X\004¢\006\002\n\000¨\006\t"}, d2 = {"Lio/javalin/websocket/WsErrorContext;", "Lio/javalin/websocket/WsContext;", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "error", "", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;Ljava/lang/Throwable;)V", "javalin"})
public final class WsErrorContext extends WsContext {
  @Nullable
  private final Throwable error;
  
  public WsErrorContext(@NotNull String sessionId, @NotNull Session session, @Nullable Throwable error) {
    super(sessionId, session);
    this.error = error;
  }
  
  @Nullable
  public final Throwable error() {
    return this.error;
  }
}
