package com.fch.servlet;

import com.fch.bean.Page;
import com.fch.bean.Student;
import com.fch.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @packageName ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/4 16:08
 * @Version 1.0
 */
@WebServlet("*.action")
public class BaseServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取工程路径
        String contextPath = request.getContextPath();
        System.out.println("工程路径：" + contextPath);

        // 2.获取URI
        String uri = request.getRequestURI();

        // 3.处理前端请求
        String load = "load.action";
        String register = "register.action";

        // 登录
        if (uri.endsWith(load)) {
            // 1.获取前端请求数据
            String stuNo = request.getParameter("stuNo");
            String password = request.getParameter("password");
            String remember = request.getParameter("remember");

            // 2.逻辑处理
            Student student = studentService.loadStudent(stuNo, password);

            // 3.响应结果
            if (student == null) {
                // 登录失败，弹窗“登录失败”，返回到 load.jsp
                response.setCharacterEncoding("gbk");
                response.getWriter().print("<script charset = \"GBK\">alert(\"登录失败\");window.location = \"load.jsp\"</script>");
            } else {
                // 2.设置记住学号
                final String on = "on";
                System.out.println("remember的状态： " + remember);
                if (on.equals(remember)) {
                    // 创建 cookie对象保存学号
                    Cookie cookie = new Cookie("stuNo", stuNo);

                    // 设置 cookie 到客户端 --> 服务器端响应数据到客户端
                    response.addCookie(cookie);
                    // 打印 cookie
                    System.out.println("当前cookie：  " + cookie.getName() + "  " + cookie.getValue());
                }
                // 此处不能重定向，否则会导致delCourses.action处request, response失效
                request.getRequestDispatcher("getMess.action").forward(request, response);
            }
        }
        // 获取学生信息
        else if (uri.endsWith("getMess.action")) {
            /*
             *   先传值，在转发
             */
            // 1.请求域传值  分页信息
            int currentPage = 1;
            if (request.getParameter("currentPage") != null) {
                currentPage = Integer.parseInt(request.getParameter("currentPage"));
            }

            int everyPageRow = 3;
            if (request.getParameter("everyPageRow") != null) {
                everyPageRow = Integer.parseInt(request.getParameter("everyPageRow"));
            }
            Page<Map<String, Object>> page = studentService.getPage(currentPage, everyPageRow);

            request.getSession().setAttribute("page",page);

            // 3.登录成功，将request, response转发到showMess.jsp打印学生信息
            request.getRequestDispatcher("showMess.jsp").forward(request, response);
        }
        //
        else if(uri.endsWith("delCourses.action")){
            //删除学生选择课程
            String stuNo = request.getParameter("stuNo");
            String couNo = request.getParameter("couNo");
            studentService.delCourses(stuNo,couNo);

            System.out.println(stuNo+couNo);

            //获取最新数据
            response.sendRedirect("getMess.action");

        }
        // 注册
        else if (uri.endsWith(register)) {
            // 0.获取请求数据
            String stuNo = request.getParameter("stuNo");
            String stuName = request.getParameter("stuName");
            String password = request.getParameter("password");

            // 1.业务处理
            boolean result = studentService.registerStudent(stuNo, stuName, password);

            // 2.根据结果做出响应
            if (result) {
                // 注册成功，跳转到登录界面
                response.setCharacterEncoding("gbk");
                response.getWriter().print("<script charset = \"GBK\">alert(\"注册成功！点击确定跳转到登录界面\");window.location = \"load.jsp\"</script>");
            } else {
                // 注册失败，重新下载本页面
                response.setCharacterEncoding("gbk");
                response.getWriter().print("<script charset = \"GBK\">alert(\"注册失败！点击确定重新注册\");window.location = \"register.jsp\"</script>");
                ;
            }
        }

    }
}
