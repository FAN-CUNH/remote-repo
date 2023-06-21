package javase.day24.service;

import javase.day24.dao.StudentDao;
import javase.day24.dao.StudentDaoImpl;
import javase.day24.entity.Student;

import java.util.Map;

/**
 * @packageName javase.day24.service
 * @ClassName StudentService
 * @Description 对学生对象进行一些操作
 * @Author CunHao Fan
 * @Date 2023/5/16 12:50
 * @Version 1.0
 */
public class StudentService {

    /**
     * 声明被调用接口StudentDao
     */
    StudentDao studentDao = null;

    /**
     * 本类的构造方法，本类被实例化的同时，StudentDao也通过其已知实现子类实例化
     */
    public StudentService() {
        studentDao = new StudentDaoImpl();
    }

    /**
     * 根据学生学号查询学生全部信息包含选课信息
     *
     * @param stuNo 学生学号
     * @return 查询到的学生对象 学生对象中包含课程对象集合
     */
    public Student getStudent(String stuNo){
        return studentDao.getStudent(stuNo);
    }

    /**
     * 根据学生学号查询学生信息并获取该学生选择的第一门课程信息
     *
     * @param stuNo 学生学号
     * @return 返回学生对象 学生对象中包含课程对象
     */
    public Student getStudentAndGetOneCourse(String stuNo) {
        return studentDao.getStudentAndGetOneCourse(stuNo);
    }

    /**
     * 根据学生学号查询所有学生信息集合课程信息
     *
     * @return 返回一个map集合 键为学号，值为学生对象（学生对象包含课程信息）
     */
    public Map<String, Student> getStudentAndCourseAllMess() {
        return studentDao.getStudentAndCourseAllMess();
    }
}
