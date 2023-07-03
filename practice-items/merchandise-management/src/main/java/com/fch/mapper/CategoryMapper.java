package com.fch.mapper;

import com.fch.pojo.Category;

/**
 * @packageName com.fch.mapper
 * @ClassName CategoryMapper
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/2 11:28
 * @Version 1.0
 */
public interface CategoryMapper {
    Category selectById(Integer categoryId);
}
