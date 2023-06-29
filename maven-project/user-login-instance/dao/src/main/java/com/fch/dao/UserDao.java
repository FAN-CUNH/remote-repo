package com.fch.dao;

import com.fch.bean.Course;
import com.fch.bean.Page;
import com.fch.bean.Student;
import com.fch.bean.User;

import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.dao
 * @ClassName UserDao
 * @Description TODO 数据访问层
 * @Author Fan
 * @Date 2023/6/11 20:51
 * @Version 1.0
 */
public interface UserDao {
    /**
     * 登录
     *
     * @param userId 用户id
     * @param password 用户密码
     * @return 返回一个用户对象
     */
    User login(String userId, String password);

    public Page<User> getAllUserMess(int currentPage, int pageSize);

    boolean deleteUserById(String stu_no);

    boolean updateUserById(String userId,String password, String userName, String name, String email, String telephone, String sex);

    boolean addUser(String userId,String password, String userName, String name, String email, String telephone, String sex);

    Page<Student> getAllStudentMessAndCourseMess(String currentPage, String pageSize);

    List<Course> getCourseMess(String stu_no);

    boolean addCourse(String cou_no, String stu_no);

    boolean deleteCourse(String cou_no, String stu_no);

    boolean deleteStudent(String stu_no);
}
