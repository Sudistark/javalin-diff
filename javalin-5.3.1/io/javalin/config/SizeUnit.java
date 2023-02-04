package io.javalin.config;

import kotlin.Metadata;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\b\n\002\b\b\b\001\030\0002\b\022\004\022\0020\0000\001B\017\b\002\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006j\002\b\007j\002\b\bj\002\b\tj\002\b\n¨\006\013"}, d2 = {"Lio/javalin/config/SizeUnit;", "", "multiplier", "", "(Ljava/lang/String;II)V", "getMultiplier", "()I", "BYTES", "KB", "MB", "GB", "javalin"})
public enum SizeUnit {
  BYTES(1),
  KB(1024),
  MB(1048576),
  GB(1073741824);
  
  private final int multiplier;
  
  SizeUnit(int multiplier) {
    this.multiplier = multiplier;
  }
  
  public final int getMultiplier() {
    return this.multiplier;
  }
}
