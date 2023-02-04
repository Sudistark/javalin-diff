package io.javalin.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\020\003\n\002\b\003\b\026\030\0002\0060\001j\002`\002B\017\b\026\022\006\020\003\032\0020\004¢\006\002\020\005B\027\b\026\022\006\020\003\032\0020\004\022\006\020\006\032\0020\007¢\006\002\020\bB\017\b\026\022\006\020\006\032\0020\007¢\006\002\020\t¨\006\n"}, d2 = {"Lio/javalin/util/JavalinException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "javalin"})
public class JavalinException extends RuntimeException {
  public JavalinException(@NotNull String message) {
    super(message);
  }
  
  public JavalinException(@NotNull String message, @NotNull Throwable cause) {
    super(message, cause);
  }
  
  public JavalinException(@NotNull Throwable cause) {
    super(cause);
  }
}
