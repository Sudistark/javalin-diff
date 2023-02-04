package io.javalin.plugin.bundled;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.HandlerType;
import io.javalin.http.HttpStatus;
import io.javalin.plugin.Plugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000<\n\002\030\002\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\016\n\002\b\002\030\0002\0020\001B\031\022\022\020\002\032\016\022\n\022\b\022\004\022\0020\0050\0040\003¢\006\002\020\006J\020\020\n\032\0020\0132\006\020\f\032\0020\rH\026J\030\020\016\032\0020\0132\006\020\f\032\0020\r2\006\020\017\032\0020\005H\002J\030\020\020\032\0020\0132\006\020\021\032\0020\0222\006\020\017\032\0020\005H\002J\036\020\023\032\0020\0242\006\020\025\032\0020\0262\f\020\027\032\b\022\004\022\0020\0260\003H\002R\027\020\007\032\b\022\004\022\0020\0050\003¢\006\b\n\000\032\004\b\b\020\t¨\006\030"}, d2 = {"Lio/javalin/plugin/bundled/CorsPlugin;", "Lio/javalin/plugin/Plugin;", "userConfigs", "", "Ljava/util/function/Consumer;", "Lio/javalin/plugin/bundled/CorsPluginConfig;", "(Ljava/util/List;)V", "configs", "getConfigs", "()Ljava/util/List;", "apply", "", "app", "Lio/javalin/Javalin;", "applySingleConfig", "cfg", "handleCors", "ctx", "Lio/javalin/http/Context;", "matchOrigin", "", "clientOrigin", "", "origins", "javalin"})
public final class CorsPlugin implements Plugin {
  @NotNull
  private final List<CorsPluginConfig> configs;
  
  public CorsPlugin(@NotNull List userConfigs) {
    if (!(!userConfigs.isEmpty() ? 1 : 0)) {
      int $i$a$-require-CorsPlugin$1 = 0;
      String str = 
        "At least one cors config has to be provided. Use CorsContainer.add() to add one.";
      throw new IllegalArgumentException(str.toString());
    } 
    List list1 = userConfigs;
    CorsPlugin corsPlugin = this;
    int $i$f$map = 0;
    List list2 = list1;
    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault(list1, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : list2) {
      Consumer consumer = (Consumer)item$iv$iv;
      Collection collection = destination$iv$iv;
      int $i$a$-map-CorsPlugin$configs$1 = 0;
      CorsPluginConfig corsPluginConfig1 = new CorsPluginConfig(false, false, null, null, null, null, 63, null), it = corsPluginConfig1;
      int $i$a$-also-CorsPlugin$configs$1$1 = 0;
    } 
    corsPlugin.configs = (List<CorsPluginConfig>)destination$iv$iv;
  }
  
  @NotNull
  public final List<CorsPluginConfig> getConfigs() {
    return this.configs;
  }
  
  public void apply(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    Iterable<CorsPluginConfig> $this$forEach$iv = this.configs;
    int $i$f$forEach = 0;
    for (CorsPluginConfig element$iv : $this$forEach$iv) {
      CorsPluginConfig it = element$iv;
      int $i$a$-forEach-CorsPlugin$apply$1 = 0;
      applySingleConfig(app, it);
    } 
  }
  
