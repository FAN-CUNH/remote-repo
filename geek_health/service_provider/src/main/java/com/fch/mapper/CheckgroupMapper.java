package com.fch.mapper;

import com.fch.domain.Checkgroup;
import com.fch.domain.CheckgroupExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckgroupMapper {
    int countByExample(CheckgroupExample example);

    int deleteByExample(CheckgroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Checkgroup record);

    int insertSelective(Checkgroup record);

    List<Checkgroup> selectByExample(CheckgroupExample example);

    Checkgroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Checkgroup record, @Param("example") CheckgroupExample example);

    int updateByExample(@Param("record") Checkgroup record, @Param("example") CheckgroupExample example);

    int updateByPrimaryKeySelective(Checkgroup record);

    int updateByPrimaryKey(Checkgroup record);
}