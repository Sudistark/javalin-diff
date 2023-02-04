package io.javalin.http;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\bJ\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\016\020\006\032\0020\004XT¢\006\002\n\000R\016\020\007\032\0020\004XT¢\006\002\n\000R\016\020\b\032\0020\004XT¢\006\002\n\000R\016\020\t\032\0020\004XT¢\006\002\n\000R\016\020\n\032\0020\004XT¢\006\002\n\000R\016\020\013\032\0020\004XT¢\006\002\n\000R\016\020\f\032\0020\004XT¢\006\002\n\000R\016\020\r\032\0020\004XT¢\006\002\n\000R\016\020\016\032\0020\004XT¢\006\002\n\000R\016\020\017\032\0020\004XT¢\006\002\n\000R\016\020\020\032\0020\004XT¢\006\002\n\000R\016\020\021\032\0020\004XT¢\006\002\n\000R\016\020\022\032\0020\004XT¢\006\002\n\000R\016\020\023\032\0020\004XT¢\006\002\n\000R\016\020\024\032\0020\004XT¢\006\002\n\000R\016\020\025\032\0020\004XT¢\006\002\n\000R\016\020\026\032\0020\004XT¢\006\002\n\000R\016\020\027\032\0020\004XT¢\006\002\n\000R\016\020\030\032\0020\004XT¢\006\002\n\000R\016\020\031\032\0020\004XT¢\006\002\n\000R\016\020\032\032\0020\004XT¢\006\002\n\000R\016\020\033\032\0020\004XT¢\006\002\n\000R\016\020\034\032\0020\004XT¢\006\002\n\000R\016\020\035\032\0020\004XT¢\006\002\n\000R\016\020\036\032\0020\004XT¢\006\002\n\000R\016\020\037\032\0020\004XT¢\006\002\n\000R\016\020 \032\0020\004XT¢\006\002\n\000R\016\020!\032\0020\004XT¢\006\002\n\000R\016\020\"\032\0020\004XT¢\006\002\n\000R\016\020#\032\0020\004XT¢\006\002\n\000R\016\020$\032\0020\004XT¢\006\002\n\000R\016\020%\032\0020\004XT¢\006\002\n\000R\016\020&\032\0020\004XT¢\006\002\n\000R\016\020'\032\0020\004XT¢\006\002\n\000R\016\020(\032\0020\004XT¢\006\002\n\000R\016\020)\032\0020\004XT¢\006\002\n\000R\016\020*\032\0020\004XT¢\006\002\n\000R\016\020+\032\0020\004XT¢\006\002\n\000R\016\020,\032\0020\004XT¢\006\002\n\000R\016\020-\032\0020\004XT¢\006\002\n\000R\016\020.\032\0020\004XT¢\006\002\n\000R\016\020/\032\0020\004XT¢\006\002\n\000R\016\0200\032\0020\004XT¢\006\002\n\000R\016\0201\032\0020\004XT¢\006\002\n\000R\016\0202\032\0020\004XT¢\006\002\n\000R\016\0203\032\0020\004XT¢\006\002\n\000R\016\0204\032\0020\004XT¢\006\002\n\000R\016\0205\032\0020\004XT¢\006\002\n\000R\016\0206\032\0020\004XT¢\006\002\n\000R\016\0207\032\0020\004XT¢\006\002\n\000R\016\0208\032\0020\004XT¢\006\002\n\000R\016\0209\032\0020\004XT¢\006\002\n\000R\016\020:\032\0020\004XT¢\006\002\n\000R\016\020;\032\0020\004XT¢\006\002\n\000R\016\020<\032\0020\004XT¢\006\002\n\000R\016\020=\032\0020\004XT¢\006\002\n\000R\016\020>\032\0020\004XT¢\006\002\n\000R\016\020?\032\0020\004XT¢\006\002\n\000R\016\020@\032\0020\004XT¢\006\002\n\000R\016\020A\032\0020\004XT¢\006\002\n\000R\016\020B\032\0020\004XT¢\006\002\n\000R\016\020C\032\0020\004XT¢\006\002\n\000R\016\020D\032\0020\004XT¢\006\002\n\000R\016\020E\032\0020\004XT¢\006\002\n\000R\016\020F\032\0020\004XT¢\006\002\n\000R\016\020G\032\0020\004XT¢\006\002\n\000R\016\020H\032\0020\004XT¢\006\002\n\000R\016\020I\032\0020\004XT¢\006\002\n\000R\016\020J\032\0020\004XT¢\006\002\n\000R\016\020K\032\0020\004XT¢\006\002\n\000R\016\020L\032\0020\004XT¢\006\002\n\000R\016\020M\032\0020\004XT¢\006\002\n\000¨\006N"}, d2 = {"Lio/javalin/http/Header;", "", "()V", "ACCEPT", "", "ACCEPT_CHARSET", "ACCEPT_ENCODING", "ACCEPT_LANGUAGE", "ACCEPT_RANGES", "ACCESS_CONTROL_ALLOW_CREDENTIALS", "ACCESS_CONTROL_ALLOW_HEADERS", "ACCESS_CONTROL_ALLOW_METHODS", "ACCESS_CONTROL_ALLOW_ORIGIN", "ACCESS_CONTROL_EXPOSE_HEADERS", "ACCESS_CONTROL_MAX_AGE", "ACCESS_CONTROL_REQUEST_HEADERS", "ACCESS_CONTROL_REQUEST_METHOD", "AGE", "ALLOW", "AUTHORIZATION", "CACHE_CONTROL", "CLEAR_SITE_DATA", "CONNECTION", "CONTENT_DISPOSITION", "CONTENT_ENCODING", "CONTENT_LANGUAGE", "CONTENT_LENGTH", "CONTENT_LOCATION", "CONTENT_RANGE", "CONTENT_SECURITY_POLICY", "CONTENT_TYPE", "COOKIE", "CROSS_ORIGIN_EMBEDDER_POLICY", "CROSS_ORIGIN_OPENER_POLICY", "CROSS_ORIGIN_RESOURCE_POLICY", "DATE", "ETAG", "EXPECT", "EXPIRES", "FROM", "HOST", "IF_MATCH", "IF_MODIFIED_SINCE", "IF_NONE_MATCH", "IF_RANGE", "IF_UNMODIFIED_SINCE", "LAST_MODIFIED", "LINK", "LOCATION", "MAX_FORWARDS", "ORIGIN", "PRAGMA", "PROXY_AUTHENTICATE", "PROXY_AUTHORIZATION", "RANGE", "REFERER", "REFERRER_POLICY", "RETRY_AFTER", "SEC_WEBSOCKET_KEY", "SERVER", "SET_COOKIE", "STRICT_TRANSPORT_SECURITY", "TE", "TRAILER", "TRANSFER_ENCODING", "UPGRADE", "USER_AGENT", "VARY", "VIA", "WARNING", "WWW_AUTHENTICATE", "X_ACCEL_BUFFERING", "X_CONTENT_TYPE_OPTIONS", "X_FORWARDED_FOR", "X_FORWARDED_PROTO", "X_FRAME_OPTIONS", "X_HTTP_METHOD_OVERRIDE", "X_PERMITTED_CROSS_DOMAIN_POLICIES", "javalin"})
public final class Header {
  @NotNull
  public static final Header INSTANCE = new Header();
  
