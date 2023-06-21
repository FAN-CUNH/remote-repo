package com.fch.filter;
/**
 * @packageName com.fch.filter
 * @ClassName BaseFilter
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/11 16:03
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/*", initParams = @WebInitParam(name = "encoding", value = "utf-8"))
public class BaseFilter implements Filter {
    /**
     * 编码方式
     */
    String encoding = null;

    /**
     * filter times count
     */
    static int count = 1;

    /**
     * filter is destroyed.
     */
    @Override
    public void destroy() {
    }

    /**
     * Filter is running.
     *
     * @param req 请求
     * @param resp 响应
     * @param chain 链
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("第" + count++ + "次" + "filter is running.");
        // 功能增强,防止乱码
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
        resp.setContentType("application/json");

        // 支持跨域访问
        HttpServletResponse response = (HttpServletResponse) resp;
        /* 允许跨域的主机地址 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");

        chain.doFilter(req, resp);


        /*//0. 获取请求 request
        HttpServletRequest request = (HttpServletRequest) req;

        //1. 获取请求uri中 "/" 的索引下标, 获取请求uri
        String uri = request.getRequestURI();
        int index = request.getRequestURI().lastIndexOf("/");

        //2. 根据 "/" 在uri中的位置，确定请求类型
        if (index == uri.length() - 1) {
            // 项目首页 -> 放行
            chain.doFilter(req, resp);
            System.out.println("项目首页 -> 放行");
        } else {
            // 获取请求名 uri "/" 之后的字段即为请求名
            String reqName = request.getRequestURI().substring(index + 1);

            if ("login.jsp".equals(reqName) || "login.action".equals(reqName) || "getAllUserMess.action".equals(reqName)) {
                // 登录请求 -> 放行
                System.out.println("登录请求 -> 放行");
                chain.doFilter(req, resp);
            } else {
                if (request.getSession().getAttribute("loaded") != null) {
                    // 已登录 -> 放行
                    System.out.println("已登录 -> 放行");
                    chain.doFilter(req, resp);
                }
            }
        }*/


    }

    /**
     * filter is init.
     *
     * @param config 配置信息
     * @throws ServletException Servlet异常
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        // 获取编码方式
        encoding = config.getInitParameter("encoding");
    }

}
