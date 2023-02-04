package io.javalin.security;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\"\n\002\030\002\n\000\bæ\001\030\0002\0020\001J&\020\002\032\0020\0032\006\020\004\032\0020\0052\006\020\006\032\0020\0072\f\020\b\032\b\022\004\022\0020\n0\tH&ø\001\000\002\006\n\004\b!0\001¨\006\013À\006\001"}, d2 = {"Lio/javalin/security/AccessManager;", "", "manage", "", "handler", "Lio/javalin/http/Handler;", "ctx", "Lio/javalin/http/Context;", "routeRoles", "", "Lio/javalin/security/RouteRole;", "javalin"})
public interface AccessManager {
  void manage(@NotNull Handler paramHandler, @NotNull Context paramContext, @NotNull Set<? extends RouteRole> paramSet) throws Exception;
}
