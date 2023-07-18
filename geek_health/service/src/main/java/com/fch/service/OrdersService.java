package com.fch.service;

import com.fch.domain.Member;
import com.fch.result.Result;

import java.util.Map;

/**
 * @packageName com.fch.service
 * @ClassName OrdersService
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/17 20:45
 * @Version 1.0
 */
public interface OrdersService {
    /**
     * @param map 前端请求参数
     * @return 返回预约状态
     */
    Result submit(Map<String, Object> map);

    /**
     * 通过订单id查询订单信息
     *
     * @param id 订单id
     * @return 返回查询到的会员信息
     */
    Map<String, Object> getOrdersById(Integer id);
}
