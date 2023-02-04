package io.javalin.plugin.bundled;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020!\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020 \n\000\030\0002\0020\001B\005¢\006\002\020\002J\024\020\007\032\0020\b2\f\020\t\032\b\022\004\022\0020\0060\005J\022\020\003\032\016\022\n\022\b\022\004\022\0020\0060\0050\nR\032\020\003\032\016\022\n\022\b\022\004\022\0020\0060\0050\004X\004¢\006\002\n\000¨\006\013"}, d2 = {"Lio/javalin/plugin/bundled/CorsContainer;", "", "()V", "corsConfigs", "", "Ljava/util/function/Consumer;", "Lio/javalin/plugin/bundled/CorsPluginConfig;", "add", "", "consumer", "", "javalin"})
public final class CorsContainer {
  @NotNull
  private final List<Consumer<CorsPluginConfig>> corsConfigs = new ArrayList<>();
  
  @NotNull
  public final List<Consumer<CorsPluginConfig>> corsConfigs() {
    Intrinsics.checkNotNullExpressionValue(Collections.unmodifiableList(this.corsConfigs), "unmodifiableList(corsConfigs)");
    return Collections.unmodifiableList(this.corsConfigs);
  }
  
  public final void add(@NotNull Consumer<CorsPluginConfig> consumer) {
    Intrinsics.checkNotNullParameter(consumer, "consumer");
    this.corsConfigs.add(consumer);
  }
}
