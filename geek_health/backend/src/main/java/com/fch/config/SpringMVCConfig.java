package com.fch.config;

import com.fch.controller.interceptor.BaseInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @packageName com.fch.config
 * @ClassName SpringMVCConfig
 * @Description Spring MVC配置类
 * @Author Fan-CUNH
 * @Date 2023/7/8 19:11
 * @Version 1.0
 */

@EnableWebMvc
@ComponentScan({"com.fch.controller", "com.fch.service"})
public class SpringMVCConfig implements WebMvcConfigurer {
    //对静态资源放行
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //开启文件上传  配置多部件解析器
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(104857600);
        multipartResolver.setMaxInMemorySize(4096);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }

    /**
     * 自动注入拦截器对象
     */
    @Resource
    private BaseInterceptor baseInterceptor;

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截请求路径包含“/books”和“/books/*”的，即拦截以books开头的所有请求
        registry.addInterceptor(baseInterceptor).addPathPatterns("/checkitem","/checkitem/*");
        registry.addInterceptor(baseInterceptor).addPathPatterns("/checkgroup","/checkgroup/*");
        registry.addInterceptor(baseInterceptor).addPathPatterns("/setmeal","/setmeal/*");
    }
}
