package com.fch.pojo;

/**
 * @packageName com.fch.pojo
 * @ClassName User
 * @Description 简单JavaBean类
 * @Author CunHao Fan
 * @Date 2023/6/3 2:29
 * @Version 1.0
 */
public class User {
    private String name;
    private Integer age;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
