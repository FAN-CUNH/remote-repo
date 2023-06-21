package basejava.day2.work;

import java.util.Scanner;

public class Work11 {
    public static void main(String[] args) {
        // 键盘录入某个数，求某个数范围内的所有乘积并且打印，格式如下：1*2*3*4*5*6*7...=结果
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个不为0的数:");
        int num  = scanner.nextInt();
        int col= 1;
        for (int i = 1; i <= num; i++) {
            col = col * i;
            System.out.print(i);
            if(i < num)
                System.out.print("*");
            else
                System.out.print("=");
        }

        System.out.println(col);
    }
}
