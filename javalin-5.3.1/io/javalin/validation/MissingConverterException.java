package io.javalin.validation;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\026\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\004\030\0002\0060\001j\002`\002B\r\022\006\020\003\032\0020\004¢\006\002\020\005R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\006\020\007¨\006\b"}, d2 = {"Lio/javalin/validation/MissingConverterException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "className", "", "(Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "javalin"})
public final class MissingConverterException extends RuntimeException {
  @NotNull
  private final String className;
  
  public MissingConverterException(@NotNull String className) {
    this.className = className;
  }
  
  @NotNull
  public final String getClassName() {
    return this.className;
  }
}
