package basejava.day4.work;

import java.util.Arrays;
import java.util.Scanner;

public class Work1 {
    public static void main(String[] args) {
        //将数值  1,2,3,4     45,45,12,0    56,67,78,90,12放入二维数组
        //将二维数组中每个一维数组的信息从大到小排序后打印出来

        int [][] arr = new int[3][5];
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入数值："); // 空值用0代替
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                // 循环赋值
                arr[i][j] = scanner.nextInt();
            }
        }
        // 排序前
        System.out.println("排序前:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        // 排序

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = j + 1; k < arr[i].length; k++) {
                    if (arr[i][j] < arr[i][k]){
                        int temp = arr[i][j];
                        arr[i][j] = arr[i][k];
                        arr[i][k] = temp;
                    }
                }
            }
        }

        // 排序后

        System.out.println("排序后:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }
}
