package com.fch.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @packageName ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/5 19:57
 * @Version 1.0
 */
@WebServlet("*.action")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在线人数 -1
        if (request.getRequestURI().endsWith("removedSession.action")) {
            // 删除会话
            request.getSession().invalidate();
        }

        // 登录
        else if(request.getRequestURI().endsWith("load.action")) {
            // 将登陆的信息保存在 session 域中

            request.getSession().setAttribute("loaded", true);
            String mess = request.getParameter("mess");
            request.getSession().setAttribute("mess", mess);
            // 展示信息
            request.getRequestDispatcher("showMess.jsp").forward(request, response);
        }
        else if(request.getRequestURI().endsWith("show.action")) {
            // 将登陆的信息保存在 session 域中

            String mess = request.getParameter("mess");
            request.getSession().setAttribute("mess", mess);
            // 展示信息
            request.getRequestDispatcher("show.jsp").forward(request, response);
        }
    }
}
