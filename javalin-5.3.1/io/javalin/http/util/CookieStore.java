package io.javalin.http.util;

import io.javalin.http.Context;
import io.javalin.http.Cookie;
import io.javalin.json.JsonMapper;
import io.javalin.json.JsonMapperKt;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0004\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020%\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\002\b\f\030\000 \0332\0020\001:\001\033B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\006\020\017\032\0020\020J\036\020\021\032\016\022\004\022\0020\007\022\004\022\0020\0010\0062\b\020\022\032\004\030\0010\007H\002J\034\020\023\032\002H\024\"\004\b\000\020\0242\006\020\025\032\0020\007H\002¢\006\002\020\026J\034\020\027\032\0020\0072\022\020\030\032\016\022\004\022\0020\007\022\004\022\0020\0010\006H\002J\031\020\031\032\0020\0202\006\020\025\032\0020\0072\006\020\032\032\0020\001H\002R\032\020\005\032\016\022\004\022\0020\007\022\004\022\0020\0010\006X\004¢\006\002\n\000R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\b\020\tR\026\020\n\032\n \f*\004\030\0010\0130\013X\004¢\006\002\n\000R\026\020\r\032\n \f*\004\030\0010\0160\016X\004¢\006\002\n\000¨\006\034"}, d2 = {"Lio/javalin/http/util/CookieStore;", "", "ctx", "Lio/javalin/http/Context;", "(Lio/javalin/http/Context;)V", "cookieMap", "", "", "getCtx", "()Lio/javalin/http/Context;", "decoder", "Ljava/util/Base64$Decoder;", "kotlin.jvm.PlatformType", "encoder", "Ljava/util/Base64$Encoder;", "clear", "", "deserialize", "cookie", "get", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "serialize", "map", "set", "value", "Companion", "javalin"})
public final class CookieStore {
  public CookieStore(@NotNull Context ctx) {
    this.ctx = ctx;
    this.encoder = Base64.getEncoder();
    this.decoder = Base64.getDecoder();
    this.cookieMap = deserialize(this.ctx.cookie(COOKIE_NAME));
  }
  
  @NotNull
  public final Context getCtx() {
    return this.ctx;
  }
  
  public final <T> T get(@NotNull String key) {
    Intrinsics.checkNotNullParameter(key, "key");
    return (T)this.cookieMap.get(key);
  }
  
  public final void set(@NotNull String key, @NotNull Object value) {
    Intrinsics.checkNotNullParameter(key, "key");
    Intrinsics.checkNotNullParameter(value, "value");
    this.cookieMap.put(key, value);
    this.ctx.cookie(new Cookie(COOKIE_NAME, serialize(this.cookieMap), null, 0, false, 0, false, null, null, null, 1020, null));
  }
  
  public final void clear() {
    this.cookieMap.clear();
    this.ctx.removeCookie(COOKIE_NAME);
  }
  
  private final Map<String, Object> deserialize(String cookie) {
    CharSequence charSequence = cookie;
    JsonMapper jsonMapper = JsonMapperKt.jsonMapper(this.ctx);
    Intrinsics.checkNotNullExpressionValue(this.decoder.decode(cookie), "decoder.decode(cookie)");
    byte[] arrayOfByte = this.decoder.decode(cookie);
    String str = new String(arrayOfByte, Charsets.UTF_8);
    int $i$f$fromJsonString = 0;
    return !((charSequence == null || charSequence.length() == 0) ? 1 : 0) ? 











      
      jsonMapper.<Map<String, Object>>fromJsonString(str, TypesJVMKt.getJavaType(Reflection.mutableCollectionType(Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)))))) : new LinkedHashMap<>();
  }
  
  private final String serialize(Map map) {
    JsonMapper $this$toJsonString$iv = JsonMapperKt.jsonMapper(this.ctx);
    int $i$f$toJsonString = 0;
    String str = $this$toJsonString$iv.toJsonString(map, TypesJVMKt.getJavaType(Reflection.mutableCollectionType(Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class))))));
    Intrinsics.checkNotNullExpressionValue(str.getBytes(Charsets.UTF_8), "this as java.lang.String).getBytes(charset)");
    Intrinsics.checkNotNullExpressionValue(this.encoder.encodeToString(str.getBytes(Charsets.UTF_8)), "encoder.encodeToString(c…tring(map).toByteArray())");
    return this.encoder.encodeToString(str.getBytes(Charsets.UTF_8));
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\005\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\b¨\006\t"}, d2 = {"Lio/javalin/http/util/CookieStore$Companion;", "", "()V", "COOKIE_NAME", "", "getCOOKIE_NAME", "()Ljava/lang/String;", "setCOOKIE_NAME", "(Ljava/lang/String;)V", "javalin"})
  public static final class Companion {
    private Companion() {}
    
    @NotNull
    public final String getCOOKIE_NAME() {
      return CookieStore.COOKIE_NAME;
    }
    
    public final void setCOOKIE_NAME(@NotNull String <set-?>) {
      Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
      CookieStore.COOKIE_NAME = <set-?>;
    }
  }
  
  @NotNull
  public static final Companion Companion = new Companion(null);
  
  @NotNull
  private final Context ctx;
  
  private final Base64.Encoder encoder;
  
  private final Base64.Decoder decoder;
  
  @NotNull
  private final Map<String, Object> cookieMap;
  
  @NotNull
  private static String COOKIE_NAME = "javalin-cookie-store";
}
