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
        // InputStream是抽象类,类似我们前面讲的Drink
        // FileInputStream 是 InputStream子类,类似我们前面的DeCaf，LongBlack
        // FilterInputStream是InputStream子类:类似我们前面的Decorator修饰者
        // DataInputStream是FilterInputStream子类，具体的修饰者，类似前面的Milk,Soy等
        // FilterInputStream类有 protected volatile InputStream in;即含被装饰者
        // 分析得出在jdk的io体系中,就是使用装饰模式
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("D:\\abc.txt"))) {
            System.out.println(dataInputStream.read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
