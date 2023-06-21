package basejava.day4.work;

import java.util.Arrays;

public class Work6 {
    public static void main(String[] args) {
        // 给定数字数组，删除所有的2后对数组进行从大到小数值的打印
        int [] arr = {1,2,4,0,7};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2){
                for (int j = i; j < arr.length-1; j++) {
                    arr[j] = arr[j+1];
                }
                arr[arr.length-1] = 999999;
                i--;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length-1; j++) {
                if (arr[i] < arr[j+1]){
                    int temp = arr[i];
                    arr[i] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
