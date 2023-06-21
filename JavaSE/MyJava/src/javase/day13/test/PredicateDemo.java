package javase.day13.test;

import java.util.function.Predicate;

/**
 * @ClassName PredicateDemo
 * @Description Predicate <T>
 * @Author Cunhao Fan
 * @Date 2023/4/21 11:39
 * @Version 1.0
 */
public class PredicateDemo {
    public static void main(String[] args) {
        /*判断键盘录入的姓名是否是纯数字，同时姓名长度是否大于12*/
        /*实例化两个断言*/
        Predicate <String> predicate = name -> name.matches("\\d+");
        Predicate <String> predicate1 = name -> name.length() > 12;
        boolean result = predicate.and(predicate1).test("1234567891011");
        System.out.println(result);
    }
}
