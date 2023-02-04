package io.javalin.plugin.bundled;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000:\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\004\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\r\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\035\020\003\032\0020\0042\006\020\005\032\0020\0042\006\020\006\032\0020\004H\000¢\006\002\b\007J\025\020\b\032\0020\t2\006\020\n\032\0020\004H\000¢\006\002\b\013J\025\020\f\032\0020\t2\006\020\n\032\0020\004H\000¢\006\002\b\rJ\025\020\016\032\0020\0172\006\020\020\032\0020\021H\000¢\006\002\b\022J\025\020\023\032\0020\0172\006\020\n\032\0020\004H\000¢\006\002\b\024J\025\020\025\032\0020\0042\006\020\n\032\0020\004H\000¢\006\002\b\026J\025\020\027\032\0020\0302\006\020\n\032\0020\004H\000¢\006\002\b\031J\035\020\032\032\0020\0172\006\020\033\032\0020\0342\006\020\035\032\0020\034H\000¢\006\002\b\036J\025\020\037\032\0020\0342\006\020\n\032\0020\004H\000¢\006\002\b ¨\006!"}, d2 = {"Lio/javalin/plugin/bundled/CorsUtils;", "", "()V", "addSchemeIfMissing", "", "host", "defaultScheme", "addSchemeIfMissing$javalin", "extractPort", "Lio/javalin/plugin/bundled/PortResult;", "origin", "extractPort$javalin", "extractPortOrSchemeDefault", "extractPortOrSchemeDefault$javalin", "isSchemeValid", "", "scheme", "", "isSchemeValid$javalin", "isValidOrigin", "isValidOrigin$javalin", "normalizeOrigin", "normalizeOrigin$javalin", "originFulfillsWildcardRequirements", "Lio/javalin/plugin/bundled/WildcardResult;", "originFulfillsWildcardRequirements$javalin", "originsMatch", "clientOrigin", "Lio/javalin/plugin/bundled/OriginParts;", "serverOrigin", "originsMatch$javalin", "parseAsOriginParts", "parseAsOriginParts$javalin", "javalin"})
public final class CorsUtils {
  @NotNull
  public static final CorsUtils INSTANCE = new CorsUtils();
  
