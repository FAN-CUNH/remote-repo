package com.bean;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description 学生模板类
 * @Author Cunhao Fan
 * @Date 2023/5/9 15:53
 * @Version 1.0
 */
public class Student implements Serializable {
    /*成员字段学生，学生账户密码*/
    private String stuNo;
    private String stuPass;
    /*有参构造方法*/
    public Student(String stuNo, String stuPass) {
        this.stuNo = stuNo;
        this.stuPass = stuPass;
    }

    /*setget方法*/
    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuPass() {
        return stuPass;
    }

    public void setStuPass(String stuPass) {
        this.stuPass = stuPass;
    }

    /*无参构造方法*/
    public Student() {
    }
    /*重写toString方法，查看学生信息*/
    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuPass='" + stuPass + '\'' +
                '}';
    }
}
