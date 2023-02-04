package io.javalin.websocket;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@WebSocket
@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\\\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\006\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\004\n\002\020\003\n\002\b\002\n\002\020\022\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\b\007\030\0002\0020\001B\037\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\b\020\006\032\004\030\0010\007¢\006\002\020\bJ\"\020\021\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\0262\b\020\027\032\004\030\0010\016H\007J\020\020\030\032\0020\0222\006\020\023\032\0020\024H\007J\032\020\031\032\0020\0222\006\020\023\032\0020\0242\b\020\032\032\004\030\0010\033H\007J(\020\034\032\0020\0222\006\020\023\032\0020\0242\006\020\035\032\0020\0362\006\020\037\032\0020\0262\006\020 \032\0020\026H\007J\030\020\034\032\0020\0222\006\020\023\032\0020\0242\006\020!\032\0020\016H\007J$\020\"\032\0020\0222\006\020#\032\0020$2\022\020%\032\016\022\004\022\0020'\022\004\022\0020\0220&H\002J$\020(\032\0020\0222\006\020#\032\0020$2\022\020%\032\016\022\004\022\0020'\022\004\022\0020\0220&H\002R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\t\020\nR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\013\020\fR\016\020\r\032\0020\016X\004¢\006\002\n\000R\023\020\006\032\004\030\0010\007¢\006\b\n\000\032\004\b\017\020\020¨\006)"}, d2 = {"Lio/javalin/websocket/WsConnection;", "", "matcher", "Lio/javalin/websocket/WsPathMatcher;", "exceptionMapper", "Lio/javalin/websocket/WsExceptionMapper;", "wsLogger", "Lio/javalin/websocket/WsConfig;", "(Lio/javalin/websocket/WsPathMatcher;Lio/javalin/websocket/WsExceptionMapper;Lio/javalin/websocket/WsConfig;)V", "getExceptionMapper", "()Lio/javalin/websocket/WsExceptionMapper;", "getMatcher", "()Lio/javalin/websocket/WsPathMatcher;", "sessionId", "", "getWsLogger", "()Lio/javalin/websocket/WsConfig;", "onClose", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "statusCode", "", "reason", "onConnect", "onError", "throwable", "", "onMessage", "buffer", "", "offset", "length", "message", "tryAfterHandlers", "ctx", "Lio/javalin/websocket/WsContext;", "handle", "Lkotlin/Function1;", "Lio/javalin/websocket/WsEntry;", "tryBeforeAndEndpointHandlers", "javalin"})
public final class WsConnection {
  @NotNull
  private final WsPathMatcher matcher;
  
  @NotNull
  private final WsExceptionMapper exceptionMapper;
  
  @Nullable
  private final WsConfig wsLogger;
  
  @NotNull
  private final String sessionId;
  
  public WsConnection(@NotNull WsPathMatcher matcher, @NotNull WsExceptionMapper exceptionMapper, @Nullable WsConfig wsLogger) {
    this.matcher = matcher;
    this.exceptionMapper = exceptionMapper;
    this.wsLogger = wsLogger;
    Intrinsics.checkNotNullExpressionValue(UUID.randomUUID().toString(), "randomUUID().toString()");
    this.sessionId = UUID.randomUUID().toString();
  }
  
  @NotNull
  public final WsPathMatcher getMatcher() {
    return this.matcher;
  }
  
  @NotNull
  public final WsExceptionMapper getExceptionMapper() {
    return this.exceptionMapper;
  }
  
  @Nullable
  public final WsConfig getWsLogger() {
    return this.wsLogger;
  }
  
