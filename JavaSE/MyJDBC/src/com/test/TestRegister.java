package com.test;

import com.entity.Student;
import com.service.StudentService;

import java.util.Scanner;

/**
 * @packageName com.test
 * @ClassName TestRegister
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/5/25 15:30
 * @Version 1.0
 */
public class TestRegister {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号、密码、姓名、年龄和生日以空格隔开：");
        String stuNo = scanner.next();
        String password = scanner.next();
        String name = scanner.next();
        long age  = scanner.nextLong();
        String birthday = scanner.next();
        studentService.register(stuNo, name, age, birthday, password);
    }
}
