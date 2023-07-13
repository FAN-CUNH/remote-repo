package com.fch.mapper;

import com.fch.domain.Checkitem;
import com.fch.domain.CheckitemExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckitemMapper {
    int countByExample(CheckitemExample example);

    int deleteByExample(CheckitemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Checkitem record);

    int insertSelective(Checkitem record);

    List<Checkitem> selectByExample(CheckitemExample example);

    Checkitem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Checkitem record, @Param("example") CheckitemExample example);

    int updateByExample(@Param("record") Checkitem record, @Param("example") CheckitemExample example);

    int updateByPrimaryKeySelective(Checkitem record);

    int updateByPrimaryKey(Checkitem record);
}