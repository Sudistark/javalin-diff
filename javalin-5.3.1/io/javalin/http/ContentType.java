package io.javalin.http;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\036\n\002\030\002\n\002\020\020\n\000\n\002\020\016\n\000\n\002\020\013\n\000\n\002\020\021\n\002\b>\b\001\030\000 D2\b\022\004\022\0020\0000\001:\001DB+\b\002\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\022\020\006\032\n\022\006\b\001\022\0020\0030\007\"\0020\003¢\006\002\020\bJ\b\020\017\032\0020\003H\026R\033\020\006\032\n\022\006\b\001\022\0020\0030\007¢\006\n\n\002\020\013\032\004\b\t\020\nR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\004\020\fR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\r\020\016j\002\b\020j\002\b\021j\002\b\022j\002\b\023j\002\b\024j\002\b\025j\002\b\026j\002\b\027j\002\b\030j\002\b\031j\002\b\032j\002\b\033j\002\b\034j\002\b\035j\002\b\036j\002\b\037j\002\b j\002\b!j\002\b\"j\002\b#j\002\b$j\002\b%j\002\b&j\002\b'j\002\b(j\002\b)j\002\b*j\002\b+j\002\b,j\002\b-j\002\b.j\002\b/j\002\b0j\002\b1j\002\b2j\002\b3j\002\b4j\002\b5j\002\b6j\002\b7j\002\b8j\002\b9j\002\b:j\002\b;j\002\b<j\002\b=j\002\b>j\002\b?j\002\b@j\002\bAj\002\bBj\002\bC¨\006E"}, d2 = {"Lio/javalin/http/ContentType;", "", "mimeType", "", "isHumanReadable", "", "extensions", "", "(Ljava/lang/String;ILjava/lang/String;Z[Ljava/lang/String;)V", "getExtensions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "()Z", "getMimeType", "()Ljava/lang/String;", "toString", "TEXT_PLAIN", "TEXT_CSS", "TEXT_CSV", "TEXT_HTML", "TEXT_MARKDOWN", "TEXT_PROPERTIES", "TEXT_XML", "IMAGE_BMP", "IMAGE_GIF", "IMAGE_ICO", "IMAGE_JPEG", "IMAGE_PNG", "IMAGE_SVG", "IMAGE_TIFF", "IMAGE_WEBP", "AUDIO_AAC", "AUDIO_MIDI", "AUDIO_MPEG", "AUDIO_OGA", "AUDIO_OPUS", "AUDIO_WAV", "AUDIO_WEBA", "VIDEO_AVI", "VIDEO_MP4", "VIDEO_MPEG", "VIDEO_OGG", "VIDEO_WEBM", "FONT_OTF", "FONT_TTF", "APPLICATION_OCTET_STREAM", "APPLICATION_BZ", "APPLICATION_BZ2", "APPLICATION_CDN", "APPLICATION_DOC", "APPLICATION_DOCX", "APPLICATION_EPUB", "APPLICATION_GZ", "APPLICATION_JS", "APPLICATION_JSON", "APPLICATION_MPKG", "APPLICATION_JAR", "APPLICATION_PDF", "APPLICATION_POM", "APPLICATION_RAR", "APPLICATION_SH", "APPLICATION_SWF", "APPLICATION_TAR", "APPLICATION_XHTML", "APPLICATION_YAML", "APPLICATION_ZIP", "APPLICATION_7Z", "MULTIPART_FORM_DATA", "Companion", "javalin"})
public enum ContentType {
  TEXT_PLAIN, TEXT_CSS, TEXT_CSV, TEXT_HTML, TEXT_MARKDOWN, TEXT_PROPERTIES, TEXT_XML, IMAGE_BMP, IMAGE_GIF, IMAGE_ICO, IMAGE_JPEG, IMAGE_PNG, IMAGE_SVG, IMAGE_TIFF, IMAGE_WEBP, AUDIO_AAC, AUDIO_MIDI, AUDIO_MPEG, AUDIO_OGA, AUDIO_OPUS, AUDIO_WAV, AUDIO_WEBA, VIDEO_AVI, VIDEO_MP4, VIDEO_MPEG, VIDEO_OGG, VIDEO_WEBM, FONT_OTF, FONT_TTF, APPLICATION_OCTET_STREAM, APPLICATION_BZ, APPLICATION_BZ2, APPLICATION_CDN, APPLICATION_DOC, APPLICATION_DOCX, APPLICATION_EPUB, APPLICATION_GZ, APPLICATION_JS, APPLICATION_JSON, APPLICATION_MPKG, APPLICATION_JAR, APPLICATION_PDF, APPLICATION_POM, APPLICATION_RAR, APPLICATION_SH, APPLICATION_SWF, APPLICATION_TAR, APPLICATION_XHTML, APPLICATION_YAML, APPLICATION_ZIP, APPLICATION_7Z, MULTIPART_FORM_DATA;
  
  @NotNull
  public static final Companion Companion;
  
  @NotNull
  private final String mimeType;
  
  private final boolean isHumanReadable;
  
  @NotNull
  private final String[] extensions;
  
  @NotNull
  public static final String PLAIN = "text/plain";
  
  @NotNull
  public static final String CSS = "text/css";
  
  @NotNull
  public static final String HTML = "text/html";
  
  @NotNull
  public static final String XML = "text/xml";
  
  @NotNull
  public static final String OCTET_STREAM = "application/octet-stream";
  
  @NotNull
  public static final String JAVASCRIPT = "application/javascript";
  
  @NotNull
  public static final String JSON = "application/json";
  
  @NotNull
  public static final String FORM_DATA = "multipart/form-data";
  
  ContentType(String mimeType, boolean isHumanReadable, String... extensions) {
    this.mimeType = mimeType;
    this.isHumanReadable = isHumanReadable;
    this.extensions = extensions;
  }
  
  @NotNull
  public final String getMimeType() {
    return this.mimeType;
  }
  
  public final boolean isHumanReadable() {
    return this.isHumanReadable;
  }
  
  @NotNull
  public final String[] getExtensions() {
    return this.extensions;
  }
  
  static {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "txt";
    TEXT_PLAIN = new ContentType("TEXT_PLAIN", 0, "text/plain", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "css";
    TEXT_CSS = new ContentType("TEXT_CSS", 1, "text/css", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "csv";
    TEXT_CSV = new ContentType("TEXT_CSV", 2, "text/csv", false, arrayOfString);
    arrayOfString = new String[2];
    arrayOfString[0] = "html";
    arrayOfString[1] = "htm";
    TEXT_HTML = new ContentType("TEXT_HTML", 3, "text/html", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "md";
    TEXT_MARKDOWN = new ContentType("TEXT_MARKDOWN", 4, "text/markdown", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "properties";
    TEXT_PROPERTIES = new ContentType("TEXT_PROPERTIES", 5, "text/x-java-properties", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "xml";
    TEXT_XML = new ContentType("TEXT_XML", 6, "text/xml", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "bmp";
    IMAGE_BMP = new ContentType("IMAGE_BMP", 7, "image/bmp", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "gif";
    IMAGE_GIF = new ContentType("IMAGE_GIF", 8, "image/gif", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "ico";
    IMAGE_ICO = new ContentType("IMAGE_ICO", 9, "image/vnd.microsoft.icon", true, arrayOfString);
    arrayOfString = new String[2];
    arrayOfString[0] = "jpeg";
    arrayOfString[1] = "jpg";
    IMAGE_JPEG = new ContentType("IMAGE_JPEG", 10, "image/jpeg", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "png";
    IMAGE_PNG = new ContentType("IMAGE_PNG", 11, "image/png", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "svg";
    IMAGE_SVG = new ContentType("IMAGE_SVG", 12, "image/svg+xml", true, arrayOfString);
    arrayOfString = new String[2];
    arrayOfString[0] = "tiff";
    arrayOfString[1] = "tif";
    IMAGE_TIFF = new ContentType("IMAGE_TIFF", 13, "image/tiff", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "webp";
    IMAGE_WEBP = new ContentType("IMAGE_WEBP", 14, "image/webp", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "aac";
    AUDIO_AAC = new ContentType("AUDIO_AAC", 15, "audio/aac", true, arrayOfString);
    arrayOfString = new String[2];
    arrayOfString[0] = "mid";
    arrayOfString[1] = "midi";
    AUDIO_MIDI = new ContentType("AUDIO_MIDI", 16, "audio/midi", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "mp3";
    AUDIO_MPEG = new ContentType("AUDIO_MPEG", 17, "audio/mpeg", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "oga";
    AUDIO_OGA = new ContentType("AUDIO_OGA", 18, "audio/ogg", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "opus";
    AUDIO_OPUS = new ContentType("AUDIO_OPUS", 19, "audio/opus", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "wav";
    AUDIO_WAV = new ContentType("AUDIO_WAV", 20, "audio/wav", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "waba";
    AUDIO_WEBA = new ContentType("AUDIO_WEBA", 21, "audio/weba", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "avi";
    VIDEO_AVI = new ContentType("VIDEO_AVI", 22, "video/x-msvideo", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "mp4";
    VIDEO_MP4 = new ContentType("VIDEO_MP4", 23, "video/mp4", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "mpeg";
    VIDEO_MPEG = new ContentType("VIDEO_MPEG", 24, "video/mpeg", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "ogg";
    VIDEO_OGG = new ContentType("VIDEO_OGG", 25, "video/ogg", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "webm";
    VIDEO_WEBM = new ContentType("VIDEO_WEBM", 26, "video/webm", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "otf";
    FONT_OTF = new ContentType("FONT_OTF", 27, "font/otf", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "ttf";
    FONT_TTF = new ContentType("FONT_TTF", 28, "font/ttf", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "bin";
    APPLICATION_OCTET_STREAM = new ContentType("APPLICATION_OCTET_STREAM", 29, "application/octet-stream", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "bz";
    APPLICATION_BZ = new ContentType("APPLICATION_BZ", 30, "application/x-bzip", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "bz2";
    APPLICATION_BZ2 = new ContentType("APPLICATION_BZ2", 31, "application/x-bzip2", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "cdn";
    APPLICATION_CDN = new ContentType("APPLICATION_CDN", 32, "application/cdn", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "doc";
    APPLICATION_DOC = new ContentType("APPLICATION_DOC", 33, "application/msword", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "docx";
    APPLICATION_DOCX = new ContentType("APPLICATION_DOCX", 34, "application/vnd.openxmlformats-officedocument.wordprocessingml.document", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "epub";
    APPLICATION_EPUB = new ContentType("APPLICATION_EPUB", 35, "application/epub+zip", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "gz";
    APPLICATION_GZ = new ContentType("APPLICATION_GZ", 36, "application/gzip", false, arrayOfString);
    arrayOfString = new String[2];
    arrayOfString[0] = "js";
    arrayOfString[1] = "mjs";
    APPLICATION_JS = new ContentType("APPLICATION_JS", 37, "application/javascript", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "json";
    APPLICATION_JSON = new ContentType("APPLICATION_JSON", 38, "application/json", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "mpkg";
    APPLICATION_MPKG = new ContentType("APPLICATION_MPKG", 39, "application/vnd.apple.installer+xml", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "jar";
    APPLICATION_JAR = new ContentType("APPLICATION_JAR", 40, "application/java-archive", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "pdf";
    APPLICATION_PDF = new ContentType("APPLICATION_PDF", 41, "application/pdf", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "pom";
    APPLICATION_POM = new ContentType("APPLICATION_POM", 42, "application/xml", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "rar";
    APPLICATION_RAR = new ContentType("APPLICATION_RAR", 43, "application/vnd.rar", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "sh";
    APPLICATION_SH = new ContentType("APPLICATION_SH", 44, "application/x-sh", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "swf";
    APPLICATION_SWF = new ContentType("APPLICATION_SWF", 45, "application/x-shockwave-flash", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "tar";
    APPLICATION_TAR = new ContentType("APPLICATION_TAR", 46, "application/x-tar", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "xhtml";
    APPLICATION_XHTML = new ContentType("APPLICATION_XHTML", 47, "application/xhtml+xml", true, arrayOfString);
    arrayOfString = new String[2];
    arrayOfString[0] = "yaml";
    arrayOfString[1] = "yml";
    APPLICATION_YAML = new ContentType("APPLICATION_YAML", 48, "application/yaml", true, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "zip";
    APPLICATION_ZIP = new ContentType("APPLICATION_ZIP", 49, "application/zip", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "7z";
    APPLICATION_7Z = new ContentType("APPLICATION_7Z", 50, "application/x-7z-compressed", false, arrayOfString);
    arrayOfString = new String[1];
    arrayOfString[0] = "multipart/form-data";
    MULTIPART_FORM_DATA = new ContentType("MULTIPART_FORM_DATA", 51, "multipart/form-data", false, arrayOfString);
  }
  
  static {
    Companion = new Companion(null);
  }
  
  @NotNull
  public String toString() {
    return this.mimeType;
  }
  
  @JvmStatic
  @Nullable
  public static final ContentType getContentType(@NotNull String mimeType) {
    return Companion.getContentType(mimeType);
  }
  
  @JvmStatic
  @Nullable
  public static final ContentType getContentTypeByExtension(@NotNull String extension) {
    return Companion.getContentTypeByExtension(extension);
  }
  
  @JvmStatic
  @Nullable
  public static final String getMimeTypeByExtension(@NotNull String extensions) {
    return Companion.getMimeTypeByExtension(extensions);
  }
  
  @Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\034\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\b\n\002\030\002\n\002\b\006\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\022\020\f\032\004\030\0010\r2\006\020\016\032\0020\004H\007J\022\020\017\032\004\030\0010\r2\006\020\020\032\0020\004H\007J\022\020\021\032\004\030\0010\0042\006\020\022\032\0020\004H\007R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\016\020\006\032\0020\004XT¢\006\002\n\000R\016\020\007\032\0020\004XT¢\006\002\n\000R\016\020\b\032\0020\004XT¢\006\002\n\000R\016\020\t\032\0020\004XT¢\006\002\n\000R\016\020\n\032\0020\004XT¢\006\002\n\000R\016\020\013\032\0020\004XT¢\006\002\n\000¨\006\023"}, d2 = {"Lio/javalin/http/ContentType$Companion;", "", "()V", "CSS", "", "FORM_DATA", "HTML", "JAVASCRIPT", "JSON", "OCTET_STREAM", "PLAIN", "XML", "getContentType", "Lio/javalin/http/ContentType;", "mimeType", "getContentTypeByExtension", "extension", "getMimeTypeByExtension", "extensions", "javalin"})
  public static final class Companion {
    private Companion() {}
    
    @JvmStatic
    @Nullable
    public final ContentType getContentType(@NotNull String mimeType) {
      // Byte code:
      //   0: aload_1
      //   1: ldc 'mimeType'
      //   3: invokestatic checkNotNullParameter : (Ljava/lang/Object;Ljava/lang/String;)V
      //   6: invokestatic values : ()[Lio/javalin/http/ContentType;
      //   9: astore_2
      //   10: iconst_0
      //   11: istore_3
      //   12: aload_2
      //   13: arraylength
      //   14: istore #4
      //   16: iload_3
      //   17: iload #4
      //   19: if_icmpge -> 58
      //   22: aload_2
      //   23: iload_3
      //   24: aaload
      //   25: astore #5
      //   27: aload #5
      //   29: astore #6
      //   31: iconst_0
      //   32: istore #7
      //   34: aload #6
      //   36: invokevirtual getMimeType : ()Ljava/lang/String;
      //   39: aload_1
      //   40: iconst_1
      //   41: invokestatic equals : (Ljava/lang/String;Ljava/lang/String;Z)Z
      //   44: ifeq -> 52
      //   47: aload #5
      //   49: goto -> 59
      //   52: iinc #3, 1
      //   55: goto -> 16
      //   58: aconst_null
      //   59: areturn
      // Line number table:
      //   Java source line number -> byte code offset
      //   #113	-> 6
      //   #131	-> 31
      //   #113	-> 34
      //   #113	-> 44
      //   #113	-> 59
      // Local variable table:
      //   start	length	slot	name	descriptor
      //   34	10	7	$i$a$-find-ContentType$Companion$getContentType$1	I
      //   31	13	6	it	Lio/javalin/http/ContentType;
      //   0	60	0	this	Lio/javalin/http/ContentType$Companion;
      //   0	60	1	mimeType	Ljava/lang/String;
    }
    
    @JvmStatic
    @Nullable
    public final ContentType getContentTypeByExtension(@NotNull String extension) {
      Intrinsics.checkNotNullParameter(extension, "extension");
      ContentType[] arrayOfContentType = ContentType.values();
      int $i$f$firstOrNull = 0;
      byte b;
      int i;
      for (b = 0, i = arrayOfContentType.length; b < i; ) {
        Object element$iv = arrayOfContentType[b], object1 = element$iv;
        int $i$a$-firstOrNull-ContentType$Companion$getContentTypeByExtension$1 = 0;
        String[] arrayOfString = object1.getExtensions();
        int $i$f$any = 0;
        boolean bool = false;
        int j = arrayOfString.length;
      } 
      return null;
    }
    
    @JvmStatic
    @Nullable
    public final String getMimeTypeByExtension(@NotNull String extensions) {
      Intrinsics.checkNotNullParameter(extensions, "extensions");
      getContentTypeByExtension(extensions);
      return (getContentTypeByExtension(extensions) != null) ? getContentTypeByExtension(extensions).getMimeType() : null;
    }
  }
}
