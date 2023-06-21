package com.fch.dao;

import com.fch.bean.Category;
import com.fch.bean.Page;
import com.fch.bean.Product;
import com.fch.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.dao
 * @ClassName UserDao
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/6 15:04
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 登录功能接口
     *
     * @param userId 用户id
     * @param password 用户密码
     * @return 登录对象
     */
    User userLoad(String userId, String password);

    /**
     * @param currentPage 当前页码
     * @param everyPageRow 每页显示条数
     * @return Page<Map<String, Object>> 将获取的商品信息存入页面对象中
     */
    Page<Map<String, Object>> getPage(int currentPage, int everyPageRow);

    /**
     * @param pid 商品id
     * @param panme 商品名称
     * @return 返回一个商品信息集合包含商品类别
     */
    List<Map<String, Object>> selectProductMess(String pid, String panme);


    /**
     * 根据商品id删除商品条目
     *
     * @param pid 商品id
     * @return true: 删除成功 false: 删除失败
     */
    boolean deleteProductByPid(String pid);

    /**
     * 根据商品id删除商品条目
     *
     * @param allPid 商品id
     * @return true: 删除成功 false: 删除失败
     */
    public boolean deleteAllProductById(String allPid);


    /**
     * 根据 pid 展示商品信息
     *
     * @param pid 商品pid
     * @return 返回是否成功展示
     */
    Product showCheckedMess(String pid);

    boolean addProducts(Product product);

    List<Category> getCategory();
}
