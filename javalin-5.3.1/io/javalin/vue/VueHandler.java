package io.javalin.vue;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.nio.file.Path;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000,\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\004\n\002\020\000\n\002\b\004\n\002\030\002\b&\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\026J\030\020\t\032\0020\0032\006\020\n\032\0020\0032\006\020\007\032\0020\bH\026J\030\020\013\032\0020\0032\006\020\n\032\0020\0032\006\020\007\032\0020\bH\026J\022\020\f\032\004\030\0010\r2\006\020\007\032\0020\bH\026J\024\020\016\032\0020\003*\0020\0032\006\020\007\032\0020\bH\002J\024\020\017\032\0020\003*\0020\0032\006\020\007\032\0020\bH\002R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\020²\006\n\020\021\032\0020\022X\002"}, d2 = {"Lio/javalin/vue/VueHandler;", "Lio/javalin/http/Handler;", "componentId", "", "(Ljava/lang/String;)V", "handle", "", "ctx", "Lio/javalin/http/Context;", "postRender", "layout", "preRender", "state", "", "postRenderHook", "preRenderHook", "javalin", "resolver", "Lio/javalin/vue/VueDependencyResolver;"})
public abstract class VueHandler implements Handler {
  @NotNull
  private final String componentId;
  
  public VueHandler(@NotNull String componentId) {
    this.componentId = componentId;
  }
  
  @Nullable
  public Object state(@NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    return null;
  }
  
  @NotNull
  public String preRender(@NotNull String layout, @NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(layout, "layout");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    return layout;
  }
  
  @NotNull
  public String postRender(@NotNull String layout, @NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(layout, "layout");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    return layout;
  }
  
