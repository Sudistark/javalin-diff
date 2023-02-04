package io.javalin.routing;

import io.javalin.http.HandlerType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000<\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020$\n\002\030\002\n\002\020!\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\020 \n\002\b\002\n\002\020\016\n\000\n\002\020\013\n\002\b\004\030\0002\0020\001B\005¢\006\002\020\002J\016\020\b\032\0020\t2\006\020\n\032\0020\007J\034\020\013\032\b\022\004\022\0020\0070\f2\006\020\r\032\0020\0052\006\020\016\032\0020\017J\035\020\020\032\0020\0212\006\020\r\032\0020\0052\006\020\016\032\0020\017H\000¢\006\002\b\022J\030\020\023\032\0020\0212\006\020\n\032\0020\0072\006\020\024\032\0020\017H\002R \020\003\032\024\022\004\022\0020\005\022\n\022\b\022\004\022\0020\0070\0060\004X\004¢\006\002\n\000¨\006\025"}, d2 = {"Lio/javalin/routing/PathMatcher;", "", "()V", "handlerEntries", "", "Lio/javalin/http/HandlerType;", "", "Lio/javalin/routing/HandlerEntry;", "add", "", "entry", "findEntries", "", "handlerType", "requestUri", "", "hasEntries", "", "hasEntries$javalin", "match", "requestPath", "javalin"})
public final class PathMatcher {
  @NotNull
  private final Map<HandlerType, List<HandlerEntry>> handlerEntries;
  
  public PathMatcher() {
    HandlerType[] arrayOfHandlerType = HandlerType.values();
    EnumMap<HandlerType, Object> enumMap = new EnumMap<>(HandlerType.class);
    PathMatcher pathMatcher = this;
    int $i$f$associateWithTo = 0;
    byte b;
    int i;
    for (b = 0, i = arrayOfHandlerType.length; b < i; ) {
      Object element$iv = arrayOfHandlerType[b];
      Object object1 = element$iv, object2 = element$iv;
      EnumMap<HandlerType, Object> enumMap1 = enumMap;
      int $i$a$-associateWithTo-PathMatcher$handlerEntries$1 = 0;
      ArrayList arrayList = new ArrayList();
      enumMap1.put(object2, arrayList);
      b++;
    } 
    pathMatcher.handlerEntries = (Map)enumMap;
  }
  
