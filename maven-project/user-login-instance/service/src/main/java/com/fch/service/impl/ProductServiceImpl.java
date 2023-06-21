package com.fch.service.impl;


import com.fch.bean.Category;
import com.fch.bean.Page;
import com.fch.bean.Product;
import com.fch.bean.Result;
import com.fch.dao.ProductDao;
import com.fch.dao.impl.ProductDaoImpl;
import com.fch.service.ProductService;

import java.util.List;

/**
 * @packageName com.fch.service.impl
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/13 18:24
 * @Version 1.0
 */
public class ProductServiceImpl implements ProductService {
    /**
     * 调用数据访问层
     */
    ProductDao productDao = new ProductDaoImpl();

    @Override
    public Page<Product> getAllProductMess(int currentPage, int pageSize) {
        return productDao.getAllProductMess(currentPage, pageSize);
    }

    @Override
    public boolean deleteProductByPid(String pid) {
        return false;
    }

    @Override
    public Result<Object> updateProduct(Product product) {
        String pid = product.getPid();
        String pname = product.getPname();
        Double market_price = product.getMarket_price();
        Double shop_price = product.getShop_price();
        String pimage = product.getPimage();
        String cid = product.getCid();
        Result result;
        if (pid.isEmpty() || pname.isEmpty() || pimage.isEmpty() || cid.isEmpty()) {
            result = new Result(400, "非法参数", "更新失败");
        } else {
            boolean updated = productDao.updateProduct(pid, pname, market_price, shop_price, cid);
            if (updated) {
                System.out.println("\"更新成功\" = " + "更新成功");
                result = new Result(20000, updated, "更新成功");
            } else {
                result = new Result(400, "服务器错误", "更新失败");
            }
        }
        return result;
    }

    @Override
    public Result<Object> addProduct(Product product) {
        // 逻辑处理
        Result<Object> result;
        if (product != null) {
            String pid = product.getPid();
            String pname = product.getPid();
            double market_price = product.getMarket_price();
            double shop_price = product.getShop_price();
            String pimage = product.getPimage();
            String cid = product.getCid();
            if (pid.isEmpty()) {
                result = new Result<>(400, "参数异常", "添加失败");
                System.out.println("参数异常");
            } else {
                if (productDao.addProduct(pid, pname, market_price, shop_price, pimage, cid)) {
                    result = new Result<>(20000, "更新成功", "添加成功");
                    System.out.println("添加成功");
                } else {
                    result = new Result<>(500, "服务器内部错误", "添加失败");
                    System.out.println("服务器内部错误");
                }
            }
        } else {
            result = new Result<>(400, "非法请求参数", "更新失败");
            System.out.println("非法请求参数");
        }
        return result;
    }

    @Override
    public Result<Object> queryAllProductCategory() {
        Result<Object> result;

        List<Category> categoryName = productDao.queryAllProductCategory();

        if (categoryName != null) {
            result = new Result<>(20000, categoryName, "正常");
        } else {
            result = new Result<>(400, null, "正常");
        }
        return result;
    }

    @Override
    public Result<Object> queryProductByCategory(String cid, int currentPage, int pageSize) {
        Result<Object> result;
        if (!"0".equals(cid)) {
            Page<Product> data = productDao.queryProductByCategory(cid, currentPage, pageSize);
            if (data != null) {
                result = new Result<>(20000, data, "查询成功");
            } else {
                result = new Result<>(500, "服务器内部错误", "查询失败");
            }
        } else {
            if ("0".equals(cid)) {
                Page<Product> data = productDao.getAllProductMess(currentPage, pageSize);
                result = new Result<>(20000, data, "查询成功");
            } else {
                result = new Result<>(400, "非法参数", "查询失败");
            }
        }
        return result;
    }

    @Override
    public Result<Object> deleteProductById(String pid) {
        // 声明响应体
        Result<Object> result;
        // 逻辑处理
        if (pid != null && !"".equals(pid)) {
            // 调用数据访问层
            boolean delete = productDao.deleteProductById(pid);
            if (delete) {
                result = new Result<>(20000, "删除成功", "删除成功");
            } else {
                result = new Result<>(500, "服务器内部错误", "删除失败");
            }
        } else {
            result = new Result<>(400, "非法参数", "删除失败");
        }
        return result;
    }
}
