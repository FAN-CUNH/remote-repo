package com.fch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @packageName com.fch.config
 * @ClassName RedisConfig
 * @Description Redis配置类
 * @Author Fan-CUNH
 * @Date 2023/7/12 15:56
 * @Version 1.0
 */

// 加载外部资源文件
@PropertySource("classpath:redis.properties")
public class RedisConfig {
    @Value("${redis.maxIdle}")
    private Integer maxIdle;

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

    /**
     * 设置redis配置类的参数，管理jedis连接池
     *
     * @return 返回jedis连接池
     */
    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 最大连接数
        jedisPoolConfig.setMaxIdle(maxIdle);
        //空闲时，允许的最大连接数
        jedisPoolConfig.setMaxTotal(maxTotal);
        //超过最大连接数时，进入等待状态
        jedisPoolConfig.setBlockWhenExhausted(true);
        //获得的连接，都是ping通的连接
        jedisPoolConfig.setTestOnBorrow(true);
        //归还连接时，会进行检查，检查不通过，销毁。
        jedisPoolConfig.setTestOnReturn(true);

        return new JedisPool(jedisPoolConfig, url, port, timeout, password);
    }
}
