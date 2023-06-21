package javase.day9.work;

import java.util.*;

/**
 * @ClassName ListPrint
 * @Description 随机产生5个100以内的整数放入集合，使用集合的3种遍历方式打印集合元素的和,将2位整数修改为原数值+1,实现删除所有的56，最后打印集合对象展示数据
 * @Author Cunhao Fan
 * @Date 2023/4/17 17:58
 * @Version 1.0
 */
public class ListPrint {
    /*递归求累加和方法
    public Integer getSum (Integer integer){
        if (integer.equals(1)){
            return 1;
        }
        else {
            return integer + getSum(integer-1);
        }
    }*/
    public static void main(String[] args) {
        /*实例化List对象*/
        List <Integer> myList = new ArrayList<Integer>();
        /*实例化Random对象*/
        Random random = new Random();
        /*实例化本类*/
        /*循环赋值*/
        for (int i = 0; i < 5; i++) {
            myList.add(random.nextInt(100));
        }
        System.out.println(myList);
        /*对集合排序*/
        /*调用集合的排序*/
        //myList.sort(Integer::compareTo);
        /*调用集合工具类排序*/
        Collections.sort(myList);
        System.out.println(myList);
        /*遍历：forEach*/
        int sum1 = 0;
        for (Integer everyEle:myList
             ) {
            sum1 = sum1 + everyEle;
            System.out.print(everyEle+" ");
        }
        System.out.println(sum1);
        /*遍历：迭代器*/
        int sum3 = 0;
        /*获取迭代器*/
        Iterator <Integer> myIterator = myList.iterator();
        /*适用迭代器*/
        while (myIterator.hasNext()){
            /*获取元素*/
            Integer integer = myIterator.next();
            sum3 = sum3 + integer;
            System.out.print(integer+" ");
        }
        System.out.println(sum3);
        /*遍历：for*/
        int sum2 = 0;
        for (int i = 0; i < myList.size(); i++) {
            //sum2 = sum2 + myList.get(i);
            if (myList.get(i).equals(56)){
                myList.remove(i);
                i--;
            }
            if ((myList.get(i) +"").length() == 2){
                myList.set(i,myList.get(i)+1);
            }
            System.out.print(myList.get(i)+" ");
        }
        //System.out.println(sum2);
    }
}
