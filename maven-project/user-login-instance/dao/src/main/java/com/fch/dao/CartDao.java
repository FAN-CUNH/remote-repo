package com.fch.dao;

import com.fch.bean.Cart;
import com.fch.bean.Page;
import com.fch.bean.Product;

import java.util.List;

/**
 * @packageName com.fch.dao
 * @ClassName CartDao
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/15 10:44
 * @Version 1.0
 */
public interface CartDao {
    Page<Product> queryProduct(String pname, String queryId, int currentPage, int pageSize);

    boolean addProductToCart(String userId, String pid, String pname, String pimage, double shop_price,  int count, double subTotal);

    Cart queryAllCartProduct(String userId);

    boolean deleteCartitemByCartitemId(String cartId, String cartitemId);

    boolean checkout(String userId, String[] cartitemIds);
}
