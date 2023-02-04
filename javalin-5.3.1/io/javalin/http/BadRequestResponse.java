package io.javalin.http;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\030\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020$\n\002\b\002\b\026\030\0002\0020\001B'\b\007\022\b\b\002\020\002\032\0020\003\022\024\b\002\020\004\032\016\022\004\022\0020\003\022\004\022\0020\0030\005¢\006\002\020\006¨\006\007"}, d2 = {"Lio/javalin/http/BadRequestResponse;", "Lio/javalin/http/HttpResponseException;", "message", "", "details", "", "(Ljava/lang/String;Ljava/util/Map;)V", "javalin"})
public class BadRequestResponse extends HttpResponseException {
  @JvmOverloads
  public BadRequestResponse() {
    this(null, null, 3, null);
  }
  
  @JvmOverloads
  public BadRequestResponse(@NotNull String message) {
    this(message, null, 2, null);
  }
  
  @JvmOverloads
  public BadRequestResponse(@NotNull String message, @NotNull Map<String, String> details) {
    super(HttpStatus.BAD_REQUEST, message, details);
  }
}
