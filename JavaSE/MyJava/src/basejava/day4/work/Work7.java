package basejava.day4.work;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Work7 {
    public static void main(String[] args) {
     // 键盘录入5个数值，将5个数值放入数组同时将其和随机数产生的4个数值进行合并到新数组，同时将新数组中所有的偶数修改为比其大一的奇数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入五个数：");
        int [] arr1 = new int[5];
        int [] arr2 = new int[4];
        int [] arr3 = new int[arr1.length+arr2.length];
        for (int i = 0; i <5; i++) {
            arr1[i] = scanner.nextInt();
        }
        Random random = new Random();
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = random.nextInt(100);
        }
        for (int i = 0; i < arr1.length; i++) {
            arr3[i] = arr1 [i];
        }
        for (int i = arr1.length; i < arr3.length; i++) {
            arr3[i] = arr2[i-5];
        }
        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] % 2 == 0)
            arr3[i] += 1;
        }
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

    }
}