  private final void applySingleConfig(Javalin app, CorsPluginConfig cfg) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual allowedOrigins : ()Ljava/util/List;
    //   4: astore_3
    //   5: aload_3
    //   6: checkcast java/util/Collection
    //   9: invokeinterface isEmpty : ()Z
    //   14: ifne -> 21
    //   17: iconst_1
    //   18: goto -> 22
    //   21: iconst_0
    //   22: ifne -> 32
    //   25: aload_2
    //   26: getfield reflectClientOrigin : Z
    //   29: ifeq -> 36
    //   32: iconst_1
    //   33: goto -> 37
    //   36: iconst_0
    //   37: ifne -> 60
    //   40: iconst_0
    //   41: istore #5
    //   43: ldc 'Origins cannot be empty if `reflectClientOrigin` is false.'
    //   45: astore #5
    //   47: new java/lang/IllegalArgumentException
    //   50: dup
    //   51: aload #5
    //   53: invokevirtual toString : ()Ljava/lang/String;
    //   56: invokespecial <init> : (Ljava/lang/String;)V
    //   59: athrow
    //   60: aload_3
    //   61: invokeinterface isEmpty : ()Z
    //   66: ifne -> 76
    //   69: aload_2
    //   70: getfield reflectClientOrigin : Z
    //   73: ifne -> 80
    //   76: iconst_1
    //   77: goto -> 81
    //   80: iconst_0
    //   81: ifne -> 104
    //   84: iconst_0
    //   85: istore #5
    //   87: ldc 'Cannot set `allowedOrigins` if `reflectClientOrigin` is true'
    //   89: astore #5
    //   91: new java/lang/IllegalArgumentException
    //   94: dup
    //   95: aload #5
    //   97: invokevirtual toString : ()Ljava/lang/String;
    //   100: invokespecial <init> : (Ljava/lang/String;)V
    //   103: athrow
    //   104: aload_1
    //   105: aload_2
    //   106: getfield path : Ljava/lang/String;
    //   109: aload_0
    //   110: aload_2
    //   111: <illegal opcode> handle : (Lio/javalin/plugin/bundled/CorsPlugin;Lio/javalin/plugin/bundled/CorsPluginConfig;)Lio/javalin/http/Handler;
    //   116: invokevirtual before : (Ljava/lang/String;Lio/javalin/http/Handler;)Lio/javalin/Javalin;
    //   119: pop
    //   120: iconst_2
    //   121: anewarray io/javalin/http/HttpStatus
    //   124: astore #5
    //   126: aload #5
    //   128: iconst_0
    //   129: getstatic io/javalin/http/HttpStatus.NOT_FOUND : Lio/javalin/http/HttpStatus;
    //   132: aastore
    //   133: aload #5
    //   135: iconst_1
    //   136: getstatic io/javalin/http/HttpStatus.METHOD_NOT_ALLOWED : Lio/javalin/http/HttpStatus;
    //   139: aastore
    //   140: aload #5
    //   142: invokestatic listOf : ([Ljava/lang/Object;)Ljava/util/List;
    //   145: astore #4
    //   147: aload_1
    //   148: aload_2
    //   149: getfield path : Ljava/lang/String;
    //   152: aload #4
    //   154: <illegal opcode> handle : (Ljava/util/List;)Lio/javalin/http/Handler;
    //   159: invokevirtual after : (Ljava/lang/String;Lio/javalin/http/Handler;)Lio/javalin/Javalin;
    //   162: pop
    //   163: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #80	-> 0
    //   #81	-> 5
    //   #81	-> 25
    //   #157	-> 40
    //   #81	-> 43
    //   #81	-> 45
    //   #82	-> 60
    //   #157	-> 84
    //   #82	-> 87
    //   #82	-> 89
    //   #83	-> 104
    //   #86	-> 120
    //   #87	-> 147
    //   #92	-> 163
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   43	2	5	$i$a$-require-CorsPlugin$applySingleConfig$1	I
    //   87	2	5	$i$a$-require-CorsPlugin$applySingleConfig$2	I
    //   5	159	3	origins	Ljava/util/List;
    //   147	17	4	validOptionStatusCodes	Ljava/util/List;
    //   0	164	0	this	Lio/javalin/plugin/bundled/CorsPlugin;
    //   0	164	1	app	Lio/javalin/Javalin;
    //   0	164	2	cfg	Lio/javalin/plugin/bundled/CorsPluginConfig;
  }
  
  private static final void applySingleConfig$lambda-6(CorsPlugin this$0, CorsPluginConfig $cfg, Context ctx) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter($cfg, "$cfg");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    this$0.handleCors(ctx, $cfg);
  }
  
  private static final void applySingleConfig$lambda-7(List $validOptionStatusCodes, Context ctx) {
    Intrinsics.checkNotNullParameter($validOptionStatusCodes, "$validOptionStatusCodes");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    if (ctx.method() == HandlerType.OPTIONS && $validOptionStatusCodes.contains(ctx.status()))
      ctx.result("").status(200); 
  }
  
  private final void handleCors(Context ctx, CorsPluginConfig cfg) {
    if (ctx.header("Origin") == null) {
      ctx.header("Origin");
      return;
    } 
    if (!CorsUtils.INSTANCE.isValidOrigin$javalin(clientOrigin))
      return; 
    if (ctx.method() == HandlerType.OPTIONS) {
      String str1 = ctx.header("Access-Control-Request-Headers"), headerValue = str1;
      int $i$a$-also-CorsPlugin$handleCors$1 = 0;
      ctx.header("Access-Control-Allow-Headers", headerValue);
      ctx.header("Access-Control-Request-Headers");
      headerValue = str1 = ctx.header("Access-Control-Request-Method");
      int $i$a$-also-CorsPlugin$handleCors$2 = 0;
      ctx.header("Access-Control-Allow-Methods", headerValue);
      ctx.header("Access-Control-Request-Method");
    } 
    List<String> origins = cfg.allowedOrigins();
    if (Intrinsics.areEqual(clientOrigin, "null"))
      return; 
    if (matchOrigin(clientOrigin, origins)) {
    
    } else {
      ctx.status(HttpStatus.BAD_REQUEST);
      return;
    } 
    String clientOrigin, allowOriginValue = origins.contains("*") ? "*" : (cfg.reflectClientOrigin ? clientOrigin : ((ctx.header("Access-Control-Request-Method") != null) ? ((ctx.header("Access-Control-Request-Headers") != null) ? (clientOrigin = ctx.header("Origin")) : (clientOrigin = ctx.header("Origin"))) : ((ctx.header("Access-Control-Request-Headers") != null) ? (clientOrigin = ctx.header("Origin")) : (clientOrigin = ctx.header("Origin")))));
    ctx.header("Access-Control-Allow-Origin", allowOriginValue);
    ctx.header("Vary", "Origin");
    if (cfg.allowCredentials)
      ctx.header("Access-Control-Allow-Credentials", "true"); 
    List<String> headersToExpose = cfg.headersToExpose();
    if (!headersToExpose.isEmpty())
      ctx.header("Access-Control-Expose-Headers", CollectionsKt.joinToString$default(headersToExpose, ",", null, null, 0, null, null, 62, null)); 
  }
  
  private final boolean matchOrigin(String clientOrigin, List origins) {
    // Byte code:
    //   0: getstatic io/javalin/plugin/bundled/CorsUtils.INSTANCE : Lio/javalin/plugin/bundled/CorsUtils;
    //   3: getstatic io/javalin/plugin/bundled/CorsUtils.INSTANCE : Lio/javalin/plugin/bundled/CorsUtils;
    //   6: aload_1
    //   7: invokevirtual normalizeOrigin$javalin : (Ljava/lang/String;)Ljava/lang/String;
    //   10: invokevirtual parseAsOriginParts$javalin : (Ljava/lang/String;)Lio/javalin/plugin/bundled/OriginParts;
    //   13: astore_3
    //   14: aload_2
    //   15: checkcast java/lang/Iterable
    //   18: astore #5
    //   20: getstatic io/javalin/plugin/bundled/CorsUtils.INSTANCE : Lio/javalin/plugin/bundled/CorsUtils;
    //   23: astore #6
    //   25: iconst_0
    //   26: istore #7
    //   28: aload #5
    //   30: astore #8
    //   32: new java/util/ArrayList
    //   35: dup
    //   36: aload #5
    //   38: bipush #10
    //   40: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
    //   43: invokespecial <init> : (I)V
    //   46: checkcast java/util/Collection
    //   49: astore #9
    //   51: iconst_0
    //   52: istore #10
    //   54: aload #8
    //   56: invokeinterface iterator : ()Ljava/util/Iterator;
    //   61: astore #11
    //   63: aload #11
    //   65: invokeinterface hasNext : ()Z
    //   70: ifeq -> 115
    //   73: aload #11
    //   75: invokeinterface next : ()Ljava/lang/Object;
    //   80: astore #12
    //   82: aload #9
    //   84: aload #12
    //   86: checkcast java/lang/String
    //   89: astore #13
    //   91: astore #15
    //   93: iconst_0
    //   94: istore #14
    //   96: aload #6
    //   98: aload #13
    //   100: invokevirtual normalizeOrigin$javalin : (Ljava/lang/String;)Ljava/lang/String;
    //   103: aload #15
    //   105: swap
    //   106: invokeinterface add : (Ljava/lang/Object;)Z
    //   111: pop
    //   112: goto -> 63
    //   115: aload #9
    //   117: checkcast java/util/List
    //   120: nop
    //   121: checkcast java/lang/Iterable
    //   124: astore #5
    //   126: getstatic io/javalin/plugin/bundled/CorsUtils.INSTANCE : Lio/javalin/plugin/bundled/CorsUtils;
    //   129: astore #6
    //   131: iconst_0
    //   132: istore #7
    //   134: aload #5
    //   136: astore #8
    //   138: new java/util/ArrayList
    //   141: dup
    //   142: aload #5
    //   144: bipush #10
    //   146: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
    //   149: invokespecial <init> : (I)V
    //   152: checkcast java/util/Collection
    //   155: astore #9
    //   157: iconst_0
    //   158: istore #10
    //   160: aload #8
    //   162: invokeinterface iterator : ()Ljava/util/Iterator;
    //   167: astore #11
    //   169: aload #11
    //   171: invokeinterface hasNext : ()Z
    //   176: ifeq -> 221
    //   179: aload #11
    //   181: invokeinterface next : ()Ljava/lang/Object;
    //   186: astore #12
    //   188: aload #9
    //   190: aload #12
    //   192: checkcast java/lang/String
    //   195: astore #13
    //   197: astore #15
    //   199: iconst_0
    //   200: istore #14
    //   202: aload #6
    //   204: aload #13
    //   206: invokevirtual parseAsOriginParts$javalin : (Ljava/lang/String;)Lio/javalin/plugin/bundled/OriginParts;
    //   209: aload #15
    //   211: swap
    //   212: invokeinterface add : (Ljava/lang/Object;)Z
    //   217: pop
    //   218: goto -> 169
    //   221: aload #9
    //   223: checkcast java/util/List
    //   226: nop
    //   227: astore #4
    //   229: aload #4
    //   231: checkcast java/lang/Iterable
    //   234: astore #5
    //   236: iconst_0
    //   237: istore #6
    //   239: aload #5
    //   241: instanceof java/util/Collection
    //   244: ifeq -> 264
    //   247: aload #5
    //   249: checkcast java/util/Collection
    //   252: invokeinterface isEmpty : ()Z
    //   257: ifeq -> 264
    //   260: iconst_0
    //   261: goto -> 319
    //   264: aload #5
    //   266: invokeinterface iterator : ()Ljava/util/Iterator;
    //   271: astore #7
    //   273: aload #7
    //   275: invokeinterface hasNext : ()Z
    //   280: ifeq -> 318
    //   283: aload #7
    //   285: invokeinterface next : ()Ljava/lang/Object;
    //   290: astore #8
    //   292: aload #8
    //   294: checkcast io/javalin/plugin/bundled/OriginParts
    //   297: astore #9
    //   299: iconst_0
    //   300: istore #10
    //   302: getstatic io/javalin/plugin/bundled/CorsUtils.INSTANCE : Lio/javalin/plugin/bundled/CorsUtils;
    //   305: aload_3
    //   306: aload #9
    //   308: invokevirtual originsMatch$javalin : (Lio/javalin/plugin/bundled/OriginParts;Lio/javalin/plugin/bundled/OriginParts;)Z
    //   311: ifeq -> 273
    //   314: iconst_1
    //   315: goto -> 319
    //   318: iconst_0
    //   319: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #135	-> 0
    //   #136	-> 14
    //   #161	-> 28
    //   #162	-> 54
    //   #163	-> 82
    //   #136	-> 96
    //   #164	-> 115
    //   #161	-> 120
    //   #136	-> 126
    //   #161	-> 134
    //   #162	-> 160
    //   #163	-> 188
    //   #136	-> 202
    //   #164	-> 221
    //   #161	-> 226
    //   #136	-> 227
    //   #138	-> 229
    //   #165	-> 239
    //   #166	-> 264
    //   #138	-> 302
    //   #167	-> 318
    //   #138	-> 319
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   96	7	14	$i$a$-map-CorsPlugin$matchOrigin$serverOriginParts$1	I
    //   93	10	13	p0	Ljava/lang/String;
    //   82	30	12	item$iv$iv	Ljava/lang/Object;
    //   54	63	10	$i$f$mapTo	I
    //   51	66	8	$this$mapTo$iv$iv	Ljava/lang/Iterable;
    //   51	66	9	destination$iv$iv	Ljava/util/Collection;
    //   28	93	7	$i$f$map	I
    //   25	96	5	$this$map$iv	Ljava/lang/Iterable;
    //   202	7	14	$i$a$-map-CorsPlugin$matchOrigin$serverOriginParts$2	I
    //   199	10	13	p0	Ljava/lang/String;
    //   188	30	12	item$iv$iv	Ljava/lang/Object;
    //   160	63	10	$i$f$mapTo	I
    //   157	66	8	$this$mapTo$iv$iv	Ljava/lang/Iterable;
    //   157	66	9	destination$iv$iv	Ljava/util/Collection;
    //   134	93	7	$i$f$map	I
    //   131	96	5	$this$map$iv	Ljava/lang/Iterable;
    //   302	9	10	$i$a$-any-CorsPlugin$matchOrigin$1	I
    //   299	12	9	it	Lio/javalin/plugin/bundled/OriginParts;
    //   292	26	8	element$iv	Ljava/lang/Object;
    //   239	80	6	$i$f$any	I
    //   236	83	5	$this$any$iv	Ljava/lang/Iterable;
    //   14	306	3	clientOriginPart	Lio/javalin/plugin/bundled/OriginParts;
    //   229	91	4	serverOriginParts	Ljava/util/List;
    //   0	320	0	this	Lio/javalin/plugin/bundled/CorsPlugin;
    //   0	320	1	clientOrigin	Ljava/lang/String;
    //   0	320	2	origins	Ljava/util/List;
  }
}
