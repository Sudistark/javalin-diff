package io.javalin.plugin.bundled;

import io.javalin.Javalin;
import io.javalin.event.EventListener;
import io.javalin.event.HandlerMetaInfo;
import io.javalin.http.Context;
import io.javalin.plugin.Plugin;
import io.javalin.plugin.PluginLifecycleInit;
import io.javalin.routing.PathSegment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\0012\0020\002B\005¢\006\002\020\003J\020\020\004\032\0020\0052\006\020\006\032\0020\007H\026J\020\020\b\032\0020\0052\006\020\006\032\0020\007H\026¨\006\t"}, d2 = {"Lio/javalin/plugin/bundled/RedirectToLowercasePathPlugin;", "Lio/javalin/plugin/Plugin;", "Lio/javalin/plugin/PluginLifecycleInit;", "()V", "apply", "", "app", "Lio/javalin/Javalin;", "init", "javalin"})
public final class RedirectToLowercasePathPlugin implements Plugin, PluginLifecycleInit {
  public void init(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    app.events(app::init$lambda-5);
  }
  
  private static final void init$lambda-5(Javalin $app, EventListener listener) {
    Intrinsics.checkNotNullParameter($app, "$app");
    listener.handlerAdded($app::init$lambda-5$lambda-4);
  }
  
