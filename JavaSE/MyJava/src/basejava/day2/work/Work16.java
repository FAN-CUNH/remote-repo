package basejava.day2.work;

import java.util.Scanner;

public class Work16 {
    public static void main(String[] args) {
        // 键盘录入行号，打印对应行的金字塔
        /*
                            *    每行空格数＋行号 = 行数
                           ***   空格数 = 行数 - 行号
                          *****
                         *******
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入金字塔的高度：");
        int hei = scanner.nextInt();
        for (int i = 1; i <= hei; i++) {  // 行号

            for (int k = hei-i; k >= 1; k--) { // 先打印空格 k = hei-i 表示每行打印的空格 逐行减少
                System.out.print(" ");
            }

            for (int j = 1; j <= i*2-1; j++) { // 再打印星号  j <= i*2-1 每行的星号个数
                System.out.print("*");
            }

            System.out.println(); // 换行
        }
    }
}
