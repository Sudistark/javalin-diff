package io.javalin.json;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.util.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000\016\n\000\n\002\030\002\n\000\n\002\020\016\n\000\032\024\020\000\032\0020\001*\0020\0012\006\020\002\032\0020\003H\002¨\006\004"}, d2 = {"registerOptionalModule", "Lcom/fasterxml/jackson/databind/ObjectMapper;", "classString", "", "javalin"})
public final class JavalinJacksonKt {
  private static final ObjectMapper registerOptionalModule(ObjectMapper $this$registerOptionalModule, String classString) {
    if (Util.INSTANCE.classExists(classString)) {
      Intrinsics.checkNotNull(Class.forName(classString).getConstructor(new Class[0]).newInstance(new Object[0]), "null cannot be cast to non-null type com.fasterxml.jackson.databind.Module");
      $this$registerOptionalModule.registerModule((Module)Class.forName(classString).getConstructor(new Class[0]).newInstance(new Object[0]));
    } 
    return $this$registerOptionalModule;
  }
}
