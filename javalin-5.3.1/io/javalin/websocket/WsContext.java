package io.javalin.websocket;

import io.javalin.http.Context;
import io.javalin.json.JsonMapperKt;
import io.javalin.validation.Validator;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.TypesJVMKt;
import org.eclipse.jetty.websocket.api.CloseStatus;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.server.JettyServerUpgradeRequest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\001\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\020$\n\002\b\t\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\007\n\002\020\002\n\002\b\004\n\002\020\b\n\002\b\002\n\002\030\002\n\002\b\006\n\002\020\t\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\b\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020 \n\002\b\007\n\002\030\002\n\002\b\004\b&\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\033\020\033\032\004\030\001H\034\"\004\b\000\020\0342\006\020\035\032\0020\003¢\006\002\020\036J\030\020\033\032\0020\0372\006\020\035\032\0020\0032\b\020 \032\004\030\0010\001J\024\020!\032\020\022\004\022\0020\003\022\006\022\004\030\0010\0010\bJ\006\020\"\032\0020\037J\030\020\"\032\0020\0372\006\020#\032\0020$2\b\020%\032\004\030\0010\003J\016\020\"\032\0020\0372\006\020&\032\0020'J\020\020(\032\004\030\0010\0032\006\020)\032\0020\003J\022\020*\032\016\022\004\022\0020\003\022\004\022\0020\0030\bJ\006\020+\032\0020\037J(\020,\032\0020\0372\b\b\002\020-\032\0020.2\b\b\002\020/\032\002002\n\b\002\0201\032\004\030\00102H\007J\023\0203\032\002042\b\0205\032\004\030\0010\001H\002J\b\0206\032\0020$H\026J\020\0207\032\004\030\0010\0032\006\0207\032\0020\003J\022\0208\032\016\022\004\022\0020\003\022\004\022\0020\0030\bJ\006\0209\032\0020\003J\006\020:\032\0020\003J\016\020;\032\0020\0032\006\020\035\032\0020\003J#\020<\032\b\022\004\022\002H\0340=\"\n\b\000\020\034\030\001*\0020\0012\006\020\035\032\0020\003H\bJ(\020<\032\b\022\004\022\002H\0340=\"\004\b\000\020\0342\006\020\035\032\0020\0032\f\020>\032\b\022\004\022\002H\0340?J\022\020@\032\016\022\004\022\0020\003\022\004\022\0020\0030\bJ\020\020A\032\004\030\0010\0032\006\020\035\032\0020\003J#\020B\032\b\022\004\022\002H\0340=\"\n\b\000\020\034\030\001*\0020\0012\006\020\035\032\0020\003H\bJ(\020B\032\b\022\004\022\002H\0340=\"\004\b\000\020\0342\006\020\035\032\0020\0032\f\020>\032\b\022\004\022\002H\0340?J\030\020C\032\024\022\004\022\0020\003\022\n\022\b\022\004\022\0020\0030D0\bJ\024\020E\032\b\022\004\022\0020\0030D2\006\020\035\032\0020\003J\b\020F\032\004\030\0010\003J\016\020G\032\0020\0372\006\020H\032\00202J\016\020G\032\0020\0372\006\020H\032\0020\001J\016\020G\032\0020\0372\006\020H\032\0020\003J\"\020I\032\0020\037\"\n\b\000\020\034\030\001*\0020\0012\006\020H\032\002H\034H\b¢\006\002\020JJ\026\020I\032\0020\0372\006\020H\032\0020\0012\006\020K\032\0020LJ\024\020M\032\0020\0372\n\b\002\0201\032\004\030\00102H\007J\033\020N\032\004\030\001H\034\"\004\b\000\020\0342\006\020\035\032\0020\003¢\006\002\020\036J\024\020O\032\020\022\004\022\0020\003\022\006\022\004\030\0010\0010\bR\020\020\004\032\0020\0058\006X\004¢\006\002\n\000R/\020\007\032\020\022\004\022\0020\003\022\004\022\0020\001\030\0010\b8@X\002¢\006\022\n\004\b\r\020\016\022\004\b\t\020\n\032\004\b\013\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\017\020\020R\033\020\021\032\0020\0228@X\002¢\006\f\n\004\b\025\020\016\032\004\b\023\020\024R\033\020\026\032\0020\0278@X\002¢\006\f\n\004\b\032\020\016\032\004\b\030\020\031¨\006P"}, d2 = {"Lio/javalin/websocket/WsContext;", "", "sessionId", "", "session", "Lorg/eclipse/jetty/websocket/api/Session;", "(Ljava/lang/String;Lorg/eclipse/jetty/websocket/api/Session;)V", "sessionAttributes", "", "getSessionAttributes$javalin$annotations", "()V", "getSessionAttributes$javalin", "()Ljava/util/Map;", "sessionAttributes$delegate", "Lkotlin/Lazy;", "getSessionId", "()Ljava/lang/String;", "upgradeCtx", "Lio/javalin/http/Context;", "getUpgradeCtx$javalin", "()Lio/javalin/http/Context;", "upgradeCtx$delegate", "upgradeReq", "Lorg/eclipse/jetty/websocket/server/JettyServerUpgradeRequest;", "getUpgradeReq$javalin", "()Lorg/eclipse/jetty/websocket/server/JettyServerUpgradeRequest;", "upgradeReq$delegate", "attribute", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "", "value", "attributeMap", "closeSession", "code", "", "reason", "closeStatus", "Lorg/eclipse/jetty/websocket/api/CloseStatus;", "cookie", "name", "cookieMap", "disableAutomaticPings", "enableAutomaticPings", "interval", "", "unit", "Ljava/util/concurrent/TimeUnit;", "applicationData", "Ljava/nio/ByteBuffer;", "equals", "", "other", "hashCode", "header", "headerMap", "host", "matchedPath", "pathParam", "pathParamAsClass", "Lio/javalin/validation/Validator;", "clazz", "Ljava/lang/Class;", "pathParamMap", "queryParam", "queryParamAsClass", "queryParamMap", "", "queryParams", "queryString", "send", "message", "sendAsClass", "(Ljava/lang/Object;)V", "type", "Ljava/lang/reflect/Type;", "sendPing", "sessionAttribute", "sessionAttributeMap", "javalin"})
public abstract class WsContext {
  @NotNull
  private final String sessionId;
  
