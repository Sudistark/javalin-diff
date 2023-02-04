package io.javalin.routing;

import io.javalin.config.RoutingConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000:\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020 \n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\002\n\002\020$\n\002\b\003\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\032\020\025\032\016\022\004\022\0020\003\022\004\022\0020\0030\0262\006\020\027\032\0020\003J\016\020\030\032\0020\b2\006\020\027\032\0020\003R\016\020\007\032\0020\bX\004¢\006\002\n\000R\024\020\t\032\b\022\004\022\0020\0130\nX\004¢\006\002\n\000R\016\020\f\032\0020\003X\004¢\006\002\n\000R\027\020\r\032\b\022\004\022\0020\0030\n¢\006\b\n\000\032\004\b\016\020\017R\024\020\020\032\b\022\004\022\0020\0130\nX\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\021\032\0020\003X\004¢\006\002\n\000R\027\020\022\032\b\022\004\022\0020\0230\n¢\006\b\n\000\032\004\b\024\020\017¨\006\031"}, d2 = {"Lio/javalin/routing/PathParser;", "", "rawPath", "", "routingConfig", "Lio/javalin/config/RoutingConfig;", "(Ljava/lang/String;Lio/javalin/config/RoutingConfig;)V", "matchPathAndEverySubPath", "", "matchRegex", "", "Lkotlin/text/Regex;", "path", "pathParamNames", "getPathParamNames", "()Ljava/util/List;", "pathParamRegex", "regexSuffix", "segments", "Lio/javalin/routing/PathSegment;", "getSegments", "extractPathParams", "", "url", "matches", "javalin"})
public final class PathParser {
  @NotNull
  private final String rawPath;
  
  private final boolean matchPathAndEverySubPath;
  
  @NotNull
  private final String path;
  
  @NotNull
  private final List<PathSegment> segments;
  
  @NotNull
  private final List<String> pathParamNames;
  
  @NotNull
  private final String regexSuffix;
  
  @NotNull
  private final List<Regex> matchRegex;
  
  @NotNull
  private final List<Regex> pathParamRegex;
  
