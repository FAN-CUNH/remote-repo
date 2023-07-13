package com.fch.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.domain.CheckgroupCheckitemExample;
import com.fch.domain.Checkitem;
import com.fch.domain.CheckitemExample;
import com.fch.dto.PageDTO;
import com.fch.exception.BusinessException;
import com.fch.mapper.CheckgroupCheckitemMapper;
import com.fch.mapper.CheckitemMapper;
import com.fch.result.PageResult;
import com.fch.result.Result;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @packageName com.fch.service
 * @ClassName CheckItemServiceImpl
 * @Description 检查项服务接口实现
 * @Author Fan-CUNH
 * @Date 2023/7/9 13:54
 * @Version 1.0
 */

@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Resource
    private CheckitemMapper checkitemMapper;
    @Resource
    private CheckgroupCheckitemMapper checkgroupCheckitemMapper;

    /**
     * @param pageDTO 封装的页面DTO接收前端参数
     * @return 返回页面
     */
    @Override
    public PageResult getAll(PageDTO pageDTO) {
        // Mybatis分页插件
        Page<Object> page = PageHelper.startPage(pageDTO.getCurrentPage(), pageDTO.getPageSize());

        // 封装查询条件
        CheckitemExample example = new CheckitemExample();
        if (StringUtils.hasLength(pageDTO.getQueryString())) {
            example.or().andCodeEqualTo(pageDTO.getQueryString());
            example.or().andNameEqualTo(pageDTO.getQueryString());
        }
        List<Checkitem> list = checkitemMapper.selectByExample(example);
        return new PageResult(page.getTotal(), list);
    }

    /**
     * 新增检查项
     *
     * @param checkitem 新增检查项参数载体
     * @return 新增状态 成功/失败
     */
    @Override
    public boolean addCheckItem(Checkitem checkitem) {
        return checkitemMapper.insertSelective(checkitem) > 0;
    }

    /**
     * 通过主键查询检查项
     *
     * @param id 检查项主键 ID
     * @return 检查项对象
     */
    @Override
    public Checkitem getById(Integer id) {
        return checkitemMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新检查项
     *
     * @param checkitem 检查项信息载体
     * @return 更新状态
     */
    @Override
    public boolean update(Checkitem checkitem) {
        return checkitemMapper.updateByPrimaryKeySelective(checkitem) > 0;
    }

    /**
     * 通过id删除检查项, 先判断checkItem是否和checkGroupCheckitem表关联 若关联则不删除
     *
     * @param id 检测项id
     * @return 删除状态
     */
    @Override
    public boolean deleteById(Integer id) {
        // 封装条件
        CheckgroupCheckitemExample example = new CheckgroupCheckitemExample();
        CheckgroupCheckitemExample.Criteria criteria = example.createCriteria();
        // 根据检查项的主键在中间表查询
        criteria.andCheckitemIdEqualTo(id);
        int count = checkgroupCheckitemMapper.countByExample(example);
        if (count > 0) {
            return false;
        }
        return checkitemMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 查询所有检查项，封装到同意响应类中
     *
     * @return 所有检查项
     */
    @Override
    public List<Checkitem> getAllCheckItem() {
        return checkitemMapper.selectByExample(null);
    }
}
