package io.javalin.validation;

import io.javalin.json.JsonMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\0000\n\002\030\002\n\000\n\002\020\000\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\f\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\b\b\030\000*\004\b\000\020\0012\0020\002B)\022\b\020\003\032\004\030\0010\004\022\f\020\005\032\b\022\004\022\0028\0000\006\022\n\b\002\020\007\032\004\030\0010\b¢\006\002\020\tJ\013\020\020\032\004\030\0010\004HÆ\003J\017\020\021\032\b\022\004\022\0028\0000\006HÆ\003J\013\020\022\032\004\030\0010\bHÆ\003J7\020\023\032\b\022\004\022\0028\0000\0002\n\b\002\020\003\032\004\030\0010\0042\016\b\002\020\005\032\b\022\004\022\0028\0000\0062\n\b\002\020\007\032\004\030\0010\bHÆ\001J\023\020\024\032\0020\0252\b\020\026\032\004\030\0010\002HÖ\003J\t\020\027\032\0020\030HÖ\001J\t\020\031\032\0020\004HÖ\001R\027\020\005\032\b\022\004\022\0028\0000\006¢\006\b\n\000\032\004\b\n\020\013R\023\020\007\032\004\030\0010\b¢\006\b\n\000\032\004\b\f\020\rR\023\020\003\032\004\030\0010\004¢\006\b\n\000\032\004\b\016\020\017¨\006\032"}, d2 = {"Lio/javalin/validation/StringSource;", "T", "", "stringValue", "", "clazz", "Ljava/lang/Class;", "jsonMapper", "Lio/javalin/json/JsonMapper;", "(Ljava/lang/String;Ljava/lang/Class;Lio/javalin/json/JsonMapper;)V", "getClazz", "()Ljava/lang/Class;", "getJsonMapper", "()Lio/javalin/json/JsonMapper;", "getStringValue", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "javalin"})
public final class StringSource<T> {
  @Nullable
  private final String stringValue;
  
  @NotNull
  private final Class<T> clazz;
  
  @Nullable
  private final JsonMapper jsonMapper;
  
  public StringSource(@Nullable String stringValue, @NotNull Class<T> clazz, @Nullable JsonMapper jsonMapper) {
    this.stringValue = stringValue;
    this.clazz = clazz;
    this.jsonMapper = jsonMapper;
  }
  
  @Nullable
  public final String getStringValue() {
    return this.stringValue;
  }
  
  @NotNull
  public final Class<T> getClazz() {
    return this.clazz;
  }
  
  @Nullable
  public final JsonMapper getJsonMapper() {
    return this.jsonMapper;
  }
  
  @Nullable
  public final String component1() {
    return this.stringValue;
  }
  
  @NotNull
  public final Class<T> component2() {
    return this.clazz;
  }
  
  @Nullable
  public final JsonMapper component3() {
    return this.jsonMapper;
  }
  
  @NotNull
  public final StringSource<T> copy(@Nullable String stringValue, @NotNull Class<T> clazz, @Nullable JsonMapper jsonMapper) {
    Intrinsics.checkNotNullParameter(clazz, "clazz");
    return new StringSource(stringValue, clazz, jsonMapper);
  }
  
  @NotNull
  public String toString() {
    return "StringSource(stringValue=" + this.stringValue + ", clazz=" + this.clazz + ", jsonMapper=" + this.jsonMapper + ")";
  }
  
  public int hashCode() {
    result = (this.stringValue == null) ? 0 : this.stringValue.hashCode();
    result = result * 31 + this.clazz.hashCode();
    return result * 31 + ((this.jsonMapper == null) ? 0 : this.jsonMapper.hashCode());
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof StringSource))
      return false; 
    StringSource stringSource = (StringSource)other;
    return !Intrinsics.areEqual(this.stringValue, stringSource.stringValue) ? false : (!Intrinsics.areEqual(this.clazz, stringSource.clazz) ? false : (!!Intrinsics.areEqual(this.jsonMapper, stringSource.jsonMapper)));
  }
}
