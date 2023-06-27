package com.fch.mapper;

import com.fch.bean.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @packageName com.fch.mapper
 * @ClassName BlogMapper
 * @Description 接口命名一般以表名为主, 例如Blog, 那我们一般命名为BlogMapper
 * @Author Fan-CUNH
 * @Date 2023/6/25 15:22
 * @Version 1.0
 */
public interface BlogMapper {
    /**
     * 查询所有Blog的方法
     * 这个方法名和BlogMapper.xml中select的id值相同
     *
     * @return 返回bolg集合
     */
    List<Blog> selectBlog();

    /**
     * 对象方式插入blog
     *
     * @param blog 插入数据库的对象
     */
    // 第一种
    void insertBlog(Blog blog);

    /**
     * param参数传递多个参数
     *
     * @param id      插入的id
     * @param title   插入的title
     * @param content 插入的content
     */
    // 第二种
    void insertBlog(@Param("id") int id, @Param("title") String title, @Param("content") String content);

    /**
     * @param blog 更新的对象
     */
    void updateBlog(Blog blog);

    /**
     * @param id 删除的记录的id
     */
    void deleteBlog(int id);
}
