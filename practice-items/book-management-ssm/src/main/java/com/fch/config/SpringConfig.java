package com.fch.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @packageName com.fch.config
 * @ClassName SpringConfig
 * @Description spring配置类
 * @Author Fan-CUNH
 * @Date 2023/7/5 19:15
 * @Version 1.0
 */

@Configuration // 标识此类是个配置类
@ComponentScan("com.fch.service") // 扫描service包
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class, MybatisConfig.class})
@EnableTransactionManagement // 开启事务
public class SpringConfig {
}
