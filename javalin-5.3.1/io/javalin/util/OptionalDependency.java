package io.javalin.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\013\bf\030\0002\0020\001R\022\020\002\032\0020\003X¦\004¢\006\006\032\004\b\004\020\005R\022\020\006\032\0020\003X¦\004¢\006\006\032\004\b\007\020\005R\022\020\b\032\0020\003X¦\004¢\006\006\032\004\b\t\020\005R\022\020\n\032\0020\003X¦\004¢\006\006\032\004\b\013\020\005R\022\020\f\032\0020\003X¦\004¢\006\006\032\004\b\r\020\005ø\001\000\002\006\n\004\b!0\001¨\006\016À\006\001"}, d2 = {"Lio/javalin/util/OptionalDependency;", "", "artifactId", "", "getArtifactId", "()Ljava/lang/String;", "displayName", "getDisplayName", "groupId", "getGroupId", "testClass", "getTestClass", "version", "getVersion", "javalin"})
public interface OptionalDependency {
  @NotNull
  String getDisplayName();
  
  @NotNull
  String getTestClass();
  
  @NotNull
  String getGroupId();
  
  @NotNull
  String getArtifactId();
  
  @NotNull
  String getVersion();
}
