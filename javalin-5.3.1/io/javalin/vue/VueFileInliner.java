package io.javalin.vue;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000,\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\004\n\002\020\016\n\000\n\002\020\013\n\000\n\002\020 \n\002\030\002\n\002\b\003\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J \020\b\032\0020\t*\0020\t2\006\020\n\032\0020\0132\f\020\f\032\b\022\004\022\0020\0160\rR\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\005\032\0020\004X\004¢\006\002\n\000R\016\020\006\032\0020\004X\004¢\006\002\n\000R\016\020\007\032\0020\004X\004¢\006\002\n\000¨\006\017²\006\022\020\020\032\n \021*\004\030\0010\t0\tX\002"}, d2 = {"Lio/javalin/vue/VueFileInliner;", "", "()V", "devRegex", "Lkotlin/text/Regex;", "newlineRegex", "notDevRegex", "unconditionalRegex", "inlineFiles", "", "isDev", "", "nonVueFiles", "", "Ljava/nio/file/Path;", "javalin", "matchingFileContent", "kotlin.jvm.PlatformType"})
public final class VueFileInliner {
  @NotNull
  public static final VueFileInliner INSTANCE = new VueFileInliner();
  
  @NotNull
  private static final Regex newlineRegex = new Regex("\\r?\\n");
  
  @NotNull
  private static final Regex unconditionalRegex = new Regex("@inlineFile\\(\".*\"\\)");
  
  @NotNull
  private static final Regex devRegex = new Regex("@inlineFileDev\\(\".*\"\\)");
  
  @NotNull
  private static final Regex notDevRegex = new Regex("@inlineFileNotDev\\(\".*\"\\)");
  
