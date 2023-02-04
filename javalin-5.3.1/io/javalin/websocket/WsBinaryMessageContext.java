package io.javalin.websocket;

import kotlin.Metadata;
import org.eclipse.jetty.websocket.api.Session;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000$\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\022\n\000\n\002\020\b\n\002\b\003\030\0002\0020\001B-\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t\022\006\020\n\032\0020\t¢\006\002\020\013J\006\020\006\032\0020\007J\006\020\n\032\0020\tJ\006\020\b\032\0020\tR\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\n\032\0020\tX\004¢\006\002\n\000R\016\020\b\032\0020\tX\004¢\006\002\n\000¨\006\f"}, d2 = {"Lio/javalin/websocket/WsBinaryMessageContext;", "Lio/javalin/websocket/WsContext;", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "data", "", "offset", "", "length", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;[BII)V", "javalin"})
public final class WsBinaryMessageContext extends WsContext {
  @NotNull
  private final byte[] data;
  
  private final int offset;
  
  private final int length;
  
  public WsBinaryMessageContext(@NotNull String sessionId, @NotNull Session session, @NotNull byte[] data, int offset, int length) {
    super(sessionId, session);
    this.data = data;
    this.offset = offset;
    this.length = length;
  }
  
  @NotNull
  public final byte[] data() {
    return this.data;
  }
  
  public final int offset() {
    return this.offset;
  }
  
  public final int length() {
    return this.length;
  }
}
