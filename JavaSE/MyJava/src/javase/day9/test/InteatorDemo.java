package javase.day9.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


/**
 * @ClassName InteatorDemo
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/17 9:59
 * @Version 1.0
 */
public class InteatorDemo {
    public static void main(String[] args) {
        /*第一种：将字符串数字转换成集合*/
        String [] str = {"串串星人","吐槽星人","汪星人"};
        Collection <String> collection = Arrays.asList(str);
        /*获取迭代器*/
        Iterator<String> iterator = collection.iterator();
        /*若hasNext指向为空，则循环结束*/
        while (iterator.hasNext()){
            /*执行next()获取元素*/
            String string = iterator.next();
            System.out.println("集合元素为："+string);
        }
        /*第二种：将字符串存入集合*/
        Collection <String> collection1 = new ArrayList<String >();
        /*调用集合的add方法，将元素存入集合*/
        collection1.add("串串星人");
        collection1.add("吐槽星人");
        collection1.add("汪星人");
        /*获取迭代器*/
        Iterator <String> iterator1 = collection1.iterator();
        /*适用迭代器*/
        while (iterator1.hasNext()){
            /*获取元素*/
            String string = iterator1.next();
            /*打印元素*/
            System.out.println("集合1元素为："+string);
        }
    }
}
