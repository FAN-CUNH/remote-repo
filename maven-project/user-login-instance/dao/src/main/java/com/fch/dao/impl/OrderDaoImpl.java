package com.fch.dao.impl;

import com.fch.BaseUtil;
import com.fch.bean.Orders;
import com.fch.bean.Page;
import com.fch.dao.OrderDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.dao.impl
 * @ClassName OrderDaoImpl
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/18 16:41
 * @Version 1.0
 */
public class OrderDaoImpl implements OrderDao {
    QueryRunner queryRunner = new QueryRunner();
    Connection conn = BaseUtil.dateBaseUtil();

    @Override
    public List<Orders> queryAllOrder(String userId, String startTime, String endTime) {
        //0. 编写查询所有订单按时间排序取前六条
        StringBuilder sql = new StringBuilder("select * from orders where userId = " + userId);

        if (startTime != null && endTime != null) {
            sql.append(" and ordertime between '").append(startTime).append("' and '").append(endTime).append("'");
        }

        sql.append(" order by ordertime desc limit 0, 6");

        System.out.println("sql = " + sql);

        //1. 执行sql
        List<Orders> orders;
        try {
            orders = queryRunner.query(conn, sql.toString(), new BeanListHandler<>(Orders.class));
            System.out.println("orders = " + orders);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //2. 响应数据
        return orders;
    }

    @Override
    public boolean deleteOrderByOid(String oid) {
        //1. 删除订单项
        String sql0 = String.format("delete from orderitem where oid = '%s'", oid);
        System.out.println("删除订单项sql0 = " + sql0);
        try {
            queryRunner.update(conn, sql0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //2. 编写删除订单sql
        String sql1 = String.format("delete from orders where oid = '%s'", oid);
        System.out.println("编写删除订单sql = " + sql1);

        //3. 执行sql
        int deleted;
        try {
            deleted = queryRunner.update(conn, sql1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //4. 相应数据
        return deleted > 0;
    }

    @Override
    public Page<Map<String, Object>> queryOrderitem(String userId, String oid, int currentPage, int pageSize) {
        //0. 编写查询订单项动态sql
        StringBuilder sql = new StringBuilder("select * from orderitem\n" +
                "    left join product on product.pid = orderitem.pid\n" +
                "    left join orders o on orderitem.oid = o.oid\n" +
                "    left join category c on product.cid = c.cid\n" +
                "    left join user u on o.userId = u.userId");

        //1. 查询记录数动态sql1
        StringBuilder sql1 = new StringBuilder("select count(0) from orderitem");


        if (oid != null && !"".equals(oid)) {
            sql.append(" where o.oid = '").append(oid).append("'");
            sql1.append(" where oid = '").append(oid).append("'");
        }

        sql.append(" order by ordertime desc limit ").append((currentPage - 1) * pageSize).append(",").append(pageSize);
        System.out.println("sql = " + sql);
        System.out.println("sql1 = " + sql1);

        //1. 执行sql
        List<Map<String, Object>> orderitems;
        long count;
        try {
            orderitems = queryRunner.query(conn, sql.toString(), new MapListHandler());
            count = (long) queryRunner.query(conn, sql1.toString(), new ScalarHandler());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("count = " + count);

        return new Page<>(currentPage, pageSize, (int) count, orderitems);
    }

    @Override
    public boolean deleteOrderitemByOid(String oid, String pid) {
        //0. 编写删除订单项sql
        String sql = String.format("delete from orderitem where oid = '%s' and pid = %s", oid, pid);
        System.out.println("编写删除订单项sql = " + sql);

        //1. 执行sql
        int delete;
        try {
            delete = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return delete > 0;
    }

    @Override
    public boolean checkPay(Orders orders) {
        //0. 编写支付订单sql
        String sql = String.format("update orders set name = '%s', telephone = %s, address = '%s', state = %s where oid = '%s'",
                orders.getName(), orders.getTelephone(), orders.getAddress(), 1, orders.getOid());
        System.out.println("编写支付订单sql = " + sql);

        //1. 执行sql
        int pay;
        try {
            pay = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //2. 响应数据
        return pay > 0;
    }
}
