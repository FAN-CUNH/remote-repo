package com.fch.builder.concretebuilder;

import com.fch.builder.builder.HouseBuilder;

/**
 * @packageName com.fch.builder.concretebuilder
 * @ClassName CommonHouse
 * @Description TODO 具体建造者
 * @Author Fan-CUNH
 * @Date 2023/8/2 19:37
 * @Version 1.0
 */
public class CommonHouse implements HouseBuilder {
    /**
     * 打地基
     */
    @Override
    public void buildBase() {
        System.out.println(" 普通房子打地基5米 ");
    }

    /**
     * 砌墙
     */
    @Override
    public void buildWall() {
        System.out.println(" 普通房子砌墙10cm ");
    }

    /**
     * 封顶
     */
    @Override
    public void buildRoofed() {
        System.out.println(" 普通房子封顶 ");
    }
}
