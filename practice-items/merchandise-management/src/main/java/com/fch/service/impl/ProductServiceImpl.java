package com.fch.service.impl;

import com.fch.config.MybatisSqlSessionConfig;
import com.fch.mapper.ProductMapper;
import com.fch.pojo.Category;
import com.fch.pojo.Product;
import com.fch.service.ProductService;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @packageName com.fch.service.impl
 * @ClassName ProductServiceImpl
 * @Description 业务逻辑接口实现类
 * @Author Fan-CUNH
 * @Date 2023/7/2 10:01
 * @Version 1.0
 */
public class ProductServiceImpl implements ProductService {
    // 获取productMapper
    private final SqlSession session = MybatisSqlSessionConfig.getSession();
    /**
     * 商品数据持久层对象
     */
    private final ProductMapper productMapper = session.getMapper(ProductMapper.class);

    @Override
    public List<Product> getPlist() {
        return productMapper.getPlist();
    }

    @Override
    public void deleteById(Integer productId) {
        //0. 参数校验
        if (productId == null) {
            return;
        } else {
            //1. 调用数据持久层
            productMapper.deleteById(productId);
        }

        //2. 提交事务
        session.commit();
    }

    @Override
    public void update(Product product) {
        //0. 参数校验
        if (product == null) {
            return;
        } else {
            //1. 调用数据持久层
            productMapper.update(product);
        }

        //2. 提交事务
        session.commit();
    }

    @Override
    public Product selectById(String productId) {
        return productMapper.selectById(productId);
    }

    @Override
    public List<Category> getCategoryList() {
        return productMapper.getCategoryList();
    }

    @Override
    public void insert(Product product) {
        productMapper.insert(product);
        session.commit();
    }
}
