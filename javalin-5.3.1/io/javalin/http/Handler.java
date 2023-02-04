package io.javalin.http;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface Handler {
  void handle(@NotNull Context paramContext) throws Exception;
}
