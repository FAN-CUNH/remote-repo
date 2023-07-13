package com.fch.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.PropertySource;

/**
 * @packageName com.fch.config
 * @ClassName DubboProviderConfig
 * @Description dubbo服务提供方 配置类
 * @Author Fan-CUNH
 * @Date 2023/7/8 17:12
 * @Version 1.0
 */

@PropertySource("classpath:dubbo-provider.properties")
// 启用注解版Dubbo,批量扫描发布服务
@EnableDubbo(scanBasePackages = "com.fch.service")
public class DubboProviderConfig {
}
