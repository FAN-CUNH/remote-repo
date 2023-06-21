package com.fch.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.fch.bean.Course;
import com.fch.bean.Page;
import com.fch.bean.Student;
import com.fch.bean.User;
import com.fch.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @packageName com.fch.dao.impl
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/11 20:52
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {
    /**
     * 工具类
     */
    QueryRunner queryRunner;
    /**
     * 连接类对象
     */
    Connection conn;

    /**
     * 使用德鲁伊资源文件与数据库建立连接
     * 通过无参构造，实例化 queryRunner, conn
     */
    public UserDaoImpl() {
        // 通过反射获取类加载器将德鲁伊资源文件读入流中
        InputStream inputStream = UserDaoImpl.class.getClassLoader().getResourceAsStream("druid.properties");

        // 实例化资源文件对象
        Properties properties = new Properties();

        try {
            // 从流中获取资源对象
            properties.load(inputStream);
            // 获取数据源
            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            // 实例化queryRunner对象
            queryRunner = new QueryRunner();
            // 获取conn连接类对象
            conn = dataSource.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过userId, password 实现登录操作
     * 1.获取前端请求参数
     * 2.编写查询sql语句，查询当前userId是否存在于数据库中
     * 3.若存在，则返回用户对象，否则返回null
     *
     * @param userId   用户id
     * @param password 用户密码
     * @return 返回值： 登录用户对昂
     */
    @Override
    public User login(String userId, String password) {
        //0. 声明一个用户引用,接收登录用户对象
        User user;

        //1. 编写查询sql
        String sql = String.format("select * from user where userId = %s and password = %s", userId, password);

        //2. 执行sql,返回值 -> 用户对象
        try {
            user = queryRunner.query(conn, sql, new BeanHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //3. 响应数据
        return user;
    }

    @Override
    public Page<User> getAllUserMess(int currentPage, int pageSize) {
        // 0.声明一个泛型为User的list集合
        List<User> users = new ArrayList<>(16);

        // 1.分页查询所有用户信息的sql
        String sql = String.format("select * from user limit %s, %s", (currentPage - 1) * pageSize, pageSize);
        // 查询总记录数
        String sql1 = "select count(0) from user";
        long count;
        try {
            count = (long) queryRunner.query(conn, sql1, new ScalarHandler());
            System.out.println("count = " + count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 2.执行sql
        try {
            users = queryRunner.query(conn, sql, new BeanListHandler<>(User.class));
            System.out.println("users = " + users);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 3.响应数据
        return new Page<>(currentPage, pageSize, (int) count, users);
    }

    @Override
    public boolean deleteUserById(String stuNo) {
        //0. 声明一个int类型的变量，用于表示当前删除状态 0: 失败 其他: 成功
        int code = 0;

        //0. 编写根据用户id删除用户信息
        String sql = String.format("delete from user where userId = %s", stuNo);
        System.out.println("删除用户sql = " + sql);

        //1. 执行sql
        try {
            code = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //2.根据结果做出响应
        if (code > 0) {
            System.out.println("删除成功!");
        } else {
            System.out.println("删除失败!");
        }
        return code > 0;
    }

    @Override
    public boolean updateUserById(String userId, String password, String userName, String name, String email, String telephone, String sex) {
        //0. 编写更新sql
        String sql = String.format("UPDATE user SET password = %s,  userName = '%s', name = '%s', email = '%s', telephone = '%s', sex = '%s' WHERE userId = %s", password, userName, name, email, telephone, sex, userId);
        System.out.println("更新sql = " + sql);

        //1.
        int i = 0;
        try {
            i = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i > 0;
    }

    @Override
    public boolean addUser(String userId, String password, String userName, String name, String email, String telephone, String sex) {
        //0. 编写添加用户sql
        String sql = String.format("INSERT INTO user (password, userId, userName, name, email, sex, telephone) VALUES ('%s', '%s','%s' ,'%s', '%s', '%s', '%s')", password, userId, userName, name, email, telephone, sex);
        System.out.println("添加sql = " + sql);
        int i;
        //1. 执行sql
        try {
            i = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i > 0;
    }

    @Override
    public Page<Student> getAllStudentMessAndCourseMess(String currentPage, String pageSize) {
        int pageSizeInt;
        int currentPageInt;
        if (currentPage != null && pageSize != null) {
            currentPageInt = Integer.parseInt(currentPage);
            pageSizeInt = Integer.parseInt(pageSize);
        } else {
            currentPageInt = 1;
            pageSizeInt = 3;
        }
        //0. 编写查询所有学生信息和课程信息sql
        /*String sql = String.format("select *\n" +
                "from student\n" +
                "         left join stu_cou on student.stuNo = stu_cou.stuNo\n" +
                "         left join course c on c.couNo = stu_cou.couNo\n" +
                "limit %s, %s", (currentPageInt - 1) * pageSizeInt, pageSizeInt);
        String sql1 = ("select count(0) from student left join stu_cou on student.stuNo = stu_cou.stuNo");*/
        String sql = String.format("select * from student limit %s, %s", (currentPageInt - 1) * pageSizeInt, pageSizeInt);
        System.out.println("sql = " + sql);

        //1. 执行sql
        List<Student> students;
        long count = 0;
        try {
            // 初始化学生
            students = queryRunner.query(conn, sql, new BeanListHandler<>(Student.class));
            if (students != null && students.size() > 0) {
                count = (long) queryRunner.query(conn, "select count(0) from student", new ScalarHandler());
                for (Student student : students) {
                    String sql1 = String.format("select * from course where couNo in (select couNo from stu_cou where stuNo = %s)", student.getStuNo());
                    List<Course> courses = queryRunner.query(conn, sql1, new BeanListHandler<>(Course.class));
                    if (courses != null) {
                        student.setCourses(courses);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Page<>(currentPageInt, pageSizeInt, (int) count, students);
    }

    @Override
    public List<Course> getCourseMess(String stuNo) {
        //0. 编写查询所有可选课程信息的sql
        String sql = String.format("select * from course where couNo not in (select couNo from stu_cou where stuNo = %s)", stuNo);
        System.out.println("sql = " + sql);

        //1. 执行sql
        List<Course> courses;
        try {
            courses = queryRunner.query(conn, sql, new BeanListHandler<>(Course.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courses;
    }

    @Override
    public boolean addCourse(String couNo, String stuNo) {
        //0. 编写添加课程sql
        String sql = String.format("insert into stu_cou values ('%s', '%s')", stuNo, couNo);
        System.out.println("sql = " + sql);

        //1. 执行sql
        int add;
        try {
            add = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return add > 0;
    }

    @Override
    public boolean deleteCourse(String couNo, String stuNo) {
        //0. 编写添加课程sql
        String sql = String.format("delete from stu_cou where stuNo = '%s' and couNo = '%s'", stuNo, couNo);
        System.out.println("sql = " + sql);

        //1. 执行sql
        int delete;
        try {
            delete = queryRunner.update(conn, sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return delete > 0;
    }

    /**
     * 删除学生涉及到级联删除
     * 0. 跟根据学号去查询该学生的所有课程
     * 1. 删除该学生的所有课程
     * 2. 删除该学生
     *
     * @param stuNo 学号
     * @return 返回删除状态
     */
    @Override
    public boolean deleteStudent(String stuNo) {
        //0. 编写删除该学号的所有课程和删除该生的sql
        String sql = String.format("delete from stu_cou where stuNo = '%s'", stuNo);
        String sql1 = String.format("delete from student where stuNo = '%s'", stuNo);
        System.out.println("sql = " + sql);
        System.out.println("sql1 = " + sql1);

        //1. 执行sql
        int delete;
        int delete1;
        try {
            conn.setAutoCommit(false);
            delete = queryRunner.update(conn, sql);
            delete1 = queryRunner.update(conn, sql1);
            conn.commit();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        if (!(delete > 0 && delete1 > 0)) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return (delete > 0 && delete1 > 0);
    }
}
