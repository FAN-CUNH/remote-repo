package com.fch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @packageName com.fch.dto
 * @ClassName PageDTO
 * @Description 接受前端的查询分页列表的请求参数
 * @Author Fan-CUNH
 * @Date 2023/7/8 20:26
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO implements Serializable {
    /**
     * 当前页码
     */
    private Integer currentPage;

    /**
     * 每页记录数
     */
    private Integer pageSize;

    /**
     * 查询条件
     */
    private String queryString;
}
