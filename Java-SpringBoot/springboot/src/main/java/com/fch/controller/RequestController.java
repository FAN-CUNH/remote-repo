package com.fch.controller;

import com.fch.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @packageName com.fch.controller
 * @ClassName RequestController
 * @Description 请求类：主要介绍了10种参数请求
 * @Author CunHao Fan
 * @Date 2023/6/3 1:43
 * @Version 1.0
 */
@RestController
public class RequestController {
    /**
     * 1.简单的参数Get请求和Post请求
     *
     * @RequestParam(name = "name" ,required = false)
     * 注解@RequestParam()
     *                  参数： 1.name or value 表示请求参数的键和值
     *                        2.required 默认值是true，代表该键的值必须传递否则报错 false可传可不传
     *                  作用： 方法形式参数与请求名不匹配，可通过该注解完成映射
     *
     * @param name 客户端请求参数name
     * @param age 客户端请求参数age
     * @return 返回OK
     */
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name = "name" ,required = false) String name, Integer age) {
        System.out.print(name + ":" + age);
        return "SimpleParam OK";
    }

    /**
     * 2.简单实体参数的封装：
     *    请求参数与实体属性一一对应
     *
     * @param user 实体类参数
     * @return 返回OK
     */
    @RequestMapping("/simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "SimplePojo OK";
    }

    /**
     * 3.复杂实体参数请求：
     *      请求参数名与实体对象属性名对应，即可直接通过pojo接收
     *      按照类的组合关系对应
     *
     * @param user 实体类参数
     * @return 返回OK
     */
    @RequestMapping("/complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "ComplexPojo OK";
    }

    /**
     * 4.数组参数请求：
     *      请求名与入参名相同即可
     *
     * @param hobby 前端请求数组参数
     * @return 响应信息OK
     */
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "ArrayParam OK";
    }

    /**
     * 5.集合参数请求：
     *      入参位置必须加上@Requestparam注解、将多个请求名相同的参数封装入list集合
     *      集合名与请求名相同
     *
     * @param hobby 前端请求集合参数
     * @return 响应信息OK
     */
    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby) {
        System.out.println(hobby);
        return "ListParam OK";
    }

    /**
     * 6.日期请求参数：
     *      需使用@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")规定日期请求参数格式
     *      请求名与参数名相同
     *
     * @param updateTime 日期请求参数
     * @return 响应状态信息
     */
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "UpdateTime OK";
    }


    /**
     * 7.Json参数请求：
     *      要求Json数据的Key名与=形参对象的属性名一一对应
     *      需使用@RequestBody注解标识 将JSON数据封装到POJO对象中
     * @param user 实体对象接收json数据
     * @return 返回状态信息
     */
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "JsonParam OK";
    }

    /**
     * 9.单个路径参数请求：
     *      通过请求URL直接传递参数，使用{..}来标识该路径参数，需要使用@PathVariable获取路径参数
     *
     * @param id 形参接收路径参数
     * @return 放回响应状态信息
     */
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id) {
        System.out.println(id);
        return "PathParam OK";
    }

    /**
     * 9.多个路径参数请求：
     *      通过请求URL直接传递参数，使用{..}来标识该路径参数，需要使用@PathVariable获取路径参数
     *
     * @param id 形参接收路径参数
     * @param name 形参接收路径参数
     * @return 放回响应状态信息
     */
    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id);
        System.out.println(name);
        return "PathParam OK";
    }
}
