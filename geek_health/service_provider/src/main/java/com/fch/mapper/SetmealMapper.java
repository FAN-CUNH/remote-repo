package com.fch.mapper;

import com.fch.domain.Checkgroup;
import com.fch.domain.Checkitem;
import com.fch.domain.Setmeal;
import com.fch.domain.SetmealExample;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface SetmealMapper {
    int countByExample(SetmealExample example);

    int deleteByExample(SetmealExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Setmeal record);

    int insertSelective(Setmeal record);

    List<Setmeal> selectByExample(SetmealExample example);

    Setmeal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Setmeal record, @Param("example") SetmealExample example);

    int updateByExample(@Param("record") Setmeal record, @Param("example") SetmealExample example);

    int updateByPrimaryKeySelective(Setmeal record);

    int updateByPrimaryKey(Setmeal record);

    @Select("select * from setmeal where setmeal.id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "checkgroups", column = "id", javaType = List.class, many = @Many(select = "getCheckgroupBySetmealId"))
    })
    Setmeal getSetmealMessById(Integer id);

    @Select("select * from checkgroup where checkgroup.id in (select checkgroup_id from setmeal_checkgroup where setmeal_id = #{setmealId})")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(property = "checkitems", column = "id", javaType = List.class, many = @Many(select = "getCheckitemByCheckgroupId"))
    })
    List<Checkgroup> getCheckgroupBySetmealId(Integer setmealId);

    @Select("select * from checkitem where checkitem.id in (select checkitem_id from checkgroup_checkitem where checkgroup_id = #{CheckgroupId})")
    List<Checkitem> getCheckitemByCheckgroupId(Integer CheckgroupId);

    @Select("select setmeal.name, count(orders.id) value from setmeal, orders where setmeal.id = orders.setmeal_id group by setmeal_id")
    List<Map<String, Object>> getSetmealCountById();

    @Select("select setmeal.name, count(orders.id) setmeal_count, count(orders.id)/(select count(0) from orders ) proportion from setmeal, orders where setmeal.id = orders.setmeal_id group by setmeal.id order by setmeal_count desc limit 0, 4")
    List<Map<String, Object>> getHotSetmeal();
}