  public void handle(@NotNull Context ctx) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'ctx'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_1
    //   7: ldc 'javalin-javalinvue-config'
    //   9: invokeinterface appAttribute : (Ljava/lang/String;)Ljava/lang/Object;
    //   14: checkcast io/javalin/vue/JavalinVueConfig
    //   17: astore_2
    //   18: aload_2
    //   19: aload_2
    //   20: invokevirtual isDev$javalin : ()Ljava/lang/Boolean;
    //   23: dup
    //   24: ifnonnull -> 41
    //   27: pop
    //   28: aload_2
    //   29: getfield isDevFunction : Lkotlin/jvm/functions/Function1;
    //   32: aload_1
    //   33: invokeinterface invoke : (Ljava/lang/Object;)Ljava/lang/Object;
    //   38: checkcast java/lang/Boolean
    //   41: invokevirtual setDev$javalin : (Ljava/lang/Boolean;)V
    //   44: aload_2
    //   45: aload_2
    //   46: invokevirtual getRootDirectory$javalin : ()Ljava/nio/file/Path;
    //   49: dup
    //   50: ifnonnull -> 72
    //   53: pop
    //   54: aload_2
    //   55: invokevirtual getPathMaster$javalin : ()Lio/javalin/vue/VuePathMaster;
    //   58: aload_2
    //   59: invokevirtual isDev$javalin : ()Ljava/lang/Boolean;
    //   62: dup
    //   63: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   66: invokevirtual booleanValue : ()Z
    //   69: invokevirtual defaultLocation : (Z)Ljava/nio/file/Path;
    //   72: invokevirtual setRootDirectory$javalin : (Ljava/nio/file/Path;)V
    //   75: aload_0
    //   76: getfield componentId : Ljava/lang/String;
    //   79: ldc '<'
    //   81: iconst_0
    //   82: iconst_2
    //   83: aconst_null
    //   84: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
    //   87: ifeq -> 97
    //   90: aload_0
    //   91: getfield componentId : Ljava/lang/String;
    //   94: goto -> 110
    //   97: aload_0
    //   98: getfield componentId : Ljava/lang/String;
    //   101: aload_0
    //   102: getfield componentId : Ljava/lang/String;
    //   105: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   110: astore_3
    //   111: aload_2
    //   112: invokevirtual isDev$javalin : ()Ljava/lang/Boolean;
    //   115: iconst_1
    //   116: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   119: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   122: ifeq -> 135
    //   125: aload_2
    //   126: invokevirtual getPathMaster$javalin : ()Lio/javalin/vue/VuePathMaster;
    //   129: invokevirtual walkPaths : ()Ljava/util/Set;
    //   132: goto -> 142
    //   135: aload_2
    //   136: invokevirtual getPathMaster$javalin : ()Lio/javalin/vue/VuePathMaster;
    //   139: invokevirtual getCachedPaths$javalin : ()Ljava/util/Set;
    //   142: astore #4
    //   144: new io/javalin/vue/VueHandler$handle$resolver$2
    //   147: dup
    //   148: aload_2
    //   149: aload #4
    //   151: invokespecial <init> : (Lio/javalin/vue/JavalinVueConfig;Ljava/util/Set;)V
    //   154: checkcast kotlin/jvm/functions/Function0
    //   157: invokestatic lazy : (Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    //   160: astore #5
    //   162: aload_3
    //   163: ldc '<'
    //   165: checkcast java/lang/CharSequence
    //   168: invokestatic removePrefix : (Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   171: astore #7
    //   173: iconst_0
    //   174: istore #8
    //   176: iconst_0
    //   177: istore #9
    //   179: aload #7
    //   181: invokevirtual length : ()I
    //   184: istore #10
    //   186: iload #9
    //   188: iload #10
    //   190: if_icmpge -> 286
    //   193: aload #7
    //   195: iload #9
    //   197: invokevirtual charAt : (I)C
    //   200: istore #11
    //   202: iconst_0
    //   203: istore #12
    //   205: iconst_2
    //   206: anewarray java/lang/Character
    //   209: astore #13
    //   211: aload #13
    //   213: iconst_0
    //   214: bipush #62
    //   216: invokestatic valueOf : (C)Ljava/lang/Character;
    //   219: aastore
    //   220: aload #13
    //   222: iconst_1
    //   223: bipush #32
    //   225: invokestatic valueOf : (C)Ljava/lang/Character;
    //   228: aastore
    //   229: aload #13
    //   231: invokestatic setOf : ([Ljava/lang/Object;)Ljava/util/Set;
    //   234: iload #11
    //   236: invokestatic valueOf : (C)Ljava/lang/Character;
    //   239: invokeinterface contains : (Ljava/lang/Object;)Z
    //   244: ifne -> 251
    //   247: iconst_1
    //   248: goto -> 252
    //   251: iconst_0
    //   252: ifne -> 280
    //   255: aload #7
    //   257: astore #11
    //   259: iconst_0
    //   260: istore #12
    //   262: aload #11
    //   264: iload #12
    //   266: iload #9
    //   268: invokevirtual substring : (II)Ljava/lang/String;
    //   271: dup
    //   272: ldc 'this as java.lang.String…ing(startIndex, endIndex)'
    //   274: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   277: goto -> 288
    //   280: iinc #9, 1
    //   283: goto -> 186
    //   286: aload #7
    //   288: astore #6
    //   290: aload_2
    //   291: getfield optimizeDependencies : Z
    //   294: ifeq -> 310
    //   297: aload #5
    //   299: invokestatic handle$lambda-0 : (Lkotlin/Lazy;)Lio/javalin/vue/VueDependencyResolver;
    //   302: aload #6
    //   304: invokevirtual resolve : (Ljava/lang/String;)Ljava/lang/String;
    //   307: goto -> 315
    //   310: aload #4
    //   312: invokestatic access$joinVueFiles : (Ljava/util/Set;)Ljava/lang/String;
    //   315: astore #7
    //   317: aload #7
    //   319: ldc 'dependencies'
    //   321: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   324: aload #7
    //   326: checkcast java/lang/CharSequence
    //   329: aload #6
    //   331: checkcast java/lang/CharSequence
    //   334: iconst_0
    //   335: iconst_2
    //   336: aconst_null
    //   337: invokestatic contains$default : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;ZILjava/lang/Object;)Z
    //   340: ifne -> 360
    //   343: new io/javalin/http/InternalServerErrorResponse
    //   346: dup
    //   347: aload_3
    //   348: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   353: aconst_null
    //   354: iconst_2
    //   355: aconst_null
    //   356: invokespecial <init> : (Ljava/lang/String;Ljava/util/Map;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   359: athrow
    //   360: aload_1
    //   361: aload_0
    //   362: getstatic io/javalin/vue/VueFileInliner.INSTANCE : Lio/javalin/vue/VueFileInliner;
    //   365: aload_0
    //   366: aload #4
    //   368: checkcast java/lang/Iterable
    //   371: astore #8
    //   373: astore #20
    //   375: astore #19
    //   377: astore #18
    //   379: astore #17
    //   381: aload #8
    //   383: astore #9
    //   385: aload #9
    //   387: invokeinterface iterator : ()Ljava/util/Iterator;
    //   392: astore #10
    //   394: aload #10
    //   396: invokeinterface hasNext : ()Z
    //   401: ifeq -> 440
    //   404: aload #10
    //   406: invokeinterface next : ()Ljava/lang/Object;
    //   411: astore #11
    //   413: aload #11
    //   415: checkcast java/nio/file/Path
    //   418: astore #12
    //   420: iconst_0
    //   421: istore #13
    //   423: aload #12
    //   425: ldc 'vue/layout.html'
    //   427: invokeinterface endsWith : (Ljava/lang/String;)Z
    //   432: ifeq -> 394
    //   435: aload #11
    //   437: goto -> 441
    //   440: aconst_null
    //   441: astore #21
    //   443: aload #17
    //   445: aload #18
    //   447: aload #19
    //   449: aload #20
    //   451: aload #21
    //   453: dup
    //   454: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   457: checkcast java/nio/file/Path
    //   460: invokestatic readText : (Ljava/nio/file/Path;)Ljava/lang/String;
    //   463: aload_1
    //   464: invokespecial preRenderHook : (Ljava/lang/String;Lio/javalin/http/Context;)Ljava/lang/String;
    //   467: aload_2
    //   468: invokevirtual isDev$javalin : ()Ljava/lang/Boolean;
    //   471: dup
    //   472: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   475: invokevirtual booleanValue : ()Z
    //   478: aload #4
    //   480: checkcast java/lang/Iterable
    //   483: astore #8
    //   485: istore #21
    //   487: astore #20
    //   489: astore #19
    //   491: astore #18
    //   493: astore #17
    //   495: iconst_0
    //   496: istore #9
    //   498: aload #8
    //   500: astore #10
    //   502: new java/util/ArrayList
    //   505: dup
    //   506: invokespecial <init> : ()V
    //   509: checkcast java/util/Collection
    //   512: astore #11
    //   514: iconst_0
    //   515: istore #12
    //   517: aload #10
    //   519: invokeinterface iterator : ()Ljava/util/Iterator;
    //   524: astore #13
    //   526: aload #13
    //   528: invokeinterface hasNext : ()Z
    //   533: ifeq -> 576
    //   536: aload #13
    //   538: invokeinterface next : ()Ljava/lang/Object;
    //   543: astore #14
    //   545: aload #14
    //   547: checkcast java/nio/file/Path
    //   550: astore #15
    //   552: iconst_0
    //   553: istore #16
    //   555: aload #15
    //   557: invokestatic isVueFile : (Ljava/nio/file/Path;)Z
    //   560: ifne -> 526
    //   563: aload #11
    //   565: aload #14
    //   567: invokeinterface add : (Ljava/lang/Object;)Z
    //   572: pop
    //   573: goto -> 526
    //   576: aload #11
    //   578: checkcast java/util/List
    //   581: nop
    //   582: astore #22
    //   584: aload #17
    //   586: aload #18
    //   588: aload #19
    //   590: aload #20
    //   592: iload #21
    //   594: aload #22
    //   596: invokevirtual inlineFiles : (Ljava/lang/String;ZLjava/util/List;)Ljava/lang/String;
    //   599: ldc_w '@componentRegistration'
    //   602: ldc_w '@loadableData@componentRegistration@serverState'
    //   605: iconst_0
    //   606: iconst_4
    //   607: aconst_null
    //   608: invokestatic replace$default : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;
    //   611: ldc_w '@loadableData'
    //   614: ldc_w '\\n\\n<script nonce="@internalAddNonce">\\n    class LoadableData {\\n        constructor(url, cache = true, errorCallback = null) {\\n            this._url = url;\\n            this._errorCallback = errorCallback;\\n            this.refresh(cache);\\n            this.addRefreshListener();\\n        }\\n        refresh(cache = true) {\\n            this.data = null;\\n            this.loading = true;\\n            this.loaded = false;\\n            this.loadError = null;\\n            let cacheKey = "LoadableData:" + this._url;\\n            if (cache) {\\n                this.data = JSON.parse(localStorage.getItem(cacheKey)) || null;\\n                this.loaded = this.data !== null;\\n                this.loading = this.loaded === false;\\n            }\\n            fetch(this._url).then(res => {\\n                if (res.ok) return res.json();\\n                throw JSON.stringify({code: res.status, text: res.statusText});\\n            }).then(data => {\\n                this.data = data;\\n                this.loaded = true;\\n                if (cache) {\\n                    localStorage.setItem(cacheKey, JSON.stringify(data));\\n                }\\n            }).catch(error => {\\n                this.loadError = JSON.parse(error);\\n                if (this._errorCallback !== null) { // should probably handle in UI\\n                    this._errorCallback(error);\\n                }\\n            }).finally(() => this.loading = false);\\n        }\\n        refreshAll() {\\n            LoadableData.refreshAll(this._url);\\n        }\\n        static refreshAll(url) {\\n            window.dispatchEvent(new CustomEvent("javalinvue-loadable-data-update", {detail: url}));\\n        }\\n        addRefreshListener() {\\n            window.addEventListener("javalinvue-loadable-data-update", e => {\\n                if (this._url === e.detail) {\\n                    this.refresh(false);\\n                }\\n            }, false);\\n        }\\n    }\\n</script>'
    //   617: iconst_0
    //   618: iconst_4
    //   619: aconst_null
    //   620: invokestatic replace$default : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;
    //   623: ldc_w '@componentRegistration'
    //   626: aload #7
    //   628: iconst_0
    //   629: iconst_4
    //   630: aconst_null
    //   631: invokestatic replace$default : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;
    //   634: ldc_w '@serverState'
    //   637: getstatic io/javalin/vue/VueStateRenderer.INSTANCE : Lio/javalin/vue/VueStateRenderer;
    //   640: aload_1
    //   641: aload_0
    //   642: aload_1
    //   643: invokevirtual state : (Lio/javalin/http/Context;)Ljava/lang/Object;
    //   646: invokevirtual getState : (Lio/javalin/http/Context;Ljava/lang/Object;)Ljava/lang/String;
    //   649: iconst_0
    //   650: iconst_4
    //   651: aconst_null
    //   652: invokestatic replace$default : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;
    //   655: ldc_w '@routeComponent'
    //   658: aload_3
    //   659: iconst_0
    //   660: iconst_4
    //   661: aconst_null
    //   662: invokestatic replace$default : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;
    //   665: ldc_w '@cdnWebjar/'
    //   668: aload_2
    //   669: invokevirtual isDev$javalin : ()Ljava/lang/Boolean;
    //   672: iconst_1
    //   673: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   676: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   679: ifeq -> 688
    //   682: ldc_w '/webjars/'
    //   685: goto -> 691
    //   688: ldc_w 'https://cdn.jsdelivr.net/webjars/org.webjars.npm/'
    //   691: iconst_0
    //   692: iconst_4
    //   693: aconst_null
    //   694: invokestatic replace$default : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;
    //   697: aload_2
    //   698: getfield enableCspAndNonces : Z
    //   701: aload_1
    //   702: invokestatic access$insertNoncesAndCspHeader : (Ljava/lang/String;ZLio/javalin/http/Context;)Ljava/lang/String;
    //   705: aload_1
    //   706: invokespecial postRenderHook : (Ljava/lang/String;Lio/javalin/http/Context;)Ljava/lang/String;
    //   709: invokeinterface html : (Ljava/lang/String;)Lio/javalin/http/Context;
    //   714: ldc_w 'Cache-Control'
    //   717: aload_2
    //   718: getfield cacheControl : Ljava/lang/String;
    //   721: invokeinterface header : (Ljava/lang/String;Ljava/lang/String;)Lio/javalin/http/Context;
    //   726: pop
    //   727: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #19	-> 6
    //   #20	-> 18
    //   #21	-> 44
    //   #22	-> 75
    //   #23	-> 111
    //   #24	-> 144
    //   #25	-> 162
    //   #61	-> 176
    //   #62	-> 193
    //   #25	-> 205
    //   #63	-> 255
    //   #63	-> 277
    //   #61	-> 280
    //   #65	-> 286
    //   #25	-> 288
    //   #26	-> 290
    //   #27	-> 317
    //   #28	-> 360
    //   #39	-> 361
    //   #31	-> 362
    //   #30	-> 365
    //   #29	-> 366
    //   #66	-> 420
    //   #29	-> 423
    //   #29	-> 432
    //   #29	-> 460
    //   #30	-> 463
    //   #31	-> 467
    //   #67	-> 498
    //   #68	-> 517
    //   #31	-> 555
    //   #69	-> 576
    //   #67	-> 581
    //   #31	-> 596
    //   #32	-> 599
    //   #33	-> 611
    //   #34	-> 623
    //   #35	-> 634
    //   #36	-> 655
    //   #37	-> 665
    //   #38	-> 697
    //   #39	-> 705
    //   #28	-> 709
    //   #40	-> 714
    //   #41	-> 727
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   205	47	12	$i$a$-takeWhile-VueHandler$handle$componentId$1	I
    //   202	50	11	it	C
    //   179	107	9	index$iv	I
    //   176	112	8	$i$f$takeWhile	I
    //   173	115	7	$this$takeWhile$iv	Ljava/lang/String;
    //   423	9	13	$i$a$-find-VueHandler$handle$1	I
    //   420	12	12	it	Ljava/nio/file/Path;
    //   555	5	16	$i$a$-filterNot-VueHandler$handle$2	I
    //   552	8	15	it	Ljava/nio/file/Path;
    //   545	28	14	element$iv$iv	Ljava/lang/Object;
    //   517	61	12	$i$f$filterNotTo	I
    //   514	64	10	$this$filterNotTo$iv$iv	Ljava/lang/Iterable;
    //   514	64	11	destination$iv$iv	Ljava/util/Collection;
    //   498	84	9	$i$f$filterNot	I
    //   495	87	8	$this$filterNot$iv	Ljava/lang/Iterable;
    //   18	710	2	c	Lio/javalin/vue/JavalinVueConfig;
    //   111	617	3	routeComponent	Ljava/lang/String;
    //   144	584	4	allFiles	Ljava/util/Set;
    //   162	566	5	resolver$delegate	Lkotlin/Lazy;
    //   290	438	6	componentId	Ljava/lang/String;
    //   317	411	7	dependencies	Ljava/lang/String;
    //   0	728	0	this	Lio/javalin/vue/VueHandler;
    //   0	728	1	ctx	Lio/javalin/http/Context;
  }
  
  private static final VueDependencyResolver handle$lambda-0(Lazy $resolver$delegate) {
    Lazy lazy = $resolver$delegate;
    return (VueDependencyResolver)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Lio/javalin/vue/VueDependencyResolver;", "invoke"})
  static final class VueHandler$handle$resolver$2 extends Lambda implements Function0<VueDependencyResolver> {
    VueHandler$handle$resolver$2(JavalinVueConfig $c, Set<Path> $allFiles) {
      super(0);
    }
    
    @NotNull
    public final VueDependencyResolver invoke() {
      return Intrinsics.areEqual(this.$c.isDev$javalin(), Boolean.valueOf(true)) ? new VueDependencyResolver(this.$allFiles, this.$c.vueAppName) : this.$c.getPathMaster$javalin().getCachedDependencyResolver$javalin();
    }
  }
  
  private final String preRenderHook(String $this$preRenderHook, Context ctx) {
    return preRender($this$preRenderHook, ctx);
  }
  
  private final String postRenderHook(String $this$postRenderHook, Context ctx) {
    return postRender($this$postRenderHook, ctx);
  }
}
