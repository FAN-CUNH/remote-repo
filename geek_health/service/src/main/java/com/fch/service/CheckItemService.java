package com.fch.service;

import com.fch.domain.Checkitem;
import com.fch.dto.PageDTO;
import com.fch.result.PageResult;

import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName CheckItemService
 * @Description 检查项接口
 * @Author Fan-CUNH
 * @Date 2023/7/9 13:51
 * @Version 1.0
 */
public interface CheckItemService {
    /**
     * @param pageDTO 封装的页面DTO接收前端参数
     * @return 返回页面
     */
    PageResult getAll(PageDTO pageDTO);

    /**
     * 新增检查项
     *
     * @param checkitem 新增检查项参数载体
     * @return 新增状态 成功/失败
     */
    boolean addCheckItem(Checkitem checkitem);

    /**
     * 通过主键查询检查项
     *
     * @param id 检查项主键 ID
     * @return 检查项对象
     */
    Checkitem getById(Integer id);

    /**
     * 更新检查项
     *
     * @param checkitem 检查项信息载体
     * @return 更新状态
     */
    boolean update(Checkitem checkitem);

    /**
     * 通过id删除检查项
     *
     * @param id 检测项id
     * @return 删除状态
     */
    boolean deleteById(Integer id);

    /**
     * 查询所有检查项，封装到同意响应类中
     *
     * @return 所有检查项
     */
    List<Checkitem> getAllCheckItem();
}
