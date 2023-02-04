package io.javalin.jetty;

import io.javalin.http.staticfiles.Location;
import io.javalin.http.staticfiles.StaticFileConfig;
import io.javalin.util.JavalinException;
import io.javalin.util.JavalinLogger;
import java.io.File;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.resource.Resource;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\020\016\n\002\b\004\b\026\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\020\020\t\032\0020\n2\006\020\013\032\0020\fH\026J\020\020\r\032\0020\f2\006\020\002\032\0020\003H\002R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\007\020\b¨\006\016²\006\022\020\017\032\n \020*\004\030\0010\n0\nX\002"}, d2 = {"Lio/javalin/jetty/ConfigurableHandler;", "Lorg/eclipse/jetty/server/handler/ResourceHandler;", "config", "Lio/javalin/http/staticfiles/StaticFileConfig;", "jettyServer", "Lorg/eclipse/jetty/server/Server;", "(Lio/javalin/http/staticfiles/StaticFileConfig;Lorg/eclipse/jetty/server/Server;)V", "getConfig", "()Lio/javalin/http/staticfiles/StaticFileConfig;", "getResource", "Lorg/eclipse/jetty/util/resource/Resource;", "path", "", "getResourceBase", "javalin", "aliasResource", "kotlin.jvm.PlatformType"})
public class ConfigurableHandler extends ResourceHandler {
  @NotNull
  private final StaticFileConfig config;
  
  public ConfigurableHandler(@NotNull StaticFileConfig config, @NotNull Server jettyServer) {
    this.config = config;
    JavalinLogger.info$default("Static file handler added: " + this.config.refinedToString$javalin() + ". File system location: '" + getResourceBase(this.config) + "'", null, 2, null);
    setResourceBase(getResourceBase(this.config));
    setDirAllowed(false);
    setEtags(true);
    setServer(jettyServer);
    start();
  }
  
  @NotNull
  public final StaticFileConfig getConfig() {
    return this.config;
  }
  
