package io.javalin.validation;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000R\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020%\n\002\030\002\n\002\030\002\n\002\020\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020$\n\002\020 \n\002\030\002\n\000\n\002\020\021\n\002\030\002\n\000\n\002\020\034\n\002\b\006\n\002\020\013\n\002\b\003\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\b\032\0020\t2\006\020\n\032\0020\013H\007JE\020\f\032\036\022\004\022\0020\007\022\024\022\022\022\016\022\f\022\b\b\001\022\004\030\0010\0010\0170\0160\r2\032\020\020\032\016\022\n\b\001\022\006\022\002\b\0030\0220\021\"\006\022\002\b\0030\022H\007¢\006\002\020\023J6\020\f\032\036\022\004\022\0020\007\022\024\022\022\022\016\022\f\022\b\b\001\022\004\030\0010\0010\0170\0160\r2\020\020\020\032\f\022\b\022\006\022\002\b\0030\0220\024H\007J)\020\025\032\002H\026\"\004\b\000\020\0262\f\020\027\032\b\022\004\022\002H\0260\0052\b\020\030\032\004\030\0010\007¢\006\002\020\031J\032\020\032\032\0020\033\"\004\b\000\020\0262\f\020\027\032\b\022\004\022\002H\0260\005J:\020\034\032\022\022\004\022\0020\007\022\006\022\004\030\0010\001\030\0010\0062\n\020\027\032\006\022\002\b\0030\0052\024\020\035\032\020\022\004\022\0020\007\022\006\022\004\030\0010\0010\006H\007R,\020\003\032 \022\b\022\006\022\002\b\0030\005\022\022\022\020\022\004\022\0020\007\022\006\022\004\030\0010\0010\0060\004X\004¢\006\002\n\000¨\006\036"}, d2 = {"Lio/javalin/validation/JavalinValidation;", "", "()V", "converters", "", "Ljava/lang/Class;", "Lkotlin/Function1;", "", "addValidationExceptionMapper", "", "app", "Lio/javalin/Javalin;", "collectErrors", "", "", "Lio/javalin/validation/ValidationError;", "validators", "", "Lio/javalin/validation/BaseValidator;", "([Lio/javalin/validation/BaseValidator;)Ljava/util/Map;", "", "convertValue", "T", "clazz", "value", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "hasConverter", "", "register", "converter", "javalin"})
public final class JavalinValidation {
  @NotNull
  public static final JavalinValidation INSTANCE = new JavalinValidation();
  
  @NotNull
  private static final Map<Class<?>, Function1<String, Object>> converters;
  
