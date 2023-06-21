package com.servlet;

import com.entity.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @packageName com.servlet
 * @ClassName Login2Servlet
 * @Description 如果userID是没有字母不包含_；密码是纯字母6位，就将该人信息以div的方式展示到页面；否则就弹框提示"信息错误"
 * @Author CunHao Fan
 * @Date 2023/6/1 19:43
 * @Version 1.0
 */
@WebServlet("/login2")
public class Login2Servlet extends HttpServlet {
    DataSource dataSource;
    QueryRunner queryRunner;

    public Login2Servlet() {
        // 实例化数据源
        dataSource = new ComboPooledDataSource("mysql");
        queryRunner = new QueryRunner(dataSource);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取前端页面的值
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        // 2.校验数据

        String regex = "[\\w\\W]*[a-zA-Z]+[\\w\\W]*";
        boolean flag = true;
        if (userId.matches(regex) || userId.contains("_")) {
            // 如果userId包含字母且含有_则将flag的值置位false
            flag = false;
            response.setCharacterEncoding("gbk");
            response.getWriter().print("<div>错误信息：用户Id中不能包含字母和下划线</div>");
        }
        if (password.length() != 6) {
            // 如果密码的长度不为六位则值false
            flag = false;
            response.setCharacterEncoding("gbk");
            response.getWriter().print("<div>错误信息：用户密码的长度必须为6位</div>");
        }


        // 从数据库中获取所有user的全部信息
        String sql = "select * from user;";
        // 执行sql获得结果集
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class));
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        if (user != null) {
            System.out.println(user.getUserId()+ "   "+ user.getPassword());
        }

        if (flag) {
            // 校验成功，将userId和密码打印在页面中
            response.setCharacterEncoding("gbk");
            response.getWriter().print("<div>用户Id：" + userId + "用户密码：" + password + "</div>");
        }
    }
}
