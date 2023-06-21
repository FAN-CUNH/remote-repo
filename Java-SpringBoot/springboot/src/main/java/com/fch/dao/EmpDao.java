package com.fch.dao;

import com.fch.pojo.Emp;

import java.util.List;

/**
 * @packageName com.fch.dao
 * @ClassName EmpDao
 * @Description 数据访问层接口
 * @Author CunHao Fan
 * @Date 2023/6/3 17:45
 * @Version 1.0
 */
public interface EmpDao {

    /**
     * 获取员工列表数据
     *
     * @return 员工数据集合
     */
    public List<Emp> listEmp();
}
