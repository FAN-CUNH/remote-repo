package com.fch.dao;

import com.fch.BaseUtil;
import com.fch.bean.Category;
import com.fch.bean.Page;
import com.fch.bean.Product;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

/**
 * @packageName com.fch.dao
 * @ClassName ProductDao
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/13 18:45
 * @Version 1.0
 */
public interface ProductDao {
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
     * @param
     * @return 更新状态
     */
    boolean updateProduct(String pid, String pname, double market_price, double shop_price, String cid);

    /**
     * 添加商品
     *
     * @param
     * @return 添加状态
     */
    boolean addProduct(String pid, String pname, double market_price, double shop_price, String pimage, String cid);

    List<Category> queryAllProductCategory();

    Page<Product> queryProductByCategory(String cid, int currentPage, int pageSize);

    boolean deleteProductById(String pid);
}
