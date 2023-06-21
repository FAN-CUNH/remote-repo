package basejava.day4.test;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTwoDimension { // 二维数组
    public static void main(String[] args) {
        // 将数值  1,2,3,4     45,45,12,0    56,67,78,90,12放入二维数组
        int [][] arr = {{ 1,2,3,4},{45,45,12,0},{56,67,78,90,12}};
        int [][] arr1 = new int[2][2];
        System.out.println("请输入数组的元素：");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                Scanner scanner = new Scanner(System.in);
                arr1[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < arr.length; i++) {
            Arrays.sort(arr[i]);
        }
        for (int j = 0; j < arr.length; j++) {
            System.out.println(Arrays.toString(arr[j])+" ");
        }
        System.out.println();
        for (int j = 0; j < arr.length-1; j++) {
            System.out.println(Arrays.toString(arr1[j])+" ");
        }
    }
}
