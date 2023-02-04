package io.javalin.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\004H\007J\020\020\006\032\0020\0042\006\020\005\032\0020\004H\007J\030\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\005\032\0020\004H\007¨\006\013"}, d2 = {"Lio/javalin/util/FileUtil;", "", "()V", "readFile", "", "path", "readResource", "streamToFile", "", "inputStream", "Ljava/io/InputStream;", "javalin"})
public final class FileUtil {
  @NotNull
  public static final FileUtil INSTANCE = new FileUtil();
  
  @JvmStatic
  public static final void streamToFile(@NotNull InputStream inputStream, @NotNull String path) {
    Intrinsics.checkNotNullParameter(inputStream, "inputStream");
    Intrinsics.checkNotNullParameter(path, "path");
    File newFile = new File(path);
    newFile.getParentFile().mkdirs();
    newFile.createNewFile();
    InputStream inputStream1 = inputStream;
    Throwable throwable = null;
    try {
      InputStream input = inputStream1;
      int $i$a$-use-FileUtil$streamToFile$1 = 0;
      CopyOption[] arrayOfCopyOption = new CopyOption[1];
      arrayOfCopyOption[0] = StandardCopyOption.REPLACE_EXISTING;
      long l = Files.copy(input, newFile.toPath(), arrayOfCopyOption);
    } catch (Throwable throwable1) {
      throwable = throwable1 = null;
      throw throwable1;
    } finally {
      CloseableKt.closeFinally(inputStream1, throwable);
    } 
  }
  
  @JvmStatic
  @NotNull
  public static final String readResource(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    Intrinsics.checkNotNullExpressionValue(FileUtil.class.getResource(path), "FileUtil::class.java.getResource(path)");
    URL uRL = FileUtil.class.getResource(path);
    Charset charset = Charsets.UTF_8;
    byte[] arrayOfByte = TextStreamsKt.readBytes(uRL);
    return new String(arrayOfByte, charset);
  }
  
  @JvmStatic
  @NotNull
  public static final String readFile(@NotNull String path) {
    Intrinsics.checkNotNullParameter(path, "path");
    return FilesKt.readText$default(new File(path), null, 1, null);
  }
}
