package io.javalin.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\003\n\002\b\002\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006¨\006\007"}, d2 = {"Lio/javalin/util/JavalinBindException;", "Lio/javalin/util/JavalinException;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "javalin"})
public final class JavalinBindException extends JavalinException {
  public JavalinBindException(@NotNull String message, @NotNull Throwable cause) {
    super(message, cause);
  }
}