  @NotNull
  public final String inlineFiles(@NotNull String $this$inlineFiles, boolean isDev, @NotNull List nonVueFiles) {
    Intrinsics.checkNotNullParameter($this$inlineFiles, "<this>");
    Intrinsics.checkNotNullParameter(nonVueFiles, "nonVueFiles");
    Iterable $this$associateBy$iv = nonVueFiles;
    int $i$f$associateBy = 0;
    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
    Iterable iterable1 = $this$associateBy$iv;
    Map<Object, Object> destination$iv$iv = new LinkedHashMap<>(capacity$iv);
    int $i$f$associateByTo = 0;
    for (Object element$iv$iv : iterable1) {
      Path path = (Path)element$iv$iv;
      Map<Object, Object> map = destination$iv$iv;
      int $i$a$-associateBy-VueFileInliner$inlineFiles$pathMap$1 = 0;
      map.put("\"/vue/" + StringsKt.substringAfter$default(StringsKt.replace$default(path.toString(), "\\", "/", false, 4, null), "/vue/", null, 2, null) + "\"", element$iv$iv);
    } 
    Map<Object, Object> pathMap = destination$iv$iv;
    CharSequence charSequence = $this$inlineFiles;
    Regex regex = newlineRegex;
    capacity$iv = 0;
    return CollectionsKt.joinToString$default(regex.split(charSequence, capacity$iv), "\n", null, null, 0, null, new VueFileInliner$inlineFiles$1((Map)pathMap, isDev), 30, null);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\r\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "line", "", "invoke"})
  static final class VueFileInliner$inlineFiles$1 extends Lambda implements Function1<String, CharSequence> {
    @NotNull
    public final CharSequence invoke(@NotNull String line) {
      // Byte code:
      //   0: aload_1
      //   1: ldc 'line'
      //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
      //   6: aload_1
      //   7: checkcast java/lang/CharSequence
      //   10: ldc '@inlineFile'
      //   12: checkcast java/lang/CharSequence
      //   15: iconst_0
      //   16: iconst_2
      //   17: aconst_null
      //   18: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
      //   21: ifne -> 29
      //   24: aload_1
      //   25: checkcast java/lang/CharSequence
      //   28: areturn
      //   29: aload_0
      //   30: getfield $pathMap : Ljava/util/Map;
      //   33: invokeinterface keySet : ()Ljava/util/Set;
      //   38: checkcast java/lang/Iterable
      //   41: astore #5
      //   43: aload #5
      //   45: invokeinterface iterator : ()Ljava/util/Iterator;
      //   50: astore #6
      //   52: aload #6
      //   54: invokeinterface hasNext : ()Z
      //   59: ifeq -> 104
      //   62: aload #6
      //   64: invokeinterface next : ()Ljava/lang/Object;
      //   69: astore #7
      //   71: aload #7
      //   73: checkcast java/lang/String
      //   76: astore #8
      //   78: iconst_0
      //   79: istore #9
      //   81: aload_1
      //   82: checkcast java/lang/CharSequence
      //   85: aload #8
      //   87: checkcast java/lang/CharSequence
      //   90: iconst_0
      //   91: iconst_2
      //   92: aconst_null
      //   93: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
      //   96: ifeq -> 52
      //   99: aload #7
      //   101: goto -> 105
      //   104: aconst_null
      //   105: checkcast java/lang/String
      //   108: dup
      //   109: ifnonnull -> 127
      //   112: pop
      //   113: new java/lang/IllegalStateException
      //   116: dup
      //   117: aload_1
      //   118: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
      //   123: invokespecial <init> : (Ljava/lang/String;)V
      //   126: athrow
      //   127: astore_2
      //   128: new io/javalin/vue/VueFileInliner$inlineFiles$1$matchingFileContent$2
      //   131: dup
      //   132: aload_0
      //   133: getfield $pathMap : Ljava/util/Map;
      //   136: aload_2
      //   137: invokespecial <init> : (Ljava/util/Map;Ljava/lang/String;)V
      //   140: checkcast kotlin/jvm/functions/Function0
      //   143: invokestatic lazy : (Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
      //   146: astore_3
      //   147: nop
      //   148: invokestatic access$getDevRegex$p : ()Lkotlin/text/Regex;
      //   151: aload_1
      //   152: checkcast java/lang/CharSequence
      //   155: invokevirtual containsMatchIn : (Ljava/lang/CharSequence;)Z
      //   158: ifeq -> 211
      //   161: aload_0
      //   162: getfield $isDev : Z
      //   165: ifeq -> 203
      //   168: aload_1
      //   169: checkcast java/lang/CharSequence
      //   172: astore #4
      //   174: invokestatic access$getDevRegex$p : ()Lkotlin/text/Regex;
      //   177: astore #5
      //   179: aload_3
      //   180: invokestatic invoke$lambda-1 : (Lkotlin/Lazy;)Ljava/lang/String;
      //   183: dup
      //   184: ldc 'matchingFileContent'
      //   186: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
      //   189: astore #6
      //   191: aload #5
      //   193: aload #4
      //   195: aload #6
      //   197: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;
      //   200: goto -> 205
      //   203: ldc ''
      //   205: checkcast java/lang/CharSequence
      //   208: goto -> 309
      //   211: invokestatic access$getNotDevRegex$p : ()Lkotlin/text/Regex;
      //   214: aload_1
      //   215: checkcast java/lang/CharSequence
      //   218: invokevirtual containsMatchIn : (Ljava/lang/CharSequence;)Z
      //   221: ifeq -> 274
      //   224: aload_0
      //   225: getfield $isDev : Z
      //   228: ifne -> 266
      //   231: aload_1
      //   232: checkcast java/lang/CharSequence
      //   235: astore #4
      //   237: invokestatic access$getNotDevRegex$p : ()Lkotlin/text/Regex;
      //   240: astore #5
      //   242: aload_3
      //   243: invokestatic invoke$lambda-1 : (Lkotlin/Lazy;)Ljava/lang/String;
      //   246: dup
      //   247: ldc 'matchingFileContent'
      //   249: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
      //   252: astore #6
      //   254: aload #5
      //   256: aload #4
      //   258: aload #6
      //   260: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;
      //   263: goto -> 268
      //   266: ldc ''
      //   268: checkcast java/lang/CharSequence
      //   271: goto -> 309
      //   274: aload_1
      //   275: checkcast java/lang/CharSequence
      //   278: astore #4
      //   280: invokestatic access$getUnconditionalRegex$p : ()Lkotlin/text/Regex;
      //   283: astore #5
      //   285: aload_3
      //   286: invokestatic invoke$lambda-1 : (Lkotlin/Lazy;)Ljava/lang/String;
      //   289: dup
      //   290: ldc 'matchingFileContent'
      //   292: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
      //   295: astore #6
      //   297: aload #5
      //   299: aload #4
      //   301: aload #6
      //   303: invokevirtual replace : (Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;
      //   306: checkcast java/lang/CharSequence
      //   309: areturn
      // Line number table:
      //   Java source line number -> byte code offset
      //   #15	-> 6
      //   #16	-> 29
      //   #27	-> 78
      //   #16	-> 81
      //   #16	-> 96
      //   #16	-> 105
      //   #17	-> 128
      //   #18	-> 147
      //   #19	-> 148
      //   #19	-> 203
      //   #20	-> 211
      //   #20	-> 266
      //   #21	-> 274
      //   #18	-> 309
      // Local variable table:
      //   start	length	slot	name	descriptor
      //   81	15	9	$i$a$-find-VueFileInliner$inlineFiles$1$matchingKey$1	I
      //   78	18	8	it	Ljava/lang/String;
      //   128	182	2	matchingKey	Ljava/lang/String;
      //   147	163	3	matchingFileContent$delegate	Lkotlin/Lazy;
      //   0	310	0	this	Lio/javalin/vue/VueFileInliner$inlineFiles$1;
      //   0	310	1	line	Ljava/lang/String;
    }
    
    private static final String invoke$lambda-1(Lazy $matchingFileContent$delegate) {
      Lazy lazy = $matchingFileContent$delegate;
      return (String)lazy.getValue();
    }
    
    VueFileInliner$inlineFiles$1(Map<String, Path> $pathMap, boolean $isDev) {
      super(1);
    }
    
    @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\n\n\000\n\002\020\016\n\002\b\002\020\000\032\n \002*\004\030\0010\0010\001H\n¢\006\002\b\003"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class VueFileInliner$inlineFiles$1$matchingFileContent$2 extends Lambda implements Function0<String> {
      VueFileInliner$inlineFiles$1$matchingFileContent$2(Map<String, Path> $pathMap, String $matchingKey) {
        super(0);
      }
      
      public final String invoke() {
        Intrinsics.checkNotNull(this.$pathMap.get(this.$matchingKey));
        return Matcher.quoteReplacement(VueHandlerKt.readText(this.$pathMap.get(this.$matchingKey)));
      }
    }
  }
}
