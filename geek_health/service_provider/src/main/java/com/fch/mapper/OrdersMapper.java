package com.fch.mapper;

import com.fch.domain.Orders;
import com.fch.domain.OrdersExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrdersMapper {
    int countByExample(OrdersExample example);

    int deleteByExample(OrdersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Orders record);

    int insertSelective(Orders record);

    List<Orders> selectByExample(OrdersExample example);

    Orders selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByExample(@Param("record") Orders record, @Param("example") OrdersExample example);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);

    @Select("select m.name 'member' ,s.name 'setmeal',o.order_date ordersDate, o.order_type ordersType" +
            "  from\n" +
            "  orders o,\n" +
            "  member m,\n" +
            "  setmeal s\n" +
            "  where o.member_id=m.id and o.setmeal_id=s.id and o.id=#{id}")
    Map<String, Object> selectByOrdersId(Integer id);
}