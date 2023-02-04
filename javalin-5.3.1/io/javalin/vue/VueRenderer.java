package io.javalin.vue;

import io.javalin.http.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\002\b\026\030\0002\0020\001B\005¢\006\002\020\002J\030\020\003\032\0020\0042\006\020\005\032\0020\0042\006\020\006\032\0020\007H\026J\030\020\b\032\0020\0042\006\020\005\032\0020\0042\006\020\006\032\0020\007H\026¨\006\t"}, d2 = {"Lio/javalin/vue/VueRenderer;", "", "()V", "postRender", "", "layout", "ctx", "Lio/javalin/http/Context;", "preRender", "javalin"})
public class VueRenderer {
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
}
