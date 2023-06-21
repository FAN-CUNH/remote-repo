package javase.day23.service;

import javase.day23.bean.Student;

/**
 * @packageName javase.day23.service
 * @ClassName StudentService
 * @Description 业务逻辑层
 * @Author CunHao Fan
 * @Date 2023/5/15 15:11
 * @Version 1.0
 */
public interface StudentService {

    /**
     * 添加学生
     * @param student 被添加的学生对象
     */
    public void addStudent(Student student);


    /**
     * 根据学号删除学生信息
     * @param stuNo 学号
     */
    public void deleteStudent(String stuNo);


    /**
     * 更新学生信息
     * @param student 被更新的学生对象
     */
    public void updateStudent(Student student);


    /**
     * 根据学号查询学生
     * @param stuNo 学号
     */
    public void selectStudent(String stuNo);
}