  public final void add(@NotNull HandlerEntry entry) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'entry'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: invokevirtual getType : ()Lio/javalin/http/HandlerType;
    //   10: invokevirtual isHttpMethod : ()Z
    //   13: ifeq -> 136
    //   16: aload_0
    //   17: getfield handlerEntries : Ljava/util/Map;
    //   20: aload_1
    //   21: invokevirtual getType : ()Lio/javalin/http/HandlerType;
    //   24: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   29: dup
    //   30: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   33: checkcast java/lang/Iterable
    //   36: astore_2
    //   37: aload_2
    //   38: invokeinterface iterator : ()Ljava/util/Iterator;
    //   43: astore_3
    //   44: aload_3
    //   45: invokeinterface hasNext : ()Z
    //   50: ifeq -> 111
    //   53: aload_3
    //   54: invokeinterface next : ()Ljava/lang/Object;
    //   59: astore #4
    //   61: aload #4
    //   63: checkcast io/javalin/routing/HandlerEntry
    //   66: astore #5
    //   68: iconst_0
    //   69: istore #6
    //   71: aload #5
    //   73: invokevirtual getType : ()Lio/javalin/http/HandlerType;
    //   76: aload_1
    //   77: invokevirtual getType : ()Lio/javalin/http/HandlerType;
    //   80: if_acmpne -> 102
    //   83: aload #5
    //   85: invokevirtual getPath : ()Ljava/lang/String;
    //   88: aload_1
    //   89: invokevirtual getPath : ()Ljava/lang/String;
    //   92: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   95: ifeq -> 102
    //   98: iconst_1
    //   99: goto -> 103
    //   102: iconst_0
    //   103: ifeq -> 44
    //   106: aload #4
    //   108: goto -> 112
    //   111: aconst_null
    //   112: ifnull -> 136
    //   115: new java/lang/IllegalArgumentException
    //   118: dup
    //   119: aload_1
    //   120: invokevirtual getType : ()Lio/javalin/http/HandlerType;
    //   123: aload_1
    //   124: invokevirtual getPath : ()Ljava/lang/String;
    //   127: <illegal opcode> makeConcatWithConstants : (Lio/javalin/http/HandlerType;Ljava/lang/String;)Ljava/lang/String;
    //   132: invokespecial <init> : (Ljava/lang/String;)V
    //   135: athrow
    //   136: aload_0
    //   137: getfield handlerEntries : Ljava/util/Map;
    //   140: aload_1
    //   141: invokevirtual getType : ()Lio/javalin/http/HandlerType;
    //   144: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   149: dup
    //   150: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   153: checkcast java/util/List
    //   156: aload_1
    //   157: invokeinterface add : (Ljava/lang/Object;)Z
    //   162: pop
    //   163: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #18	-> 6
    //   #42	-> 68
    //   #18	-> 71
    //   #18	-> 103
    //   #18	-> 112
    //   #19	-> 115
    //   #21	-> 136
    //   #22	-> 163
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   71	32	6	$i$a$-find-PathMatcher$add$1	I
    //   68	35	5	it	Lio/javalin/routing/HandlerEntry;
    //   0	164	0	this	Lio/javalin/routing/PathMatcher;
    //   0	164	1	entry	Lio/javalin/routing/HandlerEntry;
  }
  
  @NotNull
  public final List<HandlerEntry> findEntries(@NotNull HandlerType handlerType, @NotNull String requestUri) {
    Intrinsics.checkNotNullParameter(handlerType, "handlerType");
    Intrinsics.checkNotNullParameter(requestUri, "requestUri");
    Intrinsics.checkNotNull(this.handlerEntries.get(handlerType));
    Iterable<HandlerEntry> $this$filter$iv = this.handlerEntries.get(handlerType);
    int $i$f$filter = 0;
    Iterable<HandlerEntry> iterable1 = $this$filter$iv;
    Collection<Object> destination$iv$iv = new ArrayList();
    int $i$f$filterTo = 0;
    for (HandlerEntry element$iv$iv : iterable1) {
      HandlerEntry he = element$iv$iv;
      int $i$a$-filter-PathMatcher$findEntries$1 = 0;
      if (match(he, requestUri))
        destination$iv$iv.add(element$iv$iv); 
    } 
    return (List)destination$iv$iv;
  }
  
  public final boolean hasEntries$javalin(@NotNull HandlerType handlerType, @NotNull String requestUri) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'handlerType'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 'requestUri'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_0
    //   13: getfield handlerEntries : Ljava/util/Map;
    //   16: aload_1
    //   17: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: dup
    //   23: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   26: checkcast java/lang/Iterable
    //   29: astore_3
    //   30: iconst_0
    //   31: istore #4
    //   33: aload_3
    //   34: instanceof java/util/Collection
    //   37: ifeq -> 56
    //   40: aload_3
    //   41: checkcast java/util/Collection
    //   44: invokeinterface isEmpty : ()Z
    //   49: ifeq -> 56
    //   52: iconst_0
    //   53: goto -> 108
    //   56: aload_3
    //   57: invokeinterface iterator : ()Ljava/util/Iterator;
    //   62: astore #5
    //   64: aload #5
    //   66: invokeinterface hasNext : ()Z
    //   71: ifeq -> 107
    //   74: aload #5
    //   76: invokeinterface next : ()Ljava/lang/Object;
    //   81: astore #6
    //   83: aload #6
    //   85: checkcast io/javalin/routing/HandlerEntry
    //   88: astore #7
    //   90: iconst_0
    //   91: istore #8
    //   93: aload_0
    //   94: aload #7
    //   96: aload_2
    //   97: invokespecial match : (Lio/javalin/routing/HandlerEntry;Ljava/lang/String;)Z
    //   100: ifeq -> 64
    //   103: iconst_1
    //   104: goto -> 108
    //   107: iconst_0
    //   108: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #28	-> 12
    //   #46	-> 33
    //   #47	-> 56
    //   #28	-> 93
    //   #48	-> 107
    //   #28	-> 108
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   93	7	8	$i$a$-any-PathMatcher$hasEntries$1	I
    //   90	10	7	entry	Lio/javalin/routing/HandlerEntry;
    //   83	24	6	element$iv	Ljava/lang/Object;
    //   33	75	4	$i$f$any	I
    //   30	78	3	$this$any$iv	Ljava/lang/Iterable;
    //   0	109	0	this	Lio/javalin/routing/PathMatcher;
    //   0	109	1	handlerType	Lio/javalin/http/HandlerType;
    //   0	109	2	requestUri	Ljava/lang/String;
  }
  
  private final boolean match(HandlerEntry entry, String requestPath) {
    String str = entry.getPath();
    return Intrinsics.areEqual(str, "*") ? true : (Intrinsics.areEqual(str, requestPath) ? true : entry.matches(requestPath));
  }
}
