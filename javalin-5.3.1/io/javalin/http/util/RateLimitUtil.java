package io.javalin.http.util;

import io.javalin.http.Context;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0004\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\002\020\016\n\002\b\005\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\005\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\025\032\0020\n2\006\020\026\032\0020\tH\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R&\020\007\032\016\022\004\022\0020\t\022\004\022\0020\n0\bX\016¢\006\016\n\000\032\004\b\013\020\f\"\004\b\r\020\016R\035\020\017\032\016\022\004\022\0020\021\022\004\022\0020\0220\020¢\006\b\n\000\032\004\b\023\020\024¨\006\027"}, d2 = {"Lio/javalin/http/util/RateLimitUtil;", "", "()V", "executor", "Ljava/util/concurrent/ScheduledExecutorService;", "getExecutor", "()Ljava/util/concurrent/ScheduledExecutorService;", "keyFunction", "Lkotlin/Function1;", "Lio/javalin/http/Context;", "", "getKeyFunction", "()Lkotlin/jvm/functions/Function1;", "setKeyFunction", "(Lkotlin/jvm/functions/Function1;)V", "limiters", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/TimeUnit;", "Lio/javalin/http/util/RateLimiter;", "getLimiters", "()Ljava/util/concurrent/ConcurrentHashMap;", "ip", "ctx", "javalin"})
public final class RateLimitUtil {
  @NotNull
  public static final RateLimitUtil INSTANCE = new RateLimitUtil();
  
  @NotNull
  private static final ConcurrentHashMap<TimeUnit, RateLimiter> limiters = new ConcurrentHashMap<>();
  
  @NotNull
  public final ConcurrentHashMap<TimeUnit, RateLimiter> getLimiters() {
    return limiters;
  }
  
  @NotNull
  private static Function1<? super Context, String> keyFunction = RateLimitUtil$keyFunction$1.INSTANCE;
  
  @NotNull
  public final Function1<Context, String> getKeyFunction() {
    return (Function1)keyFunction;
  }
  
  public final void setKeyFunction(@NotNull Function1<? super Context, String> <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    keyFunction = <set-?>;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\016\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/http/Context;", "invoke"})
  static final class RateLimitUtil$keyFunction$1 extends Lambda implements Function1<Context, String> {
    public static final RateLimitUtil$keyFunction$1 INSTANCE = new RateLimitUtil$keyFunction$1();
    
    RateLimitUtil$keyFunction$1() {
      super(1);
    }
    
    @NotNull
    public final String invoke(@NotNull Context it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return RateLimitUtil.INSTANCE.ip(it) + RateLimitUtil.INSTANCE.ip(it) + it.method();
    }
  }
  
  @NotNull
  private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
  
  @NotNull
  public final ScheduledExecutorService getExecutor() {
    return executor;
  }
  
  static {
    Intrinsics.checkNotNullExpressionValue(Executors.newSingleThreadScheduledExecutor(), "newSingleThreadScheduledExecutor()");
  }
  
  private final String ip(Context ctx) {
    if (ctx.header("X-Forwarded-For") != null) {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = ",";
      if (StringsKt.split$default(ctx.header("X-Forwarded-For"), arrayOfString, false, 0, 6, null) == null || (String)StringsKt.split$default(ctx.header("X-Forwarded-For"), arrayOfString, false, 0, 6, null).get(0) == null) {
        (String)StringsKt.split$default(ctx.header("X-Forwarded-For"), arrayOfString, false, 0, 6, null).get(0);
        return ctx.ip();
      } 
      return StringsKt.split$default(ctx.header("X-Forwarded-For"), arrayOfString, false, 0, 6, null).get(0);
    } 
    (String)StringsKt.split$default(ctx.header("X-Forwarded-For"), arrayOfString, false, 0, 6, null).get(0);
    return ctx.ip();
  }
}
