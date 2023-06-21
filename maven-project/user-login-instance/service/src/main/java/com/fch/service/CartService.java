package com.fch.service;

import com.fch.bean.Cartitem;
import com.fch.bean.Result;

/**
 * @packageName com.fch.service
 * @ClassName CartService
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/15 10:43
 * @Version 1.0
 */
public interface CartService {

    Result<Object> queryProduct(String pname, String queryId, int currentPage, int pageSize);

    Result<Object> addProductToCart(Cartitem cartitem, String userId);

    Result<Object> queryAllCartProduct(String userId);

    Result<Object> deleteCartitemByCartitemId(String cartId, String cartitemId);

    Result<Object> checkout(String userId, String[] cartitemIds);
}
