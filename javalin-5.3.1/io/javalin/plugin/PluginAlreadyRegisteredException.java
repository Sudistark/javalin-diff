package io.javalin.plugin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\006\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\025\022\016\020\002\032\n\022\006\b\001\022\0020\0040\003¢\006\002\020\005J\021\020\b\032\n\022\006\b\001\022\0020\0040\003HÆ\003J\033\020\t\032\0020\0002\020\b\002\020\002\032\n\022\006\b\001\022\0020\0040\003HÆ\001J\023\020\n\032\0020\0132\b\020\f\032\004\030\0010\rHÖ\003J\t\020\016\032\0020\017HÖ\001J\t\020\020\032\0020\021HÖ\001R\031\020\002\032\n\022\006\b\001\022\0020\0040\003¢\006\b\n\000\032\004\b\006\020\007¨\006\022"}, d2 = {"Lio/javalin/plugin/PluginAlreadyRegisteredException;", "Lio/javalin/plugin/PluginException;", "pluginClass", "Ljava/lang/Class;", "Lio/javalin/plugin/Plugin;", "(Ljava/lang/Class;)V", "getPluginClass", "()Ljava/lang/Class;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "javalin"})
public final class PluginAlreadyRegisteredException extends PluginException {
  @NotNull
  private final Class<? extends Plugin> pluginClass;
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof PluginAlreadyRegisteredException))
      return false; 
    PluginAlreadyRegisteredException pluginAlreadyRegisteredException = (PluginAlreadyRegisteredException)other;
    return !!Intrinsics.areEqual(this.pluginClass, pluginAlreadyRegisteredException.pluginClass);
  }
  
  public int hashCode() {
    return this.pluginClass.hashCode();
  }
  
  @NotNull
  public String toString() {
    return "PluginAlreadyRegisteredException(pluginClass=" + this.pluginClass + ")";
  }
  
  @NotNull
  public final PluginAlreadyRegisteredException copy(@NotNull Class<? extends Plugin> pluginClass) {
    Intrinsics.checkNotNullParameter(pluginClass, "pluginClass");
    return new PluginAlreadyRegisteredException(pluginClass);
  }
  
  @NotNull
  public final Class<? extends Plugin> component1() {
    return this.pluginClass;
  }
  
  @NotNull
  public final Class<? extends Plugin> getPluginClass() {
    return this.pluginClass;
  }
  
  public PluginAlreadyRegisteredException(@NotNull Class<? extends Plugin> pluginClass) {
    super(pluginClass, pluginClass.getCanonicalName() + " is already registered");
    this.pluginClass = pluginClass;
  }
}
