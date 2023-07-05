package com.fch.controller;

import com.fch.domain.Student;
import com.fch.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @packageName com.fch.controller
 * @ClassName StudentController
 * @Description 表现层（控制层） 接收请求
 * @Author Fan-CUNH
 * @Date 2023/7/4 19:07
 * @Version 1.0
 */

@Controller
public class StudentController {
    @Resource
    private StudentService studentService;

    /**
     * 添加学生
     *
     * @param student 添加的学生信息载体
     */
    @PostMapping("/insert")
    public String insert(Student student, HttpServletRequest request) {
        if(studentService.insert(student)){
            request.setAttribute("msg","添加成功!");
        }else{
            request.setAttribute("msg","添加失败!");
        }
        return "findAll";
    }

    /**
     * 通过学生删除学生
     *
     * @param stuId 学生id
     */
    @GetMapping("/delete")
    public String delete(Integer stuId, HttpServletRequest request) {
        if(studentService.delete(stuId)){
            request.setAttribute("msg","删除成功!");
        }else{
            request.setAttribute("msg","删除失败!");
        }
        return "findAll";
    }

    /**
     * 更新学生
     *
     * @param student 更新学生信息载体
     */
    @PostMapping("/update")
    public String update(Student student, HttpServletRequest request) {
        if(studentService.update(student)){
            request.setAttribute("msg","更新成功!");
        }else{
            request.setAttribute("msg","更新失败!");
        }
        return "findAll";
    }

    @RequestMapping("/find")
    public String findById(Integer stuId, HttpServletRequest request) {
        Student student = studentService.findById(stuId);
        request.setAttribute("student", student);
        return "update.jsp";
    }

    @RequestMapping("/findAll")
    public String findAll(HttpServletRequest request) {
        List<Student> students = studentService.findAll();
        request.setAttribute("students", students);
        return "index.jsp";
    }
}
