package com.fch.controller;

import com.fch.service.ValidateCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @packageName com.fch.controller
 * @ClassName ValidateCodeController
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/7/28 19:09
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("validate")
@Api("验证码接口")
public class ValidateCodeController {
    @Resource
    private ValidateCodeService validateCodeService;

    @ApiOperation("新增验证码")
    @PostMapping("{telephone}")
    public boolean saveValidateCode(@ApiParam("手机号") @PathVariable("telephone") String telephone) {
        log.info("入参：{}", telephone);
        boolean flag = validateCodeService.saveValidateCode(telephone);
        log.info("新增结果：{}", flag);
        return flag;
    }

    @ApiOperation("查询验证码")
    @GetMapping("{telephone}")
    public String getValidateCode(@ApiParam("手机号") @PathVariable("telephone") String telephone) {
        log.info("入参：{}", telephone);
        String validateCode = validateCodeService.getValidateCode(telephone);
        log.info("查询结果：{}", validateCode);
        return validateCode;
    }
}
