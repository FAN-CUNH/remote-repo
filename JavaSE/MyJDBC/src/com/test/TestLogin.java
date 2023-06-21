package com.test;

import com.entity.Course;
import com.entity.Page;
import com.entity.Student;
import com.service.StudentService;

import java.util.List;
import java.util.Scanner;

/**
 * @packageName com.test
 * @ClassName testLogin
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/25 13:43
 * @Version 1.0
 */
public class TestLogin {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号和密码以空格隔开：");
        String stuNo = scanner.next();
        String password = scanner.next();
        Student student = studentService.login(stuNo, password);
        System.out.println(student);
        if (student != null) {
            Page<Student> studentPage = studentService.getPage(2, 3);
            List<Student> studentList = studentPage.getMapList();
            for (Student st:studentList
            ) {
                System.out.println("基本信息："+st.getStuno()+"   "+st.getStuname());
                System.out.println("以下是学生选择的课程");
                List<Course> courses = st.getCourses();
                System.out.println(courses);
            }
        }
        /*注册*/

    }
}
