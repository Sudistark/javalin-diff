package io.javalin.vue;

import io.javalin.http.Context;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000\"\n\000\n\002\020\016\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\"\n\002\b\002\032\034\020\000\032\0020\001*\0020\0012\006\020\002\032\0020\0032\006\020\004\032\0020\005H\002\032\f\020\006\032\0020\003*\0020\007H\000\032\022\020\b\032\0020\001*\b\022\004\022\0020\0070\tH\002\032\f\020\n\032\0020\001*\0020\007H\000¨\006\013"}, d2 = {"insertNoncesAndCspHeader", "", "enableCspAndNonces", "", "ctx", "Lio/javalin/http/Context;", "isVueFile", "Ljava/nio/file/Path;", "joinVueFiles", "", "readText", "javalin"})
public final class VueHandlerKt {
  private static final String insertNoncesAndCspHeader(String $this$insertNoncesAndCspHeader, boolean enableCspAndNonces, Context ctx) {
    if (!enableCspAndNonces)
      return StringsKt.replace$default($this$insertNoncesAndCspHeader, "nonce=\"@internalAddNonce\"", "", false, 4, null); 
    Set<String> nonces = new LinkedHashSet();
    CharSequence charSequence1 = $this$insertNoncesAndCspHeader;
    Regex regex = new Regex("@internalAddNonce");
    VueHandlerKt$insertNoncesAndCspHeader$1 vueHandlerKt$insertNoncesAndCspHeader$1 = new VueHandlerKt$insertNoncesAndCspHeader$1(nonces);
    charSequence1 = regex.replace(charSequence1, vueHandlerKt$insertNoncesAndCspHeader$1);
    regex = new Regex("@addNonce");
    VueHandlerKt$insertNoncesAndCspHeader$2 vueHandlerKt$insertNoncesAndCspHeader$2 = new VueHandlerKt$insertNoncesAndCspHeader$2(nonces);
    charSequence1 = regex.replace(charSequence1, vueHandlerKt$insertNoncesAndCspHeader$2);
    CharSequence charSequence2 = charSequence1;
    int $i$a$-also-VueHandlerKt$insertNoncesAndCspHeader$3 = 0;
    ctx.header("Content-Security-Policy", "script-src 'unsafe-eval' " + CollectionsKt.joinToString$default(nonces, " ", null, null, 0, null, VueHandlerKt$insertNoncesAndCspHeader$3$1.INSTANCE, 30, null));
    return (String)charSequence1;
  }
  
  private static final String insertNoncesAndCspHeader$newNonce(Set<String> $this$insertNoncesAndCspHeader_u24newNonce) {
    Intrinsics.checkNotNullExpressionValue(UUID.randomUUID().toString(), "randomUUID().toString()");
    String str1 = "jv-" + StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null), it = str1;
    int $i$a$-also-VueHandlerKt$insertNoncesAndCspHeader$newNonce$1 = 0;
    $this$insertNoncesAndCspHeader_u24newNonce.add(it);
    return str1;
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\r\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"})
  static final class VueHandlerKt$insertNoncesAndCspHeader$1 extends Lambda implements Function1<MatchResult, CharSequence> {
    VueHandlerKt$insertNoncesAndCspHeader$1(Set<String> $nonces) {
      super(1);
    }
    
    @NotNull
    public final CharSequence invoke(@NotNull MatchResult it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return VueHandlerKt.insertNoncesAndCspHeader$newNonce(this.$nonces);
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\r\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Lkotlin/text/MatchResult;", "invoke"})
  static final class VueHandlerKt$insertNoncesAndCspHeader$2 extends Lambda implements Function1<MatchResult, CharSequence> {
    VueHandlerKt$insertNoncesAndCspHeader$2(Set<String> $nonces) {
      super(1);
    }
    
    @NotNull
    public final CharSequence invoke(@NotNull MatchResult it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return VueHandlerKt.insertNoncesAndCspHeader$newNonce(this.$nonces);
    }
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\r\n\000\n\002\020\016\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "", "invoke"})
  static final class VueHandlerKt$insertNoncesAndCspHeader$3$1 extends Lambda implements Function1<String, CharSequence> {
    public static final VueHandlerKt$insertNoncesAndCspHeader$3$1 INSTANCE = new VueHandlerKt$insertNoncesAndCspHeader$3$1();
    
    VueHandlerKt$insertNoncesAndCspHeader$3$1() {
      super(1);
    }
    
    @NotNull
    public final CharSequence invoke(@NotNull String it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return "'nonce-" + it + "'";
    }
  }
  
  @NotNull
  public static final String readText(@NotNull Path $this$readText) {
    Intrinsics.checkNotNullParameter($this$readText, "<this>");
    Intrinsics.checkNotNullExpressionValue(Files.readAllBytes($this$readText), "readAllBytes(this)");
    byte[] arrayOfByte = Files.readAllBytes($this$readText);
    return new String(arrayOfByte, Charsets.UTF_8);
  }
  
  public static final boolean isVueFile(@NotNull Path $this$isVueFile) {
    Intrinsics.checkNotNullParameter($this$isVueFile, "<this>");
    return StringsKt.endsWith$default($this$isVueFile.toString(), ".vue", false, 2, null);
  }
  
  private static final String joinVueFiles(Set $this$joinVueFiles) {
    Iterable $this$filter$iv = $this$joinVueFiles;
    int $i$f$filter = 0;
    Iterable iterable1 = $this$filter$iv;
    Collection<Object> destination$iv$iv = new ArrayList();
    int $i$f$filterTo = 0;
    for (Object element$iv$iv : iterable1) {
      Path it = (Path)element$iv$iv;
      int $i$a$-filter-VueHandlerKt$joinVueFiles$1 = 0;
      if (isVueFile(it))
        destination$iv$iv.add(element$iv$iv); 
    } 
    return CollectionsKt.joinToString$default(destination$iv$iv, "", null, null, 0, null, VueHandlerKt$joinVueFiles$2.INSTANCE, 30, null);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 3, xi = 48, d1 = {"\000\016\n\000\n\002\020\r\n\000\n\002\030\002\n\000\020\000\032\0020\0012\006\020\002\032\0020\003H\n¢\006\002\b\004"}, d2 = {"<anonymous>", "", "it", "Ljava/nio/file/Path;", "invoke"})
  static final class VueHandlerKt$joinVueFiles$2 extends Lambda implements Function1<Path, CharSequence> {
    public static final VueHandlerKt$joinVueFiles$2 INSTANCE = new VueHandlerKt$joinVueFiles$2();
    
    VueHandlerKt$joinVueFiles$2() {
      super(1);
    }
    
    @NotNull
    public final CharSequence invoke(@NotNull Path it) {
      Intrinsics.checkNotNullParameter(it, "it");
      return "\n<!-- " + it.getFileName() + " -->\n" + VueHandlerKt.readText(it);
    }
  }
}