  @NotNull
  public Resource getResource(@NotNull String path) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'path'
    //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   6: new io/javalin/jetty/ConfigurableHandler$getResource$aliasResource$2
    //   9: dup
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial <init> : (Lio/javalin/jetty/ConfigurableHandler;Ljava/lang/String;)V
    //   15: checkcast kotlin/jvm/functions/Function0
    //   18: invokestatic lazy : (Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
    //   21: astore_2
    //   22: nop
    //   23: aload_0
    //   24: getfield config : Lio/javalin/http/staticfiles/StaticFileConfig;
    //   27: getfield directory : Ljava/lang/String;
    //   30: ldc 'META-INF/resources/webjars'
    //   32: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   35: ifeq -> 64
    //   38: aload_1
    //   39: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   44: invokestatic newClassPathResource : (Ljava/lang/String;)Lorg/eclipse/jetty/util/resource/Resource;
    //   47: dup
    //   48: ifnonnull -> 55
    //   51: pop
    //   52: getstatic org/eclipse/jetty/util/resource/EmptyResource.INSTANCE : Lorg/eclipse/jetty/util/resource/Resource;
    //   55: dup
    //   56: ldc 'Resource.newClassPathRes…?: EmptyResource.INSTANCE'
    //   58: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   61: goto -> 235
    //   64: aload_0
    //   65: getfield config : Lio/javalin/http/staticfiles/StaticFileConfig;
    //   68: getfield aliasCheck : Lorg/eclipse/jetty/server/handler/ContextHandler$AliasCheck;
    //   71: ifnull -> 148
    //   74: aload_2
    //   75: invokestatic getResource$lambda-0 : (Lkotlin/Lazy;)Lorg/eclipse/jetty/util/resource/Resource;
    //   78: invokevirtual isAlias : ()Z
    //   81: ifeq -> 148
    //   84: aload_0
    //   85: getfield config : Lio/javalin/http/staticfiles/StaticFileConfig;
    //   88: getfield aliasCheck : Lorg/eclipse/jetty/server/handler/ContextHandler$AliasCheck;
    //   91: dup
    //   92: ifnull -> 117
    //   95: aload_1
    //   96: aload_2
    //   97: invokestatic getResource$lambda-0 : (Lkotlin/Lazy;)Lorg/eclipse/jetty/util/resource/Resource;
    //   100: invokeinterface check : (Ljava/lang/String;Lorg/eclipse/jetty/util/resource/Resource;)Z
    //   105: iconst_1
    //   106: if_icmpne -> 113
    //   109: iconst_1
    //   110: goto -> 119
    //   113: iconst_0
    //   114: goto -> 119
    //   117: pop
    //   118: iconst_0
    //   119: ifeq -> 129
    //   122: aload_2
    //   123: invokestatic getResource$lambda-0 : (Lkotlin/Lazy;)Lorg/eclipse/jetty/util/resource/Resource;
    //   126: goto -> 139
    //   129: new java/nio/file/AccessDeniedException
    //   132: dup
    //   133: ldc 'Failed alias check'
    //   135: invokespecial <init> : (Ljava/lang/String;)V
    //   138: athrow
    //   139: dup
    //   140: ldc 'if (config.aliasCheck?.c…ion("Failed alias check")'
    //   142: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   145: goto -> 235
    //   148: aload_0
    //   149: getfield config : Lio/javalin/http/staticfiles/StaticFileConfig;
    //   152: getfield hostedPath : Ljava/lang/String;
    //   155: ldc '/'
    //   157: invokestatic areEqual : (Ljava/lang/Object;Ljava/lang/Object;)Z
    //   160: ifeq -> 177
    //   163: aload_0
    //   164: aload_1
    //   165: invokespecial getResource : (Ljava/lang/String;)Lorg/eclipse/jetty/util/resource/Resource;
    //   168: dup
    //   169: ldc 'super.getResource(path)'
    //   171: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   174: goto -> 235
    //   177: aload_1
    //   178: aload_0
    //   179: getfield config : Lio/javalin/http/staticfiles/StaticFileConfig;
    //   182: getfield hostedPath : Ljava/lang/String;
    //   185: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;)Ljava/lang/String;
    //   190: iconst_0
    //   191: iconst_2
    //   192: aconst_null
    //   193: invokestatic startsWith$default : (Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Z
    //   196: ifeq -> 226
    //   199: aload_0
    //   200: aload_1
    //   201: aload_0
    //   202: getfield config : Lio/javalin/http/staticfiles/StaticFileConfig;
    //   205: getfield hostedPath : Ljava/lang/String;
    //   208: checkcast java/lang/CharSequence
    //   211: invokestatic removePrefix : (Ljava/lang/String;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   214: invokespecial getResource : (Ljava/lang/String;)Lorg/eclipse/jetty/util/resource/Resource;
    //   217: dup
    //   218: ldc 'super.getResource(path.r…refix(config.hostedPath))'
    //   220: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   223: goto -> 235
    //   226: getstatic org/eclipse/jetty/util/resource/EmptyResource.INSTANCE : Lorg/eclipse/jetty/util/resource/Resource;
    //   229: dup
    //   230: ldc 'INSTANCE'
    //   232: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   235: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #83	-> 6
    //   #84	-> 22
    //   #85	-> 23
    //   #86	-> 38
    //   #88	-> 64
    //   #89	-> 84
    //   #91	-> 148
    //   #92	-> 177
    //   #93	-> 226
    //   #84	-> 235
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   22	214	2	aliasResource$delegate	Lkotlin/Lazy;
    //   0	236	0	this	Lio/javalin/jetty/ConfigurableHandler;
    //   0	236	1	path	Ljava/lang/String;
  }
  
  private static final Resource getResource$lambda-0(Lazy $aliasResource$delegate) {
    Lazy lazy = $aliasResource$delegate;
    return (Resource)lazy.getValue();
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\n\n\000\n\002\030\002\n\002\b\002\020\000\032\n \002*\004\030\0010\0010\001H\n¢\006\002\b\003"}, d2 = {"<anonymous>", "Lorg/eclipse/jetty/util/resource/Resource;", "kotlin.jvm.PlatformType", "invoke"})
  static final class ConfigurableHandler$getResource$aliasResource$2 extends Lambda implements Function0<Resource> {
    ConfigurableHandler$getResource$aliasResource$2(String $path) {
      super(0);
    }
    
    public final Resource invoke() {
      Intrinsics.checkNotNull(ConfigurableHandler.this.getBaseResource());
      return ConfigurableHandler.this.getBaseResource().addPath(URIUtil.canonicalPath(this.$path));
    }
  }
  
  private final String getResourceBase(StaticFileConfig config) {
    String noSuchDirMessage = "Static resource directory with path: '" + config.directory + "' does not exist.";
    String classpathHint = "Depending on your setup, empty folders might not get copied to classpath.";
    if (config.location == Location.CLASSPATH) {
      if (Resource.newClassPathResource(config.directory) == null || Resource.newClassPathResource(config.directory).toString() == null) {
        Resource.newClassPathResource(config.directory).toString();
        throw new JavalinException(noSuchDirMessage + " " + noSuchDirMessage);
      } 
      return Resource.newClassPathResource(config.directory).toString();
    } 
    if (!(new File(config.directory)).exists())
      throw new JavalinException(noSuchDirMessage); 
    return config.directory;
  }
}
