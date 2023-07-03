package com.fch.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.pojo
 * @ClassName Category
 * @Description 商品类别实体类
 * @Author Fan-CUNH
 * @Date 2023/7/2 10:04
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    /**
     * 商品种类Id
     */
    private Integer categoryId;
    /**
     * 商品种类名称
     */
    private String categoryName;
}
