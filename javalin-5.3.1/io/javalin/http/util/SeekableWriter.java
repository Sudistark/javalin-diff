package io.javalin.http.util;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;
import jakarta.servlet.ServletOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000>\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\t\n\002\030\002\n\002\b\003\n\002\020\022\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J&\020\t\032\0020\n2\006\020\013\032\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\022J.\020\t\032\0020\n*\0020\0232\006\020\r\032\0020\0162\006\020\024\032\0020\0222\006\020\025\032\0020\0222\b\b\002\020\026\032\0020\027H\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\b¨\006\030"}, d2 = {"Lio/javalin/http/util/SeekableWriter;", "", "()V", "chunkSize", "", "getChunkSize", "()I", "setChunkSize", "(I)V", "write", "", "ctx", "Lio/javalin/http/Context;", "inputStream", "Ljava/io/InputStream;", "contentType", "", "totalBytes", "", "Ljava/io/OutputStream;", "from", "to", "buffer", "", "javalin"})
public final class SeekableWriter {
  @NotNull
  public static final SeekableWriter INSTANCE = new SeekableWriter();
  
  private static int chunkSize = 128000;
  
  public final int getChunkSize() {
    return chunkSize;
  }
  
  public final void setChunkSize(int <set-?>) {
    chunkSize = <set-?>;
  }
  
  public final void write(@NotNull Context ctx, @NotNull InputStream inputStream, @NotNull String contentType, long totalBytes) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'ctx'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 'inputStream'
    //   9: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_3
    //   13: ldc 'contentType'
    //   15: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   18: aload_1
    //   19: aload_1
    //   20: aload_3
    //   21: aload_2
    //   22: lload #4
    //   24: <illegal opcode> run : (Lio/javalin/http/Context;Ljava/lang/String;Ljava/io/InputStream;J)Lio/javalin/util/function/ThrowingRunnable;
    //   29: invokeinterface async : (Lio/javalin/util/function/ThrowingRunnable;)V
    //   34: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #12	-> 18
    //   #33	-> 34
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	35	0	this	Lio/javalin/http/util/SeekableWriter;
    //   0	35	1	ctx	Lio/javalin/http/Context;
    //   0	35	2	inputStream	Ljava/io/InputStream;
    //   0	35	3	contentType	Ljava/lang/String;
    //   0	35	4	totalBytes	J
  }
  
  private static final void write$lambda-1(Context $ctx, String $contentType, InputStream $inputStream, long $totalBytes) {
    Intrinsics.checkNotNullParameter($ctx, "$ctx");
    Intrinsics.checkNotNullParameter($contentType, "$contentType");
    Intrinsics.checkNotNullParameter($inputStream, "$inputStream");
    ServletOutputStream uncompressedStream = $ctx.res().getOutputStream();
    if ($ctx.header("Range") == null) {
      $ctx.header("Content-Type", $contentType);
      $inputStream.transferTo((OutputStream)uncompressedStream);
      $inputStream.close();
      return;
    } 
    Intrinsics.checkNotNull($ctx.header("Range"));
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "=";
    arrayOfString = new String[1];
    arrayOfString[0] = "-";
    Iterable $this$filter$iv = StringsKt.split$default(StringsKt.split$default($ctx.header("Range"), arrayOfString, false, 0, 6, null).get(1), arrayOfString, false, 0, 6, null);
    int $i$f$filter = 0;
    Iterable iterable1 = $this$filter$iv;
    Collection<Object> destination$iv$iv = new ArrayList();
    int $i$f$filterTo = 0;
    for (Object element$iv$iv : iterable1) {
      String it = (String)element$iv$iv;
      int $i$a$-filter-SeekableWriter$write$1$requestedRange$1 = 0;
      if ((((CharSequence)it).length() > 0))
        destination$iv$iv.add(element$iv$iv); 
    } 
    List<String> requestedRange = (List)destination$iv$iv;
    long from = Long.parseLong(requestedRange.get(0));
    long to = (from + chunkSize > $totalBytes) ? ($totalBytes - 1L) : ((requestedRange.size() == 2) ? Long.parseLong(requestedRange.get(1)) : (from + chunkSize - 1L));
    $ctx.status(HttpStatus.PARTIAL_CONTENT);
    $ctx.header("Content-Type", $contentType);
    $ctx.header("Accept-Ranges", "bytes");
    $ctx.header("Content-Range", "bytes " + from + "-" + to + "/" + $totalBytes);
    $ctx.header("Content-Length", String.valueOf(Math.min(to - from + 1L, $totalBytes)));
    Intrinsics.checkNotNullExpressionValue(uncompressedStream, "uncompressedStream");
    write$default(INSTANCE, (OutputStream)uncompressedStream, $inputStream, from, to, null, 8, null);
  }
  
  private final void write(OutputStream $this$write, InputStream inputStream, long from, long to, byte[] buffer) {
    InputStream inputStream1 = inputStream;
    Throwable throwable = null;
    try {
      InputStream it = inputStream1;
      int $i$a$-use-SeekableWriter$write$2 = 0;
      long toSkip = from;
      while (toSkip > 0L) {
        long skipped = it.skip(toSkip);
        toSkip -= skipped;
      } 
      long bytesLeft = to - from + 1L;
      while (bytesLeft != 0L) {
        int read = it.read(buffer, 0, (int)RangesKt.coerceAtMost(buffer.length, bytesLeft));
        $this$write.write(buffer, 0, read);
        bytesLeft -= read;
      } 
      Unit unit = Unit.INSTANCE;
    } catch (Throwable throwable1) {
      throwable = throwable1 = null;
      throw throwable1;
    } finally {
      CloseableKt.closeFinally(inputStream1, throwable);
    } 
  }
}
