package io.javalin.apibuilder;

import io.javalin.Javalin;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.sse.SseClient;
import io.javalin.security.RouteRole;
import io.javalin.websocket.WsConfig;
import java.util.Arrays;
import java.util.Deque;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.jetbrains.annotations.NotNull;

public class ApiBuilder {
  private static final ThreadLocal<Javalin> staticJavalin = new ThreadLocal<>();
  
  private static final ThreadLocal<Deque<String>> pathDeque = ThreadLocal.withInitial(java.util.ArrayDeque::new);
  
  public static void setStaticJavalin(@NotNull Javalin javalin) {
    staticJavalin.set(javalin);
  }
  
  public static void clearStaticJavalin() {
    staticJavalin.remove();
  }
  
  public static void path(@NotNull String path, @NotNull EndpointGroup endpointGroup) {
    path = path.startsWith("/") ? path : ("/" + path);
    ((Deque<String>)pathDeque.get()).addLast(path);
    endpointGroup.addEndpoints();
    ((Deque)pathDeque.get()).removeLast();
  }
  
  public static String prefixPath(@NotNull String path) {
    if (!path.equals("*"))
      path = (path.startsWith("/") || path.isEmpty()) ? path : ("/" + path); 
    return String.join("", (Iterable<? extends CharSequence>)pathDeque.get()) + String.join("", (Iterable<? extends CharSequence>)pathDeque.get());
  }
  
  public static Javalin staticInstance() {
    Javalin javalin = staticJavalin.get();
    if (javalin == null)
      throw new IllegalStateException("The static API can only be used within a routes() call."); 
    return javalin;
  }
  
  public static void get(@NotNull String path, @NotNull Handler handler) {
    staticInstance().get(prefixPath(path), handler);
  }
  
  public static void get(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().get(prefixPath(path), handler, roles);
  }
  
  public static void get(@NotNull Handler handler) {
    staticInstance().get(prefixPath(""), handler);
  }
  
  public static void get(@NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().get(prefixPath(""), handler, roles);
  }
  
  public static void post(@NotNull String path, @NotNull Handler handler) {
    staticInstance().post(prefixPath(path), handler);
  }
  
  public static void post(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().post(prefixPath(path), handler, roles);
  }
  
  public static void post(@NotNull Handler handler) {
    staticInstance().post(prefixPath(""), handler);
  }
  
  public static void post(@NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().post(prefixPath(""), handler, roles);
  }
  
  public static void put(@NotNull String path, @NotNull Handler handler) {
    staticInstance().put(prefixPath(path), handler);
  }
  
  public static void put(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().put(prefixPath(path), handler, roles);
  }
  
  public static void put(@NotNull Handler handler) {
    staticInstance().put(prefixPath(""), handler);
  }
  
  public static void put(@NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().put(prefixPath(""), handler, roles);
  }
  
  public static void patch(@NotNull String path, @NotNull Handler handler) {
    staticInstance().patch(prefixPath(path), handler);
  }
  
  public static void patch(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().patch(prefixPath(path), handler, roles);
  }
  
  public static void patch(@NotNull Handler handler) {
    staticInstance().patch(prefixPath(""), handler);
  }
  
  public static void patch(@NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().patch(prefixPath(""), handler, roles);
  }
  
  public static void delete(@NotNull String path, @NotNull Handler handler) {
    staticInstance().delete(prefixPath(path), handler);
  }
  
  public static void delete(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().delete(prefixPath(path), handler, roles);
  }
  
  public static void delete(@NotNull Handler handler) {
    staticInstance().delete(prefixPath(""), handler);
  }
  
  public static void delete(@NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().delete(prefixPath(""), handler, roles);
  }
  
  public static void head(@NotNull String path, @NotNull Handler handler) {
    staticInstance().head(prefixPath(path), handler);
  }
  
  public static void head(@NotNull String path, @NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().head(prefixPath(path), handler, roles);
  }
  
  public static void head(@NotNull Handler handler) {
    staticInstance().head(prefixPath(""), handler);
  }
  
  public static void head(@NotNull Handler handler, @NotNull RouteRole... roles) {
    staticInstance().head(prefixPath(""), handler, roles);
  }
  
  public static void before(@NotNull String path, @NotNull Handler handler) {
    staticInstance().before(prefixPath(path), handler);
  }
  
  public static void before(@NotNull Handler handler) {
    staticInstance().before(prefixPath("*"), handler);
  }
  
