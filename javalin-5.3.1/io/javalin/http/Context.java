package io.javalin.http;

import io.javalin.config.ContextResolverConfigKt;
import io.javalin.http.servlet.JavalinServletContextKt;
import io.javalin.http.util.AsyncUtil;
import io.javalin.http.util.CookieStore;
import io.javalin.http.util.MultipartUtil;
import io.javalin.http.util.SeekableWriter;
import io.javalin.json.JsonMapperKt;
import io.javalin.rendering.FileRendererKt;
import io.javalin.security.BasicAuthCredentials;
import io.javalin.util.function.ThrowingRunnable;
import io.javalin.validation.BodyValidator;
import io.javalin.validation.Validator;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000î\001\n\002\030\002\n\002\020\000\n\002\b\003\n\002\020\016\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\003\n\002\020$\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\020\022\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\005\n\002\020\b\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020 \n\002\b\003\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\020\013\n\002\b\007\n\002\030\002\n\002\b\016\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\n\n\002\030\002\n\002\b\t\bf\030\0002\0020\001J\033\020\002\032\002H\003\"\004\b\000\020\0032\006\020\004\032\0020\005H&¢\006\002\020\006J\032\020\007\032\0020\b2\020\020\t\032\f\022\b\022\0060\013j\002`\f0\nH\026J:\020\007\032\0020\b2\n\b\002\020\r\032\004\030\0010\0162\b\b\002\020\017\032\0020\0202\b\020\021\032\004\030\0010\0222\020\020\t\032\f\022\b\022\0060\013j\002`\f0\nH\026J.\020\007\032\0020\b2\006\020\017\032\0020\0202\n\b\002\020\021\032\004\030\0010\0222\020\020\t\032\f\022\b\022\0060\013j\002`\f0\nH\026J\035\020\023\032\004\030\001H\003\"\004\b\000\020\0032\006\020\004\032\0020\005H\026¢\006\002\020\006J\032\020\023\032\0020\b2\006\020\004\032\0020\0052\b\020\024\032\004\030\0010\001H\026J\026\020\025\032\020\022\004\022\0020\005\022\006\022\004\030\0010\0010\026H\026J1\020\027\032\004\030\001H\003\"\004\b\000\020\0032\006\020\004\032\0020\0052\022\020\030\032\016\022\004\022\0020\000\022\004\022\002H\0030\031H\026¢\006\002\020\032J\n\020\033\032\004\030\0010\034H\026J\b\020\035\032\0020\005H\026J\b\020\036\032\0020\037H\026J!\020 \032\002H\003\"\004\b\000\020\0032\f\020!\032\b\022\004\022\002H\0030\"H\026¢\006\002\020#J\033\020 \032\002H\003\"\004\b\000\020\0032\006\020$\032\0020%H\026¢\006\002\020&J\b\020'\032\0020(H\026J\033\020)\032\002H\003\"\004\b\000\020\0032\006\020$\032\0020%H\026¢\006\002\020&J\"\020*\032\b\022\004\022\002H\0030+\"\004\b\000\020\0032\f\020!\032\b\022\004\022\002H\0030\"H\026J\035\020,\032\004\030\001H\003\"\004\b\000\020\0032\006\020\004\032\0020\005H\026¢\006\002\020\006J\032\020,\032\0020\b2\006\020\004\032\0020\0052\b\020\024\032\004\030\0010\001H\026J1\020-\032\004\030\001H\003\"\004\b\000\020\0032\006\020\004\032\0020\0052\022\020\030\032\016\022\004\022\0020\000\022\004\022\002H\0030\031H\026¢\006\002\020\032J\n\020.\032\004\030\0010\005H\026J\035\020/\032\004\030\001H\003\"\004\b\000\020\0032\006\020\004\032\0020\005H\026¢\006\002\020\006J\b\0200\032\00201H\026J\n\0202\032\004\030\0010\005H\026J\020\0202\032\0020\0002\006\0202\032\00203H\026J\020\0202\032\0020\0002\006\0202\032\0020\005H\026J\b\0204\032\0020\005H\026J\020\0205\032\0020\0002\006\0205\032\00206H\026J\022\0205\032\004\030\0010\0052\006\0207\032\0020\005H\026J\030\0205\032\0020\0002\006\0207\032\0020\0052\006\020\024\032\0020\005H\026J \0205\032\0020\0002\006\0207\032\0020\0052\006\020\024\032\0020\0052\006\0208\032\00201H\026J\024\0209\032\016\022\004\022\0020\005\022\004\022\0020\0050\026H\026J\b\020:\032\0020;H\026J\b\020<\032\0020\005H&J\022\020=\032\004\030\0010\0052\006\020\004\032\0020\005H\026J*\020>\032\b\022\004\022\002H\0030?\"\004\b\000\020\0032\006\020\004\032\0020\0052\f\020!\032\b\022\004\022\002H\0030\"H\026J\032\020@\032\024\022\004\022\0020\005\022\n\022\b\022\004\022\0020\0050A0\026H\026J\026\020B\032\b\022\004\022\0020\0050A2\006\020\004\032\0020\005H\026J\b\020C\032\0020\005H\026J\034\020D\032\0020\b2\022\020D\032\016\022\n\b\001\022\006\022\002\b\0030F0EH&J\b\020G\032\0020HH&J\022\020I\032\004\030\0010\0052\006\020I\032\0020\005H\026J\030\020I\032\0020\0002\006\0207\032\0020\0052\006\020\024\032\0020\005H\026J*\020J\032\b\022\004\022\002H\0030?\"\004\b\000\020\0032\006\020I\032\0020\0052\f\020!\032\b\022\004\022\002H\0030\"H\026J\024\020K\032\016\022\004\022\0020\005\022\004\022\0020\0050\026H\026J\n\020L\032\004\030\0010\005H\026J\020\020M\032\0020\0002\006\020M\032\0020\005H\026J\b\020N\032\0020\005H\026J\b\020O\032\0020PH\026J\b\020Q\032\0020PH\026J\020\020R\032\0020\0002\006\020S\032\0020\001H\026J\030\020R\032\0020\0002\006\020S\032\0020\0012\006\020$\032\0020%H\026J\020\020T\032\0020\0002\006\020S\032\0020\001H\026J\030\020T\032\0020\0002\006\020S\032\0020\0012\006\020$\032\0020%H\026J\b\020U\032\0020\005H&J\b\020V\032\0020HH\026J\b\020W\032\0020XH&J\b\020Y\032\0020\005H\026J\020\020Z\032\0020\0052\006\020\004\032\0020\005H&J*\020[\032\b\022\004\022\002H\0030?\"\004\b\000\020\0032\006\020\004\032\0020\0052\f\020!\032\b\022\004\022\002H\0030\"H\026J\024\020\\\032\016\022\004\022\0020\005\022\004\022\0020\0050\026H&J\b\020]\032\00201H\026J\b\020^\032\0020\005H\026J\022\020_\032\004\030\0010\0052\006\020\004\032\0020\005H\026J*\020`\032\b\022\004\022\002H\0030?\"\004\b\000\020\0032\006\020\004\032\0020\0052\f\020!\032\b\022\004\022\002H\0030\"H\026J\032\020a\032\024\022\004\022\0020\005\022\n\022\b\022\004\022\0020\0050A0\026H\026J\026\020b\032\b\022\004\022\0020\0050A2\006\020\004\032\0020\005H\026J\n\020c\032\004\030\0010\005H\026J\020\020d\032\0020\b2\006\020e\032\0020\005H\026J\030\020d\032\0020\b2\006\020e\032\0020\0052\006\020f\032\0020gH&J\020\020h\032\0020\0002\006\0207\032\0020\005H\026J\032\020h\032\0020\0002\006\0207\032\0020\0052\b\020Y\032\004\030\0010\005H\026J\020\020i\032\0020\0002\006\020j\032\0020\005H\026J&\020i\032\0020\0002\006\020j\032\0020\0052\024\020k\032\020\022\004\022\0020\005\022\006\022\004\030\0010\0010\026H\026J\b\020l\032\0020mH&J\b\020n\032\0020oH&J\b\020p\032\0020qH\026J\n\020r\032\004\030\0010\005H\026J\020\020r\032\0020\0002\006\020s\032\0020(H&J\020\020r\032\0020\0002\006\020t\032\0020\037H\026J\020\020r\032\0020\0002\006\020u\032\0020\005H\026J\n\020v\032\004\030\0010(H&J\b\020w\032\0020\005H\026J\035\020x\032\004\030\001H\003\"\004\b\000\020\0032\006\020\004\032\0020\005H\026¢\006\002\020\006J\032\020x\032\0020\b2\006\020\004\032\0020\0052\b\020\024\032\004\030\0010\001H\026J\026\020y\032\020\022\004\022\0020\005\022\006\022\004\030\0010\0010\026H\026J\b\020f\032\0020gH\026J\020\020f\032\0020\0002\006\020f\032\0020gH\026J\020\020f\032\0020\0002\006\020f\032\00201H\026J\b\020z\032\00201H\026J\022\020{\032\004\030\0010|2\006\020}\032\0020\005H\026J\032\020~\032\024\022\004\022\0020\005\022\n\022\b\022\004\022\0020|0A0\026H\026J\016\020\032\b\022\004\022\0020|0AH\026J\026\020\032\b\022\004\022\0020|0A2\006\020}\032\0020\005H\026J\t\020\001\032\0020\005H\026J\013\020\001\032\004\030\0010\005H\026J\032\020\001\032\0020\b2\007\020\001\032\0020(2\006\0202\032\0020\005H\026J#\020\001\032\0020\b2\007\020\001\032\0020(2\006\0202\032\0020\0052\007\020\001\032\0020\020H\026ø\001\000\002\006\n\004\b!0\001¨\006\001À\006\001"}, d2 = {"Lio/javalin/http/Context;", "", "appAttribute", "T", "key", "", "(Ljava/lang/String;)Ljava/lang/Object;", "async", "", "task", "Lio/javalin/util/function/ThrowingRunnable;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "executor", "Ljava/util/concurrent/ExecutorService;", "timeout", "", "onTimeout", "Ljava/lang/Runnable;", "attribute", "value", "attributeMap", "", "attributeOrCompute", "callback", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "basicAuthCredentials", "Lio/javalin/security/BasicAuthCredentials;", "body", "bodyAsBytes", "", "bodyAsClass", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)Ljava/lang/Object;", "bodyInputStream", "Ljava/io/InputStream;", "bodyStreamAsClass", "bodyValidator", "Lio/javalin/validation/BodyValidator;", "cachedSessionAttribute", "cachedSessionAttributeOrCompute", "characterEncoding", "consumeSessionAttribute", "contentLength", "", "contentType", "Lio/javalin/http/ContentType;", "contextPath", "cookie", "Lio/javalin/http/Cookie;", "name", "maxAge", "cookieMap", "cookieStore", "Lio/javalin/http/util/CookieStore;", "endpointHandlerPath", "formParam", "formParamAsClass", "Lio/javalin/validation/Validator;", "formParamMap", "", "formParams", "fullUrl", "future", "Ljava/util/function/Supplier;", "Ljava/util/concurrent/CompletableFuture;", "handlerType", "Lio/javalin/http/HandlerType;", "header", "headerAsClass", "headerMap", "host", "html", "ip", "isMultipart", "", "isMultipartFormData", "json", "obj", "jsonStream", "matchedPath", "method", "outputStream", "Ljakarta/servlet/ServletOutputStream;", "path", "pathParam", "pathParamAsClass", "pathParamMap", "port", "protocol", "queryParam", "queryParamAsClass", "queryParamMap", "queryParams", "queryString", "redirect", "location", "status", "Lio/javalin/http/HttpStatus;", "removeCookie", "render", "filePath", "model", "req", "Ljakarta/servlet/http/HttpServletRequest;", "res", "Ljakarta/servlet/http/HttpServletResponse;", "responseCharset", "Ljava/nio/charset/Charset;", "result", "resultStream", "resultBytes", "resultString", "resultInputStream", "scheme", "sessionAttribute", "sessionAttributeMap", "statusCode", "uploadedFile", "Lio/javalin/http/UploadedFile;", "fileName", "uploadedFileMap", "uploadedFiles", "url", "userAgent", "writeSeekableStream", "inputStream", "totalBytes", "javalin"})
public interface Context {
  default int contentLength() {
    return req().getContentLength();
  }
  
