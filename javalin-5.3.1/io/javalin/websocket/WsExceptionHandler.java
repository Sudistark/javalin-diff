package io.javalin.websocket;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface WsExceptionHandler<T extends Exception> {
  void handle(@NotNull T paramT, @NotNull WsContext paramWsContext);
}
