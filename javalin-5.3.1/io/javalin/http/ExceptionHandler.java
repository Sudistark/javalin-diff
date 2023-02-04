package io.javalin.http;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
public interface ExceptionHandler<T extends Exception> {
  void handle(@NotNull T paramT, @NotNull Context paramContext);
}
