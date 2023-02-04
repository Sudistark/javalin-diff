package io.javalin.http.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\004¨\006\006"}, d2 = {"Lio/javalin/http/util/JsonEscapeUtil;", "", "()V", "escape", "", "str", "javalin"})
public final class JsonEscapeUtil {
  @NotNull
  public static final JsonEscapeUtil INSTANCE = new JsonEscapeUtil();
  
  @NotNull
  public final String escape(@NotNull String str) {
    Intrinsics.checkNotNullParameter(str, "str");
    StringBuilder builder = new StringBuilder(str.length());
    byte b;
    int i;
    for (b = 0, i = str.length(); b < i; ) {
      char ch = str.charAt(b);
      char c = ch;
      builder.append((c == '"') ? "\\\"" : (
          (c == '\n') ? "\\n" : (
          (c == '\r') ? "\\r" : (
          (c == '\\') ? "\\\\" : (
          (c == '\t') ? "\\t" : (
          (c == '\b') ? "\\b" : 
          Character.valueOf(ch)))))));
      b++;
    } 
    Intrinsics.checkNotNullExpressionValue(builder.toString(), "builder.toString()");
    return builder.toString();
  }
}
