package io.javalin.validation;

import io.javalin.json.JsonMapper;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000N\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\013\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020$\n\002\020 \n\002\020\000\n\002\030\002\n\002\030\002\n\002\b\002\b\026\030\000*\004\b\000\020\0012\b\022\004\022\002H\0010\002B%\022\b\020\003\032\004\030\0010\004\022\f\020\005\032\b\022\004\022\0028\0000\006\022\006\020\007\032\0020\b¢\006\002\020\tJ8\020\n\032\b\022\004\022\0028\0000\0002\034\020\n\032\030\022\004\022\0028\000\022\004\022\0020\f0\013j\b\022\004\022\0028\000`\r2\f\020\016\032\b\022\004\022\0028\0000\017J2\020\n\032\b\022\004\022\0028\0000\0002\034\020\n\032\030\022\004\022\0028\000\022\004\022\0020\f0\013j\b\022\004\022\0028\000`\r2\006\020\016\032\0020\004J@\020\n\032\b\022\004\022\0028\0000\0002\006\020\020\032\0020\0042\034\020\n\032\030\022\004\022\0028\000\022\004\022\0020\f0\013j\b\022\004\022\0028\000`\r2\f\020\016\032\b\022\004\022\0028\0000\017J:\020\n\032\b\022\004\022\0028\0000\0002\006\020\020\032\0020\0042\034\020\n\032\030\022\004\022\0028\000\022\004\022\0020\f0\013j\b\022\004\022\0028\000`\r2\006\020\016\032\0020\004J\r\020\021\032\0028\000H\027¢\006\002\020\022J=\020\023\032\0028\0002.\020\024\032*\022\034\022\032\022\004\022\0020\004\022\020\022\016\022\n\022\b\022\004\022\0020\0270\0170\0260\025\022\b\022\0060\030j\002`\0310\013H\027¢\006\002\020\032¨\006\033"}, d2 = {"Lio/javalin/validation/BodyValidator;", "T", "Lio/javalin/validation/BaseValidator;", "stringValue", "", "clazz", "Ljava/lang/Class;", "jsonMapper", "Lio/javalin/json/JsonMapper;", "(Ljava/lang/String;Ljava/lang/Class;Lio/javalin/json/JsonMapper;)V", "check", "Lkotlin/Function1;", "", "Lio/javalin/validation/Check;", "error", "Lio/javalin/validation/ValidationError;", "fieldName", "get", "()Ljava/lang/Object;", "getOrThrow", "exceptionFunction", "", "", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "javalin"})
public class BodyValidator<T> extends BaseValidator<T> {
  public BodyValidator(@Nullable String stringValue, @NotNull Class<T> clazz, @NotNull JsonMapper jsonMapper) {
    super(stringValue, clazz, "REQUEST_BODY", jsonMapper);
  }
  
  @NotNull
  public final BodyValidator<T> check(@NotNull Function1<? super T, Boolean> check, @NotNull String error) {
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    return check("REQUEST_BODY", check, error);
  }
  
  @NotNull
  public final BodyValidator<T> check(@NotNull Function1<? super T, Boolean> check, @NotNull ValidationError<T> error) {
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    return check("REQUEST_BODY", check, error);
  }
  
  @NotNull
  public final BodyValidator<T> check(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> check, @NotNull String error) {
    Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    Intrinsics.checkNotNull(addRule(fieldName, new BodyValidator$check$1(check), error), "null cannot be cast to non-null type io.javalin.validation.BodyValidator<T of io.javalin.validation.BodyValidator>");
    return (BodyValidator<T>)addRule(fieldName, new BodyValidator$check$1(check), error);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\n\n\000\n\002\020\013\n\002\b\004\020\000\032\0020\001\"\004\b\000\020\0022\b\020\003\032\004\030\001H\002H\n¢\006\004\b\004\020\005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"})
  static final class BodyValidator$check$1 extends Lambda implements Function1<T, Boolean> {
    BodyValidator$check$1(Function1<T, Boolean> $check) {
      super(1);
    }
    
    @NotNull
    public final Boolean invoke(@Nullable Object it) {
      Intrinsics.checkNotNull(it);
      return (Boolean)this.$check.invoke(it);
    }
  }
  
  @NotNull
  public final BodyValidator<T> check(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> check, @NotNull ValidationError<T> error) {
    Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    Intrinsics.checkNotNull(addRule(fieldName, new BodyValidator$check$2(check), error), "null cannot be cast to non-null type io.javalin.validation.BodyValidator<T of io.javalin.validation.BodyValidator>");
    return (BodyValidator<T>)addRule(fieldName, new BodyValidator$check$2(check), error);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\n\n\000\n\002\020\013\n\002\b\004\020\000\032\0020\001\"\004\b\000\020\0022\b\020\003\032\004\030\001H\002H\n¢\006\004\b\004\020\005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"})
  static final class BodyValidator$check$2 extends Lambda implements Function1<T, Boolean> {
    BodyValidator$check$2(Function1<T, Boolean> $check) {
      super(1);
    }
    
    @NotNull
    public final Boolean invoke(@Nullable Object it) {
      Intrinsics.checkNotNull(it);
      return (Boolean)this.$check.invoke(it);
    }
  }
  
  @NotNull
  public T get() {
    Intrinsics.checkNotNull(super.get());
    return super.get();
  }
  
  @NotNull
  public T getOrThrow(@NotNull Function1<? super Map<String, ? extends List<ValidationError<Object>>>, ? extends Exception> exceptionFunction) {
    Intrinsics.checkNotNullParameter(exceptionFunction, "exceptionFunction");
    Intrinsics.checkNotNull(super.getOrThrow(exceptionFunction));
    return super.getOrThrow(exceptionFunction);
  }
}
