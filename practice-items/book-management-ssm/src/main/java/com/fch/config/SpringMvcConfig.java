package com.fch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @packageName com.fch.config
 * @ClassName SpringMvcConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/5 19:32
 * @Version 1.0
 */

@Configuration // SpringMVC配置类
@ComponentScan({"com.fch.controller", "com.fch.config"}) // 扫描controller包,config包
@EnableWebMvc // 开启注解版MVC
public class SpringMvcConfig {
}
