package io.javalin.validation;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020$\n\002\020\016\n\002\020 \n\002\030\002\n\002\020\000\n\002\b\004\030\0002\0060\001j\002`\002B%\022\036\020\003\032\032\022\004\022\0020\005\022\020\022\016\022\n\022\b\022\004\022\0020\b0\0070\0060\004¢\006\002\020\tR)\020\003\032\032\022\004\022\0020\005\022\020\022\016\022\n\022\b\022\004\022\0020\b0\0070\0060\004¢\006\b\n\000\032\004\b\n\020\013¨\006\f"}, d2 = {"Lio/javalin/validation/ValidationException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errors", "", "", "", "Lio/javalin/validation/ValidationError;", "", "(Ljava/util/Map;)V", "getErrors", "()Ljava/util/Map;", "javalin"})
public final class ValidationException extends RuntimeException {
  @NotNull
  private final Map<String, List<ValidationError<Object>>> errors;
  
  public ValidationException(@NotNull Map<String, List<ValidationError<Object>>> errors) {
    this.errors = errors;
  }
  
  @NotNull
  public final Map<String, List<ValidationError<Object>>> getErrors() {
    return this.errors;
  }
}
