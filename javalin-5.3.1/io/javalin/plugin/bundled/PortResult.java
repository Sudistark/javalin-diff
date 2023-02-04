package io.javalin.plugin.bundled;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\002\b\004\n\002\030\002\n\002\030\002\n\002\030\002\n\000\b0\030\0002\0020\001:\003\003\004\005B\007\b\004¢\006\002\020\002\001\003\006\007\b¨\006\t"}, d2 = {"Lio/javalin/plugin/bundled/PortResult;", "", "()V", "ErrorState", "NoPortSpecified", "PortSpecified", "Lio/javalin/plugin/bundled/PortResult$ErrorState;", "Lio/javalin/plugin/bundled/PortResult$NoPortSpecified;", "Lio/javalin/plugin/bundled/PortResult$PortSpecified;", "javalin"})
public abstract class PortResult {
  private PortResult() {}
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\026\n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\030\002\n\000\b0\030\0002\0020\001:\002\003\004B\007\b\004¢\006\002\020\002\001\002\005\006¨\006\007"}, d2 = {"Lio/javalin/plugin/bundled/PortResult$ErrorState;", "Lio/javalin/plugin/bundled/PortResult;", "()V", "InvalidOrigin", "InvalidPort", "Lio/javalin/plugin/bundled/PortResult$ErrorState$InvalidOrigin;", "Lio/javalin/plugin/bundled/PortResult$ErrorState$InvalidPort;", "javalin"})
  public static abstract class ErrorState extends PortResult {
    private ErrorState() {
      super(null);
    }
    
    @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\002\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002¨\006\003"}, d2 = {"Lio/javalin/plugin/bundled/PortResult$ErrorState$InvalidOrigin;", "Lio/javalin/plugin/bundled/PortResult$ErrorState;", "()V", "javalin"})
    public static final class InvalidOrigin extends ErrorState {
      @NotNull
      public static final InvalidOrigin INSTANCE = new InvalidOrigin();
      
      private InvalidOrigin() {
        super(null);
      }
    }
    
    @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\002\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002¨\006\003"}, d2 = {"Lio/javalin/plugin/bundled/PortResult$ErrorState$InvalidPort;", "Lio/javalin/plugin/bundled/PortResult$ErrorState;", "()V", "javalin"})
    public static final class InvalidPort extends ErrorState {
      @NotNull
      public static final InvalidPort INSTANCE = new InvalidPort();
      
      private InvalidPort() {
        super(null);
      }
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\f\n\002\030\002\n\002\030\002\n\002\b\002\bÀ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002¨\006\003"}, d2 = {"Lio/javalin/plugin/bundled/PortResult$NoPortSpecified;", "Lio/javalin/plugin/bundled/PortResult;", "()V", "javalin"})
  public static final class NoPortSpecified extends PortResult {
    @NotNull
    public static final NoPortSpecified INSTANCE = new NoPortSpecified();
    
    private NoPortSpecified() {
      super(null);
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000&\n\002\030\002\n\002\030\002\n\000\n\002\020\b\n\000\n\002\020\013\n\002\b\n\n\002\020\000\n\002\b\002\n\002\020\016\n\000\b\b\030\0002\0020\001B\027\022\006\020\002\032\0020\003\022\b\b\002\020\004\032\0020\005¢\006\002\020\006J\t\020\013\032\0020\003HÆ\003J\t\020\f\032\0020\005HÆ\003J\035\020\r\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\005HÆ\001J\023\020\016\032\0020\0052\b\020\017\032\004\030\0010\020HÖ\003J\t\020\021\032\0020\003HÖ\001J\t\020\022\032\0020\023HÖ\001R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\024"}, d2 = {"Lio/javalin/plugin/bundled/PortResult$PortSpecified;", "Lio/javalin/plugin/bundled/PortResult;", "port", "", "fromSchemeDefault", "", "(IZ)V", "getFromSchemeDefault", "()Z", "getPort", "()I", "component1", "component2", "copy", "equals", "other", "", "hashCode", "toString", "", "javalin"})
  public static final class PortSpecified extends PortResult {
    private final int port;
    
    private final boolean fromSchemeDefault;
    
    public PortSpecified(int port, boolean fromSchemeDefault) {
      super(null);
      this.port = port;
      this.fromSchemeDefault = fromSchemeDefault;
    }
    
    public final int getPort() {
      return this.port;
    }
    
    public final boolean getFromSchemeDefault() {
      return this.fromSchemeDefault;
    }
    
    public final int component1() {
      return this.port;
    }
    
    public final boolean component2() {
      return this.fromSchemeDefault;
    }
    
    @NotNull
    public final PortSpecified copy(int port, boolean fromSchemeDefault) {
      return new PortSpecified(port, fromSchemeDefault);
    }
    
    @NotNull
    public String toString() {
      return "PortSpecified(port=" + this.port + ", fromSchemeDefault=" + this.fromSchemeDefault + ")";
    }
    
    public int hashCode() {
      result = Integer.hashCode(this.port);
      if (this.fromSchemeDefault);
      return result * 31 + 1;
    }
    
    public boolean equals(@Nullable Object other) {
      if (this == other)
        return true; 
      if (!(other instanceof PortSpecified))
        return false; 
      PortSpecified portSpecified = (PortSpecified)other;
      return (this.port != portSpecified.port) ? false : (!(this.fromSchemeDefault != portSpecified.fromSchemeDefault));
    }
  }
}
