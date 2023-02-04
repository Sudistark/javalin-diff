package io.javalin.json;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.TypesJVMKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000(\n\000\n\002\020\016\n\002\b\002\n\002\020\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\030\002\n\002\b\006\032&\020\002\032\002H\003\"\n\b\000\020\003\030\001*\0020\004*\0020\0052\006\020\006\032\0020\007H\b¢\006\002\020\b\032&\020\t\032\002H\003\"\n\b\000\020\003\030\001*\0020\004*\0020\0052\006\020\006\032\0020\001H\b¢\006\002\020\n\032\n\020\013\032\0020\005*\0020\f\032\n\020\013\032\0020\005*\0020\r\032&\020\016\032\0020\007\"\n\b\000\020\003\030\001*\0020\004*\0020\0052\006\020\017\032\002H\003H\b¢\006\002\020\020\032&\020\021\032\0020\001\"\n\b\000\020\003\030\001*\0020\004*\0020\0052\006\020\017\032\002H\003H\b¢\006\002\020\022\"\016\020\000\032\0020\001XT¢\006\002\n\000¨\006\023"}, d2 = {"JSON_MAPPER_KEY", "", "fromJsonStream", "T", "", "Lio/javalin/json/JsonMapper;", "json", "Ljava/io/InputStream;", "(Lio/javalin/json/JsonMapper;Ljava/io/InputStream;)Ljava/lang/Object;", "fromJsonString", "(Lio/javalin/json/JsonMapper;Ljava/lang/String;)Ljava/lang/Object;", "jsonMapper", "Lio/javalin/Javalin;", "Lio/javalin/http/Context;", "toJsonStream", "obj", "(Lio/javalin/json/JsonMapper;Ljava/lang/Object;)Ljava/io/InputStream;", "toJsonString", "(Lio/javalin/json/JsonMapper;Ljava/lang/Object;)Ljava/lang/String;", "javalin"})
public final class JsonMapperKt {
  @NotNull
  public static final String JSON_MAPPER_KEY = "javalin-json-mapper";
  
  @NotNull
  public static final JsonMapper jsonMapper(@NotNull Javalin $this$jsonMapper) {
    Intrinsics.checkNotNullParameter($this$jsonMapper, "<this>");
    Intrinsics.checkNotNullExpressionValue($this$jsonMapper.attribute("javalin-json-mapper"), "this.attribute(JSON_MAPPER_KEY)");
    return (JsonMapper)$this$jsonMapper.attribute("javalin-json-mapper");
  }
  
  @NotNull
  public static final JsonMapper jsonMapper(@NotNull Context $this$jsonMapper) {
    Intrinsics.checkNotNullParameter($this$jsonMapper, "<this>");
    return $this$jsonMapper.<JsonMapper>appAttribute("javalin-json-mapper");
  }
}
