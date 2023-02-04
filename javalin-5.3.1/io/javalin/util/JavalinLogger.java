package io.javalin.util;

import io.javalin.Javalin;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000.\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\016\n\000\n\002\020\003\n\002\b\005\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\034\020\b\032\0020\t2\006\020\n\032\0020\0132\n\b\002\020\f\032\004\030\0010\rH\007J\034\020\016\032\0020\t2\006\020\n\032\0020\0132\n\b\002\020\f\032\004\030\0010\rH\007J\034\020\017\032\0020\t2\006\020\n\032\0020\0132\n\b\002\020\f\032\004\030\0010\rH\007J\020\020\020\032\0020\t2\006\020\n\032\0020\013H\007J\034\020\021\032\0020\t2\006\020\n\032\0020\0132\n\b\002\020\f\032\004\030\0010\rH\007R\022\020\003\032\0020\0048\006@\006X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\022\020\007\032\0020\0048\006@\006X\016¢\006\002\n\000¨\006\022"}, d2 = {"Lio/javalin/util/JavalinLogger;", "", "()V", "enabled", "", "log", "Lorg/slf4j/Logger;", "startupInfo", "debug", "", "message", "", "throwable", "", "error", "info", "startup", "warn", "javalin"})
public final class JavalinLogger {
  @NotNull
  public static final JavalinLogger INSTANCE = new JavalinLogger();
  
  @NotNull
  private static final Logger log = LoggerFactory.getLogger(Javalin.class);
  
  static {
    Intrinsics.checkNotNull(LoggerFactory.getLogger(Javalin.class));
  }
  
  @JvmField
  public static boolean enabled = true;
  
  @JvmField
  public static boolean startupInfo = true;
  
  @JvmStatic
  public static final void startup(@NotNull String message) {
    Intrinsics.checkNotNullParameter(message, "message");
    if (!enabled)
      return; 
    if (startupInfo)
      log.info(message); 
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void info(@NotNull String message, @Nullable Throwable throwable) {
    Intrinsics.checkNotNullParameter(message, "message");
    if (!enabled)
      return; 
    if (throwable != null) {
      log.info(message, throwable);
    } else {
      log.info(message);
    } 
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void warn(@NotNull String message, @Nullable Throwable throwable) {
    Intrinsics.checkNotNullParameter(message, "message");
    if (!enabled)
      return; 
    if (throwable != null) {
      log.warn(message, throwable);
    } else {
      log.warn(message);
    } 
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void error(@NotNull String message, @Nullable Throwable throwable) {
    Intrinsics.checkNotNullParameter(message, "message");
    if (!enabled)
      return; 
    if (throwable != null) {
      log.error(message, throwable);
    } else {
      log.error(message);
    } 
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void debug(@NotNull String message, @Nullable Throwable throwable) {
    Intrinsics.checkNotNullParameter(message, "message");
    if (!enabled)
      return; 
    if (throwable != null) {
      log.debug(message, throwable);
    } else {
      log.debug(message);
    } 
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void info(@NotNull String message) {
    Intrinsics.checkNotNullParameter(message, "message");
    info$default(message, null, 2, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void warn(@NotNull String message) {
    Intrinsics.checkNotNullParameter(message, "message");
    warn$default(message, null, 2, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void error(@NotNull String message) {
    Intrinsics.checkNotNullParameter(message, "message");
    error$default(message, null, 2, null);
  }
  
  @JvmStatic
  @JvmOverloads
  public static final void debug(@NotNull String message) {
    Intrinsics.checkNotNullParameter(message, "message");
    debug$default(message, null, 2, null);
  }
}
