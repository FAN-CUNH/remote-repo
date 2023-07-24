package com.fch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @packageName com.fch.config
 * @ClassName SpringMVCConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/22 22:30
 * @Version 1.0
 */
@EnableWebMvc
@ComponentScan({"com.fch"})
public class SpringMVCConfig implements WebMvcConfigurer {
    /**
     * @param configurer 静态资源放行
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
       configurer.enable();
    }
}
