package basejava.day2.work;

import java.util.Scanner;

public class Work10 {
    public static void main(String[] args) {
        // 键盘录入某个数，求某个数范围内的所有乘积并且打印
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个不为0的数："); //
        int num = scanner.nextInt(); // 获取数值
        int col = 1; // 声明变量,此处col不能为0  积
        for (int i = 1; i <= num; i++) {
            col = col * i;
        }
        System.out.println(col);
    }
}
