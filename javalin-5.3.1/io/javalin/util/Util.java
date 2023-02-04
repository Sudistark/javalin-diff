package io.javalin.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000D\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\000\n\002\020\016\n\002\b\003\n\002\020$\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\006\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\b\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006JG\020\007\032\004\030\001H\b\"\004\b\000\020\b2\036\020\t\032\032\022\020\022\016\022\n\b\001\022\0060\fj\002`\r0\013\022\004\022\002H\b0\n2\022\020\016\032\016\022\n\b\001\022\0060\fj\002`\r0\013¢\006\002\020\017J\022\020\020\032\004\030\0010\0062\006\020\021\032\0020\006H\002J\016\020\022\032\0020\0062\006\020\023\032\0020\024J\020\020\025\032\004\030\0010\0262\006\020\027\032\0020\006J\024\020\030\032\0020\0062\n\020\031\032\0060\fj\002`\rH\007J\022\020\032\032\004\030\0010\0262\006\020\027\032\0020\006H\007J\020\020\033\032\0020\0342\006\020\035\032\0020\004H\007J\b\020\036\032\0020\034H\007J\020\020\037\032\0020\0062\006\020 \032\0020\006H\007J\030\020!\032\0020\0062\006\020 \032\0020\0062\006\020\027\032\0020\006H\007J\b\020\"\032\0020\034H\007J\b\020#\032\0020\004H\002¨\006$"}, d2 = {"Lio/javalin/util/Util;", "", "()V", "classExists", "", "className", "", "findByClass", "T", "map", "", "Ljava/lang/Class;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exceptionClass", "(Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;", "formatBuildTime", "buildTime", "getChecksumAndReset", "inputStream", "Ljava/io/ByteArrayInputStream;", "getFileUrl", "Ljava/net/URL;", "path", "getPort", "e", "getResourceUrl", "logJavalinBanner", "", "showBanner", "logJavalinVersion", "normalizeContextPath", "contextPath", "prefixContextPath", "printHelpfulMessageIfLoggerIsMissing", "slf4jServiceImplementationExists", "javalin"})
public final class Util {
  @NotNull
  public static final Util INSTANCE = new Util();
  
  @JvmStatic
  @NotNull
  public static final String normalizeContextPath(@NotNull String contextPath) {
    Intrinsics.checkNotNullParameter(contextPath, "contextPath");
    CharSequence charSequence = "/" + contextPath;
    Regex regex = new Regex("/{2,}");
    String str = "/";
    return Intrinsics.areEqual(contextPath, "/") ? "/" : StringsKt.removeSuffix(regex.replace(charSequence, str), "/");
  }
  
  @JvmStatic
  @NotNull
  public static final String prefixContextPath(@NotNull String contextPath, @NotNull String path) {
    Intrinsics.checkNotNullParameter(contextPath, "contextPath");
    Intrinsics.checkNotNullParameter(path, "path");
    CharSequence charSequence = contextPath + "/" + contextPath;
    Regex regex = new Regex("/{2,}");
    String str = "/";
    return Intrinsics.areEqual(path, "*") ? path : regex.replace(charSequence, str);
  }
  
  public final boolean classExists(@NotNull String className) {
    boolean bool;
    Intrinsics.checkNotNullParameter(className, "className");
    try {
      Class.forName(className);
      bool = true;
    } catch (ClassNotFoundException e) {
      bool = false;
    } 
    return bool;
  }
  
  private final boolean slf4jServiceImplementationExists() {
    boolean bool;
    try {
      Class<?> serviceClass = Class.forName("org.slf4j.spi.SLF4JServiceProvider");
      ServiceLoader<?> loader = ServiceLoader.load(serviceClass);
      Intrinsics.checkNotNullExpressionValue(loader, "loader");
      bool = CollectionsKt.any(loader);
    } catch (ClassNotFoundException e) {
      bool = false;
    } 
    return bool;
  }
  
  @JvmStatic
  public static final void printHelpfulMessageIfLoggerIsMissing() {
    boolean hasLogger = (INSTANCE.classExists(CoreDependency.SLF4JSIMPLE.getTestClass()) || INSTANCE.slf4jServiceImplementationExists());
    if (!hasLogger)
      System.err.println(
          DependencyUtil.INSTANCE.wrapInSeparators(




            
            StringsKt.trimMargin$default("|Javalin: It looks like you don't have a logger in your project.\n                       |The easiest way to fix this is to add '" + CoreDependency.SLF4JSIMPLE.getArtifactId() + "':\n                       |\n                       |" + DependencyUtil.INSTANCE.mavenAndGradleSnippets(CoreDependency.SLF4JSIMPLE) + "\n                       |\n                       |Visit https://javalin.io/documentation#logging if you need more help", null, 1, null))); 
  }
  
  @JvmStatic
  public static final void logJavalinBanner(boolean showBanner) {
    if (showBanner)
      JavalinLogger.info$default(







          
          "\n       __                  ___          ______\n      / /___ __   ______ _/ (_)___     / ____/\n __  / / __ `/ | / / __ `/ / / __ \\   /___ \\\n/ /_/ / /_/ /| |/ / /_/ / / / / / /  ____/ /\n\\____/\\__,_/ |___/\\__,_/_/_/_/ /_/  /_____/\n\n       https://javalin.io/documentation\n", null, 2, null); 
  }
  
