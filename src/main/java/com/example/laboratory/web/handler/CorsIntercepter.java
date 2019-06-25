/*
package com.example.laboratory.web.handler;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Order(Integer.MIN_VALUE)
public class CorsIntercepter implements HandlerInterceptor {
    @Override//执行之前
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("你成功了！");
      if (request.getHeader(HttpHeaders.ORIGIN) != null) {
           response.addHeader("Access-Control-Allow-Origin", "*");
          response.addHeader("Access-Control-Allow-Credentials", "true");
          response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
           response.addHeader("Access-Control-Max-Age", "3600");
       }
       return true;
   }

   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
*/
