package io.javalin.http;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\030\n\002\030\002\n\002\020\020\n\000\n\002\020\b\n\000\n\002\020\016\n\002\bG\b\001\030\000 K2\b\022\004\022\0020\0000\001:\001KB\027\b\002\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\b\020\013\032\0020\005H\026R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\007\020\bR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\t\020\nj\002\b\fj\002\b\rj\002\b\016j\002\b\017j\002\b\020j\002\b\021j\002\b\022j\002\b\023j\002\b\024j\002\b\025j\002\b\026j\002\b\027j\002\b\030j\002\b\031j\002\b\032j\002\b\033j\002\b\034j\002\b\035j\002\b\036j\002\b\037j\002\b j\002\b!j\002\b\"j\002\b#j\002\b$j\002\b%j\002\b&j\002\b'j\002\b(j\002\b)j\002\b*j\002\b+j\002\b,j\002\b-j\002\b.j\002\b/j\002\b0j\002\b1j\002\b2j\002\b3j\002\b4j\002\b5j\002\b6j\002\b7j\002\b8j\002\b9j\002\b:j\002\b;j\002\b<j\002\b=j\002\b>j\002\b?j\002\b@j\002\bAj\002\bBj\002\bCj\002\bDj\002\bEj\002\bFj\002\bGj\002\bHj\002\bIj\002\bJ¨\006L"}, d2 = {"Lio/javalin/http/HttpStatus;", "", "code", "", "message", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "toString", "CONTINUE", "SWITCHING_PROTOCOLS", "PROCESSING", "EARLY_HINTS", "OK", "CREATED", "ACCEPTED", "NON_AUTHORITATIVE_INFORMATION", "NO_CONTENT", "RESET_CONTENT", "PARTIAL_CONTENT", "MULTI_STATUS", "ALREADY_REPORTED", "IM_USED", "MULTIPLE_CHOICES", "MOVED_PERMANENTLY", "FOUND", "SEE_OTHER", "NOT_MODIFIED", "USE_PROXY", "TEMPORARY_REDIRECT", "PERMANENT_REDIRECT", "BAD_REQUEST", "UNAUTHORIZED", "PAYMENT_REQUIRED", "FORBIDDEN", "NOT_FOUND", "METHOD_NOT_ALLOWED", "NOT_ACCEPTABLE", "PROXY_AUTHENTICATION_REQUIRED", "REQUEST_TIMEOUT", "CONFLICT", "GONE", "LENGTH_REQUIRED", "PRECONDITION_FAILED", "CONTENT_TOO_LARGE", "URI_TOO_LONG", "UNSUPPORTED_MEDIA_TYPE", "RANGE_NOT_SATISFIABLE", "EXPECTATION_FAILED", "IM_A_TEAPOT", "ENHANCE_YOUR_CALM", "MISDIRECTED_REQUEST", "UNPROCESSABLE_CONTENT", "LOCKED", "FAILED_DEPENDENCY", "TOO_EARLY", "UPGRADE_REQUIRED", "PRECONDITION_REQUIRED", "TOO_MANY_REQUESTS", "REQUEST_HEADER_FIELDS_TOO_LARGE", "UNAVAILABLE_FOR_LEGAL_REASONS", "INTERNAL_SERVER_ERROR", "NOT_IMPLEMENTED", "BAD_GATEWAY", "SERVICE_UNAVAILABLE", "GATEWAY_TIMEOUT", "HTTP_VERSION_NOT_SUPPORTED", "INSUFFICIENT_STORAGE", "LOOP_DETECTED", "NOT_EXTENDED", "NETWORK_AUTHENTICATION_REQUIRED", "UNKNOWN", "Companion", "javalin"})
public enum HttpStatus {
  CONTINUE(100, "Continue"),
  SWITCHING_PROTOCOLS(101, "Switching Protocols"),
  PROCESSING(102, "Processing"),
  EARLY_HINTS(103, "Early Hints"),
  OK(200, "OK"),
  CREATED(201, "Created"),
  ACCEPTED(202, "Accepted"),
  NON_AUTHORITATIVE_INFORMATION(203, "Non Authoritative Information"),
  NO_CONTENT(204, "No Content"),
  RESET_CONTENT(205, "Reset Content"),
  PARTIAL_CONTENT(206, "Partial Content"),
  MULTI_STATUS(207, "Multi-Status"),
  ALREADY_REPORTED(208, "Already Reported"),
  IM_USED(226, "IM Used"),
  MULTIPLE_CHOICES(300, "Multiple Choices"),
  MOVED_PERMANENTLY(301, "Moved Permanently"),
  FOUND(302, "Found"),
  SEE_OTHER(303, "See Other"),
  NOT_MODIFIED(304, "Not Modified"),
  USE_PROXY(305, "Use Proxy"),
  TEMPORARY_REDIRECT(307, "Temporary Redirect"),
  PERMANENT_REDIRECT(308, "Permanent Redirect"),
  BAD_REQUEST(400, "Bad Request"),
  UNAUTHORIZED(401, "Unauthorized"),
  PAYMENT_REQUIRED(402, "Payment Required"),
  FORBIDDEN(403, "Forbidden"),
  NOT_FOUND(404, "Not Found"),
  METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
  NOT_ACCEPTABLE(406, "Not Acceptable"),
  PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
  REQUEST_TIMEOUT(408, "Request Timeout"),
  CONFLICT(409, "Conflict"),
  GONE(410, "Gone"),
  LENGTH_REQUIRED(411, "Length Required"),
  PRECONDITION_FAILED(412, "Precondition Failed"),
  CONTENT_TOO_LARGE(413, "Content Too Large"),
  URI_TOO_LONG(414, "URI Too Long"),
  UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
  RANGE_NOT_SATISFIABLE(416, "Range Not Satisfiable"),
  EXPECTATION_FAILED(417, "Expectation Failed"),
  IM_A_TEAPOT(418, "I'm a Teapot"),
  ENHANCE_YOUR_CALM(420, "Enhance your Calm"),
  MISDIRECTED_REQUEST(421, "Misdirected Request"),
  UNPROCESSABLE_CONTENT(422, "Unprocessable Content"),
  LOCKED(423, "Locked"),
  FAILED_DEPENDENCY(424, "Failed Dependency"),
  TOO_EARLY(425, "Too Early"),
  UPGRADE_REQUIRED(426, "Upgrade Required"),
  PRECONDITION_REQUIRED(428, "Precondition Required"),
  TOO_MANY_REQUESTS(429, "Too Many Requests"),
  REQUEST_HEADER_FIELDS_TOO_LARGE(431, "Request Header Fields Too Large"),
  UNAVAILABLE_FOR_LEGAL_REASONS(451, "Unavailable for Legal Reason"),
  INTERNAL_SERVER_ERROR(500, "Server Error"),
  NOT_IMPLEMENTED(501, "Not Implemented"),
  BAD_GATEWAY(502, "Bad Gateway"),
  SERVICE_UNAVAILABLE(503, "Service Unavailable"),
  GATEWAY_TIMEOUT(504, "Gateway Timeout"),
  HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported"),
  INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
  LOOP_DETECTED(508, "Loop Detected"),
  NOT_EXTENDED(
    510, "Not Extended"),
  NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required"),
  UNKNOWN(-1, "Unknown HTTP code");
  
