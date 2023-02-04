package io.javalin.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000\036\n\000\n\002\020\016\n\002\020\000\n\002\b\003\n\002\020\013\n\002\b\013\n\002\030\002\n\002\b\005\032\024\020\025\032\0020\002*\0020\0022\006\020\026\032\0020\001H\000\"\032\020\000\032\004\030\0010\001*\0020\0028@X\004¢\006\006\032\004\b\003\020\004\"\030\020\005\032\0020\006*\0020\0028@X\004¢\006\006\032\004\b\005\020\007\"\030\020\b\032\0020\006*\0020\0028@X\004¢\006\006\032\004\b\b\020\007\"\030\020\t\032\0020\006*\0020\0028@X\004¢\006\006\032\004\b\t\020\007\"\030\020\n\032\0020\006*\0020\0028@X\004¢\006\006\032\004\b\n\020\007\"\030\020\013\032\0020\006*\0020\0028@X\004¢\006\006\032\004\b\013\020\007\"\030\020\f\032\0020\006*\0020\0028@X\004¢\006\006\032\004\b\f\020\007\"\032\020\r\032\004\030\0010\001*\0020\0028@X\004¢\006\006\032\004\b\016\020\004\"\030\020\017\032\0020\001*\0020\0028@X\004¢\006\006\032\004\b\020\020\004\"\034\020\021\032\006\022\002\b\0030\022*\0020\0028@X\004¢\006\006\032\004\b\023\020\024¨\006\027"}, d2 = {"implementingClassName", "", "", "getImplementingClassName", "(Ljava/lang/Object;)Ljava/lang/String;", "isClass", "", "(Ljava/lang/Object;)Z", "isJavaAnonymousLambda", "isJavaField", "isKotlinAnonymousLambda", "isKotlinField", "isKotlinMethodReference", "javaFieldName", "getJavaFieldName", "kotlinFieldName", "getKotlinFieldName", "parentClass", "Ljava/lang/Class;", "getParentClass", "(Ljava/lang/Object;)Ljava/lang/Class;", "runMethod", "name", "javalin"})
public final class ReflectionUtilKt {
  @NotNull
  public static final String getKotlinFieldName(@NotNull Object $this$kotlinFieldName) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '<this>'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokevirtual getClass : ()Ljava/lang/Class;
    //   10: invokevirtual toString : ()Ljava/lang/String;
    //   13: dup
    //   14: ldc 'this.javaClass.toString()'
    //   16: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokestatic getParentClass : (Ljava/lang/Object;)Ljava/lang/Class;
    //   23: invokevirtual toString : ()Ljava/lang/String;
    //   26: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   31: checkcast java/lang/CharSequence
    //   34: invokestatic removePrefix : (Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   37: astore_1
    //   38: iconst_0
    //   39: istore_2
    //   40: iconst_0
    //   41: istore_3
    //   42: aload_1
    //   43: invokevirtual length : ()I
    //   46: istore #4
    //   48: iload_3
    //   49: iload #4
    //   51: if_icmpge -> 108
    //   54: aload_1
    //   55: iload_3
    //   56: invokevirtual charAt : (I)C
    //   59: istore #5
    //   61: iconst_0
    //   62: istore #6
    //   64: iload #5
    //   66: bipush #36
    //   68: if_icmpeq -> 75
    //   71: iconst_1
    //   72: goto -> 76
    //   75: iconst_0
    //   76: ifne -> 102
    //   79: aload_1
    //   80: astore #5
    //   82: iconst_0
    //   83: istore #6
    //   85: aload #5
    //   87: iload #6
    //   89: iload_3
    //   90: invokevirtual substring : (II)Ljava/lang/String;
    //   93: dup
    //   94: ldc 'this as java.lang.String…ing(startIndex, endIndex)'
    //   96: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   99: goto -> 109
    //   102: iinc #3, 1
    //   105: goto -> 48
    //   108: aload_1
    //   109: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #4	-> 6
    //   #31	-> 40
    //   #32	-> 54
    //   #4	-> 64
    //   #33	-> 79
    //   #33	-> 99
    //   #31	-> 102
    //   #35	-> 108
    //   #4	-> 109
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   64	12	6	$i$a$-takeWhile-ReflectionUtilKt$kotlinFieldName$1	I
    //   61	15	5	it	C
    //   42	66	3	index$iv	I
    //   40	69	2	$i$f$takeWhile	I
    //   38	71	1	$this$takeWhile$iv	Ljava/lang/String;
    //   0	110	0	$this$kotlinFieldName	Ljava/lang/Object;
  }
  
  @Nullable
  public static final String getJavaFieldName(@NotNull Object $this$javaFieldName) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '<this>'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: nop
    //   7: aload_0
    //   8: invokestatic getParentClass : (Ljava/lang/Object;)Ljava/lang/Class;
    //   11: invokevirtual getDeclaredFields : ()[Ljava/lang/reflect/Field;
    //   14: dup
    //   15: ldc 'parentClass.declaredFields'
    //   17: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   20: checkcast [Ljava/lang/Object;
    //   23: astore_3
    //   24: iconst_0
    //   25: istore #4
    //   27: aload_3
    //   28: arraylength
    //   29: istore #5
    //   31: iload #4
    //   33: iload #5
    //   35: if_icmpge -> 85
    //   38: aload_3
    //   39: iload #4
    //   41: aaload
    //   42: astore #6
    //   44: aload #6
    //   46: checkcast java/lang/reflect/Field
    //   49: astore #7
    //   51: iconst_0
    //   52: istore #8
    //   54: aload #7
    //   56: iconst_1
    //   57: invokevirtual setAccessible : (Z)V
    //   60: aload #7
    //   62: aload #7
    //   64: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   67: aload_0
    //   68: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   71: ifeq -> 79
    //   74: aload #6
    //   76: goto -> 86
    //   79: iinc #4, 1
    //   82: goto -> 31
    //   85: aconst_null
    //   86: checkcast java/lang/reflect/Field
    //   89: dup
    //   90: ifnull -> 99
    //   93: invokevirtual getName : ()Ljava/lang/String;
    //   96: goto -> 101
    //   99: pop
    //   100: aconst_null
    //   101: astore_1
    //   102: goto -> 111
    //   105: astore_2
    //   106: aconst_null
    //   107: checkcast java/lang/String
    //   110: astore_1
    //   111: aload_1
    //   112: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #7	-> 6
    //   #8	-> 7
    //   #36	-> 51
    //   #8	-> 54
    //   #8	-> 71
    //   #8	-> 86
    //   #9	-> 105
    //   #10	-> 106
    //   #11	-> 112
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   54	17	8	$i$a$-find-ReflectionUtilKt$javaFieldName$1	I
    //   51	20	7	it	Ljava/lang/reflect/Field;
    //   106	5	2	ignored	Ljava/lang/Exception;
    //   0	113	0	$this$javaFieldName	Ljava/lang/Object;
    // Exception table:
    //   from	to	target	type
    //   6	102	105	java/lang/Exception
  }
  
  @NotNull
  public static final Class<?> getParentClass(@NotNull Object $this$parentClass) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '<this>'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokevirtual getClass : ()Ljava/lang/Class;
    //   10: invokevirtual getName : ()Ljava/lang/String;
    //   13: dup
    //   14: ldc 'this.javaClass.name'
    //   16: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   19: astore_1
    //   20: iconst_0
    //   21: istore_2
    //   22: iconst_0
    //   23: istore_3
    //   24: aload_1
    //   25: invokevirtual length : ()I
    //   28: istore #4
    //   30: iload_3
    //   31: iload #4
    //   33: if_icmpge -> 90
    //   36: aload_1
    //   37: iload_3
    //   38: invokevirtual charAt : (I)C
    //   41: istore #5
    //   43: iconst_0
    //   44: istore #6
    //   46: iload #5
    //   48: bipush #36
    //   50: if_icmpeq -> 57
    //   53: iconst_1
    //   54: goto -> 58
    //   57: iconst_0
    //   58: ifne -> 84
    //   61: aload_1
    //   62: astore #5
    //   64: iconst_0
    //   65: istore #6
    //   67: aload #5
    //   69: iload #6
    //   71: iload_3
    //   72: invokevirtual substring : (II)Ljava/lang/String;
    //   75: dup
    //   76: ldc 'this as java.lang.String…ing(startIndex, endIndex)'
    //   78: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   81: goto -> 91
    //   84: iinc #3, 1
    //   87: goto -> 30
    //   90: aload_1
    //   91: iconst_0
    //   92: aload_0
    //   93: invokevirtual getClass : ()Ljava/lang/Class;
    //   96: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   99: invokestatic forName : (Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;
    //   102: dup
    //   103: ldc 'forName(this.javaClass.n…is.javaClass.classLoader)'
    //   105: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   108: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #13	-> 6
    //   #37	-> 22
    //   #38	-> 36
    //   #13	-> 46
    //   #39	-> 61
    //   #39	-> 81
    //   #37	-> 84
    //   #41	-> 90
    //   #13	-> 91
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   46	12	6	$i$a$-takeWhile-ReflectionUtilKt$parentClass$1	I
    //   43	15	5	it	C
    //   24	66	3	index$iv	I
    //   22	69	2	$i$f$takeWhile	I
    //   20	71	1	$this$takeWhile$iv	Ljava/lang/String;
    //   0	109	0	$this$parentClass	Ljava/lang/Object;
  }
  
  @Nullable
  public static final String getImplementingClassName(@NotNull Object $this$implementingClassName) {
    Intrinsics.checkNotNullParameter($this$implementingClassName, "<this>");
    return $this$implementingClassName.getClass().getName();
  }
  
  public static final boolean isClass(@NotNull Object $this$isClass) {
    Intrinsics.checkNotNullParameter($this$isClass, "<this>");
    return $this$isClass instanceof Class;
  }
  
  public static final boolean isKotlinAnonymousLambda(@NotNull Object $this$isKotlinAnonymousLambda) {
    Intrinsics.checkNotNullParameter($this$isKotlinAnonymousLambda, "<this>");
    return ($this$isKotlinAnonymousLambda.getClass().getEnclosingMethod() != null);
  }
  
  public static final boolean isKotlinMethodReference(@NotNull Object $this$isKotlinMethodReference) {
    Intrinsics.checkNotNullParameter($this$isKotlinMethodReference, "<this>");
    Intrinsics.checkNotNullExpressionValue($this$isKotlinMethodReference.getClass().getDeclaredFields(), "this.javaClass.declaredFields");
    Object[] $this$count$iv = (Object[])$this$isKotlinMethodReference.getClass().getDeclaredFields();
    int $i$f$count = 0;
    int count$iv = 0;
    byte b;
    int i;
    for (b = 0, i = $this$count$iv.length; b < i; ) {
      Object element$iv = $this$count$iv[b];
      Field it = (Field)element$iv;
      int $i$a$-count-ReflectionUtilKt$isKotlinMethodReference$1 = 0;
      if ((Intrinsics.areEqual(it.getName(), "function") || Intrinsics.areEqual(it.getName(), "$tmp0")))
        count$iv++; 
    } 
    return (count$iv == 1);
  }
  
  public static final boolean isKotlinField(@NotNull Object $this$isKotlinField) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '<this>'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: invokevirtual getClass : ()Ljava/lang/Class;
    //   10: invokevirtual getFields : ()[Ljava/lang/reflect/Field;
    //   13: dup
    //   14: ldc 'this.javaClass.fields'
    //   16: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   19: checkcast [Ljava/lang/Object;
    //   22: astore_1
    //   23: iconst_0
    //   24: istore_2
    //   25: iconst_0
    //   26: istore_3
    //   27: aload_1
    //   28: arraylength
    //   29: istore #4
    //   31: iload_3
    //   32: iload #4
    //   34: if_icmpge -> 75
    //   37: aload_1
    //   38: iload_3
    //   39: aaload
    //   40: astore #5
    //   42: aload #5
    //   44: checkcast java/lang/reflect/Field
    //   47: astore #6
    //   49: iconst_0
    //   50: istore #7
    //   52: aload #6
    //   54: invokevirtual getName : ()Ljava/lang/String;
    //   57: ldc 'INSTANCE'
    //   59: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   62: ifeq -> 69
    //   65: iconst_1
    //   66: goto -> 76
    //   69: iinc #3, 1
    //   72: goto -> 31
    //   75: iconst_0
    //   76: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #23	-> 6
    //   #45	-> 25
    //   #23	-> 52
    //   #46	-> 75
    //   #23	-> 76
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   52	10	7	$i$a$-any-ReflectionUtilKt$isKotlinField$1	I
    //   49	13	6	it	Ljava/lang/reflect/Field;
    //   42	33	5	element$iv	Ljava/lang/Object;
    //   25	51	2	$i$f$any	I
    //   23	53	1	$this$any$iv	[Ljava/lang/Object;
    //   0	77	0	$this$isKotlinField	Ljava/lang/Object;
  }
  
  public static final boolean isJavaAnonymousLambda(@NotNull Object $this$isJavaAnonymousLambda) {
    Intrinsics.checkNotNullParameter($this$isJavaAnonymousLambda, "<this>");
    return $this$isJavaAnonymousLambda.getClass().isSynthetic();
  }
  
  public static final boolean isJavaField(@NotNull Object $this$isJavaField) {
    Intrinsics.checkNotNullParameter($this$isJavaField, "<this>");
    return (getJavaFieldName($this$isJavaField) != null);
  }
  
  @NotNull
  public static final Object runMethod(@NotNull Object $this$runMethod, @NotNull String name) {
    Intrinsics.checkNotNullParameter($this$runMethod, "<this>");
    Intrinsics.checkNotNullParameter(name, "name");
    Method method1 = $this$runMethod.getClass().getMethod(name, new Class[0]), $this$runMethod_u24lambda_u2d5 = method1;
    int $i$a$-apply-ReflectionUtilKt$runMethod$1 = 0;
    $this$runMethod_u24lambda_u2d5.setAccessible(true);
    Intrinsics.checkNotNullExpressionValue(method1.invoke($this$runMethod, new Object[0]), "this.javaClass.getMethod…ble = true }.invoke(this)");
    return method1.invoke($this$runMethod, new Object[0]);
  }
}
