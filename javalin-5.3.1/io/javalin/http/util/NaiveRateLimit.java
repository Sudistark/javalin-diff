package io.javalin.http.util;

import io.javalin.http.Context;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000$\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J \020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\nH\007¨\006\013"}, d2 = {"Lio/javalin/http/util/NaiveRateLimit;", "", "()V", "requestPerTimeUnit", "", "ctx", "Lio/javalin/http/Context;", "numRequests", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "javalin"})
public final class NaiveRateLimit {
  @NotNull
  public static final NaiveRateLimit INSTANCE = new NaiveRateLimit();
  
  @JvmStatic
  public static final void requestPerTimeUnit(@NotNull Context ctx, int numRequests, @NotNull TimeUnit timeUnit) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
    ((RateLimiter)RateLimitUtil.INSTANCE.getLimiters().computeIfAbsent(timeUnit, timeUnit::requestPerTimeUnit$lambda-0)).incrementCounter(ctx, numRequests);
  }
  
  private static final RateLimiter requestPerTimeUnit$lambda-0(TimeUnit $timeUnit, TimeUnit it) {
    Intrinsics.checkNotNullParameter($timeUnit, "$timeUnit");
    Intrinsics.checkNotNullParameter(it, "it");
    return new RateLimiter($timeUnit);
  }
}
