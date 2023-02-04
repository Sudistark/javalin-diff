package io.javalin.websocket;

import org.jetbrains.annotations.NotNull;

public class WsConfig {
  WsConnectHandler wsConnectHandler = null;
  
  WsMessageHandler wsMessageHandler = null;
  
  WsBinaryMessageHandler wsBinaryMessageHandler = null;
  
  WsCloseHandler wsCloseHandler = null;
  
  WsErrorHandler wsErrorHandler = null;
  
  public void onConnect(@NotNull WsConnectHandler wsConnectHandler) {
    this.wsConnectHandler = wsConnectHandler;
  }
  
  public void onMessage(@NotNull WsMessageHandler wsMessageHandler) {
    this.wsMessageHandler = wsMessageHandler;
  }
  
  public void onBinaryMessage(@NotNull WsBinaryMessageHandler wsBinaryMessageHandler) {
    this.wsBinaryMessageHandler = wsBinaryMessageHandler;
  }
  
  public void onClose(@NotNull WsCloseHandler wsCloseHandler) {
    this.wsCloseHandler = wsCloseHandler;
  }
  
  public void onError(@NotNull WsErrorHandler wsErrorHandler) {
    this.wsErrorHandler = wsErrorHandler;
  }
}
