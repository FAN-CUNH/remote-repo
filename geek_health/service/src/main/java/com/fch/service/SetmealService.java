package com.fch.service;


import com.fch.domain.Setmeal;
import com.fch.dto.PageDTO;
import com.fch.result.PageResult;

import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName SetmealService
 * @Description 套餐接口层
 * @Author Fan-CUNH
 * @Date 2023/7/11 18:31
 * @Version 1.0
 */
public interface SetmealService {
    /**
     * 新增套餐
     *
     * @param setmeal 套餐对象
     * @param checkGroupIds 检查组id数组
     * @return 新增套餐状态 -> 是否成功
     */
    boolean addSetmeal(Setmeal setmeal, Integer[] checkGroupIds);

    /**
     * 分页查询
     *
     * @param pageDTO 前端分页请求参数
     * @return 返回一个分页对象
     */
    PageResult getPage(PageDTO pageDTO);

    /**
     * 通过id查询套餐信息
     *
     * @param id Integer 套餐id
     * @return 套餐对象
     */
    Setmeal getSetmealById(Integer id);

    /**
     * 通过套餐id查询检查组id集合
     *
     * @param id 套餐id
     * @return 返回与套餐关联的检查组id集合
     */
    List<Integer> getCheckGroupBySetmealId(Integer id);

    /**
     * 更新套餐信息
     *
     * @param setmeal 套餐信息载体
     * @param checkGroupIds 与套餐关联的检查组id数组
     * @return 返回更新的状态
     */
    boolean update(Setmeal setmeal, Integer[] checkGroupIds);

    /**
     * 通过套餐ID删除套餐
     *
     * @param id 套餐id
     * @return 返回删除状态
     */
    boolean deleteSetmealById(Integer id);
}
