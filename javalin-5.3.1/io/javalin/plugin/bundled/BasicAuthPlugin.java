package io.javalin.plugin.bundled;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.UnauthorizedResponse;
import io.javalin.plugin.Plugin;
import io.javalin.security.BasicAuthCredentials;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003¢\006\002\020\005J\020\020\006\032\0020\0072\006\020\b\032\0020\tH\026R\016\020\004\032\0020\003X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\n"}, d2 = {"Lio/javalin/plugin/bundled/BasicAuthPlugin;", "Lio/javalin/plugin/Plugin;", "username", "", "password", "(Ljava/lang/String;Ljava/lang/String;)V", "apply", "", "app", "Lio/javalin/Javalin;", "javalin"})
public final class BasicAuthPlugin implements Plugin {
  @NotNull
  private final String username;
  
  @NotNull
  private final String password;
  
  public BasicAuthPlugin(@NotNull String username, @NotNull String password) {
    this.username = username;
    this.password = password;
  }
  
  public void apply(@NotNull Javalin app) {
    Intrinsics.checkNotNullParameter(app, "app");
    app.before(this::apply$lambda-3);
  }
  
  private static final void apply$lambda-3(BasicAuthPlugin this$0, Context ctx) {
    Object object2;
    Throwable it;
    Intrinsics.checkNotNullParameter(this$0, "this$0");
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    BasicAuthPlugin basicAuthPlugin = this$0;
    try {
      BasicAuthPlugin $this$apply_u24lambda_u2d3_u24lambda_u2d0 = basicAuthPlugin;
      int $i$a$-runCatching-BasicAuthPlugin$apply$1$matched$1 = 0;
      object2 = Result.constructor-impl(ctx.basicAuthCredentials());
    } catch (Throwable throwable) {
      object2 = Result.constructor-impl(ResultKt.createFailure(throwable));
    } 
    Object object1 = object2;
    Result.exceptionOrNull-impl(object1);
    BasicAuthCredentials basicAuthCredentials = (BasicAuthCredentials)object1;
    int $i$a$-fold-BasicAuthPlugin$apply$1$matched$2 = 0, $i$a$-fold-BasicAuthPlugin$apply$1$matched$3 = 0;
    boolean matched = (Result.exceptionOrNull-impl(object1) == null) ? ((Intrinsics.areEqual((basicAuthCredentials != null) ? basicAuthCredentials.getUsername() : null, this$0.username) && Intrinsics.areEqual(basicAuthCredentials.getPassword(), this$0.password))) : false;
    if (!matched) {
      ctx.header("WWW-Authenticate", "Basic");
      throw new UnauthorizedResponse(null, null, 3, null);
    } 
  }
}
