package com.fch.utils;

import java.sql.*;

/**
 * @packageName com.fch.utils
 * @ClassName DBUtil
 * @Description 连接数据库工具类
 * @Author Fan-CUNH
 * @Date 2023/7/4 19:19
 * @Version 1.0
 */
public class DBUtil {
    /**
     * 获取数据库连接
     *
     * @return 返回一个connection对象
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/practice_db?serverTimeZone=UTC","root", "root");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 关闭资源
     *
     * @param connection 数据库连接对象
     * @param statement 预处理通道
     * @param resultSet 结果集
     */
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if (statement != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
