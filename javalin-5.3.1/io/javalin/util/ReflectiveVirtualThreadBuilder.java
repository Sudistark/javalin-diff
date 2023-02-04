package io.javalin.util;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000 \n\002\030\002\n\002\020\000\n\002\b\007\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\026\030\000 \0162\0020\001:\001\016B\005¢\006\002\020\002J\016\020\b\032\0020\0002\006\020\b\032\0020\tJ\016\020\n\032\0020\0132\006\020\f\032\0020\rR\032\020\003\032\0020\001X\016¢\006\016\n\000\032\004\b\004\020\005\"\004\b\006\020\007¨\006\017"}, d2 = {"Lio/javalin/util/ReflectiveVirtualThreadBuilder;", "", "()V", "virtualBuilder", "getVirtualBuilder", "()Ljava/lang/Object;", "setVirtualBuilder", "(Ljava/lang/Object;)V", "name", "", "unstarted", "Ljava/lang/Thread;", "runnable", "Ljava/lang/Runnable;", "Companion", "javalin"})
public class ReflectiveVirtualThreadBuilder {
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\024\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\007\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\005\020\006R\021\020\007\032\0020\004¢\006\b\n\000\032\004\b\b\020\006R\021\020\t\032\0020\004¢\006\b\n\000\032\004\b\n\020\006¨\006\013"}, d2 = {"Lio/javalin/util/ReflectiveVirtualThreadBuilder$Companion;", "", "()V", "NAME", "Ljava/lang/invoke/MethodHandle;", "getNAME", "()Ljava/lang/invoke/MethodHandle;", "OF_VIRTUAL", "getOF_VIRTUAL", "UNSTARTED", "getUNSTARTED", "javalin"})
  protected static final class Companion {
    private Companion() {}
    
    @NotNull
    public final MethodHandle getOF_VIRTUAL() {
      return ReflectiveVirtualThreadBuilder.OF_VIRTUAL;
    }
    
    @NotNull
    public final MethodHandle getNAME() {
      return ReflectiveVirtualThreadBuilder.NAME;
    }
    
    @NotNull
    public final MethodHandle getUNSTARTED() {
      return ReflectiveVirtualThreadBuilder.UNSTARTED;
    }
  }
  
  @NotNull
  protected static final Companion Companion = new Companion(null);
  
  static {
    Class<?> builderClass = Class.forName("java.lang.Thread$Builder$OfVirtual");
    MethodHandles.Lookup handles = MethodHandles.publicLookup();
    Intrinsics.checkNotNullExpressionValue(handles.findStatic(Thread.class, "ofVirtual", MethodType.methodType(builderClass)), "handles.findStatic(Threa…methodType(builderClass))");
    OF_VIRTUAL = handles.findStatic(Thread.class, "ofVirtual", MethodType.methodType(builderClass));
    Intrinsics.checkNotNullExpressionValue(handles.findVirtual(builderClass, "name", MethodType.methodType(builderClass, String.class)), "handles.findVirtual(buil…ass, String::class.java))");
    NAME = handles.findVirtual(builderClass, "name", MethodType.methodType(builderClass, String.class));
    Intrinsics.checkNotNullExpressionValue(handles.findVirtual(builderClass, "unstarted", MethodType.methodType(Thread.class, Runnable.class)), "handles.findVirtual(buil…a, Runnable::class.java))");
    UNSTARTED = handles.findVirtual(builderClass, "unstarted", MethodType.methodType(Thread.class, Runnable.class));
  }
  
  @NotNull
  private Object virtualBuilder = OF_VIRTUAL.invoke();
  
  @NotNull
  private static final MethodHandle OF_VIRTUAL;
  
  @NotNull
  private static final MethodHandle NAME;
  
  @NotNull
  private static final MethodHandle UNSTARTED;
  
  @NotNull
  protected final Object getVirtualBuilder() {
    return this.virtualBuilder;
  }
  
  protected final void setVirtualBuilder(@NotNull Object <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    this.virtualBuilder = <set-?>;
  }
  
  @NotNull
  public final ReflectiveVirtualThreadBuilder name(@NotNull String name) {
    Intrinsics.checkNotNullParameter(name, "name");
    ReflectiveVirtualThreadBuilder reflectiveVirtualThreadBuilder1 = this, it = reflectiveVirtualThreadBuilder1;
    int $i$a$-also-ReflectiveVirtualThreadBuilder$name$1 = 0;
    this.virtualBuilder = NAME.invoke(this.virtualBuilder, name);
    return reflectiveVirtualThreadBuilder1;
  }
  
  @NotNull
  public final Thread unstarted(@NotNull Runnable runnable) {
    Intrinsics.checkNotNullParameter(runnable, "runnable");
    return UNSTARTED.invoke(this.virtualBuilder, runnable);
  }
}
