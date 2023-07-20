package com.fch.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;

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
        return new Class[]{
                SpringMVCConfig.class, BackendConsumerConfig.class, RedisConfig.class, SpringSecurityConfig.class
        };
    }

    /**
     * @return 指定DispatchServlet的映射规则， url-pattern
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * @return 注册过滤器
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");

        DelegatingFilterProxy springSecurityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain");
        return new Filter[]{filter, springSecurityFilterChain};
    }
}
