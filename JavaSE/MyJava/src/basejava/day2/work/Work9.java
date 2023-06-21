package basejava.day2.work;

import java.util.Scanner;

public class Work9 {
    public static void main(String[] args) {
        // 键盘录入行号，打印对应行数的正方形，正方形里面放置&
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入行号："); // 输入行号
        int row = scanner.nextInt(); // 获取行数
        for (int i = 0; i < row; i++) { // 行
            for (int j = 0; j < row; j++) {
                System.out.print("& ");
            }
            System.out.println(); // 换行 让内层循环执行完就换一次行 保证其形状成正方形
        }
    }
}
