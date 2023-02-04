package io.javalin.plugin.bundled;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000b\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020%\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\020\021\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\030\0002\0020\001:\007$%&'()*B\005¢\006\002\020\002J\037\020\b\032\0020\t2\022\020\n\032\n\022\006\b\001\022\0020\f0\013\"\0020\f¢\006\002\020\rJ\016\020\016\032\0020\t2\006\020\016\032\0020\005J\016\020\017\032\0020\t2\006\020\020\032\0020\021J\016\020\022\032\0020\t2\006\020\020\032\0020\023J\016\020\024\032\0020\t2\006\020\020\032\0020\025J\016\020\026\032\0020\t2\006\020\020\032\0020\027J\026\020\030\032\0020\t2\006\020\031\032\0020\0322\006\020\033\032\0020\034J\006\020\035\032\0020\tJ\016\020\036\032\0020\t2\006\020\036\032\0020\037J\016\020\036\032\0020\t2\006\020 \032\0020\005J\016\020!\032\0020\t2\006\020\020\032\0020\"J\f\020#\032\0020\005*\0020\005H\002R\035\020\003\032\016\022\004\022\0020\005\022\004\022\0020\0050\004¢\006\b\n\000\032\004\b\006\020\007¨\006+"}, d2 = {"Lio/javalin/plugin/bundled/GlobalHeaderConfig;", "", "()V", "headers", "", "", "getHeaders", "()Ljava/util/Map;", "clearSiteData", "", "data", "", "Lio/javalin/plugin/bundled/GlobalHeaderConfig$ClearSiteData;", "([Lio/javalin/plugin/bundled/GlobalHeaderConfig$ClearSiteData;)V", "contentSecurityPolicy", "crossOriginEmbedderPolicy", "policy", "Lio/javalin/plugin/bundled/GlobalHeaderConfig$CrossOriginEmbedderPolicy;", "crossOriginOpenerPolicy", "Lio/javalin/plugin/bundled/GlobalHeaderConfig$CrossOriginOpenerPolicy;", "crossOriginResourcePolicy", "Lio/javalin/plugin/bundled/GlobalHeaderConfig$CrossOriginResourcePolicy;", "referrerPolicy", "Lio/javalin/plugin/bundled/GlobalHeaderConfig$ReferrerPolicy;", "strictTransportSecurity", "duration", "Ljava/time/Duration;", "includeSubdomains", "", "xContentTypeOptionsNoSniff", "xFrameOptions", "Lio/javalin/plugin/bundled/GlobalHeaderConfig$XFrameOptions;", "domain", "xPermittedCrossDomainPolicies", "Lio/javalin/plugin/bundled/GlobalHeaderConfig$CrossDomainPolicy;", "toHttpHeaderValue", "ClearSiteData", "CrossDomainPolicy", "CrossOriginEmbedderPolicy", "CrossOriginOpenerPolicy", "CrossOriginResourcePolicy", "ReferrerPolicy", "XFrameOptions", "javalin"})
public final class GlobalHeaderConfig {
  @NotNull
  private final Map<String, String> headers = new LinkedHashMap<>();
  
  @NotNull
  public final Map<String, String> getHeaders() {
    return this.headers;
  }
  
