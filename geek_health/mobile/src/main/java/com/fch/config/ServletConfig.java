package com.fch.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @packageName com.fch.config
 * @ClassName ServletConfig
 * @Description Web项目入口配置类
 * @Author Fan-CUNH
 * @Date 2023/7/15 15:49
 * @Version 1.0
 */
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    /**
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMVCConfig.class, RedisConfig.class, MobileConsumerConfig.class};
    }

    /**
     * 路径拦截
     *
     * @return 拦截模版数组
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 处理POST请求乱码
     *
     * @return 过滤器数组
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        return new Filter[] {filter};
    }
}
