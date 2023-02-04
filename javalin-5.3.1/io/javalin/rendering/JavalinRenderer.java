package io.javalin.rendering;

import io.javalin.http.Context;
import io.javalin.util.JavalinLogger;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000@\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\030\002\n\002\020$\n\002\020\016\n\000\n\002\020%\n\002\030\002\n\002\b\004\n\002\020\013\n\000\n\002\020\021\n\002\b\002\n\002\020\002\n\002\b\n\bÆ\002\030\0002\0020\001:\001\035B\007\b\002¢\006\002\020\002J!\020\016\032\0020\0172\022\020\020\032\n\022\006\b\001\022\0020\0070\021\"\0020\007H\007¢\006\002\020\022J\r\020\023\032\0020\024H\000¢\006\002\b\025J)\020\026\032\0020\0242\006\020\027\032\0020\n2\022\020\020\032\n\022\006\b\001\022\0020\0070\021\"\0020\007H\007¢\006\002\020\030J.\020\031\032\0020\0072\006\020\032\032\0020\0072\024\020\033\032\020\022\004\022\0020\007\022\006\022\004\030\0010\0010\0062\006\020\034\032\0020\005H\007R,\020\003\032\034\022\004\022\0020\005\022\022\022\020\022\004\022\0020\007\022\006\022\004\030\0010\0010\0060\0048\006@\006X\016¢\006\002\n\000R\032\020\b\032\016\022\004\022\0020\007\022\004\022\0020\n0\tX\004¢\006\002\n\000R\030\020\013\032\0020\007*\0020\0078BX\004¢\006\006\032\004\b\f\020\r¨\006\036"}, d2 = {"Lio/javalin/rendering/JavalinRenderer;", "", "()V", "baseModelFunction", "Lkotlin/Function1;", "Lio/javalin/http/Context;", "", "", "extensions", "", "Lio/javalin/rendering/FileRenderer;", "extension", "getExtension", "(Ljava/lang/String;)Ljava/lang/String;", "hasRenderer", "", "ext", "", "([Ljava/lang/String;)Z", "loadFileRenderers", "", "loadFileRenderers$javalin", "register", "fileRenderer", "(Lio/javalin/rendering/FileRenderer;[Ljava/lang/String;)V", "renderBasedOnExtension", "filePath", "model", "ctx", "FileRendererLoader", "javalin"})
public final class JavalinRenderer {
  @NotNull
  public static final JavalinRenderer INSTANCE = new JavalinRenderer();
  
  @NotNull
  private static final Map<String, FileRenderer> extensions = new LinkedHashMap<>();
  
  @JvmField
  @NotNull
  public static Function1<? super Context, ? extends Map<String, ? extends Object>> baseModelFunction = JavalinRenderer$baseModelFunction$1.INSTANCE;
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\026\n\000\n\002\020$\n\002\020\016\n\002\020\000\n\000\n\002\030\002\n\000\020\000\032\016\022\004\022\0020\002\022\004\022\0020\0030\0012\006\020\004\032\0020\005H\n¢\006\002\b\006"}, d2 = {"<anonymous>", "", "", "", "it", "Lio/javalin/http/Context;", "invoke"})
  static final class JavalinRenderer$baseModelFunction$1 extends Lambda implements Function1<Context, Map<String, ? extends Object>> {
    public static final JavalinRenderer$baseModelFunction$1 INSTANCE = new JavalinRenderer$baseModelFunction$1();
    
    JavalinRenderer$baseModelFunction$1() {
      super(1);
    }
    
    @NotNull
    public final Map<String, Object> invoke(@NotNull Context it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return MapsKt.emptyMap();
    }
  }
  
