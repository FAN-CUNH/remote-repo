package com.fch.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fch.bean.Category;
import com.fch.bean.Product;
import com.fch.bean.Result;
import com.fch.service.CategoryService;
import com.fch.service.impl.CategoryServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @packageName com.fch.servlet
 * @ClassName CategoryServlet
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/28 19:12
 * @Version 1.0
 */

@Slf4j
@WebServlet("*.do")
public class CategoryServlet extends HttpServlet {
    private final CategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取uri
        String uri = request.getRequestURI();

        // 获取所有商品
        if (uri.endsWith("getAllCategory.do")) {
            //1. 调用service层
            List<Category> list = categoryService.getAllCategory();
            log.info("查询结果：{}", list);

            //2. 响应数据
            request.setAttribute("category", list);
            request.getRequestDispatcher("addProduct.jsp").forward(request,response);
        }
    }
}