  @Nullable
  default String contentType() {
    return req().getContentType();
  }
  
  @NotNull
  default HandlerType method() {
    if (header("X-HTTP-Method-Override") == null)
      header("X-HTTP-Method-Override"); 
    Intrinsics.checkNotNullExpressionValue(req().getMethod(), "header(Header.X_HTTP_MET…OVERRIDE) ?: req().method");
    return header("X-HTTP-Method-Override").findByName(req().getMethod());
  }
  
  @NotNull
  default String path() {
    Intrinsics.checkNotNullExpressionValue(req().getRequestURI(), "req().requestURI");
    return req().getRequestURI();
  }
  
  default int port() {
    return req().getServerPort();
  }
  
  @NotNull
  default String protocol() {
    Intrinsics.checkNotNullExpressionValue(req().getProtocol(), "req().protocol");
    return req().getProtocol();
  }
  
  @NotNull
  default String contextPath() {
    Intrinsics.checkNotNullExpressionValue(req().getContextPath(), "req().contextPath");
    return req().getContextPath();
  }
  
  @Nullable
  default String userAgent() {
    return req().getHeader("User-Agent");
  }
  
  @Nullable
  default String characterEncoding() {
    return JavalinServletContextKt.getRequestCharset(this);
  }
  
  @NotNull
  default String url() {
    return (String)(ContextResolverConfigKt.contextResolver(this)).url.invoke(this);
  }
  
