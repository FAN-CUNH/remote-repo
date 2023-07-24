package com.fch.config;

import com.fch.pojo.Address;
import com.fch.pojo.Emp;
import com.fch.pojo.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @packageName com.fch.config
 * @ClassName IConfig
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/24 13:51
 * @Version 1.0
 */
@Configuration
@EnableConfigurationProperties({User.class, Emp.class})
public class IConfig {
}
