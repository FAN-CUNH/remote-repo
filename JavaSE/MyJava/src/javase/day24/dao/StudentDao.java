package javase.day24.dao;

import javase.day24.entity.Student;

import java.util.Map;

/**
 * @packageName javase.day24.dao
 * @ClassName StudentDao
 * @Description 数据访问层的抽象方法
 * @Author CunHao Fan
 * @Date 2023/5/16 12:51
 * @Version 1.0
 */
public interface StudentDao {

    /**
     * 根据学生学号查询学生全部信息包含选课信息
     * @param stuNo 学生学号
     * @return 查询到的学生对象 学生对象中包含课程对象集合
     */
    public Student getStudent(String stuNo);

    /**
     * 根据学生学号查询学生信息并获取该学生选择的第一门课程信息
     * @param stuNo 学生学号
     * @return 返回学生对象 学生对象中包含课程对象
     */
    public Student getStudentAndGetOneCourse(String stuNo);

    /**
     * 根据学生学号查询所有学生信息集合课程信息
     * @return 返回一个map集合 键为学号，值为学生对象（学生对象包含课程信息）
     */
    public Map<String, Student> getStudentAndCourseAllMess();
}