  @JvmStatic
  @NotNull
  public static final String renderBasedOnExtension(@NotNull String filePath, @NotNull Map model, @NotNull Context ctx) {
    FileRenderer renderer;
    Intrinsics.checkNotNullParameter(filePath, "filePath");
    Intrinsics.checkNotNullParameter(model, "model");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    if ((FileRenderer)extensions.get(INSTANCE.getExtension(filePath)) == null) {
      (FileRenderer)extensions.get(INSTANCE.getExtension(filePath));
      throw new IllegalArgumentException("No Renderer registered for extension '" + INSTANCE.getExtension(filePath) + "'.");
    } 
    return renderer.render(filePath, MapsKt.plus((Map)baseModelFunction.invoke(ctx), model), ctx);
  }
  
  @JvmStatic
  public static final void register(@NotNull FileRenderer fileRenderer, @NotNull String... ext) {
    Intrinsics.checkNotNullParameter(fileRenderer, "fileRenderer");
    Intrinsics.checkNotNullParameter(ext, "ext");
    String[] arrayOfString = ext;
    int $i$f$forEach = 0;
    byte b = 0;
    int i = arrayOfString.length;
    if (b < i) {
      Object element$iv = arrayOfString[b], object1 = element$iv;
      int $i$a$-forEach-JavalinRenderer$register$1 = 0;
      if (extensions.get(object1) != null) {
        Intrinsics.checkNotNull(extensions.get(object1));
        JavalinLogger.info$default("'" + object1 + "' is already registered to " + extensions.get(object1).getClass() + ". Overriding.", null, 2, null);
      } 
    } 
  }
  
  @JvmStatic
  public static final boolean hasRenderer(@NotNull String... ext) {
    // Byte code:
    //   0: aload_0
    //   1: ldc 'ext'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: astore_1
    //   8: iconst_0
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_3
    //   12: aload_1
    //   13: arraylength
    //   14: istore #4
    //   16: iload_3
    //   17: iload #4
    //   19: if_icmpge -> 62
    //   22: aload_1
    //   23: iload_3
    //   24: aaload
    //   25: astore #5
    //   27: aload #5
    //   29: astore #6
    //   31: iconst_0
    //   32: istore #7
    //   34: getstatic io/javalin/rendering/JavalinRenderer.extensions : Ljava/util/Map;
    //   37: invokeinterface keySet : ()Ljava/util/Set;
    //   42: aload #6
    //   44: invokeinterface contains : (Ljava/lang/Object;)Z
    //   49: ifeq -> 56
    //   52: iconst_1
    //   53: goto -> 63
    //   56: iinc #3, 1
    //   59: goto -> 16
    //   62: iconst_0
    //   63: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #44	-> 6
    //   #57	-> 10
    //   #44	-> 34
    //   #58	-> 62
    //   #44	-> 63
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   34	15	7	$i$a$-any-JavalinRenderer$hasRenderer$1	I
    //   31	18	6	it	Ljava/lang/String;
    //   27	35	5	element$iv	Ljava/lang/Object;
    //   10	53	2	$i$f$any	I
    //   8	55	1	$this$any$iv	[Ljava/lang/Object;
    //   0	64	0	ext	[Ljava/lang/String;
  }
  
  private final String getExtension(String $this$extension) {
    return StringsKt.replaceBeforeLast$default($this$extension, ".", "", null, 4, null);
  }
  
  public final void loadFileRenderers$javalin() {
    Intrinsics.checkNotNullExpressionValue(ServiceLoader.load(FileRendererLoader.class), "load(FileRendererLoader::class.java)");
    Iterable<FileRendererLoader> $this$forEach$iv = ServiceLoader.load(FileRendererLoader.class);
    int $i$f$forEach = 0;
    for (FileRendererLoader element$iv : $this$forEach$iv) {
      FileRendererLoader it = element$iv;
      int $i$a$-forEach-JavalinRenderer$loadFileRenderers$1 = 0;
      it.load();
    } 
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\020\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\bf\030\0002\0020\001J\b\020\002\032\0020\003H&ø\001\000\002\006\n\004\b!0\001¨\006\004À\006\001"}, d2 = {"Lio/javalin/rendering/JavalinRenderer$FileRendererLoader;", "", "load", "", "javalin"})
  public static interface FileRendererLoader {
    void load();
  }
}
