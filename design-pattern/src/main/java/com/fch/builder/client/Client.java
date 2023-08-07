package com.fch.builder.client;

import com.fch.builder.concretebuilder.CommonHouse;
import com.fch.builder.concretebuilder.HighHouse;
import com.fch.builder.director.HouseDirector;
import com.fch.builder.product.House;

/**
 * @packageName com.fch.builder.client
 * @ClassName StaticClient
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 19:49
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 盖普通房子 commonHouse 具体建造者
        CommonHouse commonHouse = new CommonHouse();

        // 创建指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        // 建普通房子
        House house = houseDirector.createHouse();

        // 重置建造者
        houseDirector.setHouseBuilder(new HighHouse());

        // 建高楼大厦
        House house1 = houseDirector.createHouse();
    }
}
