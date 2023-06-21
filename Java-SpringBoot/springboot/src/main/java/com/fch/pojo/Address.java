package com.fch.pojo;

/**
 * @packageName com.fch.pojo
 * @ClassName Address
 * @Description TODO
 * @Author CunHao Fan
 * @Date 2023/6/3 2:43
 * @Version 1.0
 */
public class Address {
    private String province;
    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
