package com.fch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @packageName com.fch.config
 * @ClassName SpringMVCConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/8 19:11
 * @Version 1.0
 */
@Configuration
@EnableWebMvc
@ComponentScan({"com.fch.controller", "com.fch.service", "com.fch.config"})
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

    //全局异常处理器

    //校验器

    //拦截器

}
