package com.fch.dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import com.fch.bean.Course;
import com.fch.bean.Page;
import com.fch.bean.Student;
import org.apache.commons.dbutils.QueryRunner;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @packageName com.fch.dao
 * @ClassName StudentDao
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/4 15:30
 * @Version 1.0
 */
public class StudentDao {

    /**
     * queryRunner工具类
     * conn 数据库连接对象
     * ps 预编译sql
     */
    QueryRunner queryRunner = null;
    Connection conn = null;
    PreparedStatement ps = null;

    /**
     * 调用无参构造的同时实例化了queryRunner工具类
     * <p>
     * 无参构造
     */
    public StudentDao() {
        // 通过德鲁伊连接数据库
        InputStream inputStream = StudentDao.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            // 从流中读取数据存入资源文件
            properties.load(inputStream);
            // 通过德鲁伊数据源工厂创建数据源
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            // queryRunner的有参构造，将数据源注入
            queryRunner = new QueryRunner(dataSource);
            // 获取连接
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据学生对象的学号和密码与数据库中的数据进项比对 若数据中有与之匹配的记录 则返回学生对象 否则返回null
     *
     * @param stuNo    学号
     * @param password 密码
     * @return 学生对象
     */
    public Student loadStudent(String stuNo, String password) {
        // 0.声明一个引用用于接收登录的学生对象
        Student student = null;

        // 1.编写sql
        String sql = String.format("select stuNo, stuName, password from student where stuNo = %s and password = %s", stuNo, password);
        // 打印sql语句
        System.out.println("登录sql： " + sql);

        // 2.处理sql
        try {
            // 获取到数据库中的student
            student = queryRunner.query(sql, new BeanHandler<>(Student.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // 3.响应数据
        if (student != null) {
            return student;
        } else {
            return null;
        }
    }

    /**
     * 通过学生的信息进行学生的注册 注册成功返回true
     *
     * @param stuNo    学号
     * @param stuName  姓名
     * @param password 密码
     * @return
     */
    public boolean registerStudent(String stuNo, String stuName, String password) {
        // 0.声明一个boolean变量用于表示该学生是否能注册成功 false:失败 true:成功
        boolean flag = false;

        // 1.编写预编译sql
        String sql = "insert into student (stuNo, stuName, password) values (?, ?, ?)";
        System.out.println("注册sql： " + sql);

        // 2.验证该学生是否已存在
        Student student = loadStudent(stuNo, password);
        System.out.println("当前学生的值" + student);

        if (student != null) {
            // 该学生已存在，不能重新注册
            System.out.println("当前学生已存在");
        } else {
            // 该学生不存在，可以注册
            System.out.println("该学生不存在，可以注册");
            try {
                // 通过conn获取预编译sql语句对象
                ps = conn.prepareStatement(sql);

                // 处理预编译sql语句
                ps.setString(1, stuNo);
                ps.setString(2, stuName);
                ps.setString(3, password);

                System.out.println(sql);

                // 执行sql语句 int result = executeUpdate(); 返回值是一个整数，表示受影响的行数 >0表示执行有效
                flag = ps.executeUpdate() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 通过学生对象获取学生的课程信息
     *
     * @param student 学生对象
     * @return 返回学生课程信息
     */
    public List<Course> showCourse(Student student) {
        // 0.创建与一个集合用于存储登录学生的课程信息
        List<Course> courses = new ArrayList<>(16);

        // 1.编写查询学生课程的sql语句
        String sql = String.format("select * from course where couNo in " +
                "(select stu_cou.couNo from stu_cou where stuNO in)" +
                "(select stuNo from student where stu_cou.stuNo = %s)", student.getStuNo());
        System.out.println(sql);

        // 2.执行sql
        try {
            courses = queryRunner.query(sql, new BeanListHandler<Course>(Course.class));

            // 将查询到的学生课程信息赋值给学生的课程属性
            student.setCourses(courses);
            // 打印学生信息
            System.out.println(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3.响应数据
        if (courses != null && courses.size() == 0) {
            return null;
        } else {
            return courses;
        }
    }

    public boolean delCourses(String stuNo, String conNo) {
        // 0.定义一个boolean变量用于表示课程是否删除成功
        boolean result = false;

        // 1.编写删除课程sql
        String sql = String.format("delete from stu_cou where stuNo = %s and couNo = %s", stuNo, conNo);
        System.out.println("删除课程sql： " + sql);

        // 2.执行sql
        try {
            result = queryRunner.update(sql) > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 3.根据sql执行结果做出响应
        return result;
    }

    public Page<Map<String, Object>> getPage(int currentPage, int everyPageRow) {
        //1 实例化
        Page<Map<String, Object>> page = new Page<>();

        //2 初始化
        page.setCurrentPage(currentPage);
        page.setEveryPageRow(everyPageRow);
        //总页数
        page.setPageSize(this.getPageSize(currentPage, everyPageRow));
        //每页数据
        page.setData(this.getPageStudents(currentPage, everyPageRow));
        return page;
    }

    //总页数
    public int getPageSize(int currentPage, int everyPageRow) {
        String sql = "select  count(*) from student LEFT JOIN stu_cou on student.stuno = stu_cou.stuno";
        long count = 0;
        try {
            count = (long) queryRunner.query(sql, new ScalarHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        long pageSize = count / everyPageRow;
        return (int) (count % everyPageRow == 0 ? pageSize : (pageSize + 1));

    }

    public List<Map<String, Object>> getPageStudents(int currentPage, int everyPageRow) {

        String sql = "select  student.*,course.* from student LEFT JOIN stu_cou on student.stuno = stu_cou.stuno\n" +
                "LEFT join course on stu_cou.couno = course.couno\n" +
                "limit " + (currentPage - 1) * everyPageRow + "," + everyPageRow;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            list = queryRunner.query(sql, new MapListHandler());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
