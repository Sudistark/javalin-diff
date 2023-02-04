package io.javalin.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\b\026\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\017\032\0020\0202\006\020\021\032\0020\022H\026R\026\020\005\032\004\030\0010\006X\004¢\006\b\n\000\032\004\b\007\020\bR\024\020\002\032\0020\003X\004¢\006\b\n\000\032\004\b\t\020\nR\024\020\013\032\0020\fX\004¢\006\b\n\000\032\004\b\r\020\016¨\006\023"}, d2 = {"Lio/javalin/util/NamedThreadFactory;", "Ljava/util/concurrent/ThreadFactory;", "prefix", "", "(Ljava/lang/String;)V", "group", "Ljava/lang/ThreadGroup;", "getGroup", "()Ljava/lang/ThreadGroup;", "getPrefix", "()Ljava/lang/String;", "threadCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getThreadCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "newThread", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "javalin"})
public class NamedThreadFactory implements ThreadFactory {
  @NotNull
  private final String prefix;
  
  @Nullable
  private final ThreadGroup group;
  
  @NotNull
  private final AtomicInteger threadCount;
  
  public NamedThreadFactory(@NotNull String prefix) {
    this.prefix = prefix;
    this.group = Thread.currentThread().getThreadGroup();
    this.threadCount = new AtomicInteger(0);
  }
  
  @NotNull
  protected final String getPrefix() {
    return this.prefix;
  }
  
  @Nullable
  protected final ThreadGroup getGroup() {
    return this.group;
  }
  
  @NotNull
  protected final AtomicInteger getThreadCount() {
    return this.threadCount;
  }
  
  @NotNull
  public Thread newThread(@NotNull Runnable runnable) {
    Intrinsics.checkNotNullParameter(runnable, "runnable");
    return new Thread(this.group, runnable, this.prefix + "-" + this.prefix, 0L);
  }
}
