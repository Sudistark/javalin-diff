package io.javalin.jetty;

import io.javalin.config.JavalinConfig;
import io.javalin.config.RoutingConfig;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import io.javalin.http.servlet.JavalinServlet;
import io.javalin.http.servlet.JavalinServletContext;
import io.javalin.security.AccessManagerKt;
import io.javalin.security.RouteRole;
import io.javalin.websocket.WsConfig;
import io.javalin.websocket.WsConnection;
import io.javalin.websocket.WsEntry;
import io.javalin.websocket.WsExceptionMapper;
import io.javalin.websocket.WsHandlerType;
import io.javalin.websocket.WsPathMatcher;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.eclipse.jetty.server.session.Session;
import org.eclipse.jetty.websocket.server.JettyServerUpgradeRequest;
import org.eclipse.jetty.websocket.server.JettyServerUpgradeResponse;
import org.eclipse.jetty.websocket.server.JettyWebSocketServlet;
import org.eclipse.jetty.websocket.server.JettyWebSocketServletFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000~\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\"\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J2\020\023\032\0020\0242\006\020\025\032\0020\0262\006\020\027\032\0020\0302\f\020\031\032\b\022\004\022\0020\0330\0322\f\020\034\032\b\022\004\022\0020\0360\035J\030\020\037\032\0020 2\006\020!\032\0020\"2\006\020#\032\0020$H\002J\020\020%\032\0020\0242\006\020&\032\0020'H\024J\030\020(\032\0020\0242\006\020)\032\0020*2\006\020+\032\0020,H\024J\030\020-\032\0020\0242\006\020)\032\0020*2\006\020+\032\0020,H\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\007\020\bR\016\020\004\032\0020\005X\004¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\021\020\013\032\0020\f¢\006\b\n\000\032\004\b\r\020\016R\021\020\017\032\0020\020¢\006\b\n\000\032\004\b\021\020\022¨\006."}, d2 = {"Lio/javalin/jetty/JavalinJettyServlet;", "Lorg/eclipse/jetty/websocket/server/JettyWebSocketServlet;", "cfg", "Lio/javalin/config/JavalinConfig;", "httpServlet", "Lio/javalin/http/servlet/JavalinServlet;", "(Lio/javalin/config/JavalinConfig;Lio/javalin/http/servlet/JavalinServlet;)V", "getCfg", "()Lio/javalin/config/JavalinConfig;", "setUpgradeAllowed", "Lio/javalin/http/Handler;", "wsExceptionMapper", "Lio/javalin/websocket/WsExceptionMapper;", "getWsExceptionMapper", "()Lio/javalin/websocket/WsExceptionMapper;", "wsPathMatcher", "Lio/javalin/websocket/WsPathMatcher;", "getWsPathMatcher", "()Lio/javalin/websocket/WsPathMatcher;", "addHandler", "", "handlerType", "Lio/javalin/websocket/WsHandlerType;", "path", "", "ws", "Ljava/util/function/Consumer;", "Lio/javalin/websocket/WsConfig;", "roles", "", "Lio/javalin/security/RouteRole;", "allowedByAccessManager", "", "entry", "Lio/javalin/websocket/WsEntry;", "ctx", "Lio/javalin/http/Context;", "configure", "factory", "Lorg/eclipse/jetty/websocket/server/JettyWebSocketServletFactory;", "service", "req", "Ljakarta/servlet/http/HttpServletRequest;", "res", "Ljakarta/servlet/http/HttpServletResponse;", "setWsProtocolHeader", "javalin"})
public final class JavalinJettyServlet extends JettyWebSocketServlet {
  @NotNull
  private final JavalinConfig cfg;
  
  @NotNull
  private final JavalinServlet httpServlet;
  
  @NotNull
  private final WsExceptionMapper wsExceptionMapper;
  
  @NotNull
  private final WsPathMatcher wsPathMatcher;
  
  @NotNull
  private final Handler setUpgradeAllowed;
  
  public JavalinJettyServlet(@NotNull JavalinConfig cfg, @NotNull JavalinServlet httpServlet) {
    this.cfg = cfg;
    this.httpServlet = httpServlet;
    this.wsExceptionMapper = new WsExceptionMapper();
    this.wsPathMatcher = new WsPathMatcher();
    this.setUpgradeAllowed = JavalinJettyServlet::setUpgradeAllowed$lambda-3;
  }
  
