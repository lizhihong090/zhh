package com.ngdp.filter;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Cors filter
 *
 */
public class CorsFilter implements Filter {


  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
      throws IOException, ServletException {
    String origin = ((HttpServletRequest) request).getHeader("Origin");

    if (((HttpServletRequest) request).getMethod().equals("OPTIONS")) {
      HttpServletResponse resp = ((HttpServletResponse) response);
      addCorsHeaders(resp, origin);
      return;
    }

    if (response instanceof HttpServletResponse) {
      HttpServletResponse alteredResponse = ((HttpServletResponse) response);
      addCorsHeaders(alteredResponse, origin);
    }
    filterChain.doFilter(request, response);
  }

  private void addCorsHeaders(HttpServletResponse response, String origin) {
    response.addHeader("Access-Control-Allow-Origin", origin);
    response.addHeader("Access-Control-Allow-Credentials", "true");
    response.addHeader("cors.exposed.headers", "Access-Control-Allow-Origin,Access-Control-Allow-Credentials");
    response.addHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Last-Modified,Authorization,Jwt-User-Info,site");
    response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, HEAD, DELETE");
    DateFormat fullDateFormatEN =
        DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, new Locale("EN", "en"));
    response.addHeader("Date", fullDateFormatEN.format(new Date()));
  }

  @Override
  public void destroy() {}

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {}
}
