package com.fch.mapper;

import com.fch.bean.Score;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @packageName com.fch.mapper
 * @ClassName ScoreMapper
 * @Description ScoreMapper
 * @Author Fan-CUNH
 * @Date 2023/6/27 11:45
 * @Version 1.0
 */
public interface ScoreMapper {
    /**
     * 查询所有成绩信息，包含学生对象信息 一对一
     *
     * @return 返回成绩对象集合包含学生信息
     */
    List<Score> selectAll();


    /**
     * 插入多个学生成绩
     *
     * @param scores 成绩集合
     */
    void insert(List<Score> scores);

    /**
     * 通过no批量删除成绩
     *
     * @param scoNos 成绩编号集合
     */
    void deleteByScoNos(List<String> scoNos);

    /**
     * 通过学生学号和课程编号查询学生成绩，可以动态查询
     *      当两条件都为null时，查询全部成绩信息
     *      当两个条件任意不为null时，按条件查询信息
     *
     * @param couNo 课程编号
     * @param stuNo 学生学号
     * @return 返回查询到的课程集合
     */
    List<Score> selectByCondition(@Param("couNo") String couNo,@Param("stuNo") String stuNo);
}
