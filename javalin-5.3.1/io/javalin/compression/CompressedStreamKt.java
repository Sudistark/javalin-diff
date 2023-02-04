package io.javalin.compression;

import io.javalin.http.Context;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.text.StringsKt;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000.\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\030\002\n\000\n\002\020\013\n\002\b\002\032.\020\000\032\020\022\004\022\0020\002\022\004\022\0020\003\030\0010\0012\006\020\004\032\0020\0052\006\020\006\032\0020\0032\006\020\007\032\0020\bH\002\032.\020\t\032\020\022\004\022\0020\002\022\004\022\0020\003\030\0010\0012\006\020\004\032\0020\0052\006\020\006\032\0020\0032\006\020\007\032\0020\bH\002\032.\020\n\032\020\022\004\022\0020\002\022\004\022\0020\003\030\0010\0012\006\020\004\032\0020\0052\006\020\013\032\0020\f2\006\020\006\032\0020\003H\002\032\026\020\r\032\0020\016*\0020\0052\b\020\017\032\004\030\0010\bH\002¨\006\020"}, d2 = {"tryBrotli", "Lkotlin/Pair;", "Lio/javalin/compression/CompressionType;", "Ljava/io/OutputStream;", "compression", "Lio/javalin/compression/CompressionStrategy;", "originStream", "acceptedEncoding", "", "tryGzip", "tryMatchCompression", "ctx", "Lio/javalin/http/Context;", "allowsForCompression", "", "contentType", "javalin"})
public final class CompressedStreamKt {
  private static final Pair<CompressionType, OutputStream> tryMatchCompression(CompressionStrategy compression, Context ctx, OutputStream originStream) {
    String acceptedEncoding = ctx.header("Accept-Encoding");
    int $i$a$-let-CompressedStreamKt$tryMatchCompression$1 = 0;
    if (tryBrotli(compression, originStream, acceptedEncoding) == null)
      tryBrotli(compression, originStream, acceptedEncoding); 
    tryBrotli(compression, originStream, acceptedEncoding);
    return (ctx.header("Accept-Encoding") != null) ? tryGzip(compression, originStream, acceptedEncoding) : null;
  }
  
  private static final Pair<CompressionType, OutputStream> tryBrotli(CompressionStrategy compression, OutputStream originStream, String acceptedEncoding) {
    return 
      (compression.getBrotli() == null) ? null : (
      !StringsKt.contains(acceptedEncoding, CompressionType.BR.getTypeName(), true) ? null : 
      TuplesKt.to(CompressionType.BR, new LeveledBrotliStream(originStream, compression.getBrotli().getLevel())));
  }
  
  private static final Pair<CompressionType, OutputStream> tryGzip(CompressionStrategy compression, OutputStream originStream, String acceptedEncoding) {
    return 
      (compression.getGzip() == null) ? null : (
      !StringsKt.contains(acceptedEncoding, CompressionType.GZIP.getTypeName(), true) ? null : 
      TuplesKt.to(CompressionType.GZIP, new LeveledGzipStream(originStream, compression.getGzip().getLevel())));
  }
  
  private static final boolean allowsForCompression(CompressionStrategy $this$allowsForCompression, String contentType) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 98
    //   4: aload_0
    //   5: invokevirtual getExcludedMimeTypesFromCompression : ()Ljava/util/List;
    //   8: checkcast java/lang/Iterable
    //   11: astore_2
    //   12: iconst_0
    //   13: istore_3
    //   14: aload_2
    //   15: instanceof java/util/Collection
    //   18: ifeq -> 37
    //   21: aload_2
    //   22: checkcast java/util/Collection
    //   25: invokeinterface isEmpty : ()Z
    //   30: ifeq -> 37
    //   33: iconst_1
    //   34: goto -> 95
    //   37: aload_2
    //   38: invokeinterface iterator : ()Ljava/util/Iterator;
    //   43: astore #4
    //   45: aload #4
    //   47: invokeinterface hasNext : ()Z
    //   52: ifeq -> 94
    //   55: aload #4
    //   57: invokeinterface next : ()Ljava/lang/Object;
    //   62: astore #5
    //   64: aload #5
    //   66: checkcast java/lang/String
    //   69: astore #6
    //   71: iconst_0
    //   72: istore #7
    //   74: aload_1
    //   75: checkcast java/lang/CharSequence
    //   78: aload #6
    //   80: checkcast java/lang/CharSequence
    //   83: iconst_1
    //   84: invokestatic contains : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z
    //   87: ifeq -> 45
    //   90: iconst_0
    //   91: goto -> 95
    //   94: iconst_1
    //   95: ifeq -> 102
    //   98: iconst_1
    //   99: goto -> 103
    //   102: iconst_0
    //   103: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #65	-> 0
    //   #67	-> 14
    //   #68	-> 37
    //   #65	-> 74
    //   #69	-> 94
    //   #65	-> 103
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   74	13	7	$i$a$-none-CompressedStreamKt$allowsForCompression$1	I
    //   71	16	6	excluded	Ljava/lang/String;
    //   64	30	5	element$iv	Ljava/lang/Object;
    //   14	81	3	$i$f$none	I
    //   12	83	2	$this$none$iv	Ljava/lang/Iterable;
    //   0	104	0	$this$allowsForCompression	Lio/javalin/compression/CompressionStrategy;
    //   0	104	1	contentType	Ljava/lang/String;
  }
}