  static {
    Pair[] arrayOfPair = new Pair[12];
    arrayOfPair[0] = TuplesKt.to(Boolean.class, JavalinValidation$converters$1.INSTANCE);
    arrayOfPair[1] = 
      TuplesKt.to(Double.class, JavalinValidation$converters$2.INSTANCE);
    arrayOfPair[2] = TuplesKt.to(Float.class, JavalinValidation$converters$3.INSTANCE);
    arrayOfPair[3] = TuplesKt.to(Integer.class, JavalinValidation$converters$4.INSTANCE);
    arrayOfPair[4] = TuplesKt.to(Long.class, JavalinValidation$converters$5.INSTANCE);
    arrayOfPair[5] = TuplesKt.to(String.class, JavalinValidation$converters$6.INSTANCE);
    arrayOfPair[6] = TuplesKt.to(boolean.class, JavalinValidation$converters$7.INSTANCE);
    arrayOfPair[7] = TuplesKt.to(double.class, JavalinValidation$converters$8.INSTANCE);
    arrayOfPair[8] = TuplesKt.to(float.class, JavalinValidation$converters$9.INSTANCE);
    arrayOfPair[9] = TuplesKt.to(int.class, JavalinValidation$converters$10.INSTANCE);
    arrayOfPair[10] = TuplesKt.to(long.class, JavalinValidation$converters$11.INSTANCE);
    arrayOfPair[11] = TuplesKt.to(String.class, JavalinValidation$converters$12.INSTANCE);
    converters = MapsKt.mutableMapOf(arrayOfPair);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$1 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$1 INSTANCE = new JavalinValidation$converters$1();
    
    JavalinValidation$converters$1() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Boolean.valueOf(Boolean.parseBoolean(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$2 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$2 INSTANCE = new JavalinValidation$converters$2();
    
    JavalinValidation$converters$2() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Double.valueOf(Double.parseDouble(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$3 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$3 INSTANCE = new JavalinValidation$converters$3();
    
    JavalinValidation$converters$3() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Float.valueOf(Float.parseFloat(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$4 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$4 INSTANCE = new JavalinValidation$converters$4();
    
    JavalinValidation$converters$4() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Integer.valueOf(Integer.parseInt(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$5 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$5 INSTANCE = new JavalinValidation$converters$5();
    
    JavalinValidation$converters$5() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Long.valueOf(Long.parseLong(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$6 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$6 INSTANCE = new JavalinValidation$converters$6();
    
    JavalinValidation$converters$6() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it;
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$7 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$7 INSTANCE = new JavalinValidation$converters$7();
    
    JavalinValidation$converters$7() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Boolean.valueOf(Boolean.parseBoolean(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$8 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$8 INSTANCE = new JavalinValidation$converters$8();
    
    JavalinValidation$converters$8() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Double.valueOf(Double.parseDouble(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$9 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$9 INSTANCE = new JavalinValidation$converters$9();
    
    JavalinValidation$converters$9() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Float.valueOf(Float.parseFloat(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$10 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$10 INSTANCE = new JavalinValidation$converters$10();
    
    JavalinValidation$converters$10() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Integer.valueOf(Integer.parseInt(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$11 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$11 INSTANCE = new JavalinValidation$converters$11();
    
    JavalinValidation$converters$11() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Long.valueOf(Long.parseLong(it));
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\000\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class JavalinValidation$converters$12 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$12 INSTANCE = new JavalinValidation$converters$12();
    
    JavalinValidation$converters$12() {
      super(1);
    }
    
    @NotNull
    public final Object invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it;
    }
  }
  
  public final <T> T convertValue(@NotNull Class clazz, @Nullable String value) {
    Function1 converter;
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    if ((Function1)converters.get(clazz) == null) {
      (Function1)converters.get(clazz);
      Intrinsics.checkNotNullExpressionValue(clazz.getSimpleName(), "clazz.simpleName");
      throw new MissingConverterException(clazz.getSimpleName());
    } 
    return (value != null) ? (T)converter.invoke(value) : null;
  }
  
  public final <T> boolean hasConverter(@NotNull Class clazz) {
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return (converters.get(clazz) != null);
  }
  
  @JvmStatic
  @Nullable
  public static final Function1<String, Object> register(@NotNull Class<?> clazz, @NotNull Function1<String, Object> converter) {
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    Intrinsics.checkNotNullParameter(converter, "converter");
    return converters.put(clazz, converter);
  }
  
  @JvmStatic
  @NotNull
  public static final Map<String, List<ValidationError<? extends Object>>> collectErrors(@NotNull BaseValidator... validators) {
    Intrinsics.checkNotNullParameter(validators, "validators");
    return collectErrors(ArraysKt.toList((Object[])validators));
  }
  
  @JvmStatic
  @NotNull
  public static final Map<String, List<ValidationError<? extends Object>>> collectErrors(@NotNull Iterable validators) {
    Intrinsics.checkNotNullParameter(validators, "validators");
    Iterable $this$flatMap$iv = validators;
    int $i$f$flatMap = 0;
    Iterable iterable1 = $this$flatMap$iv;
    Collection destination$iv$iv = new ArrayList();
    int $i$f$flatMapTo = 0;
    for (Object element$iv$iv : iterable1) {
      BaseValidator it = (BaseValidator)element$iv$iv;
      int $i$a$-flatMap-JavalinValidation$collectErrors$1 = 0;
      Iterable list$iv$iv = it.errors().entrySet();
      CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
    } 
    $this$flatMap$iv = destination$iv$iv;
    int $i$f$associate = 0;
    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$flatMap$iv, 10)), 16);
    Iterable iterable2 = $this$flatMap$iv;
    Map<Object, Object> map = new LinkedHashMap<>(capacity$iv);
    int $i$f$associateTo = 0;
    for (Object element$iv$iv : iterable2) {
      Map<Object, Object> map1 = map;
      Map.Entry it = (Map.Entry)element$iv$iv;
      int $i$a$-associate-JavalinValidation$collectErrors$2 = 0;
      Pair pair = TuplesKt.to(it.getKey(), it.getValue());
      map1.put(pair.getFirst(), pair.getSecond());
    } 
    return (Map)map;
  }
  
  @JvmStatic
  public static final void addValidationExceptionMapper(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    app.exception(ValidationException.class, JavalinValidation::addValidationExceptionMapper$lambda-2);
  }
  
  private static final void addValidationExceptionMapper$lambda-2(ValidationException e, Context ctx) {
    Intrinsics.checkNotNullParameter(e, "e");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    ctx.json(e.getErrors()).status(HttpStatus.BAD_REQUEST);
  }
}
