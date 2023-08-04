package com.fch.composite.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @packageName com.fch.composite.component
 * @ClassName OrganizationComponent
 * @Description TODO 抽象组织 由具体组织实现 本例中如学校、学院、系来实现
 * @Author Fan-CUNH
 * @Date 2023/8/4 10:22
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class OrganizationComponent {
    /**
     * 组织名
     */
    private String name;
    /**
     * 描述
     */
    private String des;

    /**
     * 增
     *
     * @param organizationComponent 具体组织
     */
    public void add(OrganizationComponent organizationComponent) {
        // 默认实现 -> 即 空方法
        throw new UnsupportedOperationException(); // 抛出不支持操作异常
    }

    /**
     * 删
     *
     * @param organizationComponent 具体组织
     */
    public void remove(OrganizationComponent organizationComponent) {
        // 默认实现 -> 即 空方法
        throw new UnsupportedOperationException(); // 抛出不支持操作异常
    }

    /**
     * 查
     */
    public abstract void print();
}
