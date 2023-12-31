package com.fch.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @packageName com.fch.config
 * @ClassName ServletConfig
 * @Description Web项目入口配置类
 * @Author Fan-CUNH
 * @Date 2023/7/8 18:51
 * @Version 1.0
 */
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {
                // MVC
                SpringMVCConfig.class,
                // Dubbo 远程调用服务中心
                DubboProviderConfig.class,
                // Mybatis
                MybatisConfig.class,
                // Redis
                RedisConfig.class,
                // Thymeleaf
                ThymeleafTemplateConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        return new Filter[] {filter};
    }
}