  private static final void init$lambda-5$lambda-4(Javalin $app, HandlerMetaInfo handlerMetaInfo) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '$app'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: new io/javalin/routing/PathParser
    //   9: dup
    //   10: aload_1
    //   11: invokevirtual getPath : ()Ljava/lang/String;
    //   14: aload_0
    //   15: getfield cfg : Lio/javalin/config/JavalinConfig;
    //   18: getfield routing : Lio/javalin/config/RoutingConfig;
    //   21: invokespecial <init> : (Ljava/lang/String;Lio/javalin/config/RoutingConfig;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual getSegments : ()Ljava/util/List;
    //   29: checkcast java/lang/Iterable
    //   32: invokestatic asSequence : (Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    //   35: astore #4
    //   37: nop
    //   38: iconst_0
    //   39: istore #5
    //   41: aload #4
    //   43: getstatic io/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$lambda-5$lambda-4$$inlined$filterIsInstance$1.INSTANCE : Lio/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$lambda-5$lambda-4$$inlined$filterIsInstance$1;
    //   46: checkcast kotlin/jvm/functions/Function1
    //   49: invokestatic filter : (Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    //   52: dup
    //   53: ldc 'null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>'
    //   55: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
    //   58: getstatic io/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$1$1$1.INSTANCE : Lio/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$1$1$1;
    //   61: checkcast kotlin/jvm/functions/Function1
    //   64: invokestatic map : (Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    //   67: astore #4
    //   69: nop
    //   70: iconst_0
    //   71: istore #5
    //   73: aload #4
    //   75: invokeinterface iterator : ()Ljava/util/Iterator;
    //   80: astore #6
    //   82: aload #6
    //   84: invokeinterface hasNext : ()Z
    //   89: ifeq -> 158
    //   92: aload #6
    //   94: invokeinterface next : ()Ljava/lang/Object;
    //   99: astore #7
    //   101: aload #7
    //   103: checkcast java/lang/String
    //   106: astore #8
    //   108: iconst_0
    //   109: istore #9
    //   111: aload #8
    //   113: aload #8
    //   115: astore #10
    //   117: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   120: dup
    //   121: ldc 'ROOT'
    //   123: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   126: aload #10
    //   128: swap
    //   129: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   132: dup
    //   133: ldc 'this as java.lang.String).toLowerCase(locale)'
    //   135: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   138: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   141: ifne -> 148
    //   144: iconst_1
    //   145: goto -> 149
    //   148: iconst_0
    //   149: nop
    //   150: ifeq -> 82
    //   153: aload #7
    //   155: goto -> 159
    //   158: aconst_null
    //   159: checkcast java/lang/String
    //   162: astore_3
    //   163: aload_3
    //   164: ifnull -> 183
    //   167: aload_3
    //   168: astore #5
    //   170: iconst_0
    //   171: istore #6
    //   173: new java/lang/IllegalArgumentException
    //   176: dup
    //   177: ldc 'Paths must be lowercase when using RedirectToLowercasePathPlugin'
    //   179: invokespecial <init> : (Ljava/lang/String;)V
    //   182: athrow
    //   183: aload_2
    //   184: invokevirtual getSegments : ()Ljava/util/List;
    //   187: checkcast java/lang/Iterable
    //   190: invokestatic asSequence : (Ljava/lang/Iterable;)Lkotlin/sequences/Sequence;
    //   193: astore #4
    //   195: nop
    //   196: iconst_0
    //   197: istore #5
    //   199: aload #4
    //   201: getstatic io/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$lambda-5$lambda-4$$inlined$filterIsInstance$2.INSTANCE : Lio/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$lambda-5$lambda-4$$inlined$filterIsInstance$2;
    //   204: checkcast kotlin/jvm/functions/Function1
    //   207: invokestatic filter : (Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    //   210: dup
    //   211: ldc 'null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>'
    //   213: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
    //   216: getstatic io/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$1$1$4.INSTANCE : Lio/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$1$1$4;
    //   219: checkcast kotlin/jvm/functions/Function1
    //   222: invokestatic flatMapIterable : (Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    //   225: astore #4
    //   227: nop
    //   228: iconst_0
    //   229: istore #5
    //   231: aload #4
    //   233: getstatic io/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$lambda-5$lambda-4$$inlined$filterIsInstance$3.INSTANCE : Lio/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$lambda-5$lambda-4$$inlined$filterIsInstance$3;
    //   236: checkcast kotlin/jvm/functions/Function1
    //   239: invokestatic filter : (Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    //   242: dup
    //   243: ldc 'null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>'
    //   245: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
    //   248: getstatic io/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$1$1$5.INSTANCE : Lio/javalin/plugin/bundled/RedirectToLowercasePathPlugin$init$1$1$5;
    //   251: checkcast kotlin/jvm/functions/Function1
    //   254: invokestatic map : (Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;
    //   257: astore #4
    //   259: nop
    //   260: iconst_0
    //   261: istore #5
    //   263: aload #4
    //   265: invokeinterface iterator : ()Ljava/util/Iterator;
    //   270: astore #6
    //   272: aload #6
    //   274: invokeinterface hasNext : ()Z
    //   279: ifeq -> 348
    //   282: aload #6
    //   284: invokeinterface next : ()Ljava/lang/Object;
    //   289: astore #7
    //   291: aload #7
    //   293: checkcast java/lang/String
    //   296: astore #8
    //   298: iconst_0
    //   299: istore #9
    //   301: aload #8
    //   303: aload #8
    //   305: astore #10
    //   307: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   310: dup
    //   311: ldc 'ROOT'
    //   313: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   316: aload #10
    //   318: swap
    //   319: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   322: dup
    //   323: ldc 'this as java.lang.String).toLowerCase(locale)'
    //   325: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   328: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   331: ifne -> 338
    //   334: iconst_1
    //   335: goto -> 339
    //   338: iconst_0
    //   339: nop
    //   340: ifeq -> 272
    //   343: aload #7
    //   345: goto -> 349
    //   348: aconst_null
    //   349: checkcast java/lang/String
    //   352: astore_3
    //   353: aload_3
    //   354: ifnull -> 373
    //   357: aload_3
    //   358: astore #5
    //   360: iconst_0
    //   361: istore #6
    //   363: new java/lang/IllegalArgumentException
    //   366: dup
    //   367: ldc 'Paths must be lowercase when using RedirectToLowercasePathPlugin'
    //   369: invokespecial <init> : (Ljava/lang/String;)V
    //   372: athrow
    //   373: nop
    //   374: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #29	-> 6
    //   #35	-> 25
    //   #31	-> 25
    //   #32	-> 37
    //   #98	-> 41
    //   #32	-> 58
    //   #33	-> 58
    //   #34	-> 69
    //   #99	-> 73
    //   #34	-> 111
    //   #34	-> 149
    //   #100	-> 158
    //   #34	-> 159
    //   #35	-> 163
    //   #34	-> 167
    //   #35	-> 168
    //   #101	-> 170
    //   #35	-> 173
    //   #43	-> 183
    //   #37	-> 183
    //   #38	-> 195
    //   #102	-> 199
    //   #38	-> 216
    //   #39	-> 216
    //   #40	-> 227
    //   #103	-> 231
    //   #40	-> 248
    //   #41	-> 248
    //   #42	-> 259
    //   #104	-> 263
    //   #42	-> 301
    //   #42	-> 339
    //   #105	-> 348
    //   #42	-> 349
    //   #43	-> 353
    //   #42	-> 357
    //   #43	-> 358
    //   #101	-> 360
    //   #43	-> 363
    //   #43	-> 373
    //   #44	-> 374
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   41	17	5	$i$f$filterIsInstance	I
    //   38	20	4	$this$filterIsInstance$iv	Lkotlin/sequences/Sequence;
    //   111	39	9	$i$a$-firstOrNull-RedirectToLowercasePathPlugin$init$1$1$2	I
    //   108	42	8	it	Ljava/lang/String;
    //   101	57	7	element$iv	Ljava/lang/Object;
    //   73	86	5	$i$f$firstOrNull	I
    //   70	89	4	$this$firstOrNull$iv	Lkotlin/sequences/Sequence;
    //   173	10	6	$i$a$-run-RedirectToLowercasePathPlugin$init$1$1$3	I
    //   170	13	5	$this$init_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d1	Ljava/lang/String;
    //   199	17	5	$i$f$filterIsInstance	I
    //   196	20	4	$this$filterIsInstance$iv	Lkotlin/sequences/Sequence;
    //   231	17	5	$i$f$filterIsInstance	I
    //   228	20	4	$this$filterIsInstance$iv	Lkotlin/sequences/Sequence;
    //   301	39	9	$i$a$-firstOrNull-RedirectToLowercasePathPlugin$init$1$1$6	I
    //   298	42	8	it	Ljava/lang/String;
    //   291	57	7	element$iv	Ljava/lang/Object;
    //   263	86	5	$i$f$firstOrNull	I
    //   260	89	4	$this$firstOrNull$iv	Lkotlin/sequences/Sequence;
    //   363	10	6	$i$a$-run-RedirectToLowercasePathPlugin$init$1$1$7	I
    //   360	13	5	$this$init_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3	Ljava/lang/String;
    //   25	350	2	parser	Lio/javalin/routing/PathParser;
    //   0	375	0	$app	Lio/javalin/Javalin;
    //   0	375	1	handlerMetaInfo	Lio/javalin/event/HandlerMetaInfo;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\022\n\000\n\002\020\016\n\000\n\002\030\002\n\002\030\002\n\000\020\000\032\0020\0012\013\020\002\032\0070\003¢\006\002\b\004H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/routing/PathSegment$Normal;", "Lkotlin/internal/NoInfer;", "invoke"})
  static final class RedirectToLowercasePathPlugin$init$1$1$1 extends Lambda implements Function1<PathSegment.Normal, String> {
    public static final RedirectToLowercasePathPlugin$init$1$1$1 INSTANCE = new RedirectToLowercasePathPlugin$init$1$1$1();
    
