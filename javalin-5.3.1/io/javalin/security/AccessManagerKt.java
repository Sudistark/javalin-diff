package io.javalin.security;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mv = {1, 7, 1}, k = 2, xi = 48, d1 = {"\000\b\n\000\n\002\030\002\n\000\032\006\020\000\032\0020\001¨\006\002"}, d2 = {"accessManagerNotConfiguredException", "Ljava/lang/IllegalStateException;", "javalin"})
public final class AccessManagerKt {
  @NotNull
  public static final IllegalStateException accessManagerNotConfiguredException() {
    return new IllegalStateException("No access-manager configured. Add an access-manager using 'Javalin.create(c -> c.core.accessManager(...))'.");
  }
}
