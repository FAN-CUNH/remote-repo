package com.fch.controller.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @packageName com.fch.controller.interceptor
 * @ClassName BaseInterceptor
 * @Description 拦截器 进行表现层方法的增强
 * @Author Fan-CUNH
 * @Date 2023/7/6 18:53
 * @Version 1.0
 */
@Slf4j
@Component // 注入IOC容器 此类必须受spring容器管理
public class BaseInterceptor implements HandlerInterceptor {
    /**
     * 前置处理方法 原始方法调用前执行
     *
     * @param request 请求
     * @param response 响应
     * @param handler :被调用的处理器对象，本质上是一个方法对象，对反射中的Method对象进行了再包装
     * @return 返回是否拦截原始方法
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("=========================================== preHandle ===========================================");
        return true;
    }

    /**
     * 后置处理方法 原始方法调用后执行
     *
     * @param request 请求
     * @param response 响应
     * @param handler :被调用的处理器对象，本质上是一个方法对象，对反射中的Method对象进行了再包装
     * @param modelAndView 模型和视图
     * @throws Exception 异常
     */
    /*@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle...");
    }*/

    /**
     * 完成处理方法 原始方法调用完成后执行的内容
     *
     * @param request 请求
     * @param response 响应
     * @param handler :被调用的处理器对象，本质上是一个方法对象，对反射中的Method对象进行了再包装
     * @param ex 异常
     * @throws Exception 异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("=========================================== afterCompletion ===========================================");
    }
}
