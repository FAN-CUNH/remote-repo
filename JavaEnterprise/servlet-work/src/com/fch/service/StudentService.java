package com.fch.service;

import com.fch.bean.Course;
import com.fch.bean.Page;
import com.fch.bean.Student;
import com.fch.dao.StudentDao;

import java.util.List;
import java.util.Map;

/**
 * @packageName com.fch.service
 * @ClassName StudentService
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/4 15:31
 * @Version 1.0
 */
public class StudentService {
    /**
     * 调用数据访问层
     */
    StudentDao studentDao = null;

    public StudentService() {
        studentDao = new StudentDao();
    }

    public Student loadStudent(String stuNo, String password) {
        return studentDao.loadStudent(stuNo, password);
    }

    public boolean registerStudent(String stuNo, String stuName, String password) {
        return studentDao.registerStudent(stuNo, stuName, password);
    }

    public List<Course> showCourse(Student student) {
        return studentDao.showCourse(student);
    }

    public boolean delCourses(String stuNo, String conNo) {
        return studentDao.delCourses(stuNo, conNo);
    }

    public Page<Map<String, Object>> getPage(int currentPage, int everyPageRow) {
        return studentDao.getPage(currentPage, everyPageRow);
    }
}
