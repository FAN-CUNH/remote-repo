package com.fch.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.fch.code.Code;
import com.fch.constant.Msg;
import com.fch.domain.Checkgroup;
import com.fch.dto.PageDTO;
import com.fch.result.PageResult;
import com.fch.result.Result;
import com.fch.service.CheckGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @packageName com.fch.controller
 * @ClassName CheckGroupController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/10 16:40
 * @Version 1.0
 */
@Slf4j
@RestController // REST 风格
@RequestMapping("/checkgroup") // 窄化请求
public class CheckGroupController {
    @Reference
    private CheckGroupService checkGroupService;

    @GetMapping()
    public PageResult getCheckGroup(PageDTO pageDTO) {
        log.info("获取检查组 参数：{}", pageDTO);
        PageResult pageResult = checkGroupService.getCheckGroup(pageDTO);
        log.info("获取检查组 结果：{}", pageResult);
        return pageResult;
    }

    @GetMapping("getAll")
    public Result getAll() {
        log.info("查询所有检查组");
        List<Checkgroup> checkGroups = checkGroupService.getAll();
        if (checkGroups != null && checkGroups.size() > 0) {
            return new Result(Code.GET_OK, Msg.QUERY_CHECKGROUP_SUCCESS, checkGroups);
        } else {
            return new Result(Code.GET_ERR, Msg.QUERY_CHECKGROUP_FAIL);
        }
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("add")
    public Result addCheckGroup(@RequestBody Checkgroup checkgroup, @RequestParam("checkitemIds") Integer[] checkitemIds) {
        log.info("新增检查组 参数：{},{}", checkgroup, checkitemIds);
        boolean flag = checkGroupService.add(checkgroup, checkitemIds);
        log.info("新增检查组 结果：{}", flag);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag ? Msg.ADD_CHECKGROUP_SUCCESS : Msg.ADD_CHECKGROUP_FAIL);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable Integer id) {
        log.info("删除检查组 参数：{}", id);
        boolean flag = checkGroupService.deleteById(id);
        log.info("删除检查组 结果：{}", flag);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag ? Msg.DELETE_CHECKGROUP_SUCCESS : Msg.DELETE_CHECKGROUP_FAIL);
    }

    @GetMapping("{id}")
    public Result getCheckGroupById(@PathVariable Integer id) {
        log.info("通过id查询检查组 参数：{}", id);
        Checkgroup checkgroup = checkGroupService.getCheckGroupById(id);
        boolean flag = checkgroup != null;
        log.info("通过id查询检查组 结果：{}", flag);
        return new Result(flag ? Code.GET_OK : Code.GET_ERR, flag ? Msg.QUERY_CHECKGROUP_SUCCESS : Msg.QUERY_CHECKGROUP_FAIL, checkgroup);
    }

    @GetMapping("getCheckItemIdsByCheckGroupId/{id}")
    public Result getCheckItemIdsByCheckGroupId(@PathVariable Integer id) {
        log.info("通过检查组Id查询检查项id 参数：{}", id);
        List<Integer> checkItemIds = checkGroupService.getCheckItemIdsByCheckGroupId(id);
        boolean flag = checkItemIds != null && checkItemIds.size() > 0;
        log.info("通过检查组Id查询检查项id 结果：{},{}", checkItemIds, flag);
        return new Result(flag ? Code.GET_OK : Code.GET_ERR, flag ? Msg.QUERY_CHECKITEM_SUCCESS : Msg.QUERY_CHECKITEM_FAIL, checkItemIds);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update")
    public Result update(@RequestBody Checkgroup checkgroup, @RequestParam("checkitemIds") Integer[] checkItemIds) {
        log.info("更新检查组 入参：{}，{}", checkgroup, checkItemIds);
        boolean flag = checkGroupService.update(checkgroup, checkItemIds);
        log.info("更新检查组 结果：{}", flag);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag ? Msg.EDIT_CHECKGROUP_SUCCESS : Msg.EDIT_CHECKGROUP_FAIL);
    }
}