  @NotNull
  public final JavalinConfig getCfg() {
    return this.cfg;
  }
  
  @NotNull
  public final WsExceptionMapper getWsExceptionMapper() {
    return this.wsExceptionMapper;
  }
  
  @NotNull
  public final WsPathMatcher getWsPathMatcher() {
    return this.wsPathMatcher;
  }
  
  public final void addHandler(@NotNull WsHandlerType handlerType, @NotNull String path, @NotNull Consumer<WsConfig> ws, @NotNull Set<? extends RouteRole> roles) {
    Intrinsics.checkNotNullParameter(handlerType, "handlerType");
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullParameter(ws, "ws");
    Intrinsics.checkNotNullParameter(roles, "roles");
    WsConfig wsConfig1 = new WsConfig(), wsConfig2 = wsConfig1;
    RoutingConfig routingConfig1 = this.cfg.routing;
    String str1 = path;
    WsHandlerType wsHandlerType1 = handlerType;
    WsPathMatcher wsPathMatcher = this.wsPathMatcher;
    int $i$a$-apply-JavalinJettyServlet$addHandler$1 = 0;
    ws.accept(wsConfig2);
    Unit unit = Unit.INSTANCE;
    Set<? extends RouteRole> set = roles;
    WsConfig wsConfig3 = wsConfig1;
    RoutingConfig routingConfig2 = routingConfig1;
    String str2 = str1;
    WsHandlerType wsHandlerType2 = wsHandlerType1;
    wsPathMatcher.add(new WsEntry(wsHandlerType2, str2, routingConfig2, wsConfig3, set));
  }
  
  protected void configure(@NotNull JettyWebSocketServletFactory factory) {
    Intrinsics.checkNotNullParameter(factory, "factory");
    if (this.cfg.pvt.wsFactoryConfig != null) {
      this.cfg.pvt.wsFactoryConfig.accept(factory);
    } else {
    
    } 
    factory.setCreator(this::configure$lambda-2);
  }
  
  private static final Object configure$lambda-2(JavalinJettyServlet this$0, JettyServerUpgradeRequest req, JettyServerUpgradeResponse paramJettyServerUpgradeResponse) {
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNull(req.getHttpServletRequest().getAttribute("javalin-ws-upgrade-context"), "null cannot be cast to non-null type io.javalin.http.servlet.JavalinServletContext");
    JavalinServletContext preUpgradeContext = (JavalinServletContext)req.getHttpServletRequest().getAttribute("javalin-ws-upgrade-context");
    Intrinsics.checkNotNullExpressionValue(req.getHttpServletRequest(), "req.httpServletRequest");
    req.getHttpServletRequest().setAttribute("javalin-ws-upgrade-context", preUpgradeContext.changeBaseRequest(req.getHttpServletRequest()));
    Object object = req.getSession();
    Session session = (object instanceof Session) ? (Session)object : null;
    Sequence sequence1 = SequencesKt.asSequence(CollectionsKt.iterator(session.getAttributeNames()));
    String str = "javalin-ws-upgrade-http-session";
    HttpServletRequest httpServletRequest = req.getHttpServletRequest();
    int $i$f$associateWith = 0;
    LinkedHashMap<Object, Object> result$iv = new LinkedHashMap<>();
    Sequence $this$associateWithTo$iv$iv = sequence1;
    int $i$f$associateWithTo = 0;
    for (Object element$iv$iv : $this$associateWithTo$iv$iv) {
      String str1 = (String)element$iv$iv;
      Object object1 = element$iv$iv;
      LinkedHashMap<Object, Object> linkedHashMap = result$iv;
      int $i$a$-associateWith-JavalinJettyServlet$configure$1$1 = 0;
      Object object2 = session.getAttribute(str1);
      linkedHashMap.put(object1, object2);
    } 
    LinkedHashMap<Object, Object> linkedHashMap1 = result$iv;
    SequencesKt.asSequence(CollectionsKt.iterator(session.getAttributeNames()));
    req.getHttpServletRequest().setAttribute("javalin-ws-upgrade-http-session", (session != null && session.getAttributeNames() != null && SequencesKt.asSequence(CollectionsKt.iterator(session.getAttributeNames())) != null) ? linkedHashMap1 : null);
    return new WsConnection(this$0.wsPathMatcher, this$0.wsExceptionMapper, this$0.cfg.pvt.wsLogger);
  }
  
