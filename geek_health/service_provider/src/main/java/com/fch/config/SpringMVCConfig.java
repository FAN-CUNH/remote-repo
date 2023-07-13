package com.fch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @packageName com.fch.config
 * @ClassName SpringMVCConfig
 * @Description MVC 配置类
 * @Author Fan-CUNH
 * @Date 2023/7/8 17:09
 * @Version 1.0
 */

@Configuration
// 开启注解版 MVC
@EnableWebMvc
@ComponentScan("com.fch.config")
public class SpringMVCConfig {
}
