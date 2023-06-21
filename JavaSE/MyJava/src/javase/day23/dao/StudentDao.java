package javase.day23.dao;

import javase.day23.bean.Student;
import javase.day23.service.StudentService;

import java.util.Map;

/**
 * @packageName javase.day23.dao
 * @ClassName StudentDao
 * @Description 数据访问层
 * @Author CunHao Fan
 * @Date 2023/5/15 15:35
 * @Version 1.0
 */
public interface StudentDao {
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
     * @param stuNo 被更新的学生学号
     */
    public void updateStudent(String stuNo);


    /**
     * 根据学号查询学生
     * @param stuNo 学生
     * @return 返回一个Map集合，存放学生信息的键值对
     */
    public Map<String, Object> selectStudent(String stuNo);
}
