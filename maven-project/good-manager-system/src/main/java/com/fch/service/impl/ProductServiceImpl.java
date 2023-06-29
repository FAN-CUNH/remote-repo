package com.fch.service.impl;

import com.fch.bean.Product;
import com.fch.bean.Result;
import com.fch.mapper.ProductMapper;
import com.fch.service.ProductService;
import com.fch.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @packageName com.fch.service.impl
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/28 9:20
 * @Version 1.0
 */
public class ProductServiceImpl implements ProductService {
    private final SqlSession session = MybatisUtil.getSession();
    private final ProductMapper productMapper = session.getMapper(ProductMapper.class);

    /**
     * 通过pid和pname查询商品  -> 动态查询
     * 1. 什么都不输入时 查询全部商品
     * 2. 条件只输入一个时，按条件查询
     *
     * @param pid   商品id
     * @param pname 商品名称
     * @return 返回查询到的商品集合
     */
    @Override
    public List<Product> selectProduct(String pid, String pname) {
        return productMapper.selectProduct(pid, pname);
    }

    /**
     * 通过pid删除商品
     *
     * @param pids 商品id集合
     */
    @Override
    public void deleteProductByPids(List<String> pids) {
        productMapper.deleteProductByPids(pids);
        session.commit();
    }

    @Override
    public void addProduct(String pid, String pname, String marketPrice, String cid) {
        productMapper.addProduct(pid, pname, marketPrice, cid);
    }

    @Override
    public Product getProductByPid(String pid) {
        return productMapper.getProductByPid(pid);
    }

    @Override
    public void updateProduct(String pid, String pname, String marketPrice, String cid) {
        productMapper.updateProduct(pid, pname, marketPrice, cid);
    }
}
