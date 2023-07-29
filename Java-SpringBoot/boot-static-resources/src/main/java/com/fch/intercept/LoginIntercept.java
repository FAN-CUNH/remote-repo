package com.fch.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @packageName com.fch.intercept
 * @ClassName LoginIntercept
 * @Description TODO 登录拦截器
 * @Author Fan-CUNH
 * @Date 2023/7/26 9:49
 * @Version 1.0
 */
@Slf4j
public class LoginIntercept implements HandlerInterceptor {
    /**
     * 执行handler之前
     *
     * @param request  请求
     * @param response 响应
     * @param handler  处理器
     * @return true 放行 false 拦截
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle拦截的请求路径是{}", request.getRequestURI());

        // 获取 session
        HttpSession session = request.getSession();

        // 获取当前登录账号人信息
        Object user = session.getAttribute("user");

        // 判断当前登录人是否存在
        if (user == null) {
            // 未登录 -> login.html
            response.sendRedirect("/login.html");
            // 拦截
            return false;
        }
        // 放行
        return true;
    }

    /**
     * 执行handler之前， 返回modelAndView之前
     *
     * @param request      请求
     * @param response     响应
     * @param handler      处理器
     * @param modelAndView 模型与视图
     * @throws Exception 异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle执行{}", modelAndView);
    }

    /**
     * 执行handler之后，返回modelAndView之后
     *
     * @param request  请求
     * @param response 响应
     * @param handler  真正的
     * @param ex       异常
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (ex != null) {
            log.info("afterCompletion执行异常{}", ex.getMessage());
        }
    }
}
