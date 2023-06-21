package com.fch.service.impl;

import com.fch.bean.*;
import com.fch.dao.CartDao;
import com.fch.dao.impl.CartDaoImpl;
import com.fch.service.CartService;

import java.util.Arrays;
import java.util.List;

/**
 * @packageName com.fch.service.impl
 * @ClassName CartServiceImpl
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/15 10:44
 * @Version 1.0
 */
public class CartServiceImpl implements CartService {
    CartDao cartDao = new CartDaoImpl();
    final String errMsg = "查询失败，当前词条无匹配项";
    /**
     * 响应体类型
     */
    Result<Object> result;

    @Override
    public Result<Object> queryProduct(String pname, String queryId, int currentPage, int pageSize) {
        //0. 声明一个Result接收响应体
        Page<Product> page;

        //1. 业务逻辑处理
        if (pname != null && queryId != null && !"".equals(pname) && !"".equals(queryId)) {
            page = cartDao.queryProduct(pname, queryId, currentPage, pageSize);
            if (page.getData() != null) {
                result = new Result<>(20000, page, "查询成功，与" + pname + "和" + queryId + "相关的产品查询如下");
            } else {
                result = new Result<>(500, page, errMsg);
            }
        } else if (pname != null && !"".equals(pname)) {
            queryId = "";
            page = cartDao.queryProduct(pname, queryId, currentPage, pageSize);
            if (page.getData() != null) {
                result = new Result<>(20000, page, "查询成功，与" + pname + "相关的产品查询如下");
            } else {
                result = new Result<>(20000, page, errMsg);
            }

        } else if (queryId != null && !"".equals(queryId)) {
            pname = "";
            page = cartDao.queryProduct(pname, queryId, currentPage, pageSize);
            if (page.getData() != null) {
                result = new Result<>(20000, page, "查询成功");
            } else {
                result = new Result<>(20000, page, errMsg);
            }
        } else {
            pname = "";
            queryId = "";
            page = cartDao.queryProduct(pname, queryId, currentPage, pageSize);
            if (page.getData() != null) {
                result = new Result<>(20000, page, "全部商品展示");
            } else {
                result = new Result<>(20000, page, "商品全部售罄");
            }
        }
        return result;
    }

    @Override
    public Result<Object> addProductToCart(Cartitem cartitem, String userId) {
        if (cartitem != null) {
            String pid = cartitem.getPid();
            String pname = cartitem.getPname();
            String pimage = cartitem.getPimage();
            double shop_price = cartitem.getShop_price();
            System.out.println(pid);
            if (pid != null && !"".equals(pid)) {
                int count = cartitem.getCount();
                double subTotal = cartitem.getSubTotal();
                if (cartDao.addProductToCart(userId, pid, pname, pimage , shop_price, count, subTotal)) {
                    result = new Result<>(20000, "添加成功", "PID为" + pid + "的商品已添加入购物车");
                    System.out.println("PID为" + pid + "的商品已添加入购物车");
                } else {
                    result = new Result<>(500, "添加失败", "PID为" + pid + "的商品未能成功添加入购物车");
                    System.out.println("添加失败");
                }
            } else {
                result = new Result<>(400, "添加失败", "非法参数");
            }
        } else {
            result = new Result<>(400, "添加失败", "非法参数");
        }
        return result;
    }

    @Override
    public Result<Object> queryAllCartProduct(String userId) {
        if (userId != null && !"".equals(userId)) {
            Cart cart = cartDao.queryAllCartProduct(userId);
            if (cart != null) {
                result = new Result<>(20000, cart, "查询成功,用户ID为"+userId+"的购物车信息如下");
                System.out.println("购物车信息查询成功");
            } else {
                result = new Result<>(500, null, "查询失败,用户ID为"+userId+"不存在购物车");
                System.out.println("查询失败,服务器内部错误");
            }
        }
        return result;
    }

    @Override
    public Result<Object> deleteCartitemByCartitemId(String cartId, String cartitemId) {
        if (cartitemId != null && !"".equals(cartitemId) && cartId != null && !"".equals(cartId)) {
            boolean delete = cartDao.deleteCartitemByCartitemId(cartId, cartitemId);
            if (delete) {
                result = new Result<>(20000, "删除成功", "购物项编号为"+cartitemId+"的订单已移除购物车");
                System.out.println("删除成功");
            } else {
                result = new Result<>(500, "服务器内部错误", "删除失败");
                System.out.println("删除失败");
            }
        } else {
            result = new Result<>(400, "非法参数", "非法参数");
        }
        return result;
    }

    @Override
    public Result<Object> checkout(String userId, String[] cartitemIds) {
        Result<Object> result;
        if ("[]".equals(Arrays.toString(cartitemIds))) {
            result = new Result<>(400, "非法参数", "未选择下单商品");
            System.out.println("未选择下单商品");
        } else {
            boolean checkout = cartDao.checkout(userId, cartitemIds);
            if (checkout) {
                result= new Result<>(20000, "下单成功", "下单成功");
                System.out.println("下单成功");
            } else {
                result = new Result<>(500, "下单失败", "下单失败");
                System.out.println("下单失败");
            }
        }
        return result;
    }
}
