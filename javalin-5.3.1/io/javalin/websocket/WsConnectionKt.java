package io.javalin.websocket;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.server.JettyServerUpgradeRequest;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000\022\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\000\032\f\020\000\032\0020\001*\0020\002H\000\032\f\020\003\032\0020\004*\0020\002H\002¨\006\005"}, d2 = {"jettyUpgradeRequest", "Lorg/eclipse/jetty/websocket/server/JettyServerUpgradeRequest;", "Lorg/eclipse/jetty/websocket/api/Session;", "uriNoContextPath", "", "javalin"})
public final class WsConnectionKt {
  private static final String uriNoContextPath(Session $this$uriNoContextPath) {
    Intrinsics.checkNotNullExpressionValue($this$uriNoContextPath.getUpgradeRequest().getRequestURI().getPath(), "this.upgradeRequest.requestURI.path");
    Intrinsics.checkNotNullExpressionValue(jettyUpgradeRequest($this$uriNoContextPath).getHttpServletRequest().getContextPath(), "jettyUpgradeRequest().ht…ervletRequest.contextPath");
    return StringsKt.removePrefix($this$uriNoContextPath.getUpgradeRequest().getRequestURI().getPath(), jettyUpgradeRequest($this$uriNoContextPath).getHttpServletRequest().getContextPath());
  }
  
  @NotNull
  public static final JettyServerUpgradeRequest jettyUpgradeRequest(@NotNull Session $this$jettyUpgradeRequest) {
    Intrinsics.checkNotNullParameter($this$jettyUpgradeRequest, "<this>");
    Intrinsics.checkNotNull($this$jettyUpgradeRequest.getUpgradeRequest(), "null cannot be cast to non-null type org.eclipse.jetty.websocket.server.JettyServerUpgradeRequest");
    return (JettyServerUpgradeRequest)$this$jettyUpgradeRequest.getUpgradeRequest();
  }
}
