package com.fch.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @packageName com.fch.result
 * @ClassName PageResult
 * @Description 封装分页返回结果
 * @Author Fan-CUNH
 * @Date 2023/7/8 20:24
 * @Version 1.0
 */

@Data
public class PageResult implements Serializable {
    /**
     * 总记录数
     */
    private Long total;

    /**
     * 当前页结果
     */
    private List rows;

    public PageResult() {
    }

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
