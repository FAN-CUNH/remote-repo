package com.fch.service;

import com.fch.bean.Page;
import com.fch.bean.Product;
import com.fch.bean.Result;

/**
 * @packageName com.fch.service
 * @ClassName ProductService
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/13 18:22
 * @Version 1.0
 */
public interface ProductService {
    /**
     * 获取商品信息
     *
     * @param currentPage 当前页码
     * @param pageSize 每页显示条数
     * @return 分页数据
     */
    Page<Product> getAllProductMess(int currentPage, int pageSize);

    /**
     * 根据商品ID删除商品 删除时先删除商品与种类关系表，再删除商品表中该商品
     *
     * @param pid 商品pid
     * @return 状态 true成功 false失败
     */
    boolean deleteProductByPid(String pid);

    /**
     * 更新商品
     *
     * @param product 商品对象
     * @return 更新状态
     */
    Result<Object> updateProduct(Product product);

    /**
     * 添加商品
     *
     * @param product 商品商品对象
     * @return 添加状态
     */
    Result<Object> addProduct(Product product);

    /**
     * @return 结果集
     */
    Result<Object> queryAllProductCategory();

    /**
     * @param cid 商品种类id
     * @param currentPage 当前页码
     * @param pageSize 每页显示条数
     * @return 结果集
     */
    Result<Object> queryProductByCategory(String cid, int currentPage, int pageSize);

    Result<Object> deleteProductById(String pid);
}
