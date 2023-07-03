package com.fch.servlet;

import com.fch.pojo.Category;
import com.fch.pojo.Product;
import com.fch.service.ProductService;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @packageName com.fch.servlet
 * @ClassName ProductServlet
 * @Description 参数校验以及结果校验，转发页面
 * @Author Fan-CUNH
 * @Date 2023/7/2 9:53
 * @Version 1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@Slf4j
@WebServlet("*.action")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        productService = context.getBean(ProductService.class);

        // 获取请求 URL
        String uri = request.getRequestURI();

        // 获取所有商品信息
        if (uri.endsWith("plist.action")) {
            //0. 调用业务逻辑层
            List<Product> products = productService.getPlist();

            //1. 存入request域
            request.setAttribute("plist", products);
            log.info("查询结果plist:{}", products);

            //2. 转发到页面
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }

        // 删除单个商品
        if (uri.endsWith("deleteById.action")) {
            //0. 获取请求参数
            Integer productId = Integer.valueOf(request.getParameter("productId"));
            log.info("删除单个商品参数：{}", productId);

            //1. 调用业务逻辑层
            productService.deleteById(productId);

            //2. 重定向到获取所有商品接口
            response.sendRedirect("plist.action");
        }

        // 获取所有商品类型
        if (uri.endsWith("getCList.action")) {
            //1. 调用业务逻辑层
            List<Category> categories = productService.getCategoryList();

            //2. 将查询到的商品存入request域中
            request.setAttribute("categories", categories);

            //3. 转发
            request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
        }

        // 修改商品之前的准备操作，获取修改商品的全部信息
        if (uri.endsWith("beforeUpdate.action")) {
            //0. 获取请求参数
            String productId = request.getParameter("productId");

            //1. 调用业务逻辑层
            Product product = productService.selectById(productId);

            //2. 将查询到的商品存入request域中
            request.setAttribute("product", product);

            //3. 重定向
            request.getRequestDispatcher("getCList.action").forward(request, response);
        }

        // 修改商品信息
        if (uri.endsWith("update.action")) {
            //0. 获取参数
            Product product = getProduct(request);
            log.info("修改商品信息参数：{}", product);

            //1. 调用业务逻辑
            productService.update(product);

            //2. 重定向
            response.sendRedirect("plist.action");
        }

        // 添加商品之前
        if (uri.endsWith("beforeAddProduct.action")) {
            //1. 调用业务逻辑层
            List<Category> categories = productService.getCategoryList();

            //2. 将查询到的商品存入request域中
            request.setAttribute("categories", categories);

            //3. 转发
            request.getRequestDispatcher("addProduct.jsp").forward(request, response);
        }

        // 添加商品
        if (uri.endsWith("addProduct.action")) {
            //0. 获取参数
            Product product = getProduct(request);
            log.info("修改商品信息参数：{}", product);

            //1. 调用业务逻辑
            productService.insert(product);

            //2. 重定向
            response.sendRedirect("plist.action");
        }
    }

    private static Product getProduct(HttpServletRequest request) {
        Integer productId;
        if (request.getParameter("productId") != null) {
            productId = Integer.valueOf(request.getParameter("productId"));
        } else {
            productId = null;
        }
        String productName = request.getParameter("productName");
        Double productPrice = Double.valueOf(request.getParameter("productPrice"));
        String categoryId = request.getParameter("categoryId");
        return new Product(productId, productName, productPrice, Integer.valueOf(categoryId), null);
    }
}
