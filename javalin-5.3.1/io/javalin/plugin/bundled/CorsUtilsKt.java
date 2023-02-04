package io.javalin.plugin.bundled;

import kotlin.Metadata;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000\f\n\000\n\002\020\013\n\002\020\f\n\000\032\f\020\000\032\0020\001*\0020\002H\002¨\006\003"}, d2 = {"isAsciiDigit", "", "", "javalin"})
public final class CorsUtilsKt {
  private static final boolean isAsciiDigit(char $this$isAsciiDigit) {
    return ('0' <= $this$isAsciiDigit) ? (($this$isAsciiDigit < ':')) : false;
  }
}
