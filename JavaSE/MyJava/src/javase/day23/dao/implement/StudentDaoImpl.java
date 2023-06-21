package javase.day23.dao.implement;

import javase.day23.bean.Student;
import javase.day23.dao.StudentDao;
import javase.day23.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.HashMap;
import java.util.Map;

/**
 * @packageName javase.day23.dao.implement
 * @ClassName StudentDaoImpl
 * @Description 接口实现层
 * @Author CunHao Fan
 * @Date 2023/5/15 15:59
 * @Version 1.0
 */
public class StudentDaoImpl implements StudentDao {
    public Connection connection = null;

    public StudentDaoImpl() {
        JDBCUtils jdbcUtils = new JDBCUtils();
        try {
            /*获取连接*/
            connection = jdbcUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加学生
     *
     * @param student 被添加的学生对象
     */
    @Override
    public void addStudent(Student student) {
        /*定义一个String类型变量接收sql语句*/
        String sql = String.format("insert into student(stuNo, stuName, stuAge, birthday) values('%s', '%s', '%s', '%s')", student.getStuNo() ,student.getStuName(), student.getStuAge(), student.getBirthday());
        /*定义一个Statement，用于执行静态的sql语句并返回他生成的结果对象*/
        Statement statement = null;
        try {
            /*获取statement*/
            statement = connection.createStatement();
            /*将sql语句发送到mysql数据库*/
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据学号删除学生信息
     *
     * @param stuNo 学号
     */
    @Override
    public void deleteStudent(String stuNo) {
        /*sql语句*/
        String sql = String.format("delete from student where stuNo = '%s'", stuNo);
        Statement statement = null;
        try {
            /*获取到statement*/
            statement = connection.createStatement();
            /*通过Statement调用executeUpdate()执行更新sql语句*/
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (statement != null) {
                try {
                    /*关闭资源*/
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    /**
     * 按学号更新学生信息
     *
     * @param stuNo 被更新的学生学号
     */
    @Override
    public void updateStudent(String stuNo) {
        /*sql语句*/
        String sql = null;
        sql = String.format("update student set birthday = '%s' where stuNo = '%s'", "1998-11-12", stuNo);
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    /**
     * 根据学号查询学生
     *
     * @param stuNo 学号
     */
    @Override
    public Map<String, Object> selectStudent(String stuNo) {
        /*定义一个Map集合用于存储学生信息的键值对*/
        Map<String, Object> map = new HashMap<>(16);
        /*sql语句*/
        String sql = "select * from student";
        /*声明一个Statement变量*/
        Statement statement = null;
        try {
            /*获取statement*/
            statement = connection.createStatement();
            /*通过Statement调用executeQuery()执行查询sql*/
            ResultSet resultSet = statement.executeQuery(sql);
            /*判断结果集中是否存在数据行（第一行是字段名，第二行开始时数据行）*/
            if (resultSet.next()) {
                /*获取第一个字段的信息*/
                String stuNo1 = resultSet.getString("stuNo");
                /*将数据放入集合中*/
                map.put("stuNo", stuNo1);
                String stuName1 = resultSet.getString("stuName");
                /*将数据放入集合中*/
                map.put("stuName", stuName1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return map;
    }
}
