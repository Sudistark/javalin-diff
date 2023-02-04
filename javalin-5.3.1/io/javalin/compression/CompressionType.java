package io.javalin.compression;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\032\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\006\n\002\020\013\n\002\b\005\b\001\030\000 \0162\b\022\004\022\0020\0000\001:\001\016B\027\b\002\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003¢\006\002\020\005J\016\020\t\032\0020\n2\006\020\t\032\0020\003R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\006\020\007R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\b\020\007j\002\b\013j\002\b\fj\002\b\r¨\006\017"}, d2 = {"Lio/javalin/compression/CompressionType;", "", "typeName", "", "extension", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getExtension", "()Ljava/lang/String;", "getTypeName", "acceptEncoding", "", "GZIP", "BR", "NONE", "Companion", "javalin"})
public enum CompressionType {
  GZIP("gzip", ".gz"),
  BR("br", ".br"),
  NONE("", "");
  
  @NotNull
  public static final Companion Companion;
  
  @NotNull
  private final String typeName;
  
  @NotNull
  private final String extension;
  
  CompressionType(String typeName, String extension) {
    this.typeName = typeName;
    this.extension = extension;
  }
  
  @NotNull
  public final String getTypeName() {
    return this.typeName;
  }
  
  @NotNull
  public final String getExtension() {
    return this.extension;
  }
  
  static {
    Companion = new Companion(null);
  }
  
  public final boolean acceptEncoding(@NotNull String acceptEncoding) {
    Intrinsics.checkNotNullParameter(acceptEncoding, "acceptEncoding");
    return StringsKt.contains(acceptEncoding, this.typeName, true);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006¨\006\007"}, d2 = {"Lio/javalin/compression/CompressionType$Companion;", "", "()V", "getByAcceptEncoding", "Lio/javalin/compression/CompressionType;", "acceptEncoding", "", "javalin"})
  public static final class Companion {
    private Companion() {}
    
    @NotNull
    public final CompressionType getByAcceptEncoding(@NotNull String acceptEncoding) {
      // Byte code:
      //   0: aload_1
      //   1: ldc 'acceptEncoding'
      //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
      //   6: invokestatic values : ()[Lio/javalin/compression/CompressionType;
      //   9: astore_2
      //   10: iconst_0
      //   11: istore_3
      //   12: aload_2
      //   13: arraylength
      //   14: istore #4
      //   16: iload_3
      //   17: iload #4
      //   19: if_icmpge -> 54
      //   22: aload_2
      //   23: iload_3
      //   24: aaload
      //   25: astore #5
      //   27: aload #5
      //   29: astore #6
      //   31: iconst_0
      //   32: istore #7
      //   34: aload #6
      //   36: aload_1
      //   37: invokevirtual acceptEncoding : (Ljava/lang/String;)Z
      //   40: ifeq -> 48
      //   43: aload #5
      //   45: goto -> 55
      //   48: iinc #3, 1
      //   51: goto -> 16
      //   54: aconst_null
      //   55: dup
      //   56: ifnonnull -> 63
      //   59: pop
      //   60: getstatic io/javalin/compression/CompressionType.NONE : Lio/javalin/compression/CompressionType;
      //   63: areturn
      // Line number table:
      //   Java source line number -> byte code offset
      //   #14	-> 6
      //   #19	-> 31
      //   #14	-> 34
      //   #14	-> 40
      //   #14	-> 55
      // Local variable table:
      //   start	length	slot	name	descriptor
      //   34	6	7	$i$a$-find-CompressionType$Companion$getByAcceptEncoding$1	I
      //   31	9	6	it	Lio/javalin/compression/CompressionType;
      //   0	64	0	this	Lio/javalin/compression/CompressionType$Companion;
      //   0	64	1	acceptEncoding	Ljava/lang/String;
    }
  }
}
