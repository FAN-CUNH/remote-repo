package basejava.day2.work;

import java.util.Scanner;

public class Work15 {
    public static void main(String[] args) {
        // 键盘录入某个数，打印某个数范围内的所有水仙花数（选做）
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数");
        int num = scanner.nextInt();
        for (int i=100; i < num; i++) {
            int hei = i / 100,mid = i % 100 /10,low = i % 10;
            if (i == hei*hei*hei+mid*mid*mid+low*low*low){
                System.out.print(i);
                System.out.print(" ");
            }

        }
    }
}
