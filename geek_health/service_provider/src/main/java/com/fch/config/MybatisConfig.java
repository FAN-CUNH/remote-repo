package com.fch.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @packageName com.fch.config
 * @ClassName MybatisConfig
 * @Description mybatis 配置类
 * @Author Fan-CUNH
 * @Date 2023/7/8 17:08
 * @Version 1.0
 */

// 扫描mapper接口， 为其生成代理对象
@MapperScan("com.fch.mapper")
// 加载外部属性文件
@PropertySource("classpath:jdbc.properties")
// 开启注解版事务管理 需要进行事务控制，会由Spring框架产生代理对象，Dubbo需要将Service发布为服务，要求必须使用cglib创建代理对象。
@EnableTransactionManagement(proxyTargetClass = true)
public class MybatisConfig {
    @Value("${jdbc.driver}")
    String driver;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    /**
     * @return 德鲁伊 数据源
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
     * 驼峰映射、数据库方言、分页插件
     *
     * @param dataSource 数据源
     * @return 会话工厂
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.fch.domain");

        Configuration configuration = new Configuration();
        // 开启驼峰映射
        configuration.setMapUnderscoreToCamelCase(true);

        sqlSessionFactoryBean.setConfiguration(configuration);

        // 分页插件
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        // 指定数据库方言
        properties.put("helperDialect", "mysql");
        // 分页合理化
        properties.put("reasonable", "true");

        // 配置分页参数
        pageInterceptor.setProperties(properties);
        // 设置分页插件
        sqlSessionFactoryBean.setPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }

    /**
     * @param dataSource dataSource 德鲁伊数据源对象
     * @return 数据源事务管理
     */
    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
