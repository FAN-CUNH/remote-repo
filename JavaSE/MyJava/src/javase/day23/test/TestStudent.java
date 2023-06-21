package javase.day23.test;

import javase.day23.bean.Student;
import javase.day23.dao.StudentDao;
import javase.day23.dao.implement.StudentDaoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @packageName javase.day23.test
 * @ClassName TestStudent
 * @Description 测试类
 * @Author CunHao Fan
 * @Date 2023/5/15 20:04
 * @Version 1.0
 */
public class TestStudent {
    public static void main(String[] args) {
        /*通过StudentDao的已知实现子类实例化*/
        StudentDao studentDao = new StudentDaoImpl();
        /*删除学生*/
        studentDao.deleteStudent("2");
        /*添加学生*/
        try {
            /*实例化学生对象，并初始化信息*/
            Student student = new Student("4", "麻子", 23, new SimpleDateFormat("yyyy-MM-dd").parse("1998-11-12"));
            studentDao.addStudent(student);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*查询学生信息*/
        Map<String, Object> map = studentDao.selectStudent("2");
        System.out.println(map);
        /*更新学生信息*/
        studentDao.updateStudent("2");
    }
}
