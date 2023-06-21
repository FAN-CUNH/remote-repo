package com.service;

import com.dao.StudentDao;
import com.entity.Course;
import com.entity.Page;
import com.entity.Student;

/**
 * @packageName com.service
 * @ClassName StudentService
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/25 13:41
 * @Version 1.0
 */
public class StudentService {
    StudentDao studentDao;

    public StudentService() {
        studentDao = new StudentDao();
    }

    public Student login(String stuNo, String password) {
        return studentDao.login(stuNo, password);
    }

    public void register(String stuNo, String name, long age, String birthday, String password) {
        studentDao.register(stuNo, name, age, birthday, password);
    }

    public Page<Student> getPage(int currentPage, int everyShow) {
        return studentDao.getPage(currentPage, everyShow);
    }

}
