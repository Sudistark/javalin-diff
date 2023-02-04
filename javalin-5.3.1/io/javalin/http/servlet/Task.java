package io.javalin.http.servlet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000(\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\000\n\002\030\002\n\002\020\002\n\002\b\013\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\035\022\b\b\002\020\002\032\0020\003\022\f\020\004\032\b\022\004\022\0020\0060\005¢\006\002\020\007J\t\020\f\032\0020\003HÆ\003J\017\020\r\032\b\022\004\022\0020\0060\005HÆ\003J#\020\016\032\0020\0002\b\b\002\020\002\032\0020\0032\016\b\002\020\004\032\b\022\004\022\0020\0060\005HÆ\001J\023\020\017\032\0020\0032\b\020\020\032\004\030\0010\001HÖ\003J\t\020\021\032\0020\022HÖ\001J\t\020\023\032\0020\024HÖ\001R\027\020\004\032\b\022\004\022\0020\0060\005¢\006\b\n\000\032\004\b\b\020\tR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\n\020\013¨\006\025"}, d2 = {"Lio/javalin/http/servlet/Task;", "", "skipIfExceptionOccurred", "", "handler", "Lio/javalin/http/servlet/TaskHandler;", "", "(ZLio/javalin/http/servlet/TaskHandler;)V", "getHandler", "()Lio/javalin/http/servlet/TaskHandler;", "getSkipIfExceptionOccurred", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "javalin"})
public final class Task {
  private final boolean skipIfExceptionOccurred;
  
  @NotNull
  private final TaskHandler<Unit> handler;
  
  public Task(boolean skipIfExceptionOccurred, @NotNull TaskHandler<Unit> handler) {
    this.skipIfExceptionOccurred = skipIfExceptionOccurred;
    this.handler = handler;
  }
  
  public final boolean getSkipIfExceptionOccurred() {
    return this.skipIfExceptionOccurred;
  }
  
  @NotNull
  public final TaskHandler<Unit> getHandler() {
    return this.handler;
  }
  
  public final boolean component1() {
    return this.skipIfExceptionOccurred;
  }
  
  @NotNull
  public final TaskHandler<Unit> component2() {
    return this.handler;
  }
  
  @NotNull
  public final Task copy(boolean skipIfExceptionOccurred, @NotNull TaskHandler<Unit> handler) {
    Intrinsics.checkNotNullParameter(handler, "handler");
    return new Task(skipIfExceptionOccurred, handler);
  }
  
  @NotNull
  public String toString() {
    return "Task(skipIfExceptionOccurred=" + this.skipIfExceptionOccurred + ", handler=" + this.handler + ")";
  }
  
  public int hashCode() {
    if (this.skipIfExceptionOccurred);
    result = 1;
    return result * 31 + this.handler.hashCode();
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof Task))
      return false; 
    Task task = (Task)other;
    return (this.skipIfExceptionOccurred != task.skipIfExceptionOccurred) ? false : (!!Intrinsics.areEqual(this.handler, task.handler));
  }
}