  @OnWebSocketConnect
  public final void onConnect(@NotNull Session session) {
    Intrinsics.checkNotNullParameter(session, "session");
    WsConnectContext ctx = new WsConnectContext(this.sessionId, session);
    tryBeforeAndEndpointHandlers(ctx, new WsConnection$onConnect$1(ctx));
    tryAfterHandlers(ctx, new WsConnection$onConnect$2(ctx));
    if (this.wsLogger != null && this.wsLogger.wsConnectHandler != null) {
      this.wsLogger.wsConnectHandler.handleConnect(ctx);
    } else {
    
    } 
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onConnect$1 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onConnect$1(WsConnectContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsConnectHandler != null) {
        (it.getWsConfig()).wsConnectHandler.handleConnect(this.$ctx);
      } else {
      
      } 
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onConnect$2 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onConnect$2(WsConnectContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsConnectHandler != null) {
        (it.getWsConfig()).wsConnectHandler.handleConnect(this.$ctx);
      } else {
      
      } 
    }
  }
  
  @OnWebSocketMessage
  public final void onMessage(@NotNull Session session, @NotNull String message) {
    Intrinsics.checkNotNullParameter(session, "session");
    Intrinsics.checkNotNullParameter(message, "message");
    WsMessageContext ctx = new WsMessageContext(this.sessionId, session, message);
    tryBeforeAndEndpointHandlers(ctx, new WsConnection$onMessage$1(ctx));
    tryAfterHandlers(ctx, new WsConnection$onMessage$2(ctx));
    if (this.wsLogger != null && this.wsLogger.wsMessageHandler != null) {
      this.wsLogger.wsMessageHandler.handleMessage(ctx);
    } else {
    
    } 
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onMessage$1 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onMessage$1(WsMessageContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsMessageHandler != null) {
        (it.getWsConfig()).wsMessageHandler.handleMessage(this.$ctx);
      } else {
      
      } 
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onMessage$2 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onMessage$2(WsMessageContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsMessageHandler != null) {
        (it.getWsConfig()).wsMessageHandler.handleMessage(this.$ctx);
      } else {
      
      } 
    }
  }
  
  @OnWebSocketMessage
  public final void onMessage(@NotNull Session session, @NotNull byte[] buffer, int offset, int length) {
    Intrinsics.checkNotNullParameter(session, "session");
    Intrinsics.checkNotNullParameter(buffer, "buffer");
    WsBinaryMessageContext ctx = new WsBinaryMessageContext(this.sessionId, session, buffer, offset, length);
    tryBeforeAndEndpointHandlers(ctx, new WsConnection$onMessage$3(ctx));
    tryAfterHandlers(ctx, new WsConnection$onMessage$4(ctx));
    if (this.wsLogger != null && this.wsLogger.wsBinaryMessageHandler != null) {
      this.wsLogger.wsBinaryMessageHandler.handleBinaryMessage(ctx);
    } else {
    
    } 
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onMessage$3 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onMessage$3(WsBinaryMessageContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsBinaryMessageHandler != null) {
        (it.getWsConfig()).wsBinaryMessageHandler.handleBinaryMessage(this.$ctx);
      } else {
      
      } 
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onMessage$4 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onMessage$4(WsBinaryMessageContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsBinaryMessageHandler != null) {
        (it.getWsConfig()).wsBinaryMessageHandler.handleBinaryMessage(this.$ctx);
      } else {
      
      } 
    }
  }
  
  @OnWebSocketClose
  public final void onClose(@NotNull Session session, int statusCode, @Nullable String reason) {
    Intrinsics.checkNotNullParameter(session, "session");
    WsCloseContext ctx = new WsCloseContext(this.sessionId, session, statusCode, reason);
    tryBeforeAndEndpointHandlers(ctx, new WsConnection$onClose$1(ctx));
    tryAfterHandlers(ctx, new WsConnection$onClose$2(ctx));
    if (this.wsLogger != null && this.wsLogger.wsCloseHandler != null) {
      this.wsLogger.wsCloseHandler.handleClose(ctx);
    } else {
    
    } 
    ctx.disableAutomaticPings();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onClose$1 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onClose$1(WsCloseContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsCloseHandler != null) {
        (it.getWsConfig()).wsCloseHandler.handleClose(this.$ctx);
      } else {
      
      } 
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onClose$2 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onClose$2(WsCloseContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsCloseHandler != null) {
        (it.getWsConfig()).wsCloseHandler.handleClose(this.$ctx);
      } else {
      
      } 
    }
  }
  
  @OnWebSocketError
  public final void onError(@NotNull Session session, @Nullable Throwable throwable) {
    Intrinsics.checkNotNullParameter(session, "session");
    WsErrorContext ctx = new WsErrorContext(this.sessionId, session, throwable);
    tryBeforeAndEndpointHandlers(ctx, new WsConnection$onError$1(ctx));
    tryAfterHandlers(ctx, new WsConnection$onError$2(ctx));
    if (this.wsLogger != null && this.wsLogger.wsErrorHandler != null) {
      this.wsLogger.wsErrorHandler.handleError(ctx);
    } else {
    
    } 
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onError$1 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onError$1(WsErrorContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsErrorHandler != null) {
        (it.getWsConfig()).wsErrorHandler.handleError(this.$ctx);
      } else {
      
      } 
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/websocket/WsEntry;", "invoke"})
  static final class WsConnection$onError$2 extends Lambda implements Function1<WsEntry, Unit> {
    WsConnection$onError$2(WsErrorContext $ctx) {
      super(1);
    }
    
    public final void invoke(@NotNull WsEntry it) {
      Intrinsics.checkNotNullParameter(it, "it");
      if ((it.getWsConfig()).wsErrorHandler != null) {
        (it.getWsConfig()).wsErrorHandler.handleError(this.$ctx);
      } else {
      
      } 
    }
  }
  
  private final void tryBeforeAndEndpointHandlers(WsContext ctx, Function1 handle) {
    String requestUri = WsConnectionKt.access$uriNoContextPath(ctx.session);
    try {
      Iterable<WsEntry> $this$forEach$iv = this.matcher.findBeforeHandlerEntries(requestUri);
      int $i$f$forEach = 0;
      for (WsEntry element$iv : $this$forEach$iv) {
        WsEntry wsEntry1 = element$iv;
        int $i$a$-forEach-WsConnection$tryBeforeAndEndpointHandlers$1 = 0;
        handle.invoke(wsEntry1);
      } 
      Intrinsics.checkNotNull(this.matcher.findEndpointHandlerEntry(requestUri));
      WsEntry it = this.matcher.findEndpointHandlerEntry(requestUri);
      int $i$a$-let-WsConnection$tryBeforeAndEndpointHandlers$2 = 0;
      handle.invoke(it);
    } catch (Exception e) {
      this.exceptionMapper.handle(e, ctx);
    } 
  }
  
  private final void tryAfterHandlers(WsContext ctx, Function1 handle) {
    String requestUri = WsConnectionKt.access$uriNoContextPath(ctx.session);
    try {
      Iterable<WsEntry> $this$forEach$iv = this.matcher.findAfterHandlerEntries(requestUri);
      int $i$f$forEach = 0;
      for (WsEntry element$iv : $this$forEach$iv) {
        WsEntry it = element$iv;
        int $i$a$-forEach-WsConnection$tryAfterHandlers$1 = 0;
        handle.invoke(it);
      } 
    } catch (Exception e) {
      this.exceptionMapper.handle(e, ctx);
    } 
  }
}
