package com.fch.servlet;

import com.alibaba.fastjson.JSON;
import com.fch.bean.Page;
import com.fch.bean.Product;
import com.fch.bean.Result;
import com.fch.service.ProductService;
import com.fch.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @packageName com.fch.servlet
 * @ClassName ProductServlet
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/13 18:08
 * @Version 1.0
 */
@WebServlet("*.do")
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求uri
        String uri = request.getRequestURI();
        System.out.println("商品管理请求uri = " + uri);

        // 分页获取所有商品信息
        if (uri.endsWith("getAllProductMess.do")) {
            // 获取分页参数
            String currentPage = request.getParameter("currentPage");
            String pageSize = request.getParameter("pageSize");
            String cid = request.getParameter("cid");
            int currentPageInt = 1;
            int pageSizeInt = 6;
            if (currentPage != null) {
                currentPageInt = Integer.parseInt(currentPage);
            }
            if (pageSize != null) {
                pageSizeInt = Integer.parseInt(pageSize);
            }
            Result<Object> result;

            if (cid != null  && !"".equals(cid)) {
                result = productService.queryProductByCategory(cid, currentPageInt, pageSizeInt);
            } else {
                // 调用service层获取分页对象
                Page<Product> page = productService.getAllProductMess(currentPageInt, pageSizeInt);
                result = new Result<>(20000, page, "正常");
            }

            // 声明一个Result类型对象
            response.getWriter().print(JSON.toJSONString(result));

        }
        // 更新商品信息
        else if (uri.endsWith("updateProductById.do")) {
            // 获取请求参数
            Product product = JSON.parseObject(request.getReader().readLine(), Product.class);
            System.out.println("product = " + product);

            //
            Result<Object> result = productService.updateProduct(product);

            response.getWriter().print(JSON.toJSONString(result));
        }

        // 获取所有商品类别信息
        else if (uri.endsWith("queryAllProductCategory.do")) {

            // 调用业务逻辑层
            Result<Object> result = productService.queryAllProductCategory();

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }

        // 添加商品
        else if (uri.endsWith("addProduct.do")) {
            // 获取请求体
            Product product = JSON.parseObject(request.getReader().readLine(), Product.class);
            System.out.println("product = " + product);

            // 调用业务逻辑层
            Result<Object> result = productService.addProduct(product);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }

        // 按类别查询商品
        else if (uri.endsWith("queryProductByCategory.do")) {
            // 获取请求参数
            String cid = request.getParameter("cid");
            String currentPage = request.getParameter("currentPage");
            String pageSize = request.getParameter("pageSize");
            int currentPageInt = 1;
            int pageSizeInt = 6;
            if (currentPage != null) {
                currentPageInt = Integer.parseInt(currentPage);
            }
            if (pageSize != null) {
                pageSizeInt = Integer.parseInt(pageSize);
            }

            // 调用业务逻辑层
            Result<Object> result = productService.queryProductByCategory(cid, currentPageInt, pageSizeInt);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }

        // 删除单个商品
        else if (uri.endsWith("deleteProductById.do")) {
            // 获取请求参数
            String pid = request.getParameter("pid");
            System.out.println("pid = " + pid);

            // 调用业务逻辑层
            Result<Object> result = productService.deleteProductById(pid);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
    }
}
