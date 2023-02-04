package io.javalin.routing;

import io.javalin.config.RoutingConfig;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\0008\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\"\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\004\032J\020\000\032\0020\0012\006\020\002\032\0020\0032\f\020\004\032\b\022\004\022\0020\0060\0052\006\020\007\032\0020\b2\016\b\002\020\t\032\b\022\004\022\0020\0130\n2\022\020\f\032\016\022\004\022\0020\006\022\004\022\0020\b0\rH\000\032X\020\016\032\b\022\004\022\0020\0010\0052\006\020\002\032\0020\0032\006\020\017\032\0020\0202\f\020\004\032\b\022\004\022\0020\0060\0052\006\020\007\032\0020\b2\016\b\002\020\t\032\b\022\004\022\0020\0130\n2\022\020\f\032\016\022\004\022\0020\006\022\004\022\0020\b0\rH\000\032\036\020\021\032\b\022\004\022\0020\b0\0052\006\020\022\032\0020\0012\006\020\023\032\0020\bH\000¨\006\024"}, d2 = {"constructRegex", "Lkotlin/text/Regex;", "options", "Lio/javalin/config/RoutingConfig;", "segments", "", "Lio/javalin/routing/PathSegment;", "regexSuffix", "", "regexOptions", "", "Lkotlin/text/RegexOption;", "mapper", "Lkotlin/Function1;", "constructRegexList", "matchEverySubPath", "", "values", "regex", "url", "javalin"})
public final class RoutingRegexesKt {
  private static final List<Regex> constructRegexList$addRegexForExtraWildcard(boolean $matchEverySubPath, RoutingConfig $options, List $segments, String $regexSuffix, Set<? extends RegexOption> $regexOptions, Function1<? super PathSegment, String> $mapper) {
    return $matchEverySubPath ? 
      CollectionsKt.listOf(constructRegex($options, CollectionsKt.plus($segments, PathSegment.Wildcard.INSTANCE), $regexSuffix, $regexOptions, $mapper)) : 
      
      CollectionsKt.emptyList();
  }
  
  @NotNull
  public static final List<Regex> constructRegexList(@NotNull RoutingConfig options, boolean matchEverySubPath, @NotNull List<? extends PathSegment> segments, @NotNull String regexSuffix, @NotNull Set<? extends RegexOption> regexOptions, @NotNull Function1<? super PathSegment, String> mapper) {
    Intrinsics.checkNotNullParameter(options, "options");
    Intrinsics.checkNotNullParameter(segments, "segments");
    Intrinsics.checkNotNullParameter(regexSuffix, "regexSuffix");
    Intrinsics.checkNotNullParameter(regexOptions, "regexOptions");
    Intrinsics.checkNotNullParameter(mapper, "mapper");
    return CollectionsKt.plus(CollectionsKt.listOf(constructRegex(options, segments, regexSuffix, regexOptions, mapper)), constructRegexList$addRegexForExtraWildcard(matchEverySubPath, options, segments, regexSuffix, regexOptions, mapper));
  }
  
  @NotNull
  public static final Regex constructRegex(@NotNull RoutingConfig options, @NotNull List segments, @NotNull String regexSuffix, @NotNull Set regexOptions, @NotNull Function1 mapper) {
    Intrinsics.checkNotNullParameter(options, "options");
    Intrinsics.checkNotNullParameter(segments, "segments");
    Intrinsics.checkNotNullParameter(regexSuffix, "regexSuffix");
    Intrinsics.checkNotNullParameter(regexOptions, "regexOptions");
    Intrinsics.checkNotNullParameter(mapper, "mapper");
    String slashRegex = options.treatMultipleSlashesAsSingleSlash ? 
      "/+" : 
      
      "/";
    StringBuilder stringBuilder1 = new StringBuilder(), $this$constructRegex_u24lambda_u2d0 = stringBuilder1;
    int $i$a$-buildString-RoutingRegexesKt$constructRegex$1 = 0;
    $this$constructRegex_u24lambda_u2d0.append("^/");
    if (options.treatMultipleSlashesAsSingleSlash)
      $this$constructRegex_u24lambda_u2d0.append("+"); 
    $this$constructRegex_u24lambda_u2d0.append(CollectionsKt.joinToString$default(segments, slashRegex, null, null, 0, null, mapper, 30, null));
    $this$constructRegex_u24lambda_u2d0.append(regexSuffix);
    $this$constructRegex_u24lambda_u2d0.append("$");
    Intrinsics.checkNotNullExpressionValue(stringBuilder1.toString(), "StringBuilder().apply(builderAction).toString()");
    String str1 = stringBuilder1.toString();
    return new Regex(str1, regexOptions);
  }
  
  @NotNull
  public static final List<String> values(@NotNull Regex regex, @NotNull String url) {
    Intrinsics.checkNotNullParameter(regex, "regex");
    Intrinsics.checkNotNullParameter(url, "url");
    if (regex.matchEntire(url) == null || regex.matchEntire(url).getGroupValues() == null || CollectionsKt.drop(regex.matchEntire(url).getGroupValues(), 1) == null)
      CollectionsKt.drop(regex.matchEntire(url).getGroupValues(), 1); 
    return CollectionsKt.emptyList();
  }
}
