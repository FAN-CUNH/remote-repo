package com.fch.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @packageName com.fch.config
 * @ClassName ServletConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/22 22:31
 * @Version 1.0
 */
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
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
        return new Class[] {SpringMVCConfig.class, RedisConfig.class};
    }

    /**
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    /**
     * @return 处理乱码
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        return new Filter[] {filter};
    }
}
