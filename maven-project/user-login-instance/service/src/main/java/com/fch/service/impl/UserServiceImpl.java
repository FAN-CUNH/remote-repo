package com.fch.service.impl;

import com.fch.bean.*;
import com.fch.dao.UserDao;
import com.fch.dao.impl.UserDaoImpl;
import com.fch.service.UserService;

import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.service.impl
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Fan
 * @Date 2023/6/11 21:46
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {

    /**
     * 调用数据访问层 userDao
     */
    UserDao userDao = new UserDaoImpl();

    /**
     * 通过userId, password 实现登录
     *
     * @param userId   用户id
     * @param password 用户密码
     * @return 返回 -> 登录用户对象
     */
    @Override
    public User login(String userId, String password) {
        return userDao.login(userId, password);
    }

    @Override
    public Page<User> getAllUserMess(int currentPage, int pageSize) {
        return userDao.getAllUserMess(currentPage, pageSize);
    }

    @Override
    public boolean deleteUserById(String stuNo) {
        return userDao.deleteUserById(stuNo);
    }

    @Override
    public boolean updateUserById(String userId, String password, String userName, String name, String email, String telephone, String sex) {
        return userDao.updateUserById(userId, password, userName, name, email, telephone, sex);
    }

    @Override
    public boolean addUser(String userId, String password, String userName, String name, String email, String telephone, String sex) {
        return userDao.addUser(userId, password, userName, name, email, telephone, sex);
    }

    @Override
    public Result<Object> getAllStudentMessAndCourseMess(String currentPage, String pageSize) {
        Result<Object> result;

        /*Page<Map<String, Object>> page;
        // currentPage,pageSize两者任意为null，则加载全部学生信息
        if (currentPage == null && pageSize == null) {
            page = userDao.getAllStudentMessAndCourseMess(null, null);

            result = new Result<>(20000, page, "加载成功");
        } else {
            page = userDao.getAllStudentMessAndCourseMess(currentPage, pageSize);

            result = new Result<>(20000, page, "加载成功");
        }*/
        Page<Student> page;
        if (currentPage == null && pageSize == null) {
            page = userDao.getAllStudentMessAndCourseMess(null, null);

            result = new Result<>(20000, page, "加载成功");
        } else {
            page = userDao.getAllStudentMessAndCourseMess(currentPage, pageSize);

            result = new Result<>(20000, page, "加载成功");
        }

        return result;
    }

    @Override
    public Result<Object> getCourseMess(String stuNo) {
        List<Course> courses;
        Result<Object> result;
        // 参数判断
        if (stuNo != null && !"".equals(stuNo)) {
            courses = userDao.getCourseMess(stuNo);
            if (courses != null) {
                result = new Result<>(20000, courses, "ok");
            } else {
                result = new Result<>(400, null, "err");
            }
        } else {
            result = new Result<>(20000, null, "ok");
        }
        return result;
    }

    @Override
    public Result<Object> addCourse(String couNo, String stuNo) {
        // 检验参数
        Result<Object> result;
        if (couNo != null && !"".equals(couNo)) {
            boolean add = userDao.addCourse(couNo, stuNo);
            if (add) {
                result = new Result<>(20000, true, couNo+"号课程添加成功");
            } else {
                result = new Result<>(400, false, couNo+"号课程添加失败");
            }
        } else {
            result = new Result<>(400, null, "非法参数");
        }
        return result;
    }

    @Override
    public Result<Object> deleteCourse(String couNo, String stuNo) {
        // 检验参数
        Result<Object> result;
        if (couNo != null && !"".equals(couNo)) {
            boolean delete = userDao.deleteCourse(couNo, stuNo);
            if (delete) {
                result = new Result<>(20000, true, couNo+"号课程删除成功");
            } else {
                result = new Result<>(400, false, couNo+"号课程删除失败");
            }
        } else {
            result = new Result<>(400, null, "非法参数");
        }
        return result;
    }

    @Override
    public Result<Object> deleteStudent(String stuNo) {
        Result<Object> result;
        // 参数校验
        if (stuNo != null && !"".equals(stuNo)) {
            boolean delete = userDao.deleteStudent(stuNo);
            if (delete) {
                result = new Result<>(20000, true, stuNo+"号学生删除成功");
                System.out.println("删除成功");
            } else {
                result = new Result<>(400, false, stuNo+"号学生删除失败");
            }
        } else {
            result = new Result<>(400, false, "非法参数");
        }
        return result;
    }
}
