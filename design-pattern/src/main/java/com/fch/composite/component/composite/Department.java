package com.fch.composite.component.composite;

import com.fch.composite.component.OrganizationComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.composite.component
 * @ClassName Department
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/4 10:52
 * @Version 1.0
 */
@Slf4j
public class Department extends OrganizationComponent {

    public Department(String name, String des) {
        super(name, des);
    }

    public Department() {
    }

    /**
     * 组织名
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * 描述
     */
    @Override
    public String getDes() {
        return super.getDes();
    }

    /**
     * 查
     */
    @Override
    public void print() {
        log.info("------ {} ------", getName());
    }
}
