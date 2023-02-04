package io.javalin.websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0004\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\030\002\n\002\020!\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\020 \n\000\n\002\020\016\n\002\b\005\030\0002\0020\001B\005¢\006\002\020\002J\016\020\b\032\0020\t2\006\020\n\032\0020\007J\024\020\013\032\b\022\004\022\0020\0070\f2\006\020\r\032\0020\016J\024\020\017\032\b\022\004\022\0020\0070\f2\006\020\r\032\0020\016J\020\020\020\032\004\030\0010\0072\006\020\r\032\0020\016J\036\020\021\032\b\022\004\022\0020\0070\f2\006\020\022\032\0020\0052\006\020\r\032\0020\016H\002R \020\003\032\024\022\004\022\0020\005\022\n\022\b\022\004\022\0020\0070\0060\004X\004¢\006\002\n\000¨\006\023"}, d2 = {"Lio/javalin/websocket/WsPathMatcher;", "", "()V", "wsHandlerEntries", "Ljava/util/EnumMap;", "Lio/javalin/websocket/WsHandlerType;", "", "Lio/javalin/websocket/WsEntry;", "add", "", "entry", "findAfterHandlerEntries", "", "path", "", "findBeforeHandlerEntries", "findEndpointHandlerEntry", "findEntries", "handlerType", "javalin"})
public final class WsPathMatcher {
  @NotNull
  private final EnumMap<WsHandlerType, List<WsEntry>> wsHandlerEntries;
  
  public WsPathMatcher() {
    WsHandlerType[] arrayOfWsHandlerType = WsHandlerType.values();
    EnumMap<WsHandlerType, Object> enumMap = new EnumMap<>(WsHandlerType.class);
    WsPathMatcher wsPathMatcher = this;
    int $i$f$associateTo = 0;
    byte b;
    int i;
    for (b = 0, i = arrayOfWsHandlerType.length; b < i; ) {
      Object element$iv = arrayOfWsHandlerType[b];
      EnumMap<WsHandlerType, Object> enumMap1 = enumMap;
      Object object1 = element$iv;
      int $i$a$-associateTo-WsPathMatcher$wsHandlerEntries$1 = 0;
      object1 = TuplesKt.to(object1, new ArrayList());
      enumMap1.put(object1.getFirst(), object1.getSecond());
      b++;
    } 
    wsPathMatcher.wsHandlerEntries = (EnumMap)enumMap;
  }
  
  public final void add(@NotNull WsEntry entry) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'entry'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield wsHandlerEntries : Ljava/util/EnumMap;
    //   10: aload_1
    //   11: invokevirtual getType : ()Lio/javalin/websocket/WsHandlerType;
    //   14: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   17: dup
    //   18: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   21: checkcast java/lang/Iterable
    //   24: astore_2
    //   25: aload_2
    //   26: invokeinterface iterator : ()Ljava/util/Iterator;
    //   31: astore_3
    //   32: aload_3
    //   33: invokeinterface hasNext : ()Z
    //   38: ifeq -> 99
    //   41: aload_3
    //   42: invokeinterface next : ()Ljava/lang/Object;
    //   47: astore #4
    //   49: aload #4
    //   51: checkcast io/javalin/websocket/WsEntry
    //   54: astore #5
    //   56: iconst_0
    //   57: istore #6
    //   59: aload #5
    //   61: invokevirtual getType : ()Lio/javalin/websocket/WsHandlerType;
    //   64: aload_1
    //   65: invokevirtual getType : ()Lio/javalin/websocket/WsHandlerType;
    //   68: if_acmpne -> 90
    //   71: aload #5
    //   73: invokevirtual getPath : ()Ljava/lang/String;
    //   76: aload_1
    //   77: invokevirtual getPath : ()Ljava/lang/String;
    //   80: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   83: ifeq -> 90
    //   86: iconst_1
    //   87: goto -> 91
    //   90: iconst_0
    //   91: ifeq -> 32
    //   94: aload #4
    //   96: goto -> 100
    //   99: aconst_null
    //   100: ifnull -> 124
    //   103: new java/lang/IllegalArgumentException
    //   106: dup
    //   107: aload_1
    //   108: invokevirtual getType : ()Lio/javalin/websocket/WsHandlerType;
    //   111: aload_1
    //   112: invokevirtual getPath : ()Ljava/lang/String;
    //   115: <illegal opcode> makeConcatWithConstants : (Lio/javalin/websocket/WsHandlerType;Ljava/lang/String;)Ljava/lang/String;
    //   120: invokespecial <init> : (Ljava/lang/String;)V
    //   123: athrow
    //   124: aload_0
    //   125: getfield wsHandlerEntries : Ljava/util/EnumMap;
    //   128: aload_1
    //   129: invokevirtual getType : ()Lio/javalin/websocket/WsHandlerType;
    //   132: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   135: dup
    //   136: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   139: checkcast java/util/List
    //   142: aload_1
    //   143: invokeinterface add : (Ljava/lang/Object;)Z
    //   148: pop
    //   149: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #37	-> 6
    //   #61	-> 56
    //   #37	-> 59
    //   #37	-> 91
    //   #37	-> 100
    //   #38	-> 103
    //   #40	-> 124
    //   #41	-> 149
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   59	32	6	$i$a$-find-WsPathMatcher$add$1	I
    //   56	35	5	it	Lio/javalin/websocket/WsEntry;
    //   0	150	0	this	Lio/javalin/websocket/WsPathMatcher;
    //   0	150	1	entry	Lio/javalin/websocket/WsEntry;
  }
  
  @NotNull
  public final List<WsEntry> findBeforeHandlerEntries(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    return findEntries(WsHandlerType.WS_BEFORE, path);
  }
  
  @Nullable
  public final WsEntry findEndpointHandlerEntry(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    return (WsEntry)CollectionsKt.firstOrNull(findEntries(WsHandlerType.WEBSOCKET, path));
  }
  
  @NotNull
  public final List<WsEntry> findAfterHandlerEntries(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    return findEntries(WsHandlerType.WS_AFTER, path);
  }
  
  private final List<WsEntry> findEntries(WsHandlerType handlerType, String path) {
    Intrinsics.checkNotNull(this.wsHandlerEntries.get(handlerType));
    Iterable<WsEntry> $this$filter$iv = this.wsHandlerEntries.get(handlerType);
    int $i$f$filter = 0;
    Iterable<WsEntry> iterable1 = $this$filter$iv;
    Collection<Object> destination$iv$iv = new ArrayList();
    int $i$f$filterTo = 0;
    for (WsEntry element$iv$iv : iterable1) {
      WsEntry entry = element$iv$iv;
      int $i$a$-filter-WsPathMatcher$findEntries$1 = 0;
      if ((Intrinsics.areEqual(entry.getPath(), "*") || entry.matches(path)))
        destination$iv$iv.add(element$iv$iv); 
    } 
    return (List)destination$iv$iv;
  }
}
