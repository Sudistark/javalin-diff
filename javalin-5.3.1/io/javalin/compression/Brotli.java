package io.javalin.compression;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\002\b\004\030\0002\0020\001B\017\022\b\b\002\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006¨\006\007"}, d2 = {"Lio/javalin/compression/Brotli;", "", "level", "", "(I)V", "getLevel", "()I", "javalin"})
public final class Brotli {
  private final int level;
  
  public Brotli(int level) {
    this.level = level;
    int i = this.level;
    if (!((0 <= i) ? ((i < 12) ? 1 : 0) : 0)) {
      int $i$a$-require-Brotli$1 = 0;
      String str = "Valid range for parameter level is 0 to 11";
      throw new IllegalArgumentException(str.toString());
    } 
  }
  
  public final int getLevel() {
    return this.level;
  }
  
  public Brotli() {
    this(0, 1, null);
  }
}
