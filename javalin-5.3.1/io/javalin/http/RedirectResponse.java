package io.javalin.http;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020$\n\002\b\002\b\026\030\0002\0020\001B1\b\007\022\b\b\002\020\002\032\0020\003\022\b\b\002\020\004\032\0020\005\022\024\b\002\020\006\032\016\022\004\022\0020\005\022\004\022\0020\0050\007¢\006\002\020\b¨\006\t"}, d2 = {"Lio/javalin/http/RedirectResponse;", "Lio/javalin/http/HttpResponseException;", "status", "Lio/javalin/http/HttpStatus;", "message", "", "details", "", "(Lio/javalin/http/HttpStatus;Ljava/lang/String;Ljava/util/Map;)V", "javalin"})
public class RedirectResponse extends HttpResponseException {
  @JvmOverloads
  public RedirectResponse() {
    this(null, null, null, 7, null);
  }
  
  @JvmOverloads
  public RedirectResponse(@NotNull HttpStatus status) {
    this(status, null, null, 6, null);
  }
  
  @JvmOverloads
  public RedirectResponse(@NotNull HttpStatus status, @NotNull String message) {
    this(status, message, null, 4, null);
  }
  
  @JvmOverloads
  public RedirectResponse(@NotNull HttpStatus status, @NotNull String message, @NotNull Map<String, String> details) {
    super(status, message, details);
  }
}
