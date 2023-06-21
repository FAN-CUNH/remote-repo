package com.fch.servlet;

import com.alibaba.fastjson.JSON;
import com.fch.bean.Course;
import com.fch.bean.Page;
import com.fch.bean.Result;
import com.fch.bean.User;
import com.fch.service.UserService;
import com.fch.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @packageName com.fch.servlet
 * @ClassName UserServlet
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/11 16:09
 * @Version 1.0
 */
@javax.servlet.annotation.WebServlet("*.action")
public class UserServlet extends HttpServlet {

    /**
     * 调用业务逻辑层 userService
     */
    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取前端请求uri, 根据请求url的不同, 执行不同的操作
        String uri = request.getRequestURI();

        // 接口路径
        String login = "login.action";
        String showProductMess = "showProductMess.action";
        // login.action -> 登录请求
        if (uri.endsWith(login)) {
            String mess = request.getReader().readLine();
            System.out.println("mess = " + mess);
            User user = JSON.parseObject(mess, User.class);
            System.out.println("user = " + user);
            String userId = user.getUserId();
            System.out.println("userId = " + userId);
            String password = user.getPassword();
            System.out.println("password = " + password);

            User logined = userService.login(userId, password);
            System.out.println("logined = " + logined);
            Result<Object> result;

            if (logined != null) {
                result = new Result<>(20000, logined, "正常");
                System.out.println("登录成功");
                response.getWriter().print(JSON.toJSONString(result));
            } else {
                result = new Result<>(400, "error", "异常");
                response.getWriter().print(JSON.toJSONString(result));
                System.out.println("登录失败");
            }
            /* *//*
             * 登录：
             *       0. 获取前端请求参数 -> userId, password
             *       1. 根据参数，调用userService
             *       2. 返回值不为Null -> 登录成功, 将登录人信息添加到session域中，否则登录失败，弹窗提示登录失败，并且保持在login.jsp页面
             *//*
            String userId = request.getParameter("userId");
            String password = request.getParameter("password");
            System.out.println("userId = " + userId);
            System.out.println("password = " + password);

            User loadUser = userService.login(userId, password);
            System.out.println("user = " + loadUser);

            // 创建一个 session 属性, 引用名为 “logined”, 调用setAttribute 将 loaded : user 存入域中
            String loaded = "loaded";
            if (loadUser != null) {
                // 登陆成功
                request.getSession().setAttribute(loaded,loadUser);
                // 跳转到 showProductMess.jsp
                request.getRequestDispatcher("showProductMess.jsp").forward(request, response);
            } else {
                // 登录失败
                response.getWriter().println("<script>alert(\"登录失败\") window.location(\"login.jsp\")</script>");
            }*/
        }

        else if (uri.endsWith("getAllUserMess.action")) {
            String currentPage = request.getParameter("currentPage");
            String pageSize = request.getParameter("pageSize");
            int currentPageInt = 1;
            int pageSizeInt = 3;
            if(currentPage != null){
                //分页过来：1 点击当前页码   2 点击上一页  3 点击下一页
                currentPageInt = Integer.parseInt(currentPage);
            }
            if(pageSize != null){
                //分页过来：1 点击当前页码   2 点击上一页  3 点击下一页
                pageSizeInt = Integer.parseInt(pageSize);
            }
            Page<User> page = userService.getAllUserMess(currentPageInt, pageSizeInt);
            Result<Object> result = new Result<>(20000, page, "正常");
            response.getWriter().print(JSON.toJSONString(result));
        }

        else if (uri.endsWith("deleteUserById.action")) {
            // 获取请求参数 stuNo
            String userId = request.getParameter("userId");
            System.out.println("userId = " + userId);
            boolean code = userService.deleteUserById(userId);
            if (code) {
                Result<Object> result = new Result<>(20000, code, "删除成功");
                response.getWriter().print(JSON.toJSONString(result));
            } else {
                Result<Object> result = new Result<>(400, code, "删除失败");
                response.getWriter().print(JSON.toJSONString(result));
            }
        }

        else if (uri.endsWith("updateUserById.action")) {
            // 获取请求体
            User user = JSON.parseObject(request.getReader().readLine(), User.class);
            System.out.println("更新对象user = " + user);
            boolean update = userService.updateUserById(user.getUserId(), user.getPassword(), user.getUserName(), user.getName(), user.getEmail(), user.getTelephone(), user.getSex());
            if (update) {
                Result<Object> result = new Result<>(20000, update, "更新成功");
                response.getWriter().print(JSON.toJSONString(result));
            } else {
                Result<Object> result = new Result<>(400, update, "更新失败");
                response.getWriter().print(JSON.toJSONString(result));
            }
        }

        else if (uri.endsWith("addUser.action")) {
            String userId = request.getParameter("userId");
            String password = request.getParameter("password");
            String userName = request.getParameter("userName");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String sex = request.getParameter("sex");
            System.out.println("userId = " + userId);
            System.out.println("userName = " + userName);
            System.out.println("name = " + name);
            System.out.println("email = " + email);
            System.out.println("telephone = " + telephone);
            System.out.println("sex = " + sex);

            boolean update = userService.addUser(userId,password, userName, name, email, telephone, sex);
            if (update) {
                Result<Object> result = new Result<>(20000, update, "更新成功");
                response.getWriter().print(JSON.toJSONString(result));
            } else {
                Result<Object> result = new Result<>(400, update, "更新失败");
                response.getWriter().print(JSON.toJSONString(result));
            }
        }
        // 获取所有学生信息和课程信息 getAllStudentMessAndCourseMess.action
        else if (uri.endsWith("getAllStudentMessAndCourseMess.action")) {
            // 获取请求参数   初始加载 分页
            String currentPage = request.getParameter("currentPage");
            String pageSize = request.getParameter("pageSize");

            // 调用业务逻辑层
            Result<Object> result = userService.getAllStudentMessAndCourseMess(currentPage, pageSize);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // 获取所有课程信息
        else if (uri.endsWith("getCourseMess.action")) {
            // 获取请求参数
            String stuNo = request.getParameter("stuNo");

            // 调用业务逻辑层
            Result<Object> result = userService.getCourseMess(stuNo);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // 添加课程
        else if (uri.endsWith("addCourse.action")) {
            // 获取请求参数
            String couNo = request.getParameter("couNo");
            String stuNo = request.getParameter("stuNo");
            System.out.println("couNo = " + couNo);
            System.out.println("stuNo = " + stuNo);

            // 调用业务逻辑层
            Result<Object> result = userService.addCourse(couNo, stuNo);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // 删除课程
        else if (uri.endsWith("deleteCourse.action")) {
            // 获取请求参数
            String couNo = request.getParameter("couNo");
            String stuNo = request.getParameter("stuNo");
            System.out.println("couNo = " + couNo);
            System.out.println("stuNo = " + stuNo);

            // 调用业务逻辑层
            Result<Object> result = userService.deleteCourse(couNo, stuNo);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }
        // 删除学生
        else if (uri.endsWith("deleteStudent.action")) {
            // 获取请求参数
            String stuNo = request.getParameter("stuNo");

            // 调用业务逻辑层
            Result<Object> result = userService.deleteStudent(stuNo);

            // 响应数据
            response.getWriter().print(JSON.toJSONString(result));
        }

    }
}