  public final void strictTransportSecurity(@NotNull Duration duration, boolean includeSubdomains) {
    Intrinsics.checkNotNullParameter(duration, "duration");
    this.headers
      .put("Strict-Transport-Security", "max-age=" + duration.getSeconds() + (includeSubdomains ? " ; includeSubDomains" : ""));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\004\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004¨\006\005"}, d2 = {"Lio/javalin/plugin/bundled/GlobalHeaderConfig$XFrameOptions;", "", "(Ljava/lang/String;I)V", "DENY", "SAMEORIGIN", "javalin"})
  public enum XFrameOptions {
    DENY, SAMEORIGIN;
  }
  
  public final void xFrameOptions(@NotNull XFrameOptions xFrameOptions) {
    Intrinsics.checkNotNullParameter(xFrameOptions, "xFrameOptions");
    this.headers.put("X-Frame-Options", toHttpHeaderValue(xFrameOptions.name()));
  }
  
  public final void xFrameOptions(@NotNull String domain) {
    Intrinsics.checkNotNullParameter(domain, "domain");
    this.headers.put("X-Frame-Options", "allow-from: " + domain);
  }
  
  public final void xContentTypeOptionsNoSniff() {
    this.headers.put("X-Content-Type-Options", "nosniff");
  }
  
  public final void contentSecurityPolicy(@NotNull String contentSecurityPolicy) {
    Intrinsics.checkNotNullParameter(contentSecurityPolicy, "contentSecurityPolicy");
    this.headers.put("Content-Security-Policy", contentSecurityPolicy);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\007\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005j\002\b\006j\002\b\007¨\006\b"}, d2 = {"Lio/javalin/plugin/bundled/GlobalHeaderConfig$CrossDomainPolicy;", "", "(Ljava/lang/String;I)V", "NONE", "MASTER_ONLY", "BY_CONTENT_TYPE", "BY_FTP_FILENAME", "ALL", "javalin"})
  public enum CrossDomainPolicy {
    NONE, MASTER_ONLY, BY_CONTENT_TYPE, BY_FTP_FILENAME, ALL;
  }
  
  public final void xPermittedCrossDomainPolicies(@NotNull CrossDomainPolicy policy) {
    Intrinsics.checkNotNullParameter(policy, "policy");
    this.headers.put("X-Permitted-Cross-Domain-Policies", toHttpHeaderValue(policy.name()));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\n\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005j\002\b\006j\002\b\007j\002\b\bj\002\b\tj\002\b\n¨\006\013"}, d2 = {"Lio/javalin/plugin/bundled/GlobalHeaderConfig$ReferrerPolicy;", "", "(Ljava/lang/String;I)V", "NO_REFERRER", "NO_REFERRER_WHEN_DOWNGRADE", "ORIGIN", "ORIGIN_WHEN_CROSS_ORIGIN", "SAME_ORIGIN", "STRICT_ORIGIN", "STRICT_ORIGIN_WHEN_CROSS_ORIGIN", "UNSAFE_URL", "javalin"})
  public enum ReferrerPolicy {
    NO_REFERRER, NO_REFERRER_WHEN_DOWNGRADE, ORIGIN, ORIGIN_WHEN_CROSS_ORIGIN, SAME_ORIGIN, STRICT_ORIGIN, STRICT_ORIGIN_WHEN_CROSS_ORIGIN, UNSAFE_URL;
  }
  
  public final void referrerPolicy(@NotNull ReferrerPolicy policy) {
    Intrinsics.checkNotNullParameter(policy, "policy");
    this.headers.put("Referrer-Policy", toHttpHeaderValue(policy.name()));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\002\b\n\b\001\030\0002\b\022\004\022\0020\0000\001B\031\b\002\022\006\020\002\032\0020\003\022\b\b\002\020\004\032\0020\003¢\006\002\020\005R\021\020\004\032\0020\003¢\006\b\n\000\032\004\b\006\020\007j\002\b\bj\002\b\tj\002\b\nj\002\b\013j\002\b\f¨\006\r"}, d2 = {"Lio/javalin/plugin/bundled/GlobalHeaderConfig$ClearSiteData;", "", "name", "", "headerValue", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getHeaderValue", "()Ljava/lang/String;", "CACHE", "COOKIES", "STORAGE", "EXECUTION_CONTEXTS", "ANY", "javalin"})
  public enum ClearSiteData {
    CACHE("cache", null, 2, null),
    COOKIES("cookies", null, 2, null),
    STORAGE("storage", null, 2, null),
    EXECUTION_CONTEXTS("executionContexts", null, 2, null),
    ANY("*", null, 2, null);
    
    @NotNull
    private final String headerValue;
    
    ClearSiteData(String name, String headerValue) {
      this.headerValue = headerValue;
    }
    
    @NotNull
    public final String getHeaderValue() {
      return this.headerValue;
    }
  }
  
  public final void clearSiteData(@NotNull ClearSiteData... data) {
    Intrinsics.checkNotNullParameter(data, "data");
    this.headers.put("Clear-Site-Data", ArraysKt.joinToString$default((Object[])data, ",", null, null, 0, null, (Function1)GlobalHeaderConfig$clearSiteData$1.INSTANCE, 30, null));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\004\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004¨\006\005"}, d2 = {"Lio/javalin/plugin/bundled/GlobalHeaderConfig$CrossOriginEmbedderPolicy;", "", "(Ljava/lang/String;I)V", "UNSAFE_NONE", "REQUIRE_CORP", "javalin"})
  public enum CrossOriginEmbedderPolicy {
    UNSAFE_NONE, REQUIRE_CORP;
  }
  
  public final void crossOriginEmbedderPolicy(@NotNull CrossOriginEmbedderPolicy policy) {
    Intrinsics.checkNotNullParameter(policy, "policy");
    this.headers.put("Cross-Origin-Embedder-Policy", toHttpHeaderValue(policy.name()));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2 = {"Lio/javalin/plugin/bundled/GlobalHeaderConfig$CrossOriginOpenerPolicy;", "", "(Ljava/lang/String;I)V", "UNSAFE_NONE", "SAME_ORIGIN_ALLOW_POPUPS", "SAME_ORIGIN", "javalin"})
  public enum CrossOriginOpenerPolicy {
    UNSAFE_NONE, SAME_ORIGIN_ALLOW_POPUPS, SAME_ORIGIN;
  }
  
  public final void crossOriginOpenerPolicy(@NotNull CrossOriginOpenerPolicy policy) {
    Intrinsics.checkNotNullParameter(policy, "policy");
    this.headers.put("Cross-Origin-Opener-Policy", toHttpHeaderValue(policy.name()));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\020\020\n\002\b\005\b\001\030\0002\b\022\004\022\0020\0000\001B\007\b\002¢\006\002\020\002j\002\b\003j\002\b\004j\002\b\005¨\006\006"}, d2 = {"Lio/javalin/plugin/bundled/GlobalHeaderConfig$CrossOriginResourcePolicy;", "", "(Ljava/lang/String;I)V", "SAME_SITE", "SAME_ORIGIN", "CROSS_ORIGIN", "javalin"})
  public enum CrossOriginResourcePolicy {
    SAME_SITE, SAME_ORIGIN, CROSS_ORIGIN;
  }
  
  public final void crossOriginResourcePolicy(@NotNull CrossOriginResourcePolicy policy) {
    Intrinsics.checkNotNullParameter(policy, "policy");
    this.headers.put("Cross-Origin-Resource-Policy", toHttpHeaderValue(policy.name()));
  }
  
  private final String toHttpHeaderValue(String $this$toHttpHeaderValue) {
    String str = $this$toHttpHeaderValue;
    Intrinsics.checkNotNullExpressionValue(Locale.ROOT, "ROOT");
    Intrinsics.checkNotNullExpressionValue(str.toLowerCase(Locale.ROOT), "this as java.lang.String).toLowerCase(locale)");
    return StringsKt.replace$default(str.toLowerCase(Locale.ROOT), "_", "-", false, 4, null);
  }
}
