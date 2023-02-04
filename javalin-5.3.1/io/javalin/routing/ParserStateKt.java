package io.javalin.routing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000,\n\000\n\002\020 \n\002\020\016\n\000\n\002\020\"\n\002\020\f\n\000\n\002\030\002\n\002\b\004\n\002\020\013\n\002\b\005\n\002\020\b\n\000\032\030\020\006\032\0020\0072\006\020\b\032\0020\0022\006\020\t\032\0020\002H\000\032\030\020\n\032\0020\0072\006\020\b\032\0020\0022\006\020\t\032\0020\002H\002\032\034\020\013\032\0020\f*\0020\0022\006\020\r\032\0020\0052\006\020\016\032\0020\005H\002\032\034\020\017\032\0020\002*\0020\0022\006\020\r\032\0020\0052\006\020\016\032\0020\005H\002\"\024\020\000\032\b\022\004\022\0020\0020\001X\004¢\006\002\n\000\"\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000¨\006\020²\006\n\020\021\032\0020\022X\002²\006\n\020\023\032\0020\022X\002"}, d2 = {"adjacentViolations", "", "", "allDelimiters", "", "", "convertSegment", "Lio/javalin/routing/PathSegment;", "segment", "rawPath", "parseAsPathSegment", "isEnclosedBy", "", "prefix", "suffix", "stripEnclosing", "javalin", "bracketsCount", "", "wildcardCount"})
public final class ParserStateKt {
  @NotNull
  private static final Set<Character> allDelimiters;
  
  @NotNull
  private static final List<String> adjacentViolations;
  
  static {
    Character[] arrayOfCharacter = new Character[4];
    arrayOfCharacter[0] = Character.valueOf('{');
    arrayOfCharacter[1] = Character.valueOf('}');
    arrayOfCharacter[2] = Character.valueOf('<');
    arrayOfCharacter[3] = Character.valueOf('>');
    allDelimiters = SetsKt.setOf((Object[])arrayOfCharacter);
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "*{";
    arrayOfString[1] = "*<";
    arrayOfString[2] = "}*";
    arrayOfString[3] = ">*";
    adjacentViolations = CollectionsKt.listOf((Object[])arrayOfString);
  }
  
