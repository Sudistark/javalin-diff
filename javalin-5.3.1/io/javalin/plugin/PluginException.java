package io.javalin.plugin;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000 \n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\004\b&\030\0002\0060\001j\002`\002B\035\022\016\020\003\032\n\022\006\b\001\022\0020\0050\004\022\006\020\006\032\0020\007¢\006\002\020\bR\024\020\006\032\0020\007X\004¢\006\b\n\000\032\004\b\t\020\n¨\006\013"}, d2 = {"Lio/javalin/plugin/PluginException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "pluginClass", "Ljava/lang/Class;", "Lio/javalin/plugin/Plugin;", "message", "", "(Ljava/lang/Class;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "javalin"})
public abstract class PluginException extends RuntimeException {
  @NotNull
  private final String message;
  
  @NotNull
  public String getMessage() {
    return this.message;
  }
  
  public PluginException(@NotNull Class pluginClass, @NotNull String message) {
    super("Error in " + pluginClass.getCanonicalName() + ": " + message);
    this.message = message;
  }
}
