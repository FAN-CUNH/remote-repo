package javase.day24.controller;

import javase.day24.service.StudentService;

import java.util.HashMap;

/**
 * @packageName javase.day24.controller
 * @ClassName TestStudent
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/16 12:44
 * @Version 1.0
 */
public class TestStudent {
    public static void main(String[] args) {
        /*实例化StudentService*/
        StudentService studentService = new StudentService();
        /*调用查询学生信息以及学生选课信息方法*/
        System.out.println(studentService.getStudent("4"));
        System.out.println(studentService.getStudentAndCourseAllMess());
    }
}
