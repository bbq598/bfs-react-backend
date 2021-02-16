package com.bfs.employee_server.filter;


import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        JwtUtil jwtUtil = new JwtUtil();
        final String authorizationHeader = request.getHeader("Authorization");
        String jwt = null;
        if(authorizationHeader!=null&&authorizationHeader.startsWith("Bearer ")&&authorizationHeader.length() > 20){
            jwt = authorizationHeader.substring(7);
        }else {
            response.setStatus(2200);
            System.out.println("already here");
//            response.sendRedirect("www.baidu.com");
            response.setHeader("Location", "http://localhost:9999/auth?redirect="+request.getRequestURI());
            return;
        }
        if(jwtUtil.isTokenExpired(jwt)){
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("http://localhost:9999/auth?redirect="+request.getRequestURI());
           return;
        }
        Claims c = jwtUtil.extractAllClaims(jwt);
        String username = (String)c.get("username");
        int index = username.indexOf("?userId=");
        request.setAttribute("username", username.substring(0,index));
        request.setAttribute("userId", username.substring(index+8));
        filterChain.doFilter(request,response);
    }
}
