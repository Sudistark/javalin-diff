package io.javalin.routing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\007\n\002\030\002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\b6\030\0002\0020\001:\004\b\t\n\013B\007\b\004¢\006\002\020\002J\r\020\003\032\0020\004H ¢\006\002\b\005J\r\020\006\032\0020\004H ¢\006\002\b\007\001\004\f\r\016\017¨\006\020"}, d2 = {"Lio/javalin/routing/PathSegment;", "", "()V", "asGroupedRegexString", "", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "MultipleSegments", "Normal", "Parameter", "Wildcard", "Lio/javalin/routing/PathSegment$MultipleSegments;", "Lio/javalin/routing/PathSegment$Normal;", "Lio/javalin/routing/PathSegment$Parameter;", "Lio/javalin/routing/PathSegment$Wildcard;", "javalin"})
public abstract class PathSegment {
  private PathSegment() {}
  
  @NotNull
  public abstract String asRegexString$javalin();
  
  @NotNull
  public abstract String asGroupedRegexString$javalin();
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\005\n\002\030\002\n\002\030\002\n\000\b6\030\0002\0020\001:\002\007\bB\017\b\004\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006\001\002\t\n¨\006\013"}, d2 = {"Lio/javalin/routing/PathSegment$Normal;", "Lio/javalin/routing/PathSegment;", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "RegexAllowed", "RegexEscaped", "Lio/javalin/routing/PathSegment$Normal$RegexAllowed;", "Lio/javalin/routing/PathSegment$Normal$RegexEscaped;", "javalin"})
  public static abstract class Normal extends PathSegment {
    @NotNull
    private final String content;
    
    private Normal(String content) {
      super(null);
      this.content = content;
    }
    
    @NotNull
    public final String getContent() {
      return this.content;
    }
    
    @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\006\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\r\020\005\032\0020\003H\020¢\006\002\b\006J\r\020\007\032\0020\003H\020¢\006\002\b\b¨\006\t"}, d2 = {"Lio/javalin/routing/PathSegment$Normal$RegexEscaped;", "Lio/javalin/routing/PathSegment$Normal;", "content", "", "(Ljava/lang/String;)V", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
    public static final class RegexEscaped extends Normal {
      public RegexEscaped(@NotNull String content) {
        super(content, null);
      }
      
      @NotNull
      public String asRegexString$javalin() {
        return Regex.Companion.escape(getContent());
      }
      
      @NotNull
      public String asGroupedRegexString$javalin() {
        return Regex.Companion.escape(getContent());
      }
    }
    
    @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\006\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\r\020\005\032\0020\003H\020¢\006\002\b\006J\r\020\007\032\0020\003H\020¢\006\002\b\b¨\006\t"}, d2 = {"Lio/javalin/routing/PathSegment$Normal$RegexAllowed;", "Lio/javalin/routing/PathSegment$Normal;", "content", "", "(Ljava/lang/String;)V", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
    public static final class RegexAllowed extends Normal {
      public RegexAllowed(@NotNull String content) {
        super(content, null);
      }
      
      @NotNull
      public String asRegexString$javalin() {
        return getContent();
      }
      
      @NotNull
      public String asGroupedRegexString$javalin() {
        return getContent();
      }
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\034\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\005\n\002\030\002\n\002\030\002\n\000\b6\030\0002\0020\001:\002\007\bB\017\b\004\022\006\020\002\032\0020\003¢\006\002\020\004R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\005\020\006\001\002\t\n¨\006\013"}, d2 = {"Lio/javalin/routing/PathSegment$Parameter;", "Lio/javalin/routing/PathSegment;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "SlashAcceptingParameter", "SlashIgnoringParameter", "Lio/javalin/routing/PathSegment$Parameter$SlashAcceptingParameter;", "Lio/javalin/routing/PathSegment$Parameter$SlashIgnoringParameter;", "javalin"})
  public static abstract class Parameter extends PathSegment {
    @NotNull
    private final String name;
    
    private Parameter(String name) {
      super(null);
      this.name = name;
    }
    
    @NotNull
    public final String getName() {
      return this.name;
    }
    
    @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\006\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\r\020\005\032\0020\003H\020¢\006\002\b\006J\r\020\007\032\0020\003H\020¢\006\002\b\b¨\006\t"}, d2 = {"Lio/javalin/routing/PathSegment$Parameter$SlashIgnoringParameter;", "Lio/javalin/routing/PathSegment$Parameter;", "name", "", "(Ljava/lang/String;)V", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
    public static final class SlashIgnoringParameter extends Parameter {
      public SlashIgnoringParameter(@NotNull String name) {
        super(name, null);
      }
      
      @NotNull
      public String asRegexString$javalin() {
        return "[^/]+?";
      }
      
      @NotNull
      public String asGroupedRegexString$javalin() {
        return PathSegmentKt.access$grouped(asRegexString$javalin());
      }
    }
    
    @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\022\n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\006\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\r\020\005\032\0020\003H\020¢\006\002\b\006J\r\020\007\032\0020\003H\020¢\006\002\b\b¨\006\t"}, d2 = {"Lio/javalin/routing/PathSegment$Parameter$SlashAcceptingParameter;", "Lio/javalin/routing/PathSegment$Parameter;", "name", "", "(Ljava/lang/String;)V", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
    public static final class SlashAcceptingParameter extends Parameter {
      public SlashAcceptingParameter(@NotNull String name) {
        super(name, null);
      }
      