  @NotNull
  default String fullUrl() {
    return (String)(ContextResolverConfigKt.contextResolver(this)).fullUrl.invoke(this);
  }
  
  @NotNull
  default String scheme() {
    return (String)(ContextResolverConfigKt.contextResolver(this)).scheme.invoke(this);
  }
  
  @Nullable
  default String host() {
    return (String)(ContextResolverConfigKt.contextResolver(this)).host.invoke(this);
  }
  
  @NotNull
  default String ip() {
    return (String)(ContextResolverConfigKt.contextResolver(this)).ip.invoke(this);
  }
  
  @NotNull
  default String body() {
    byte[] arrayOfByte = bodyAsBytes();
    if (characterEncoding() == null)
      characterEncoding(); 
    Intrinsics.checkNotNullExpressionValue(Charset.forName("UTF-8"), "forName(characterEncoding() ?: \"UTF-8\")");
    Charset charset = Charset.forName("UTF-8");
    return new String(arrayOfByte, charset);
  }
  
  @NotNull
  default byte[] bodyAsBytes() {
    JavalinServletContextKt.throwContentTooLargeIfContentTooLarge(this);
    Intrinsics.checkNotNullExpressionValue(req().getInputStream(), "req().inputStream");
    return ByteStreamsKt.readBytes((InputStream)req().getInputStream());
  }
  
