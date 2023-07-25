package com.fch.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @packageName com.fch.controller
 * @ClassName RestfulController
 * @Description Restful风格
 * @Author Fan-CUNH
 * @Date 2023/7/24 18:16
 * @Version 1.0
 */
@RestController
@RequestMapping("rest")
public class RestfulController {
    @GetMapping
    public String get() {
        return "GET";
    }
    @PostMapping
    public String post() {
        return "POST";
    }
    @PutMapping
    public String put() {
        return "PUT";
    }
    @DeleteMapping
    public String delete() {
        return "DELETE";
    }
}
