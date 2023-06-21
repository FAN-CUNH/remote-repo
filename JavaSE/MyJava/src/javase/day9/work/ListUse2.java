package javase.day9.work;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ListUse2
 * @Description 有一个数组 String arr[]={"abc","bad","abc","aab","bad","cef","jhi"};创建一个ArrayList，将arr数组里面的元素添加进ArrayList中去，但ArrayList中元素不能重复 (arr数组不变)
 * @Author Cunhao Fan
 * @Date 2023/4/17 20:36
 * @Version 1.0
 */
public class ListUse2 {
    public static void main(String[] args) {
        /*初始化一个字符串数组*/
        String strArray[]={"abc","bad","abc","aab","bad","cef","jhi"};
        /*实例化集合对象*/
        List<String> myList = new ArrayList<String>();
        for (String everyStr:strArray
             ) {
            if (!myList.contains(everyStr)){
                myList.add(everyStr);
            }
        }
        System.out.println(myList);
    }
}
