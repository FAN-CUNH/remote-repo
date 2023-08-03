package com.fch.factory.factorymethod.store;

import com.fch.factory.factorymethod.order.BJOrderPizza;
import com.fch.factory.factorymethod.order.LDOrderPizza;
import java.util.Scanner;

/**
 * @packageName com.fch.factorymode.factorymethod.store
 * @ClassName PizzaStore
 * @Description TODO
 * @Author Fan-CUNH
 * @Date 2023/8/2 11:10
 * @Version 1.0
 */
public class PizzaStore {
    public static void main(String[] args) {
        // 获取地区
        Scanner scanner = new Scanner(System.in);
        System.out.println(" 请输入地区 ");
        String local = scanner.next();
        if ("北京".equals(local)) {
            new BJOrderPizza();
        } else {
            new LDOrderPizza();
        }
    }
}
