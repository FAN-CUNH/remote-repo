package com.fch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

/**
 * @packageName com.fch.config
 * @ClassName ThymeleafTemplateConfig
 * @Description thymeleaf模板配置类
 * @Author Fan-CUNH
 * @Date 2023/7/16 15:24
 * @Version 1.0
 */
@PropertySource("classpath:thymeleaf.properties")
public class ThymeleafTemplateConfig {
    /**
     * @param springTemplateEngine 模板引擎
     * @return 返回一个thymeleaf视图解析器
     */
    @Bean
    public ViewResolver viewResolverZ(SpringTemplateEngine springTemplateEngine) {
        // thymeleaf视图解析器
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        // 处理乱码
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
        return thymeleafViewResolver;
    }

    /**
     * @param springResourceTemplateResolver spring资源模版引擎
     * @return 模版引擎
     */
    @Bean
    public SpringTemplateEngine springTemplateEngine(SpringResourceTemplateResolver springResourceTemplateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springResourceTemplateResolver);
        return springTemplateEngine;
    }

    /**
     * @return spring资源模版解析器
     */
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setPrefix("/templates/");
        springResourceTemplateResolver.setSuffix(".html");
        springResourceTemplateResolver.setTemplateMode("HTML");
        springResourceTemplateResolver.setCharacterEncoding("UTF-8");
        return springResourceTemplateResolver;
    }
}
