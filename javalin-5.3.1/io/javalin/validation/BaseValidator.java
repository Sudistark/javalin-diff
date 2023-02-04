package io.javalin.validation;

import io.javalin.json.JsonMapper;
import io.javalin.util.JavalinLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000b\n\002\030\002\n\000\n\002\020\000\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020$\n\002\020 \n\002\030\002\n\002\b\007\n\002\020!\n\002\030\002\n\002\b\013\n\002\030\002\n\002\020\013\n\002\030\002\n\002\b\004\n\002\030\002\n\002\030\002\n\002\b\002\b\026\030\000*\004\b\000\020\0012\0020\002B3\b\026\022\b\020\003\032\004\030\0010\004\022\f\020\005\032\b\022\004\022\0028\0000\006\022\006\020\007\032\0020\004\022\n\b\002\020\b\032\004\030\0010\t¢\006\002\020\nB'\022\006\020\007\032\0020\004\022\b\020\013\032\004\030\0018\000\022\016\020\f\032\n\022\004\022\0028\000\030\0010\r¢\006\002\020\016JF\020%\032\b\022\004\022\0028\0000\0002\006\020\007\032\0020\0042 \020&\032\034\022\006\022\004\030\0018\000\022\004\022\0020(0'j\n\022\006\022\004\030\0018\000`)2\f\020*\032\b\022\004\022\0028\0000\022H\004J@\020%\032\b\022\004\022\0028\0000\0002\006\020\007\032\0020\0042 \020&\032\034\022\006\022\004\030\0018\000\022\004\022\0020(0'j\n\022\006\022\004\030\0018\000`)2\006\020*\032\0020\004H\004J\036\020\017\032\032\022\004\022\0020\004\022\020\022\016\022\n\022\b\022\004\022\0028\0000\0220\0210\020J\017\020+\032\004\030\0018\000H\026¢\006\002\020!J?\020,\032\004\030\0018\0002.\020-\032*\022\034\022\032\022\004\022\0020\004\022\020\022\016\022\n\022\b\022\004\022\0020\0020\0220\0210\020\022\b\022\0060.j\002`/0'H\026¢\006\002\0200R3\020\017\032\032\022\004\022\0020\004\022\020\022\016\022\n\022\b\022\004\022\0028\0000\0220\0210\0208BX\002¢\006\f\n\004\b\025\020\026\032\004\b\023\020\024R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\027\020\030R \020\031\032\016\022\n\022\b\022\004\022\0028\0000\0330\032X\004¢\006\b\n\000\032\004\b\034\020\035R\034\020\f\032\n\022\004\022\0028\000\030\0010\rX\004¢\006\b\n\000\032\004\b\036\020\037R\036\020\013\032\004\030\0018\000X\016¢\006\020\n\002\020$\032\004\b \020!\"\004\b\"\020#¨\0061"}, d2 = {"Lio/javalin/validation/BaseValidator;", "T", "", "stringValue", "", "clazz", "Ljava/lang/Class;", "fieldName", "jsonMapper", "Lio/javalin/json/JsonMapper;", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Lio/javalin/json/JsonMapper;)V", "typedValue", "stringSource", "Lio/javalin/validation/StringSource;", "(Ljava/lang/String;Ljava/lang/Object;Lio/javalin/validation/StringSource;)V", "errors", "", "", "Lio/javalin/validation/ValidationError;", "getErrors", "()Ljava/util/Map;", "errors$delegate", "Lkotlin/Lazy;", "getFieldName", "()Ljava/lang/String;", "rules", "", "Lio/javalin/validation/Rule;", "getRules$javalin", "()Ljava/util/List;", "getStringSource", "()Lio/javalin/validation/StringSource;", "getTypedValue", "()Ljava/lang/Object;", "setTypedValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "addRule", "check", "Lkotlin/Function1;", "", "Lio/javalin/validation/Check;", "error", "get", "getOrThrow", "exceptionFunction", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "javalin"})
public class BaseValidator<T> {
  @NotNull
  private final String fieldName;
  
  @Nullable
  private T typedValue;
  
  @Nullable
  private final StringSource<T> stringSource;
  
  @NotNull
  private final List<Rule<T>> rules;
  
  @NotNull
  private final Lazy errors$delegate;
  
  public BaseValidator(@NotNull String fieldName, @Nullable Object typedValue, @Nullable StringSource<T> stringSource) {
    this.fieldName = fieldName;
    this.typedValue = (T)typedValue;
    this.stringSource = stringSource;
    this.rules = new ArrayList<>();
    this.errors$delegate = LazyKt.lazy(new BaseValidator$errors$2());
  }
  
  @NotNull
  public final String getFieldName() {
    return this.fieldName;
  }
  
  @Nullable
  protected final T getTypedValue() {
    return this.typedValue;
  }
  
  protected final void setTypedValue(@Nullable Object <set-?>) {
    this.typedValue = (T)<set-?>;
  }
  
  @Nullable
  protected final StringSource<T> getStringSource() {
    return this.stringSource;
  }
  
  @NotNull
  public final List<Rule<T>> getRules$javalin() {
    return this.rules;
  }
  
  public BaseValidator(@Nullable String stringValue, @NotNull Class<T> clazz, @NotNull String fieldName, @Nullable JsonMapper jsonMapper) {
    this(fieldName, null, new StringSource<>(stringValue, clazz, jsonMapper));
  }
  
  private final Map<String, List<ValidationError<T>>> getErrors() {
    Lazy lazy = this.errors$delegate;
    return (Map<String, List<ValidationError<T>>>)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\026\n\000\n\002\020$\n\002\020\016\n\002\020 \n\002\030\002\n\002\b\002\020\000\032\032\022\004\022\0020\002\022\020\022\016\022\n\022\b\022\004\022\002H\0050\0040\0030\001\"\004\b\000\020\005H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "", "", "Lio/javalin/validation/ValidationError;", "T", "invoke"})
  static final class BaseValidator$errors$2 extends Lambda implements Function0<Map<String, ? extends List<? extends ValidationError<T>>>> {
    @NotNull
    public final Map<String, List<ValidationError<T>>> invoke() {
      if (BaseValidator.this.getStringSource() != null)
        if (BaseValidator.this instanceof BodyValidator) {
          try {
            Intrinsics.checkNotNull(BaseValidator.this.getStringSource().getJsonMapper());
            Intrinsics.checkNotNull(BaseValidator.this.getStringSource().getStringValue());
            BaseValidator.this.setTypedValue(BaseValidator.this.getStringSource().getJsonMapper().fromJsonString(BaseValidator.this.getStringSource().getStringValue(), BaseValidator.this.getStringSource().getClazz()));
          } catch (Exception e) {
            JavalinLogger.info("Couldn't deserialize body to " + BaseValidator.this.getStringSource().getClazz().getSimpleName(), e);
            return MapsKt.mapOf(TuplesKt.to("REQUEST_BODY", CollectionsKt.listOf(new ValidationError("DESERIALIZATION_FAILED", null, BaseValidator.this.getStringSource().getStringValue(), 2, null))));
          } 
        } else if (BaseValidator.this instanceof NullableValidator || BaseValidator.this instanceof Validator) {
          try {
            BaseValidator.this.setTypedValue(JavalinValidation.INSTANCE.convertValue(BaseValidator.this.getStringSource().getClazz(), BaseValidator.this.getStringSource().getStringValue()));
          } catch (Exception e) {
            JavalinLogger.info$default("Parameter '" + BaseValidator.this.getFieldName() + "' with value '" + BaseValidator.this.getStringSource().getStringValue() + "' is not a valid " + BaseValidator.this.getStringSource().getClazz().getSimpleName(), null, 2, null);
            return MapsKt.mapOf(TuplesKt.to(BaseValidator.this.getFieldName(), CollectionsKt.listOf(new ValidationError("TYPE_CONVERSION_FAILED", null, BaseValidator.this.getStringSource().getStringValue(), 2, null))));
          } 
          if (!(BaseValidator.this instanceof NullableValidator) && BaseValidator.this.getTypedValue() == null)
            return MapsKt.mapOf(TuplesKt.to(BaseValidator.this.getFieldName(), CollectionsKt.listOf(new ValidationError("NULLCHECK_FAILED", null, BaseValidator.this.getStringSource().getStringValue(), 2, null)))); 
        }  
      Map<Object, Object> errors = new LinkedHashMap<>();
      List<Rule<T>> list1 = BaseValidator.this.getRules$javalin();
      BaseValidator<T> baseValidator = BaseValidator.this;
      int $i$f$filter = 0;
      List<Rule<T>> list2 = list1;
      Collection<Object<T>> collection = new ArrayList();
      int $i$f$filterTo = 0;
      for (Object<T> element$iv$iv : list2) {
        Rule<T> it = (Rule)element$iv$iv;
        int $i$a$-filter-BaseValidator$errors$2$1 = 0;
        if (!((Boolean)it.getCheck().invoke(baseValidator.getTypedValue())).booleanValue())
          collection.add(element$iv$iv); 
      } 
      Iterable $this$filter$iv = collection;
      baseValidator = BaseValidator.this;
      int $i$f$forEach = 0;
      Iterator iterator = $this$filter$iv.iterator();
      if (iterator.hasNext()) {
        Object element$iv = iterator.next();
        Rule failedRule = (Rule)element$iv;
        int $i$a$-forEach-BaseValidator$errors$2$2 = 0;
        errors.computeIfAbsent(failedRule.getFieldName(), BaseValidator$errors$2::invoke$lambda-3$lambda-1);
        Intrinsics.checkNotNull(errors.get(failedRule.getFieldName()));
        ValidationError validationError1 = failedRule.getError(), validationError2 = validationError1;
        List list = (List)errors.get(failedRule.getFieldName());
        int $i$a$-also-BaseValidator$errors$2$2$2 = 0;
      } 
      Map<Object, Object> $this$mapValues$iv = errors;
      int $i$f$mapValues = 0;
      Map<Object, Object> map1 = $this$mapValues$iv, destination$iv$iv = new LinkedHashMap<>(MapsKt.mapCapacity($this$mapValues$iv.size()));
      int $i$f$mapValuesTo = 0;
      Iterable<Map.Entry<Object, Object>> $this$associateByTo$iv$iv$iv = map1.entrySet();
      int $i$f$associateByTo = 0;
      for (Object<Object, Object> element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
        Map.Entry entry1 = (Map.Entry)element$iv$iv$iv;
        Map<Object, Object> map2 = destination$iv$iv;
        int $i$a$-associateByTo-MapsKt__MapsKt$mapValuesTo$1$iv$iv = 0;
        Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
        Object object = entry1.getKey();
        Map<Object, Object> map3 = map2;
        int $i$a$-mapValues-BaseValidator$errors$2$3 = 0;
      } 
      return MapsKt.toMap(destination$iv$iv);
    }
    
    private static final List invoke$lambda-3$lambda-1(String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return new ArrayList();
    }
    
    BaseValidator$errors$2() {
      super(0);
    }
  }
  
  @NotNull
  protected final BaseValidator<T> addRule(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> check, @NotNull String error) {
    Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    this.rules.add(new Rule<>(fieldName, check, new ValidationError<>(error, null, null, 6, null)));
    return this;
  }
  
  @NotNull
  protected final BaseValidator<T> addRule(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> check, @NotNull ValidationError<T> error) {
    Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    this.rules.add(new Rule<>(fieldName, check, error));
    return this;
  }
  
  @Nullable
  public T get() {
    return getOrThrow(BaseValidator$get$1.INSTANCE);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000$\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020$\n\002\020\016\n\002\020 \n\002\030\002\n\002\020\000\n\000\020\000\032\0060\001j\002`\002\"\004\b\000\020\0032\036\020\004\032\032\022\004\022\0020\006\022\020\022\016\022\n\022\b\022\004\022\0020\t0\b0\0070\005H\n¢\006\002\b\n"}, d2 = {"<anonymous>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "T", "it", "", "", "", "Lio/javalin/validation/ValidationError;", "", "invoke"})
  static final class BaseValidator$get$1 extends Lambda implements Function1<Map<String, ? extends List<? extends ValidationError<Object>>>, Exception> {
    public static final BaseValidator$get$1 INSTANCE = new BaseValidator$get$1();
    
    BaseValidator$get$1() {
      super(1);
    }
    
    @NotNull
    public final Exception invoke(@NotNull Map<String, ? extends List<ValidationError<Object>>> it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return new ValidationException(it);
    }
  }
  
  @Nullable
  public T getOrThrow(@NotNull Function1 exceptionFunction) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'exceptionFunction'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: nop
    //   7: aload_0
    //   8: invokespecial getErrors : ()Ljava/util/Map;
    //   11: invokeinterface isEmpty : ()Z
    //   16: ifeq -> 26
    //   19: aload_0
    //   20: getfield typedValue : Ljava/lang/Object;
    //   23: goto -> 46
    //   26: aload_1
    //   27: aload_0
    //   28: invokespecial getErrors : ()Ljava/util/Map;
    //   31: dup
    //   32: ldc 'null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.collections.List<io.javalin.validation.ValidationError<kotlin.Any>>>'
    //   34: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
    //   37: invokeinterface invoke : (Ljava/lang/Object;)Ljava/lang/Object;
    //   42: checkcast java/lang/Throwable
    //   45: athrow
    //   46: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #74	-> 6
    //   #75	-> 7
    //   #76	-> 26
    //   #77	-> 46
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	47	0	this	Lio/javalin/validation/BaseValidator;
    //   0	47	1	exceptionFunction	Lkotlin/jvm/functions/Function1;
  }
  
  @NotNull
  public final Map<String, List<ValidationError<T>>> errors() {
    return getErrors();
  }
}
