package com.fch.composite.component.composite;

import com.fch.composite.component.OrganizationComponent;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @packageName com.fch.composite.component
 * @ClassName College
 * @Description TODO 具体组织 学院 Composite
 * @Author Fan-CUNH
 * @Date 2023/8/4 10:48
 * @Version 1.0
 */
@Slf4j
public class College extends OrganizationComponent {
    /**
     * 用于组合其子类系的list集合
     */
    List<OrganizationComponent> organizationComponents = new ArrayList<>(16);

    /**
     * 继承父类的构造器
     *
     * @param name 组织名
     * @param des 组织描述
     */
    public College(String name, String des) {
        super(name, des);
    }

    /**
     * 增 在集合中新增入参对象
     *
     * @param organizationComponent 具体组织
     */
    @Override
    public void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    /**
     * 删 在集合中删除入参对象
     *
     * @param organizationComponent 具体组织
     */
    @Override
    public void remove(OrganizationComponent organizationComponent) {
        organizationComponents.remove(organizationComponent);
    }

    /**
     * 查 输出本类即学校包含的组织即学院集合
     */
    @Override
    public void print() {
        // 输出组织名
        log.info("------ {} ------", this.getName());
        // 遍历输出该组织中包含的子组织
        organizationComponents.forEach(OrganizationComponent::print);
    }

    /**
     * 重写父类的getName方法
     * 获取组织名
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * 重写父类的getDes方法
     * 获取组织描述描述
     */
    @Override
    public String getDes() {
        return super.getDes();
    }
}
