package com.bfs.time_sheetserver.filter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
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
        if(authorizationHeader!=null&&authorizationHeader.startsWith("Bearer ")){
            jwt = authorizationHeader.substring(7);
        }else {
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
            response.setHeader("Location", "http://localhost:9999/auth?redirect="+request.getRequestURI());
            return;
        }
        if(jwtUtil.isTokenExpired(jwt)){
            response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
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
