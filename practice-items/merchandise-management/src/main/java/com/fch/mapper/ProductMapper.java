package com.fch.mapper;

import com.fch.pojo.Category;
import com.fch.pojo.Product;

import java.util.List;

/**
 * @packageName com.fch.mapper
 * @ClassName ProductMapper
 * @Description Mapper 数据持久层接口 进行数据的CRUD
 * @Author Fan-CUNH
 * @Date 2023/7/2 10:05
 * @Version 1.0
 */
public interface ProductMapper {
    List<Product> getPlist();

    void deleteById(Integer productId);

    void update(Product product);

    Product selectById(String productId);

    List<Category> getCategoryList();

    void insert(Product product);
}
