package com.fch.service;

import com.fch.bean.Product;

import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName ProductService
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/28 9:20
 * @Version 1.0
 */
public interface ProductService {
    List<Product> selectProduct(String pid, String pname);

    void deleteProductByPids(List<String> pids);

    void addProduct(String pid, String pname, String marketPrice, String cid);

    Product getProductByPid(String pid);

    void updateProduct(String pid, String pname, String marketPrice, String cid);
}
