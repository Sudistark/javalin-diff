package io.javalin.http.util;

import io.javalin.http.UploadedFile;
import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000D\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\002\030\002\n\002\020\002\n\002\b\005\n\002\020$\n\002\020 \n\002\b\004\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\002\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J \020\r\032\024\022\004\022\0020\004\022\n\022\b\022\004\022\0020\0040\0170\0162\006\020\020\032\0020\007J\036\020\021\032\b\022\004\022\0020\0040\0172\006\020\020\032\0020\0072\006\020\022\032\0020\004H\002J \020\023\032\024\022\004\022\0020\004\022\n\022\b\022\004\022\0020\0240\0170\0162\006\020\020\032\0020\007J\024\020\025\032\b\022\004\022\0020\0240\0172\006\020\020\032\0020\007J\034\020\025\032\b\022\004\022\0020\0240\0172\006\020\020\032\0020\0072\006\020\022\032\0020\004J\020\020\026\032\0020\0272\006\020\030\032\0020\031H\002J\020\020\032\032\0020\0272\006\020\030\032\0020\031H\002R\016\020\003\032\0020\004XT¢\006\002\n\000R&\020\005\032\016\022\004\022\0020\007\022\004\022\0020\b0\006X\016¢\006\016\n\000\032\004\b\t\020\n\"\004\b\013\020\f¨\006\033"}, d2 = {"Lio/javalin/http/util/MultipartUtil;", "", "()V", "MULTIPART_CONFIG_ATTRIBUTE", "", "preUploadFunction", "Lkotlin/Function1;", "Ljakarta/servlet/http/HttpServletRequest;", "", "getPreUploadFunction", "()Lkotlin/jvm/functions/Function1;", "setPreUploadFunction", "(Lkotlin/jvm/functions/Function1;)V", "getFieldMap", "", "", "req", "getPartValue", "partName", "getUploadedFileMap", "Lio/javalin/http/UploadedFile;", "getUploadedFiles", "isField", "", "filePart", "Ljakarta/servlet/http/Part;", "isFile", "javalin"})
public final class MultipartUtil {
  @NotNull
  public static final MultipartUtil INSTANCE = new MultipartUtil();
  
  @NotNull
  public static final String MULTIPART_CONFIG_ATTRIBUTE = "org.eclipse.jetty.multipartConfig";
  
  @NotNull
  private static Function1<? super HttpServletRequest, Unit> preUploadFunction = MultipartUtil$preUploadFunction$1.INSTANCE;
  
  @NotNull
  public final Function1<HttpServletRequest, Unit> getPreUploadFunction() {
    return (Function1)preUploadFunction;
  }
  
