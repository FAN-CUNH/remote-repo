package com.fch.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.fch.domain.*;
import com.fch.dto.PageDTO;
import com.fch.mapper.CheckgroupCheckitemMapper;
import com.fch.mapper.CheckgroupMapper;
import com.fch.mapper.SetmealCheckgroupMapper;
import com.fch.result.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @packageName com.fch.service
 * @ClassName CheckGroupServiceImpl
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/10 16:45
 * @Version 1.0
 */
@Service(interfaceClass = CheckGroupService.class)
@Transactional // 开启事务
public class CheckGroupServiceImpl implements CheckGroupService{
    @Resource
    private CheckgroupMapper checkgroupMapper;

    @Resource
    private CheckgroupCheckitemMapper checkgroupCheckitemMapper;

    @Resource
    private SetmealCheckgroupMapper setmealCheckgroupMapper;
    /**
     * 无条件查询所有/通过条件查询检查组
     *
     * @param pageDTO 前端请求参数模型
     * @return 返回检查组分页信息
     */
    @Override
    public PageResult getCheckGroup(PageDTO pageDTO) {
        // 使用Mybatis插件
        Page<Object> page = PageHelper.startPage(pageDTO.getCurrentPage(), pageDTO.getPageSize());

        // 封装查询条件
        CheckgroupExample example = new CheckgroupExample();
        if (StringUtils.hasLength(pageDTO.getQueryString())) {
            example.or().andCodeEqualTo(pageDTO.getQueryString());
            example.or().andNameEqualTo(pageDTO.getQueryString());
            example.or().andMnemonicsEqualTo(pageDTO.getQueryString());
        }
        List<Checkgroup> checkGroups = checkgroupMapper.selectByExample(example);
        return new PageResult(page.getTotal(), checkGroups);
    }

    /**
     * 新增检测组
     *
     * @param checkgroup   检查组参数载体
     * @param checkitemIds 检查项id数组
     * @return 返回新增检查组状态
     */
    @Override
    public boolean add(Checkgroup checkgroup, Integer[] checkitemIds) {
        // 添加检查组
        int add = checkgroupMapper.insertSelective(checkgroup);

        // 添加检查组和检查项的关联关系
        if (checkitemIds != null && checkitemIds.length > 0) {
            Stream.of(checkitemIds).forEach(checkitemId -> {
                CheckgroupCheckitemKey key = new CheckgroupCheckitemKey();
                key.setCheckgroupId(checkgroup.getId());
                key.setCheckitemId(checkitemId);
                checkgroupCheckitemMapper.insertSelective(key);
            });
        }
        return add > 0;
    }

    /**
     * 通过检查组id删除检查组
     * 首先，先确定该检查组id是否与套餐检查组存在关联，若存在则不能删除
     * 其次，不存外键关系时，在删除该检查组的同时也要删除与其关联的所有检查项（即删除关系表中的关系）
     *
     * @param id 检查组id
     * @return 返回删除检查组状态
     */
    @Override
    public boolean deleteById(Integer id) {
        // 查询该id是否存在套餐检查组中 若返回结果大于0，则说明存在记录
        SetmealCheckgroupExample setmealCheckgroupExample = new SetmealCheckgroupExample();
        SetmealCheckgroupExample.Criteria setmealCheckgroupExampleCriteria = setmealCheckgroupExample.createCriteria();
        setmealCheckgroupExampleCriteria.andCheckgroupIdEqualTo(id);
        int count = setmealCheckgroupMapper.countByExample(setmealCheckgroupExample);
        if (count > 0) {
            return false;
        }

        // 先删除关系表
        CheckgroupCheckitemExample checkgroupCheckitemExample = new CheckgroupCheckitemExample();
        CheckgroupCheckitemExample.Criteria checkgroupCheckitemExampleCriteria = checkgroupCheckitemExample.createCriteria();
        checkgroupCheckitemExampleCriteria.andCheckgroupIdEqualTo(id);
        checkgroupCheckitemMapper.deleteByExample(checkgroupCheckitemExample);

        // 再删主表
        return checkgroupMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 通过Id查询检查组
     *
     * @param id 检查组id
     * @return 返回检查组对象
     */
    @Override
    public Checkgroup getCheckGroupById(Integer id) {
        return checkgroupMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过检查组id查询所有已选的检查项id
     *
     * @param id 检查组id
     * @return 返回查询到的检查项id数组
     */
    @Override
    public List<Integer> getCheckItemIdsByCheckGroupId(Integer id) {
        // 封装查询条件
        CheckgroupCheckitemExample checkgroupCheckitemExample = new CheckgroupCheckitemExample();
        CheckgroupCheckitemExample.Criteria checkgroupCheckitemExampleCriteria = checkgroupCheckitemExample.createCriteria();
        checkgroupCheckitemExampleCriteria.andCheckgroupIdEqualTo(id);

        // 执行查询条件
        List<CheckgroupCheckitemKey> checkgroupCheckitemKeys = checkgroupCheckitemMapper.selectByExample(checkgroupCheckitemExample);
        return checkgroupCheckitemKeys.stream()
                .map(CheckgroupCheckitemKey::getCheckitemId)
                .collect(Collectors.toList());
    }

    /**
     * 通过检查组的id更新检查组
     *
     * @param checkgroup   被更新的检查组对象，信息载体
     * @param checkItemIds 被更新检查组中的检查项
     * @return 返回更新状态
     */
    @Override
    public boolean update(Checkgroup checkgroup, Integer[] checkItemIds) {
        // 根据检查组id,删除源检查组与检查项的关系
        CheckgroupCheckitemExample checkgroupCheckitemExample = new CheckgroupCheckitemExample();
        CheckgroupCheckitemExample.Criteria checkgroupCheckitemExampleCriteria = checkgroupCheckitemExample.createCriteria();
        checkgroupCheckitemExampleCriteria.andCheckgroupIdEqualTo(checkgroup.getId());
        checkgroupCheckitemMapper.deleteByExample(checkgroupCheckitemExample);

        // 添加检查组和检查项之间的关系 用checkgroupCheckitemMapper执行insertSelective操作，将checkgroupCheckitemKey插入表中
        if (checkItemIds != null && checkItemIds.length > 0) {
            Stream.of(checkItemIds).forEach(checkgroupId -> {
                CheckgroupCheckitemKey checkgroupCheckitemKey = new CheckgroupCheckitemKey();
                checkgroupCheckitemKey.setCheckitemId(checkgroupId);
                checkgroupCheckitemKey.setCheckgroupId(checkgroup.getId());
                checkgroupCheckitemMapper.insertSelective(checkgroupCheckitemKey);
            });
        }

        // 更新检查组基本信息
        return checkgroupMapper.updateByPrimaryKeySelective(checkgroup) > 0;
    }

    /**
     * 查询所有的检查组
     *
     * @return 返回检查组数组
     */
    @Override
    public List<Checkgroup> getAll() {
        return checkgroupMapper.selectByExample(null);
    }
}
