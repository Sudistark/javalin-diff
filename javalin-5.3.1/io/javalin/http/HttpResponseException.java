package io.javalin.http;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000(\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020$\n\000\n\002\020\b\n\002\b\006\b\026\030\0002\0060\001j\002`\002B/\b\026\022\006\020\003\032\0020\004\022\b\b\002\020\005\032\0020\006\022\024\b\002\020\007\032\016\022\004\022\0020\006\022\004\022\0020\0060\b¢\006\002\020\tB/\b\007\022\006\020\003\032\0020\n\022\b\b\002\020\005\032\0020\006\022\024\b\002\020\007\032\016\022\004\022\0020\006\022\004\022\0020\0060\b¢\006\002\020\013R\035\020\007\032\016\022\004\022\0020\006\022\004\022\0020\0060\b¢\006\b\n\000\032\004\b\f\020\rR\021\020\003\032\0020\n¢\006\b\n\000\032\004\b\016\020\017¨\006\020"}, d2 = {"Lio/javalin/http/HttpResponseException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "status", "Lio/javalin/http/HttpStatus;", "message", "", "details", "", "(Lio/javalin/http/HttpStatus;Ljava/lang/String;Ljava/util/Map;)V", "", "(ILjava/lang/String;Ljava/util/Map;)V", "getDetails", "()Ljava/util/Map;", "getStatus", "()I", "javalin"})
public class HttpResponseException extends RuntimeException {
  private final int status;
  
  @NotNull
  private final Map<String, String> details;
  
  public final int getStatus() {
    return this.status;
  }
  
  @NotNull
  public final Map<String, String> getDetails() {
    return this.details;
  }
  
  @JvmOverloads
  public HttpResponseException(int status, @NotNull String message, @NotNull Map<String, String> details) {
    super(message);
    this.status = status;
    this.details = details;
  }
  
  public HttpResponseException(@NotNull HttpStatus status, @NotNull String message, @NotNull Map<String, String> details) {
    this(status.getCode(), message, details);
  }
  
  @JvmOverloads
  public HttpResponseException(int status, @NotNull String message) {
    this(status, message, (Map)null, 4, (DefaultConstructorMarker)null);
  }
  
  @JvmOverloads
  public HttpResponseException(int status) {
    this(status, (String)null, (Map)null, 6, (DefaultConstructorMarker)null);
  }
}
