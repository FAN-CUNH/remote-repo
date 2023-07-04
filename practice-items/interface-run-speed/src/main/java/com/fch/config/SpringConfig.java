package com.fch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

/**
 * @packageName com.fch.config
 * @ClassName SpringConfig
 * @Description Spring配置类
 * @Author Fan-CUNH
 * @Date 2023/7/3 20:11
 * @Version 1.0
 */

@Configuration
@EnableAspectJAutoProxy
@PropertySource("classpath:jdbc.properties")
@ComponentScan(basePackages = "com.fch")
public class SpringConfig {
}
