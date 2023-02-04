package io.javalin.rendering;

import io.javalin.http.Context;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\002\n\002\020$\n\000\n\002\030\002\n\000\bæ\001\030\0002\0020\001J.\020\002\032\0020\0032\006\020\004\032\0020\0032\024\020\005\032\020\022\004\022\0020\003\022\006\022\004\030\0010\0010\0062\006\020\007\032\0020\bH&ø\001\000\002\006\n\004\b!0\001¨\006\tÀ\006\001"}, d2 = {"Lio/javalin/rendering/FileRenderer;", "", "render", "", "filePath", "model", "", "context", "Lio/javalin/http/Context;", "javalin"})
public interface FileRenderer {
  @NotNull
  String render(@NotNull String paramString, @NotNull Map<String, ? extends Object> paramMap, @NotNull Context paramContext);
}
