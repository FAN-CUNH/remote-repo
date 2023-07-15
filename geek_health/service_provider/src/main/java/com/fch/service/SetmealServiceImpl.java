package com.fch.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.fch.constant.RedisConstant;
import com.fch.domain.Setmeal;
import com.fch.domain.SetmealCheckgroupExample;
import com.fch.domain.SetmealCheckgroupKey;
import com.fch.domain.SetmealExample;
import com.fch.dto.PageDTO;
import com.fch.mapper.SetmealCheckgroupMapper;
import com.fch.mapper.SetmealMapper;
import com.fch.result.PageResult;
import com.fch.utils.QiNiuUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @packageName com.fch.service
 * @ClassName SetmealServiceImpl
 * @Description 套餐接口实现
 * @Author Fan-CUNH
 * @Date 2023/7/11 18:33
 * @Version 1.0
 */
@Service(interfaceClass = SetmealService.class)
@Transactional
public class SetmealServiceImpl implements SetmealService {
    @Resource
    private SetmealMapper setmealMapper;

    @Resource
    private SetmealCheckgroupMapper setmealCheckgroupMapper;

    @Resource
    private JedisPool jedisPool;

    /**
     * 新增套餐
     *
     * @param setmeal       套餐对象
     * @param checkGroupIds 检查组id数组
     * @return 新增套餐状态 -> 是否成功
     */
    @Override
    public boolean addSetmeal(Setmeal setmeal, Integer[] checkGroupIds) {
        // 添加套餐信息
        int add = setmealMapper.insertSelective(setmeal);

        // 添加图片至redis
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, setmeal.getImg());

        // 设置套餐和检查组的联系
        if (checkGroupIds != null && checkGroupIds.length > 0) {
            Stream.of(checkGroupIds).forEach(checkGroupId -> {
                SetmealCheckgroupKey setmealCheckgroupKey = new SetmealCheckgroupKey();
                setmealCheckgroupKey.setCheckgroupId(checkGroupId);
                setmealCheckgroupKey.setSetmealId(setmeal.getId());
                setmealCheckgroupMapper.insertSelective(setmealCheckgroupKey);
            });
        }
        return add > 0;
    }

    /**
     * 分页查询
     *
     * @param pageDTO 前端分页请求参数
     * @return 返回一个分页对象
     */
    @Override
    public PageResult getPage(PageDTO pageDTO) {
        // 分页插件
        try (Page<Setmeal> page = PageHelper.startPage(pageDTO.getCurrentPage(), pageDTO.getPageSize())) {
            // 封装查询条件
            SetmealExample setmealExample = new SetmealExample();
            // 查询条件
            String queryString = pageDTO.getQueryString();
            if (queryString != null && queryString.length() > 0) {
                setmealExample.or().andCodeEqualTo(queryString);
                setmealExample.or().andNameEqualTo(queryString);
                setmealExample.or().andMnemonicsEqualTo(queryString);
            }

            // 查询检查项列表 如果queryString不为空则传入条件，如果为空，则传入null
            List<Setmeal> setmeals = setmealMapper.selectByExample(setmealExample);
            return new PageResult(page.getTotal(), setmeals);
        }
    }

    /**
     * 通过id查询套餐信息
     *
     * @param id Integer 套餐id
     * @return 套餐对象
     */
    @Override
    public Setmeal getSetmealById(Integer id) {
        return setmealMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过套餐id查询检查组id集合
     *
     * @param id 套餐id
     * @return 返回与套餐关联的检查组id集合
     */
    @Override
    public List<Integer> getCheckGroupBySetmealId(Integer id) {
        // 封装查询条件
        SetmealCheckgroupExample setmealCheckgroupExample = new SetmealCheckgroupExample();
        SetmealCheckgroupExample.Criteria setmealCheckgroupExampleCriteria = setmealCheckgroupExample.createCriteria();
        setmealCheckgroupExampleCriteria.andSetmealIdEqualTo(id);

        // 查询
        List<SetmealCheckgroupKey> setmealCheckgroupKeys = setmealCheckgroupMapper.selectByExample(setmealCheckgroupExample);

        return setmealCheckgroupKeys.stream().map(SetmealCheckgroupKey::getCheckgroupId).collect(Collectors.toList());
    }

    /**
     * 更新套餐信息
     *
     * @param setmeal       套餐信息载体
     * @param checkGroupIds 与套餐关联的检查组id数组
     * @return 返回更新的状态
     */
    @Override
    public boolean update(Setmeal setmeal, Integer[] checkGroupIds) {
        // 添加图片至redis
        jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_DB_RESOURCES, setmeal.getImg());

        // 删除套餐与关联的检查组中间表数据
        SetmealCheckgroupExample setmealCheckgroupExample = new SetmealCheckgroupExample();
        SetmealCheckgroupExample.Criteria setmealCheckgroupExampleCriteria = setmealCheckgroupExample.createCriteria();
        setmealCheckgroupExampleCriteria.andSetmealIdEqualTo(setmeal.getId());
        setmealCheckgroupMapper.deleteByExample(setmealCheckgroupExample);

        // 建立新的套餐与检查组之间的关系
        if (checkGroupIds != null && checkGroupIds.length > 0) {
            Stream.of(checkGroupIds).forEach(c -> {
                SetmealCheckgroupKey setmealCheckgroupKey = new SetmealCheckgroupKey();
                setmealCheckgroupKey.setSetmealId(setmeal.getId());
                setmealCheckgroupKey.setCheckgroupId(c);
                setmealCheckgroupMapper.insertSelective(setmealCheckgroupKey);
            });
        }

        // 更新
        return setmealMapper.updateByPrimaryKeySelective(setmeal) > 0;
    }

    /**
     * 通过套餐ID删除套餐
     *
     * @param id 套餐id
     * @return 返回删除状态
     */
    @Override
    public boolean deleteSetmealById(Integer id) {
        // 先删除关系表
        SetmealCheckgroupExample setmealCheckgroupExample = new SetmealCheckgroupExample();
        SetmealCheckgroupExample.Criteria setmealCheckgroupExampleCriteria = setmealCheckgroupExample.createCriteria();
        setmealCheckgroupExampleCriteria.andSetmealIdEqualTo(id);
        setmealCheckgroupMapper.deleteByExample(setmealCheckgroupExample);

        // 通过id查询图片名称
        Setmeal setmeal = setmealMapper.selectByPrimaryKey(id);

        // 删除存储在redis和七牛云中的图片
        if (setmeal.getImg() != null && setmeal.getImg().length() > 0) {
            QiNiuUtil.deleteFromQiNiu(setmeal.getImg());
            jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_DB_RESOURCES, setmeal.getImg());
        }

        // 再删主表
        return setmealMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 查询所有套餐数据
     *
     * @return 所有套餐数据集合
     */
    @Override
    public List<Setmeal> findAll() {
        return setmealMapper.selectByExample(null);
    }
}
