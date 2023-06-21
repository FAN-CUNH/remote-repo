package javase.day9.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ListDemo
 * @Description 将集合中的张三改成字符的个数
 * @Author Cunhao Fan
 * @Date 2023/4/17 15:18
 * @Version 1.0
 */
public class ListDemo {
    public static void main(String[] args) {
        /*实例化集合对象list*/
        List <String> list = new ArrayList<String>();
        list.addAll(Arrays.asList(new String[]{"zhangsan","lisi","wangwu"}));
        System.out.println("集合元素"+list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("zhangsan")){
                list.set(i,"8");
            }
        }
        System.out.println(list);
    }
}
