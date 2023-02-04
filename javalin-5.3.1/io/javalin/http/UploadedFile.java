package io.javalin.http;

import jakarta.servlet.http.Part;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\020\t\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\006\020\005\032\0020\006J%\020\007\032\002H\b\"\004\b\000\020\b2\022\020\t\032\016\022\004\022\0020\006\022\004\022\002H\b0\n¢\006\002\020\013J\b\020\f\032\004\030\0010\rJ\006\020\016\032\0020\rJ\006\020\017\032\0020\rJ\006\020\020\032\0020\021R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\022"}, d2 = {"Lio/javalin/http/UploadedFile;", "", "part", "Ljakarta/servlet/http/Part;", "(Ljakarta/servlet/http/Part;)V", "content", "Ljava/io/InputStream;", "contentAndClose", "T", "callback", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "contentType", "", "extension", "filename", "size", "", "javalin"})
public final class UploadedFile {
  @NotNull
  private final Part part;
  
  public UploadedFile(@NotNull Part part) {
    this.part = part;
  }
  
  @NotNull
  public final InputStream content() {
    Intrinsics.checkNotNullExpressionValue(this.part.getInputStream(), "part.inputStream");
    return this.part.getInputStream();
  }
  
  public final <T> T contentAndClose(@NotNull Function1 callback) {
    Intrinsics.checkNotNullParameter(callback, "callback");
    InputStream inputStream = content();
    Throwable throwable = null;
    try {
      InputStream it = inputStream;
      int $i$a$-use-UploadedFile$contentAndClose$1 = 0;
      Object object = callback.invoke(it);
    } catch (Throwable throwable1) {
      throwable = throwable1 = null;
      throw throwable1;
    } finally {
      CloseableKt.closeFinally(inputStream, throwable);
    } 
    return (T)object;
  }
  
  @Nullable
  public final String contentType() {
    return this.part.getContentType();
  }
  
  @NotNull
  public final String filename() {
    Intrinsics.checkNotNullExpressionValue(this.part.getSubmittedFileName(), "part.submittedFileName");
    return this.part.getSubmittedFileName();
  }
  
  @NotNull
  public final String extension() {
    Intrinsics.checkNotNullExpressionValue(this.part.getSubmittedFileName(), "part.submittedFileName");
    return StringsKt.replaceBeforeLast$default(this.part.getSubmittedFileName(), ".", "", null, 4, null);
  }
  
  public final long size() {
    return this.part.getSize();
  }
}
