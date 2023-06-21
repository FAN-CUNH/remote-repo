package basejava.day3.work;

import java.util.Scanner;

public class Work2 {
    public static void main(String[] args) {
        //  键盘录入某个数值，打印该数值的位数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scanner.nextInt(); // 获取数值
        // digit 位数
        //  123 % 10 --> 3
        //  123 / 10 % 10 --> 2
        //  123 / 10 / 10 % 10 --> 1
        String num1 = " "; // 定义一个空字符串
        num1 = " "+num;  // 将num转化成字符类型 以便获取num的长度
        System.out.println("num的位数"+num1.length());
        int digit = 0,count = 0;
        for (int i = 0; i < num1.length(); i++) {
            digit = num % 10;
            num = num / 10;
            if (digit >= 0 && digit <= 9){// 每个位数的取值0-9
                System.out.print(digit+" ");
            }
        }
    }
}
