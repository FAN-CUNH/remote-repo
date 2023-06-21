package com.fch.service.impl;

import com.fch.bean.Orderitem;
import com.fch.bean.Orders;
import com.fch.bean.Page;
import com.fch.bean.Result;
import com.fch.dao.OrderDao;
import com.fch.dao.impl.OrderDaoImpl;
import com.fch.service.OrderService;

import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.service.impl
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/18 16:41
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {
    /**
     * 响应体
     */
    Result<Object> result;
    OrderDao orderDao = new OrderDaoImpl();

    List<Orders> orders;

    @Override
    public Result<Object> queryAllOrder(String userId, String startTime, String endTime) {
        if (userId != null) {
            if (startTime == null && endTime == null) {
                // 查询全部订单
                orders = orderDao.queryAllOrder(userId, null, null);
                if (orders != null && orders.size() > 0) {
                    result = new Result<>(20000, orders, "查询成功，" + userId + "用户的订单如下");
                } else {
                    result = new Result<>(400, orders, "当前用户未下单");
                }
            } else {
                // 按时间查询订单、
                orders = orderDao.queryAllOrder(userId, startTime, endTime);
                if (orders != null && orders.size() > 0) {
                    result = new Result<>(20000, orders, "查询成功，" + userId + "用户该时间段的订单如下");
                } else {
                    result = new Result<>(400, orders, "当前用户此时间段内未下单");
                }
            }
        } else {
            result = new Result<>(400, null, "非法参数");
        }
        return result;
    }

    @Override
    public Result<Object> deleteOrderByOid(String oid) {
        // 逻辑处理
        if (oid != null && !"".equals(oid)) {
            boolean delete = orderDao.deleteOrderByOid(oid);
            if (delete) {
                result = new Result<>(20000, delete, "订单" + oid + "删除成功");
                System.out.println("删除成功");
            } else {
                result = new Result<>(400, delete, "订单" + oid + "删除失败");
                System.out.println("删除失败");
            }
        } else {
            result = new Result<>(400, false, "非法参数");
            System.out.println("删除失败");
        }
        return result;
    }

    @Override
    public Result<Object> queryOrderitem(String userId, String oid, int currentPage, int pageSize) {
        Page<Map<String, Object>> data;
        // 最近下单的前第十条订单项
        if (oid == null || "".equals(oid)) {
            data = orderDao.queryOrderitem(userId, oid, currentPage, pageSize);
            if (data != null) {
                if (data.getData().size() > 0) {
                    result = new Result<>(20000, data, "最近下单的前10条订单项信息如下");
                } else {
                    result = new Result<>(500, data, "无订单项信息");
                }
            } else {
                result = new Result<>(500, data, "无订单项信息");
            }
        }
        // oid订单的所有订单项
        else {
            data = orderDao.queryOrderitem(userId, oid, currentPage, pageSize);
            result = new Result<>(20000, data, oid + "订单的所有订单项信息如下");
        }
        return result;
    }

    @Override
    public Result<Object> deleteOrderitemByOid(String oid, String pid) {
        // 判断参数
        if (oid != null && pid != null) {
            boolean delete = orderDao.deleteOrderitemByOid(oid, pid);
            if (delete) {
                result = new Result<>(20000, delete, "订单项删除成功");
            } else {
                result = new Result<>(400, delete, "订单项删除失败");
            }
        } else {
            result = new Result<>(400, null, "非法参数");
        }
        return result;
    }

    @Override
    public Result<Object> checkPay(Orders orders) {
        // 判断参数
        if (orders != null) {
            boolean pay = orderDao.checkPay(orders);
            if (pay) {
                result = new Result<>(20000, true, orders.getOid() + "订单已支付");
                System.out.println("支付成功");
            } else {
                result = new Result<>(400, false, orders.getOid() + "订单支付失败");
                System.out.println("支付失败");
            }
        } else {
            result = new Result<>(500, false, "非法参数");
            System.out.println("支付失败");
        }
        return result;
    }
}