  @JvmField
  @NotNull
  public final Session session;
  
  @NotNull
  private final Lazy upgradeReq$delegate;
  
  @NotNull
  private final Lazy upgradeCtx$delegate;
  
  @NotNull
  private final Lazy sessionAttributes$delegate;
  
  public WsContext(@NotNull String sessionId, @NotNull Session session) {
    this.sessionId = sessionId;
    this.session = session;
    this.upgradeReq$delegate = LazyKt.lazy(new WsContext$upgradeReq$2());
    this.upgradeCtx$delegate = LazyKt.lazy(new WsContext$upgradeCtx$2());
    this.sessionAttributes$delegate = LazyKt.lazy(new WsContext$sessionAttributes$2());
  }
  
  @NotNull
  public final String getSessionId() {
    return this.sessionId;
  }
  
  @NotNull
  public final JettyServerUpgradeRequest getUpgradeReq$javalin() {
    Lazy lazy = this.upgradeReq$delegate;
    return (JettyServerUpgradeRequest)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Lorg/eclipse/jetty/websocket/server/JettyServerUpgradeRequest;", "invoke"})
  static final class WsContext$upgradeReq$2 extends Lambda implements Function0<JettyServerUpgradeRequest> {
    WsContext$upgradeReq$2() {
      super(0);
    }
    
    @NotNull
    public final JettyServerUpgradeRequest invoke() {
      return WsConnectionKt.jettyUpgradeRequest(WsContext.this.session);
    }
  }
  
  @NotNull
  public final Context getUpgradeCtx$javalin() {
    Lazy lazy = this.upgradeCtx$delegate;
    return (Context)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Lio/javalin/http/Context;", "invoke"})
  static final class WsContext$upgradeCtx$2 extends Lambda implements Function0<Context> {
    WsContext$upgradeCtx$2() {
      super(0);
    }
    
    @NotNull
    public final Context invoke() {
      Intrinsics.checkNotNull(WsContext.this.getUpgradeReq$javalin().getHttpServletRequest().getAttribute("javalin-ws-upgrade-context"), "null cannot be cast to non-null type io.javalin.http.Context");
      return (Context)WsContext.this.getUpgradeReq$javalin().getHttpServletRequest().getAttribute("javalin-ws-upgrade-context");
    }
  }
  
  @Nullable
  public final Map<String, Object> getSessionAttributes$javalin() {
    Lazy lazy = this.sessionAttributes$delegate;
    return (Map<String, Object>)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\020\n\000\n\002\020$\n\002\020\016\n\002\020\000\n\000\020\000\032\020\022\004\022\0020\002\022\004\022\0020\003\030\0010\001H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "", "", "invoke"})
  static final class WsContext$sessionAttributes$2 extends Lambda implements Function0<Map<String, ? extends Object>> {
    WsContext$sessionAttributes$2() {
      super(0);
    }
    
    @Nullable
    public final Map<String, Object> invoke() {
      return (Map<String, Object>)WsContext.this.getUpgradeReq$javalin().getHttpServletRequest().getAttribute("javalin-ws-upgrade-http-session");
    }
  }
  
  @NotNull
  public final String matchedPath() {
    return getUpgradeCtx$javalin().matchedPath();
  }
  
  public final void send(@NotNull Object message) {
    Intrinsics.checkNotNullParameter(message, "message");
    sendAsClass(message, message.getClass());
  }
  
  public final void sendAsClass(@NotNull Object message, @NotNull Type type) {
    Intrinsics.checkNotNullParameter(message, "message");
    Intrinsics.checkNotNullParameter(type, "type");
    send(JsonMapperKt.jsonMapper(getUpgradeCtx$javalin()).toJsonString(message, type));
  }
  
  public final void send(@NotNull String message) {
    Intrinsics.checkNotNullParameter(message, "message");
    this.session.getRemote().sendString(message);
  }
  
  public final void send(@NotNull ByteBuffer message) {
    Intrinsics.checkNotNullParameter(message, "message");
    this.session.getRemote().sendBytes(message);
  }
  
  @JvmOverloads
  public final void sendPing(@Nullable ByteBuffer applicationData) {
    if (applicationData == null);
    applicationData.sendPing(ByteBuffer.allocate(0));
  }
  
  @JvmOverloads
  public final void enableAutomaticPings(long interval, @NotNull TimeUnit unit, @Nullable ByteBuffer applicationData) {
    Intrinsics.checkNotNullParameter(unit, "unit");
    WsAutomaticPingKt.enableAutomaticPings(this, interval, unit, applicationData);
  }
  
  public final void disableAutomaticPings() {
    WsAutomaticPingKt.disableAutomaticPings(this);
  }
  
  @Nullable
  public final String queryString() {
    return getUpgradeCtx$javalin().queryString();
  }
  
  @NotNull
  public final Map<String, List<String>> queryParamMap() {
    return getUpgradeCtx$javalin().queryParamMap();
  }
  
  @NotNull
  public final List<String> queryParams(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return getUpgradeCtx$javalin().queryParams(key);
  }
  
  @Nullable
  public final String queryParam(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return getUpgradeCtx$javalin().queryParam(key);
  }
  
  @NotNull
  public final <T> Validator<T> queryParamAsClass(@NotNull String key, @NotNull Class<T> clazz) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return getUpgradeCtx$javalin().queryParamAsClass(key, clazz);
  }
  
