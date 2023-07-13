package com.fch.mapper;

import com.fch.domain.SetmealCheckgroupExample;
import com.fch.domain.SetmealCheckgroupKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SetmealCheckgroupMapper {
    int countByExample(SetmealCheckgroupExample example);

    int deleteByExample(SetmealCheckgroupExample example);

    int deleteByPrimaryKey(SetmealCheckgroupKey key);

    int insert(SetmealCheckgroupKey record);

    int insertSelective(SetmealCheckgroupKey record);

    List<SetmealCheckgroupKey> selectByExample(SetmealCheckgroupExample example);

    int updateByExampleSelective(@Param("record") SetmealCheckgroupKey record, @Param("example") SetmealCheckgroupExample example);

    int updateByExample(@Param("record") SetmealCheckgroupKey record, @Param("example") SetmealCheckgroupExample example);
}