  @NotNull
  public static final String ACCEPT = "Accept";
  
  @NotNull
  public static final String ACCEPT_CHARSET = "Accept-Charset";
  
  @NotNull
  public static final String ACCEPT_ENCODING = "Accept-Encoding";
  
  @NotNull
  public static final String ACCEPT_LANGUAGE = "Accept-Language";
  
  @NotNull
  public static final String ACCEPT_RANGES = "Accept-Ranges";
  
  @NotNull
  public static final String ACCESS_CONTROL_ALLOW_CREDENTIALS = "Access-Control-Allow-Credentials";
  
  @NotNull
  public static final String ACCESS_CONTROL_ALLOW_HEADERS = "Access-Control-Allow-Headers";
  
  @NotNull
  public static final String ACCESS_CONTROL_ALLOW_METHODS = "Access-Control-Allow-Methods";
  
  @NotNull
  public static final String ACCESS_CONTROL_ALLOW_ORIGIN = "Access-Control-Allow-Origin";
  
  @NotNull
  public static final String ACCESS_CONTROL_EXPOSE_HEADERS = "Access-Control-Expose-Headers";
  
  @NotNull
  public static final String ACCESS_CONTROL_MAX_AGE = "Access-Control-Max-Age";
  
  @NotNull
  public static final String ACCESS_CONTROL_REQUEST_HEADERS = "Access-Control-Request-Headers";
  
  @NotNull
  public static final String ACCESS_CONTROL_REQUEST_METHOD = "Access-Control-Request-Method";
  
  @NotNull
  public static final String AGE = "Age";
  
  @NotNull
  public static final String ALLOW = "Allow";
  
  @NotNull
  public static final String AUTHORIZATION = "Authorization";
  
  @NotNull
  public static final String CACHE_CONTROL = "Cache-Control";
  
  @NotNull
  public static final String CLEAR_SITE_DATA = "Clear-Site-Data";
  
  @NotNull
  public static final String CONNECTION = "Connection";
  
  @NotNull
  public static final String CONTENT_ENCODING = "Content-Encoding";
  
