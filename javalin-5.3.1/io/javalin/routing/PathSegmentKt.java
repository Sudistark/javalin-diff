package io.javalin.routing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000,\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\002\b\003\032\032\020\000\032\0020\0012\006\020\002\032\0020\0032\b\b\002\020\004\032\0020\005H\000\032\020\020\006\032\0020\0072\006\020\002\032\0020\003H\000\032\020\020\b\032\0020\t2\006\020\002\032\0020\003H\000\032\026\020\n\032\b\022\004\022\0020\f0\013*\b\022\004\022\0020\f0\013\032\f\020\r\032\0020\003*\0020\003H\002\032\022\020\016\032\b\022\004\022\0020\0030\013*\0020\fH\000¨\006\017"}, d2 = {"createNormal", "Lio/javalin/routing/PathSegment$Normal;", "string", "", "enableRegex", "", "createSlashAcceptingParam", "Lio/javalin/routing/PathSegment$Parameter$SlashAcceptingParameter;", "createSlashIgnoringParam", "Lio/javalin/routing/PathSegment$Parameter$SlashIgnoringParameter;", "flattenMultipleSegments", "", "Lio/javalin/routing/PathSegment;", "grouped", "pathParamNames", "javalin"})
public final class PathSegmentKt {
  private static final String grouped(String $this$grouped) {
    return "(" + $this$grouped + ")";
  }
  
  @NotNull
  public static final PathSegment.Normal createNormal(@NotNull String string, boolean enableRegex) {
    Intrinsics.checkNotNullParameter(string, "string");
    return enableRegex ? 
      new PathSegment.Normal.RegexAllowed(string) : 
      
      new PathSegment.Normal.RegexEscaped(string);
  }
  
  @NotNull
  public static final PathSegment.Parameter.SlashIgnoringParameter createSlashIgnoringParam(@NotNull String string) {
    Intrinsics.checkNotNullParameter(string, "string");
    return new PathSegment.Parameter.SlashIgnoringParameter(string);
  }
  
  @NotNull
  public static final PathSegment.Parameter.SlashAcceptingParameter createSlashAcceptingParam(@NotNull String string) {
    Intrinsics.checkNotNullParameter(string, "string");
    return new PathSegment.Parameter.SlashAcceptingParameter(string);
  }
  
  @NotNull
  public static final List<PathSegment> flattenMultipleSegments(@NotNull List $this$flattenMultipleSegments) {
    Intrinsics.checkNotNullParameter($this$flattenMultipleSegments, "<this>");
    Iterable $this$map$iv = $this$flattenMultipleSegments;
    int $i$f$map = 0;
    Iterable iterable1 = $this$map$iv;
    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : iterable1) {
      PathSegment pathSegment = (PathSegment)item$iv$iv;
      Collection collection = destination$iv$iv;
      int $i$a$-map-PathSegmentKt$flattenMultipleSegments$1 = 0;
    } 
    return CollectionsKt.flatten(destination$iv$iv);
  }
  
  @NotNull
  public static final List<String> pathParamNames(@NotNull PathSegment $this$pathParamNames) {
    Intrinsics.checkNotNullParameter($this$pathParamNames, "<this>");
    PathSegment pathSegment = $this$pathParamNames;
    if (pathSegment instanceof PathSegment.MultipleSegments) {
      Iterable<PathSegment> $this$filterIsInstance$iv = ((PathSegment.MultipleSegments)$this$pathParamNames).getInnerSegments();
      int $i$f$filterIsInstance = 0;
      Iterable<PathSegment> iterable1 = $this$filterIsInstance$iv;
      Collection<Object> collection = new ArrayList();
      int $i$f$filterIsInstanceTo = 0;
      for (PathSegment element$iv$iv : iterable1) {
        if (element$iv$iv instanceof PathSegment.Parameter)
          collection.add(element$iv$iv); 
      } 
      $this$filterIsInstance$iv = collection;
      int $i$f$map = 0;
      Iterable<PathSegment> $this$filterIsInstanceTo$iv$iv = $this$filterIsInstance$iv;
      Collection<String> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$filterIsInstance$iv, 10));
      int $i$f$mapTo = 0;
      for (PathSegment item$iv$iv : $this$filterIsInstanceTo$iv$iv) {
        PathSegment.Parameter parameter = (PathSegment.Parameter)item$iv$iv;
        Collection<String> collection1 = destination$iv$iv;
        int $i$a$-map-PathSegmentKt$pathParamNames$1 = 0;
        collection1.add(parameter.getName());
      } 
    } else {
      throw new NoWhenBranchMatchedException();
    } 
    return ((pathSegment instanceof PathSegment.Normal) ? true : (pathSegment instanceof PathSegment.Wildcard)) ? CollectionsKt.emptyList() : ((pathSegment instanceof PathSegment.Parameter) ? CollectionsKt.listOf(((PathSegment.Parameter)$this$pathParamNames).getName()) : (List<String>)"JD-Core does not support Kotlin");
  }
}
