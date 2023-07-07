package com.fch.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @packageName com.fch.config
 * @ClassName JdbcConfig
 * @Description jdbc配置类
 * @Author Fan-CUNH
 * @Date 2023/7/5 19:22
 * @Version 1.0
 */
public class JdbcConfig {
    /**
     * 数据库驱动
     */
    @Value("${jdbc.driver}")
    private String driver;
    /**
     * 数据库地址
     */
    @Value("${jdbc.url}")
    private String url;
    /**
     * 数据库用户名
     */
    @Value("${jdbc.username}")
    private String username;
    /**
     * 数据库密码
     */
    @Value("${jdbc.password}")
    private String password;

    /**
     * 获取德鲁伊数据源
     *
     * @return 德鲁伊数据源对象
     */
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * @param dataSource 德鲁伊数据源对象
     * @return 数据源事务管理
     */
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
