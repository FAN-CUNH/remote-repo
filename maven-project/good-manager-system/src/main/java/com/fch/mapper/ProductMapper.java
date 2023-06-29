package com.fch.mapper;

import com.fch.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @packageName com.fch.mapper
 * @ClassName ProductMapper
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/28 9:19
 * @Version 1.0
 */
public interface ProductMapper {
    List<Product> selectProduct(@Param("pid") String pid, @Param("pname") String pname);

    void deleteProductByPids(List<String> pids);

    void addProduct(@Param("pid") String pid, @Param("pname") String pname, @Param("marketPrice") String marketPrice, @Param("cid") String cid);

    Product getProductByPid(String pid);

    void updateProduct(@Param("pid") String pid, @Param("pname") String pname, @Param("marketPrice") String marketPrice, @Param("cid") String cid);
}
