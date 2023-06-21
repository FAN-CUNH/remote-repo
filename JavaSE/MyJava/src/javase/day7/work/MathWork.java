package javase.day7.work;

import java.util.Scanner;

/**
 * @ClassName MathWork
 * @Description 通过Math类实现键盘录入整数，输出整数的3次幂；键盘录入的是小数输出小数的向下取整
 * @Author Cunhao Fan
 * @Date 2023/4/14 18:35
 * @Version 1.0
 */
public class MathWork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入一串数字：");
        String str = scanner.next();
        /*判断是否是纯数字*/
        String regex = "^[-|+]?[0-9]+[.]*[0-9]*";
        boolean isRight = str.matches(regex);
        if (!str.contains(".")){
            /*Math类中的.pow(数，次方).cbrt() 返回立方根*/
            System.out.println("整数为："+Math.pow(Integer.parseInt(str),3));
        }else {
            /*.floor向下取整*/
            System.out.println("小数向下取整的结果："+Math.floor(Double.parseDouble(str)));
        }
    }
}
