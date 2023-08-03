package com.fch.decorator.jdksource;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * @packageName com.fch.decorator.jdksource
 * @ClassName DataInputStreamDemo
 * @Description TODO 装饰者模式在JDK源码中的使用
 * @Author Fan-CUNH
 * @Date 2023/8/3 18:34
 * @Version 1.0
 */
public class DataInputStreamDemo {
    public static void main(String[] args) {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("D:\\abc.txt"))) {
            System.out.println(dataInputStream.read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