  protected void service(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) {
    WsEntry entry;
    Intrinsics.checkNotNullParameter(req, "req");
    Intrinsics.checkNotNullParameter(res, "res");
    if (req.getHeader("Sec-WebSocket-Key") == null) {
      this.httpServlet.service((ServletRequest)req, (ServletResponse)res);
      return;
    } 
    Intrinsics.checkNotNullExpressionValue(req.getRequestURI(), "req.requestURI");
    Intrinsics.checkNotNullExpressionValue(req.getContextPath(), "req.contextPath");
    String requestUri = StringsKt.removePrefix(req.getRequestURI(), req.getContextPath());
    if (this.wsPathMatcher.findEndpointHandlerEntry(requestUri) == null) {
      this.wsPathMatcher.findEndpointHandlerEntry(requestUri);
      res.sendError(404, "WebSocket handler not found");
      return;
    } 
    JavalinConfig javalinConfig = this.cfg;
    String str1 = entry.getPath();
    Map<String, String> map = entry.extractPathParams(requestUri);
    JavalinServletContext upgradeContext = new JavalinServletContext(javalinConfig, null, false, null, req, res, null, null, null, null, str1, map, null, null, null, 29646, null);
    if (!allowedByAccessManager(entry, upgradeContext)) {
      res.sendError(HttpStatus.UNAUTHORIZED.getCode(), HttpStatus.UNAUTHORIZED.getMessage());
      return;
    } 
    req.setAttribute("javalin-ws-upgrade-context", upgradeContext);
    setWsProtocolHeader(req, res);
    super.service(req, res);
  }
  
  private static final void setUpgradeAllowed$lambda-3(Context it) {
    Intrinsics.checkNotNullParameter(it, "it");
    it.attribute("javalin-ws-upgrade-allowed", Boolean.valueOf(true));
  }
  
  private final boolean allowedByAccessManager(WsEntry entry, Context ctx) {
    boolean bool;
    try {
      if (this.cfg.pvt.accessManager != null) {
        if (this.cfg.pvt.accessManager != null) {
          this.cfg.pvt.accessManager.manage(this.setUpgradeAllowed, ctx, entry.getRoles());
        } else {
        
        } 
      } else {
        if (!entry.getRoles().isEmpty())
          throw AccessManagerKt.accessManagerNotConfiguredException(); 
        this.setUpgradeAllowed.handle(ctx);
      } 
      bool = Intrinsics.areEqual(ctx.attribute("javalin-ws-upgrade-allowed"), Boolean.valueOf(true));
    } catch (Exception e) {
      bool = false;
    } 
    return bool;
  }
  
