package hashmap_concurrenthashmap;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @ClassName MyFinal
 * @Description final:
 *  java中的关键词，可以用来修饰类，变量，常量，方法等
 * final修饰的类不能被继承，因此抽象类和接口不能用final修饰；被final修饰的类中的所有方法都被隐式的指定为final方法；Java中的八大基本数据类型和String类都是用final修饰的；
 * final修饰的方法不能被重写；类的private方法会隐式的指定为final方法；
 * final修饰的引用变量在初始化后引用地址就不能改变，如果是类成员变量则必须在声明或者类的构造函数中初始化，而基本数据类型在数值初始化后便不能修改；
 * final修饰的基本数据类型或者String类型如果在编译期能确定值，则当做常量使用；
 * @Author Cunhao Fan
 * @Date 2023/5/10 17:58
 * @Version 1.0
 */
public class MyFinal {
    public static void main(String[] args) {
        final String STR = "abc";
        final HashMap<Integer, String> hashMap = new HashMap<>();
        final int[] arr = new int[10];

        //str = "cbd";
        hashMap.put(1, "数字1");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        HashMap<Integer, String> hashMap2 = new HashMap<>();
        hashMap2.put(2, "数字2");
        //hashMap = hashMap2;

        System.out.println(STR + "      " +hashMap + "     " + Arrays.toString(arr) + "    "+ hashMap2);
    }
}
