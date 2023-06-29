package com.fch.service;

import com.fch.bean.Page;
import com.fch.bean.Result;
import com.fch.bean.User;

import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName UserService
 * @Description TODO 业务逻辑层
 * @Author Fan
 * @Date 2023/6/11 21:45
 * @Version 1.0
 */
public interface UserService {
    /**
     * 登录
     *
     * @param userId 用户id
     * @param password 用户密码
     * @return 返回一个用户对象
     */
    User login(String userId, String password);

    Page<User> getAllUserMess(int currentPage, int pageSize);

    boolean deleteUserById(String stu_no);

    boolean updateUserById(String userId,String password, String userName, String name, String email, String telephone, String sex);

    boolean addUser(String userId,String password, String userName, String name, String email, String telephone, String sex);

    Result<Object> getAllStudentMessAndCourseMess(String currentPage, String pageSize);

    Result<Object> getCourseMess(String stu_no);

    Result<Object> addCourse(String cou_no, String stu_no);

    Result<Object> deleteCourse(String cou_no, String stu_no);

    Result<Object> deleteStudent(String stu_no);
}
