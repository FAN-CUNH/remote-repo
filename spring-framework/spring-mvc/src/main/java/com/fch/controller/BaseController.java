package com.fch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @packageName com.fch.controller
 * @ClassName BaseController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/4 10:28
 * @Version 1.0
 */

@Controller
public class BaseController {
    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("test");
        return "测试";
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "upload.jsp";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename = " + originalFilename);
        try {
            file.transferTo(new File(
                    "E:\\IntelliJ-IDEA-Project\\spring-framework\\spring-mvc\\src\\main\\resources\\static\\"
                            +originalFilename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "index.jsp";
    }
}
