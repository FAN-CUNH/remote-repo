package com.fch.mapper;

import com.fch.domain.CheckgroupCheckitemExample;
import com.fch.domain.CheckgroupCheckitemKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckgroupCheckitemMapper {
    int countByExample(CheckgroupCheckitemExample example);

    int deleteByExample(CheckgroupCheckitemExample example);

    int deleteByPrimaryKey(CheckgroupCheckitemKey key);

    int insert(CheckgroupCheckitemKey record);

    int insertSelective(CheckgroupCheckitemKey record);

    List<CheckgroupCheckitemKey> selectByExample(CheckgroupCheckitemExample example);

    int updateByExampleSelective(@Param("record") CheckgroupCheckitemKey record, @Param("example") CheckgroupCheckitemExample example);

    int updateByExample(@Param("record") CheckgroupCheckitemKey record, @Param("example") CheckgroupCheckitemExample example);
}