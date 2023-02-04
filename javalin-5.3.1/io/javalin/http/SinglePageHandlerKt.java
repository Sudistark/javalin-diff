package io.javalin.http;

import java.util.Map;
import kotlin.Metadata;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000\020\n\002\b\002\n\002\020$\n\002\020\016\n\002\b\003\032-\020\000\032\004\030\001H\001\"\004\b\000\020\001*\016\022\004\022\0020\003\022\004\022\002H\0010\0022\006\020\004\032\0020\003H\002¢\006\002\020\005¨\006\006"}, d2 = {"findByPath", "T", "", "", "requestPath", "(Ljava/util/Map;Ljava/lang/String;)Ljava/lang/Object;", "javalin"})
public final class SinglePageHandlerKt {
  private static final <T> T findByPath(Map $this$findByPath, String requestPath) {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface keySet : ()Ljava/util/Set;
    //   6: checkcast java/lang/Iterable
    //   9: astore_2
    //   10: aload_2
    //   11: invokeinterface iterator : ()Ljava/util/Iterator;
    //   16: astore_3
    //   17: aload_3
    //   18: invokeinterface hasNext : ()Z
    //   23: ifeq -> 61
    //   26: aload_3
    //   27: invokeinterface next : ()Ljava/lang/Object;
    //   32: astore #4
    //   34: aload #4
    //   36: checkcast java/lang/String
    //   39: astore #5
    //   41: iconst_0
    //   42: istore #6
    //   44: aload_1
    //   45: aload #5
    //   47: iconst_0
    //   48: iconst_2
    //   49: aconst_null
    //   50: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
    //   53: ifeq -> 17
    //   56: aload #4
    //   58: goto -> 62
    //   61: aconst_null
    //   62: checkcast java/lang/String
    //   65: dup
    //   66: ifnull -> 86
    //   69: astore_2
    //   70: iconst_0
    //   71: istore_3
    //   72: aload_0
    //   73: aload_2
    //   74: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   79: dup
    //   80: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   83: goto -> 88
    //   86: pop
    //   87: aconst_null
    //   88: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #60	-> 0
    //   #62	-> 41
    //   #60	-> 44
    //   #60	-> 53
    //   #60	-> 62
    //   #62	-> 70
    //   #60	-> 72
    //   #60	-> 83
    //   #60	-> 86
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   44	9	6	$i$a$-find-SinglePageHandlerKt$findByPath$1	I
    //   41	12	5	it	Ljava/lang/String;
    //   72	11	3	$i$a$-let-SinglePageHandlerKt$findByPath$2	I
    //   70	13	2	it	Ljava/lang/String;
    //   0	89	0	$this$findByPath	Ljava/util/Map;
    //   0	89	1	requestPath	Ljava/lang/String;
  }
}
