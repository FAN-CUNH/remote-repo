package com.fch.visitor;

/**
 * @packageName com.fch.visitor
 * @ClassName Client
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/7 13:34
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.attach(new Man());
        objectStructure.attach(new Woman());

        // 成功
        Success success = new Success();
        objectStructure.display(success);

        // 失败
        Fail fail = new Fail();
        objectStructure.display(fail);
    }
}