  default <T> T bodyAsClass(@NotNull Type type) {
    Intrinsics.checkNotNullParameter(type, "type");
    return JsonMapperKt.jsonMapper(this).fromJsonString(body(), type);
  }
  
  default <T> T bodyAsClass(@NotNull Class clazz) {
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return bodyAsClass(clazz);
  }
  
  default <T> T bodyStreamAsClass(@NotNull Type type) {
    Intrinsics.checkNotNullParameter(type, "type");
    Intrinsics.checkNotNullExpressionValue(req().getInputStream(), "req().inputStream");
    return JsonMapperKt.jsonMapper(this).fromJsonStream((InputStream)req().getInputStream(), type);
  }
  
  @NotNull
  default InputStream bodyInputStream() {
    Intrinsics.checkNotNullExpressionValue(req().getInputStream(), "req().inputStream");
    return (InputStream)req().getInputStream();
  }
  
  @NotNull
  default <T> BodyValidator<T> bodyValidator(@NotNull Class<T> clazz) {
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return new BodyValidator<>(body(), clazz, JsonMapperKt.jsonMapper(this));
  }
  
  @Nullable
  default String formParam(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return (String)CollectionsKt.firstOrNull(formParams(key));
  }
  
  @NotNull
  default <T> Validator<T> formParamAsClass(@NotNull String key, @NotNull Class<T> clazz) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return Validator.Companion.create(clazz, formParam(key), key);
  }
  
  @NotNull
  default List<String> formParams(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    if ((List)formParamMap().get(key) == null)
      (List)formParamMap().get(key); 
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  default Map<String, List<String>> formParamMap() {
    if (characterEncoding() == null)
      characterEncoding(); 
    return isMultipartFormData() ? MultipartUtil.INSTANCE.getFieldMap(req()) : JavalinServletContextKt.splitKeyValueStringAndGroupByKey(characterEncoding(), "UTF-8");
  }
  
  @NotNull
  default <T> Validator<T> pathParamAsClass(@NotNull String key, @NotNull Class<T> clazz) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return Validator.Companion.create(clazz, pathParam(key), key);
  }
  
  @Nullable
  default String queryParam(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return (String)CollectionsKt.firstOrNull(queryParams(key));
  }
  
  @NotNull
  default <T> Validator<T> queryParamAsClass(@NotNull String key, @NotNull Class<T> clazz) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return Validator.Companion.create(clazz, queryParam(key), key);
  }
  
  @NotNull
  default List<String> queryParams(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    if ((List)queryParamMap().get(key) == null)
      (List)queryParamMap().get(key); 
    return CollectionsKt.emptyList();
  }
  
  @NotNull
  default Map<String, List<String>> queryParamMap() {
    if (queryString() == null)
      queryString(); 
    if (characterEncoding() == null)
      characterEncoding(); 
    return JavalinServletContextKt.splitKeyValueStringAndGroupByKey(characterEncoding(), "UTF-8");
  }
  
  @Nullable
  default String queryString() {
    return req().getQueryString();
  }
  
  default void sessionAttribute(@NotNull String key, @Nullable Object value) {
    Intrinsics.checkNotNullParameter(key, "key");
    req().getSession().setAttribute(key, value);
  }
  
  @Nullable
  default <T> T sessionAttribute(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    req().getSession(false);
    if (((req().getSession(false) != null) ? req().getSession(false).getAttribute(key) : null) == null)
      (req().getSession(false) != null) ? req().getSession(false).getAttribute(key) : null; 
    return null;
  }
  
  @Nullable
  default <T> T consumeSessionAttribute(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    T t = (T)sessionAttribute(key);
    Object it = t;
    int $i$a$-also-Context$consumeSessionAttribute$1 = 0;
    sessionAttribute(key, null);
    return t;
  }
  
  default void cachedSessionAttribute(@NotNull String key, @Nullable Object value) {
    Intrinsics.checkNotNullParameter(key, "key");
    JavalinServletContextKt.cacheAndSetSessionAttribute(key, value, req());
  }
  
  @Nullable
  default <T> T cachedSessionAttribute(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return JavalinServletContextKt.getCachedRequestAttributeOrSessionAttribute(key, req());
  }
  
  @Nullable
  default <T> T cachedSessionAttributeOrCompute(@NotNull String key, @NotNull Function1<? super Context, ? extends T> callback) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(callback, "callback");
    return JavalinServletContextKt.cachedSessionAttributeOrCompute(callback, key, this);
  }
  
  @NotNull
  default Map<String, Object> sessionAttributeMap() {
    Intrinsics.checkNotNullExpressionValue(req().getSession().getAttributeNames(), "req().session.attributeNames");
    Sequence sequence1 = SequencesKt.asSequence(CollectionsKt.iterator(req().getSession().getAttributeNames()));
    int $i$f$associateWith = 0;
    LinkedHashMap<Object, Object> result$iv = new LinkedHashMap<>();
    Sequence $this$associateWithTo$iv$iv = sequence1;
    int $i$f$associateWithTo = 0;
    for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
      String str = (String)element$iv$iv;
      Object object1 = element$iv$iv;
      LinkedHashMap<Object, Object> linkedHashMap = result$iv;
      int $i$a$-associateWith-Context$sessionAttributeMap$1 = 0;
      Object object = sessionAttribute(str);
      linkedHashMap.put(object1, object);
    } 
    return (Map)result$iv;
  }
  
  default void attribute(@NotNull String key, @Nullable Object value) {
    Intrinsics.checkNotNullParameter(key, "key");
    req().setAttribute(key, value);
  }
  
  @Nullable
  default <T> T attribute(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    if (req().getAttribute(key) == null)
      req().getAttribute(key); 
    return null;
  }
  
  @Nullable
  default <T> T attributeOrCompute(@NotNull String key, @NotNull Function1<? super Context, ? extends T> callback) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(callback, "callback");
    return JavalinServletContextKt.attributeOrCompute(callback, key, this);
  }
  
  @NotNull
  default Map<String, Object> attributeMap() {
    Intrinsics.checkNotNullExpressionValue(req().getAttributeNames(), "req().attributeNames");
    Sequence sequence1 = SequencesKt.asSequence(CollectionsKt.iterator(req().getAttributeNames()));
    int $i$f$associateWith = 0;
    LinkedHashMap<Object, Object> result$iv = new LinkedHashMap<>();
    Sequence $this$associateWithTo$iv$iv = sequence1;
    int $i$f$associateWithTo = 0;
    for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
      String str = (String)element$iv$iv;
      Object object1 = element$iv$iv;
      LinkedHashMap<Object, Object> linkedHashMap = result$iv;
      int $i$a$-associateWith-Context$attributeMap$1 = 0;
      Object object = attribute(str);
      linkedHashMap.put(object1, object);
    } 
    return (Map)result$iv;
  }
  
  @NotNull
  default CookieStore cookieStore() {
    return new CookieStore(this);
  }
  
  @Nullable
  default String cookie(@NotNull String name) {
    Intrinsics.checkNotNullParameter(name, "name");
    return CookieKt.getCookie(req(), name);
  }
  
  @NotNull
  default Map<String, String> cookieMap() {
    Cookie[] arrayOfCookie1 = req().getCookies();
    int $i$f$associate = 0;
    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(arrayOfCookie1.length), 16);
    Cookie[] arrayOfCookie2 = arrayOfCookie1;
    Map<Object, Object> destination$iv$iv = new LinkedHashMap<>(capacity$iv);
    int $i$f$associateTo = 0;
    byte b;
    int i;
    for (b = 0, i = arrayOfCookie2.length; b < i; ) {
      Object element$iv$iv = arrayOfCookie2[b];
      Map<Object, Object> map = destination$iv$iv;
      Object object1 = element$iv$iv;
      int $i$a$-associate-Context$cookieMap$1 = 0;
      object1 = TuplesKt.to(object1.getName(), object1.getValue());
      map.put(object1.getFirst(), object1.getSecond());
      b++;
    } 
    req().getCookies();
    return (req().getCookies() != null) ? (Map)destination$iv$iv : MapsKt.emptyMap();
  }
  
  @Nullable
  default String header(@NotNull String header) {
    Intrinsics.checkNotNullParameter(header, "header");
    return req().getHeader(header);
  }
  
  @NotNull
  default <T> Validator<T> headerAsClass(@NotNull String header, @NotNull Class<T> clazz) {
    Intrinsics.checkNotNullParameter(header, "header");
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return Validator.Companion.create(clazz, header(header), header);
  }
  
  @NotNull
  default Map<String, String> headerMap() {
    Intrinsics.checkNotNullExpressionValue(req().getHeaderNames(), "req().headerNames");
    Sequence sequence1 = SequencesKt.asSequence(CollectionsKt.iterator(req().getHeaderNames()));
    int $i$f$associateWith = 0;
    LinkedHashMap<Object, Object> result$iv = new LinkedHashMap<>();
    Sequence $this$associateWithTo$iv$iv = sequence1;
    int $i$f$associateWithTo = 0;
    for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
      String str1 = (String)element$iv$iv;
      Object object1 = element$iv$iv;
      LinkedHashMap<Object, Object> linkedHashMap = result$iv;
      int $i$a$-associateWith-Context$headerMap$1 = 0;
      Intrinsics.checkNotNull(header(str1));
      String str2 = header(str1);
      linkedHashMap.put(object1, str2);
    } 
    return (Map)result$iv;
  }
  
  @Nullable
  default BasicAuthCredentials basicAuthCredentials() {
    return JavalinServletContextKt.getBasicAuthCredentials(header("Authorization"));
  }
  
  default boolean isMultipart() {
    if (header("Content-Type") != null) {
      String str = header("Content-Type");
      Intrinsics.checkNotNullExpressionValue(Locale.ROOT, "ROOT");
      Intrinsics.checkNotNullExpressionValue(str.toLowerCase(Locale.ROOT), "this as java.lang.String).toLowerCase(locale)");
      if (str.toLowerCase(Locale.ROOT) != null)
        return (StringsKt.contains$default(str.toLowerCase(Locale.ROOT), "multipart/", false, 2, null) == true); 
    } 
    str.toLowerCase(Locale.ROOT);
    return false;
  }
  
  default boolean isMultipartFormData() {
    if (header("Content-Type") != null) {
      String str = header("Content-Type");
      Intrinsics.checkNotNullExpressionValue(Locale.ROOT, "ROOT");
      Intrinsics.checkNotNullExpressionValue(str.toLowerCase(Locale.ROOT), "this as java.lang.String).toLowerCase(locale)");
      if (str.toLowerCase(Locale.ROOT) != null)
        return (StringsKt.contains$default(str.toLowerCase(Locale.ROOT), "multipart/form-data", false, 2, null) == true); 
    } 
    str.toLowerCase(Locale.ROOT);
    return false;
  }
  
  @Nullable
  default UploadedFile uploadedFile(@NotNull String fileName) {
    Intrinsics.checkNotNullParameter(fileName, "fileName");
    return (UploadedFile)CollectionsKt.firstOrNull(uploadedFiles(fileName));
  }
  
  @NotNull
  default List<UploadedFile> uploadedFiles(@NotNull String fileName) {
    Intrinsics.checkNotNullParameter(fileName, "fileName");
    return isMultipartFormData() ? MultipartUtil.INSTANCE.getUploadedFiles(req(), fileName) : CollectionsKt.emptyList();
  }
  
  @NotNull
  default List<UploadedFile> uploadedFiles() {
    return isMultipartFormData() ? MultipartUtil.INSTANCE.getUploadedFiles(req()) : CollectionsKt.emptyList();
  }
  
  @NotNull
  default Map<String, List<UploadedFile>> uploadedFileMap() {
    return isMultipartFormData() ? MultipartUtil.INSTANCE.getUploadedFileMap(req()) : MapsKt.emptyMap();
  }
  
  @NotNull
  default Charset responseCharset() {
    Object object2;
    Throwable it;
    Context context = this;
    try {
      Context $this$responseCharset_u24lambda_u2d5 = context;
      int $i$a$-runCatching-Context$responseCharset$1 = 0;
      object2 = Result.constructor-impl(Charset.forName($this$responseCharset_u24lambda_u2d5.res().getCharacterEncoding()));
    } catch (Throwable throwable) {
      object2 = Result.constructor-impl(ResultKt.createFailure(throwable));
    } 
    Object object1 = object2;
    Result.exceptionOrNull-impl(object1);
    int $i$a$-getOrElse-Context$responseCharset$2 = 0;
    Intrinsics.checkNotNullExpressionValue((Result.exceptionOrNull-impl(object1) == null) ? (Charset)object1 : Charset.defaultCharset(), "runCatching { Charset.fo…harset.defaultCharset() }");
    return (Result.exceptionOrNull-impl(object1) == null) ? (Charset)object1 : Charset.defaultCharset();
  }
  
  default void writeSeekableStream(@NotNull InputStream inputStream, @NotNull String contentType, long totalBytes) {
    Intrinsics.checkNotNullParameter(inputStream, "inputStream");
    Intrinsics.checkNotNullParameter(contentType, "contentType");
    SeekableWriter.INSTANCE.write(this, inputStream, contentType, totalBytes);
  }
  
  default void writeSeekableStream(@NotNull InputStream inputStream, @NotNull String contentType) {
    Intrinsics.checkNotNullParameter(inputStream, "inputStream");
    Intrinsics.checkNotNullParameter(contentType, "contentType");
    writeSeekableStream(inputStream, contentType, inputStream.available());
  }
  
  @NotNull
  default Context result(@NotNull String resultString) {
    Intrinsics.checkNotNullParameter(resultString, "resultString");
    Intrinsics.checkNotNullExpressionValue(resultString.getBytes(responseCharset()), "this as java.lang.String).getBytes(charset)");
    return result(new ByteArrayInputStream(resultString.getBytes(responseCharset())));
  }
  
  @NotNull
  default Context result(@NotNull byte[] resultBytes) {
    Intrinsics.checkNotNullParameter(resultBytes, "resultBytes");
    return result(new ByteArrayInputStream(resultBytes));
  }
  
  @Nullable
  default String result() {
    return JavalinServletContextKt.readAndResetStreamIfPossible(resultInputStream(), responseCharset());
  }
  
  default void async(@Nullable ExecutorService executor, long timeout, @Nullable Runnable onTimeout, @NotNull ThrowingRunnable<Exception> task) {
    Intrinsics.checkNotNullParameter(task, "task");
    AsyncUtil.INSTANCE.submitAsyncTask(this, executor, timeout, onTimeout, task);
  }
  
  default void async(long timeout, @Nullable Runnable onTimeout, @NotNull ThrowingRunnable<Exception> task) {
    Intrinsics.checkNotNullParameter(task, "task");
    async(null, timeout, onTimeout, task);
  }
  
  default void async(@NotNull ThrowingRunnable task) {
    Intrinsics.checkNotNullParameter(task, "task");
    async$default(this, null, 0L, null, task, 3, null);
  }
  
  @NotNull
  default Context contentType(@NotNull String contentType) {
    Intrinsics.checkNotNullParameter(contentType, "contentType");
    Context context1 = this, it = context1;
    int $i$a$-also-Context$contentType$1 = 0;
    res().setContentType(contentType);
    return context1;
  }
  
  @NotNull
  default Context contentType(@NotNull ContentType contentType) {
    Intrinsics.checkNotNullParameter(contentType, "contentType");
    return contentType(contentType.getMimeType());
  }
  
  @NotNull
  default Context header(@NotNull String name, @NotNull String value) {
    Intrinsics.checkNotNullParameter(name, "name");
    Intrinsics.checkNotNullParameter(value, "value");
    Context context1 = this, it = context1;
    int $i$a$-also-Context$header$1 = 0;
    res().setHeader(name, value);
    return context1;
  }
  
  default void redirect(@NotNull String location) {
    Intrinsics.checkNotNullParameter(location, "location");
    redirect(location, HttpStatus.FOUND);
  }
  
  @NotNull
  default Context status(@NotNull HttpStatus status) {
    Intrinsics.checkNotNullParameter(status, "status");
    Context context1 = this, it = context1;
    int $i$a$-also-Context$status$1 = 0;
    res().setStatus(status.getCode());
    return context1;
  }
  
  @NotNull
  default Context status(int status) {
    Context context1 = this, it = context1;
    int $i$a$-also-Context$status$2 = 0;
    res().setStatus(status);
    return context1;
  }
  
  @NotNull
  default HttpStatus status() {
    return HttpStatus.Companion.forStatus(res().getStatus());
  }
  
  default int statusCode() {
    return res().getStatus();
  }
  
  @NotNull
  default Context cookie(@NotNull String name, @NotNull String value) {
    Intrinsics.checkNotNullParameter(name, "name");
    Intrinsics.checkNotNullParameter(value, "value");
    return cookie(name, value, -1);
  }
  
  @NotNull
  default Context cookie(@NotNull String name, @NotNull String value, int maxAge) {
    Intrinsics.checkNotNullParameter(name, "name");
    Intrinsics.checkNotNullParameter(value, "value");
    return cookie(new Cookie(name, value, null, maxAge, false, 0, false, null, null, null, 1012, null));
  }
  
  @NotNull
  default Context cookie(@NotNull Cookie cookie) {
    Intrinsics.checkNotNullParameter(cookie, "cookie");
    Context context1 = this, it = context1;
    int $i$a$-also-Context$cookie$1 = 0;
    CookieKt.setJavalinCookie(res(), cookie);
    return context1;
  }
  
  @NotNull
  default Context removeCookie(@NotNull String name, @Nullable String path) {
    Intrinsics.checkNotNullParameter(name, "name");
    Context context1 = this, it = context1;
    int $i$a$-also-Context$removeCookie$1 = 0;
    CookieKt.removeCookie(res(), name, path);
    return context1;
  }
  
  @NotNull
  default Context removeCookie(@NotNull String name) {
    Intrinsics.checkNotNullParameter(name, "name");
    return removeCookie(name, "/");
  }
  
  @NotNull
  default Context json(@NotNull Object obj, @NotNull Type type) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    Intrinsics.checkNotNullParameter(type, "type");
    return contentType(ContentType.APPLICATION_JSON).result(JsonMapperKt.jsonMapper(this).toJsonString(obj, type));
  }
  
  @NotNull
  default Context json(@NotNull Object obj) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    return json(obj, obj.getClass());
  }
  
  @NotNull
  default Context jsonStream(@NotNull Object obj, @NotNull Type type) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    Intrinsics.checkNotNullParameter(type, "type");
    return contentType(ContentType.APPLICATION_JSON).result(JsonMapperKt.jsonMapper(this).toJsonStream(obj, type));
  }
  
  @NotNull
  default Context jsonStream(@NotNull Object obj) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    return jsonStream(obj, obj.getClass());
  }
  
  @NotNull
  default Context html(@NotNull String html) {
    Intrinsics.checkNotNullParameter(html, "html");
    return contentType(ContentType.TEXT_HTML).result(html);
  }
  
  @NotNull
  default Context render(@NotNull String filePath, @NotNull Map<String, ? extends Object> model) {
    Intrinsics.checkNotNullParameter(filePath, "filePath");
    Intrinsics.checkNotNullParameter(model, "model");
    return html(FileRendererKt.fileRenderer(this).render(filePath, model, this));
  }
  
  @NotNull
  default Context render(@NotNull String filePath) {
    Intrinsics.checkNotNullParameter(filePath, "filePath");
    return render(filePath, new LinkedHashMap<>());
  }
  
  @NotNull
  HttpServletRequest req();
  
  @NotNull
  HttpServletResponse res();
  
  <T> T appAttribute(@NotNull String paramString);
  
  @NotNull
  HandlerType handlerType();
  
  @NotNull
  String matchedPath();
  
  @NotNull
  String endpointHandlerPath();
  
  @NotNull
  String pathParam(@NotNull String paramString);
  
  @NotNull
  Map<String, String> pathParamMap();
  
  @NotNull
  ServletOutputStream outputStream();
  
  @NotNull
  Context result(@NotNull InputStream paramInputStream);
  
  @Nullable
  InputStream resultInputStream();
  
  void future(@NotNull Supplier<? extends CompletableFuture<?>> paramSupplier);
  
  void redirect(@NotNull String paramString, @NotNull HttpStatus paramHttpStatus);
}
