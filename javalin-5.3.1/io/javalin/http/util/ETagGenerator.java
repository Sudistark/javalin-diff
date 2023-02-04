package io.javalin.http.util;

import io.javalin.http.Context;
import io.javalin.http.HandlerType;
import io.javalin.http.HttpStatus;
import io.javalin.util.Util;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\036\020\003\032\0020\0042\006\020\005\032\0020\0042\006\020\006\032\0020\0072\006\020\b\032\0020\tJ\024\020\n\032\0020\013*\0020\0072\006\020\f\032\0020\tH\002¨\006\r"}, d2 = {"Lio/javalin/http/util/ETagGenerator;", "", "()V", "tryWriteEtagAndClose", "", "generatorEnabled", "ctx", "Lio/javalin/http/Context;", "resultStream", "Ljava/io/InputStream;", "closeWith304", "", "inputStream", "javalin"})
public final class ETagGenerator {
  @NotNull
  public static final ETagGenerator INSTANCE = new ETagGenerator();
  
  public final boolean tryWriteEtagAndClose(boolean generatorEnabled, @NotNull Context ctx, @NotNull InputStream resultStream) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    Intrinsics.checkNotNullParameter(resultStream, "resultStream");
    String serverEtag = ctx.res().getHeader("ETag");
    String clientEtag = ctx.req().getHeader("If-None-Match");
    if (serverEtag != null && Intrinsics.areEqual(serverEtag, clientEtag)) {
      closeWith304(ctx, resultStream);
      return true;
    } 
    if (serverEtag == null && generatorEnabled && ctx.method() == HandlerType.GET && resultStream instanceof ByteArrayInputStream) {
      String generatedEtag = Util.INSTANCE.getChecksumAndReset((ByteArrayInputStream)resultStream);
      ctx.header("ETag", generatedEtag);
      if (Intrinsics.areEqual(generatedEtag, clientEtag)) {
        closeWith304(ctx, resultStream);
        return true;
      } 
    } 
    return false;
  }
  
  private final void closeWith304(Context $this$closeWith304, InputStream inputStream) {
    InputStream inputStream1 = inputStream;
    Throwable throwable = null;
    try {
      InputStream it = inputStream1;
      int $i$a$-use-ETagGenerator$closeWith304$1 = 0;
      Context context = $this$closeWith304.status(HttpStatus.NOT_MODIFIED);
    } catch (Throwable throwable1) {
      throwable = throwable1 = null;
      throw throwable1;
    } finally {
      CloseableKt.closeFinally(inputStream1, throwable);
    } 
  }
}
