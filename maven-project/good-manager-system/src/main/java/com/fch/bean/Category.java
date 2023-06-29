package com.fch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.bean
 * @ClassName Category
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/28 9:18
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private String cid;
    private String cname;
}
