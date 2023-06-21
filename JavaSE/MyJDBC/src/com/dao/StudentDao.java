package com.dao;

import com.entity.Course;
import com.entity.Page;
import com.entity.Student;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @packageName com.dao
 * @ClassName StudentDao
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/25 13:38
 * @Version 1.0
 */
public class StudentDao {
    DataSource dataSource = new ComboPooledDataSource("mysql");
    QueryRunner queryRunner = new QueryRunner(dataSource);

    /**
     * 通过学号和密码登录
     * @param stuNo 学号
     * @param password 密码
     * @return 返回学生对象
     */
    public Student login(String stuNo, String password) {
        Student student = null;
        /*sql语句*/
        String sql = String.format("select * from student where stuNo = '%s' and password = '%s'", stuNo, password);
        try {
            student = queryRunner.query(sql, new BeanHandler<Student>(Student.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    /**
     * 学生注册
     * @param stuNo 学号
     * @param password 密码
     * @param name 姓名
     * @param age 年龄
     * @param birthday 生日
     */
    public void register(String stuNo, String name, long age, String birthday, String password) {
        String sql = String.format("insert into student values('%s', '%s', '%s', '%s', '%s')", stuNo, name, age, birthday, password   );
        try {
            queryRunner.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Page<Student> getPage(int currentPage, int everyShow) {
        /*实例化*/
        Page<Student> page = new Page<>();
        /*给四个参数赋值*/
        page.setCurrentPage(currentPage);
        page.setEveryPageSize(everyShow);
        /*查询所有学生记录*/
        String sql = "select count(*) from student";
        long count = 0;
        try {
            count = (long) queryRunner.query(sql, new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*获取总页数*/
        int allPageCount = (int) (count % everyShow == 0?count / everyShow:(count/everyShow)+1);
        page.setAllPageCount(allPageCount);
        /*获取当页数据*/
        page.setMapList(getStudents(currentPage, everyShow));
        return page;
    }

    //获取当前页数据
    public List<Student> getStudents(int currentPage, int everyShow){
        String sql = "select * from student limit "+(currentPage -1)* everyShow+","+everyShow;
        List<Student> students = new ArrayList<>();
        try {
            students = queryRunner.query(sql,new BeanListHandler<>(Student.class));
            for (Student everyStu:students
            ) {
                String stuNo = everyStu.getStuno();
                //根据学号查询改学生选择的课程
                String sql1 = "select * from course where couno in(select couno from stu_cou where stuno = '"+stuNo+"')";
                List<Course> courses = new ArrayList<>();
                courses = queryRunner.query(sql1,new BeanListHandler<>(Course.class));
                everyStu.setCourses(courses);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  students;

    }
}
