package com.fch.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @packageName com.fch.controller
 * @ClassName BlogMapper
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/26 21:57
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("count")
    public Integer getCount() {
        Integer count = jdbcTemplate.queryForObject("select count(0) from blog", Integer.class);
        log.info("count = {}", count);
        return count;
    }
}
