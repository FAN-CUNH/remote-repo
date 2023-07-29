package com.fch.controller;

import com.fch.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import java.util.stream.Stream;

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
    /**
     * 利用thymeleaf实现登录页请求
     *
     * @return classpath:/templates/login.html
     */
    @GetMapping("/login.html")
    public String goToLogin() {
        return "login";
    }

    /**
     * 利用thymeleaf实现主页请求
     *
     * @return classpath:/templates/index.html
     */
    @GetMapping("/index")
    public String goToMain() {
        return "index";
    }

    /**
     * 前端表单login请求
     *
     * @return 登录成功跳转 -> index.html 登录失败 -> login.html
     */
    @PostMapping("/login")
    public String login(User user, HttpSession session, Model model) {
        log.info("user :{}", user);
        if (user == null) {
            log.error("非法参数!");
            model.addAttribute("msg", "账户密码不能为空！");
            return "login";
        }
        if (user.getUsername() == null || "".equals(user.getUsername())) {
            log.error("账户不能为空！");
            model.addAttribute("msg", "账户不能为空！");
            return "login";
        }
        if (user.getPassword() == null || "".equals(user.getPassword())) {
            log.error("密码不能为空！");
            model.addAttribute("msg", "密码不能为空！");
            return "login";
        }
        log.info("登陆成功！");
        session.setAttribute("user", user);
        model.addAttribute("msg", "登录成功！");
        return "redirect:index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate();
        model.addAttribute("msg", "已登出");
        return "login";
    }

    /**
     * @return 真实路径 classpath:/templates/form_layouts.html
     */
    @GetMapping("/form_layouts.html")
    public String goToFormLayouts() {
        return "form_layouts";
    }

    @PostMapping("/upload")
    public String upload(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestPart("photo") MultipartFile photo,
            @RequestPart("photos") MultipartFile[] photos
    ) {
        log.info("上传个人信息 入参：{}，{}，{}，{}", username, password, photo, photos);

        // 处理单个文件上传
        fileUpload(photo);

        // 处理多个文件
        if (photos != null && photos.length > 0) {
            Stream.of(photos).forEach(LoginController::fileUpload);
        }

        return "redirect:/index";
    }

    private static void fileUpload(MultipartFile file) {
        if (file != null) {
            String originalFilename = file.getOriginalFilename();
            if (StringUtils.hasLength(originalFilename)) {
                String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
                String fileName = UUID.randomUUID() + suffix;
                try {
                    file.transferTo(new File("E:\\Java\\10.SpringBoot\\temp\\" + fileName));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
