package com.fch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @packageName com.fch.controller
 * @ClassName BaseController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/4 10:28
 * @Version 1.0
 */

@Controller
@ResponseBody
public class BaseController {
    @RequestMapping("test.action")
    public String test() {
        System.out.println("test");
        return "测试";
    }

    @PostMapping("login.action")
    public String login(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "index.jsp";
    }
}
