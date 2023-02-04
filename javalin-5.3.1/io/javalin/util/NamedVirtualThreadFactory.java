package io.javalin.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\026\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\026¨\006\t"}, d2 = {"Lio/javalin/util/NamedVirtualThreadFactory;", "Lio/javalin/util/NamedThreadFactory;", "prefix", "", "(Ljava/lang/String;)V", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "javalin"})
public class NamedVirtualThreadFactory extends NamedThreadFactory {
  public NamedVirtualThreadFactory(@NotNull String prefix) {
    super(prefix);
  }
  
  @NotNull
  public Thread newThread(@NotNull Runnable runnable) {
    Intrinsics.checkNotNullParameter(runnable, "runnable");
    return (new ReflectiveVirtualThreadBuilder()).name(getPrefix() + "-Virtual-" + getPrefix()).unstarted(runnable);
  }
}
