package com.fch.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @packageName com.fch.config
 * @ClassName DruidDataSourceConfig
 * @Description 配置德鲁伊数据源
 * @Author Fan-CUNH
 * @Date 2023/7/2 10:18
 * @Version 1.0
 */
public class DruidDataSourceConfig extends UnpooledDataSourceFactory {
    public DruidDataSourceConfig() {
        this.dataSource = new DruidDataSource();
    }
}
