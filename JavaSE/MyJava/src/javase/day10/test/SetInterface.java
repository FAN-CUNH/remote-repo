package javase.day10.test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * @ClassName SetInterface
 * @Description Set泛型接口 特点：去重+按指定规则自行排序+没有get()方法（因为存入的顺序和输入的顺序不一致）
 * @Author Cunhao Fan
 * @Date 2023/4/18 11:03
 * @Version 1.0
 */
public class SetInterface {
    public static void main(String[] args) {
        /*已知实现子类TreeSet,HashSet,LinkedHashSet*/
        Set<Integer> numbers = new TreeSet<Integer>(Arrays.asList(3,1,2));
        System.out.println(numbers);
        /*TreeSet:放入元素对应的类必须要实现Compable接口，去重和排序依据Compable的返回值（0：删除）*/
    }
}
