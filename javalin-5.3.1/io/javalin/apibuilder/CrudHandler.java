package io.javalin.apibuilder;

import io.javalin.http.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000 \n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\004\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&J\030\020\006\032\0020\0032\006\020\004\032\0020\0052\006\020\007\032\0020\bH&J\020\020\t\032\0020\0032\006\020\004\032\0020\005H&J\030\020\n\032\0020\0032\006\020\004\032\0020\0052\006\020\007\032\0020\bH&J\030\020\013\032\0020\0032\006\020\004\032\0020\0052\006\020\007\032\0020\bH&ø\001\000\002\006\n\004\b!0\001¨\006\fÀ\006\001"}, d2 = {"Lio/javalin/apibuilder/CrudHandler;", "", "create", "", "ctx", "Lio/javalin/http/Context;", "delete", "resourceId", "", "getAll", "getOne", "update", "javalin"})
public interface CrudHandler {
  void getAll(@NotNull Context paramContext);
  
  void getOne(@NotNull Context paramContext, @NotNull String paramString);
  
  void create(@NotNull Context paramContext);
  
  void update(@NotNull Context paramContext, @NotNull String paramString);
  
  void delete(@NotNull Context paramContext, @NotNull String paramString);
}
