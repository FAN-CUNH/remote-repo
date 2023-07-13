package com.fch.service;

import com.fch.domain.Checkgroup;
import com.fch.dto.PageDTO;
import com.fch.result.PageResult;

import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName CheckGroupService
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/10 16:43
 * @Version 1.0
 */
public interface CheckGroupService {
    /**
     * 无条件查询所有/通过条件查询检查组
     *
     * @param pageDTO 前端请求参数模型
     * @return 返回检查组分页信息
     */
    PageResult getCheckGroup(PageDTO pageDTO);

    /**
     * 新增检测组
     *
     * @param checkgroup 检查组参数载体
     * @param checkitemIds 检查项id数组
     * @return 返回新增检查组状态
     */
    boolean add(Checkgroup checkgroup, Integer[] checkitemIds);

    /**
     * 通过检查组id删除检查组
     *    首先，先确定该检查组id是否与套餐检查组存在关联，若存在则不能删除
     *    其次，不存外键关系时，在删除该检查组的同时也要删除与其关联的所有检查项（即删除关系表中的关系）
     *
     * @param id 检查组id
     * @return 返回删除检查组状态
     */
    boolean deleteById(Integer id);

    /**
     * 通过Id查询检查组
     *
     * @param id 检查组id
     * @return 返回检查组对象
     */
    Checkgroup getCheckGroupById(Integer id);

    /**
     * 通过检查组id查询所有已选的检查项id
     *
     * @param id 检查组id
     * @return 返回查询到的检查项id数组
     */
    List<Integer> getCheckItemIdsByCheckGroupId(Integer id);

    /**
     * 通过检查组的id更新检查组
     *
     * @param checkgroup 被更新的检查组对象，信息载体
     * @param checkItemIds 被更新检查组中的检查项
     * @return 返回更新状态
     */
    boolean update(Checkgroup checkgroup, Integer[] checkItemIds);

    /**
     * 查询所有的检查组
     *
     * @return 返回检查组数组
     */
    List<Checkgroup> getAll();
}
