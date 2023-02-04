package io.javalin.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 1, xi = 48, d1 = {"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\002\b\004\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006J\016\020\007\032\0020\0042\006\020\005\032\0020\006J\016\020\b\032\0020\0042\006\020\t\032\0020\004¨\006\n"}, d2 = {"Lio/javalin/util/DependencyUtil;", "", "()V", "mavenAndGradleSnippets", "", "dependency", "Lio/javalin/util/OptionalDependency;", "missingDependencyMessage", "wrapInSeparators", "msg", "javalin"})
public final class DependencyUtil {
  @NotNull
  public static final DependencyUtil INSTANCE = new DependencyUtil();
  
  @NotNull
  public final String missingDependencyMessage(@NotNull OptionalDependency dependency) {
    Intrinsics.checkNotNullParameter(dependency, "dependency");
    return wrapInSeparators(

        
        StringsKt.trimMargin$default("|You're missing the '" + dependency.getDisplayName() + "' dependency in your project. Add the dependency:\n           |\n           |" + mavenAndGradleSnippets(dependency), null, 1, null));
  }
  
  @NotNull
  public final String mavenAndGradleSnippets(@NotNull OptionalDependency dependency) {
    Intrinsics.checkNotNullParameter(dependency, "dependency");
    return StringsKt.trimMargin$default("\n           |pom.xml:\n           |<dependency>\n           |    <groupId>" + dependency.getGroupId() + "</groupId>\n           |    <artifactId>" + dependency.getArtifactId() + "</artifactId>\n           |    <version>" + dependency.getVersion() + "</version>\n           |</dependency>\n           |\n           |build.gradle or build.gradle.kts:\n           |implementation(\"" + dependency.getGroupId() + ":" + dependency.getArtifactId() + ":" + dependency.getVersion() + "\")", null, 1, null);
  }
  
  @NotNull
  public final String wrapInSeparators(@NotNull String msg) {
    Intrinsics.checkNotNullParameter(msg, "msg");
    return StringsKt.trimMargin$default("\n        |\n        |#########################################################################\n        |" + msg + "\n        |#########################################################################", null, 1, null);
  }
}
