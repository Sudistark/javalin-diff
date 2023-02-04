package io.javalin.http.servlet;

import io.javalin.compression.CompressedOutputStream;
import io.javalin.compression.CompressionStrategy;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import io.javalin.http.HandlerType;
import io.javalin.http.HttpStatus;
import io.javalin.http.util.CookieStore;
import io.javalin.routing.HandlerEntry;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000¬\001\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020$\n\002\020\016\n\002\020\000\n\000\n\002\030\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\022\n\002\b\t\n\002\030\002\n\002\b\013\n\002\020 \n\002\b\b\n\002\030\002\n\002\b\026\n\002\020\007\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\030\0002\0020\001BÅ\001\022\006\020\002\032\0020\003\022\016\b\002\020\004\032\b\022\004\022\0020\0060\005\022\b\b\002\020\007\032\0020\b\022\b\b\002\020\t\032\0020\n\022\006\020\013\032\0020\f\022\006\020\r\032\0020\016\022\024\b\002\020\017\032\016\022\004\022\0020\021\022\004\022\0020\0220\020\022\b\b\002\020\023\032\0020\024\022\n\b\002\020\025\032\004\030\0010\026\022\b\b\002\020\027\032\0020\030\022\b\b\002\020\031\032\0020\021\022\024\b\002\020\032\032\016\022\004\022\0020\021\022\004\022\0020\0210\020\022\b\b\002\020\033\032\0020\021\022\026\b\002\020\034\032\020\022\n\b\001\022\006\022\002\b\0030\036\030\0010\035\022\n\b\002\020\037\032\004\030\0010 ¢\006\002\020!J\033\020R\032\002HS\"\004\b\000\020S2\006\020T\032\0020\021H\026¢\006\002\020UJ\b\020V\032\0020#H\026J\016\020W\032\0020\0002\006\020\013\032\0020\fJ\b\020(\032\0020\021H\026J\b\020,\032\0020-H\026J\b\020\033\032\0020\021H\026J\006\020X\032\0020YJ\032\020Z\032\024\022\004\022\0020\021\022\n\022\b\022\004\022\0020\021090\020H\026J\034\020[\032\0020\\2\022\020[\032\016\022\n\b\001\022\006\022\002\b\0030\0360\035H\026J\b\020\027\032\0020\030H\026J\b\020\031\032\0020\021H\026J\b\020=\032\0020\030H\026J\b\020]\032\0020^H\026J\020\020_\032\0020\0212\006\020T\032\0020\021H\026J\024\020\032\032\016\022\004\022\0020\021\022\004\022\0020\0210\020H\026J\032\020`\032\024\022\004\022\0020\021\022\n\022\b\022\004\022\0020\021090\020H\026J\030\020a\032\0020\\2\006\020b\032\0020\0212\006\020c\032\0020dH\026J\b\020\013\032\0020\fH\026J\b\020\r\032\0020\016H\026J\020\020e\032\0020\0012\006\020\037\032\0020 H\026J\n\020f\032\004\030\0010 H\026J\026\020g\032\0020\0002\006\020h\032\0020i2\006\020j\032\0020\021R\032\020\017\032\016\022\004\022\0020\021\022\004\022\0020\0220\020X\004¢\006\002\n\000R\033\020\"\032\0020#8BX\002¢\006\f\n\004\b&\020'\032\004\b$\020%R\033\020(\032\0020\0218BX\002¢\006\f\n\004\b+\020'\032\004\b)\020*R\016\020\023\032\0020\024X\004¢\006\002\n\000R\033\020,\032\0020-8BX\002¢\006\f\n\004\b0\020'\032\004\b.\020/R\032\020\033\032\0020\021X\016¢\006\016\n\000\032\004\b1\020*\"\004\b2\0203R\032\020\007\032\0020\bX\016¢\006\016\n\000\032\004\b4\0205\"\004\b6\0207R-\0208\032\024\022\004\022\0020\021\022\n\022\b\022\004\022\0020\021090\0208BX\002¢\006\f\n\004\b<\020'\032\004\b:\020;R\016\020\027\032\0020\030X\016¢\006\002\n\000R\016\020\031\032\0020\021X\016¢\006\002\n\000R\033\020=\032\0020\0308BX\002¢\006\f\n\004\b@\020'\032\004\b>\020?R\033\020A\032\0020B8@X\002¢\006\f\n\004\bE\020'\032\004\bC\020DR\032\020\032\032\016\022\004\022\0020\021\022\004\022\0020\0210\020X\016¢\006\002\n\000R-\020F\032\024\022\004\022\0020\021\022\n\022\b\022\004\022\0020\021090\0208BX\002¢\006\f\n\004\bH\020'\032\004\bG\020;R\016\020\013\032\0020\fX\016¢\006\002\n\000R\016\020\r\032\0020\016X\004¢\006\002\n\000R\021\020\t\032\0020\n¢\006\b\n\000\032\004\bI\020JR\020\020\037\032\004\030\0010 X\016¢\006\002\n\000R\022\020\025\032\004\030\0010\026X\004¢\006\004\n\002\020KR\027\020\004\032\b\022\004\022\0020\0060\005¢\006\b\n\000\032\004\bL\020MR(\020\034\032\020\022\n\b\001\022\006\022\002\b\0030\036\030\0010\035X\016¢\006\016\n\000\032\004\bN\020O\"\004\bP\020Q¨\006k"}, d2 = {"Lio/javalin/http/servlet/JavalinServletContext;", "Lio/javalin/http/Context;", "cfg", "Lio/javalin/config/JavalinConfig;", "tasks", "Ljava/util/Deque;", "Lio/javalin/http/servlet/Task;", "exceptionOccurred", "", "responseWritten", "Ljava/util/concurrent/atomic/AtomicBoolean;", "req", "Ljakarta/servlet/http/HttpServletRequest;", "res", "Ljakarta/servlet/http/HttpServletResponse;", "appAttributes", "", "", "", "compressionStrategy", "Lio/javalin/compression/CompressionStrategy;", "startTimeNanos", "", "handlerType", "Lio/javalin/http/HandlerType;", "matchedPath", "pathParamMap", "endpointHandlerPath", "userFutureSupplier", "Ljava/util/function/Supplier;", "Ljava/util/concurrent/CompletableFuture;", "resultStream", "Ljava/io/InputStream;", "(Lio/javalin/config/JavalinConfig;Ljava/util/Deque;ZLjava/util/concurrent/atomic/AtomicBoolean;Ljakarta/servlet/http/HttpServletRequest;Ljakarta/servlet/http/HttpServletResponse;Ljava/util/Map;Lio/javalin/compression/CompressionStrategy;Ljava/lang/Long;Lio/javalin/http/HandlerType;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/function/Supplier;Ljava/io/InputStream;)V", "body", "", "getBody", "()[B", "body$delegate", "Lkotlin/Lazy;", "characterEncoding", "getCharacterEncoding", "()Ljava/lang/String;", "characterEncoding$delegate", "cookieStore", "Lio/javalin/http/util/CookieStore;", "getCookieStore", "()Lio/javalin/http/util/CookieStore;", "cookieStore$delegate", "getEndpointHandlerPath$javalin", "setEndpointHandlerPath$javalin", "(Ljava/lang/String;)V", "getExceptionOccurred", "()Z", "setExceptionOccurred", "(Z)V", "formParams", "", "getFormParams", "()Ljava/util/Map;", "formParams$delegate", "method", "getMethod", "()Lio/javalin/http/HandlerType;", "method$delegate", "outputStreamWrapper", "Lio/javalin/compression/CompressedOutputStream;", "getOutputStreamWrapper$javalin", "()Lio/javalin/compression/CompressedOutputStream;", "outputStreamWrapper$delegate", "queryParams", "getQueryParams", "queryParams$delegate", "getResponseWritten", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/lang/Long;", "getTasks", "()Ljava/util/Deque;", "getUserFutureSupplier$javalin", "()Ljava/util/function/Supplier;", "setUserFutureSupplier$javalin", "(Ljava/util/function/Supplier;)V", "appAttribute", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "bodyAsBytes", "changeBaseRequest", "executionTimeMs", "", "formParamMap", "future", "", "outputStream", "Ljakarta/servlet/ServletOutputStream;", "pathParam", "queryParamMap", "redirect", "location", "status", "Lio/javalin/http/HttpStatus;", "result", "resultInputStream", "update", "handlerEntry", "Lio/javalin/routing/HandlerEntry;", "requestUri", "javalin"})
public final class JavalinServletContext implements Context {
  @NotNull
  private final Deque<Task> tasks;
  
  private boolean exceptionOccurred;
  
  @NotNull
  private final AtomicBoolean responseWritten;
  
  @NotNull
  private HttpServletRequest req;
  
  @NotNull
  private final HttpServletResponse res;
  
  @NotNull
  private final Map<String, Object> appAttributes;
  
  @NotNull
  private final CompressionStrategy compressionStrategy;
  
  @Nullable
  private final Long startTimeNanos;
  
  @NotNull
  private HandlerType handlerType;
  
  @NotNull
  private String matchedPath;
  
  @NotNull
  private Map<String, String> pathParamMap;
  
  @NotNull
  private String endpointHandlerPath;
  
  @Nullable
  private Supplier<? extends CompletableFuture<?>> userFutureSupplier;
  
  @Nullable
  private InputStream resultStream;
  
  @NotNull
  private final Lazy characterEncoding$delegate;
  
  @NotNull
  private final Lazy cookieStore$delegate;
  
  @NotNull
  private final Lazy method$delegate;
  
  @NotNull
  private final Lazy body$delegate;
  
  @NotNull
  private final Lazy formParams$delegate;
  
  @NotNull
  private final Lazy queryParams$delegate;
  
  @NotNull
  private final Lazy outputStreamWrapper$delegate;
  
  public JavalinServletContext(@NotNull JavalinConfig cfg, @NotNull Deque<Task> tasks, boolean exceptionOccurred, @NotNull AtomicBoolean responseWritten, @NotNull HttpServletRequest req, @NotNull HttpServletResponse res, @NotNull Map<String, Object> appAttributes, @NotNull CompressionStrategy compressionStrategy, @Nullable Long startTimeNanos, @NotNull HandlerType handlerType, @NotNull String matchedPath, @NotNull Map<String, String> pathParamMap, @NotNull String endpointHandlerPath, @Nullable Supplier<? extends CompletableFuture<?>> userFutureSupplier, @Nullable InputStream resultStream) {
    this.tasks = tasks;
    this.exceptionOccurred = exceptionOccurred;
    this.responseWritten = responseWritten;
    this.req = req;
    this.res = res;
    this.appAttributes = appAttributes;
    this.compressionStrategy = compressionStrategy;
    this.startTimeNanos = startTimeNanos;
    this.handlerType = handlerType;
    this.matchedPath = matchedPath;
    this.pathParamMap = pathParamMap;
    this.endpointHandlerPath = endpointHandlerPath;
    this.userFutureSupplier = userFutureSupplier;
    this.resultStream = resultStream;
    contentType(cfg.http.defaultContentType);
    this.characterEncoding$delegate = LazyKt.lazy(new JavalinServletContext$characterEncoding$2());
    this.cookieStore$delegate = LazyKt.lazy(new JavalinServletContext$cookieStore$2());
    this.method$delegate = LazyKt.lazy(new JavalinServletContext$method$2());
    this.body$delegate = LazyKt.lazy(new JavalinServletContext$body$2());
    this.formParams$delegate = LazyKt.lazy(new JavalinServletContext$formParams$2());
    this.queryParams$delegate = LazyKt.lazy(new JavalinServletContext$queryParams$2());
    this.outputStreamWrapper$delegate = LazyKt.lazy(new JavalinServletContext$outputStreamWrapper$2());
  }
  
  @NotNull
  public final Deque<Task> getTasks() {
    return this.tasks;
  }
  
  public final boolean getExceptionOccurred() {
    return this.exceptionOccurred;
  }
  
  public final void setExceptionOccurred(boolean <set-?>) {
    this.exceptionOccurred = <set-?>;
  }
  
  @NotNull
  public final AtomicBoolean getResponseWritten() {
    return this.responseWritten;
  }
  
  @NotNull
  public final String getEndpointHandlerPath$javalin() {
    return this.endpointHandlerPath;
  }
  
  public final void setEndpointHandlerPath$javalin(@NotNull String <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    this.endpointHandlerPath = <set-?>;
  }
  
  @Nullable
  public final Supplier<? extends CompletableFuture<?>> getUserFutureSupplier$javalin() {
    return this.userFutureSupplier;
  }
  
  public final void setUserFutureSupplier$javalin(@Nullable Supplier<? extends CompletableFuture<?>> <set-?>) {
    this.userFutureSupplier = <set-?>;
  }
  
  public final float executionTimeMs() {
    return (this.startTimeNanos == null) ? -1.0F : ((float)(System.nanoTime() - this.startTimeNanos.longValue()) / 1000000.0F);
  }
  
  @NotNull
  public final JavalinServletContext changeBaseRequest(@NotNull HttpServletRequest req) {
    Intrinsics.checkNotNullParameter(req, "req");
    JavalinServletContext javalinServletContext1 = this, it = javalinServletContext1;
    int $i$a$-also-JavalinServletContext$changeBaseRequest$1 = 0;
    this.req = req;
    return javalinServletContext1;
  }
  
  @NotNull
  public final JavalinServletContext update(@NotNull HandlerEntry handlerEntry, @NotNull String requestUri) {
    Intrinsics.checkNotNullParameter(handlerEntry, "handlerEntry");
    Intrinsics.checkNotNullParameter(requestUri, "requestUri");
    JavalinServletContext javalinServletContext1 = this, it = javalinServletContext1;
    int $i$a$-also-JavalinServletContext$update$1 = 0;
    this.handlerType = handlerEntry.getType();
    if (!Intrinsics.areEqual(this.matchedPath, handlerEntry.getPath())) {
      this.matchedPath = handlerEntry.getPath();
      this.pathParamMap = handlerEntry.extractPathParams(requestUri);
    } 
    if (this.handlerType != HandlerType.AFTER)
      this.endpointHandlerPath = handlerEntry.getPath(); 
    return javalinServletContext1;
  }
  
  @NotNull
  public HttpServletRequest req() {
    return this.req;
  }
  
  @NotNull
  public HttpServletResponse res() {
    return this.res;
  }
  
  public <T> T appAttribute(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return (T)this.appAttributes.get(key);
  }
  
  @NotNull
  public String endpointHandlerPath() {
    // Byte code:
    //   0: nop
    //   1: aload_0
    //   2: invokevirtual handlerType : ()Lio/javalin/http/HandlerType;
    //   5: getstatic io/javalin/http/HandlerType.BEFORE : Lio/javalin/http/HandlerType;
    //   8: if_acmpeq -> 18
    //   11: aload_0
    //   12: getfield endpointHandlerPath : Ljava/lang/String;
    //   15: goto -> 29
    //   18: new java/lang/IllegalStateException
    //   21: dup
    //   22: ldc_w 'Cannot access the endpoint handler path in a 'BEFORE' handler'
    //   25: invokespecial <init> : (Ljava/lang/String;)V
    //   28: athrow
    //   29: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #79	-> 0
    //   #80	-> 1
    //   #81	-> 18
    //   #82	-> 29
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   0	30	0	this	Lio/javalin/http/servlet/JavalinServletContext;
  }
  
  private final String getCharacterEncoding() {
    Lazy lazy = this.characterEncoding$delegate;
    return (String)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\020\016\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
  static final class JavalinServletContext$characterEncoding$2 extends Lambda implements Function0<String> {
    JavalinServletContext$characterEncoding$2() {
      super(0);
    }
    
    @NotNull
    public final String invoke() {
      if (JavalinServletContext.this.characterEncoding() == null)
        JavalinServletContext.this.characterEncoding(); 
      return "UTF-8";
    }
  }
  
  @NotNull
  public String characterEncoding() {
    return getCharacterEncoding();
  }
  
  private final CookieStore getCookieStore() {
    Lazy lazy = this.cookieStore$delegate;
    return (CookieStore)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Lio/javalin/http/util/CookieStore;", "invoke"})
  static final class JavalinServletContext$cookieStore$2 extends Lambda implements Function0<CookieStore> {
    JavalinServletContext$cookieStore$2() {
      super(0);
    }
    
    @NotNull
    public final CookieStore invoke() {
      return JavalinServletContext.this.cookieStore();
    }
  }
  
  @NotNull
  public CookieStore cookieStore() {
    return getCookieStore();
  }
  
  private final HandlerType getMethod() {
    Lazy lazy = this.method$delegate;
    return (HandlerType)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Lio/javalin/http/HandlerType;", "invoke"})
  static final class JavalinServletContext$method$2 extends Lambda implements Function0<HandlerType> {
    JavalinServletContext$method$2() {
      super(0);
    }
    
    @NotNull
    public final HandlerType invoke() {
      return JavalinServletContext.this.method();
    }
  }
  
  @NotNull
  public HandlerType method() {
    return getMethod();
  }
  
  @NotNull
  public HandlerType handlerType() {
    return this.handlerType;
  }
  
  @NotNull
  public String matchedPath() {
    return this.matchedPath;
  }
  
  private final byte[] getBody() {
    Lazy lazy = this.body$delegate;
    return (byte[])lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\020\022\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "", "invoke"})
  static final class JavalinServletContext$body$2 extends Lambda implements Function0<byte[]> {
    JavalinServletContext$body$2() {
      super(0);
    }
    
    @NotNull
    public final byte[] invoke() {
      return JavalinServletContext.this.bodyAsBytes();
    }
  }
  
  @NotNull
  public byte[] bodyAsBytes() {
    return getBody();
  }
  
  private final Map<String, List<String>> getFormParams() {
    Lazy lazy = this.formParams$delegate;
    return (Map<String, List<String>>)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\020\n\000\n\002\020$\n\002\020\016\n\002\020 \n\000\020\000\032\024\022\004\022\0020\002\022\n\022\b\022\004\022\0020\0020\0030\001H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "", "", "invoke"})
  static final class JavalinServletContext$formParams$2 extends Lambda implements Function0<Map<String, ? extends List<? extends String>>> {
    JavalinServletContext$formParams$2() {
      super(0);
    }
    
    @NotNull
    public final Map<String, List<String>> invoke() {
      return JavalinServletContext.this.formParamMap();
    }
  }
  
  @NotNull
  public Map<String, List<String>> formParamMap() {
    return getFormParams();
  }
  
  @NotNull
  public Map<String, String> pathParamMap() {
    Intrinsics.checkNotNullExpressionValue(Collections.unmodifiableMap(this.pathParamMap), "unmodifiableMap(pathParamMap)");
    return Collections.unmodifiableMap(this.pathParamMap);
  }
  
  @NotNull
  public String pathParam(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return JavalinServletContextKt.pathParamOrThrow(this.pathParamMap, key, this.matchedPath);
  }
  
  private final Map<String, List<String>> getQueryParams() {
    Lazy lazy = this.queryParams$delegate;
    return (Map<String, List<String>>)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\020\n\000\n\002\020$\n\002\020\016\n\002\020 \n\000\020\000\032\024\022\004\022\0020\002\022\n\022\b\022\004\022\0020\0020\0030\001H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "", "", "invoke"})
  static final class JavalinServletContext$queryParams$2 extends Lambda implements Function0<Map<String, ? extends List<? extends String>>> {
    JavalinServletContext$queryParams$2() {
      super(0);
    }
    
    @NotNull
    public final Map<String, List<String>> invoke() {
      return JavalinServletContext.this.queryParamMap();
    }
  }
  
  @NotNull
  public Map<String, List<String>> queryParamMap() {
    return getQueryParams();
  }
  
  @NotNull
  public final CompressedOutputStream getOutputStreamWrapper$javalin() {
    Lazy lazy = this.outputStreamWrapper$delegate;
    return (CompressedOutputStream)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Lio/javalin/compression/CompressedOutputStream;", "invoke"})
  static final class JavalinServletContext$outputStreamWrapper$2 extends Lambda implements Function0<CompressedOutputStream> {
    JavalinServletContext$outputStreamWrapper$2() {
      super(0);
    }
    
    @NotNull
    public final CompressedOutputStream invoke() {
      return new CompressedOutputStream(JavalinServletContext.this.compressionStrategy, JavalinServletContext.this);
    }
  }
  
  @NotNull
  public ServletOutputStream outputStream() {
    return getOutputStreamWrapper$javalin();
  }
  
  public void redirect(@NotNull String location, @NotNull HttpStatus status) {
    Intrinsics.checkNotNullParameter(location, "location");
    Intrinsics.checkNotNullParameter(status, "status");
    header("Location", location).status(status).result("Redirected");
    if (handlerType() == HandlerType.BEFORE)
      this.tasks.removeIf(JavalinServletContext::redirect$lambda-2); 
  }
  
  private static final boolean redirect$lambda-2(Task it) {
    return it.getSkipIfExceptionOccurred();
  }
  
  @NotNull
  public Context result(@NotNull InputStream resultStream) {
    Intrinsics.checkNotNullParameter(resultStream, "resultStream");
    JavalinServletContext javalinServletContext1 = this, $this$result_u24lambda_u2d4 = javalinServletContext1;
    int $i$a$-apply-JavalinServletContext$result$1 = 0;
    JavalinServletContext javalinServletContext2 = $this$result_u24lambda_u2d4;
    try {
      JavalinServletContext $this$result_u24lambda_u2d4_u24lambda_u2d3 = javalinServletContext2;
      int $i$a$-runCatching-JavalinServletContext$result$1$1 = 0;
      $this$result_u24lambda_u2d4_u24lambda_u2d3.resultStream.close();
      Object object = Result.constructor-impl(($this$result_u24lambda_u2d4_u24lambda_u2d3.resultStream != null) ? Unit.INSTANCE : null);
    } catch (Throwable throwable) {
      Object object = Result.constructor-impl(ResultKt.createFailure(throwable));
    } 
    $this$result_u24lambda_u2d4.resultStream = resultStream;
    return javalinServletContext1;
  }
  
  @Nullable
  public InputStream resultInputStream() {
    return this.resultStream;
  }
  
  public void future(@NotNull Supplier<? extends CompletableFuture<?>> future) {
    Intrinsics.checkNotNullParameter(future, "future");
    if (this.userFutureSupplier != null)
      throw new IllegalStateException("Cannot override future from the same handler"); 
    this.userFutureSupplier = future;
  }
}
