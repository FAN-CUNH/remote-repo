package com.fch.servlet;

import com.alibaba.fastjson.JSON;
import com.fch.bean.Orders;
import com.fch.bean.Result;
import com.fch.service.OrderService;
import com.fch.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @packageName com.fch.servlet
 * @ClassName OrderServlet
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/18 16:32
 * @Version 1.0
 */
@WebServlet("*.to")
public class OrderServlet extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求 uri
        String uri = request.getRequestURI();
        System.out.println("订单管理uri = " + uri);

        // queryAllOrder.to 查询所有订单 / 按下单时间查询订单
        if (uri.endsWith("queryAllOrder.to")) {
            // 获取请求参数
            String userId = request.getParameter("userId");
            String startTime = request.getParameter("startTime");
            String endTime = request.getParameter("endTime");
            System.out.println("userId = " + userId);
            System.out.println("startTime = " + startTime);
            System.out.println("endTime = " + endTime);

            // 调用业务逻辑层
            Result<Object> result = orderService.queryAllOrder(userId, startTime, endTime);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // deleteOrderByOid.to 删除单行订单
        else if (uri.endsWith("deleteOrderByOid.to")) {
            // 获取请求参数
            String oid = request.getParameter("oid");
            System.out.println("oid = " + oid);

            // 调用业务逻辑层
            Result<Object> result = orderService.deleteOrderByOid(oid);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // 查询最近下单的前十条订单项
        else if (uri.endsWith("queryOrderitem.to")) {
            // 获取请求参数
            String oid = request.getParameter("oid");
            String currentPage = request.getParameter("currentPage");
            String pageSize = request.getParameter("pageSize");
            String userId = request.getParameter("userId");
            int currentPageInt = 1;
            int pageSizeInt = 10;
            if (currentPage != null) {
                currentPageInt = Integer.parseInt(currentPage);
            }
            if (pageSize != null) {
                pageSizeInt = Integer.parseInt(pageSize);
            }
            System.out.println("oid = " + oid);
            System.out.println("userId = " + userId);
            System.out.println("currentPage = " + currentPageInt);
            System.out.println("pageSize = " + pageSizeInt);

            // 调用业务逻辑层
            Result<Object> result = orderService.queryOrderitem(userId, oid, currentPageInt, pageSizeInt);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // 删除单行订单项
        else if (uri.endsWith("deleteOrderitemByOid.to")) {
            // 获取请求参数
            String oid = request.getParameter("oid");
            String pid = request.getParameter("pid");
            System.out.println("oid = " + oid + "   " +"pid = " + pid);

            // 调用业务逻辑层
            Result<Object> result = orderService.deleteOrderitemByOid(oid, pid);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // 支付
        else if (uri.endsWith("checkPay.to")) {
            // 获取请求参数
            Orders orders = JSON.parseObject(request.getReader().readLine(), Orders.class);
            System.out.println("orders = " + orders);
            // 调用业务逻辑层
            Result<Object> result = orderService.checkPay(orders);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
    }
}
