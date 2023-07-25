package com.fch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @packageName com.fch.controller
 * @ClassName LoginController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/25 19:30
 * @Version 1.0
 */
@Slf4j
@Controller
public class LoginController {
    @GetMapping("/login.html")
    public String goToLogin() {
        return "login";
    }
}
