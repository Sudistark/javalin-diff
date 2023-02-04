package io.javalin.validation;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000*\n\002\030\002\n\000\n\002\020\000\n\000\n\002\020\016\n\000\n\002\020$\n\002\b\017\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\b\b\030\000*\004\b\000\020\0012\0020\002B1\022\006\020\003\032\0020\004\022\026\b\002\020\005\032\020\022\004\022\0020\004\022\006\022\004\030\0010\0020\006\022\n\b\002\020\007\032\004\030\0010\002¢\006\002\020\bJ\t\020\021\032\0020\004HÆ\003J\027\020\022\032\020\022\004\022\0020\004\022\006\022\004\030\0010\0020\006HÆ\003J\013\020\023\032\004\030\0010\002HÆ\003J=\020\024\032\b\022\004\022\0028\0000\0002\b\b\002\020\003\032\0020\0042\026\b\002\020\005\032\020\022\004\022\0020\004\022\006\022\004\030\0010\0020\0062\n\b\002\020\007\032\004\030\0010\002HÆ\001J\023\020\025\032\0020\0262\b\020\027\032\004\030\0010\002HÖ\003J\t\020\030\032\0020\031HÖ\001J\t\020\032\032\0020\004HÖ\001R\037\020\005\032\020\022\004\022\0020\004\022\006\022\004\030\0010\0020\006¢\006\b\n\000\032\004\b\t\020\nR\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\013\020\fR\034\020\007\032\004\030\0010\002X\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020¨\006\033"}, d2 = {"Lio/javalin/validation/ValidationError;", "T", "", "message", "", "args", "", "value", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/Object;)V", "getArgs", "()Ljava/util/Map;", "getMessage", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "javalin"})
public final class ValidationError<T> {
  @NotNull
  private final String message;
  
  @NotNull
  private final Map<String, Object> args;
  
  @Nullable
  private Object value;
  
  public ValidationError(@NotNull String message, @NotNull Map<String, Object> args, @Nullable Object value) {
    this.message = message;
    this.args = args;
    this.value = value;
  }
  
  @NotNull
  public final String getMessage() {
    return this.message;
  }
  
  @NotNull
  public final Map<String, Object> getArgs() {
    return this.args;
  }
  
  @Nullable
  public final Object getValue() {
    return this.value;
  }
  
  public final void setValue(@Nullable Object <set-?>) {
    this.value = <set-?>;
  }
  
  @NotNull
  public final String component1() {
    return this.message;
  }
  
  @NotNull
  public final Map<String, Object> component2() {
    return this.args;
  }
  
  @Nullable
  public final Object component3() {
    return this.value;
  }
  
  @NotNull
  public final ValidationError<T> copy(@NotNull String message, @NotNull Map<String, ? extends Object> args, @Nullable Object value) {
    Intrinsics.checkNotNullParameter(message, "message");
    Intrinsics.checkNotNullParameter(args, "args");
    return new ValidationError(message, args, value);
  }
  
  @NotNull
  public String toString() {
    return "ValidationError(message=" + this.message + ", args=" + this.args + ", value=" + this.value + ")";
  }
  
  public int hashCode() {
    result = this.message.hashCode();
    result = result * 31 + this.args.hashCode();
    return result * 31 + ((this.value == null) ? 0 : this.value.hashCode());
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof ValidationError))
      return false; 
    ValidationError validationError = (ValidationError)other;
    return !Intrinsics.areEqual(this.message, validationError.message) ? false : (!Intrinsics.areEqual(this.args, validationError.args) ? false : (!!Intrinsics.areEqual(this.value, validationError.value)));
  }
}