  @JvmStatic
  public static final void logJavalinVersion() {
    try {
      Properties properties1 = new Properties(), it = properties1;
      int $i$a$-also-Util$logJavalinVersion$properties$1 = 0;
      String propertiesPath = "META-INF/maven/io.javalin/javalin/pom.properties";
      it.load(INSTANCE.getClass().getClassLoader().getResourceAsStream(propertiesPath));
      Properties properties = properties1;
      String[] arrayOfString = new String[2];
      Intrinsics.checkNotNull(properties.getProperty("version"));
      arrayOfString[0] = properties.getProperty("version");
      Intrinsics.checkNotNull(properties.getProperty("buildTime"));
      arrayOfString[1] = properties.getProperty("buildTime");
      List<String> list = CollectionsKt.listOf((Object[])arrayOfString);
      String version = list.get(0), buildTime = list.get(1);
      JavalinLogger.startup("You are running Javalin " + version + " (released " + INSTANCE.formatBuildTime(buildTime) + ").");
    } catch (Exception exception) {}
  }
  
  private final String formatBuildTime(String buildTime) {
    String str;
    try {
      Instant[] arrayOfInstant = new Instant[2];
      arrayOfInstant[0] = Instant.parse(buildTime);
      arrayOfInstant[1] = Instant.now();
      List<Instant> list = CollectionsKt.listOf((Object[])arrayOfInstant);
      Instant release = list.get(0), now = list.get(1);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy").withLocale(Locale.US).withZone(ZoneId.of("Z"));
      str = formatter.format(release) + formatter.format(release);
    } catch (Exception e) {
      str = (String)null;
    } 
    return str;
  }
  
  @NotNull
  public final String getChecksumAndReset(@NotNull ByteArrayInputStream inputStream) {
    Intrinsics.checkNotNullParameter(inputStream, "inputStream");
    CheckedInputStream cis = new CheckedInputStream(inputStream, new Adler32());
    int byte = cis.read();
    while (byte > -1)
      byte = cis.read(); 
    inputStream.reset();
    return String.valueOf(cis.getChecksum().getValue());
  }
  
  @JvmStatic
  @Nullable
  public static final URL getResourceUrl(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    return INSTANCE.getClass().getClassLoader().getResource(path);
  }
  
  @Nullable
  public final URL getFileUrl(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    return (new File(path)).exists() ? (new File(path)).toURI().toURL() : null;
  }
  
  @JvmStatic
  @NotNull
  public static final String getPort(@NotNull Exception e) {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 'e'
    //   4: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_0
    //   8: invokevirtual getMessage : ()Ljava/lang/String;
    //   11: dup
    //   12: invokestatic checkNotNull : (Ljava/lang/Object;)V
    //   15: astore_1
    //   16: iconst_0
    //   17: istore_2
    //   18: aload_1
    //   19: checkcast java/lang/CharSequence
    //   22: invokestatic getLastIndex : (Ljava/lang/CharSequence;)I
    //   25: istore_3
    //   26: iconst_m1
    //   27: iload_3
    //   28: if_icmpge -> 87
    //   31: aload_1
    //   32: iload_3
    //   33: invokevirtual charAt : (I)C
    //   36: istore #4
    //   38: iconst_0
    //   39: istore #5
    //   41: iload #4
    //   43: bipush #58
    //   45: if_icmpeq -> 52
    //   48: iconst_1
    //   49: goto -> 53
    //   52: iconst_0
    //   53: ifne -> 81
    //   56: aload_1
    //   57: astore #4
    //   59: iload_3
    //   60: iconst_1
    //   61: iadd
    //   62: istore #5
    //   64: aload #4
    //   66: iload #5
    //   68: invokevirtual substring : (I)Ljava/lang/String;
    //   71: dup
    //   72: ldc_w 'this as java.lang.String).substring(startIndex)'
    //   75: invokestatic checkNotNullExpressionValue : (Ljava/lang/Object;Ljava/lang/String;)V
    //   78: goto -> 88
    //   81: iinc #3, -1
    //   84: goto -> 26
    //   87: aload_1
    //   88: areturn
    // Line number table:
    //   Java source line number -> byte code offset
    //   #116	-> 7
    //   #131	-> 18
    //   #132	-> 31
    //   #116	-> 41
    //   #133	-> 56
    //   #133	-> 78
    //   #131	-> 81
    //   #136	-> 87
    //   #116	-> 88
    // Local variable table:
    //   start	length	slot	name	descriptor
    //   41	12	5	$i$a$-takeLastWhile-Util$getPort$1	I
    //   38	15	4	it	C
    //   26	61	3	index$iv	I
    //   18	70	2	$i$f$takeLastWhile	I
    //   16	72	1	$this$takeLastWhile$iv	Ljava/lang/String;
    //   0	89	0	e	Ljava/lang/Exception;
  }
  
  @Nullable
  public final <T> T findByClass(@NotNull Map map, @NotNull Class exceptionClass) {
    Intrinsics.checkNotNullParameter(map, "map");
    Intrinsics.checkNotNullParameter(exceptionClass, "exceptionClass");
    if (map.get(exceptionClass) == null) {
      map.get(exceptionClass);
      int $i$a$-getOrElse-Util$findByClass$1 = 0;
      Class superclass = exceptionClass.getSuperclass();
      while (superclass != null) {
        if (map.containsKey(superclass))
          return (T)map.get(superclass); 
        superclass = superclass.getSuperclass();
      } 
      return null;
    } 
    return (T)map.get(exceptionClass);
  }
}
