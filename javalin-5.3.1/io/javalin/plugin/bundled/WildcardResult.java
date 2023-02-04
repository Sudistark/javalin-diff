package io.javalin.plugin.bundled;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\002\b\004\n\002\030\002\n\002\030\002\n\002\030\002\n\000\b0\030\0002\0020\001:\003\003\004\005B\007\b\004¢\006\002\020\002\001\003\006\007\b¨\006\t"}, d2 = {"Lio/javalin/plugin/bundled/WildcardResult;", "", "()V", "ErrorState", "NoWildcardDetected", "WildcardOkay", "Lio/javalin/plugin/bundled/WildcardResult$ErrorState;", "Lio/javalin/plugin/bundled/WildcardResult$NoWildcardDetected;", "Lio/javalin/plugin/bundled/WildcardResult$WildcardOkay;", "javalin"})
public abstract class WildcardResult {
  private WildcardResult() {}
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\026\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\000\b0\030\0002\0020\001:\002\003\004B\007\b\004¢\006\002\020\002\001\002\005\006¨\006\007"}, d2 = {"Lio/javalin/plugin/bundled/WildcardResult$ErrorState;", "Lio/javalin/plugin/bundled/WildcardResult;", "()V", "TooManyWildcards", "WildcardNotAtTheStartOfTheHost", "Lio/javalin/plugin/bundled/WildcardResult$ErrorState$TooManyWildcards;", "Lio/javalin/plugin/bundled/WildcardResult$ErrorState$WildcardNotAtTheStartOfTheHost;", "javalin"})
  public static abstract class ErrorState extends WildcardResult {
    private ErrorState() {
      super(null);
    }
    
    @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\002\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002¨\006\003"}, d2 = {"Lio/javalin/plugin/bundled/WildcardResult$ErrorState$TooManyWildcards;", "Lio/javalin/plugin/bundled/WildcardResult$ErrorState;", "()V", "javalin"})
    public static final class TooManyWildcards extends ErrorState {
      @NotNull
      public static final TooManyWildcards INSTANCE = new TooManyWildcards();
      
      private TooManyWildcards() {
        super(null);
      }
    }
    
    @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\002\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002¨\006\003"}, d2 = {"Lio/javalin/plugin/bundled/WildcardResult$ErrorState$WildcardNotAtTheStartOfTheHost;", "Lio/javalin/plugin/bundled/WildcardResult$ErrorState;", "()V", "javalin"})
    public static final class WildcardNotAtTheStartOfTheHost extends ErrorState {
      @NotNull
      public static final WildcardNotAtTheStartOfTheHost INSTANCE = new WildcardNotAtTheStartOfTheHost();
      
      private WildcardNotAtTheStartOfTheHost() {
        super(null);
      }
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\002\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002¨\006\003"}, d2 = {"Lio/javalin/plugin/bundled/WildcardResult$NoWildcardDetected;", "Lio/javalin/plugin/bundled/WildcardResult;", "()V", "javalin"})
  public static final class NoWildcardDetected extends WildcardResult {
    @NotNull
    public static final NoWildcardDetected INSTANCE = new NoWildcardDetected();
    
    private NoWildcardDetected() {
      super(null);
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\002\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002¨\006\003"}, d2 = {"Lio/javalin/plugin/bundled/WildcardResult$WildcardOkay;", "Lio/javalin/plugin/bundled/WildcardResult;", "()V", "javalin"})
  public static final class WildcardOkay extends WildcardResult {
    @NotNull
    public static final WildcardOkay INSTANCE = new WildcardOkay();
    
    private WildcardOkay() {
      super(null);
    }
  }
}
