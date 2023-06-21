package com.service;

import com.bean.Student;
import com.dao.StudentDao;

/**
 * @ClassName StudentService
 * @Description 业务逻辑层
 * @Author Cunhao Fan
 * @Date 2023/5/9 16:29
 * @Version 1.0
 */
public class StudentService {
    /*成员变量*/
    StudentDao studentDao = null;

    /*无参构造，实例化StudentService的同时实例化StudentDao*/
    public StudentService() {
        this.studentDao = new StudentDao();
    }

    /**
     * @Description 登录
     * @param stuNo 学生学号
     * @param stuPass 学生密码
     * @return Student
     * @Author Cunhao Fan
     * @Date 2023/5/9 16:32
     */
    public Student login(String stuNo, String stuPass){
        return  studentDao.login(stuNo, stuPass);
    }


    /**
     * @Description 注册
     * @param stuNo 学生学号
     * @param stuPass 学生密码
     * @return Student
     * @Author Cunhao Fan
     * @Date 2023/5/9 16:32
     */
    public Student register(String stuNo, String stuPass){
        return  studentDao.register(stuNo, stuPass);
    }



    /**
     * @Description 聊天
     * @param mess 要发送的信息
     * @return void
     * @Author Cunhao Fan
     * @Date 2023/5/9 16:32
     */
    public void sendMess(String mess){
        studentDao.sendMess(mess);
    }

    public String  receiveMess(){
        String mess = studentDao.receiveMess();
        return mess;
    }
}
