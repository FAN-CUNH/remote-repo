package javase.day14.test;

import java.util.function.Function;

public class FunctionWork {
    public static void main(String[] args) {
        /*String str = "张三,20";
将字符串截取数字年龄部分，得到字符串；
将上一步的字符串转换成为int类型的数字；
将上一步的int数字加上100，得到结果int数字。*/
        //Function   R = apply(T)   Function = andThen(Function)
        String str = "张三,20";
        Function<String, Integer> function = (t) -> Integer.parseInt(t.substring(t.indexOf(",") + 1));
        int age = function.apply(str);
        Function<Integer, Integer> function1 = (t) -> t + 100;
        System.out.println("整数:" + age);

        int resultFunal = function.andThen(function1).apply(str);
        System.out.println("最终的结果：" + resultFunal);
    }
}
