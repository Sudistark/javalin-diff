package io.javalin.http;

import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000(\n\002\030\002\n\002\020\000\n\000\n\002\020\016\n\002\b\003\n\002\020\b\n\000\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b,\b\b\030\0002\0020\001Bm\b\007\022\006\020\002\032\0020\003\022\006\020\004\032\0020\003\022\b\b\002\020\005\032\0020\003\022\b\b\002\020\006\032\0020\007\022\b\b\002\020\b\032\0020\t\022\b\b\002\020\n\032\0020\007\022\b\b\002\020\013\032\0020\t\022\n\b\002\020\f\032\004\030\0010\003\022\n\b\002\020\r\032\004\030\0010\003\022\n\b\002\020\016\032\004\030\0010\017¢\006\002\020\020J\t\020,\032\0020\003HÆ\003J\013\020-\032\004\030\0010\017HÆ\003J\t\020.\032\0020\003HÆ\003J\t\020/\032\0020\003HÆ\003J\t\0200\032\0020\007HÆ\003J\t\0201\032\0020\tHÆ\003J\t\0202\032\0020\007HÆ\003J\t\0203\032\0020\tHÆ\003J\013\0204\032\004\030\0010\003HÆ\003J\013\0205\032\004\030\0010\003HÆ\003Js\0206\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\0032\b\b\002\020\005\032\0020\0032\b\b\002\020\006\032\0020\0072\b\b\002\020\b\032\0020\t2\b\b\002\020\n\032\0020\0072\b\b\002\020\013\032\0020\t2\n\b\002\020\f\032\004\030\0010\0032\n\b\002\020\r\032\004\030\0010\0032\n\b\002\020\016\032\004\030\0010\017HÆ\001J\023\0207\032\0020\t2\b\0208\032\004\030\0010\001HÖ\003J\t\0209\032\0020\007HÖ\001J\t\020:\032\0020\003HÖ\001R\034\020\f\032\004\030\0010\003X\016¢\006\016\n\000\032\004\b\021\020\022\"\004\b\023\020\024R\034\020\r\032\004\030\0010\003X\016¢\006\016\n\000\032\004\b\025\020\022\"\004\b\026\020\024R\032\020\013\032\0020\tX\016¢\006\016\n\000\032\004\b\013\020\027\"\004\b\030\020\031R\032\020\006\032\0020\007X\016¢\006\016\n\000\032\004\b\032\020\033\"\004\b\034\020\035R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\036\020\022\"\004\b\037\020\024R\032\020\005\032\0020\003X\016¢\006\016\n\000\032\004\b \020\022\"\004\b!\020\024R\034\020\016\032\004\030\0010\017X\016¢\006\016\n\000\032\004\b\"\020#\"\004\b$\020%R\032\020\b\032\0020\tX\016¢\006\016\n\000\032\004\b&\020\027\"\004\b'\020\031R\032\020\004\032\0020\003X\016¢\006\016\n\000\032\004\b(\020\022\"\004\b)\020\024R\032\020\n\032\0020\007X\016¢\006\016\n\000\032\004\b*\020\033\"\004\b+\020\035¨\006;"}, d2 = {"Lio/javalin/http/Cookie;", "", "name", "", "value", "path", "maxAge", "", "secure", "", "version", "isHttpOnly", "comment", "domain", "sameSite", "Lio/javalin/http/SameSite;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZIZLjava/lang/String;Ljava/lang/String;Lio/javalin/http/SameSite;)V", "getComment", "()Ljava/lang/String;", "setComment", "(Ljava/lang/String;)V", "getDomain", "setDomain", "()Z", "setHttpOnly", "(Z)V", "getMaxAge", "()I", "setMaxAge", "(I)V", "getName", "setName", "getPath", "setPath", "getSameSite", "()Lio/javalin/http/SameSite;", "setSameSite", "(Lio/javalin/http/SameSite;)V", "getSecure", "setSecure", "getValue", "setValue", "getVersion", "setVersion", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "javalin"})
public final class Cookie {
  @NotNull
  private String name;
  
  @NotNull
  private String value;
  
  @NotNull
  private String path;
  
  private int maxAge;
  
  private boolean secure;
  
  private int version;
  
  private boolean isHttpOnly;
  
  @Nullable
  private String comment;
  
  @Nullable
  private String domain;
  
  @Nullable
  private SameSite sameSite;
  
