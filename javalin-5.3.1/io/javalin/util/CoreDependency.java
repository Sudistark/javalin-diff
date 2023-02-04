package io.javalin.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\026\n\002\030\002\n\002\020\020\n\002\030\002\n\000\n\002\020\016\n\002\b\024\b\001\030\0002\b\022\004\022\0020\0000\0012\0020\002B/\b\002\022\006\020\003\032\0020\004\022\006\020\005\032\0020\004\022\006\020\006\032\0020\004\022\006\020\007\032\0020\004\022\006\020\b\032\0020\004¢\006\002\020\tR\024\020\007\032\0020\004X\004¢\006\b\n\000\032\004\b\n\020\013R\024\020\003\032\0020\004X\004¢\006\b\n\000\032\004\b\f\020\013R\024\020\006\032\0020\004X\004¢\006\b\n\000\032\004\b\r\020\013R\024\020\005\032\0020\004X\004¢\006\b\n\000\032\004\b\016\020\013R\024\020\b\032\0020\004X\004¢\006\b\n\000\032\004\b\017\020\013j\002\b\020j\002\b\021j\002\b\022j\002\b\023j\002\b\024j\002\b\025j\002\b\026j\002\b\027¨\006\030"}, d2 = {"Lio/javalin/util/CoreDependency;", "", "Lio/javalin/util/OptionalDependency;", "displayName", "", "testClass", "groupId", "artifactId", "version", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArtifactId", "()Ljava/lang/String;", "getDisplayName", "getGroupId", "getTestClass", "getVersion", "JACKSON", "JACKSON_KT", "JACKSON_JSR_310", "JACKSON_ECLIPSE_COLLECTIONS", "JACKSON_KTORM", "GSON", "SLF4JSIMPLE", "JVMBROTLI", "javalin"})
public enum CoreDependency implements OptionalDependency {
  JACKSON("Jackson", "com.fasterxml.jackson.databind.ObjectMapper", "com.fasterxml.jackson.core", "jackson-databind", "2.14.0"),
  JACKSON_KT("JacksonKt", "com.fasterxml.jackson.module.kotlin.KotlinModule", "com.fasterxml.jackson.module", "jackson-module-kotlin", "2.14.0"),
  JACKSON_JSR_310("JacksonJsr310", "com.fasterxml.jackson.datatype.jsr310.JavaTimeModule", "com.fasterxml.jackson.datatype", "jackson-datatype-jsr310", "2.14.0"),
  JACKSON_ECLIPSE_COLLECTIONS("JacksonEclipseCollections", "com.fasterxml.jackson.datatype.eclipsecollections.EclipseCollectionsModule", "com.fasterxml.jackson.datatype", "jackson-datatype-eclipse-collections", "2.14.0"),
  JACKSON_KTORM("Jackson Ktorm", "org.ktorm.jackson.KtormModule", "org.ktorm", "ktorm-jackson", "3.4.1"),
  GSON("Gson", "com.google.gson.Gson", "com.google.code.gson", "gson", "2.10"),
  SLF4JSIMPLE("Slf4j simple", "org.slf4j.impl.StaticLoggerBinder", "org.slf4j", "slf4j-simple", "2.0.3"),
  JVMBROTLI("Jvm-Brotli", "com.nixxcode.jvmbrotli.common.BrotliLoader", "com.nixxcode.jvmbrotli", "jvmbrotli", "0.2.0");
  
  @NotNull
  private final String displayName;
  
  @NotNull
  private final String testClass;
  
  @NotNull
  private final String groupId;
  
  @NotNull
  private final String artifactId;
  
  @NotNull
  private final String version;
  
  CoreDependency(String displayName, String testClass, String groupId, String artifactId, String version) {
    this.displayName = displayName;
    this.testClass = testClass;
    this.groupId = groupId;
    this.artifactId = artifactId;
    this.version = version;
  }
  
  @NotNull
  public String getDisplayName() {
    return this.displayName;
  }
  
  @NotNull
  public String getTestClass() {
    return this.testClass;
  }
  
  @NotNull
  public String getGroupId() {
    return this.groupId;
  }
  
  @NotNull
  public String getArtifactId() {
    return this.artifactId;
  }
  
  @NotNull
  public String getVersion() {
    return this.version;
  }
}
