package com.fch.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fch.domain.Blog;
import com.fch.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @packageName com.fch.controller
 * @ClassName BlogController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/28 10:40
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("blog")
public class BlogController {
    @Resource
    private BlogService blogService;

    @GetMapping("{id}")
    public Blog getBlogById(@PathVariable("id") Integer id) {
        log.info("入参：{}", id);
        Blog blog = blogService.getById(id);
        log.info("结果：{}", blog);
        return blog;
    }

    @GetMapping("query/{condition}")
    public List<Blog> getBlogsByCondition(@PathVariable("condition") String condition) {
        log.info("入参：{}", condition);
        // 封装查询条件
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .select("title", "content")
                .like("title", condition);

        // 调用list方法获取blog集合
        List<Blog> blogs = blogService.list(queryWrapper);
        log.info("结果：{}", blogs);

        return blogs;
    }

    @PutMapping
    public boolean update() {
        // 封装更新条件
        UpdateWrapper<Blog> blogUpdateWrapper = new UpdateWrapper<>();
        blogUpdateWrapper
                .set("title", "标题一")
                .eq("title", "标题五");
        // 执行更新
        boolean flag = blogService.update(blogUpdateWrapper);
        log.info("更新结果：{}", flag);
        return flag;
    }

    @GetMapping("/lambda/{id}")
    public Blog getById(@PathVariable("id") Integer id) {
        log.info("lambda 入参：{}", id);
        // 封装查询条件
        LambdaQueryWrapper<Blog> blogLambdaQueryWrapper = new LambdaQueryWrapper<>();
        blogLambdaQueryWrapper
                .select(Blog::getId, Blog::getTitle, Blog::getContent)
                .like(Blog::getId, id);

        // 查询
        Blog blog = blogService.getOne(blogLambdaQueryWrapper);
        log.info("lambda 结果：{}", blog);
        return blog;
    }

    @PutMapping("/lambda/{condition}")
    public boolean updateByCondition(@PathVariable("condition") String condition) {
        log.info("lambda 更新入参：{}", condition);
        LambdaUpdateWrapper<Blog> blogLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        blogLambdaUpdateWrapper
                .set(Blog::getContent, "内容六")
                .like(Blog::getContent, condition);

        boolean flag = blogService.update(null, blogLambdaUpdateWrapper);
        log.info("lambda 更新结果：{}", flag);
        return flag;
    }

    @GetMapping("/getPage")
    public Page<Blog> getPage(
            @RequestParam("current") Integer current,
            @RequestParam("pageSize") Integer pageSize,
            @RequestParam("query") String query
    ) {
        log.info("入参：{}， {}", current, pageSize);
        // 封装page对象
        Page<Blog> blogPage = new Page<>(current, pageSize);
        // 封装查询条件
        LambdaQueryWrapper<Blog> blogLambdaQueryWrapper = new LambdaQueryWrapper<>();
        blogLambdaQueryWrapper.like(Blog::getTitle, query);

        // 执行分页和条件过滤
        Page<Blog> page =  blogService.page(blogPage, blogLambdaQueryWrapper);
        log.info("结果：{}", page);
        return page;
    }

    @PostMapping("save")
    public boolean save(@RequestBody Blog blog) {
        log.info("入参：{}", blog);
        boolean flag = blogService.save(blog);
        log.info("结果：{}", flag);
        return flag;
    }

    @DeleteMapping("{id}")
    public boolean delById(@PathVariable Integer id) {
        log.info("入参：{}", id);
        // 物理删除 DELETE FROM blog WHERE id=?
        // 逻辑删除 UPDATE blog SET deleted=1 WHERE id=? AND deleted=0
        boolean flag = blogService.removeById(id);
        log.info("结果：{}", flag);
        return flag;
    }

    @PutMapping("update")
    public boolean update(@RequestBody Blog blog) {
        log.info("入参：{}", blog);
        boolean flag = blogService.updateById(blog);
        log.info("结果：{}", blog);
        return flag;
    }
}
