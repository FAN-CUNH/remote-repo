package basejava.day3.work;

import java.util.Scanner;

public class Work5 {
    public static void main(String[] args) {
        // 键盘录入某个数值，要求将该数值范围内的数值和求出来，同时判断该数值是否是奇数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum = sum + i;
        }
        if (sum % 2 == 0){ // 能被2整除——>偶数
            System.out.println(sum+"不是奇数");
        }
        else {
            System.out.println(sum+"是奇数");
        }
    }
}
