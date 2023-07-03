package com.fch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.pojo
 * @ClassName Product
 * @Description 商品实体类
 * @Author Fan-CUNH
 * @Date 2023/7/2 10:02
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品单价
     */
    private Double productPrice;
    /**
     * 商品种类Id
     */
    private Integer categoryId;

    /**
     * 商品种类实体
     */
    private Category category;
}
