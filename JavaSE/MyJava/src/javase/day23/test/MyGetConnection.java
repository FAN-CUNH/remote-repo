package javase.day23.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @ClassName MyGetConnection
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/15 9:45
 * @Version 1.0
 */
public class MyGetConnection {
    public static void main(String[] args) {
        /*先找到驱动名*/
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        /* 获取连接*/
        String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String password = "0000";
        Connection myConnection = null;
        try {
            /*获取驱动的Class对象*/
            Class.forName(driverClassName);
            /*利用驱动连接数据库*/
            myConnection = DriverManager.getConnection(url, userName, password);
            /*输出连接名*/
            System.out.println("数据库连接" + myConnection);
            /*获取Statement,负责发送sql语句到mysql后台*/
            Statement statement = myConnection.createStatement();
            /*写sql语句*/
            String id = "5";
            String sqlDelete = "delete from creditaccount where id = '"+ id +"'";
            System.out.println("删除sql：" + sqlDelete);
            /*发送sql，并让后台执行sql 定义int型result接收更新影响的行数*/
            int result = statement.executeUpdate(sqlDelete);
            System.out.println(result);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
