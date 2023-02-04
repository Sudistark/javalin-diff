package io.javalin.json;

import com.google.gson.Gson;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.util.CoreDependency;
import io.javalin.util.DependencyUtil;
import io.javalin.util.JavalinLogger;
import io.javalin.util.Util;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PipedOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\006\b\026\030\0002\0020\001B\017\022\b\b\002\020\002\032\0020\003¢\006\002\020\004J'\020\005\032\002H\006\"\b\b\000\020\006*\0020\0072\006\020\b\032\0020\t2\006\020\n\032\0020\013H\026¢\006\002\020\fJ'\020\r\032\002H\006\"\b\b\000\020\006*\0020\0072\006\020\b\032\0020\0162\006\020\n\032\0020\013H\026¢\006\002\020\017J\030\020\020\032\0020\t2\006\020\021\032\0020\0072\006\020\022\032\0020\013H\026J\030\020\023\032\0020\0162\006\020\021\032\0020\0072\006\020\022\032\0020\013H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\024"}, d2 = {"Lio/javalin/json/JavalinGson;", "Lio/javalin/json/JsonMapper;", "gson", "Lcom/google/gson/Gson;", "(Lcom/google/gson/Gson;)V", "fromJsonStream", "T", "", "json", "Ljava/io/InputStream;", "targetType", "Ljava/lang/reflect/Type;", "(Ljava/io/InputStream;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "fromJsonString", "", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "toJsonStream", "obj", "type", "toJsonString", "javalin"})
public class JavalinGson implements JsonMapper {
  @NotNull
  private final Gson gson;
  
  public JavalinGson(@NotNull Gson gson) {
    this.gson = gson;
    if (!Util.INSTANCE.classExists(CoreDependency.GSON.getTestClass())) {
      String message = 



        
        StringsKt.trimMargin$default("|It looks like you don't have Gson dependency on classpath.\n                   |The easiest way to fix this is to simply add the '" + CoreDependency.GSON.getArtifactId() + "' dependency:\n                   |\n                   |" + DependencyUtil.INSTANCE.mavenAndGradleSnippets(CoreDependency.GSON) + "\n                   |", null, 1, null);
      JavalinLogger.warn$default(DependencyUtil.INSTANCE.wrapInSeparators(message), null, 2, null);
      throw new InternalServerErrorResponse(message, null, 2, null);
    } 
  }
  
  @NotNull
  public String toJsonString(@NotNull Object obj, @NotNull Type type) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    Intrinsics.checkNotNullParameter(type, "type");
    Intrinsics.checkNotNullExpressionValue(this.gson.toJson(obj, type), "gson.toJson(obj, type)");
    return (obj instanceof String) ? (String)obj : this.gson.toJson(obj, type);
  }
  
  @NotNull
  public InputStream toJsonStream(@NotNull Object obj, @NotNull Type type) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    Intrinsics.checkNotNullParameter(type, "type");
    String str = (String)obj;
    Charset charset = Charsets.UTF_8;
    Intrinsics.checkNotNullExpressionValue(str.getBytes(charset), "this as java.lang.String).getBytes(charset)");
    return (obj instanceof String) ? new ByteArrayInputStream(str.getBytes(charset)) : 
      PipedStreamUtil.INSTANCE.getInputStream(new JavalinGson$toJsonStream$1(obj, type));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Ljava/io/PipedOutputStream;", "invoke"})
  static final class JavalinGson$toJsonStream$1 extends Lambda implements Function1<PipedOutputStream, Unit> {
    JavalinGson$toJsonStream$1(Object $obj, Type $type) {
      super(1);
    }
    
    public final void invoke(@NotNull PipedOutputStream it) {
      Intrinsics.checkNotNullParameter(it, "it");
      JavalinGson.this.gson.toJson(this.$obj, this.$type, new OutputStreamWriter(it));
    }
  }
  
  @NotNull
  public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
    Intrinsics.checkNotNullParameter(json, "json");
    Intrinsics.checkNotNullParameter(targetType, "targetType");
    Intrinsics.checkNotNullExpressionValue(this.gson.fromJson(json, targetType), "gson.fromJson(json, targetType)");
    return (T)this.gson.fromJson(json, targetType);
  }
  
  @NotNull
  public <T> T fromJsonStream(@NotNull InputStream json, @NotNull Type targetType) {
    Intrinsics.checkNotNullParameter(json, "json");
    Intrinsics.checkNotNullParameter(targetType, "targetType");
    Intrinsics.checkNotNullExpressionValue(this.gson.fromJson(new InputStreamReader(json), targetType), "gson.fromJson(InputStreamReader(json), targetType)");
    return (T)this.gson.fromJson(new InputStreamReader(json), targetType);
  }
  
  public JavalinGson() {
    this(null, 1, null);
  }
}
