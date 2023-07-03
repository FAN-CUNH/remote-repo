package com.fch.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @packageName com.fch.config
 * @ClassName MybatisSqlSessionConfig
 * @Description 配置SqlSessionFactory的静态单例模式
 * @Author Fan-CUNH
 * @Date 2023/7/2 10:22
 * @Version 1.0
 */
public class MybatisSqlSessionConfig {
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession session;

    public static SqlSession getSession() {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
        }
        return session;
    }
}