  private final void setWsProtocolHeader(HttpServletRequest req, HttpServletResponse res) {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 'Sec-WebSocket-Protocol'
    //   4: invokeinterface getHeader : (Ljava/lang/String;)Ljava/lang/String;
    //   9: dup
    //   10: ifnonnull -> 15
    //   13: pop
    //   14: return
    //   15: astore_3
    //   16: aload_3
    //   17: checkcast java/lang/CharSequence
    //   20: iconst_1
    //   21: newarray char
    //   23: astore #5
    //   25: aload #5
    //   27: iconst_0
    //   28: bipush #44
    //   30: castore
    //   31: aload #5
    //   33: iconst_0
    //   34: iconst_0
    //   35: bipush #6
    //   37: aconst_null
    //   38: invokestatic split$default : (Ljava/lang/CharSequence;[CZIILjava/lang/Object;)Ljava/util/List;
    //   41: checkcast java/lang/Iterable
    //   44: astore #5
    //   46: iconst_0
    //   47: istore #6
    //   49: aload #5
    //   51: astore #7
    //   53: new java/util/ArrayList
    //   56: dup
    //   57: aload #5
    //   59: bipush #10
    //   61: invokestatic collectionSizeOrDefault : (Ljava/lang/Iterable;I)I
    //   64: invokespecial <init> : (I)V
    //   67: checkcast java/util/Collection
    //   70: astore #8
    //   72: iconst_0
    //   73: istore #9
    //   75: aload #7
    //   77: invokeinterface iterator : ()Ljava/util/Iterator;
    //   82: astore #10
    //   84: aload #10
    //   86: invokeinterface hasNext : ()Z
    //   91: ifeq -> 141
    //   94: aload #10
    //   96: invokeinterface next : ()Ljava/lang/Object;
    //   101: astore #11
    //   103: aload #8
    //   105: aload #11
    //   107: checkcast java/lang/String
    //   110: astore #12
    //   112: astore #14
    //   114: iconst_0
    //   115: istore #13
    //   117: aload #12
    //   119: checkcast java/lang/CharSequence
    //   122: invokestatic trim : (Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    //   125: invokevirtual toString : ()Ljava/lang/String;
    //   128: nop
    //   129: aload #14
    //   131: swap
    //   132: invokeinterface add : (Ljava/lang/Object;)Z
    //   137: pop
    //   138: goto -> 84
    //   141: aload #8
    //   143: checkcast java/util/List
    //   146: nop
    //   147: checkcast java/lang/Iterable
    //   150: astore #6
    //   152: aload #6
    //   154: invokeinterface iterator : ()Ljava/util/Iterator;
    //   159: astore #7
    //   161: aload #7
    //   163: invokeinterface hasNext : ()Z
    //   168: ifeq -> 215
    //   171: aload #7
    //   173: invokeinterface next : ()Ljava/lang/Object;
    //   178: astore #8
    //   180: aload #8
    //   182: checkcast java/lang/String
    //   185: astore #9
    //   187: iconst_0
    //   188: istore #10
    //   190: aload #9
    //   192: checkcast java/lang/CharSequence
    //   195: invokestatic isBlank : (Ljava/lang/CharSequence;)Z
    //   198: ifne -> 205
    //   201: iconst_1
    //   202: goto -> 206
    //   205: iconst_0
    //   206: nop
    //   207: ifeq -> 161
    //   210: aload #8
    //   212: goto -> 216
    //   215: aconst_null
    //   216: checkcast java/lang/String
    //   219: dup
    //   220: ifnonnull -> 225
    //   223: pop
    //   224: return
    //   225: astore #4
    //   227: aload_2
    //   228: ldc_w 'Sec-WebSocket-Protocol'
    //   231: aload #4
    //   233: invokeinterface setHeader : (Ljava/lang/String;Ljava/lang/String;)V
    //   238: return
    // Line number table:
    //   Java source line number -> byte code offset
    //   #90	-> 0
    //   #91	-> 16
    //   #99	-> 49
    //   #100	-> 75
    //   #101	-> 103
    //   #91	-> 117
    //   #91	-> 128
    //   #102	-> 141
    //   #99	-> 146
    //   #91	-> 147
    //   #98	-> 187
    //   #91	-> 190
    //   #91	-> 206
    //   #91	-> 207
    //   #91	-> 216
    //   #92	-> 227
    //   #93	-> 238
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   117	12	13	$i$a$-map-JavalinJettyServlet$setWsProtocolHeader$firstProtocol$1	I
    //   114	15	12	it	Ljava/lang/String;
    //   103	35	11	item$iv$iv	Ljava/lang/Object;
    //   75	68	9	$i$f$mapTo	I
    //   72	71	7	$this$mapTo$iv$iv	Ljava/lang/Iterable;
    //   72	71	8	destination$iv$iv	Ljava/util/Collection;
    //   49	98	6	$i$f$map	I
    //   46	101	5	$this$map$iv	Ljava/lang/Iterable;
    //   190	17	10	$i$a$-find-JavalinJettyServlet$setWsProtocolHeader$firstProtocol$2	I
    //   187	20	9	it	Ljava/lang/String;
    //   16	223	3	wsProtocolHeader	Ljava/lang/String;
    //   227	12	4	firstProtocol	Ljava/lang/String;
    //   0	239	0	this	Lio/javalin/jetty/JavalinJettyServlet;
    //   0	239	1	req	Ljakarta/servlet/http/HttpServletRequest;
    //   0	239	2	res	Ljakarta/servlet/http/HttpServletResponse;
  }
}
