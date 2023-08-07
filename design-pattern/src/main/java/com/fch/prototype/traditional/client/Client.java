package com.fch.prototype.traditional.client;

import com.fch.prototype.traditional.sheep.Sheep;

/**
 * @packageName com.fch.prototype.traditional.client
 * @ClassName StaticClient
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 15:45
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 传统方法
        Sheep sheep = new Sheep("tom", "白色", 1);

        Sheep sheep1 = new Sheep(sheep.getName(), sheep.getColor(), sheep.getAge());
        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getColor(), sheep.getAge());
        Sheep sheep3 = new Sheep(sheep.getName(), sheep.getColor(), sheep.getAge());
        Sheep sheep4 = new Sheep(sheep.getName(), sheep.getColor(), sheep.getAge());

        System.out.println("sheep0 = " + sheep);
        System.out.println("sheep1 = " + sheep1);
        System.out.println("sheep2 = " + sheep2);
        System.out.println("sheep3 = " + sheep3);
        System.out.println("sheep4 = " + sheep4);
    }
}
