package com.fch.service.impl;

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
 * @Date 2023/7/27 11:30
 * @Version 1.0
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    private BlogMapper blogMapper;

    @Override
    public Blog getById(Integer id) {
        return blogMapper.getById(id);
    }
}
