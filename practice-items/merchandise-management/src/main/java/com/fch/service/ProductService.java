package com.fch.service;

import com.fch.pojo.Category;
import com.fch.pojo.Product;

import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName ProductServiceImpl
 * @Description 业务逻辑接口
 * @Author Fan-CUNH
 * @Date 2023/7/2 10:00
 * @Version 1.0
 */
public interface ProductService {
    List<Product> getPlist();

    void deleteById(Integer productId);

    void update(Product product);

    Product selectById(String productId);

    List<Category> getCategoryList();

    void insert(Product product);
}
