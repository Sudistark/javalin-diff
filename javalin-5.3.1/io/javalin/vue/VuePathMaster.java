package io.javalin.vue;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000D\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\"\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\b\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\032\020\025\032\0020\r2\006\020\026\032\0020\0272\n\020\030\032\006\022\002\b\0030\031J\016\020\032\032\0020\r2\006\020\033\032\0020\034J\024\020\035\032\0020\0242\n\020\030\032\006\022\002\b\0030\031H\002J\f\020\036\032\b\022\004\022\0020\r0\fR\033\020\005\032\0020\0068@X\002¢\006\f\n\004\b\t\020\n\032\004\b\007\020\bR!\020\013\032\b\022\004\022\0020\r0\f8@X\002¢\006\f\n\004\b\020\020\n\032\004\b\016\020\017R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\021\020\022R\016\020\023\032\0020\024X.¢\006\002\n\000¨\006\037"}, d2 = {"Lio/javalin/vue/VuePathMaster;", "", "cfg", "Lio/javalin/vue/JavalinVueConfig;", "(Lio/javalin/vue/JavalinVueConfig;)V", "cachedDependencyResolver", "Lio/javalin/vue/VueDependencyResolver;", "getCachedDependencyResolver$javalin", "()Lio/javalin/vue/VueDependencyResolver;", "cachedDependencyResolver$delegate", "Lkotlin/Lazy;", "cachedPaths", "", "Ljava/nio/file/Path;", "getCachedPaths$javalin", "()Ljava/util/Set;", "cachedPaths$delegate", "getCfg", "()Lio/javalin/vue/JavalinVueConfig;", "fileSystem", "Ljava/nio/file/FileSystem;", "classpathPath", "path", "", "jarClass", "Ljava/lang/Class;", "defaultLocation", "isDev", "", "getFileSystem", "walkPaths", "javalin"})
public final class VuePathMaster {
  @NotNull
  private final JavalinVueConfig cfg;
  
  @NotNull
  private final Lazy cachedPaths$delegate;
  
  @NotNull
  private final Lazy cachedDependencyResolver$delegate;
  
  private FileSystem fileSystem;
  
  public VuePathMaster(@NotNull JavalinVueConfig cfg) {
    this.cfg = cfg;
    this.cachedPaths$delegate = LazyKt.lazy(new VuePathMaster$cachedPaths$2());
    this.cachedDependencyResolver$delegate = LazyKt.lazy(new VuePathMaster$cachedDependencyResolver$2());
  }
  
  @NotNull
  public final JavalinVueConfig getCfg() {
    return this.cfg;
  }
  
  @NotNull
  public final Set<Path> getCachedPaths$javalin() {
    Lazy lazy = this.cachedPaths$delegate;
    return (Set<Path>)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\f\n\000\n\002\020\"\n\002\030\002\n\000\020\000\032\b\022\004\022\0020\0020\001H\n¢\006\002\b\003"}, d2 = {"<anonymous>", "", "Ljava/nio/file/Path;", "invoke"})
  static final class VuePathMaster$cachedPaths$2 extends Lambda implements Function0<Set<? extends Path>> {
    VuePathMaster$cachedPaths$2() {
      super(0);
    }
    
    @NotNull
    public final Set<Path> invoke() {
      return VuePathMaster.this.walkPaths();
    }
  }
  
  @NotNull
  public final VueDependencyResolver getCachedDependencyResolver$javalin() {
    Lazy lazy = this.cachedDependencyResolver$delegate;
    return (VueDependencyResolver)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Lio/javalin/vue/VueDependencyResolver;", "invoke"})
  static final class VuePathMaster$cachedDependencyResolver$2 extends Lambda implements Function0<VueDependencyResolver> {
    VuePathMaster$cachedDependencyResolver$2() {
      super(0);
    }
    
    @NotNull
    public final VueDependencyResolver invoke() {
      return new VueDependencyResolver(VuePathMaster.this.getCachedPaths$javalin(), (VuePathMaster.this.getCfg()).vueAppName);
    }
  }
  
  @NotNull
  public final Set<Path> walkPaths() {
    Stream<Path> stream = Files.walk(this.cfg.getRootDirectory$javalin(), 20, new java.nio.file.FileVisitOption[0]);
    Throwable throwable = null;
    try {
      Stream<Path> it = stream;
      int $i$a$-use-VuePathMaster$walkPaths$1 = 0;
      Set<Path> set = it.collect((Collector)Collectors.toSet());
    } catch (Throwable throwable1) {
      throwable = throwable1 = null;
      throw throwable1;
    } finally {
      AutoCloseableKt.closeFinally(stream, throwable);
    } 
    Intrinsics.checkNotNullExpressionValue(set, "walk(cfg.rootDirectory, …ect(Collectors.toSet()) }");
    return set;
  }
  
  @NotNull
  public final Path classpathPath(@NotNull String path, @NotNull Class<?> jarClass) {
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullParameter(jarClass, "jarClass");
    Intrinsics.checkNotNull(jarClass.getResource(path));
    Intrinsics.checkNotNullExpressionValue(getFileSystem(jarClass).getPath(path, new String[0]), "getFileSystem(jarClass).getPath(path)");
    Intrinsics.checkNotNull(jarClass.getResource(path));
    Intrinsics.checkNotNullExpressionValue(Paths.get(jarClass.getResource(path).toURI()), "get(jarClass.getResource(path)!!.toURI())");
    return Intrinsics.areEqual(jarClass.getResource(path).toURI().getScheme(), "jar") ? getFileSystem(jarClass).getPath(path, new String[0]) : Paths.get(jarClass.getResource(path).toURI());
  }
  
  @NotNull
  public final Path defaultLocation(boolean isDev) {
    Intrinsics.checkNotNullExpressionValue(Paths.get("src/main/resources/vue", new String[0]), "get(\"src/main/resources/vue\")");
    return isDev ? Paths.get("src/main/resources/vue", new String[0]) : classpathPath("/vue", VuePathMaster.class);
  }
  
  private final FileSystem getFileSystem(Class jarClass) {
    if (this.fileSystem == null) {
      Intrinsics.checkNotNull(jarClass.getResource(""));
      Intrinsics.checkNotNullExpressionValue(FileSystems.newFileSystem(jarClass.getResource("").toURI(), MapsKt.emptyMap()), "newFileSystem(jarClass.g… emptyMap<String, Any>())");
      this.fileSystem = FileSystems.newFileSystem(jarClass.getResource("").toURI(), MapsKt.emptyMap());
    } 
    if (this.fileSystem == null)
      Intrinsics.throwUninitializedPropertyAccessException("fileSystem"); 
    return null;
  }
}
