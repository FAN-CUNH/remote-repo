package com.fch.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.constant.RedisConstant;
import com.fch.domain.Setmeal;
import com.fch.dto.PageDTO;
import com.fch.exception.BusinessException;
import com.fch.result.PageResult;
import com.fch.result.Result;
import com.fch.service.SetmealService;
import com.fch.utils.QiNiuUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @packageName com.fch.controller
 * @ClassName SetmealController
 * @Description 套餐表现层 套餐管理
 * @Author Fan-CUNH
 * @Date 2023/7/11 18:27
 * @Version 1.0
 */
@Slf4j
// REST 风格
@RestController
// 窄化请求路径
@RequestMapping("/setmeal")
public class SetmealController {
    @Reference
    private SetmealService setmealService;

    @Resource
    private JedisPool jedisPool;

    /**
     * 套餐图片上传
     *
     * @param multipartFile 多部件解析器 文件上传
     * @return 返回统一返回结果
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("upload")
    public Result upload(@RequestPart(value = "imgFile") MultipartFile multipartFile) {
        log.info("上传图片文件 参数：{}", multipartFile.toString());
        // 获取源文件名
        String originalFilename = multipartFile.getOriginalFilename();
        // 构建新文件名
        if (originalFilename != null && originalFilename.length() > 0) {
            String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
            log.info("上传的文件名：{}", fileName);
            try {
                // 上传文件至七牛云
                String imgUrl = QiNiuUtil.uploadForQiNiu(multipartFile.getInputStream(), fileName);
                // 上传文件至redis
                jedisPool.getResource().sadd(RedisConstant.SETMEAL_PIC_RESOURCES, imgUrl);

                return new Result(Code.SAVE_OK, Msg.PIC_UPLOAD_SUCCESS, imgUrl);
            } catch (IOException e) {
                log.error("异常信息：{}", e.getMessage());
                throw new BusinessException(Code.BUSINESS_ERR, Msg.PIC_UPLOAD_FAIL);
            }
        }
        return new Result(Code.SAVE_ERR, Msg.PIC_UPLOAD_FAIL);
    }

    /**
     * 新增套餐
     *
     * @param setmeal 套餐对象
     * @param checkGroupIds 检查组id数组
     * @return 统一响应数据
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add")
    public Result addSetmeal(@RequestBody Setmeal setmeal, @RequestParam("checkGroupIds") Integer[] checkGroupIds) {
        log.info("新增套餐 参数：{}，{}", setmeal, checkGroupIds);
        boolean flag = setmealService.addSetmeal(setmeal, checkGroupIds);
        log.info("新增套餐 结果：{}", flag);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR, flag?Msg.ADD_SETMEAL_SUCCESS:Msg.ADD_SETMEAL_FAIL);
    }

    /**
     * 分页查询
     *
     * @param pageDTO 前端分页请求参数
     * @return 返回一个分页对象
     */
    @GetMapping("findPage")
    public PageResult getPage(PageDTO pageDTO) {
        log.info("套餐分页查询 参数：{}", pageDTO);
        return setmealService.getPage(pageDTO);
    }

    /**
     * 通过id查询套餐信息
     *
     * @param id Integer 套餐id
     * @return 统一响应结果
     */
    @GetMapping("{id}")
    public Result getSetmealById(@PathVariable("id") Integer id) {
        log.info("通过id获取套餐基本信息 参数：{}", id);
        Setmeal setmeal = setmealService.getSetmealById(id);
        log.info("通过id获取套餐基本信息 结果:{}", setmeal);
        return new Result(setmeal != null ? Code.GET_OK: Code.GET_ERR, setmeal != null ? Msg.QUERY_SETMEAL_SUCCESS : Msg.QUERY_SETMEAL_FAIL, setmeal);
    }

    /**
     * 通过套餐id查询检查组id集合
     *
     * @param id 套餐id
     * @return 返回与套餐关联的检查组id集合
     */
    @GetMapping("getCheckGroupBySetmealId/{id}")
    public Result getCheckGroupBySetmealId(@PathVariable("id") Integer id) {
        log.info("获取套餐中的检查组 参数：{}", id);
        List<Integer> checkGroupIds = setmealService.getCheckGroupBySetmealId(id);
        log.info("获取套餐中的检查组 结果：{}", checkGroupIds);
        if (checkGroupIds != null && checkGroupIds.size() > 0) {
            return new Result(Code.GET_OK, Msg.QUERY_CHECKGROUP_SUCCESS, checkGroupIds);
        }
        return new Result(Code.GET_ERR, Msg.QUERY_CHECKGROUP_FAIL);
    }

    /**
     * 更新套餐信息
     *
     * @param setmeal 套餐信息载体
     * @param checkGroupIds 与套餐关联的检查组id
     * @return 返回统一响应结果
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update")
    public Result update(@RequestBody Setmeal setmeal, @RequestParam("checkGroupIds") Integer[] checkGroupIds) {
        log.info("更新套餐 参数：{}, {}", setmeal, checkGroupIds);
        boolean flag = setmealService.update(setmeal, checkGroupIds);
        log.info("更新套餐 状态：{}", flag);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR, flag?Msg.EDIT_SETMEAL_SUCCESS:Msg.EDIT_SETMEAL_FAIL);
    }

    /**
     * 通过套餐ID删除套餐
     *
     * @param id 套餐id
     * @return 返回统一响应结果
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public Result deleteSetmealById(@PathVariable("id") Integer id) {
        log.info("通过套餐id删除套餐 参数：{}", id);
        boolean flag = setmealService.deleteSetmealById(id);
        log.info("通过套餐id删除套餐 状态：{}", flag);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag ? Msg.DELETE_SETMEAL_SUCCESS : Msg.DELETE_SETMEAL_FAIL);
    }
}