  public final boolean isSchemeValid$javalin(@NotNull CharSequence scheme) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'scheme'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: invokeinterface length : ()I
    //   12: ifle -> 19
    //   15: iconst_1
    //   16: goto -> 20
    //   19: iconst_0
    //   20: ifeq -> 131
    //   23: aload_1
    //   24: invokestatic first : (Ljava/lang/CharSequence;)C
    //   27: invokestatic isLetter : (C)Z
    //   30: ifeq -> 131
    //   33: aload_1
    //   34: astore_2
    //   35: iconst_0
    //   36: istore_3
    //   37: iconst_0
    //   38: istore #4
    //   40: iload #4
    //   42: aload_2
    //   43: invokeinterface length : ()I
    //   48: if_icmpge -> 123
    //   51: aload_2
    //   52: iload #4
    //   54: invokeinterface charAt : (I)C
    //   59: istore #5
    //   61: iload #5
    //   63: istore #6
    //   65: iconst_0
    //   66: istore #7
    //   68: iload #6
    //   70: invokestatic isLetter : (C)Z
    //   73: ifne -> 105
    //   76: iload #6
    //   78: invokestatic access$isAsciiDigit : (C)Z
    //   81: ifne -> 105
    //   84: iload #6
    //   86: bipush #45
    //   88: if_icmpeq -> 105
    //   91: iload #6
    //   93: bipush #43
    //   95: if_icmpeq -> 105
    //   98: iload #6
    //   100: bipush #46
    //   102: if_icmpne -> 109
    //   105: iconst_1
    //   106: goto -> 110
    //   109: iconst_0
    //   110: ifne -> 117
    //   113: iconst_0
    //   114: goto -> 124
    //   117: iinc #4, 1
    //   120: goto -> 40
    //   123: iconst_1
    //   124: ifeq -> 131
    //   127: iconst_1
    //   128: goto -> 132
    //   131: iconst_0
    //   132: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #9	-> 6
    //   #9	-> 23
    //   #9	-> 33
    //   #194	-> 37
    //   #10	-> 68
    //   #10	-> 76
    //   #195	-> 123
    //   #11	-> 132
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   68	42	7	$i$a$-all-CorsUtils$isSchemeValid$1	I
    //   65	45	6	it	C
    //   61	62	5	element$iv	C
    //   37	87	3	$i$f$all	I
    //   35	89	2	$this$all$iv	Ljava/lang/CharSequence;
    //   0	133	0	this	Lio/javalin/plugin/bundled/CorsUtils;
    //   0	133	1	scheme	Ljava/lang/CharSequence;
  }
  
  public final boolean isValidOrigin$javalin(@NotNull String origin) {
    Intrinsics.checkNotNullParameter(origin, "origin");
    int schemeAndHostDelimiter = StringsKt.indexOf$default(origin, "://", 0, false, 6, null);
    PortResult portResult = extractPort$javalin(origin);
    CharSequence $this$count$iv = origin;
    int $i$f$count = 0;
    int count$iv = 0;
    for (byte b = 0; b < $this$count$iv.length(); ) {
      char element$iv = $this$count$iv.charAt(b), it = element$iv;
      int $i$a$-count-CorsUtils$isValidOrigin$1 = 0;
      if ((it == '/'))
        count$iv++; 
    } 
    return ((((CharSequence)origin).length() == 0)) ? false : (Intrinsics.areEqual(origin, "null") ? true : (StringsKt.contains$default(origin, "?", false, 2, null) ? false : ((schemeAndHostDelimiter <= 0) ? false : (!isSchemeValid$javalin(origin.subSequence(0, schemeAndHostDelimiter)) ? false : ((count$iv != 2) ? false : (!(portResult instanceof PortResult.ErrorState)))))));
  }
  
  @NotNull
  public final PortResult extractPort$javalin(@NotNull String origin) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'origin'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: checkcast java/lang/CharSequence
    //   10: ldc '://'
    //   12: checkcast java/lang/CharSequence
    //   15: iconst_0
    //   16: iconst_2
    //   17: aconst_null
    //   18: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
    //   21: ifne -> 31
    //   24: getstatic io/javalin/plugin/bundled/PortResult$ErrorState$InvalidOrigin.INSTANCE : Lio/javalin/plugin/bundled/PortResult$ErrorState$InvalidOrigin;
    //   27: checkcast io/javalin/plugin/bundled/PortResult
    //   30: areturn
    //   31: aload_1
    //   32: checkcast java/lang/CharSequence
    //   35: bipush #58
    //   37: iconst_0
    //   38: iconst_0
    //   39: bipush #6
    //   41: aconst_null
    //   42: invokestatic lastIndexOf$default : (Ljava/lang/CharSequence;CIZILjava/lang/Object;)I
    //   45: istore_2
    //   46: aload_1
    //   47: checkcast java/lang/CharSequence
    //   50: bipush #58
    //   52: iconst_0
    //   53: iconst_0
    //   54: bipush #6
    //   56: aconst_null
    //   57: invokestatic indexOf$default : (Ljava/lang/CharSequence;CIZILjava/lang/Object;)I
    //   60: istore_3
    //   61: iload_2
    //   62: iload_3
    //   63: if_icmpeq -> 70
    //   66: iconst_1
    //   67: goto -> 71
    //   70: iconst_0
    //   71: istore #4
    //   73: iload #4
    //   75: ifne -> 85
    //   78: getstatic io/javalin/plugin/bundled/PortResult$NoPortSpecified.INSTANCE : Lio/javalin/plugin/bundled/PortResult$NoPortSpecified;
    //   81: checkcast io/javalin/plugin/bundled/PortResult
    //   84: areturn
    //   85: aload_1
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: aload_1
    //   90: invokevirtual length : ()I
    //   93: invokevirtual subSequence : (II)Ljava/lang/CharSequence;
    //   96: invokevirtual toString : ()Ljava/lang/String;
    //   99: astore #5
    //   101: aload #5
    //   103: checkcast java/lang/CharSequence
    //   106: astore #6
    //   108: iconst_0
    //   109: istore #7
    //   111: iconst_0
    //   112: istore #8
    //   114: iload #8
    //   116: aload #6
    //   118: invokeinterface length : ()I
    //   123: if_icmpge -> 170
    //   126: aload #6
    //   128: iload #8
    //   130: invokeinterface charAt : (I)C
    //   135: istore #9
    //   137: iload #9
    //   139: istore #10
    //   141: iconst_0
    //   142: istore #11
    //   144: iload #10
    //   146: invokestatic access$isAsciiDigit : (C)Z
    //   149: ifne -> 156
    //   152: iconst_1
    //   153: goto -> 157
    //   156: iconst_0
    //   157: ifeq -> 164
    //   160: iconst_1
    //   161: goto -> 171
    //   164: iinc #8, 1
    //   167: goto -> 114
    //   170: iconst_0
    //   171: ifeq -> 181
    //   174: getstatic io/javalin/plugin/bundled/PortResult$ErrorState$InvalidPort.INSTANCE : Lio/javalin/plugin/bundled/PortResult$ErrorState$InvalidPort;
    //   177: checkcast io/javalin/plugin/bundled/PortResult
    //   180: areturn
    //   181: new io/javalin/plugin/bundled/PortResult$PortSpecified
    //   184: dup
    //   185: aload #5
    //   187: bipush #10
    //   189: invokestatic checkRadix : (I)I
    //   192: invokestatic parseInt : (Ljava/lang/String;I)I
    //   195: iconst_0
    //   196: iconst_2
    //   197: aconst_null
    //   198: invokespecial <init> : (IZILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   201: checkcast io/javalin/plugin/bundled/PortResult
    //   204: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #49	-> 6
    //   #50	-> 31
    //   #51	-> 46
    //   #52	-> 61
    //   #53	-> 73
    //   #54	-> 78
    //   #56	-> 85
    //   #57	-> 101
    //   #199	-> 111
    //   #57	-> 144
    //   #200	-> 170
    //   #57	-> 171
    //   #58	-> 174
    //   #60	-> 181
    //   #60	-> 195
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   144	13	11	$i$a$-any-CorsUtils$extractPort$1	I
    //   141	16	10	it	C
    //   137	33	9	element$iv	C
    //   111	60	7	$i$f$any	I
    //   108	63	6	$this$any$iv	Ljava/lang/CharSequence;
    //   46	159	2	possiblePortIndex	I
    //   61	144	3	colonAfterSchemeIndex	I
    //   73	132	4	hasPort	Z
    //   101	104	5	possiblePortDigits	Ljava/lang/String;
    //   0	205	0	this	Lio/javalin/plugin/bundled/CorsUtils;
    //   0	205	1	origin	Ljava/lang/String;
  }
  
  @NotNull
  public final PortResult extractPortOrSchemeDefault$javalin(@NotNull String origin) {
    Intrinsics.checkNotNullParameter(origin, "origin");
    PortResult portResult = extractPort$javalin(origin);
    return (portResult instanceof PortResult.NoPortSpecified && StringsKt.startsWith(origin, "https://", true)) ? new PortResult.PortSpecified(443, true) : ((portResult instanceof PortResult.NoPortSpecified && StringsKt.startsWith(origin, "http://", true)) ? new PortResult.PortSpecified(80, true) : portResult);
  }
  
  @NotNull
  public final String addSchemeIfMissing$javalin(@NotNull String host, @NotNull String defaultScheme) {
    Intrinsics.checkNotNullParameter(host, "host");
    Intrinsics.checkNotNullParameter(defaultScheme, "defaultScheme");
    String hostWithScheme = Intrinsics.areEqual(host, "*") ? host : (Intrinsics.areEqual(host, "null") ? host : (StringsKt.contains$default(host, "://", false, 2, null) ? host : (defaultScheme + "://" + defaultScheme)));
    String str1 = hostWithScheme;
    Intrinsics.checkNotNullExpressionValue(Locale.ROOT, "ROOT");
    Intrinsics.checkNotNullExpressionValue(str1.toLowerCase(Locale.ROOT), "this as java.lang.String).toLowerCase(locale)");
    return StringsKt.removeSuffix(str1.toLowerCase(Locale.ROOT), "/");
  }
  
  @NotNull
  public final String normalizeOrigin$javalin(@NotNull String origin) {
    Intrinsics.checkNotNullParameter(origin, "origin");
    PortResult portResult = extractPortOrSchemeDefault$javalin(origin);
    if (portResult instanceof PortResult.PortSpecified && ((PortResult.PortSpecified)portResult).getFromSchemeDefault())
      return origin + ":" + origin; 
    return origin;
  }
  
  @NotNull
  public final OriginParts parseAsOriginParts$javalin(@NotNull String origin) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'origin'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: checkcast java/lang/CharSequence
    //   10: ldc '://'
    //   12: iconst_0
    //   13: iconst_0
    //   14: bipush #6
    //   16: aconst_null
    //   17: invokestatic indexOf$default : (Ljava/lang/CharSequence;Ljava/lang/String;IZILjava/lang/Object;)I
    //   20: istore_3
    //   21: iload_3
    //   22: istore #4
    //   24: iconst_0
    //   25: istore #5
    //   27: iload #4
    //   29: ifle -> 36
    //   32: iconst_1
    //   33: goto -> 37
    //   36: iconst_0
    //   37: ifne -> 60
    //   40: iconst_0
    //   41: istore #6
    //   43: ldc 'scheme delimiter :// must exist'
    //   45: astore #6
    //   47: new java/lang/IllegalArgumentException
    //   50: dup
    //   51: aload #6
    //   53: invokevirtual toString : ()Ljava/lang/String;
    //   56: invokespecial <init> : (Ljava/lang/String;)V
    //   59: athrow
    //   60: nop
    //   61: iload_3
    //   62: istore_2
    //   63: aload_1
    //   64: iconst_0
    //   65: iload_2
    //   66: invokevirtual subSequence : (II)Ljava/lang/CharSequence;
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: astore #4
    //   74: aload #4
    //   76: astore #5
    //   78: iconst_0
    //   79: istore #6
    //   81: getstatic io/javalin/plugin/bundled/CorsUtils.INSTANCE : Lio/javalin/plugin/bundled/CorsUtils;
    //   84: aload #5
    //   86: checkcast java/lang/CharSequence
    //   89: invokevirtual isSchemeValid$javalin : (Ljava/lang/CharSequence;)Z
    //   92: ifne -> 115
    //   95: iconst_0
    //   96: istore #7
    //   98: ldc 'specified scheme is not valid'
    //   100: astore #7
    //   102: new java/lang/IllegalArgumentException
    //   105: dup
    //   106: aload #7
    //   108: invokevirtual toString : ()Ljava/lang/String;
    //   111: invokespecial <init> : (Ljava/lang/String;)V
    //   114: athrow
    //   115: nop
    //   116: aload #4
    //   118: astore_3
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual extractPort$javalin : (Ljava/lang/String;)Lio/javalin/plugin/bundled/PortResult;
    //   124: astore #6
    //   126: aload #6
    //   128: instanceof io/javalin/plugin/bundled/PortResult$PortSpecified
    //   131: ifeq -> 142
    //   134: aload #6
    //   136: checkcast io/javalin/plugin/bundled/PortResult$PortSpecified
    //   139: goto -> 143
    //   142: aconst_null
    //   143: dup
    //   144: ifnull -> 153
    //   147: invokevirtual getPort : ()I
    //   150: goto -> 164
    //   153: pop
    //   154: new java/lang/IllegalArgumentException
    //   157: dup
    //   158: ldc 'explicit port is required'
    //   160: invokespecial <init> : (Ljava/lang/String;)V
    //   163: athrow
    //   164: istore #4
    //   166: aload_1
    //   167: iload_2
    //   168: iconst_3
    //   169: iadd
    //   170: aload_1
    //   171: checkcast java/lang/CharSequence
    //   174: bipush #58
    //   176: iconst_0
    //   177: iconst_0
    //   178: bipush #6
    //   180: aconst_null
    //   181: invokestatic lastIndexOf$default : (Ljava/lang/CharSequence;CIZILjava/lang/Object;)I
    //   184: invokevirtual subSequence : (II)Ljava/lang/CharSequence;
    //   187: invokevirtual toString : ()Ljava/lang/String;
    //   190: astore #5
    //   192: aload_3
    //   193: aload #5
    //   195: iload #4
    //   197: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;
    //   202: astore #6
    //   204: aload #6
    //   206: aload_1
    //   207: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   210: ifne -> 245
    //   213: iconst_0
    //   214: istore #8
    //   216: aload #6
    //   218: aload_1
    //   219: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: aconst_null
    //   225: iconst_1
    //   226: aconst_null
    //   227: invokestatic trimMargin$default : (Ljava/lang/String;Ljava/lang/String;ILjava/lang/Object;)Ljava/lang/String;
    //   230: astore #8
    //   232: new java/lang/IllegalArgumentException
    //   235: dup
    //   236: aload #8
    //   238: invokevirtual toString : ()Ljava/lang/String;
    //   241: invokespecial <init> : (Ljava/lang/String;)V
    //   244: athrow
    //   245: new io/javalin/plugin/bundled/OriginParts
    //   248: dup
    //   249: aload_3
    //   250: aload #5
    //   252: iload #4
    //   254: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;I)V
    //   257: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #101	-> 6
    //   #201	-> 24
    //   #101	-> 27
    //   #201	-> 40
    //   #101	-> 43
    //   #101	-> 45
    //   #101	-> 60
    //   #101	-> 61
    //   #101	-> 62
    //   #100	-> 62
    //   #102	-> 63
    //   #103	-> 74
    //   #201	-> 78
    //   #103	-> 81
    //   #201	-> 95
    //   #103	-> 98
    //   #103	-> 100
    //   #103	-> 115
    //   #103	-> 116
    //   #103	-> 118
    //   #102	-> 118
    //   #104	-> 119
    //   #105	-> 154
    //   #104	-> 164
    //   #106	-> 166
    //   #108	-> 192
    //   #109	-> 204
    //   #111	-> 216
    //   #115	-> 224
    //   #109	-> 230
    //   #118	-> 245
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   43	2	6	$i$a$-require-CorsUtils$parseAsOriginParts$schemeAndHostDelimiter$1$1	I
    //   27	34	5	$i$a$-also-CorsUtils$parseAsOriginParts$schemeAndHostDelimiter$1	I
    //   24	37	4	it	I
    //   98	2	7	$i$a$-require-CorsUtils$parseAsOriginParts$scheme$1$1	I
    //   81	35	6	$i$a$-also-CorsUtils$parseAsOriginParts$scheme$1	I
    //   78	38	5	it	Ljava/lang/String;
    //   216	14	8	$i$a$-require-CorsUtils$parseAsOriginParts$1	I
    //   63	195	2	schemeAndHostDelimiter	I
    //   119	139	3	scheme	Ljava/lang/String;
    //   166	92	4	port	I
    //   192	66	5	host	Ljava/lang/String;
    //   204	54	6	reconstructedOrigin	Ljava/lang/String;
    //   0	258	0	this	Lio/javalin/plugin/bundled/CorsUtils;
    //   0	258	1	origin	Ljava/lang/String;
  }
  
  public final boolean originsMatch$javalin(@NotNull OriginParts clientOrigin, @NotNull OriginParts serverOrigin) {
    Intrinsics.checkNotNullParameter(clientOrigin, "clientOrigin");
    Intrinsics.checkNotNullParameter(serverOrigin, "serverOrigin");
    if (Intrinsics.areEqual(clientOrigin, serverOrigin))
      return true; 
    if (!Intrinsics.areEqual(clientOrigin.getScheme(), serverOrigin.getScheme()))
      return false; 
    if (clientOrigin.getPort() != serverOrigin.getPort())
      return false; 
    if (!StringsKt.startsWith$default(serverOrigin.getHost(), "*.", false, 2, null))
      return false; 
    String serverHostBase = StringsKt.removePrefix(serverOrigin.getHost(), "*.");
    char[] arrayOfChar = new char[1];
    arrayOfChar[0] = '.';
    String clientHostBase = StringsKt.split$default(clientOrigin.getHost(), arrayOfChar, false, 2, 2, null).get(1);
    return Intrinsics.areEqual(serverHostBase, clientHostBase);
  }
  
  @NotNull
  public final WildcardResult originFulfillsWildcardRequirements$javalin(@NotNull String origin) {
    Intrinsics.checkNotNullParameter(origin, "origin");
    CharSequence $this$count$iv = origin;
    int $i$f$count = 0;
    int count$iv = 0;
    for (byte b = 0; b < $this$count$iv.length(); ) {
      char element$iv = $this$count$iv.charAt(b), it = element$iv;
      int $i$a$-count-CorsUtils$originFulfillsWildcardRequirements$1 = 0;
      if ((it == '*'))
        count$iv++; 
    } 
    switch (count$iv) {
      case 0:
      
      case 1:
        return !StringsKt.contains$default(origin, "://*.", false, 2, null) ? WildcardResult.ErrorState.WildcardNotAtTheStartOfTheHost.INSTANCE : WildcardResult.WildcardOkay.INSTANCE;
    } 
    return WildcardResult.ErrorState.TooManyWildcards.INSTANCE;
  }
}
