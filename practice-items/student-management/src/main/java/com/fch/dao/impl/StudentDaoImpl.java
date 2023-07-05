package com.fch.dao.impl;

import com.fch.dao.StudentDao;
import com.fch.domain.Student;
import com.fch.utils.DBUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @packageName com.fch.dao.impl
 * @ClassName StudentDaoImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/4 19:06
 * @Version 1.0
 */

@Repository
public class StudentDaoImpl implements StudentDao {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    @Override
    public boolean insert(Student student) {
        //0. 通过DBUtil获取连接
        connection = DBUtil.getConnection();

        if (connection != null) {
            try {
                //1. 编写添加学生sql
                statement = connection.prepareStatement(
                        "insert into practice_db.student(stu_name, stu_age, address) values (?, ?, ?)");

                //2. 执行sql
                statement.setString(1, student.getStuName());
                statement.setInt(2, student.getStuAge());
                statement.setString(3, student.getAddress());
                int update = statement.executeUpdate();

                //3. 判断是否更新成功
                if (update > 0) {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DBUtil.closeConnection(connection, statement, resultSet);
            }
        }
        return false;
    }

    @Override
    public boolean delete(Integer stuId) {
        //0. 通过DBUtil获取连接对象
        connection = DBUtil.getConnection();

        if (connection != null) {
            try {
                //1.编写删除学生sql
                statement = connection.prepareStatement(
                        "delete from practice_db.student where stu_id = ?");

                //2. 执行sql
                statement.setInt(1, stuId);
                int update = statement.executeUpdate();

                //3. 判断是否更新成功
                if (update > 0) {
                    return true;
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                //4. 关闭资源
                DBUtil.closeConnection(connection, statement, resultSet);
            }
        }
        return false;
    }

    @Override
    public boolean update(Student student) {
        //0. 通过DBUtil获取连接对象
        connection = DBUtil.getConnection();
        if (connection != null) {
            //1. 执行更新学生信息操作
            try {
                statement = connection.prepareStatement(
                        "update practice_db.student set stu_name = ?, stu_age = ?, address = ? where stu_id = ?");
                statement.setString(1, student.getStuName());
                statement.setInt(2, student.getStuAge());
                statement.setString(3, student.getAddress());
                statement.setInt(4, student.getStuId());
                int update = statement.executeUpdate();

                //2. 判断是否更新成功
                if (update > 0) {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DBUtil.closeConnection(connection, statement, resultSet);
            }
        }
        return false;
    }

    @Override
    public Student findById(Integer stuId) {
        //0. 通过DBUtil获取数据库连接对象
        connection = DBUtil.getConnection();
        if (connection != null) {
            try {
                //1. 编写查找单个学生
                statement = connection.prepareStatement(
                        "select * from practice_db.student where stu_id = ?");
                statement.setInt(1, stuId);

                //2. 执行sql
                resultSet = statement.executeQuery();

                //3. 响应数据
                if (resultSet.next()) {
                    Student student = new Student();
                    student.setStuId(resultSet.getInt("stu_id"));
                    student.setStuName(resultSet.getString("stu_name"));
                    student.setStuAge(resultSet.getInt("stu_age"));
                    student.setAddress(resultSet.getString("address"));
                    return student;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DBUtil.closeConnection(connection, statement, resultSet);
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        //0. 通过DBUtil获取数据库连接对象
        connection = DBUtil.getConnection();
        if (connection != null) {
            try {
                //1. 编写查找单个学生
                statement = connection.prepareStatement(
                        "select * from practice_db.student");

                //2. 执行sql
                resultSet = statement.executeQuery();

                //3. 响应数据
                List<Student> students = new ArrayList<>(16);
                while (resultSet.next()) {
                    Student student = new Student();
                    student.setStuId(resultSet.getInt("stu_id"));
                    student.setStuName(resultSet.getString("stu_name"));
                    student.setStuAge(resultSet.getInt("stu_age"));
                    student.setAddress(resultSet.getString("address"));
                    students.add(student);
                }
                return students;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                DBUtil.closeConnection(connection, statement, resultSet);
            }
        }
        return null;
    }
}
