package com.fch.prototype.prototype.client;


import com.fch.prototype.prototype.sheep.Sheep;

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

        Sheep sheep1 = (Sheep) sheep.clone();
        Sheep sheep2 = (Sheep) sheep.clone();
        Sheep sheep3 = (Sheep) sheep.clone();
        Sheep sheep4 = (Sheep) sheep.clone();

        System.out.println("sheep0 = " + sheep);
        System.out.println("sheep1 = " + sheep1);
        System.out.println("sheep2 = " + sheep2);
        System.out.println("sheep3 = " + sheep3);
        System.out.println("sheep4 = " + sheep4);
    }
}
