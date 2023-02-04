package io.javalin.plugin;

import io.javalin.Javalin;
import io.javalin.event.EventListener;
import io.javalin.event.HandlerMetaInfo;
import io.javalin.event.WsHandlerMetaInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000.\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020#\n\002\030\002\n\000\n\002\020%\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\003\030\0002\0020\001B\005¢\006\002\020\002J\016\020\t\032\0020\n2\006\020\013\032\0020\fJ\016\020\r\032\0020\n2\006\020\016\032\0020\005R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000R\"\020\006\032\026\022\f\022\n\022\006\b\001\022\0020\0050\b\022\004\022\0020\0050\007X\004¢\006\002\n\000¨\006\017"}, d2 = {"Lio/javalin/plugin/PluginManager;", "", "()V", "initializedPlugins", "", "Lio/javalin/plugin/Plugin;", "plugins", "", "Ljava/lang/Class;", "initializePlugins", "", "app", "Lio/javalin/Javalin;", "register", "plugin", "javalin"})
public final class PluginManager {
  @NotNull
  private final Map<Class<? extends Plugin>, Plugin> plugins = new LinkedHashMap<>();
  
  @NotNull
  private final Set<Plugin> initializedPlugins = new LinkedHashSet<>();
  
  public final void register(@NotNull Plugin plugin) {
    Intrinsics.checkNotNullParameter(plugin, "plugin");
    if (this.plugins.containsKey(plugin.getClass()))
      throw new PluginAlreadyRegisteredException(plugin.getClass()); 
    this.plugins.put(plugin.getClass(), plugin);
  }
  
  public final void initializePlugins(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    Ref.BooleanRef anyHandlerAdded = new Ref.BooleanRef();
    app.events(anyHandlerAdded::initializePlugins$lambda-2);
    Iterable<Plugin> $this$filterNot$iv = this.plugins.values();
    int $i$f$filterNot = 0;
    Iterable<Plugin> iterable1 = $this$filterNot$iv;
    Collection<Object> destination$iv$iv = new ArrayList();
    int $i$f$filterNotTo = 0;
    for (Plugin element$iv$iv : iterable1) {
      Plugin it = element$iv$iv;
      int $i$a$-filterNot-PluginManager$initializePlugins$pluginsToInitialize$1 = 0;
      if (!this.initializedPlugins.contains(it))
        destination$iv$iv.add(element$iv$iv); 
    } 
    List pluginsToInitialize = (List)destination$iv$iv;
    Iterable $this$forEach$iv = pluginsToInitialize;
    int $i$f$forEach = 0;
    Iterator iterator = $this$forEach$iv.iterator();
    if (iterator.hasNext()) {
      Object element$iv = iterator.next();
      Plugin it = (Plugin)element$iv;
      int $i$a$-forEach-PluginManager$initializePlugins$2 = 0;
      if (it instanceof PluginLifecycleInit) {
        ((PluginLifecycleInit)it).init(app);
        if (anyHandlerAdded.element)
          throw new PluginInitException(it.getClass()); 
      } 
    } 
    $this$forEach$iv = pluginsToInitialize;
    $i$f$forEach = 0;
    iterator = $this$forEach$iv.iterator();
    if (iterator.hasNext()) {
      Object element$iv = iterator.next();
      Plugin it = (Plugin)element$iv;
      int $i$a$-forEach-PluginManager$initializePlugins$3 = 0;
      it.apply(app);
      this.initializedPlugins.add(it);
    } 
  }
  
  private static final void initializePlugins$lambda-2$lambda-0(Ref.BooleanRef $anyHandlerAdded, HandlerMetaInfo it) {
    Intrinsics.checkNotNullParameter($anyHandlerAdded, "$anyHandlerAdded");
    $anyHandlerAdded.element = true;
  }
  
  private static final void initializePlugins$lambda-2(Ref.BooleanRef $anyHandlerAdded, EventListener event) {
    Intrinsics.checkNotNullParameter($anyHandlerAdded, "$anyHandlerAdded");
    event.handlerAdded($anyHandlerAdded::initializePlugins$lambda-2$lambda-0);
    event.wsHandlerAdded($anyHandlerAdded::initializePlugins$lambda-2$lambda-1);
  }
  
  private static final void initializePlugins$lambda-2$lambda-1(Ref.BooleanRef $anyHandlerAdded, WsHandlerMetaInfo it) {
    Intrinsics.checkNotNullParameter($anyHandlerAdded, "$anyHandlerAdded");
    $anyHandlerAdded.element = true;
  }
}