  public final void setPreUploadFunction(@NotNull Function1<? super HttpServletRequest, Unit> <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    preUploadFunction = <set-?>;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\002\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "req", "Ljakarta/servlet/http/HttpServletRequest;", "invoke"})
  static final class MultipartUtil$preUploadFunction$1 extends Lambda implements Function1<HttpServletRequest, Unit> {
    public static final MultipartUtil$preUploadFunction$1 INSTANCE = new MultipartUtil$preUploadFunction$1();
    
    public final void invoke(@NotNull HttpServletRequest req) {
      Intrinsics.checkNotNullParameter(req, "req");
      Object existingConfig = req.getAttribute("org.eclipse.jetty.multipartConfig");
      if (existingConfig == null)
        req.setAttribute(
            "org.eclipse.jetty.multipartConfig", 
            new MultipartConfigElement(System.getProperty("java.io.tmpdir"), -1L, -1L, 1)); 
    }
    
    MultipartUtil$preUploadFunction$1() {
      super(1);
    }
  }
  
  @NotNull
  public final List<UploadedFile> getUploadedFiles(@NotNull HttpServletRequest req, @NotNull String partName) {
    Intrinsics.checkNotNullParameter(req, "req");
    Intrinsics.checkNotNullParameter(partName, "partName");
    preUploadFunction.invoke(req);
    Intrinsics.checkNotNullExpressionValue(req.getParts(), "req.parts");
    Iterable $this$filter$iv = req.getParts();
    int $i$f$filter = 0;
    Iterable iterable1 = $this$filter$iv;
    Collection<Object> collection = new ArrayList();
    int $i$f$filterTo = 0;
    for (Object element$iv$iv : iterable1) {
      Part it = (Part)element$iv$iv;
      int $i$a$-filter-MultipartUtil$getUploadedFiles$1 = 0;
      Intrinsics.checkNotNullExpressionValue(it, "it");
      if ((INSTANCE.isFile(it) && Intrinsics.areEqual(it.getName(), partName)))
        collection.add(element$iv$iv); 
    } 
    $this$filter$iv = collection;
    int $i$f$map = 0;
    Iterable $this$filterTo$iv$iv = $this$filter$iv;
    Collection<UploadedFile> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$filter$iv, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : $this$filterTo$iv$iv) {
      Part part = (Part)item$iv$iv;
      Collection<UploadedFile> collection1 = destination$iv$iv;
      int $i$a$-map-MultipartUtil$getUploadedFiles$2 = 0;
      Intrinsics.checkNotNullExpressionValue(part, "it");
      collection1.add(new UploadedFile(part));
    } 
    return (List<UploadedFile>)destination$iv$iv;
  }
  
  @NotNull
  public final List<UploadedFile> getUploadedFiles(@NotNull HttpServletRequest req) {
    Intrinsics.checkNotNullParameter(req, "req");
    preUploadFunction.invoke(req);
    Intrinsics.checkNotNullExpressionValue(req.getParts(), "req.parts");
    Iterable $this$filter$iv = req.getParts();
    int $i$f$filter = 0;
    Iterable iterable1 = $this$filter$iv;
    Collection<Object> collection = new ArrayList();
    int $i$f$filterTo = 0;
    for (Object element$iv$iv : iterable1) {
      Part p0 = (Part)element$iv$iv;
      int $i$a$-filter-MultipartUtil$getUploadedFiles$3 = 0;
      if (isFile(p0))
        collection.add(element$iv$iv); 
    } 
    $this$filter$iv = collection;
    int $i$f$map = 0;
    Iterable $this$filterTo$iv$iv = $this$filter$iv;
    Collection<UploadedFile> destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$filter$iv, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : $this$filterTo$iv$iv) {
      Part part = (Part)item$iv$iv;
      Collection<UploadedFile> collection1 = destination$iv$iv;
      int $i$a$-map-MultipartUtil$getUploadedFiles$4 = 0;
      Intrinsics.checkNotNullExpressionValue(part, "it");
      collection1.add(new UploadedFile(part));
    } 
    return (List<UploadedFile>)destination$iv$iv;
  }
  
  @NotNull
  public final Map<String, List<UploadedFile>> getUploadedFileMap(@NotNull HttpServletRequest req) {
    Intrinsics.checkNotNullParameter(req, "req");
    preUploadFunction.invoke(req);
    Intrinsics.checkNotNullExpressionValue(req.getParts(), "req\n            .parts");
    Collection collection1 = req.getParts();
    int $i$f$filter = 0;
    Collection collection2 = collection1;
    Collection<Object> collection = new ArrayList();
    int $i$f$filterTo = 0;
    for (Object element$iv$iv : collection2) {
      Part p0 = (Part)element$iv$iv;
      int $i$a$-filter-MultipartUtil$getUploadedFileMap$1 = 0;
      if (isFile(p0))
        collection.add(element$iv$iv); 
    } 
    Iterable $this$filter$iv = collection;
    int $i$f$groupBy = 0;
    Iterable $this$filterTo$iv$iv = $this$filter$iv;
    Map<Object, Object> map3 = new LinkedHashMap<>();
    int $i$f$groupByTo = 0;
    for (Object element$iv$iv : $this$filterTo$iv$iv) {
      Part it = (Part)element$iv$iv;
      int $i$a$-groupBy-MultipartUtil$getUploadedFileMap$2 = 0;
      Object key$iv$iv = it.getName();
      Map<Object, Object> $this$getOrPut$iv$iv$iv = map3;
      int $i$f$getOrPut = 0;
      Object value$iv$iv$iv = $this$getOrPut$iv$iv$iv.get(key$iv$iv);
    } 
    Map<Object, Object> map1 = map3;
    int $i$f$mapValues = 0;
    Map<Object, Object> map2 = map1, destination$iv$iv = new LinkedHashMap<>(MapsKt.mapCapacity(map1.size()));
    int $i$f$mapValuesTo = 0;
    Iterable<Map.Entry<Object, Object>> $this$associateByTo$iv$iv$iv = map2.entrySet();
    int $i$f$associateByTo = 0;
    for (Object<Object, Object> element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
      Map.Entry entry1 = (Map.Entry)element$iv$iv$iv;
      Map<Object, Object> map4 = destination$iv$iv;
      int $i$a$-associateByTo-MapsKt__MapsKt$mapValuesTo$1$iv$iv = 0;
      Map.Entry entry2 = (Map.Entry)element$iv$iv$iv;
      Object object = entry1.getKey();
      Map<Object, Object> map5 = map4;
      int $i$a$-mapValues-MultipartUtil$getUploadedFileMap$3 = 0;
    } 
    return (Map)destination$iv$iv;
  }
  
  @NotNull
  public final Map<String, List<String>> getFieldMap(@NotNull HttpServletRequest req) {
    Intrinsics.checkNotNullParameter(req, "req");
    preUploadFunction.invoke(req);
    Intrinsics.checkNotNullExpressionValue(req.getParts(), "req.parts");
    Iterable $this$associate$iv = req.getParts();
    int $i$f$associate = 0;
    int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
    Iterable iterable1 = $this$associate$iv;
    Map<Object, Object> destination$iv$iv = new LinkedHashMap<>(capacity$iv);
    int $i$f$associateTo = 0;
    for (Object element$iv$iv : iterable1) {
      Map<Object, Object> map = destination$iv$iv;
      Part part = (Part)element$iv$iv;
      int $i$a$-associate-MultipartUtil$getFieldMap$1 = 0;
      Intrinsics.checkNotNullExpressionValue(part.getName(), "part.name");
      Pair pair = TuplesKt.to(part.getName(), INSTANCE.getPartValue(req, part.getName()));
      map.put(pair.getFirst(), pair.getSecond());
    } 
    return (Map)destination$iv$iv;
  }
  
  private final List<String> getPartValue(HttpServletRequest req, String partName) {
    Intrinsics.checkNotNullExpressionValue(req.getParts(), "req.parts");
    Iterable $this$filter$iv = req.getParts();
    int $i$f$filter = 0;
    Iterable iterable1 = $this$filter$iv;
    Collection<Object> collection = new ArrayList();
    int $i$f$filterTo = 0;
    for (Object element$iv$iv : iterable1) {
      Part it = (Part)element$iv$iv;
      int $i$a$-filter-MultipartUtil$getPartValue$1 = 0;
      Intrinsics.checkNotNullExpressionValue(it, "it");
      if ((INSTANCE.isField(it) && Intrinsics.areEqual(it.getName(), partName)))
        collection.add(element$iv$iv); 
    } 
    $this$filter$iv = collection;
    int $i$f$map = 0;
    Iterable $this$filterTo$iv$iv = $this$filter$iv;
    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$filter$iv, 10));
    int $i$f$mapTo = 0;
    for (Object item$iv$iv : $this$filterTo$iv$iv) {
      Part part = (Part)item$iv$iv;
      Collection collection1 = destination$iv$iv;
      int $i$a$-map-MultipartUtil$getPartValue$2 = 0;
      InputStream inputStream = part.getInputStream();
      Object object = null;
    } 
    return CollectionsKt.toList(destination$iv$iv);
  }
  
  private final boolean isField(Part filePart) {
    return (filePart.getSubmittedFileName() == null);
  }
  
  private final boolean isFile(Part filePart) {
    return !isField(filePart);
  }
}
