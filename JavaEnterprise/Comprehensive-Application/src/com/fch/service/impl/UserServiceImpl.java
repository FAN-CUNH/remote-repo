package com.fch.service.impl;

import com.fch.bean.Category;
import com.fch.bean.Page;
import com.fch.bean.Product;
import com.fch.bean.User;
import com.fch.dao.UserDao;
import com.fch.dao.impl.UserDaoImpl;
import com.fch.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.service.impl
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/6 15:06
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = null;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    /**
     * 登录功能接口
     *
     * @param userId   用户id
     * @param password 用户密码
     * @return 登录对象
     */
    @Override
    public User userLoad(String userId, String password) {
        return userDao.userLoad(userId, password);
    }

    /**
     * @param currentPage  当前页码
     * @param everyPageRow 每页显示条数
     * @return Page<Map < String, Object>> 将获取的商品信息存入页面对象中
     */
    @Override
    public Page<Map<String, Object>> getPage(int currentPage, int everyPageRow) {
        return userDao.getPage(currentPage, everyPageRow);
    }

    /**
     * @param pid   商品id
     * @param panme 商品名称
     * @return 返回一个商品信息集合包含商品类别
     */
    @Override
    public List<Map<String, Object>> selectProductMess(String pid, String panme) {
        return userDao.selectProductMess(pid, panme);
    }

    /**
     * 根据商品id删除商品条目
     *
     * @param pid 商品id
     * @return true: 删除成功 false: 删除失败
     */
    @Override
    public boolean deleteProductByPid(String pid) {
        return userDao.deleteProductByPid(pid);
    }

    /**
     * 根据商品id删除商品条目
     *
     * @param allPid 商品id
     * @return true: 删除成功 false: 删除失败
     */
    @Override
    public boolean deleteAllProductById(String allPid) {
        return userDao.deleteAllProductById(allPid);
    }

    /**
     * 根据 pid 展示商品信息
     *
     * @param pid 商品pid
     * @return 返回是否成功展示
     */
    @Override
    public Product showCheckedMess(String pid) {
        return userDao.showCheckedMess(pid);
    }

    @Override
    public boolean addProducts(Product product) {
        return userDao.addProducts(product);
    }

    @Override
    public List<Category> getCategory() {
        return userDao.getCategory();
    }
}
