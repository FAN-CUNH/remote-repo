package javase.day24.dao;

import javase.day24.entity.Course;
import javase.day24.entity.Student;
import javase.day24.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @packageName javase.day24.dao
 * @ClassName StudentDaoImpl
 * @Description StudentDao接口实现类
 * @Author CunHao Fan
 * @Date 2023/5/16 13:13
 * @Version 1.0
 */
public class StudentDaoImpl implements StudentDao {
    /**
     *声明一个公告的连接对象
     */
    public Connection connection = null;

    public StudentDaoImpl() {
        JDBCUtils utils = new JDBCUtils();
        /*通过JDBCUtils获取连接对象*/
        try {
            connection = utils.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 根据学生学号查询学生全部信息包含选课信息
     *
     * @param stuNo 学生学号
     * @return 查询到的学生对象 学生对象中包含课程对象集合
     */
    @Override
    public Student getStudent(String stuNo) {
        /*声明一个学生对象用于存储查询到的学生*/
        Student student = null;
        /*定义一个课程集合*/
        ArrayList<Course> courses = new ArrayList<>(16);
        /*SQL语句*/
        String sql = String.format(
                " select student.STUNO, student.STUNAME, c.COUNO, c.COUNAME from student left join stu_cou sc on student.STUNO = sc.STUNO left join course c on sc.COUNO = c.COUNO where student.STUNO = '%s'; "
                ,
                stuNo
        );
        try {
            /*获取Statement*/
            Statement statement = connection.createStatement();
            /*执行sql语句*/
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                /*有数据,则实例化学生，并将信息赋值*/
                if (student == null) {
                    student = new Student();
                    student.setStuNo(resultSet.getString("stuNo"));
                    student.setStuName(resultSet.getString("stuName"));
                }
                /*实例化课程*/
                if (resultSet.getString("couNo") != null) {
                    Course course = new Course();
                    course.setCouNo(resultSet.getString("couNo"));
                    course.setCouName(resultSet.getString("couName"));
                    courses.add(course);
                }
            }
            if (student != null) {
                student.setCourses(courses);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    /**
     * 根据学生学号查询学生信息并获取该学生选择的第一门课程信息
     *
     * @param stuNo 学生学号
     * @return 返回学生对象 学生对象中包含课程对象
     */
    @Override
    public Student getStudentAndGetOneCourse(String stuNo) {
        /*声明一个学生对象用于存储查询到的学生*/
        Student student = null;
        /*定义一个集合用于存储查询到的学生的课程信息*/
        ArrayList<Course> courses = new ArrayList<>(16);
        /*SQL语句*/
        String sql = String.format(/*sql语句*/"'%s'",stuNo);
        /*获取Statement*/
        try {
            Statement statement = connection.createStatement();
            /*执行sql*/
            ResultSet resultSet = statement.executeQuery(sql);
            /*判断结果集数据行是否存在*/
            while (resultSet.next()) {
                /*有数据行，判断学生对象是否存在*/
                if (student == null) {
                    /*创建学生，并将其地址引用给student*/
                    student = new Student();
                    /*给student变量赋值*/
                    student.setStuNo(resultSet.getString("stuNo"));
                    student.setStuName(resultSet.getString("stuName"));
                }
                /*判断当前学生是否选课*/
                boolean isChooseCourse = resultSet.getString("couNO") != null;
                if (isChooseCourse) {
                    /*选课了,实例化课程对象*/
                    Course course = new Course();
                    /*给课程信息赋值*/
                    course.setCouNo(resultSet.getString("couNo"));
                    course.setCouName(resultSet.getString("couName"));
                    courses.add(course);
                }
            }
            if (student != null) {
                student.setCourses(courses);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return student;
    }

    /**
     * 根据学生学号查询所有学生信息集合课程信息
     *
     * @return 返回一个map集合 键为学号，值为学生对象（学生对象包含课程信息）
     */
    @Override
    public Map<String, Student> getStudentAndCourseAllMess() {
        /*实例化一个Map集合用于存储查询到的学生信息*/
        HashMap<String, Student> map = new HashMap<>(16);
        /*SQL语句*/
        String sql = "select student.*,c.* from student left join" +
                " stu_cou sc on student.stuNo = sc.stuNo left join" +
                " course c on sc.couNo = c.couNo";
        /*获取Statement*/
        try {
            Statement statement = connection.createStatement();
            /*执行sql语句*/
            ResultSet query = statement.executeQuery(sql);
            /*循环判断下一行是否存在数据*/
            while (query.next()) {
                /*存在数据，由于一个学生可能选择多门课程，可能存在多条记录是同一个学生对象但是选的课程不同，故实例化学生前要判断当前学生是否已被加入集合*/
                String stuNo = query.getString("stuNo");
                if (map.containsKey("stuNo")) {
                    /*当前学生信息已加入到集合中，获取当前学生*/
                    Student student = map.get(stuNo);
                    /*获取当前学生的课程集合*/
                    ArrayList<Course> courses = new ArrayList<>(16);
                    /*该学生已被加入到集合，且当前记录课程信息必定存在*/
                    Course course = new Course();
                    course.setCouNo(query.getString("couNo"));
                    course.setCouName(query.getString("couName"));
                    /*将课程添加到该学生的集合中*/
                    courses.add(course);
                }
                else {
                    /*当前学生信息未加入到集合,实例化学生对象*/
                    Student student = new Student();
                    /*给学生对象赋值*/
                    student.setStuNo(query.getString("stuNo"));
                    student.setStuName(query.getString("stuName"));
                    /*创建一个课程集合用于存放学生选择的课程*/
                    ArrayList<Course> courses = new ArrayList<>(16);
                    if (query.getString("couNo") != null) {
                        /*学生有课程信息*/
                        Course course = new Course();
                        course.setCouNo(query.getString("couNo"));
                        course.setCouName(query.getString("couName"));
                        courses.add(course);
                    }
                    student.setCourses(courses);
                    map.put(stuNo, student);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return map;
    }
}
