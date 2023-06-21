package javase.day24.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @packageName javase.day23.utils
 * @ClassName JDBCUtils
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/15 13:25
 * @Version 1.0
 */
public class JDBCUtils {
    /**
     * 加载驱动
     */
    private String driver;
    /**
     * 数据库地址
     */
    private String url;
    /**
     * 数据库用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    /**
     * @Description 本类构造方法
     * @return null
     * @throws:
     * @Author CunHao Fan
     * @Date 2023/5/15 13:54
     */
    public JDBCUtils() {
        init();
    }

    /**
     * @Description 初始化成员变量
     * @return null
     * @throws:
     * @Author CunHao Fan
     * @Date 2023/5/15 13:57
     */
    private void init() {
        /*实例化 properties 对象*/
        Properties properties = new Properties();
        /*实例化输入流，将properties文件路径作为参数,将文件信息读入流中*/
        try(InputStream inputStream = new FileInputStream(ResourcePath.JDBC_PATH)) {
            /*从流中获取文件信息*/
            properties.load(inputStream);
            /*将信息赋给成员变量*/
            this.driver = properties.getProperty("jdbc.driverClassName");
            this.url = properties.getProperty("jdbc.url");
            this.username = properties.getProperty("jdbc.username");
            this.password = properties.getProperty("jdbc.password");
            /*加载驱动（只用加载一次）*/
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @Description 获取连接
     * @return null
     * @throws:
     * @Author CunHao Fan
     * @Date 2023/5/15 14:58
     */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url, this.username, this.password);
    }

    public void releaseConnection(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
