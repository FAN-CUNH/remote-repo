package com.fch.mapper;

import com.fch.bean.Score;

import java.util.List;

/**
 * @packageName com.fch.mapper
 * @ClassName ScoreMapper
 * @Description TODO
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
}
