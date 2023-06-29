package com.fch.service.impl;

import com.fch.bean.Category;
import com.fch.mapper.CategoryMapper;
import com.fch.service.CategoryService;
import com.fch.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @packageName com.fch.service.impl
 * @ClassName CategoryServiceImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/28 19:15
 * @Version 1.0
 */
public class CategoryServiceImpl implements CategoryService {
    SqlSession session = MybatisUtil.getSession();
    CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
    @Override
    public List<Category> getAllCategory() {
        return categoryMapper.getAllCategory();
    }
}
