package com.fch.controller;

import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @packageName com.fch.controller
 * @ClassName UserController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/19 16:17
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")

public class UserController {
    /**
     * 当Spring Security完成认证后，会将当前用户信息保存至框架提供的上下文对象中
     * 此处User为org.springframework.security.core.userdetails.User;
     * @return
     */
    @GetMapping("getUsername")
    public Result getUsername() {
        // 获取登录用户对象
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        log.info("认证后的信息 ：{}", principal);
        if (principal != null) {
            String username = principal.getUsername();
            return new Result(Code.GET_OK, Msg.GET_USERNAME_SUCCESS, username);
        }
        return new Result(Code.GET_ERR, Msg.GET_USERNAME_FAIL);
    }
}
