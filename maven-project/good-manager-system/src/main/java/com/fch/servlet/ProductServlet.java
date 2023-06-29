package com.fch.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fch.bean.Category;
import com.fch.bean.Product;
import com.fch.bean.Result;
import com.fch.service.CategoryService;
import com.fch.service.ProductService;
import com.fch.service.impl.CategoryServiceImpl;
import com.fch.service.impl.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @packageName com.fch.servlet
 * @ClassName ProductServlet
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/28 9:21
 * @Version 1.0
 */
@Slf4j
@WebServlet("*.action")
public class ProductServlet extends HttpServlet {

    private static final ProductService productService = new ProductServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取uri
        String uri = request.getRequestURI();

        // 获取所有商品
        if (uri.endsWith("selectProduct.action")) {
            //0. 获取请求参数
            String pname = request.getParameter("pname");
            String pid = request.getParameter("pid");
            log.info("获取所有商品参数：{},{}", pid, pname);

            //1. 调用service层
            List<Product> list = productService.selectProduct(pid, pname);
            Result result = Result.success(list);
            log.info("查询结果：{}", list);

            //2. 响应数据
            response.getWriter().print(JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect));
        }

        // 删除商品
        else if (uri.endsWith("deleteProduct.action")) {
            //0. 获取参数
            List<String> pids = Arrays.asList(request.getParameterValues("pid"));
            log.info("删除商品参数：{}", pids);

            //1. 调用service层
            productService.deleteProductByPids(pids);

            //2. 响应数据
            response.getWriter().print(JSON.toJSONString(Result.success()));
        }

        // 添加商品
        else if (uri.endsWith("addProduct.action")) {
            //0. 获取参数
            String pid = request.getParameter("pid");
            String pname = request.getParameter("pname");
            String marketPrice = request.getParameter("marketPrice");
            String cid = request.getParameter("cid");
            log.info("添加商品参数：{}, {}, {}, {}", pid, pname, marketPrice, cid);

            //1. 调用service层
            productService.addProduct(pid, pname, marketPrice, cid);

            //2. 响应数据
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        // 获取单个商品信息
        else if (uri.endsWith("getProductByPid.action")) {
            // 获取参数
            String pid = request.getParameter("pid");
            log.info("获取单个商品信息参数：{}", pid);

            //
            Product product = productService.getProductByPid(pid);
            request.setAttribute("product", product);
            CategoryService categoryService = new CategoryServiceImpl();
            List<Category> category = categoryService.getAllCategory();
            request.setAttribute("category", category);

            //
            request.getRequestDispatcher("updateProduct.jsp").forward(request, response);
        }

        // 更新商品
        else if (uri.endsWith("updateProduct.action")) {
            // 获取参数
            String pid = request.getParameter("pid");
            String pname = request.getParameter("pname");
            String marketPrice = request.getParameter("marketPrice");
            String cid = request.getParameter("cid");
            log.info("添加商品参数：{}, {}, {}, {}", pid, pname, marketPrice, cid);

            // 调用业务逻辑层
            productService.updateProduct(pid, pname, marketPrice, cid);

            // 跳转页面
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}
