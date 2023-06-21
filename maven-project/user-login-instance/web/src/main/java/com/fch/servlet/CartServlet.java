package com.fch.servlet;

import com.alibaba.fastjson.JSON;
import com.fch.bean.Cartitem;
import com.fch.bean.Result;
import com.fch.service.CartService;
import com.fch.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @packageName com.fch.servlet
 * @ClassName CartServlet
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/15 10:42
 * @Version 1.0
 */
@WebServlet("*.go")
public class CartServlet extends HttpServlet {
    CartService cartService = new CartServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 获取请求 uri */
        String uri = request.getRequestURI();
        System.out.println("购物车管理uri = " + uri);

        // 商品查询 queryProduct.go
        if (uri.endsWith("queryProduct.go")) {
            //0. 获取请求参数
            String currentPage = request.getParameter("currentPage");
            String pageSize = request.getParameter("pageSize");
            String pname = request.getParameter("pname");
            String queryId = request.getParameter("queryId");
            System.out.println("pname = " + pname);
            System.out.println("queryId = " + queryId);

            int currentPageInt = 1;
            int pageSizeInt = 4;
            if (currentPage != null) {
                currentPageInt = Integer.parseInt(currentPage);
            }
            if (pageSize != null) {
                pageSizeInt = Integer.parseInt(pageSize);
            }

            //1. 调用service层
            Result<Object> result = cartService.queryProduct(pname, queryId, currentPageInt, pageSizeInt);

            //2. 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // addProductToCart.go 添加商品到购物车
        else if (uri.endsWith("addProductToCart.go")) {
            // 获取前端请求参数
            String userId = request.getParameter("userId");
            Cartitem cartitem = JSON.parseObject(request.getReader().readLine(), Cartitem.class);

            // 调用业务逻辑层
            Result<Object> result = cartService.addProductToCart(cartitem, userId);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // queryAllCartProduct.go 查询购物车中的所有商品
        else if (uri.endsWith("queryAllCartProduct.go")) {
            // 获取参数
            String userId = request.getParameter("userId");

            // 调用业务逻辑层
            Result<Object> result = cartService.queryAllCartProduct(userId);

            // 相应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // deleteCartitemByCartitemId.go 通过购物项id删除购物项
        else if (uri.endsWith("deleteCartitemByCartitemId.go")) {
            // 获取参数
            String cartitemId = request.getParameter("cartitemId");
            String cartId = request.getParameter("cartId");

            // 调用业务逻辑层
            Result<Object> result = cartService.deleteCartitemByCartitemId(cartId, cartitemId);

            // 相应数据
            response.getWriter().print(JSON.toJSONString(result));
        }

        // checkout.go
        else if (uri.endsWith("checkout.go")) {
            // 获取参数
            String userId = request.getParameter("userId");
            String[] cartitemIds1 = request.getParameterValues("cartitemIds");
            String[] cartitemIds = (Arrays.toString(cartitemIds1).substring(1,cartitemIds1[0].length()+1).split(","));
            System.out.println(Arrays.toString(cartitemIds));
            System.out.println(cartitemIds.length);

            // 调用业务逻辑层
            Result<Object> result = cartService.checkout(userId, cartitemIds);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
    }
}