  @NotNull
  public final Map<String, String> pathParamMap() {
    return getUpgradeCtx$javalin().pathParamMap();
  }
  
  @NotNull
  public final String pathParam(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return getUpgradeCtx$javalin().pathParam(key);
  }
  
  @NotNull
  public final <T> Validator<T> pathParamAsClass(@NotNull String key, @NotNull Class<T> clazz) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return getUpgradeCtx$javalin().pathParamAsClass(key, clazz);
  }
  
  @NotNull
  public final String host() {
    Intrinsics.checkNotNullExpressionValue(getUpgradeReq$javalin().getHost(), "upgradeReq.host");
    return getUpgradeReq$javalin().getHost();
  }
  
  @Nullable
  public final String header(@NotNull String header) {
    Intrinsics.checkNotNullParameter(header, "header");
    return getUpgradeCtx$javalin().header(header);
  }
  
  @NotNull
  public final Map<String, String> headerMap() {
    return getUpgradeCtx$javalin().headerMap();
  }
  
  @Nullable
  public final String cookie(@NotNull String name) {
    Intrinsics.checkNotNullParameter(name, "name");
    return getUpgradeCtx$javalin().cookie(name);
  }
  
  @NotNull
  public final Map<String, String> cookieMap() {
    return getUpgradeCtx$javalin().cookieMap();
  }
  
  public final void attribute(@NotNull String key, @Nullable Object value) {
    Intrinsics.checkNotNullParameter(key, "key");
    getUpgradeCtx$javalin().attribute(key, value);
  }
  
  @Nullable
  public final <T> T attribute(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return getUpgradeCtx$javalin().attribute(key);
  }
  
  @NotNull
  public final Map<String, Object> attributeMap() {
    return getUpgradeCtx$javalin().attributeMap();
  }
  
  @Nullable
  public final <T> T sessionAttribute(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return (T)sessionAttributeMap().get(key);
  }
  
  @NotNull
  public final Map<String, Object> sessionAttributeMap() {
    if (getSessionAttributes$javalin() == null)
      getSessionAttributes$javalin(); 
    return MapsKt.emptyMap();
  }
  
  public final void closeSession() {
    this.session.close();
  }
  
  public final void closeSession(@NotNull CloseStatus closeStatus) {
    Intrinsics.checkNotNullParameter(closeStatus, "closeStatus");
    this.session.close(closeStatus);
  }
  
  public final void closeSession(int code, @Nullable String reason) {
    this.session.close(code, reason);
  }
  
  public boolean equals(@Nullable Object other) {
    Intrinsics.checkNotNull(other, "null cannot be cast to non-null type io.javalin.websocket.WsContext");
    return Intrinsics.areEqual(this.session, ((WsContext)other).session);
  }
  
  public int hashCode() {
    return this.session.hashCode();
  }
  
  @JvmOverloads
  public final void sendPing() {
    sendPing$default(this, null, 1, null);
  }
  
  @JvmOverloads
  public final void enableAutomaticPings(long interval, @NotNull TimeUnit unit) {
    Intrinsics.checkNotNullParameter(unit, "unit");
    enableAutomaticPings$default(this, interval, unit, null, 4, null);
  }
  
  @JvmOverloads
  public final void enableAutomaticPings(long interval) {
    enableAutomaticPings$default(this, interval, null, null, 6, null);
  }
  
  @JvmOverloads
  public final void enableAutomaticPings() {
    enableAutomaticPings$default(this, 0L, null, null, 7, null);
  }
}
