package com.fch;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @packageName com.fch
 * @ClassName BaseUtil
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/13 18:53
 * @Version 1.0
 */
public class BaseUtil {
    public static Connection dateBaseUtil() {
        // 连接类对象
        Connection conn;
        // 通过反射获取类加载器将德鲁伊资源文件读入流中
        InputStream inputStream = BaseUtil.class.getClassLoader().getResourceAsStream("druid.properties");
        // 实例化资源文件
        Properties properties = new Properties();
        // 将流中对选存入资源文件对象中
        try {
            properties.load(inputStream);
            // 获取数据源
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            conn = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
