package io.javalin.validation;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000V\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\020\013\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\020$\n\002\020 \n\002\020\000\n\002\030\002\n\002\030\002\n\002\b\004\b\026\030\000 #*\004\b\000\020\0012\b\022\004\022\002H\0010\002:\001#B'\b\026\022\b\020\003\032\004\030\0010\004\022\f\020\005\032\b\022\004\022\0028\0000\006\022\006\020\007\032\0020\004¢\006\002\020\bB+\022\006\020\007\032\0020\004\022\n\b\002\020\t\032\004\030\0018\000\022\020\b\002\020\n\032\n\022\004\022\0028\000\030\0010\013¢\006\002\020\fJ\f\020\r\032\b\022\004\022\0028\0000\016J8\020\017\032\b\022\004\022\0028\0000\0002\034\020\017\032\030\022\004\022\0028\000\022\004\022\0020\0210\020j\b\022\004\022\0028\000`\0222\f\020\023\032\b\022\004\022\0028\0000\024J2\020\017\032\b\022\004\022\0028\0000\0002\034\020\017\032\030\022\004\022\0028\000\022\004\022\0020\0210\020j\b\022\004\022\0028\000`\0222\006\020\023\032\0020\004J\r\020\025\032\0028\000H\027¢\006\002\020\026J\023\020\027\032\0028\0002\006\020\030\032\0028\000¢\006\002\020\031JB\020\032\032\004\b\0028\0002.\020\033\032*\022\034\022\032\022\004\022\0020\004\022\020\022\016\022\n\022\b\022\004\022\0020\0360\0240\0350\034\022\b\022\0060\037j\002` 0\020H\027ø\001\000¢\006\002\020!J\006\020\"\032\0020\021\002\004\n\002\b9¨\006$"}, d2 = {"Lio/javalin/validation/Validator;", "T", "Lio/javalin/validation/BaseValidator;", "stringValue", "", "clazz", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V", "typedValue", "stringSource", "Lio/javalin/validation/StringSource;", "(Ljava/lang/String;Ljava/lang/Object;Lio/javalin/validation/StringSource;)V", "allowNullable", "Lio/javalin/validation/NullableValidator;", "check", "Lkotlin/Function1;", "", "Lio/javalin/validation/Check;", "error", "Lio/javalin/validation/ValidationError;", "get", "()Ljava/lang/Object;", "getOrDefault", "default", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrThrow", "exceptionFunction", "", "", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasValue", "Companion", "javalin"})
public class Validator<T> extends BaseValidator<T> {
  @NotNull
  public static final Companion Companion = new Companion(null);
  
  public Validator(@NotNull String fieldName, @Nullable Object typedValue, @Nullable StringSource<T> stringSource) {
    super(fieldName, (T)typedValue, stringSource);
  }
  
  public Validator(@Nullable String stringValue, @NotNull Class clazz, @NotNull String fieldName) {
    this(fieldName, (T)null, new StringSource<>(stringValue, clazz, null, 4, null));
  }
  
  @NotNull
  public final NullableValidator<T> allowNullable() {
    if (getRules$javalin().isEmpty())
      return new NullableValidator<>(getFieldName(), getTypedValue(), getStringSource()); 
    throw new IllegalStateException("Validator#allowNullable must be called before adding rules");
  }
  
