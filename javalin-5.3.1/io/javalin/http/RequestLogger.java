package io.javalin.http;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface RequestLogger {
  void handle(@NotNull Context paramContext, @NotNull Float paramFloat) throws Exception;
}
