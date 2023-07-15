package com.fch.mapper;

import com.fch.domain.RoleMenuExample;
import com.fch.domain.RoleMenuKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {
    int countByExample(RoleMenuExample example);

    int deleteByExample(RoleMenuExample example);

    int deleteByPrimaryKey(RoleMenuKey key);

    int insert(RoleMenuKey record);

    int insertSelective(RoleMenuKey record);

    List<RoleMenuKey> selectByExample(RoleMenuExample example);

    int updateByExampleSelective(@Param("record") RoleMenuKey record, @Param("example") RoleMenuExample example);

    int updateByExample(@Param("record") RoleMenuKey record, @Param("example") RoleMenuExample example);
}