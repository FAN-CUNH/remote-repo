package com.fch.mapper;

import com.fch.bean.Student;

import java.util.List;

/**
 * @packageName com.fch.mapper
 * @ClassName StudentMapper
 * @Description Mapper层
 * @Author Fan-CUNH
 * @Date 2023/6/26 16:28
 * @Version 1.0
 */
public interface StudentMapper {


    /**
     * 查询所有的学生信息, 并根据排序字段进行排序
     *
     * @param sortByThing 排序规则 根据任何字段排序均可
     * @return 返回所有学生对象结合
     */
    List<Student> selectAllStudent(String sortByThing);

    /**
     * 通过学生学号查询学生信息
     *
     * @param stuNo 学生学号
     * @return 返回单个学生对象
     */
    Student selectByStuNo(String stuNo);

    /**
     * 新增学生信息
     *
     * @param student 新增学生信息载体
     */
    void insertStudent(Student student);

    /**
     * 根据学生学号删除学生信息
     *
     * @param stuNo 学生学号
     */
    void deleteByStuNo(String stuNo);

    /**
     * 根据学生学号更新学生信息
     *
     * @param student 学生学号
     */
    void updateByStuNo(Student student);

    /**
     * 查询所有学生信息包含分数信息
     *
     * @return 返回学生对象结合
     */
    List<Student> selectAllMess();
}
