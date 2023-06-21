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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

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

    public static final Logger log = Logger.getLogger(Filter.class.getName());

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

        /*
         * 需求: 除了load.jsp请求和load.action请求，其他请求资源访问必须先登录
         *      load.jsp判断user是否能够登录成功，如果可以重定向到showAllProducts.jsp页面
         *      否则弹框提示"load fail" 重定向回去load.jsp重新登录
         */

        // 0.获取request
        HttpServletRequest request = (HttpServletRequest) req;

        // 1.获取请求uri中 "/" 的索引下标
        int index = request.getRequestURI().lastIndexOf("/");

        // 2.根据 "/" 在url中的位置，来确定是否放行
        if (index == request.getRequestURI().length() - 1) {
            // "/" 在url的最后 -> 登录页面 —> 放行
            chain.doFilter(req, resp);

            // 登录页面 -> 放行
            log.info("登录页面 -> 放行");
        } else {
            // 3.获取请求名 -> "/" 后的所有字符. load.jsp,load.action -> 放行
            String reqName = request.getRequestURI().substring(index + 1);

            if ("load.jsp".equals(reqName) || "load.action".equals(reqName) || "getCode.action".equals(reqName) || "checkCodeIsRight.action".equals(reqName)) {
                // 登录页面 和 登录功能接口 —> 放行
                log.info("登录页面 和 登录功能接口 —> 放行");
                chain.doFilter(req, resp);
            } else {
                // 其他资源请求 此项目是展示页面请求，以及资源信息请求

                if (request.getSession().getAttribute("loaded") != null) {
                    // 4.获取登录信息，已登录 —> 放行
                    chain.doFilter(req, resp);
                    log.info("已登录 —> 放行");
                }
            }

        }

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
