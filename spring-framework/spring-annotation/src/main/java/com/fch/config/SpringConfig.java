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

@Configuration // @Configuration表示此类是配置类 用来替换 spring-config.xml 文件
@EnableAspectJAutoProxy // @EnableAspectJAutoProxy开启注解版AOP功能
@ComponentScan(basePackages = "com.fch") // @ComponentScan主要就是定义扫描的路径从中找出标识了需要装配的类自动装配到spring的bean容器中
public class SpringConfig {

}
