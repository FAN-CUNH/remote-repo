package com.fch.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.domain.Checkitem;
import com.fch.dto.PageDTO;
import com.fch.result.PageResult;
import com.fch.result.Result;
import com.fch.service.CheckItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @packageName com.fch.controller
 * @ClassName CheckItemController
 * @Description 检查项控制层
 * @Author Fan-CUNH
 * @Date 2023/7/9 13:45
 * @Version 1.0
 */
@Slf4j
@RestController // REST风格
@RequestMapping("/checkitem")
public class CheckItemController {
    // 服务消费方，通过Dubbo的RPC远程服务调用
    @Reference
    private CheckItemService checkItemService;

    @GetMapping("getAll")
    public PageResult getAll(PageDTO pageDTO) {
        log.info("查询检查项 参数：{}", pageDTO);
        return checkItemService.getAll(pageDTO);
    }

    @GetMapping("getAllCheckItem")
    public Result getAllCheckItem() {
        List<Checkitem> checkItems = checkItemService.getAllCheckItem();
        log.info("查询所有检查项 结果：{}", checkItems);
        boolean flag = checkItems != null && checkItems.size() > 0;
        return new Result(flag ? Code.GET_OK : Code.GET_ERR, flag ? Msg.QUERY_CHECKITEM_SUCCESS : Msg.QUERY_CHECKITEM_FAIL, checkItems);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add")
    public Result addCheckItem(@RequestBody Checkitem checkitem) {
        log.info("新增检查项 参数：{}", checkitem);
        boolean flag = checkItemService.addCheckItem(checkitem);
        log.info("新增检查项 状态:{}", flag);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag ? Msg.ADD_CHECKITEM_SUCCESS : Msg.ADD_CHECKITEM_FAIL);
    }

    @GetMapping("{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("通过Id查询检查项 参数：{}", id);
        Checkitem checkitem = checkItemService.getById(id);
        log.info("通过Id查询检查项 结果：{}", checkitem);
        return new Result(
                checkitem != null ? Code.GET_OK : Code.GET_ERR,
                checkitem != null ? Msg.QUERY_CHECKITEM_SUCCESS : Msg.QUERY_CHECKITEM_FAIL,
                checkitem);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update")
    public Result update(@RequestBody Checkitem checkitem) {
        log.info("更新检查项 参数：{}", checkitem);
        boolean flag = checkItemService.update(checkitem);
        log.info("更新检查项 状态：{}", flag);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag ? Msg.EDIT_CHECKITEM_SUCCESS : Msg.EDIT_CHECKITEM_FAIL);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("通过Id删除检查项 参数：{}", id);
        boolean flag = checkItemService.deleteById(id);
        log.info("通过Id删除检查项 删除状态：{}", flag);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag ? Msg.DELETE_CHECKITEM_SUCCESS : Msg.DELETE_CHECKITEM_FAIL);
    }
}
