package com.fch.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @packageName com.fch.utils
 * @ClassName MybatisUtil
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/6/25 14:56
 * @Version 1.0
 */
public class MybatisUtil {
    /**
     * 静态单例 SqlSessionFactory连接
     */
    private static SqlSessionFactory sqlSessionFactory = null;
    static SqlSession session;

    public static SqlSession getSession() {
        if (sqlSessionFactory == null) {
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 装配
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
        }
        return session;
    }
}
