package com.fch.config;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.PropertySource;

/**
 * @packageName com.fch.config
 * @ClassName MobileConsumerConfig
 * @Description 移动端消费方配置类
 * @Author Fan-CUNH
 * @Date 2023/7/15 15:27
 * @Version 1.0
 */

@EnableDubbo(scanBasePackages = "com.fch.controller")
@PropertySource("classpath:dubbo-consumer.properties")
public class MobileConsumerConfig {
}
