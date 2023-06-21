package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @packageName com.servlet
 * @ClassName ForwardAndRedirectServlet
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/1 15:21
 * @Version 1.0
 */
@WebServlet("/forwardAndRedirectServlet")
public class ForwardAndRedirectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取username
        String username = request.getParameter("username");

        // 2.判断username的值
        // 转发
        if ("zhangsan".equals(username)) {
            request.getRequestDispatcher("a.html").forward(request, response);
        }

        // 重定向
        else if ("lisi".equals(username)) {
            response.sendRedirect("b.html");
        }

        // 弹窗后跳转
        else if ("wangwu".equals(username)) {
            response.setCharacterEncoding("gbk");
            response.getWriter().print("<script charset=\"GBK\">alert('你好');window.location='c.html'</script>");
        }

        // 展示一个按钮在浏览器页面 按钮上的值为zhaoliu
        else if ("zhaoliu".equals(username)) {
            response.getWriter().print("<button>"+username+"</button>");
        }
        else {
            response.setCharacterEncoding("gbk");
            response.getWriter().print("你好网页浏览器");
        }
    }
}
