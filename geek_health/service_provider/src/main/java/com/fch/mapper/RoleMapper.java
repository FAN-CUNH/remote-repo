package com.fch.mapper;

import com.fch.domain.Role;
import com.fch.domain.RoleExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {
    int countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    @Select("select * from role where id = #{userId}")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "permissions", javaType = List.class,
            many = @Many(select = "com.fch.mapper.PermissionMapper.selectPermissionsByRoleId"))
    })
    List<Role> selectRolesByUserId(Integer userId);
}