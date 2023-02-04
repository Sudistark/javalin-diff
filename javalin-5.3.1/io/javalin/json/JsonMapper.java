package io.javalin.json;

import java.io.InputStream;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\"\n\002\030\002\n\002\020\000\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\006\bf\030\0002\0020\001J'\020\002\032\002H\003\"\b\b\000\020\003*\0020\0012\006\020\004\032\0020\0052\006\020\006\032\0020\007H\026¢\006\002\020\bJ'\020\t\032\002H\003\"\b\b\000\020\003*\0020\0012\006\020\004\032\0020\n2\006\020\006\032\0020\007H\026¢\006\002\020\013J\030\020\f\032\0020\0052\006\020\r\032\0020\0012\006\020\016\032\0020\007H\026J\030\020\017\032\0020\n2\006\020\r\032\0020\0012\006\020\016\032\0020\007H\026ø\001\000\002\006\n\004\b!0\001¨\006\020À\006\001"}, d2 = {"Lio/javalin/json/JsonMapper;", "", "fromJsonStream", "T", "json", "Ljava/io/InputStream;", "targetType", "Ljava/lang/reflect/Type;", "(Ljava/io/InputStream;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "fromJsonString", "", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "toJsonStream", "obj", "type", "toJsonString", "javalin"})
public interface JsonMapper {
  @NotNull
  default String toJsonString(@NotNull Object obj, @NotNull Type type) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    Intrinsics.checkNotNullParameter(type, "type");
    throw new NotImplementedError("JsonMapper#toJsonString not implemented");
  }
  
  @NotNull
  default InputStream toJsonStream(@NotNull Object obj, @NotNull Type type) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    Intrinsics.checkNotNullParameter(type, "type");
    throw new NotImplementedError("JsonMapper#toJsonStream not implemented");
  }
  
  @NotNull
  default <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
    Intrinsics.checkNotNullParameter(json, "json");
    Intrinsics.checkNotNullParameter(targetType, "targetType");
    throw new NotImplementedError("JsonMapper#fromJsonString not implemented");
  }
  
  @NotNull
  default <T> T fromJsonStream(@NotNull InputStream json, @NotNull Type targetType) {
    Intrinsics.checkNotNullParameter(json, "json");
    Intrinsics.checkNotNullParameter(targetType, "targetType");
    throw new NotImplementedError("JsonMapper#fromJsonStream not implemented");
  }
}
