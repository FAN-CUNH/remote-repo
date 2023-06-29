package com.fch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.bean
 * @ClassName Product
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/28 9:16
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private String pid;
    private String pname;
    private double marketPrice;
    private double shopPrice;
    private String pimage;
    private java.sql.Date pdate;
    private long isHot;
    private String cid;
    private Category category;

}
