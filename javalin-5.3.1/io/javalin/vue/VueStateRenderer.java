package io.javalin.vue;

import io.javalin.http.Context;
import io.javalin.json.JsonMapper;
import io.javalin.json.JsonMapperKt;
import java.net.URLEncoder;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\002\b\003\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\030\020\003\032\0020\0042\006\020\005\032\0020\0062\b\020\007\032\004\030\0010\001J\f\020\b\032\0020\004*\0020\004H\002¨\006\t"}, d2 = {"Lio/javalin/vue/VueStateRenderer;", "", "()V", "getState", "", "ctx", "Lio/javalin/http/Context;", "state", "urlEncodeForJavascript", "javalin"})
public final class VueStateRenderer {
  @NotNull
  public static final VueStateRenderer INSTANCE = new VueStateRenderer();
  
  @NotNull
  public final String getState(@NotNull Context ctx, @Nullable Object state) {
    Intrinsics.checkNotNullParameter(ctx, "ctx");
    JavalinVueConfig cfg = ctx.<JavalinVueConfig>appAttribute("javalin-javalinvue-config");
    String prototypeOrGlobalConfig = (cfg.vueAppName != null) ? (cfg.vueAppName + ".config.globalProperties") : "Vue.prototype";
    return 


      
      StringsKt.trimIndent("\n            <script nonce=\"@internalAddNonce\">\n                " + prototypeOrGlobalConfig + ".$javalin = JSON.parse(decodeURIComponent('" + getState$urlEncodedState(ctx, cfg, state) + "'))\n            </script>\n        ");
  }
  
  private static final String getState$urlEncodedState(Context $ctx, JavalinVueConfig cfg, Object state) {
    JsonMapper jsonMapper = JsonMapperKt.jsonMapper($ctx);
    Pair[] arrayOfPair = new Pair[2];
    arrayOfPair[0] = TuplesKt.to("pathParams", $ctx.pathParamMap());
    if (state == null);
    true["state"] = TuplesKt.to(state, cfg.stateFunction.invoke($ctx));
    Map map = MapsKt.mapOf(arrayOfPair);
    int $i$f$toJsonString = 0;
    return arrayOfPair.urlEncodeForJavascript(jsonMapper.toJsonString(map, TypesJVMKt.getJavaType(Reflection.typeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class))))));
  }
  
  private final String urlEncodeForJavascript(String $this$urlEncodeForJavascript) {
    Intrinsics.checkNotNullExpressionValue(URLEncoder.encode($this$urlEncodeForJavascript, Charsets.UTF_8.name()), "encode(this, Charsets.UTF_8.name())");
    return StringsKt.replace$default(URLEncoder.encode($this$urlEncodeForJavascript, Charsets.UTF_8.name()), "+", "%20", false, 4, null);
  }
}
