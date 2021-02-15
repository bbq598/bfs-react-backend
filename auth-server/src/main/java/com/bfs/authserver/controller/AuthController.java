package com.bfs.authserver.controller;


import com.bfs.authserver.model.AuthenticationRequest;
import com.bfs.authserver.service.MyUserDetailsService;
import com.bfs.authserver.utils.CookieUtil;
import com.bfs.authserver.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AuthController {
    private static final String jwtTokenCookieName = "JWT-TOKEN";

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;


    @GetMapping("/auth")
    public String auth(@RequestParam(required = false) String redirect) {
        return "login/login.html";
    }

    @PostMapping("/auth")
    public String createAuthToken(HttpServletResponse response, AuthenticationRequest authenticationRequest) throws Exception{
        System.out.println(authenticationRequest.toString());
        try{
            authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }catch (Exception e){
            return "redirect:"+authenticationRequest.getRedirect();
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);
        CookieUtil.create(response, jwtTokenCookieName, jwt, false, -1, "localhost");
        String redirect = authenticationRequest.getRedirect();
        if(redirect==null) return "redirect:auth";
        return "redirect:"+redirect.substring(redirect.indexOf("?redirect=")+10);
    }
}
