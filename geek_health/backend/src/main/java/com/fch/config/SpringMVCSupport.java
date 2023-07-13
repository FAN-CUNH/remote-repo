package com.fch.config;

import com.fch.controller.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @packageName com.fch.config
 * @ClassName SpringMVCSupport
 * @Description 静态资源放行、拦截器
 * @Author Fan-CUNH
 * @Date 2023/7/6 13:57
 * @Version 1.0
 */

@Configuration
public class SpringMVCSupport extends WebMvcConfigurationSupport {

    /**
     * 自动注入拦截器对象
     */
    @Resource
    private BaseInterceptor baseInterceptor;
    /**
     * 静态资源放行
     *
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        // 拦截请求路径包含“/books”和“/books/*”的，即拦截以books开头的所有请求
        registry.addInterceptor(baseInterceptor).addPathPatterns("/*");
    }
}
