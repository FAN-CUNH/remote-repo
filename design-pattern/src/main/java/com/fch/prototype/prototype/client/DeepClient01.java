package com.fch.prototype.prototype.client;

import com.fch.prototype.prototype.deepcope.DeepCloneableTarget;
import com.fch.prototype.prototype.deepcope.DeepPrototype;

/**
 * @packageName com.fch.prototype.prototype.client
 * @ClassName DeepClient01
 * @Description TODO 方式1 重写clone方法来实现深拷贝  优点：简单  缺点：当存在多个引用数据类型时 代码量太大
 * @Author Fan-CUNH
 * @Date 2023/8/2 17:31
 * @Version 1.0
 */
public class DeepClient01 {
    public static void main(String[] args) throws CloneNotSupportedException {
        DeepPrototype deepPrototype = new DeepPrototype();
        deepPrototype.name = "深拷贝";
        deepPrototype.deepCloneableTarget = new DeepCloneableTarget("deepCloneableTarget", "DeepCloneableTarget");

        DeepPrototype deepPrototype1 = (DeepPrototype) deepPrototype.clone();
        System.out.println("deepPrototype.name = " + deepPrototype.name + " deepPrototype.deepCloneableTarget = " + deepPrototype.deepCloneableTarget.hashCode());
        System.out.println("deepPrototype1.name = " + deepPrototype1.name + " deepPrototype1.deepCloneableTarget = " + deepPrototype1.deepCloneableTarget.hashCode());
    }
}