      @NotNull
      public String asRegexString$javalin() {
        return ".+?";
      }
      
      @NotNull
      public String asGroupedRegexString$javalin() {
        return PathSegmentKt.access$grouped(asRegexString$javalin());
      }
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\024\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\004\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\r\020\003\032\0020\004H\020¢\006\002\b\005J\r\020\006\032\0020\004H\020¢\006\002\b\007¨\006\b"}, d2 = {"Lio/javalin/routing/PathSegment$Wildcard;", "Lio/javalin/routing/PathSegment;", "()V", "asGroupedRegexString", "", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
  public static final class Wildcard extends PathSegment {
    @NotNull
    public static final Wildcard INSTANCE = new Wildcard();
    
    private Wildcard() {
      super(null);
    }
    
    @NotNull
    public String asRegexString$javalin() {
      return ".*?";
    }
    
    @NotNull
    public String asGroupedRegexString$javalin() {
      return asRegexString$javalin();
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\032\n\002\030\002\n\002\030\002\n\000\n\002\020 \n\002\b\002\n\002\020\016\n\002\b\t\030\0002\0020\001B\023\022\f\020\002\032\b\022\004\022\0020\0010\003¢\006\002\020\004J\r\020\013\032\0020\006H\020¢\006\002\b\fJ\r\020\r\032\0020\006H\020¢\006\002\b\016R\016\020\005\032\0020\006X\004¢\006\002\n\000R\027\020\007\032\b\022\004\022\0020\0010\003¢\006\b\n\000\032\004\b\b\020\tR\016\020\n\032\0020\006X\004¢\006\002\n\000¨\006\017"}, d2 = {"Lio/javalin/routing/PathSegment$MultipleSegments;", "Lio/javalin/routing/PathSegment;", "segments", "", "(Ljava/util/List;)V", "groupedRegex", "", "innerSegments", "getInnerSegments", "()Ljava/util/List;", "regex", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
  public static final class MultipleSegments extends PathSegment {
    @NotNull
    private final List<PathSegment> innerSegments;
    
    @NotNull
    private final String regex;
    
    @NotNull
    private final String groupedRegex;
    
    public MultipleSegments(@NotNull List segments) {
      super(null);
      Iterable $this$filterIsInstance$iv = segments;
      int $i$f$filterIsInstance = 0;
      Iterable iterable1 = $this$filterIsInstance$iv;
      Collection<Object> collection1 = new ArrayList();
      int $i$f$filterIsInstanceTo = 0;
      for (Object element$iv$iv : iterable1) {
        if (element$iv$iv instanceof MultipleSegments)
          collection1.add(element$iv$iv); 
      } 
      if (!((List)collection1).isEmpty())
        throw new IllegalStateException("Found MultipleSegment inside MultipleSegments! This is forbidden"); 
      $this$filterIsInstance$iv = segments;
      MultipleSegments multipleSegments = this;
      int $i$f$filterNot = 0;
      Iterable $this$filterIsInstanceTo$iv$iv = $this$filterIsInstance$iv;
      Collection<Object> destination$iv$iv = new ArrayList();
      int $i$f$filterNotTo = 0;
      for (Object element$iv$iv : $this$filterIsInstanceTo$iv$iv) {
        PathSegment it = (PathSegment)element$iv$iv;
        int $i$a$-filterNot-PathSegment$MultipleSegments$innerSegments$1 = 0;
        if (!(it instanceof MultipleSegments))
          destination$iv$iv.add(element$iv$iv); 
      } 
      multipleSegments.innerSegments = (List)destination$iv$iv;
      this.regex = CollectionsKt.joinToString$default(this.innerSegments, "", null, null, 0, null, PathSegment$MultipleSegments$regex$1.INSTANCE, 30, null);
      this.groupedRegex = CollectionsKt.joinToString$default(this.innerSegments, "", null, null, 0, null, PathSegment$MultipleSegments$groupedRegex$1.INSTANCE, 30, null);
    }
    
    @NotNull
    public final List<PathSegment> getInnerSegments() {
      return this.innerSegments;
    }
    
    @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\r\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/routing/PathSegment;", "invoke"})
    static final class PathSegment$MultipleSegments$regex$1 extends Lambda implements Function1<PathSegment, CharSequence> {
      public static final PathSegment$MultipleSegments$regex$1 INSTANCE = new PathSegment$MultipleSegments$regex$1();
      
      PathSegment$MultipleSegments$regex$1() {
        super(1);
      }
      
      @NotNull
      public final CharSequence invoke(@NotNull PathSegment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.asRegexString$javalin();
      }
    }
    
    @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\r\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lio/javalin/routing/PathSegment;", "invoke"})
    static final class PathSegment$MultipleSegments$groupedRegex$1 extends Lambda implements Function1<PathSegment, CharSequence> {
      public static final PathSegment$MultipleSegments$groupedRegex$1 INSTANCE = new PathSegment$MultipleSegments$groupedRegex$1();
      
      PathSegment$MultipleSegments$groupedRegex$1() {
        super(1);
      }
      
      @NotNull
      public final CharSequence invoke(@NotNull PathSegment it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.asGroupedRegexString$javalin();
      }
    }
    
    @NotNull
    public String asRegexString$javalin() {
      return this.regex;
    }
    
    @NotNull
    public String asGroupedRegexString$javalin() {
      return this.groupedRegex;
    }
  }
}
