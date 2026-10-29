package com.web.site.web_site.controller;

import com.web.site.web_site.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class LoginController {

    private final LoginService loginService;

    public LoginController(
            LoginService loginService
    ){
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String index(){return "index";}

}
