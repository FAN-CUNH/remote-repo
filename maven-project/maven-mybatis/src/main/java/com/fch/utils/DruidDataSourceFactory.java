package com.fch.utils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

/**
 * @packageName com.fch.utils
 * @ClassName DruidDataSourceFactory
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/25 15:14
 * @Version 1.0
 */
public class DruidDataSourceFactory extends UnpooledDataSourceFactory {


    /**
     * 配置德鲁伊数据源
     */
    public DruidDataSourceFactory(){
        this.dataSource = new DruidDataSource();
    }
}
