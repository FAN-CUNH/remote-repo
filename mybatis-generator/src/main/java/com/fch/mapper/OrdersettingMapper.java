package com.fch.mapper;

import com.fch.domain.Ordersetting;
import com.fch.domain.OrdersettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrdersettingMapper {
    int countByExample(OrdersettingExample example);

    int deleteByExample(OrdersettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ordersetting record);

    int insertSelective(Ordersetting record);

    List<Ordersetting> selectByExample(OrdersettingExample example);

    Ordersetting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ordersetting record, @Param("example") OrdersettingExample example);

    int updateByExample(@Param("record") Ordersetting record, @Param("example") OrdersettingExample example);

    int updateByPrimaryKeySelective(Ordersetting record);

    int updateByPrimaryKey(Ordersetting record);
}