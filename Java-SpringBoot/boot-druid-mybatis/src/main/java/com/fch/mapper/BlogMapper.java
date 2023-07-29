package com.fch.mapper;

import com.fch.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @packageName com.fch.mapper
 * @ClassName BlogMapper
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/27 11:27
 * @Version 1.0
 */
public interface BlogMapper {
    Blog getById(Integer id);
}
