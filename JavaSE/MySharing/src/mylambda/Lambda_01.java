package mylambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @ClassName Lambda_01
 * @Description 使用Lambda表达式进行遍历
 * @Author Cunhao Fan
 * @Date 2023/5/11 13:45
 * @Version 1.0
 */
public class Lambda_01 {
    public static void main(String[] args) {
        /*数组遍历：创建一个数组，存放三个字符串类型水果的英文名*/
        String[] fruitArr = {"apple", "banana", "orange"};

        /*未使用Lambda表达式：*/
        for (String s : fruitArr) {
            System.out.println(s);
        }
        System.out.println("===================================");

        /*使用Lambda表达式*/
        Stream.of(fruitArr).forEach(System.out::println);

        System.out.println("===================================");

        /*集合遍历：创建一个集合，存放三个字符串类型水果的英文名*/
        List<String> fruitArrList = Arrays.asList("apple", "banana", "orange");
        /*未使用Lambda表达式：*/
        for (String fruit : fruitArrList) {
            System.out.println(fruit);
        }
        System.out.println("===================================");

        /*使用Lambda表达式*/
        /*list.forEach(s -> {System.out.println(s);});*/
        fruitArrList.forEach(System.out::println);

    }
}
