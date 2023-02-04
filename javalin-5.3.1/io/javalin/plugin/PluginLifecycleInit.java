package io.javalin.plugin;

import io.javalin.Javalin;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\026\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&ø\001\000\002\006\n\004\b!0\001¨\006\006À\006\001"}, d2 = {"Lio/javalin/plugin/PluginLifecycleInit;", "", "init", "", "app", "Lio/javalin/Javalin;", "javalin"})
public interface PluginLifecycleInit {
  void init(@NotNull Javalin paramJavalin);
}
