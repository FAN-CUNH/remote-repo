package com.fch.filter;
/**
 * @packageName com.fch.filter
 * @ClassName BaseFilter
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/2 10:06
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "*.action", initParams = @WebInitParam(name = "encoding", value = "utf-8"))
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

        // 执行此方法放行
        chain.doFilter(req, resp);
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
