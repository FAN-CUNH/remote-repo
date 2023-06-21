package javase.day9.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName ListSort
 * @Description 对A中的元素按照a和name排序：a相等再去比较name;a不等不用看name
 * @Author Cunhao Fan
 * @Date 2023/4/17 19:02
 * @Version 1.0
 */
class A implements Comparable <A>{
    int a;
    String name;
    /*构造方法*/

    public A(int a, String name) {
        this.a = a;
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", name='" + name + '\'' +
                '}';
    }
    /*重写比较方法，先比a的值，若果相等在比较name的值*/
    @Override
    public int compareTo(A o) {
        if (this.a == o.a){
            return this.name.compareTo(o.name);
        }else {
            return this.a - o.a;
        }
    }
}
public class ListSort {
    public static void main(String[] args) {
        /*实例化三个A对象*/
        A a1 = new A(111,"zhangsan");
        A a2 = new A(111,"lisi");
        A a3 = new A(100,"zhangsi");
        /*实例化集合对象,并初始化*/
        List<A> list = new ArrayList<A>(Arrays.asList(a1, a2, a3));
        Collections.sort(list);
        System.out.println(list);
    }
}
