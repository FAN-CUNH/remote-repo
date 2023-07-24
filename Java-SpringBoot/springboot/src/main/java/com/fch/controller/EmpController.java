package com.fch.controller;

import com.fch.pojo.Emp;
import com.fch.pojo.Result;
import com.fch.service.EmpService;
import com.fch.service.impl.EmpServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @packageName com.fch.controller
 * @ClassName EmpController
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/3 17:08
 * @Version 1.0
 */
@RestController
public class EmpController {

    /**
     * 调用 EmpService
     */
    @Resource // 运行时，IOC容器会提供该类型的bean对象，并赋值给该变量–依赖注入
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list(){

        //1. 调用 empService 获取数据
        List<Emp> empList = empService.empList();

        //2. 响应数据
        return Result.success(empList);
    }
}
