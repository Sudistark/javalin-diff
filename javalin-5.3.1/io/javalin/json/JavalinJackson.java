package io.javalin.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.http.InternalServerErrorResponse;
import io.javalin.util.CoreDependency;
import io.javalin.util.DependencyUtil;
import io.javalin.util.JavalinLogger;
import io.javalin.util.Util;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PipedOutputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.function.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0006\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\b\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\007\n\002\030\002\n\002\b\002\030\000 \0342\0020\001:\001\034B\021\022\n\b\002\020\002\032\004\030\0010\003¢\006\002\020\004J'\020\n\032\002H\013\"\b\b\000\020\013*\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0020\020H\026¢\006\002\020\021J'\020\022\032\002H\013\"\b\b\000\020\013*\0020\f2\006\020\r\032\0020\0232\006\020\017\032\0020\020H\026¢\006\002\020\024J\030\020\025\032\0020\0162\006\020\026\032\0020\f2\006\020\027\032\0020\020H\026J\030\020\030\032\0020\0232\006\020\026\032\0020\f2\006\020\027\032\0020\020H\026J\024\020\031\032\0020\0002\f\020\032\032\b\022\004\022\0020\0030\033R\033\020\005\032\0020\0038FX\002¢\006\f\n\004\b\b\020\t\032\004\b\006\020\007R\020\020\002\032\004\030\0010\003X\016¢\006\002\n\000¨\006\035"}, d2 = {"Lio/javalin/json/JavalinJackson;", "Lio/javalin/json/JsonMapper;", "objectMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "(Lcom/fasterxml/jackson/databind/ObjectMapper;)V", "mapper", "getMapper", "()Lcom/fasterxml/jackson/databind/ObjectMapper;", "mapper$delegate", "Lkotlin/Lazy;", "fromJsonStream", "T", "", "json", "Ljava/io/InputStream;", "targetType", "Ljava/lang/reflect/Type;", "(Ljava/io/InputStream;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "fromJsonString", "", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "toJsonStream", "obj", "type", "toJsonString", "updateMapper", "updateFunction", "Ljava/util/function/Consumer;", "Companion", "javalin"})
public final class JavalinJackson implements JsonMapper {
  @NotNull
  public static final Companion Companion = new Companion(null);
  
  @Nullable
  private ObjectMapper objectMapper;
  
  @NotNull
  private final Lazy mapper$delegate;
  
  public JavalinJackson(@Nullable ObjectMapper objectMapper) {
    this.objectMapper = objectMapper;
    this.mapper$delegate = LazyKt.lazy(new JavalinJackson$mapper$2());
  }
  
  @NotNull
  public final ObjectMapper getMapper() {
    Lazy lazy = this.mapper$delegate;
    return (ObjectMapper)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\020\000\032\0020\001H\n¢\006\002\b\002"}, d2 = {"<anonymous>", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "invoke"})
  static final class JavalinJackson$mapper$2 extends Lambda implements Function0<ObjectMapper> {
    @NotNull
    public final ObjectMapper invoke() {
      if (!Util.INSTANCE.classExists(CoreDependency.JACKSON.getTestClass())) {
        String message = 






          
          StringsKt.trimMargin$default("|It looks like you don't have an object mapper configured.\n                   |The easiest way to fix this is to simply add the '" + CoreDependency.JACKSON.getArtifactId() + "' dependency:\n                   |\n                   |" + DependencyUtil.INSTANCE.mavenAndGradleSnippets(CoreDependency.JACKSON) + "\n                   |\n                   |If you're using Kotlin, you will need to add '" + CoreDependency.JACKSON_KT.getArtifactId() + "'.\n                   |\n                   |To use a different object mapper, visit https://javalin.io/documentation#configuring-the-json-mapper", null, 1, null);
        JavalinLogger.warn$default(DependencyUtil.INSTANCE.wrapInSeparators(message), null, 2, null);
        throw new InternalServerErrorResponse(message, null, 2, null);
      } 
      if (JavalinJackson.this.objectMapper == null)
        JavalinJackson.this.objectMapper; 
      return JavalinJackson.Companion.defaultMapper();
    }
    
    JavalinJackson$mapper$2() {
      super(0);
    }
  }
  
  @NotNull
  public String toJsonString(@NotNull Object obj, @NotNull Type type) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    Intrinsics.checkNotNullParameter(type, "type");
    Intrinsics.checkNotNullExpressionValue(getMapper().writeValueAsString(obj), "mapper.writeValueAsString(obj)");
    return (obj instanceof String) ? (String)obj : getMapper().writeValueAsString(obj);
  }
  
