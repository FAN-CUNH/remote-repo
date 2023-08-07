package com.fch.visitor;

import java.util.LinkedList;
import java.util.List;

/**
 * @packageName com.fch.visitor
 * @ClassName ObjectStructure
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/7 13:27
 * @Version 1.0
 */
public class ObjectStructure {
    /**
     * 角色集合
     */
    private List<Person> personList = new LinkedList<>();

    /**
     * 添加角色
     *
     * @param person 角色
     */
    public void attach(Person person) {
        personList.add(person);
    }

    /**
     * 移除角色
     *
     * @param person 角色
     */
    public void detach(Person person) {
        personList.remove(person);
    }

    /**
     * 遍历测评情况
     *
     * @param action
     */
    public void display(Action action) {
        personList.forEach(person -> person.accept(action));
    }
}