  public PathParser(@NotNull String rawPath, @NotNull RoutingConfig routingConfig) {
    this.rawPath = rawPath;
    if (StringsKt.contains$default(this.rawPath, "/:", false, 2, null))
      throw new IllegalArgumentException("Path '" + this.rawPath + "' invalid - Javalin 4 switched from ':param' to '{param}'."); 
    this.matchPathAndEverySubPath = (StringsKt.endsWith$default(this.rawPath, ">*", false, 2, null) || StringsKt.endsWith$default(this.rawPath, "}*", false, 2, null));
    this.path = this.matchPathAndEverySubPath ? StringsKt.removeSuffix(this.rawPath, "*") : this.rawPath;
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "/";
    List list1 = StringsKt.split$default(this.path, arrayOfString, false, 0, 6, null);
    PathParser pathParser = 
      this;
    int $i$f$filter = 0;
    List list2 = list1;
    Collection<Object> collection1 = new ArrayList();
    int $i$f$filterTo = 0;
    for (Object element$iv$iv : list2) {
      String it = (String)element$iv$iv;
      int $i$a$-filter-PathParser$segments$1 = 0;
      if ((((CharSequence)it).length() > 0))
        collection1.add(element$iv$iv); 
    } 
    Iterable $this$filter$iv = collection1;
    pathParser = pathParser;
    int $i$f$map = 0;
    Iterable $this$filterTo$iv$iv = $this$filter$iv;
    Collection<PathSegment> collection = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$filter$iv, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : $this$filterTo$iv$iv) {
      String str = (String)item$iv$iv;
      Collection<PathSegment> collection2 = collection;
      int $i$a$-map-PathParser$segments$2 = 0;
      collection2.add(ParserStateKt.convertSegment(str, this.rawPath));
    } 
    pathParser.segments = (List<PathSegment>)collection;
    Iterable<PathSegment> iterable1 = this.segments;
    pathParser = this;
    $i$f$map = 0;
    Iterable<PathSegment> $this$mapTo$iv$iv = iterable1;
    Collection<List<String>> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable1, 10));
    $i$f$mapTo = 0;
    for (PathSegment item$iv$iv : $this$mapTo$iv$iv) {
      PathSegment pathSegment1 = item$iv$iv;
      Collection<List<String>> collection2 = destination$iv$iv;
      int $i$a$-map-PathParser$pathParamNames$1 = 0;
      collection2.add(PathSegmentKt.pathParamNames(pathSegment1));
    } 
    Iterable $this$map$iv = CollectionsKt.flatten(destination$iv$iv), iterable2 = $this$map$iv;
    pathParser = pathParser;
    int $i$a$-also-PathParser$pathParamNames$2 = 0;
    Set set = CollectionsKt.toSet(iterable2);
    if (set.size() != iterable2.size())
      throw new ParameterNamesNotUniqueException(this.rawPath); 
    pathParser.pathParamNames = (List<String>)$this$map$iv;
    this.regexSuffix = routingConfig.treatMultipleSlashesAsSingleSlash ? (routingConfig.ignoreTrailingSlashes ? "/*" : (StringsKt.endsWith$default(this.rawPath, "/", false, 2, null) ? "/+" : "")) : (routingConfig.ignoreTrailingSlashes ? "/?" : (StringsKt.endsWith$default(this.rawPath, "/", false, 2, null) ? "/" : ""));
    this.matchRegex = RoutingRegexesKt.constructRegexList$default(routingConfig, this.matchPathAndEverySubPath, this.segments, this.regexSuffix, null, PathParser$matchRegex$1.INSTANCE, 16, null);
    this.pathParamRegex = RoutingRegexesKt.constructRegexList$default(routingConfig, this.matchPathAndEverySubPath, this.segments, this.regexSuffix, null, PathParser$pathParamRegex$1.INSTANCE, 16, null);
  }
  
  @NotNull
  public final List<PathSegment> getSegments() {
    return this.segments;
  }
  
  @NotNull
  public final List<String> getPathParamNames() {
    return this.pathParamNames;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\016\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/routing/PathSegment;", "invoke"})
  static final class PathParser$matchRegex$1 extends Lambda implements Function1<PathSegment, String> {
    public static final PathParser$matchRegex$1 INSTANCE = new PathParser$matchRegex$1();
    
    PathParser$matchRegex$1() {
      super(1);
    }
    
    @NotNull
    public final String invoke(@NotNull PathSegment it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it.asRegexString$javalin();
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\016\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/routing/PathSegment;", "invoke"})
  static final class PathParser$pathParamRegex$1 extends Lambda implements Function1<PathSegment, String> {
    public static final PathParser$pathParamRegex$1 INSTANCE = new PathParser$pathParamRegex$1();
    
    PathParser$pathParamRegex$1() {
      super(1);
    }
    
    @NotNull
    public final String invoke(@NotNull PathSegment it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it.asGroupedRegexString$javalin();
    }
  }
  
  public final boolean matches(@NotNull String url) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'url'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield matchRegex : Ljava/util/List;
    //   10: checkcast java/lang/Iterable
    //   13: astore_2
    //   14: iconst_0
    //   15: istore_3
    //   16: aload_2
    //   17: instanceof java/util/Collection
    //   20: ifeq -> 39
    //   23: aload_2
    //   24: checkcast java/util/Collection
    //   27: invokeinterface isEmpty : ()Z
    //   32: ifeq -> 39
    //   35: iconst_0
    //   36: goto -> 95
    //   39: aload_2
    //   40: invokeinterface iterator : ()Ljava/util/Iterator;
    //   45: astore #4
    //   47: aload #4
    //   49: invokeinterface hasNext : ()Z
    //   54: ifeq -> 94
    //   57: aload #4
    //   59: invokeinterface next : ()Ljava/lang/Object;
    //   64: astore #5
    //   66: aload #5
    //   68: checkcast kotlin/text/Regex
    //   71: astore #6
    //   73: iconst_0
    //   74: istore #7
    //   76: aload_1
    //   77: checkcast java/lang/CharSequence
    //   80: aload #6
    //   82: swap
    //   83: invokevirtual matches : (Ljava/lang/CharSequence;)Z
    //   86: nop
    //   87: ifeq -> 47
    //   90: iconst_1
    //   91: goto -> 95
    //   94: iconst_0
    //   95: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #51	-> 6
    //   #72	-> 16
    //   #73	-> 39
    //   #51	-> 76
    //   #51	-> 86
    //   #74	-> 94
    //   #51	-> 95
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   76	11	7	$i$a$-any-PathParser$matches$1	I
    //   73	14	6	it	Lkotlin/text/Regex;
    //   66	28	5	element$iv	Ljava/lang/Object;
    //   16	79	3	$i$f$any	I
    //   14	81	2	$this$any$iv	Ljava/lang/Iterable;
    //   0	96	0	this	Lio/javalin/routing/PathParser;
    //   0	96	1	url	Ljava/lang/String;
  }
  
  @NotNull
  public final Map<String, String> extractPathParams(@NotNull String url) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'url'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield matchRegex : Ljava/util/List;
    //   10: astore_3
    //   11: iconst_0
    //   12: istore #4
    //   14: iconst_0
    //   15: istore #5
    //   17: aload_3
    //   18: invokeinterface iterator : ()Ljava/util/Iterator;
    //   23: astore #6
    //   25: aload #6
    //   27: invokeinterface hasNext : ()Z
    //   32: ifeq -> 79
    //   35: aload #6
    //   37: invokeinterface next : ()Ljava/lang/Object;
    //   42: astore #7
    //   44: aload #7
    //   46: checkcast kotlin/text/Regex
    //   49: astore #8
    //   51: iconst_0
    //   52: istore #9
    //   54: aload_1
    //   55: checkcast java/lang/CharSequence
    //   58: aload #8
    //   60: swap
    //   61: invokevirtual matches : (Ljava/lang/CharSequence;)Z
    //   64: nop
    //   65: ifeq -> 73
    //   68: iload #5
    //   70: goto -> 80
    //   73: iinc #5, 1
    //   76: goto -> 25
    //   79: iconst_m1
    //   80: istore_2
    //   81: aload_0
    //   82: getfield pathParamNames : Ljava/util/List;
    //   85: checkcast java/lang/Iterable
    //   88: astore_3
    //   89: aload_0
    //   90: getfield pathParamRegex : Ljava/util/List;
    //   93: iload_2
    //   94: invokeinterface get : (I)Ljava/lang/Object;
    //   99: checkcast kotlin/text/Regex
    //   102: aload_1
    //   103: invokestatic values : (Lkotlin/text/Regex;Ljava/lang/String;)Ljava/util/List;
    //   106: checkcast java/lang/Iterable
    //   109: astore #4
    //   111: iconst_0
    //   112: istore #5
    //   114: aload_3
    //   115: invokeinterface iterator : ()Ljava/util/Iterator;
    //   120: astore #6
    //   122: aload #4
    //   124: invokeinterface iterator : ()Ljava/util/Iterator;
    //   129: astore #7
    //   131: new java/util/ArrayList
    //   134: dup
    //   135: aload_3
    //   136: bipush #10
    //   138: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
    //   141: aload #4
    //   143: bipush #10
    //   145: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
    //   148: invokestatic min : (II)I
    //   151: invokespecial <init> : (I)V
    //   154: astore #8
    //   156: aload #6
    //   158: invokeinterface hasNext : ()Z
    //   163: ifeq -> 227
    //   166: aload #7
    //   168: invokeinterface hasNext : ()Z
    //   173: ifeq -> 227
    //   176: aload #8
    //   178: aload #6
    //   180: invokeinterface next : ()Ljava/lang/Object;
    //   185: aload #7
    //   187: invokeinterface next : ()Ljava/lang/Object;
    //   192: checkcast java/lang/String
    //   195: astore #9
    //   197: checkcast java/lang/String
    //   200: astore #10
    //   202: astore #12
    //   204: iconst_0
    //   205: istore #11
    //   207: aload #10
    //   209: aload #9
    //   211: invokestatic urlDecode : (Ljava/lang/String;)Ljava/lang/String;
    //   214: invokestatic to : (Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;
    //   217: aload #12
    //   219: swap
    //   220: invokevirtual add : (Ljava/lang/Object;)Z
    //   223: pop
    //   224: goto -> 156
    //   227: aload #8
    //   229: checkcast java/util/List
    //   232: checkcast java/lang/Iterable
    //   235: invokestatic toMap : (Ljava/lang/Iterable;)Ljava/util/Map;
    //   238: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #54	-> 6
    //   #75	-> 14
    //   #76	-> 17
    //   #77	-> 44
    //   #54	-> 54
    //   #54	-> 64
    //   #78	-> 68
    //   #79	-> 73
    //   #81	-> 79
    //   #54	-> 80
    //   #55	-> 81
    //   #82	-> 114
    //   #83	-> 122
    //   #84	-> 131
    //   #84	-> 151
    //   #85	-> 156
    //   #86	-> 176
    //   #56	-> 207
    //   #88	-> 227
    //   #57	-> 235
    //   #55	-> 238
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   54	11	9	$i$a$-indexOfFirst-PathParser$extractPathParams$index$1	I
    //   51	14	8	it	Lkotlin/text/Regex;
    //   44	32	7	item$iv	Ljava/lang/Object;
    //   14	66	4	$i$f$indexOfFirst	I
    //   17	63	5	index$iv	I
    //   11	69	3	$this$indexOfFirst$iv	Ljava/util/List;
    //   207	10	11	$i$a$-zip-PathParser$extractPathParams$1	I
    //   204	13	10	name	Ljava/lang/String;
    //   204	13	9	value	Ljava/lang/String;
    //   114	118	5	$i$f$zip	I
    //   122	110	6	first$iv	Ljava/util/Iterator;
    //   131	101	7	second$iv	Ljava/util/Iterator;
    //   156	76	8	list$iv	Ljava/util/ArrayList;
    //   111	121	3	$this$zip$iv	Ljava/lang/Iterable;
    //   111	121	4	other$iv	Ljava/lang/Iterable;
    //   81	158	2	index	I
    //   0	239	0	this	Lio/javalin/routing/PathParser;
    //   0	239	1	url	Ljava/lang/String;
  }
}
