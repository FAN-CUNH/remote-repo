package javase.day13.test;

import java.util.function.Function;

/**
 * @ClassName FunctionDemo
 * @Description Function <T,R> T传入参数的类型 R返回结果的类型 用来根据一个类型，返回拎一个类型
 * @Author Cunhao Fan
 * @Date 2023/4/21 11:26
 * @Version 1.0
 */
public class FunctionDemo {
    public static void main(String[] args) {
        /*将字符串转化为缓冲区,在转化为整型*/
        Function <String, StringBuffer> function1 = string -> new StringBuffer(string);
        Function <StringBuffer, Integer> function2 = string -> Integer.parseInt(string.toString());
        /*调用*/
        //function1.apply("123");
        int result = function1.andThen(function2).apply("123");
        System.out.println(result+1);

        /*给定字符串，先获取数组的第一个元素，再回去第一个元素的前两位*/
        String[] arr = {"abc", "bcd", "cde", "def", "efg"};
        /*获取数组的第一个元素*/
        Function<String[], String> function3 = array -> arr[0];
        /*获取第一个元素的前两位*/
        Function<String, String> function4 = s -> s.charAt(0)+""+ s.charAt(1);
        String finalResult = function3.andThen(function4).apply(arr);
        System.out.println(finalResult);
    }
}
