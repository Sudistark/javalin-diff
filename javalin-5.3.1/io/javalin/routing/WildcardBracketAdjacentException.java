package io.javalin.routing;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\026\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\005\030\0002\0060\001j\002`\002B\025\022\006\020\003\032\0020\004\022\006\020\005\032\0020\004¢\006\002\020\006R\021\020\005\032\0020\004¢\006\b\n\000\032\004\b\007\020\b¨\006\t"}, d2 = {"Lio/javalin/routing/WildcardBracketAdjacentException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "segment", "", "path", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "javalin"})
public final class WildcardBracketAdjacentException extends IllegalArgumentException {
  @NotNull
  private final String path;
  
  public WildcardBracketAdjacentException(@NotNull String segment, @NotNull String path) {
    super("Wildcard and a path parameter bracket are adjacent in segment '" + 
        segment + "' of path '" + path + "'. This is forbidden");
    this.path = path;
  }
  
  @NotNull
  public final String getPath() {
    return this.path;
  }
}
