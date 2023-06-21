package com.fch.controller;

import com.fch.pojo.Address;
import com.fch.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @packageName com.fch.controller
 * @ClassName ResponseController
 * @Description 响应类：
 *                      @RequestMapping("/hello")
 *                      public String hello() {
 *                          System.out.println("hello");
 *                          return "Hello SpringBoot";
 *                      }
 *                      @RequestMapping("/hello")
 *                      功能接口          功能接口访问路径
 *                                       请求参数
 *                                       响应数据
 * @Author CunHao Fan
 * @Date 2023/6/3 14:31
 * @Version 1.0
 */
@RestController
public class ResponseController {
    /**
     * 1.字符串—响应
     *
     * @return 响应到客户端浏览器的数据
     */
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("hello");
        return "Hello SpringBoot";
    }

    /**
     * 经Result类改造后的功能接口
     */
    @RequestMapping("/resultHello")
    public Result resultHello() {
        System.out.println("hello");
        return Result.success("Hello SpringBoot");
    }

    /**
     * 2.Json对象-响应
     *
     * @return 响应到客户端浏览器的对象
     */
    @RequestMapping("/getAddress")
    public Address getAddress() {
        Address address = new Address();
        address.setProvince("江苏");
        address.setCity("无锡");
        return address;
    }

    /**
     * 经Result类改造后的功能接口
     */
    @RequestMapping("/resultGetAddress")
    public Result resultGetAddress() {
        Address address = new Address();
        address.setProvince("江苏");
        address.setCity("无锡");
        return Result.success(address);
    }

    /**
     * 3.集合-响应
     *
     * @return 响应到客户端浏览器的集合
     */
    @RequestMapping("/listAddress")
    public ArrayList<Address> listAddress() {
        ArrayList<Address> list = new ArrayList<>(16);

        Address addr1 = new Address();
        addr1.setProvince("北京");
        addr1.setCity("北京");

        Address addr2 = new Address();
        addr2.setProvince("上海");
        addr2.setCity("上海");

        Address addr3 = new Address();
        addr3.setProvince("江苏");
        addr3.setCity("无锡");

        list.add(addr1);
        list.add(addr2);
        list.add(addr3);

        return list;
    }

    /**
     * 经Result类改造后的功能接口
     */
    @RequestMapping("/resultListAddress")
    public Result resultListAddress() {
        ArrayList<Address> list = new ArrayList<>(16);

        Address addr1 = new Address();
        addr1.setProvince("北京");
        addr1.setCity("北京");

        Address addr2 = new Address();
        addr2.setProvince("上海");
        addr2.setCity("上海");

        Address addr3 = new Address();
        addr3.setProvince("江苏");
        addr3.setCity("无锡");

        list.add(addr1);
        list.add(addr2);
        list.add(addr3);

        return Result.success(list);
    }
}
