package io.javalin.http;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\b\b\001\030\0002\b\022\004\022\0020\0000\001B\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\007\032\0020\003H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\bj\002\b\tj\002\b\n¨\006\013"}, d2 = {"Lio/javalin/http/SameSite;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "toString", "NONE", "STRICT", "LAX", "javalin"})
public enum SameSite {
  NONE("SameSite=None"),
  STRICT("SameSite=Strict"),
  LAX("SameSite=Lax");
  
  @NotNull
  private final String value;
  
  SameSite(String value) {
    this.value = value;
  }
  
  @NotNull
  public final String getValue() {
    return this.value;
  }
  
  @NotNull
  public String toString() {
    return this.value;
  }
}