  @JvmOverloads
  public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly, @Nullable String comment, @Nullable String domain, @Nullable SameSite sameSite) {
    this.name = name;
    this.value = value;
    this.path = path;
    this.maxAge = maxAge;
    this.secure = secure;
    this.version = version;
    this.isHttpOnly = isHttpOnly;
    this.comment = comment;
    this.domain = domain;
    this.sameSite = sameSite;
  }
  
  @NotNull
  public final String getName() {
    return this.name;
  }
  
  public final void setName(@NotNull String <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    this.name = <set-?>;
  }
  
  @NotNull
  public final String getValue() {
    return this.value;
  }
  
  public final void setValue(@NotNull String <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    this.value = <set-?>;
  }
  
  @NotNull
  public final String getPath() {
    return this.path;
  }
  
  public final void setPath(@NotNull String <set-?>) {
    Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
    this.path = <set-?>;
  }
  
  public final int getMaxAge() {
    return this.maxAge;
  }
  
  public final void setMaxAge(int <set-?>) {
    this.maxAge = <set-?>;
  }
  
  public final boolean getSecure() {
    return this.secure;
  }
  
  public final void setSecure(boolean <set-?>) {
    this.secure = <set-?>;
  }
  
  public final int getVersion() {
    return this.version;
  }
  
  public final void setVersion(int <set-?>) {
    this.version = <set-?>;
  }
  
  public final boolean isHttpOnly() {
    return this.isHttpOnly;
  }
  
  public final void setHttpOnly(boolean <set-?>) {
    this.isHttpOnly = <set-?>;
  }
  
  @Nullable
  public final String getComment() {
    return this.comment;
  }
  
  public final void setComment(@Nullable String <set-?>) {
    this.comment = <set-?>;
  }
  
  @Nullable
  public final String getDomain() {
    return this.domain;
  }
  
  public final void setDomain(@Nullable String <set-?>) {
    this.domain = <set-?>;
  }
  
  @Nullable
  public final SameSite getSameSite() {
    return this.sameSite;
  }
  
  public final void setSameSite(@Nullable SameSite <set-?>) {
    this.sameSite = <set-?>;
  }
  
  @NotNull
  public final String component1() {
    return this.name;
  }
  
  @NotNull
  public final String component2() {
    return this.value;
  }
  
  @NotNull
  public final String component3() {
    return this.path;
  }
  
  public final int component4() {
    return this.maxAge;
  }
  
  public final boolean component5() {
    return this.secure;
  }
  
  public final int component6() {
    return this.version;
  }
  
  public final boolean component7() {
    return this.isHttpOnly;
  }
  
  @Nullable
  public final String component8() {
    return this.comment;
  }
  
  @Nullable
  public final String component9() {
    return this.domain;
  }
  
  @Nullable
  public final SameSite component10() {
    return this.sameSite;
  }
  
  @NotNull
  public final Cookie copy(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly, @Nullable String comment, @Nullable String domain, @Nullable SameSite sameSite) {
    Intrinsics.checkNotNullParameter(name, "name");
    Intrinsics.checkNotNullParameter(value, "value");
    Intrinsics.checkNotNullParameter(path, "path");
    return new Cookie(name, value, path, maxAge, secure, version, isHttpOnly, comment, domain, sameSite);
  }
  
  @NotNull
  public String toString() {
    return "Cookie(name=" + this.name + ", value=" + this.value + ", path=" + this.path + ", maxAge=" + this.maxAge + ", secure=" + this.secure + ", version=" + this.version + ", isHttpOnly=" + this.isHttpOnly + ", comment=" + this.comment + ", domain=" + this.domain + ", sameSite=" + this.sameSite + ")";
  }
  
  public int hashCode() {
    result = this.name.hashCode();
    result = result * 31 + this.value.hashCode();
    result = result * 31 + this.path.hashCode();
    result = result * 31 + Integer.hashCode(this.maxAge);
    if (this.secure);
    result = result * 31 + 1;
    result = result * 31 + Integer.hashCode(this.version);
    if (this.isHttpOnly);
    result = result * 31 + 1;
    result = result * 31 + ((this.comment == null) ? 0 : this.comment.hashCode());
    result = result * 31 + ((this.domain == null) ? 0 : this.domain.hashCode());
    return result * 31 + ((this.sameSite == null) ? 0 : this.sameSite.hashCode());
  }
  
  public boolean equals(@Nullable Object other) {
    if (this == other)
      return true; 
    if (!(other instanceof Cookie))
      return false; 
    Cookie cookie = (Cookie)other;
    return !Intrinsics.areEqual(this.name, cookie.name) ? false : (!Intrinsics.areEqual(this.value, cookie.value) ? false : (!Intrinsics.areEqual(this.path, cookie.path) ? false : ((this.maxAge != cookie.maxAge) ? false : ((this.secure != cookie.secure) ? false : ((this.version != cookie.version) ? false : ((this.isHttpOnly != cookie.isHttpOnly) ? false : (!Intrinsics.areEqual(this.comment, cookie.comment) ? false : (!Intrinsics.areEqual(this.domain, cookie.domain) ? false : (!(this.sameSite != cookie.sameSite))))))))));
  }
  
  @JvmOverloads
  public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly, @Nullable String comment, @Nullable String domain) {
    this(name, value, path, maxAge, secure, version, isHttpOnly, comment, domain, null, 512, null);
  }
  
  @JvmOverloads
  public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly, @Nullable String comment) {
    this(name, value, path, maxAge, secure, version, isHttpOnly, comment, null, null, 768, null);
  }
  
  @JvmOverloads
  public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version, boolean isHttpOnly) {
    this(name, value, path, maxAge, secure, version, isHttpOnly, null, null, null, 896, null);
  }
  
  @JvmOverloads
  public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure, int version) {
    this(name, value, path, maxAge, secure, version, false, null, null, null, 960, null);
  }
  
  @JvmOverloads
  public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge, boolean secure) {
    this(name, value, path, maxAge, secure, 0, false, null, null, null, 992, null);
  }
  
  @JvmOverloads
  public Cookie(@NotNull String name, @NotNull String value, @NotNull String path, int maxAge) {
    this(name, value, path, maxAge, false, 0, false, null, null, null, 1008, null);
  }
  
  @JvmOverloads
  public Cookie(@NotNull String name, @NotNull String value, @NotNull String path) {
    this(name, value, path, 0, false, 0, false, null, null, null, 1016, null);
  }
  
  @JvmOverloads
  public Cookie(@NotNull String name, @NotNull String value) {
    this(name, value, null, 0, false, 0, false, null, null, null, 1020, null);
  }
}
