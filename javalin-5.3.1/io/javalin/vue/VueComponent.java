package io.javalin.vue;

import io.javalin.http.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\000\n\000\n\002\030\002\n\002\b\b\n\002\030\002\n\002\b\002\030\0002\0020\001B%\b\007\022\006\020\002\032\0020\003\022\n\b\002\020\004\032\004\030\0010\005\022\b\b\002\020\006\032\0020\007¢\006\002\020\bJ\030\020\r\032\0020\0032\006\020\016\032\0020\0032\006\020\017\032\0020\020H\026J\030\020\021\032\0020\0032\006\020\016\032\0020\0032\006\020\017\032\0020\020H\026J\022\020\004\032\004\030\0010\0052\006\020\017\032\0020\020H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR\016\020\006\032\0020\007X\004¢\006\002\n\000R\023\020\004\032\004\030\0010\005¢\006\b\n\000\032\004\b\013\020\f¨\006\022"}, d2 = {"Lio/javalin/vue/VueComponent;", "Lio/javalin/vue/VueHandler;", "component", "", "state", "", "renderer", "Lio/javalin/vue/VueRenderer;", "(Ljava/lang/String;Ljava/lang/Object;Lio/javalin/vue/VueRenderer;)V", "getComponent", "()Ljava/lang/String;", "getState", "()Ljava/lang/Object;", "postRender", "layout", "ctx", "Lio/javalin/http/Context;", "preRender", "javalin"})
public final class VueComponent extends VueHandler {
  @NotNull
  private final String component;
  
  @Nullable
  private final Object state;
  
  @NotNull
  private final VueRenderer renderer;
  
  @NotNull
  public final String getComponent() {
    return this.component;
  }
  
  @Nullable
  public final Object getState() {
    return this.state;
  }
  
  @JvmOverloads
  public VueComponent(@NotNull String component, @Nullable Object state, @NotNull VueRenderer renderer) {
    super(component);
    this.component = component;
    this.state = state;
    this.renderer = renderer;
  }
  
  @Nullable
  public Object state(@NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    return this.state;
  }
  
  @NotNull
  public String preRender(@NotNull String layout, @NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(layout, "layout");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    return this.renderer.preRender(layout, ctx);
  }
  
  @NotNull
  public String postRender(@NotNull String layout, @NotNull Context ctx) {
    Intrinsics.checkNotNullParameter(layout, "layout");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    return this.renderer.postRender(layout, ctx);
  }
  
  @JvmOverloads
  public VueComponent(@NotNull String component, @Nullable Object state) {
    this(component, state, null, 4, null);
  }
  
  @JvmOverloads
  public VueComponent(@NotNull String component) {
    this(component, null, null, 6, null);
  }
}