  public static void after(@NotNull String path, @NotNull Handler handler) {
    staticInstance().after(prefixPath(path), handler);
  }
  
  public static void after(@NotNull Handler handler) {
    staticInstance().after(prefixPath("*"), handler);
  }
  
  public static void ws(@NotNull String path, @NotNull Consumer<WsConfig> ws) {
    staticInstance().ws(prefixPath(path), ws);
  }
  
  public static void ws(@NotNull String path, @NotNull Consumer<WsConfig> ws, @NotNull RouteRole... roles) {
    staticInstance().ws(prefixPath(path), ws, roles);
  }
  
  public static void ws(@NotNull Consumer<WsConfig> ws) {
    staticInstance().ws(prefixPath(""), ws);
  }
  
  public static void ws(@NotNull Consumer<WsConfig> ws, @NotNull RouteRole... roles) {
    staticInstance().ws(prefixPath(""), ws, roles);
  }
  
  public Javalin wsBefore(@NotNull String path, @NotNull Consumer<WsConfig> wsConfig) {
    return staticInstance().wsBefore(prefixPath(path), wsConfig);
  }
  
  public Javalin wsBefore(@NotNull Consumer<WsConfig> wsConfig) {
    return staticInstance().wsBefore(prefixPath("*"), wsConfig);
  }
  
  public Javalin wsAfter(@NotNull String path, @NotNull Consumer<WsConfig> wsConfig) {
    return staticInstance().wsAfter(prefixPath(path), wsConfig);
  }
  
  public Javalin wsAfter(@NotNull Consumer<WsConfig> wsConfig) {
    return staticInstance().wsAfter(prefixPath("*"), wsConfig);
  }
  
  public static void sse(@NotNull String path, @NotNull Consumer<SseClient> client) {
    staticInstance().sse(prefixPath(path), client);
  }
  
  public static void sse(@NotNull String path, @NotNull Consumer<SseClient> client, @NotNull RouteRole... roles) {
    staticInstance().sse(prefixPath(path), client, roles);
  }
  
  public static void sse(@NotNull Consumer<SseClient> client) {
    staticInstance().sse(prefixPath(""), client);
  }
  
  public static void sse(@NotNull Consumer<SseClient> client, @NotNull RouteRole... roles) {
    staticInstance().sse(prefixPath(""), client, roles);
  }
  
  public static void crud(@NotNull CrudHandler crudHandler) {
    crud("", crudHandler, new RouteRole[0]);
  }
  
  public static void crud(@NotNull CrudHandler crudHandler, @NotNull RouteRole... roles) {
    crud("", crudHandler, roles);
  }
  
  public static void crud(@NotNull String path, @NotNull CrudHandler crudHandler) {
    crud(path, crudHandler, new RouteRole[0]);
  }
  
  public static void crud(@NotNull String path, @NotNull CrudHandler crudHandler, @NotNull RouteRole... roles) {
    String fullPath = prefixPath(path);
    String[] subPaths = (String[])Arrays.<String>stream(fullPath.split("/")).filter(it -> !it.isEmpty()).toArray(x$0 -> new String[x$0]);
    if (subPaths.length < 2)
      throw new IllegalArgumentException("CrudHandler requires a path like '/resource/{resource-id}'"); 
    String resourceId = subPaths[subPaths.length - 1];
    if (!resourceId.startsWith("{") || !resourceId.endsWith("}"))
      throw new IllegalArgumentException("CrudHandler requires a path-parameter at the end of the provided path, e.g. '/users/{user-id}'"); 
    String resourceBase = subPaths[subPaths.length - 2];
    if (resourceBase.startsWith("{") || resourceBase.startsWith("<") || resourceBase.endsWith("}") || resourceBase.endsWith(">"))
      throw new IllegalArgumentException("CrudHandler requires a resource base at the beginning of the provided path, e.g. '/users/{user-id}'"); 
    staticInstance().get(fullPath, ctx -> crudHandler.getOne(ctx, ctx.pathParam(resourceId)), roles);
    Objects.requireNonNull(crudHandler);
    staticInstance().get(fullPath.replace(resourceId, ""), crudHandler::getAll, roles);
    Objects.requireNonNull(crudHandler);
    staticInstance().post(fullPath.replace(resourceId, ""), crudHandler::create, roles);
    staticInstance().patch(fullPath, ctx -> crudHandler.update(ctx, ctx.pathParam(resourceId)), roles);
    staticInstance().delete(fullPath, ctx -> crudHandler.delete(ctx, ctx.pathParam(resourceId)), roles);
  }
}
