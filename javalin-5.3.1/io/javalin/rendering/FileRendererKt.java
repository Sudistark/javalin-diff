package io.javalin.rendering;

import io.javalin.http.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000\022\n\000\n\002\020\016\n\000\n\002\030\002\n\002\030\002\n\000\032\n\020\002\032\0020\003*\0020\004\"\016\020\000\032\0020\001XT¢\006\002\n\000¨\006\005"}, d2 = {"FILE_RENDERER_KEY", "", "fileRenderer", "Lio/javalin/rendering/FileRenderer;", "Lio/javalin/http/Context;", "javalin"})
public final class FileRendererKt {
  @NotNull
  public static final String FILE_RENDERER_KEY = "javalin-file-renderer";
  
  @NotNull
  public static final FileRenderer fileRenderer(@NotNull Context $this$fileRenderer) {
    Intrinsics.checkNotNullParameter($this$fileRenderer, "<this>");
    return $this$fileRenderer.<FileRenderer>appAttribute("javalin-file-renderer");
  }
}
