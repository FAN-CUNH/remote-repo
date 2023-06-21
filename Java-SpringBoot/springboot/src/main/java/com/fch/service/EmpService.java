package com.fch.service;

import com.fch.pojo.Emp;

import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName EmpService
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/3 17:54
 * @Version 1.0
 */
public interface EmpService {
    /**
     * 获取员工列表数据
     *
     * @return 员工数据集合
     */
    public List<Emp> empList();
}
