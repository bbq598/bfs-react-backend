package com.bfs.auth.controller;

import com.bfs.auth.domain.Test;
import com.bfs.auth.service.UserService;
import com.bfs.auth.utils.CookieUtil;
import com.bfs.auth.utils.JwtUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
@Controller
public class LoginController {
    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "signingKey";
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        System.out.println("get login is ok");
        return "login";
    }

    @PostMapping("/login")
    public String login(HttpServletResponse response, String username, String password, String redirect, Model model) {
        System.out.println("post login is ok");
        if (username == null || password == null) {
            model.addAttribute("err", "Invalid username or password!");
            return "login";
        } else if (userService.checkUser(username, password) == null) {
            model.addAttribute("err", "Invalid username or password!");
            return "login";
        }
        Test t = new Test("testname", "testage");
        Gson gson = new Gson();
        String test = gson.toJson(t);
        String token = JwtUtil.generateToken(signingKey,test);
        CookieUtil.create(response, jwtTokenCookieName, token, false, -1, "localhost");
        return "redirect:" + redirect;
    }
}
