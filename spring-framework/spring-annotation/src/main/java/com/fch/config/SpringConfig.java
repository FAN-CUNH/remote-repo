package com.fch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @packageName com.fch.config
 * @ClassName SpringConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/3 14:49
 * @Version 1.0
 */

@Configuration
@ComponentScan(basePackages = "com.fch.pojo")
public class SpringConfig {
    
}
