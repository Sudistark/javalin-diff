package io.javalin.validation;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000 \n\000\n\002\020$\n\002\020\016\n\002\020 \n\002\030\002\n\002\020\000\n\002\020\034\n\002\030\002\n\000\0320\020\000\032\036\022\004\022\0020\002\022\024\022\022\022\016\022\f\022\b\b\001\022\004\030\0010\0050\0040\0030\001*\f\022\b\022\006\022\002\b\0030\0070\006¨\006\b"}, d2 = {"collectErrors", "", "", "", "Lio/javalin/validation/ValidationError;", "", "", "Lio/javalin/validation/BaseValidator;", "javalin"})
public final class JavalinValidationKt {
  @NotNull
  public static final Map<String, List<ValidationError<? extends Object>>> collectErrors(@NotNull Iterable<? extends BaseValidator<?>> $this$collectErrors) {
    Intrinsics.checkNotNullParameter($this$collectErrors, "<this>");
    return JavalinValidation.collectErrors($this$collectErrors);
  }
}
