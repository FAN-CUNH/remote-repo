package com.fch.comfig;

import com.fch.domain.Pet;
import com.fch.intercept.LoginIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @packageName com.fch.comfig
 * @ClassName IConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/25 17:36
 * @Version 1.0
 */
@Configuration
public class IConfig {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            /**
             * 自定义的拦截器
             *
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginIntercept())
                        // 配置拦截规则
                        .addPathPatterns("/index.html", "/form_layouts.html")
                        // 配置放行规则
                        .excludePathPatterns("/css/**", "/fonts/**", "/image/**", "/js/**", "/login.html", "/login", "/logout");
            }

            /**
             * 自定义的类型转换器
             *
             * @param registry 注册
             */
            @Override
            public void addFormatters(FormatterRegistry registry) {
                // String —> Date
                Converter<String, Date> stringToDateConverter = new Converter<String, Date>() {
                    /**
                     * 类型转换器
                     * String -> Date 字符串转日期 作用等同于在Person类中的birthday属性上加@DateTimeFormat(pattern = "yyyy-MM-dd")
                     * @param source String
                     * @return Date
                     */
                    @Override
                    public Date convert(String source) {
                        if (source.length() > 0) {
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            Date date;
                            try {
                                date = format.parse(source);
                            } catch (ParseException e) {
                                throw new RuntimeException(e);
                            }
                            return date;
                        }
                        return null;
                    }
                };
                // 注册
                registry.addConverter(stringToDateConverter);

                Converter<String, Pet> stringToPetConverter = new Converter<String, Pet>() {
                    /**
                     * 类型转换器
                     * String -> Pet 字符串转宠物
                     *
                     * @param source String
                     * @return Pet
                     */
                    @Override
                    public Pet convert(String source) {
                        if (StringUtils.hasLength(source)) {
                            String[] split = source.split("#");
                            return new Pet(split[0], Integer.parseInt(split[1]));
                        }
                        return null;
                    }
                };
                // 注册
                registry.addConverter(stringToPetConverter);
            }

            /**
             * 自定义的资源处理器
             *
             * @param registry
             */
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry
                        // 访问路径
                        .addResourceHandler("/temp/**")
                        // 资源存放的本地路径
                        .addResourceLocations("E:\\Java\\10.SpringBoot\\temp\\" );
            }
        };
    }
}
