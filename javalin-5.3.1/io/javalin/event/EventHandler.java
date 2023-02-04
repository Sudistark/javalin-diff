package io.javalin.event;

@FunctionalInterface
public interface EventHandler {
  void handleEvent() throws Exception;
}
