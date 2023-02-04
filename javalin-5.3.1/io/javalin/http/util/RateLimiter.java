package io.javalin.http.util;

import io.javalin.http.Context;
import io.javalin.http.HttpResponseException;
import io.javalin.http.HttpStatus;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0000\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\020\016\n\002\020\b\n\002\b\004\n\002\020\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\026\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\bR\032\020\005\032\016\022\004\022\0020\007\022\004\022\0020\b0\006X\004¢\006\002\n\000R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR\016\020\013\032\0020\007X\004¢\006\002\n\000¨\006\021"}, d2 = {"Lio/javalin/http/util/RateLimiter;", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/util/concurrent/TimeUnit;)V", "keyToRequestCount", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "timeUnitString", "incrementCounter", "", "ctx", "Lio/javalin/http/Context;", "requestLimit", "javalin"})
public final class RateLimiter {
  @NotNull
  private final TimeUnit timeUnit;
  
  @NotNull
  private final String timeUnitString;
  
  @NotNull
  private final ConcurrentHashMap<String, Integer> keyToRequestCount;
  
  public RateLimiter(@NotNull TimeUnit timeUnit) {
    this.timeUnit = timeUnit;
    String str = this.timeUnit.toString();
    Intrinsics.checkNotNullExpressionValue(Locale.ROOT, "ROOT");
    Intrinsics.checkNotNullExpressionValue(str.toLowerCase(Locale.ROOT), "this as java.lang.String).toLowerCase(locale)");
    this.timeUnitString = StringsKt.removeSuffix(str.toLowerCase(Locale.ROOT), "s");
    ConcurrentHashMap<Object, Object> concurrentHashMap1 = new ConcurrentHashMap<>(), concurrentHashMap2 = concurrentHashMap1;
    RateLimiter rateLimiter = this;
    int $i$a$-also-RateLimiter$keyToRequestCount$1 = 0;
    RateLimitUtil.INSTANCE.getExecutor().scheduleAtFixedRate(concurrentHashMap2::keyToRequestCount$lambda-1$lambda-0, 0L, 1L, this.timeUnit);
    rateLimiter.keyToRequestCount = (ConcurrentHashMap)concurrentHashMap1;
  }
  
  @NotNull
  public final TimeUnit getTimeUnit() {
    return this.timeUnit;
  }
  
  private static final void keyToRequestCount$lambda-1$lambda-0(ConcurrentHashMap $it) {
    Intrinsics.checkNotNullParameter($it, "$it");
    $it.clear();
  }
  
  public final void incrementCounter(@NotNull Context ctx, int requestLimit) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'ctx'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield keyToRequestCount : Ljava/util/concurrent/ConcurrentHashMap;
    //   10: getstatic io/javalin/http/util/RateLimitUtil.INSTANCE : Lio/javalin/http/util/RateLimitUtil;
    //   13: invokevirtual getKeyFunction : ()Lkotlin/jvm/functions/Function1;
    //   16: aload_1
    //   17: invokeinterface invoke : (Ljava/lang/Object;)Ljava/lang/Object;
    //   22: iload_2
    //   23: aload_0
    //   24: <illegal opcode> apply : (ILio/javalin/http/util/RateLimiter;)Ljava/util/function/BiFunction;
    //   29: invokevirtual compute : (Ljava/lang/Object;Ljava/util/function/BiFunction;)Ljava/lang/Object;
    //   32: pop
    //   33: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #33	-> 6
    //   #40	-> 33
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	34	0	this	Lio/javalin/http/util/RateLimiter;
    //   0	34	1	ctx	Lio/javalin/http/Context;
    //   0	34	2	requestLimit	I
  }
  
  private static final Integer incrementCounter$lambda-2(int $requestLimit, RateLimiter this$0, String paramString, Integer count) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter(paramString, "<anonymous parameter 0>");
    if (count.intValue() < $requestLimit) {
    
    } else {
      throw new HttpResponseException(HttpStatus.TOO_MANY_REQUESTS, "Rate limit exceeded - Server allows " + $requestLimit + " requests per " + this$0.timeUnitString + ".", null, 4, null);
    } 
    return (count == null) ? Integer.valueOf(1) : (Integer)"JD-Core does not support Kotlin";
  }
}