    RedirectToLowercasePathPlugin$init$1$1$1() {
      super(1);
    }
    
    @NotNull
    public final String invoke(@NotNull PathSegment.Normal it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it.getContent();
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\026\n\000\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\020\000\032\b\022\004\022\0020\0020\0012\013\020\003\032\0070\004¢\006\002\b\005H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "Lio/javalin/routing/PathSegment;", "it", "Lio/javalin/routing/PathSegment$MultipleSegments;", "Lkotlin/internal/NoInfer;", "invoke"})
  static final class RedirectToLowercasePathPlugin$init$1$1$4 extends Lambda implements Function1<PathSegment.MultipleSegments, List<? extends PathSegment>> {
    public static final RedirectToLowercasePathPlugin$init$1$1$4 INSTANCE = new RedirectToLowercasePathPlugin$init$1$1$4();
    
    RedirectToLowercasePathPlugin$init$1$1$4() {
      super(1);
    }
    
    @NotNull
    public final List<PathSegment> invoke(@NotNull PathSegment.MultipleSegments it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it.getInnerSegments();
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\022\n\000\n\002\020\016\n\000\n\002\030\002\n\002\030\002\n\000\020\000\032\0020\0012\013\020\002\032\0070\003¢\006\002\b\004H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/routing/PathSegment$Normal;", "Lkotlin/internal/NoInfer;", "invoke"})
  static final class RedirectToLowercasePathPlugin$init$1$1$5 extends Lambda implements Function1<PathSegment.Normal, String> {
    public static final RedirectToLowercasePathPlugin$init$1$1$5 INSTANCE = new RedirectToLowercasePathPlugin$init$1$1$5();
    
    RedirectToLowercasePathPlugin$init$1$1$5() {
      super(1);
    }
    
    @NotNull
    public final String invoke(@NotNull PathSegment.Normal it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return it.getContent();
    }
  }
  
  public void apply(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    app.before(app::apply$lambda-10);
  }
  
  private static final void apply$lambda-10(Javalin $app, Context ctx) {
    // Byte code:
    //   0: aload_0
    //   1: ldc '$app'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'ctx'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: invokeinterface path : ()Ljava/lang/String;
    //   18: aload_1
    //   19: invokeinterface contextPath : ()Ljava/lang/String;
    //   24: checkcast java/lang/CharSequence
    //   27: invokestatic removePrefix : (Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   30: astore_2
    //   31: aload_0
    //   32: invokevirtual javalinServlet : ()Lio/javalin/http/servlet/JavalinServlet;
    //   35: invokevirtual getMatcher : ()Lio/javalin/routing/PathMatcher;
    //   38: astore_3
    //   39: aload_3
    //   40: aload_1
    //   41: invokeinterface method : ()Lio/javalin/http/HandlerType;
    //   46: aload_2
    //   47: invokevirtual findEntries : (Lio/javalin/http/HandlerType;Ljava/lang/String;)Ljava/util/List;
    //   50: invokestatic firstOrNull : (Ljava/util/List;)Ljava/lang/Object;
    //   53: ifnull -> 57
    //   56: return
    //   57: aload_3
    //   58: aload_1
    //   59: invokeinterface method : ()Lio/javalin/http/HandlerType;
    //   64: aload_2
    //   65: astore #6
    //   67: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   70: dup
    //   71: ldc 'ROOT'
    //   73: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   76: aload #6
    //   78: swap
    //   79: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   82: dup
    //   83: ldc 'this as java.lang.String).toLowerCase(locale)'
    //   85: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   88: invokevirtual findEntries : (Lio/javalin/http/HandlerType;Ljava/lang/String;)Ljava/util/List;
    //   91: invokestatic firstOrNull : (Ljava/util/List;)Ljava/lang/Object;
    //   94: checkcast io/javalin/routing/HandlerEntry
    //   97: dup
    //   98: ifnonnull -> 103
    //   101: pop
    //   102: return
    //   103: astore #4
    //   105: aload_2
    //   106: checkcast java/lang/CharSequence
    //   109: iconst_1
    //   110: anewarray java/lang/String
    //   113: astore #6
    //   115: aload #6
    //   117: iconst_0
    //   118: ldc_w '/'
    //   121: aastore
    //   122: aload #6
    //   124: iconst_0
    //   125: iconst_0
    //   126: bipush #6
    //   128: aconst_null
    //   129: invokestatic split$default : (Ljava/lang/CharSequence;[Ljava/lang/String;ZIILjava/lang/Object;)Ljava/util/List;
    //   132: checkcast java/lang/Iterable
    //   135: astore #6
    //   137: nop
    //   138: iconst_0
    //   139: istore #7
    //   141: aload #6
    //   143: astore #8
    //   145: new java/util/ArrayList
    //   148: dup
    //   149: invokespecial <init> : ()V
    //   152: checkcast java/util/Collection
    //   155: astore #9
    //   157: iconst_0
    //   158: istore #10
    //   160: aload #8
    //   162: invokeinterface iterator : ()Ljava/util/Iterator;
    //   167: astore #11
    //   169: aload #11
    //   171: invokeinterface hasNext : ()Z
    //   176: ifeq -> 233
    //   179: aload #11
    //   181: invokeinterface next : ()Ljava/lang/Object;
    //   186: astore #12
    //   188: aload #12
    //   190: checkcast java/lang/String
    //   193: astore #13
    //   195: iconst_0
    //   196: istore #14
    //   198: aload #13
    //   200: checkcast java/lang/CharSequence
    //   203: invokeinterface length : ()I
    //   208: ifle -> 215
    //   211: iconst_1
    //   212: goto -> 216
    //   215: iconst_0
    //   216: nop
    //   217: ifeq -> 169
    //   220: aload #9
    //   222: aload #12
    //   224: invokeinterface add : (Ljava/lang/Object;)Z
    //   229: pop
    //   230: goto -> 169
    //   233: aload #9
    //   235: checkcast java/util/List
    //   238: nop
    //   239: checkcast java/util/Collection
    //   242: astore #6
    //   244: nop
    //   245: iconst_0
    //   246: istore #7
    //   248: aload #6
    //   250: astore #8
    //   252: aload #8
    //   254: iconst_0
    //   255: anewarray java/lang/String
    //   258: invokeinterface toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   263: dup
    //   264: ldc_w 'null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>'
    //   267: invokestatic checkNotNull : (Ljava/lang/Object;Ljava/lang/String;)V
    //   270: checkcast [Ljava/lang/String;
    //   273: astore #5
    //   275: new io/javalin/routing/PathParser
    //   278: dup
    //   279: aload #4
    //   281: invokevirtual getPath : ()Ljava/lang/String;
    //   284: aload_0
    //   285: getfield cfg : Lio/javalin/config/JavalinConfig;
    //   288: getfield routing : Lio/javalin/config/RoutingConfig;
    //   291: invokespecial <init> : (Ljava/lang/String;Lio/javalin/config/RoutingConfig;)V
    //   294: invokevirtual getSegments : ()Ljava/util/List;
    //   297: astore #6
    //   299: aload #6
    //   301: checkcast java/lang/Iterable
    //   304: astore #7
    //   306: iconst_0
    //   307: istore #8
    //   309: iconst_0
    //   310: istore #9
    //   312: aload #7
    //   314: invokeinterface iterator : ()Ljava/util/Iterator;
    //   319: astore #10
    //   321: aload #10
    //   323: invokeinterface hasNext : ()Z
    //   328: ifeq -> 612
    //   331: aload #10
    //   333: invokeinterface next : ()Ljava/lang/Object;
    //   338: astore #11
    //   340: iload #9
    //   342: iinc #9, 1
    //   345: istore #12
    //   347: iload #12
    //   349: ifge -> 355
    //   352: invokestatic throwIndexOverflow : ()V
    //   355: iload #12
    //   357: aload #11
    //   359: checkcast io/javalin/routing/PathSegment
    //   362: astore #13
    //   364: istore #14
    //   366: iconst_0
    //   367: istore #15
    //   369: aload #13
    //   371: instanceof io/javalin/routing/PathSegment$Normal
    //   374: ifeq -> 410
    //   377: aload #5
    //   379: iload #14
    //   381: aload #5
    //   383: iload #14
    //   385: aaload
    //   386: astore #16
    //   388: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   391: dup
    //   392: ldc 'ROOT'
    //   394: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   397: aload #16
    //   399: swap
    //   400: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   403: dup
    //   404: ldc 'this as java.lang.String).toLowerCase(locale)'
    //   406: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   409: aastore
    //   410: aload #13
    //   412: instanceof io/javalin/routing/PathSegment$MultipleSegments
    //   415: ifeq -> 608
    //   418: aload #13
    //   420: checkcast io/javalin/routing/PathSegment$MultipleSegments
    //   423: invokevirtual getInnerSegments : ()Ljava/util/List;
    //   426: checkcast java/lang/Iterable
    //   429: astore #16
    //   431: nop
    //   432: iconst_0
    //   433: istore #17
    //   435: aload #16
    //   437: astore #18
    //   439: new java/util/ArrayList
    //   442: dup
    //   443: invokespecial <init> : ()V
    //   446: checkcast java/util/Collection
    //   449: astore #19
    //   451: iconst_0
    //   452: istore #20
    //   454: aload #18
    //   456: invokeinterface iterator : ()Ljava/util/Iterator;
    //   461: astore #21
    //   463: aload #21
    //   465: invokeinterface hasNext : ()Z
    //   470: ifeq -> 503
    //   473: aload #21
    //   475: invokeinterface next : ()Ljava/lang/Object;
    //   480: astore #22
    //   482: aload #22
    //   484: instanceof io/javalin/routing/PathSegment$Normal
    //   487: ifeq -> 463
    //   490: aload #19
    //   492: aload #22
    //   494: invokeinterface add : (Ljava/lang/Object;)Z
    //   499: pop
    //   500: goto -> 463
    //   503: aload #19
    //   505: checkcast java/util/List
    //   508: nop
    //   509: checkcast java/lang/Iterable
    //   512: astore #16
    //   514: nop
    //   515: iconst_0
    //   516: istore #17
    //   518: aload #16
    //   520: invokeinterface iterator : ()Ljava/util/Iterator;
    //   525: astore #18
    //   527: aload #18
    //   529: invokeinterface hasNext : ()Z
    //   534: ifeq -> 607
    //   537: aload #18
    //   539: invokeinterface next : ()Ljava/lang/Object;
    //   544: astore #19
    //   546: aload #19
    //   548: checkcast io/javalin/routing/PathSegment$Normal
    //   551: astore #20
    //   553: iconst_0
    //   554: istore #21
    //   556: aload #5
    //   558: iload #14
    //   560: aload #5
    //   562: iload #14
    //   564: aaload
    //   565: aload #20
    //   567: invokevirtual getContent : ()Ljava/lang/String;
    //   570: aload #20
    //   572: invokevirtual getContent : ()Ljava/lang/String;
    //   575: astore #22
    //   577: getstatic java/util/Locale.ROOT : Ljava/util/Locale;
    //   580: dup
    //   581: ldc 'ROOT'
    //   583: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   586: aload #22
    //   588: swap
    //   589: invokevirtual toLowerCase : (Ljava/util/Locale;)Ljava/lang/String;
    //   592: dup
    //   593: ldc 'this as java.lang.String).toLowerCase(locale)'
    //   595: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   598: iconst_1
    //   599: invokestatic replace : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;
    //   602: aastore
    //   603: nop
    //   604: goto -> 527
    //   607: nop
    //   608: nop
    //   609: goto -> 321
    //   612: nop
    //   613: aload_1
    //   614: aload #5
    //   616: ldc_w '/'
    //   619: checkcast java/lang/CharSequence
    //   622: aconst_null
    //   623: aconst_null
    //   624: iconst_0
    //   625: aconst_null
    //   626: aconst_null
    //   627: bipush #62
    //   629: aconst_null
    //   630: invokestatic joinToString$default : ([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;ILjava/lang/Object;)Ljava/lang/String;
    //   633: aload_1
    //   634: invokeinterface queryString : ()Ljava/lang/String;
    //   639: dup
    //   640: ifnull -> 672
    //   643: astore #10
    //   645: astore #24
    //   647: astore #23
    //   649: iconst_0
    //   650: istore #11
    //   652: aload #10
    //   654: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   659: astore #25
    //   661: aload #23
    //   663: aload #24
    //   665: aload #25
    //   667: nop
    //   668: dup
    //   669: ifnonnull -> 676
    //   672: pop
    //   673: ldc_w ''
    //   676: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   681: getstatic io/javalin/http/HttpStatus.MOVED_PERMANENTLY : Lio/javalin/http/HttpStatus;
    //   684: invokeinterface redirect : (Ljava/lang/String;Lio/javalin/http/HttpStatus;)V
    //   689: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #50	-> 12
    //   #51	-> 31
    //   #53	-> 39
    //   #54	-> 56
    //   #57	-> 57
    //   #57	-> 88
    //   #58	-> 91
    //   #57	-> 97
    //   #59	-> 102
    //   #57	-> 103
    //   #61	-> 105
    //   #62	-> 137
    //   #106	-> 141
    //   #107	-> 160
    //   #62	-> 198
    //   #62	-> 216
    //   #108	-> 233
    //   #106	-> 238
    //   #63	-> 244
    //   #109	-> 248
    //   #110	-> 250
    //   #112	-> 252
    //   #63	-> 270
    //   #61	-> 273
    //   #65	-> 275
    //   #66	-> 294
    //   #65	-> 297
    //   #68	-> 299
    //   #113	-> 309
    //   #114	-> 312
    //   #114	-> 357
    //   #70	-> 369
    //   #71	-> 377
    //   #75	-> 410
    //   #76	-> 418
    //   #77	-> 431
    //   #115	-> 435
    //   #124	-> 454
    //   #125	-> 503
    //   #115	-> 508
    //   #78	-> 514
    //   #126	-> 518
    //   #79	-> 556
    //   #80	-> 565
    //   #81	-> 570
    //   #82	-> 598
    //   #79	-> 599
    //   #84	-> 603
    //   #127	-> 607
    //   #86	-> 608
    //   #128	-> 612
    //   #88	-> 613
    //   #89	-> 614
    //   #101	-> 645
    //   #89	-> 652
    //   #89	-> 667
    //   #89	-> 668
    //   #90	-> 681
    //   #88	-> 684
    //   #92	-> 689
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   198	19	14	$i$a$-filter-RedirectToLowercasePathPlugin$apply$1$clientSegments$1	I
    //   195	22	13	it	Ljava/lang/String;
    //   188	42	12	element$iv$iv	Ljava/lang/Object;
    //   160	75	10	$i$f$filterTo	I
    //   157	78	8	$this$filterTo$iv$iv	Ljava/lang/Iterable;
    //   157	78	9	destination$iv$iv	Ljava/util/Collection;
    //   141	98	7	$i$f$filter	I
    //   138	101	6	$this$filter$iv	Ljava/lang/Iterable;
    //   248	22	7	$i$f$toTypedArray	I
    //   252	18	8	thisCollection$iv	Ljava/util/Collection;
    //   245	25	6	$this$toTypedArray$iv	Ljava/util/Collection;
    //   482	18	22	element$iv$iv	Ljava/lang/Object;
    //   454	51	20	$i$f$filterIsInstanceTo	I
    //   451	54	18	$this$filterIsInstanceTo$iv$iv	Ljava/lang/Iterable;
    //   451	54	19	destination$iv$iv	Ljava/util/Collection;
    //   435	74	17	$i$f$filterIsInstance	I
    //   432	77	16	$this$filterIsInstance$iv	Ljava/lang/Iterable;
    //   556	48	21	$i$a$-forEach-RedirectToLowercasePathPlugin$apply$1$1$1	I
    //   553	51	20	innerServerSegment	Lio/javalin/routing/PathSegment$Normal;
    //   546	58	19	element$iv	Ljava/lang/Object;
    //   518	90	17	$i$f$forEach	I
    //   515	93	16	$this$forEach$iv	Ljava/lang/Iterable;
    //   369	240	15	$i$a$-forEachIndexed-RedirectToLowercasePathPlugin$apply$1$1	I
    //   366	243	14	index	I
    //   366	243	13	serverSegment	Lio/javalin/routing/PathSegment;
    //   340	269	11	item$iv	Ljava/lang/Object;
    //   309	304	8	$i$f$forEachIndexed	I
    //   312	301	9	index$iv	I
    //   306	307	7	$this$forEachIndexed$iv	Ljava/lang/Iterable;
    //   652	7	11	$i$a$-let-RedirectToLowercasePathPlugin$apply$1$2	I
    //   649	10	10	it	Ljava/lang/String;
    //   31	659	2	requestUri	Ljava/lang/String;
    //   39	651	3	matcher	Lio/javalin/routing/PathMatcher;
    //   105	585	4	lowercaseRoute	Lio/javalin/routing/HandlerEntry;
    //   275	415	5	clientSegments	[Ljava/lang/String;
    //   299	391	6	serverSegments	Ljava/util/List;
    //   0	690	0	$app	Lio/javalin/Javalin;
    //   0	690	1	ctx	Lio/javalin/http/Context;
  }
}
