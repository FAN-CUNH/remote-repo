package com.fch.dao;

import com.fch.bean.Orderitem;
import com.fch.bean.Orders;
import com.fch.bean.Page;

import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.dao
 * @ClassName OrderDao
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/18 16:41
 * @Version 1.0
 */
public interface OrderDao {
    List<Orders> queryAllOrder(String userId, String startTime, String endTime);

    boolean deleteOrderByOid(String oid);

    Page<Map<String, Object>> queryOrderitem(String userId, String oid, int currentPage, int pageSize);

    boolean deleteOrderitemByOid(String oid, String pid);

    boolean checkPay(Orders orders);
}
