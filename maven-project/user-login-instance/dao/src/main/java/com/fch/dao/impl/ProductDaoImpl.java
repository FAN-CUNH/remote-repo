package com.fch.dao.impl;

import com.fch.BaseUtil;
import com.fch.bean.Category;
import com.fch.bean.Page;
import com.fch.bean.Product;
import com.fch.dao.ProductDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @packageName com.fch.dao.impl
 * @ClassName ProductDaoImpl
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/13 18:26
 * @Version 1.0
 */
public class ProductDaoImpl implements ProductDao {
    QueryRunner queryRunner = new QueryRunner();
    Connection conn = BaseUtil.dateBaseUtil();

    /**
     * 分页获取所有商品信息
     *
     * @param currentPage 当前页码
     * @param pageSize    每页显示条数
     * @return 返回分页对象
     */
    @Override
    public Page<Product> getAllProductMess(int currentPage, int pageSize) {
        // 声明一个商品集合 用于接收查询结果
        List<Product> products;

        // 编写查询所有商品信息sql
        String sql = String.format("select pid, pname, market_price, shop_price, pimage, is_hot, cid from product  limit %s, %s", (currentPage - 1) * pageSize, pageSize);
        System.out.println("sql = " + sql);
        long count;
        // 执行sql
        try {
            products = queryRunner.query(conn, sql, new BeanListHandler<>(Product.class));
            for (Product product : products) {
                Category category;
                String cid = product.getCid();
                System.out.println("cid = " + cid);
                String sql1 = String.format("select * from category where cid = %s", cid);
                System.out.println("sql1 = " + sql1);
                category = queryRunner.query(conn, sql1, new BeanHandler<>(Category.class));
                product.setCategory(category);
            }
            count = (long) queryRunner.query(conn, "select count(0) from product", new ScalarHandler());
            System.out.println("count = " + count);
            System.out.println("products = " + products);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 响应数据
        return new Page<>(currentPage, pageSize, (int) count, products);
    }

    /**
     * @param pid 商品pid
     * @return
     */
    @Override
    public boolean deleteProductByPid(String pid) {
        return false;
    }

    /**
     * @param
     * @return
     */
    @Override
    public boolean updateProduct(String pid, String pname, double market_price, double shop_price, String cid) {
        // 编写更新商品sql
        String sql = String.format("update product set pid = %s, pname = '%s', market_price = %s, shop_price = %s, cid = %s where pid = %s", pid, pname, market_price, shop_price, cid, pid);
        System.out.println("编写更新商品sql = " + sql);

        // 执行sql
        int update;
        try {
            update = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return (update > 0);
    }

    /**
     * @param
     * @return
     */
    @Override
    public boolean addProduct(String pid, String pname, double market_price, double shop_price, String pimage, String cid) {
        // 编写商品更新sql
        String sql = String.format("insert into product (pid, pname, market_price, shop_price, pimage, cid) values (%s, %s, %s, %s, %s, %s)", pid, pname, market_price, shop_price, pimage, cid);
        System.out.println("sql = " + sql);

        // 执行sql
        int update;
        try {
            update = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return update > 0;
    }

    @Override
    public List<Category> queryAllProductCategory() {
        //0. 编写查询所有商品种类的sql
        String sql = ("select * from category");
        System.out.println("查询所有商品种类的sql = " + sql);

        //1. 执行sql
        List<Category> categoryName;
        try {
            categoryName = queryRunner.query(conn, sql, new BeanListHandler<>(Category.class));
            System.out.println("categoryName = " + categoryName);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryName;
    }

    @Override
    public Page<Product> queryProductByCategory(String cid, int currentPage, int pageSize) {
        // 编写按类别查询sql
        String sql = String.format("select pid, pname, market_price, shop_price, pimage, cid from product where cid = %s limit %s, %s", cid, (currentPage - 1) * pageSize, pageSize);
        System.out.println("编写按类别查询sql = " + sql);
        String sql1 = "select count(0) from product where cid = " + cid;

        // 执行sql
        List<Product> products;
        long total;
        try {
            products = queryRunner.query(conn, sql, new BeanListHandler<Product>(Product.class));
            for (Product product : products) {
                String categoryCid = product.getCid();
                String sql2 = "select * from category where cid = " + categoryCid;
                System.out.println("编写按类别查询sql2 = " + sql2);
                Category category = queryRunner.query(conn, sql2, new BeanHandler<>(Category.class));
                product.setCategory(category);
            }
            total = (long) queryRunner.query(conn, sql1, new ScalarHandler());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("products = " + products);
        System.out.println("total = " + total);
        System.out.println("编写按类别查询sql1 = " + sql1);

        return new Page<>(currentPage, pageSize, (int)total, products);
    }

    @Override
    public boolean deleteProductById(String pid) {
        // 编写删除单个商品sql
        String sql = String.format("delete from product where pid = %s", pid);
        System.out.println("sql = " + sql);

        int delete;
        // 执行sql
        try {
            delete = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return delete > 0;
    }
}