  @NotNull
  public static final Companion Companion;
  
  private final int code;
  
  @NotNull
  private final String message;
  
  @NotNull
  private static final HttpStatus[] cachedValues;
  
  HttpStatus(int code, String message) {
    this.code = code;
    this.message = message;
  }
  
  public final int getCode() {
    return this.code;
  }
  
  @NotNull
  public final String getMessage() {
    return this.message;
  }
  
  static {
    Companion = new Companion(null);
    cachedValues = values();
  }
  
  @NotNull
  public String toString() {
    return "" + this.code + " " + this.code;
  }
  
  @JvmStatic
  @NotNull
  public static final HttpStatus forStatus(int status) {
    return Companion.forStatus(status);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\021\n\002\030\002\n\002\b\003\n\002\020\b\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\007\032\0020\0052\006\020\b\032\0020\tH\007R\026\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\004\n\002\020\006¨\006\n"}, d2 = {"Lio/javalin/http/HttpStatus$Companion;", "", "()V", "cachedValues", "", "Lio/javalin/http/HttpStatus;", "[Lio/javalin/http/HttpStatus;", "forStatus", "status", "", "javalin"})
  public static final class Companion {
    private Companion() {}
    
    @JvmStatic
    @NotNull
    public final HttpStatus forStatus(int status) {
      // Byte code:
      //   0: invokestatic access$getCachedValues$cp : ()[Lio/javalin/http/HttpStatus;
      //   3: astore_2
      //   4: iconst_0
      //   5: istore_3
      //   6: aload_2
      //   7: arraylength
      //   8: istore #4
      //   10: iload_3
      //   11: iload #4
      //   13: if_icmpge -> 56
      //   16: aload_2
      //   17: iload_3
      //   18: aaload
      //   19: astore #5
      //   21: aload #5
      //   23: astore #6
      //   25: iconst_0
      //   26: istore #7
      //   28: aload #6
      //   30: invokevirtual getCode : ()I
      //   33: iload_1
      //   34: if_icmpne -> 41
      //   37: iconst_1
      //   38: goto -> 42
      //   41: iconst_0
      //   42: ifeq -> 50
      //   45: aload #5
      //   47: goto -> 57
      //   50: iinc #3, 1
      //   53: goto -> 10
      //   56: aconst_null
      //   57: dup
      //   58: ifnonnull -> 65
      //   61: pop
      //   62: getstatic io/javalin/http/HttpStatus.UNKNOWN : Lio/javalin/http/HttpStatus;
      //   65: areturn
      // Line number table:
      //   Java source line number -> byte code offset
      //   #79	-> 0
      //   #84	-> 25
      //   #79	-> 28
      //   #79	-> 42
      //   #79	-> 57
      // Local variable table:
      //   start	length	slot	name	descriptor
      //   28	14	7	$i$a$-find-HttpStatus$Companion$forStatus$1	I
      //   25	17	6	it	Lio/javalin/http/HttpStatus;
      //   0	66	0	this	Lio/javalin/http/HttpStatus$Companion;
      //   0	66	1	status	I
    }
  }
}
