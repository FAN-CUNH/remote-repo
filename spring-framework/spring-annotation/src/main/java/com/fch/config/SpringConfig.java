package com.fch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @packageName com.fch.config
 * @ClassName SpringConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 14:49
 * @Version 1.0
 */

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.fch")
public class SpringConfig {

}
