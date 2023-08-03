package com.fch.builder.director;

import com.fch.builder.builder.HouseBuilder;
import com.fch.builder.product.House;

/**
 * @packageName com.fch.builder.director
 * @ClassName HouseDirector
 * @Description TODO 指挥者 指定建造流程 返回建造好的产品
 * @Author Fan-CUNH
 * @Date 2023/8/2 19:42
 * @Version 1.0
 */
public class HouseDirector {
    HouseBuilder houseBuilder;

    // 构造器注入
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // setter 注入
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 如何处理建造房子的流程交给指挥者
    public House createHouse() {
        houseBuilder.buildBase();
        houseBuilder.buildWall();
        houseBuilder.buildRoofed();
        return houseBuilder.buildHouse();
    }
}
