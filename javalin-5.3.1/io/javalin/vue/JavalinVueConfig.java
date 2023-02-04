package io.javalin.vue;

import io.javalin.http.Context;
import io.javalin.http.servlet.JavalinServletContextKt;
import io.javalin.http.staticfiles.Location;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000H\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\020\013\n\002\b\b\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\007\n\002\020\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\005¢\006\002\020\002J\016\020\031\032\0020 2\006\020!\032\0020\030J(\020\031\032\0020 2\006\020!\032\0020\0042\b\b\002\020\"\032\0020#2\f\b\002\020$\032\006\022\002\b\0030%H\007R\022\020\003\032\0020\0048\006@\006X\016¢\006\002\n\000R\022\020\005\032\0020\0068\006@\006X\016¢\006\002\n\000R,\020\b\032\004\030\0010\0062\b\020\007\032\004\030\0010\0068@@@X\016¢\006\020\n\002\020\r\032\004\b\t\020\n\"\004\b\013\020\fR\036\020\016\032\016\022\004\022\0020\020\022\004\022\0020\0060\0178\006@\006X\016¢\006\002\n\000R\022\020\021\032\0020\0068\006@\006X\016¢\006\002\n\000R&\020\023\032\0020\0222\006\020\007\032\0020\0228@@@X\016¢\006\016\n\000\032\004\b\024\020\025\"\004\b\026\020\027R*\020\031\032\004\030\0010\0302\b\020\007\032\004\030\0010\0308@@@X\016¢\006\016\n\000\032\004\b\032\020\033\"\004\b\034\020\035R\036\020\036\032\016\022\004\022\0020\020\022\004\022\0020\0010\0178\006@\006X\016¢\006\002\n\000R\024\020\037\032\004\030\0010\0048\006@\006X\016¢\006\002\n\000¨\006&"}, d2 = {"Lio/javalin/vue/JavalinVueConfig;", "", "()V", "cacheControl", "", "enableCspAndNonces", "", "<set-?>", "isDev", "isDev$javalin", "()Ljava/lang/Boolean;", "setDev$javalin", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isDevFunction", "Lkotlin/Function1;", "Lio/javalin/http/Context;", "optimizeDependencies", "Lio/javalin/vue/VuePathMaster;", "pathMaster", "getPathMaster$javalin", "()Lio/javalin/vue/VuePathMaster;", "setPathMaster$javalin", "(Lio/javalin/vue/VuePathMaster;)V", "Ljava/nio/file/Path;", "rootDirectory", "getRootDirectory$javalin", "()Ljava/nio/file/Path;", "setRootDirectory$javalin", "(Ljava/nio/file/Path;)V", "stateFunction", "vueAppName", "", "path", "location", "Lio/javalin/http/staticfiles/Location;", "resourcesJarClass", "Ljava/lang/Class;", "javalin"})
public final class JavalinVueConfig {
  @NotNull
  private VuePathMaster pathMaster = new VuePathMaster(this);
  
  @Nullable
  private Path rootDirectory;
  
  @JvmField
  @Nullable
  public String vueAppName;
  
  @Nullable
  private Boolean isDev;
  
  public final void rootDirectory(@NotNull Path path) {
    Intrinsics.checkNotNullParameter(path, "path");
    this.rootDirectory = path;
  }
  
  @JvmOverloads
  public final void rootDirectory(@NotNull String path, @NotNull Location location, @NotNull Class<?> resourcesJarClass) {
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullParameter(location, "location");
    Intrinsics.checkNotNullParameter(resourcesJarClass, "resourcesJarClass");
    this.rootDirectory = (location == Location.CLASSPATH) ? this.pathMaster.classpathPath(path, resourcesJarClass) : Paths.get(path, new String[0]);
  }
  
  @JvmField
  @NotNull
  public Function1<? super Context, Boolean> isDevFunction = JavalinVueConfig$isDevFunction$1.INSTANCE;
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\020\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\002\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\004\b\004\020\005"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/http/Context;", "invoke", "(Lio/javalin/http/Context;)Ljava/lang/Boolean;"})
  static final class JavalinVueConfig$isDevFunction$1 extends Lambda implements Function1<Context, Boolean> {
    public static final JavalinVueConfig$isDevFunction$1 INSTANCE = new JavalinVueConfig$isDevFunction$1();
    
    JavalinVueConfig$isDevFunction$1() {
      super(1);
    }
    
    @NotNull
    public final Boolean invoke(@NotNull Context it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return Boolean.valueOf(JavalinServletContextKt.isLocalhost(it));
    }
  }
  
  @JvmField
  public boolean optimizeDependencies = true;
  
  @JvmField
  @NotNull
  public Function1<? super Context, ? extends Object> stateFunction = JavalinVueConfig$stateFunction$1.INSTANCE;
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\022\n\000\n\002\020$\n\002\020\016\n\000\n\002\030\002\n\000\020\000\032\016\022\004\022\0020\002\022\004\022\0020\0020\0012\006\020\003\032\0020\004H\n¢\006\002\b\005"}, d2 = {"<anonymous>", "", "", "it", "Lio/javalin/http/Context;", "invoke"})
  static final class JavalinVueConfig$stateFunction$1 extends Lambda implements Function1<Context, Map<String, ? extends String>> {
    public static final JavalinVueConfig$stateFunction$1 INSTANCE = new JavalinVueConfig$stateFunction$1();
    
    JavalinVueConfig$stateFunction$1() {
      super(1);
    }
    
    @NotNull
    public final Map<String, String> invoke(@NotNull Context it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return MapsKt.emptyMap();
    }
  }
  
  @JvmField
  @NotNull
  public String cacheControl = "no-cache, no-store, must-revalidate";
  
  @JvmField
  public boolean enableCspAndNonces;
  
  @JvmOverloads
  public final void rootDirectory(@NotNull String path, @NotNull Location location) {
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullParameter(location, "location");
    rootDirectory$default(this, path, location, null, 4, null);
  }
  
  @JvmOverloads
  public final void rootDirectory(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    rootDirectory$default(this, path, null, null, 6, null);
  }
}
