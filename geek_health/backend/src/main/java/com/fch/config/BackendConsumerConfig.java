package com.fch.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.PropertySource;

/**
 * @packageName com.fch.config
 * @ClassName BackendConsumerConfig
 * @Description 后台消费方配置类
 * @Author Fan-CUNH
 * @Date 2023/7/8 19:24
 * @Version 1.0
 */

@EnableDubbo
@PropertySource("classpath:dubbo-consumer.properties")
public class BackendConsumerConfig {
}
