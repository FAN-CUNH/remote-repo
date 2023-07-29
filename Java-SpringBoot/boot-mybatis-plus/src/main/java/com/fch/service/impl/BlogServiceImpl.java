package com.fch.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fch.domain.Blog;
import com.fch.mapper.BlogMapper;
import com.fch.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @packageName com.fch.service.impl
 * @ClassName BlogServiceImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/28 10:38
 * @Version 1.0
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Resource
    private BlogMapper blogMapper;
}
