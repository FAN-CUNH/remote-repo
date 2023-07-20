package com.fch.mapper;

import com.fch.domain.User;
import com.fch.domain.UserExample;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from user where username = #{username}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "id", property = "roles", javaType = List.class,
                    many = @Many(select = "com.fch.mapper.RoleMapper.selectRolesByUserId"))
    })
    User selectUserByUsername(String username);
}