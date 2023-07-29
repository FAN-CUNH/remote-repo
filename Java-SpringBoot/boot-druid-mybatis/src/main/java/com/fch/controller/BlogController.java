package com.fch.controller;

import com.fch.domain.Blog;
import com.fch.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @packageName com.fch.controller
 * @ClassName BlogController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/27 11:29
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    private BlogService blogService;

    @GetMapping("{id}")
    public Blog getById(@PathVariable("id") Integer id) {
        log.info("查询 入参：{}", id);
        Blog blog = blogService.getById(id);
        log.info("查询 结果：{}", blog);
        return blog;
    }
}
