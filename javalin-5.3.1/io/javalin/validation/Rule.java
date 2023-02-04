package io.javalin.validation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0000\n\002\030\002\n\000\n\002\020\000\n\000\n\002\020\016\n\000\n\002\030\002\n\002\020\013\n\002\030\002\n\000\n\002\030\002\n\002\b\016\n\002\020\b\n\002\b\002\b\b\030\000*\004\b\000\020\0012\0020\002B=\022\006\020\003\032\0020\004\022 \020\005\032\034\022\006\022\004\030\0018\000\022\004\022\0020\0070\006j\n\022\006\022\004\030\0018\000`\b\022\f\020\t\032\b\022\004\022\0028\0000\n¢\006\002\020\013J\t\020\022\032\0020\004HÆ\003J#\020\023\032\034\022\006\022\004\030\0018\000\022\004\022\0020\0070\006j\n\022\006\022\004\030\0018\000`\bHÆ\003J\017\020\024\032\b\022\004\022\0028\0000\nHÆ\003JM\020\025\032\b\022\004\022\0028\0000\0002\b\b\002\020\003\032\0020\0042\"\b\002\020\005\032\034\022\006\022\004\030\0018\000\022\004\022\0020\0070\006j\n\022\006\022\004\030\0018\000`\b2\016\b\002\020\t\032\b\022\004\022\0028\0000\nHÆ\001J\023\020\026\032\0020\0072\b\020\027\032\004\030\0010\002HÖ\003J\t\020\030\032\0020\031HÖ\001J\t\020\032\032\0020\004HÖ\001R+\020\005\032\034\022\006\022\004\030\0018\000\022\004\022\0020\0070\006j\n\022\006\022\004\030\0018\000`\b¢\006\b\n\000\032\004\b\f\020\rR\027\020\t\032\b\022\004\022\0028\0000\n¢\006\b\n\000\032\004\b\016\020\017R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\020\020\021¨\006\033"}, d2 = {"Lio/javalin/validation/Rule;", "T", "", "fieldName", "", "check", "Lkotlin/Function1;", "", "Lio/javalin/validation/Check;", "error", "Lio/javalin/validation/ValidationError;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lio/javalin/validation/ValidationError;)V", "getCheck", "()Lkotlin/jvm/functions/Function1;", "getError", "()Lio/javalin/validation/ValidationError;", "getFieldName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "javalin"})
public final class Rule<T> {
  @NotNull
  private final String fieldName;
  
  @NotNull
  private final Function1<T, Boolean> check;
  
  @NotNull
  private final ValidationError<T> error;
  
  public Rule(@NotNull String fieldName, @NotNull Function1<T, Boolean> check, @NotNull ValidationError<T> error) {
    this.fieldName = fieldName;
    this.check = check;
    this.error = error;
  }
  
  @NotNull
  public final String getFieldName() {
    return this.fieldName;
  }
  
  @NotNull
  public final Function1<T, Boolean> getCheck() {
    return this.check;
  }
  
  @NotNull
  public final ValidationError<T> getError() {
    return this.error;
  }
  
  @NotNull
  public final String component1() {
    return this.fieldName;
  }
  
  @NotNull
  public final Function1<T, Boolean> component2() {
    return this.check;
  }
  
  @NotNull
  public final ValidationError<T> component3() {
    return this.error;
  }
  
  @NotNull
  public final Rule<T> copy(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> check, @NotNull ValidationError<T> error) {
    Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    Intrinsics.checkNotNullParameter(check, "check");
    Intrinsics.checkNotNullParameter(error, "error");
    return new Rule(fieldName, check, error);
  }
  
  @NotNull
  public String toString() {
    return "Rule(fieldName=" + this.fieldName + ", check=" + this.check + ", error=" + this.error + ")";
  }
  
  public int hashCode() {
    result = this.fieldName.hashCode();
    result = result * 31 + this.check.hashCode();
    return result * 31 + this.error.hashCode();
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof Rule))
      return false; 
    Rule rule = (Rule)other;
    return !Intrinsics.areEqual(this.fieldName, rule.fieldName) ? false : (!Intrinsics.areEqual(this.check, rule.check) ? false : (!!Intrinsics.areEqual(this.error, rule.error)));
  }
}
