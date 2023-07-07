package com.fch.config;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @packageName com.fch.config
 * @ClassName MybatisConfig
 * @Description Mybatis配置类
 * @Author Fan-CUNH
 * @Date 2023/7/5 19:29
 * @Version 1.0
 */
public class MybatisConfig {
    /**
     * @param dataSource 德鲁伊数据源
     * @return 返回SqlSessionFactoryBean对象
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.fch.domain");
        // 开启驼峰映射
        Configuration configuration=new Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        return sqlSessionFactoryBean;
    }

    /**
     * @return 返回mapperScannerConfigurer对象
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.fch.dao");
        return mapperScannerConfigurer;
    }
}