  @NotNull
  public static final PathSegment convertSegment(@NotNull String segment, @NotNull String rawPath) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'segment'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'rawPath'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new io/javalin/routing/ParserStateKt$convertSegment$bracketsCount$2
    //   15: dup
    //   16: aload_0
    //   17: invokespecial <init> : (Ljava/lang/String;)V
    //   20: checkcast kotlin/jvm/functions/Function0
    //   23: invokestatic lazy : (Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    //   26: astore_2
    //   27: new io/javalin/routing/ParserStateKt$convertSegment$wildcardCount$2
    //   30: dup
    //   31: aload_0
    //   32: invokespecial <init> : (Ljava/lang/String;)V
    //   35: checkcast kotlin/jvm/functions/Function0
    //   38: invokestatic lazy : (Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    //   41: astore_3
    //   42: nop
    //   43: aload_2
    //   44: invokestatic convertSegment$lambda-0 : (Lkotlin/Lazy;)I
    //   47: iconst_2
    //   48: irem
    //   49: ifeq -> 62
    //   52: new io/javalin/routing/MissingBracketsException
    //   55: dup
    //   56: aload_0
    //   57: aload_1
    //   58: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   61: athrow
    //   62: getstatic io/javalin/routing/ParserStateKt.adjacentViolations : Ljava/util/List;
    //   65: checkcast java/lang/Iterable
    //   68: astore #4
    //   70: iconst_0
    //   71: istore #5
    //   73: aload #4
    //   75: instanceof java/util/Collection
    //   78: ifeq -> 98
    //   81: aload #4
    //   83: checkcast java/util/Collection
    //   86: invokeinterface isEmpty : ()Z
    //   91: ifeq -> 98
    //   94: iconst_0
    //   95: goto -> 159
    //   98: aload #4
    //   100: invokeinterface iterator : ()Ljava/util/Iterator;
    //   105: astore #6
    //   107: aload #6
    //   109: invokeinterface hasNext : ()Z
    //   114: ifeq -> 158
    //   117: aload #6
    //   119: invokeinterface next : ()Ljava/lang/Object;
    //   124: astore #7
    //   126: aload #7
    //   128: checkcast java/lang/String
    //   131: astore #8
    //   133: iconst_0
    //   134: istore #9
    //   136: aload_0
    //   137: checkcast java/lang/CharSequence
    //   140: aload #8
    //   142: checkcast java/lang/CharSequence
    //   145: iconst_0
    //   146: iconst_2
    //   147: aconst_null
    //   148: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
    //   151: ifeq -> 107
    //   154: iconst_1
    //   155: goto -> 159
    //   158: iconst_0
    //   159: ifeq -> 172
    //   162: new io/javalin/routing/WildcardBracketAdjacentException
    //   165: dup
    //   166: aload_0
    //   167: aload_1
    //   168: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   171: athrow
    //   172: aload_0
    //   173: ldc '*'
    //   175: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   178: ifeq -> 190
    //   181: getstatic io/javalin/routing/PathSegment$Wildcard.INSTANCE : Lio/javalin/routing/PathSegment$Wildcard;
    //   184: checkcast io/javalin/routing/PathSegment
    //   187: goto -> 294
    //   190: aload_2
    //   191: invokestatic convertSegment$lambda-0 : (Lkotlin/Lazy;)I
    //   194: ifne -> 217
    //   197: aload_3
    //   198: invokestatic convertSegment$lambda-1 : (Lkotlin/Lazy;)I
    //   201: ifne -> 217
    //   204: aload_0
    //   205: iconst_0
    //   206: iconst_2
    //   207: aconst_null
    //   208: invokestatic createNormal$default : (Ljava/lang/String;ZILjava/lang/Object;)Lio/javalin/routing/PathSegment$Normal;
    //   211: checkcast io/javalin/routing/PathSegment
    //   214: goto -> 294
    //   217: aload_2
    //   218: invokestatic convertSegment$lambda-0 : (Lkotlin/Lazy;)I
    //   221: iconst_2
    //   222: if_icmpne -> 253
    //   225: aload_0
    //   226: bipush #123
    //   228: bipush #125
    //   230: invokestatic isEnclosedBy : (Ljava/lang/String;CC)Z
    //   233: ifeq -> 253
    //   236: aload_0
    //   237: bipush #123
    //   239: bipush #125
    //   241: invokestatic stripEnclosing : (Ljava/lang/String;CC)Ljava/lang/String;
    //   244: invokestatic createSlashIgnoringParam : (Ljava/lang/String;)Lio/javalin/routing/PathSegment$Parameter$SlashIgnoringParameter;
    //   247: checkcast io/javalin/routing/PathSegment
    //   250: goto -> 294
    //   253: aload_2
    //   254: invokestatic convertSegment$lambda-0 : (Lkotlin/Lazy;)I
    //   257: iconst_2
    //   258: if_icmpne -> 289
    //   261: aload_0
    //   262: bipush #60
    //   264: bipush #62
    //   266: invokestatic isEnclosedBy : (Ljava/lang/String;CC)Z
    //   269: ifeq -> 289
    //   272: aload_0
    //   273: bipush #60
    //   275: bipush #62
    //   277: invokestatic stripEnclosing : (Ljava/lang/String;CC)Ljava/lang/String;
    //   280: invokestatic createSlashAcceptingParam : (Ljava/lang/String;)Lio/javalin/routing/PathSegment$Parameter$SlashAcceptingParameter;
    //   283: checkcast io/javalin/routing/PathSegment
    //   286: goto -> 294
    //   289: aload_0
    //   290: aload_1
    //   291: invokestatic parseAsPathSegment : (Ljava/lang/String;Ljava/lang/String;)Lio/javalin/routing/PathSegment;
    //   294: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #13	-> 12
    //   #14	-> 27
    //   #15	-> 42
    //   #16	-> 43
    //   #17	-> 62
    //   #100	-> 73
    //   #101	-> 98
    //   #17	-> 136
    //   #102	-> 158
    //   #17	-> 159
    //   #18	-> 172
    //   #19	-> 190
    //   #20	-> 217
    //   #21	-> 253
    //   #22	-> 289
    //   #15	-> 294
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   136	15	9	$i$a$-any-ParserStateKt$convertSegment$1	I
    //   133	18	8	it	Ljava/lang/String;
    //   126	32	7	element$iv	Ljava/lang/Object;
    //   73	86	5	$i$f$any	I
    //   70	89	4	$this$any$iv	Ljava/lang/Iterable;
    //   27	268	2	bracketsCount$delegate	Lkotlin/Lazy;
    //   42	253	3	wildcardCount$delegate	Lkotlin/Lazy;
    //   0	295	0	segment	Ljava/lang/String;
    //   0	295	1	rawPath	Ljava/lang/String;
  }
  
  private static final int convertSegment$lambda-0(Lazy $bracketsCount$delegate) {
    Lazy lazy = $bracketsCount$delegate;
    return ((Number)lazy.getValue()).intValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\n\n\000\n\002\020\b\n\002\b\002\020\000\032\0020\001H\n¢\006\004\b\002\020\003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"})
  static final class ParserStateKt$convertSegment$bracketsCount$2 extends Lambda implements Function0<Integer> {
    ParserStateKt$convertSegment$bracketsCount$2(String $segment) {
      super(0);
    }
    
    @NotNull
    public final Integer invoke() {
      CharSequence $this$count$iv = this.$segment;
      int $i$f$count = 0;
      int count$iv = 0;
      for (byte b = 0; b < $this$count$iv.length(); ) {
        char element$iv = $this$count$iv.charAt(b), it = element$iv;
        int $i$a$-count-ParserStateKt$convertSegment$bracketsCount$2$1 = 0;
        if (ParserStateKt.allDelimiters.contains(Character.valueOf(it)))
          count$iv++; 
      } 
      return Integer.valueOf(count$iv);
    }
  }
  
  private static final int convertSegment$lambda-1(Lazy $wildcardCount$delegate) {
    Lazy lazy = $wildcardCount$delegate;
    return ((Number)lazy.getValue()).intValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\n\n\000\n\002\020\b\n\002\b\002\020\000\032\0020\001H\n¢\006\004\b\002\020\003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"})
  static final class ParserStateKt$convertSegment$wildcardCount$2 extends Lambda implements Function0<Integer> {
    ParserStateKt$convertSegment$wildcardCount$2(String $segment) {
      super(0);
    }
    
    @NotNull
    public final Integer invoke() {
      CharSequence $this$count$iv = this.$segment;
      int $i$f$count = 0;
      int count$iv = 0;
      for (byte b = 0; b < $this$count$iv.length(); ) {
        char element$iv = $this$count$iv.charAt(b), it = element$iv;
        int $i$a$-count-ParserStateKt$convertSegment$wildcardCount$2$1 = 0;
        if ((it == '*'))
          count$iv++; 
      } 
      return Integer.valueOf(count$iv);
    }
  }
  
  private static final PathSegment parseAsPathSegment(String segment, String rawPath) {
    Ref.ObjectRef<ParserState> state = new Ref.ObjectRef();
    state.element = ParserState.NORMAL;
    List<Character> pathNameAccumulator = new ArrayList();
    CharSequence $this$map$iv = segment;
    int $i$f$map = 0;
    CharSequence charSequence1 = $this$map$iv;
    Collection<PathSegment> destination$iv$iv = new ArrayList($this$map$iv.length());
    int $i$f$mapTo = 0;
    for (byte b = 0; b < charSequence1.length(); ) {
      char item$iv$iv = charSequence1.charAt(b);
      char c = item$iv$iv;
      Collection<PathSegment> collection = destination$iv$iv;
      int $i$a$-map-ParserStateKt$parseAsPathSegment$1 = 0;
      collection.add(parseAsPathSegment$mapSingleChar(state, segment, rawPath, pathNameAccumulator, c));
      b++;
    } 
    List list = CollectionsKt.filterNotNull(destination$iv$iv);
    Object initial$iv = new PathSegment.MultipleSegments(CollectionsKt.emptyList());
    int $i$f$fold = 0;
    Object accumulator$iv = initial$iv;
    for (Object element$iv : list) {
      PathSegment pathSegment1 = (PathSegment)element$iv;
      Object object1 = accumulator$iv;
      int $i$a$-fold-ParserStateKt$parseAsPathSegment$2 = 0;
      PathSegment lastAddition = (PathSegment)CollectionsKt.lastOrNull(object1.getInnerSegments());
    } 
    return (PathSegment)accumulator$iv;
  }
  
  private static final PathSegment parseAsPathSegment$mapSingleChar(Ref.ObjectRef state, String $segment, String $rawPath, List<Character> pathNameAccumulator, char char) {
    char c;
    String name;
    Character character;
    switch (WhenMappings.$EnumSwitchMapping$0[((ParserState)state.element).ordinal()]) {
      case 1:
        c = char;
        state.element = ParserState.INSIDE_SLASH_IGNORING_BRACKETS;
        state.element = ParserState.INSIDE_SLASH_ACCEPTING_BRACKETS;
        if ((c == '}') ? true : ((c == '>')))
          throw new MissingBracketsException($segment, $rawPath); 
        return (c == '*') ? PathSegment.Wildcard.INSTANCE : ((c == '{') ? (PathSegment)null : ((c == '<') ? (PathSegment)null : PathSegmentKt.createNormal$default(String.valueOf(char), false, 2, null)));
      case 2:
        c = char;
        state.element = ParserState.NORMAL;
        name = CollectionsKt.joinToString$default(pathNameAccumulator, "", null, null, 0, null, null, 62, null);
        pathNameAccumulator.clear();
        if (((c == '{') ? true : ((c == '<'))) ? true : ((c == '>')))
          throw new MissingBracketsException($segment, $rawPath); 
        character = Character.valueOf(char);
        pathNameAccumulator.add(character);
      case 3:
        c = char;
        state.element = ParserState.NORMAL;
        name = CollectionsKt.joinToString$default(pathNameAccumulator, "", null, null, 0, null, null, 62, null);
        pathNameAccumulator.clear();
        if (((c == '{') ? true : ((c == '}'))) ? true : ((c == '<')))
          throw new MissingBracketsException($segment, $rawPath); 
        character = Character.valueOf(char);
        pathNameAccumulator.add(character);
    } 
    throw new NoWhenBranchMatchedException();
  }
  
  private static final boolean isEnclosedBy(String $this$isEnclosedBy, char prefix, char suffix) {
    return (StringsKt.startsWith$default($this$isEnclosedBy, prefix, false, 2, null) && StringsKt.endsWith$default($this$isEnclosedBy, suffix, false, 2, null));
  }
  
  private static final String stripEnclosing(String $this$stripEnclosing, char prefix, char suffix) {
    return StringsKt.removeSuffix(StringsKt.removePrefix($this$stripEnclosing, String.valueOf(prefix)), String.valueOf(suffix));
  }
}
