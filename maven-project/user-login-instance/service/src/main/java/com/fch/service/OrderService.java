package com.fch.service;

import com.fch.bean.Orders;
import com.fch.bean.Result;

/**
 * @packageName com.fch.service
 * @ClassName OrderService
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/18 16:41
 * @Version 1.0
 */
public interface OrderService {
    Result<Object> queryAllOrder(String userId, String startTime, String endTime);

    Result<Object> deleteOrderByOid(String oid);

    Result<Object> queryOrderitem(String userId, String oid, int currentPage, int pageSize);

    Result<Object> deleteOrderitemByOid(String oid, String pid);

    Result<Object> checkPay(Orders orders);
}