  @NotNull
  public InputStream toJsonStream(@NotNull Object obj, @NotNull Type type) {
    Intrinsics.checkNotNullParameter(obj, "obj");
    Intrinsics.checkNotNullParameter(type, "type");
    String str = (String)obj;
    Charset charset = Charsets.UTF_8;
    Intrinsics.checkNotNullExpressionValue(str.getBytes(charset), "this as java.lang.String).getBytes(charset)");
    return (obj instanceof String) ? new ByteArrayInputStream(str.getBytes(charset)) : 
      PipedStreamUtil.INSTANCE.getInputStream(new JavalinJackson$toJsonStream$1(obj));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "pipedOutputStream", "Ljava/io/PipedOutputStream;", "invoke"})
  static final class JavalinJackson$toJsonStream$1 extends Lambda implements Function1<PipedOutputStream, Unit> {
    public final void invoke(@NotNull PipedOutputStream pipedOutputStream) {
      Intrinsics.checkNotNullParameter(pipedOutputStream, "pipedOutputStream");
      JavalinJackson.this.getMapper().getFactory().createGenerator(pipedOutputStream).writeObject(this.$obj);
    }
    
    JavalinJackson$toJsonStream$1(Object $obj) {
      super(1);
    }
  }
  
  @NotNull
  public <T> T fromJsonString(@NotNull String json, @NotNull Type targetType) {
    Intrinsics.checkNotNullParameter(json, "json");
    Intrinsics.checkNotNullParameter(targetType, "targetType");
    Intrinsics.checkNotNullExpressionValue(getMapper().readValue(json, getMapper().getTypeFactory().constructType(targetType)), "mapper.readValue(json, m…onstructType(targetType))");
    return (T)getMapper().readValue(json, getMapper().getTypeFactory().constructType(targetType));
  }
  
  @NotNull
  public <T> T fromJsonStream(@NotNull InputStream json, @NotNull Type targetType) {
    Intrinsics.checkNotNullParameter(json, "json");
    Intrinsics.checkNotNullParameter(targetType, "targetType");
    Intrinsics.checkNotNullExpressionValue(getMapper().readValue(json, getMapper().getTypeFactory().constructType(targetType)), "mapper.readValue(json, m…onstructType(targetType))");
    return (T)getMapper().readValue(json, getMapper().getTypeFactory().constructType(targetType));
  }
  
  @NotNull
  public final JavalinJackson updateMapper(@NotNull Consumer<ObjectMapper> updateFunction) {
    Intrinsics.checkNotNullParameter(updateFunction, "updateFunction");
    updateFunction.accept(getMapper());
    return this;
  }
  
  public JavalinJackson() {
    this(null, 1, null);
  }
  
  @JvmStatic
  @NotNull
  public static final ObjectMapper defaultMapper() {
    return Companion.defaultMapper();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\003\032\0020\004H\007¨\006\005"}, d2 = {"Lio/javalin/json/JavalinJackson$Companion;", "", "()V", "defaultMapper", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "javalin"})
  public static final class Companion {
    private Companion() {}
    
    @JvmStatic
    @NotNull
    public final ObjectMapper defaultMapper() {
      return JavalinJacksonKt.access$registerOptionalModule(JavalinJacksonKt.access$registerOptionalModule(JavalinJacksonKt.access$registerOptionalModule(JavalinJacksonKt.access$registerOptionalModule(new ObjectMapper(), CoreDependency.JACKSON_KT.getTestClass()), CoreDependency.JACKSON_JSR_310.getTestClass()), CoreDependency.JACKSON_ECLIPSE_COLLECTIONS.getTestClass()), CoreDependency.JACKSON_KTORM.getTestClass());
    }
  }
}
