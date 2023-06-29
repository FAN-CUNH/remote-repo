package com.fch.filter;
/**
 * @packageName ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/6 14:17
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(value = "/*", initParams = @WebInitParam(name = "encoding", value = "utf-8"))
public class Filter implements javax.servlet.Filter {
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
     * @param req   请求
     * @param resp  响应
     * @param chain 链
     * @throws ServletException Servlet异常
     * @throws IOException      IO异常
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("第" + count++ + "次" + "filter is running.");
        // 功能增强,防止乱码
        req.setCharacterEncoding(encoding);
        resp.setCharacterEncoding(encoding);
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
