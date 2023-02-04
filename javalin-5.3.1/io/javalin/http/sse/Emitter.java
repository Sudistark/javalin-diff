package io.javalin.http.sse;

import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\004\n\002\020\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\016\020\n\032\0020\0132\006\020\f\032\0020\rJ \020\n\032\0020\0132\006\020\016\032\0020\r2\006\020\017\032\0020\0202\b\020\021\032\004\030\0010\rJ\020\020\022\032\0020\0132\006\020\023\032\0020\rH\002R\036\020\007\032\0020\0062\006\020\005\032\0020\006@BX\016¢\006\b\n\000\032\004\b\b\020\tR\016\020\002\032\0020\003X\016¢\006\002\n\000¨\006\024"}, d2 = {"Lio/javalin/http/sse/Emitter;", "", "response", "Ljakarta/servlet/http/HttpServletResponse;", "(Ljakarta/servlet/http/HttpServletResponse;)V", "<set-?>", "", "closed", "getClosed", "()Z", "emit", "", "comment", "", "event", "data", "Ljava/io/InputStream;", "id", "write", "value", "javalin"})
public final class Emitter {
  @NotNull
  private HttpServletResponse response;
  
  private boolean closed;
  
  public Emitter(@NotNull HttpServletResponse response) {
    this.response = response;
  }
  
  public final boolean getClosed() {
    return this.closed;
  }
  
  public final void emit(@NotNull String event, @NotNull InputStream data, @Nullable String id) {
    Intrinsics.checkNotNullParameter(event, "event");
    Intrinsics.checkNotNullParameter(data, "data");
    synchronized (this) {
      int $i$a$-synchronized-Emitter$emit$1 = 0;
      try {
        if (id != null)
          write("id: " + id + "\n"); 
        write("event: " + event + "\n");
        InputStream inputStream = data;
        char c1 = ' ';
        inputStream = (inputStream instanceof BufferedInputStream) ? inputStream : new BufferedInputStream(inputStream, c1);
        Charset charset = Charsets.UTF_8;
        InputStreamReader inputStreamReader1 = new InputStreamReader(inputStream, charset);
        int $i$f$useLines = 0;
        InputStreamReader inputStreamReader2 = inputStreamReader1;
        char c2 = ' ';
        BufferedReader bufferedReader = (inputStreamReader2 instanceof BufferedReader) ? (BufferedReader)inputStreamReader2 : new BufferedReader(inputStreamReader2, c2);
        Throwable throwable = null;
        try {
          BufferedReader it$iv = bufferedReader;
          int $i$a$-use-TextStreamsKt$useLines$1$iv = 0;
          Sequence it = TextStreamsKt.lineSequence(it$iv);
          int $i$a$-useLines-Emitter$emit$1$1 = 0;
          Sequence $this$forEach$iv = it;
          int $i$f$forEach = 0;
          for (Object element$iv : $this$forEach$iv) {
            String line = (String)element$iv;
            int $i$a$-forEach-Emitter$emit$1$1$1 = 0;
            write("data: " + line + "\n");
          } 
          Unit unit1 = Unit.INSTANCE;
        } catch (Throwable throwable1) {
          throwable = throwable1 = null;
          throw throwable1;
        } finally {
          CloseableKt.closeFinally(bufferedReader, throwable);
        } 
        write("\n");
        this.response.flushBuffer();
      } catch (IOException ignored) {
        Reader $this$useLines$iv;
        this.closed = true;
      } 
      Unit unit = Unit.INSTANCE;
    } 
  }
  
  public final void emit(@NotNull String comment) {
    Intrinsics.checkNotNullParameter(comment, "comment");
    try {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "\n";
      Iterable $this$forEach$iv = StringsKt.split$default(comment, arrayOfString, false, 0, 6, null);
      int $i$f$forEach = 0;
      Iterator iterator = $this$forEach$iv.iterator();
      if (iterator.hasNext()) {
        Object element$iv = iterator.next();
        String it = (String)element$iv;
        int $i$a$-forEach-Emitter$emit$2 = 0;
        write(": " + it + "\n");
      } 
      this.response.flushBuffer();
    } catch (IOException ignored) {
      this.closed = true;
    } 
  }
  
  private final void write(String value) {
    this.response.getOutputStream().print(value);
  }
}
