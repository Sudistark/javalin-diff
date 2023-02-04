package io.javalin.http.staticfiles;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface ResourceHandler {
  boolean handle(HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse);
  
  boolean addStaticFileConfig(StaticFileConfig paramStaticFileConfig);
}
