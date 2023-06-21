package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @packageName com.servlet;
 * @ClassName LoginServlet
 * @Description 登录服务器
 * @Author CunHao Fan
 * @Date 2023/6/1 10:33
 * @Version 1.0
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String[] hobby = request.getParameterValues("hobby");
        boolean flag = true;
        if ("zhangsan".equals(username)) {
            flag = false;
        }
        if (password.length() != 6) {
            flag = false;
        }
        if ("1".equals(sex)) {
            flag = false;
        }
        for (String s : hobby) {
            if ("跑步1".equals(s)) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            System.out.println("sex = " + sex);
            System.out.println("hobby = " + Arrays.toString(hobby));
        } else {
            System.out.println("非法输入！");
        }
    }
}
