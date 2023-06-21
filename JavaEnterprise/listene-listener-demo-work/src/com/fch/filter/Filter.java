package com.fch.filter;
/**
 * @packageName ${PACKAGE_NAME}
 * @ClassName ${NAME}
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/5 21:02
 * @Version 1.0
 */

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(value = "/*", initParams = @WebInitParam(name = "encoding", value = "utf-8"))
public class Filter implements javax.servlet.Filter {

    /**
     * 编码方式
     */
    String encoding = null;

    /**
     * filter count
     */
    static int count = 1;

    /**
     * filter is destroyed.
     */
    @Override
    public void destroy() {
        System.out.println("filter is destroyed.");
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
         *   需求：
         *       实现过滤"非项目首页"，"非index,jsp"，"非load.action"以及"第一次登录"
         *
         */

        // 0.类型转换
        HttpServletRequest request = (HttpServletRequest) req;

        // 1.获取请求uri中"/"的索引
        int index = request.getRequestURI().lastIndexOf("/");

        // 2.根据 "/" 在uri中的位置确定当前请求的类型
        if (index == request.getRequestURI().length() - 1) {
            // "/" 在请求uri最后 则说明是项目首页
            chain.doFilter(req, resp);
            System.out.println("项目首页 -> 已放行");
        } else {
            // 3.非项目首页， 获取请求名 -> "/" 后的所有字符
            String reqName = request.getRequestURI().substring(index + 1);

            // 4.根据请求名是否是 "index.jsp", "load.action" 放行 以及不是第一次登录的也放行
            if ("index.jsp".equals(reqName) || "load.action".equals(reqName) || "load.jsp".equals(reqName)) {
                System.out.println("请求符合，已放行");
                chain.doFilter(req, resp);

            } else {
                // 5.根据登录信息再次进行过滤，若登录信息中包含 "IGeek" 则拦截；
                String mess = request.getParameter("mess");
                System.out.println("input输入的mess：" + mess);
                System.out.println("是否登录："+request.getSession().getAttribute("loaded"));

                if ("IGeek".equals(mess)) {
                    // 拦截
                    System.out.println("拦截");

                } else {
                    if (request.getSession().getAttribute("loaded") != null) {
                        System.out.println("已登录，放行");
                        chain.doFilter(req, resp);

                    } else {
                        resp.setCharacterEncoding("gbk");
                        resp.getWriter().println("<script>alert('请先登录!');window.location='index.jsp'</script>");
                    }

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
        System.out.println("filter is init.");

        // 获取编码方式
        encoding = config.getInitParameter("encoding");
    }

}
