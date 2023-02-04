package io.javalin.event;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000D\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020#\n\002\030\002\n\002\030\002\n\002\b\005\n\002\020$\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\006\030\0002\0020\001B\005¢\006\002\020\002J\025\020\026\032\004\030\0010\0272\006\020\030\032\0020\r¢\006\002\020\031J\032\020\032\032\016\022\n\022\b\022\004\022\0020\0060\0050\0042\006\020\033\032\0020\006J\032\020\034\032\016\022\n\022\b\022\004\022\0020\0240\0050\0042\006\020\033\032\0020\024R&\020\003\032\016\022\n\022\b\022\004\022\0020\0060\0050\004X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR-\020\013\032\036\022\004\022\0020\r\022\024\022\022\022\004\022\0020\0170\016j\b\022\004\022\0020\017`\0200\f¢\006\b\n\000\032\004\b\021\020\022R\035\020\023\032\016\022\n\022\b\022\004\022\0020\0240\0050\004¢\006\b\n\000\032\004\b\025\020\b¨\006\035"}, d2 = {"Lio/javalin/event/EventManager;", "", "()V", "handlerAddedHandlers", "", "Ljava/util/function/Consumer;", "Lio/javalin/event/HandlerMetaInfo;", "getHandlerAddedHandlers", "()Ljava/util/Set;", "setHandlerAddedHandlers", "(Ljava/util/Set;)V", "lifecycleHandlers", "", "Lio/javalin/event/JavalinEvent;", "Ljava/util/HashSet;", "Lio/javalin/event/EventHandler;", "Lkotlin/collections/HashSet;", "getLifecycleHandlers", "()Ljava/util/Map;", "wsHandlerAddedHandlers", "Lio/javalin/event/WsHandlerMetaInfo;", "getWsHandlerAddedHandlers", "fireEvent", "", "javalinEvent", "(Lio/javalin/event/JavalinEvent;)Lkotlin/Unit;", "fireHandlerAddedEvent", "metaInfo", "fireWsHandlerAddedEvent", "javalin"})
public final class EventManager {
  @NotNull
  private final Map<JavalinEvent, HashSet<EventHandler>> lifecycleHandlers;
  
  @NotNull
  private Set<Consumer<HandlerMetaInfo>> handlerAddedHandlers;
  
  @NotNull
  private final Set<Consumer<WsHandlerMetaInfo>> wsHandlerAddedHandlers;
  
  public EventManager() {
    JavalinEvent[] arrayOfJavalinEvent1 = JavalinEvent.values();
    EventManager eventManager = this;
    int $i$f$associateWith = 0;
    LinkedHashMap<Object, Object> result$iv = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(arrayOfJavalinEvent1.length), 16));
    JavalinEvent[] arrayOfJavalinEvent2 = arrayOfJavalinEvent1;
    int $i$f$associateWithTo = 0;
    byte b;
    int i;
    for (b = 0, i = arrayOfJavalinEvent2.length; b < i; ) {
      Object element$iv$iv = arrayOfJavalinEvent2[b];
      Object object1 = element$iv$iv, object2 = element$iv$iv;
      LinkedHashMap<Object, Object> linkedHashMap = result$iv;
      int $i$a$-associateWith-EventManager$lifecycleHandlers$1 = 0;
      HashSet hashSet = new HashSet();
      linkedHashMap.put(object2, hashSet);
      b++;
    } 
    eventManager.lifecycleHandlers = (Map)result$iv;
    this.handlerAddedHandlers = new LinkedHashSet<>();
    this.wsHandlerAddedHandlers = new LinkedHashSet<>();
  }
  
  @NotNull
  public final Map<JavalinEvent, HashSet<EventHandler>> getLifecycleHandlers() {
    return this.lifecycleHandlers;
  }
  
  @NotNull
  public final Set<Consumer<HandlerMetaInfo>> getHandlerAddedHandlers() {
    return this.handlerAddedHandlers;
  }
  
  public final void setHandlerAddedHandlers(@NotNull Set<Consumer<HandlerMetaInfo>> <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    this.handlerAddedHandlers = <set-?>;
  }
  
  @NotNull
  public final Set<Consumer<WsHandlerMetaInfo>> getWsHandlerAddedHandlers() {
    return this.wsHandlerAddedHandlers;
  }
  
  @Nullable
  public final Unit fireEvent(@NotNull JavalinEvent javalinEvent) {
    Intrinsics.checkNotNullParameter(javalinEvent, "javalinEvent");
    Iterable $this$forEach$iv = this.lifecycleHandlers.get(javalinEvent);
    int $i$f$forEach = 0;
    for (Object element$iv : $this$forEach$iv) {
      EventHandler it = (EventHandler)element$iv;
      int $i$a$-forEach-EventManager$fireEvent$1 = 0;
      it.handleEvent();
    } 
    (HashSet)this.lifecycleHandlers.get(javalinEvent);
    return ((HashSet)this.lifecycleHandlers.get(javalinEvent) != null) ? Unit.INSTANCE : null;
  }
  
  @NotNull
  public final Set<Consumer<HandlerMetaInfo>> fireHandlerAddedEvent(@NotNull HandlerMetaInfo metaInfo) {
    Intrinsics.checkNotNullParameter(metaInfo, "metaInfo");
    Iterable<Consumer<HandlerMetaInfo>> $this$onEach$iv = this.handlerAddedHandlers;
    int $i$f$onEach = 0;
    Iterable<Consumer<HandlerMetaInfo>> iterable1 = $this$onEach$iv, $this$onEach_u24lambda_u2d16$iv = iterable1;
    int $i$a$-apply-CollectionsKt___CollectionsKt$onEach$1$iv = 0;
    for (Object<HandlerMetaInfo> element$iv : $this$onEach_u24lambda_u2d16$iv) {
      Consumer<HandlerMetaInfo> it = (Consumer)element$iv;
      int $i$a$-onEach-EventManager$fireHandlerAddedEvent$1 = 0;
      it.accept(metaInfo);
    } 
    return (Set<Consumer<HandlerMetaInfo>>)iterable1;
  }
  
  @NotNull
  public final Set<Consumer<WsHandlerMetaInfo>> fireWsHandlerAddedEvent(@NotNull WsHandlerMetaInfo metaInfo) {
    Intrinsics.checkNotNullParameter(metaInfo, "metaInfo");
    Iterable<Consumer<WsHandlerMetaInfo>> $this$onEach$iv = this.wsHandlerAddedHandlers;
    int $i$f$onEach = 0;
    Iterable<Consumer<WsHandlerMetaInfo>> iterable1 = $this$onEach$iv, $this$onEach_u24lambda_u2d16$iv = iterable1;
    int $i$a$-apply-CollectionsKt___CollectionsKt$onEach$1$iv = 0;
    for (Object<WsHandlerMetaInfo> element$iv : $this$onEach_u24lambda_u2d16$iv) {
      Consumer<WsHandlerMetaInfo> it = (Consumer)element$iv;
      int $i$a$-onEach-EventManager$fireWsHandlerAddedEvent$1 = 0;
      it.accept(metaInfo);
    } 
    return (Set<Consumer<WsHandlerMetaInfo>>)iterable1;
  }
}
