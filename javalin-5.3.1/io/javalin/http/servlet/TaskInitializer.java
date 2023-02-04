package io.javalin.http.servlet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0004\n\002\030\002\n\000\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\bæ\001\030\000*\b\b\000\020\001*\0020\0022\0020\003J?\020\004\032\0020\0052\030\020\006\032\024\022\004\022\0020\b\022\004\022\0020\t\022\004\022\0020\0050\0072\006\020\n\032\0020\0132\006\020\f\032\0028\0002\006\020\r\032\0020\016H&¢\006\002\020\017ø\001\000\002\006\n\004\b!0\001¨\006\020À\006\001"}, d2 = {"Lio/javalin/http/servlet/TaskInitializer;", "CTX", "Lio/javalin/http/Context;", "", "createTasks", "", "submitTask", "Lkotlin/Function2;", "Lio/javalin/http/servlet/SubmitOrder;", "Lio/javalin/http/servlet/Task;", "servlet", "Lio/javalin/http/servlet/JavalinServlet;", "ctx", "requestUri", "", "(Lkotlin/jvm/functions/Function2;Lio/javalin/http/servlet/JavalinServlet;Lio/javalin/http/Context;Ljava/lang/String;)V", "javalin"})
public interface TaskInitializer<CTX extends io.javalin.http.Context> {
  void createTasks(@NotNull Function2<? super SubmitOrder, ? super Task, Unit> paramFunction2, @NotNull JavalinServlet paramJavalinServlet, @NotNull CTX paramCTX, @NotNull String paramString);
}
