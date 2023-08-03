package com.fch.builder.builder;

import com.fch.builder.product.House;

/**
 * @packageName com.fch.builder.builder
 * @ClassName HouseBuilder
 * @Description TODO 抽象建造者接口
 * @Author Fan-CUNH
 * @Date 2023/8/2 19:28
 * @Version 1.0
 */
public interface HouseBuilder {
    House HOUSE = new House();

    // 建造流程

    /**
     * 打地基
     */
    void buildBase();

    /**
     * 砌墙
     */
    void buildWall();

    /**
     * 封顶
     */
    void buildRoofed();

    /**
     * 建房子
     *
     * @return 房子
     */
    default House buildHouse() {
        return HOUSE;
    }
}
