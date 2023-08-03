package com.fch.builder.concretebuilder;

import com.fch.builder.builder.HouseBuilder;

/**
 * @packageName com.fch.builder.concretebuilder
 * @ClassName HighHouse
 * @Description TODO 具体建造者
 * @Author Fan-CUNH
 * @Date 2023/8/2 19:40
 * @Version 1.0
 */
public class HighHouse implements HouseBuilder {
    /**
     * 打地基
     */
    @Override
    public void buildBase() {
        System.out.println(" 高楼大厦打地基50米 ");
    }

    /**
     * 砌墙
     */
    @Override
    public void buildWall() {
        System.out.println(" 高楼大厦砌墙50cm ");
    }

    /**
     * 封顶
     */
    @Override
    public void buildRoofed() {
        System.out.println(" 高楼大厦封顶 ");
    }
}
