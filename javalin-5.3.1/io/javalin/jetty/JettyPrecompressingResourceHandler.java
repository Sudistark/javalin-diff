package io.javalin.jetty;

import io.javalin.compression.CompressionStrategy;
import io.javalin.compression.CompressionType;
import io.javalin.compression.LeveledBrotliStream;
import io.javalin.compression.LeveledGzipStream;
import io.javalin.util.CoreDependency;
import io.javalin.util.Util;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.util.resource.Resource;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000L\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\020\016\n\002\020\022\n\002\b\003\n\002\020 \n\002\b\003\n\002\020\b\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\021\032\0020\0042\006\020\022\032\0020\007H\002J\030\020\023\032\0020\b2\006\020\024\032\0020\0252\006\020\026\032\0020\027H\002J\"\020\030\032\004\030\0010\b2\006\020\024\032\0020\0252\006\020\031\032\0020\0072\006\020\026\032\0020\027H\002J&\020\032\032\0020\0042\006\020\031\032\0020\0072\006\020\024\032\0020\0252\006\020\033\032\0020\0342\006\020\035\032\0020\036R\016\020\003\032\0020\004X\004¢\006\002\n\000R\035\020\005\032\016\022\004\022\0020\007\022\004\022\0020\b0\006¢\006\b\n\000\032\004\b\t\020\nR\027\020\013\032\b\022\004\022\0020\0070\f¢\006\b\n\000\032\004\b\r\020\016R\022\020\017\032\0020\0208\006@\006X\016¢\006\002\n\000¨\006\037"}, d2 = {"Lio/javalin/jetty/JettyPrecompressingResourceHandler;", "", "()V", "brotliAvailable", "", "compressedFiles", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getCompressedFiles", "()Ljava/util/concurrent/ConcurrentHashMap;", "excludedMimeTypes", "", "getExcludedMimeTypes", "()Ljava/util/List;", "resourceMaxSize", "", "excludedMimeType", "mimeType", "getCompressedByteArray", "resource", "Lorg/eclipse/jetty/util/resource/Resource;", "type", "Lio/javalin/compression/CompressionType;", "getStaticResourceByteArray", "target", "handle", "req", "Ljakarta/servlet/http/HttpServletRequest;", "res", "Ljakarta/servlet/http/HttpServletResponse;", "javalin"})
public final class JettyPrecompressingResourceHandler {
  @NotNull
  public static final JettyPrecompressingResourceHandler INSTANCE = new JettyPrecompressingResourceHandler();
  
  @NotNull
  private static final ConcurrentHashMap<String, byte[]> compressedFiles = (ConcurrentHashMap)new ConcurrentHashMap<>();
  
  @NotNull
  public final ConcurrentHashMap<String, byte[]> getCompressedFiles() {
    return compressedFiles;
  }
  
  @JvmField
  public static int resourceMaxSize = 2097152;
  
  @NotNull
  private static final List<String> excludedMimeTypes = (new CompressionStrategy(null, null, 3, null)).getExcludedMimeTypesFromCompression();
  
  @NotNull
  public final List<String> getExcludedMimeTypes() {
    return excludedMimeTypes;
  }
  
  public final boolean handle(@NotNull String target, @NotNull Resource resource, @NotNull HttpServletRequest req, @NotNull HttpServletResponse res) {
    Intrinsics.checkNotNullParameter(target, "target");
    Intrinsics.checkNotNullParameter(resource, "resource");
    Intrinsics.checkNotNullParameter(req, "req");
    Intrinsics.checkNotNullParameter(res, "res");
    if (resource.exists() && !resource.isDirectory()) {
      byte[] resultByteArray;
      if (req.getHeader("Accept-Encoding") == null)
        req.getHeader("Accept-Encoding"); 
      CompressionType acceptCompressType = req.getHeader("Accept-Encoding").getByAcceptEncoding("");
      String contentType = MimeTypes.getDefaultMimeByExtension(target);
      if (contentType == null || excludedMimeType(contentType))
        acceptCompressType = CompressionType.NONE; 
      if (getStaticResourceByteArray(resource, target, acceptCompressType) == null) {
        getStaticResourceByteArray(resource, target, acceptCompressType);
        return false;
      } 
      res.setContentLength(resultByteArray.length);
      res.setHeader("Content-Type", contentType);
      if (acceptCompressType != CompressionType.NONE)
        res.setHeader("Content-Encoding", acceptCompressType.getTypeName()); 
      String weakETag = resource.getWeakETag();
      String etag = req.getHeader("If-None-Match");
      int $i$a$-let-JettyPrecompressingResourceHandler$handle$1 = 0;
      if (Intrinsics.areEqual(etag, weakETag)) {
        res.setStatus(304);
        return true;
      } 
      req.getHeader("If-None-Match");
      res.setHeader("ETag", weakETag);
      Intrinsics.checkNotNullExpressionValue(res.getOutputStream(), "res.outputStream");
      ByteStreamsKt.copyTo$default(new ByteArrayInputStream(resultByteArray), (OutputStream)res.getOutputStream(), 0, 2, null);
      res.getOutputStream().close();
      return true;
    } 
    return false;
  }
  
  private final byte[] getStaticResourceByteArray(Resource resource, String target, CompressionType type) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual length : ()J
    //   4: getstatic io/javalin/jetty/JettyPrecompressingResourceHandler.resourceMaxSize : I
    //   7: i2l
    //   8: lcmp
    //   9: ifle -> 29
    //   12: aload_2
    //   13: getstatic io/javalin/jetty/JettyPrecompressingResourceHandler.resourceMaxSize : I
    //   16: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;I)Ljava/lang/String;
    //   21: aconst_null
    //   22: iconst_2
    //   23: aconst_null
    //   24: invokestatic warn$default : (Ljava/lang/String;Ljava/lang/Throwable;ILjava/lang/Object;)V
    //   27: aconst_null
    //   28: areturn
    //   29: getstatic io/javalin/jetty/JettyPrecompressingResourceHandler.compressedFiles : Ljava/util/concurrent/ConcurrentHashMap;
    //   32: aload_2
    //   33: aload_3
    //   34: invokevirtual getExtension : ()Ljava/lang/String;
    //   37: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: aload_1
    //   43: aload_3
    //   44: <illegal opcode> apply : (Lorg/eclipse/jetty/util/resource/Resource;Lio/javalin/compression/CompressionType;)Ljava/util/function/Function;
    //   49: invokevirtual computeIfAbsent : (Ljava/lang/Object;Ljava/util/function/Function;)Ljava/lang/Object;
    //   52: checkcast [B
    //   55: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #58	-> 0
    //   #60	-> 12
    //   #59	-> 21
    //   #63	-> 27
    //   #65	-> 29
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	56	0	this	Lio/javalin/jetty/JettyPrecompressingResourceHandler;
    //   0	56	1	resource	Lorg/eclipse/jetty/util/resource/Resource;
    //   0	56	2	target	Ljava/lang/String;
    //   0	56	3	type	Lio/javalin/compression/CompressionType;
  }
  
  private static final byte[] getStaticResourceByteArray$lambda-1(Resource $resource, CompressionType $type, String it) {
    Intrinsics.checkNotNullParameter($resource, "$resource");
    Intrinsics.checkNotNullParameter($type, "$type");
    Intrinsics.checkNotNullParameter(it, "it");
    return INSTANCE.getCompressedByteArray($resource, $type);
  }
  
  private static final boolean brotliAvailable = Util.INSTANCE.classExists(CoreDependency.JVMBROTLI.getTestClass());
  
  private final byte[] getCompressedByteArray(Resource resource, CompressionType type) {
    InputStream fileInput = resource.getInputStream();
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    OutputStream outputStream = 
      (type == CompressionType.GZIP) ? 
      new LeveledGzipStream(byteArrayOutputStream, 9) : (
      
      (type == CompressionType.BR && brotliAvailable) ? 
      (OutputStream)new LeveledBrotliStream(byteArrayOutputStream, 11) : 
      
      byteArrayOutputStream);
    Intrinsics.checkNotNullExpressionValue(fileInput, "fileInput");
    ByteStreamsKt.copyTo$default(fileInput, outputStream, 0, 2, null);
    fileInput.close();
    outputStream.close();
    Intrinsics.checkNotNullExpressionValue(byteArrayOutputStream.toByteArray(), "byteArrayOutputStream.toByteArray()");
    return byteArrayOutputStream.toByteArray();
  }
  
  private final boolean excludedMimeType(String mimeType) {
    // Byte code:
    //   0: aload_1
    //   1: ldc ''
    //   3: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   6: ifeq -> 13
    //   9: iconst_0
    //   10: goto -> 103
    //   13: getstatic io/javalin/jetty/JettyPrecompressingResourceHandler.excludedMimeTypes : Ljava/util/List;
    //   16: checkcast java/lang/Iterable
    //   19: astore_2
    //   20: iconst_0
    //   21: istore_3
    //   22: aload_2
    //   23: instanceof java/util/Collection
    //   26: ifeq -> 45
    //   29: aload_2
    //   30: checkcast java/util/Collection
    //   33: invokeinterface isEmpty : ()Z
    //   38: ifeq -> 45
    //   41: iconst_0
    //   42: goto -> 103
    //   45: aload_2
    //   46: invokeinterface iterator : ()Ljava/util/Iterator;
    //   51: astore #4
    //   53: aload #4
    //   55: invokeinterface hasNext : ()Z
    //   60: ifeq -> 102
    //   63: aload #4
    //   65: invokeinterface next : ()Ljava/lang/Object;
    //   70: astore #5
    //   72: aload #5
    //   74: checkcast java/lang/String
    //   77: astore #6
    //   79: iconst_0
    //   80: istore #7
    //   82: aload_1
    //   83: checkcast java/lang/CharSequence
    //   86: aload #6
    //   88: checkcast java/lang/CharSequence
    //   91: iconst_1
    //   92: invokestatic contains : (Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z
    //   95: ifeq -> 53
    //   98: iconst_1
    //   99: goto -> 103
    //   102: iconst_0
    //   103: ireturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #88	-> 0
    //   #92	-> 22
    //   #93	-> 45
    //   #88	-> 82
    //   #94	-> 102
    //   #88	-> 103
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   82	13	7	$i$a$-any-JettyPrecompressingResourceHandler$excludedMimeType$1	I
    //   79	16	6	excluded	Ljava/lang/String;
    //   72	30	5	element$iv	Ljava/lang/Object;
    //   22	81	3	$i$f$any	I
    //   20	83	2	$this$any$iv	Ljava/lang/Iterable;
    //   0	104	0	this	Lio/javalin/jetty/JettyPrecompressingResourceHandler;
    //   0	104	1	mimeType	Ljava/lang/String;
  }
}
