package com.fch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @packageName com.fch.config
 * @ClassName RedisConfig
 * @Description Jedis连接池配置
 * @Author Fan-CUNH
 * @Date 2023/7/22 22:20
 * @Version 1.0
 */
@PropertySource("classpath:redis.properties")
public class RedisConfig {
    @Value("${redis.maxIdle}")
    private Integer maxIdle;
    @Value("${redis.minIdle}")
    private Integer minIdle;
    @Value("${redis.maxTotal}")
    private Integer maxTotal;
    @Value("${redis.url}")
    private String url;
    @Value("${redis.port}")
    private Integer port;
    @Value("${redis.password}")
    private String password;
    @Value("${redis.timeout}")
    private Integer timeout;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        //空闲时，允许的最大连接数
        config.setMaxIdle(maxIdle);
        //空闲时，允许的最小连接数
        config.setMinIdle(minIdle);
        //池子中，最大连接数
        config.setMaxTotal(maxTotal);
        //超过最大连接数时，进入等待状态
        config.setBlockWhenExhausted(true);
        //获得的连接，都是ping通的连接
        config.setTestOnBorrow(true);
        //归还连接时，会进行检查，检查不通过，销毁。
        config.setTestOnReturn(true);

        return new JedisPool(config, url, port, timeout, password);
    }
}
