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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
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

    @Resource
    private TemplateEngine templateEngine;

    @Value("${OUTPUT_PATH}")
    private String OUTPUT_PATH;

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
        setSetmealAndCheckgroupContact(setmeal, checkGroupIds);

        // 添加数据后重新生成静态页面（包含套餐列表页面，以及套餐详情页面）
        generateMobileStaticHtml();
        return add > 0;
    }

    /**
     * 生成静态页面
     */
    private void generateMobileStaticHtml() {
        // 获取更新后的数据
        List<Setmeal> setmealList = this.findAll();

        // 生成套餐列表静态页面（单个）
        generateStaticMobileSetmealListHtml(setmealList);

        // 生成套餐详情静态页面（多个）
        generateStaticMobileSetmealDetailHtml(setmealList);
    }

    /**
     * 通过遍历套餐列表数据获取每一个套餐详情数据生成静态套餐详情页面
     *
     * @param setmealList 套餐列表数据
     */
    private void generateStaticMobileSetmealDetailHtml(List<Setmeal> setmealList) {
        setmealList.forEach(setmeal -> {
            HashMap<String, Object> map = new HashMap<>(16);
            map.put("setmeal", this.getSetmealMessById(setmeal.getId()));
            this.generateHtml("mobile_setmeal_detail.html", "setmeal_detail_" + setmeal.getId() + ".html", map);
        });
    }

    /**
     * 生成静态移动端套餐详情页面
     *
     * @param setmealList 套餐列表数据
     */
    private void generateStaticMobileSetmealListHtml(List<Setmeal> setmealList) {
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("setmealList", setmealList);
        this.generateHtml("mobile_setmeal.html", "m_setmeal.html", map);
    }

    /**
     * 生成静态页面方法
     *
     * @param templateName 模版名称
     * @param pageName 页面名称
     * @param map 需要渲染到页面中的数据
     */
    private void generateHtml(String templateName, String pageName, HashMap<String, Object> map) {
        // 声明写出流
        PrintWriter printWriter = null;
        // 创建thymeleaf上下文对象
        Context context = new Context();
        // 将数据 map 放入上下文中
        context.setVariable("map", map);
        // 创建写出流
        try {
            printWriter = new PrintWriter(OUTPUT_PATH + "/" + pageName);

            // 执行页面静态化方法
            templateEngine.process(templateName, context, printWriter);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

    /**
     * 设置套餐与检查组的一对多关系
     *
     * @param setmeal       套餐信息
     * @param checkGroupIds 检查组id数组
     */
    private void setSetmealAndCheckgroupContact(Setmeal setmeal, Integer[] checkGroupIds) {
        if (checkGroupIds != null && checkGroupIds.length > 0) {
            Stream.of(checkGroupIds).forEach(checkGroupId -> {
                SetmealCheckgroupKey setmealCheckgroupKey = new SetmealCheckgroupKey();
                setmealCheckgroupKey.setCheckgroupId(checkGroupId);
                setmealCheckgroupKey.setSetmealId(setmeal.getId());
                setmealCheckgroupMapper.insertSelective(setmealCheckgroupKey);
            });
        }
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
        this.setSetmealAndCheckgroupContact(setmeal, checkGroupIds);

        boolean flag = (setmealMapper.updateByPrimaryKeySelective(setmeal) > 0);

        // 更新数据后重新生成静态页面（包含套餐列表页面，以及套餐详情页面）
        this.generateMobileStaticHtml();

        // 更新
        return flag;

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
        boolean flag = (setmealMapper.deleteByPrimaryKey(id) > 0);

        // 删除数据后重新生成静态页面（包含套餐列表页面，以及套餐详情页面）
        this.generateMobileStaticHtml();


        return flag;
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

    /**
     * 通过id查询套餐详情 （包含套餐信息，检查组信息以及检查项信息）
     *
     * @param id 套餐id
     * @return 返回套餐详情
     */
    @Override
    public Setmeal getSetmealMessById(Integer id) {
        return setmealMapper.getSetmealMessById(id);
    }
}
