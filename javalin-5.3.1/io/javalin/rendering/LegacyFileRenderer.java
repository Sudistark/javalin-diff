package io.javalin.rendering;

import io.javalin.http.Context;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Deprecated(message = "To be removed in Javalin 6")
@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000$\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\n\002\020$\n\002\020\000\n\000\n\002\030\002\n\000\b\007\030\0002\0020\001B\005¢\006\002\020\002J.\020\003\032\0020\0042\006\020\005\032\0020\0042\024\020\006\032\020\022\004\022\0020\004\022\006\022\004\030\0010\b0\0072\006\020\t\032\0020\nH\026¨\006\013"}, d2 = {"Lio/javalin/rendering/LegacyFileRenderer;", "Lio/javalin/rendering/FileRenderer;", "()V", "render", "", "filePath", "model", "", "", "context", "Lio/javalin/http/Context;", "javalin"})
public final class LegacyFileRenderer implements FileRenderer {
  public LegacyFileRenderer() {
    JavalinRenderer.INSTANCE.loadFileRenderers$javalin();
  }
  
  @NotNull
  public String render(@NotNull String filePath, @NotNull Map<String, ? extends Object> model, @NotNull Context context) {
    Intrinsics.checkNotNullParameter(filePath, "filePath");
    Intrinsics.checkNotNullParameter(model, "model");
    Intrinsics.checkNotNullParameter(context, "context");
    return JavalinRenderer.renderBasedOnExtension(filePath, model, context);
  }
}
