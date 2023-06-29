package com.fch.servlet;

import com.fch.service.UserService;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @packageName com.fch.servlet
 * @ClassName UserServlet
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/29 15:12
 * @Version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@WebServlet("*.action")
public class UserServlet extends HttpServlet {
    private UserService userService;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userService.init();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        userService.init();
        System.out.println("UserServlet is init...");
    }
}