  @NotNull
  public final Validator<T> check(@NotNull Function1<? super T, Boolean> check, @NotNull String error) {
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    Intrinsics.checkNotNull(addRule(getFieldName(), new Validator$check$1(check), error), "null cannot be cast to non-null type io.javalin.validation.Validator<T of io.javalin.validation.Validator>");
    return (Validator<T>)addRule(getFieldName(), new Validator$check$1(check), error);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\n\n\000\n\002\020\013\n\002\b\004\020\000\032\0020\001\"\004\b\000\020\0022\b\020\003\032\004\030\001H\002H\n¢\006\004\b\004\020\005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"})
  static final class Validator$check$1 extends Lambda implements Function1<T, Boolean> {
    Validator$check$1(Function1<T, Boolean> $check) {
      super(1);
    }
    
    @NotNull
    public final Boolean invoke(@Nullable Object it) {
      Intrinsics.checkNotNull(it);
      return (Boolean)this.$check.invoke(it);
    }
  }
  
  @NotNull
  public final Validator<T> check(@NotNull Function1<? super T, Boolean> check, @NotNull ValidationError<T> error) {
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    Intrinsics.checkNotNull(addRule(getFieldName(), new Validator$check$2(check), error), "null cannot be cast to non-null type io.javalin.validation.Validator<T of io.javalin.validation.Validator>");
    return (Validator<T>)addRule(getFieldName(), new Validator$check$2(check), error);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\n\n\000\n\002\020\013\n\002\b\004\020\000\032\0020\001\"\004\b\000\020\0022\b\020\003\032\004\030\001H\002H\n¢\006\004\b\004\020\005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Boolean;"})
  static final class Validator$check$2 extends Lambda implements Function1<T, Boolean> {
    Validator$check$2(Function1<T, Boolean> $check) {
      super(1);
    }
    
    @NotNull
    public final Boolean invoke(@Nullable Object it) {
      Intrinsics.checkNotNull(it);
      return (Boolean)this.$check.invoke(it);
    }
  }
  
  public final boolean hasValue() {
    getStringSource();
    return (((getStringSource() != null) ? getStringSource().getStringValue() : null) != null || getTypedValue() != null);
  }
  
  @NotNull
  public T get() {
    Intrinsics.checkNotNull(super.get());
    return super.get();
  }
  
  public final T getOrDefault(Object default) {
    Intrinsics.checkNotNull(super.get());
    return hasValue() ? super.get() : (T)default;
  }
  
  @NotNull
  public T getOrThrow(@NotNull Function1<? super Map<String, ? extends List<ValidationError<Object>>>, ? extends Exception> exceptionFunction) {
    Intrinsics.checkNotNullParameter(exceptionFunction, "exceptionFunction");
    Intrinsics.checkNotNull(super.getOrThrow(exceptionFunction));
    return super.getOrThrow(exceptionFunction);
  }
  
  @JvmStatic
  @NotNull
  public static final <T> Validator<T> create(@NotNull Class<T> clazz, @Nullable String value, @NotNull String fieldName) {
    return Companion.create(clazz, value, fieldName);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J4\020\003\032\b\022\004\022\002H\0050\004\"\004\b\001\020\0052\f\020\006\032\b\022\004\022\002H\0050\0072\b\020\b\032\004\030\0010\t2\006\020\n\032\0020\tH\007¨\006\013"}, d2 = {"Lio/javalin/validation/Validator$Companion;", "", "()V", "create", "Lio/javalin/validation/Validator;", "T", "clazz", "Ljava/lang/Class;", "value", "", "fieldName", "javalin"})
  public static final class Companion {
    private Companion() {}
    
    @JvmStatic
    @NotNull
    public final <T> Validator<T> create(@NotNull Class<?> clazz, @Nullable String value, @NotNull String fieldName) {
      // Byte code:
      //   0: aload_1
      //   1: ldc 'clazz'
      //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
      //   6: aload_3
      //   7: ldc 'fieldName'
      //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
      //   12: getstatic io/javalin/validation/JavalinValidation.INSTANCE : Lio/javalin/validation/JavalinValidation;
      //   15: aload_1
      //   16: invokevirtual hasConverter : (Ljava/lang/Class;)Z
      //   19: ifeq -> 35
      //   22: new io/javalin/validation/Validator
      //   25: dup
      //   26: aload_2
      //   27: aload_1
      //   28: aload_3
      //   29: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V
      //   32: goto -> 62
      //   35: aload_1
      //   36: invokevirtual getSimpleName : ()Ljava/lang/String;
      //   39: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
      //   44: aconst_null
      //   45: iconst_2
      //   46: aconst_null
      //   47: invokestatic info$default : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
      //   50: new io/javalin/http/InternalServerErrorResponse
      //   53: dup
      //   54: aconst_null
      //   55: aconst_null
      //   56: iconst_3
      //   57: aconst_null
      //   58: invokespecial <init> : (Ljava/lang/String;Ljava/util/Map;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
      //   61: athrow
      //   62: areturn
      // Line number table:
      //   Java source line number -> byte code offset
      //   #42	-> 12
      //   #43	-> 22
      //   #45	-> 35
      //   #46	-> 50
      //   #47	-> 62
      // Local variable table:
      //   start	length	slot	name	descriptor
      //   0	63	0	this	Lio/javalin/validation/Validator$Companion;
      //   0	63	1	clazz	Ljava/lang/Class;
      //   0	63	2	value	Ljava/lang/String;
      //   0	63	3	fieldName	Ljava/lang/String;
    }
  }
}
