package javase.day10.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @ClassName LinkedListDemo
 * @Description  特点双链表，查找慢，增删改快
 * @Author Cunhao Fan
 * @Date 2023/4/18 10:23
 * @Version 1.0
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        /*实例化并初始化链表集合*/
        LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(23,24,89,80));
        /*集合对象.pop()弹栈 先进后出*/
        System.out.println(linkedList.pop());
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
        /*push()压栈*/
        linkedList.push(30);
        linkedList.push(35);
        System.out.println(linkedList.pop());
        System.out.println(linkedList);
        /*get()可以正常取*/
        System.out.println(linkedList.get(2));
        /*peek()检索不删除*/
        System.out.println(linkedList.peek());
        /*迭代器遍历*/
        Iterator<Integer>iterator = linkedList.iterator();
        while (iterator.hasNext()){
            Integer integer = iterator.next();
            System.out.print(integer+" ");
        }
        System.out.println();
        /*addFirst()添加到第一个位置*/
        linkedList.addFirst(20);
        /*addLast()*/
        linkedList.addLast(100);
        System.out.println(linkedList);
        /*removeFirst()有返回值，删除并返回第一个元素*/
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);
        /*removeLast()有返回值，删除并返回最后一个元素*/
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);
    }
}
