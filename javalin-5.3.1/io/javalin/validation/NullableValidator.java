package io.javalin.validation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0006\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\013\n\002\030\002\n\000\n\002\030\002\n\000\b\026\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\002B'\b\026\022\b\020\003\032\004\030\0010\004\022\f\020\005\032\b\022\004\022\0028\0000\006\022\006\020\007\032\0020\004¢\006\002\020\bB+\022\006\020\007\032\0020\004\022\n\b\002\020\t\032\004\030\0018\000\022\020\b\002\020\n\032\n\022\004\022\0028\000\030\0010\013¢\006\002\020\fJ<\020\r\032\b\022\004\022\0028\0000\0002 \020\r\032\034\022\006\022\004\030\0018\000\022\004\022\0020\0170\016j\n\022\006\022\004\030\0018\000`\0202\f\020\021\032\b\022\004\022\0028\0000\022J6\020\r\032\b\022\004\022\0028\0000\0002 \020\r\032\034\022\006\022\004\030\0018\000\022\004\022\0020\0170\016j\n\022\006\022\004\030\0018\000`\0202\006\020\021\032\0020\004¨\006\023"}, d2 = {"Lio/javalin/validation/NullableValidator;", "T", "Lio/javalin/validation/BaseValidator;", "stringValue", "", "clazz", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V", "typedValue", "stringSource", "Lio/javalin/validation/StringSource;", "(Ljava/lang/String;Ljava/lang/Object;Lio/javalin/validation/StringSource;)V", "check", "Lkotlin/Function1;", "", "Lio/javalin/validation/Check;", "error", "Lio/javalin/validation/ValidationError;", "javalin"})
public class NullableValidator<T> extends BaseValidator<T> {
  public NullableValidator(@NotNull String fieldName, @Nullable Object typedValue, @Nullable StringSource<T> stringSource) {
    super(fieldName, (T)typedValue, stringSource);
  }
  
  public NullableValidator(@Nullable String stringValue, @NotNull Class clazz, @NotNull String fieldName) {
    this(fieldName, (T)null, new StringSource<>(stringValue, clazz, null, 4, null));
  }
  
  @NotNull
  public final NullableValidator<T> check(@NotNull Function1<? super T, Boolean> check, @NotNull String error) {
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    Intrinsics.checkNotNull(addRule(getFieldName(), check, error), "null cannot be cast to non-null type io.javalin.validation.NullableValidator<T of io.javalin.validation.NullableValidator>");
    return (NullableValidator<T>)addRule(getFieldName(), check, error);
  }
  
  @NotNull
  public final NullableValidator<T> check(@NotNull Function1<? super T, Boolean> check, @NotNull ValidationError<T> error) {
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    Intrinsics.checkNotNull(addRule(getFieldName(), check, error), "null cannot be cast to non-null type io.javalin.validation.NullableValidator<T of io.javalin.validation.NullableValidator>");
    return (NullableValidator<T>)addRule(getFieldName(), check, error);
  }
}
