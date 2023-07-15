package com.fch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @packageName com.fch.config
 * @ClassName SpringMVCConfig
 * @Description WebMvcConfigurer 配置spring mvc
 * @Author Fan-CUNH
 * @Date 2023/7/15 15:33
 * @Version 1.0
 */

// 开启注解版Spring MVC
@EnableWebMvc
// 扫描包
@ComponentScan({"com.fch.controller", "com.fch.service"})
public class SpringMVCConfig implements WebMvcConfigurer {
    /**
     * 配置静态资源放行
     *
     * @param configurer 配置
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * 注册启动访问默认页面
     *
     * @param registry 注册
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/pages/login.html");
    }

    /**
     * 开启文件上传  配置多部件解析器
     *
     * @return
     */
    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(104857600);
        multipartResolver.setMaxInMemorySize(4096);
        multipartResolver.setDefaultEncoding("UTF-8");
        return multipartResolver;
    }
}