  @NotNull
  public static final String CONTENT_DISPOSITION = "Content-Disposition";
  
  @NotNull
  public static final String CONTENT_LANGUAGE = "Content-Language";
  
  @NotNull
  public static final String CONTENT_LENGTH = "Content-Length";
  
  @NotNull
  public static final String CONTENT_LOCATION = "Content-Location";
  
  @NotNull
  public static final String CONTENT_RANGE = "Content-Range";
  
  @NotNull
  public static final String CONTENT_SECURITY_POLICY = "Content-Security-Policy";
  
  @NotNull
  public static final String CONTENT_TYPE = "Content-Type";
  
  @NotNull
  public static final String COOKIE = "Cookie";
  
  @NotNull
  public static final String CROSS_ORIGIN_EMBEDDER_POLICY = "Cross-Origin-Embedder-Policy";
  
  @NotNull
  public static final String CROSS_ORIGIN_OPENER_POLICY = "Cross-Origin-Opener-Policy";
  
  @NotNull
  public static final String CROSS_ORIGIN_RESOURCE_POLICY = "Cross-Origin-Resource-Policy";
  
  @NotNull
  public static final String DATE = "Date";
  
  @NotNull
  public static final String ETAG = "ETag";
  
  @NotNull
  public static final String EXPECT = "Expect";
  
  @NotNull
  public static final String EXPIRES = "Expires";
  
  @NotNull
  public static final String FROM = "From";
  
  @NotNull
  public static final String HOST = "Host";
  
  @NotNull
  public static final String IF_MATCH = "If-Match";
  
  @NotNull
  public static final String IF_MODIFIED_SINCE = "If-Modified-Since";
  
  @NotNull
  public static final String IF_NONE_MATCH = "If-None-Match";
  
  @NotNull
  public static final String IF_RANGE = "If-Range";
  
  @NotNull
  public static final String IF_UNMODIFIED_SINCE = "If-Unmodified-Since";
  
  @NotNull
  public static final String LAST_MODIFIED = "Last-Modified";
  
  @NotNull
  public static final String LINK = "Link";
  
  @NotNull
  public static final String LOCATION = "Location";
  
  @NotNull
  public static final String MAX_FORWARDS = "Max-Forwards";
  
  @NotNull
  public static final String ORIGIN = "Origin";
  
  @NotNull
  public static final String PRAGMA = "Pragma";
  
  @NotNull
  public static final String PROXY_AUTHENTICATE = "Proxy-Authenticate";
  
  @NotNull
  public static final String PROXY_AUTHORIZATION = "Proxy-Authorization";
  
  @NotNull
  public static final String RANGE = "Range";
  
  @NotNull
  public static final String REFERER = "Referer";
  
  @NotNull
  public static final String REFERRER_POLICY = "Referrer-Policy";
  
  @NotNull
  public static final String RETRY_AFTER = "Retry-After";
  
  @NotNull
  public static final String SERVER = "Server";
  
  @NotNull
  public static final String SET_COOKIE = "Set-Cookie";
  
  @NotNull
  public static final String SEC_WEBSOCKET_KEY = "Sec-WebSocket-Key";
  
  @NotNull
  public static final String STRICT_TRANSPORT_SECURITY = "Strict-Transport-Security";
  
  @NotNull
  public static final String TE = "TE";
  
  @NotNull
  public static final String TRAILER = "Trailer";
  
  @NotNull
  public static final String TRANSFER_ENCODING = "Transfer-Encoding";
  
  @NotNull
  public static final String UPGRADE = "Upgrade";
  
  @NotNull
  public static final String USER_AGENT = "User-Agent";
  
  @NotNull
  public static final String VARY = "Vary";
  
  @NotNull
  public static final String VIA = "Via";
  
  @NotNull
  public static final String WARNING = "Warning";
  
  @NotNull
  public static final String WWW_AUTHENTICATE = "WWW-Authenticate";
  
  @NotNull
  public static final String X_FORWARDED_FOR = "X-Forwarded-For";
  
  @NotNull
  public static final String X_FORWARDED_PROTO = "X-Forwarded-Proto";
  
  @NotNull
  public static final String X_FRAME_OPTIONS = "X-Frame-Options";
  
  @NotNull
  public static final String X_CONTENT_TYPE_OPTIONS = "X-Content-Type-Options";
  
  @NotNull
  public static final String X_HTTP_METHOD_OVERRIDE = "X-HTTP-Method-Override";
  
  @NotNull
  public static final String X_PERMITTED_CROSS_DOMAIN_POLICIES = "X-Permitted-Cross-Domain-Policies";
  
  @NotNull
  public static final String X_ACCEL_BUFFERING = "X-Accel-Buffering";
}
