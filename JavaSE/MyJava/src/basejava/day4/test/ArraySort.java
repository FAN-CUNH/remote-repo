package basejava.day4.test;

import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {
        // 从小到大或者从大到小排序
        // 冒泡：小的上浮，大的下沉
        int [] arr = {1,2,3,4,56,67,78,0};
        for (int i = 0; i < arr.length; i++) { // i表示比较数的下标
            for (int j = i+1; j < arr.length; j++) { // j表示被比较数的下标
                if (arr[i] > arr[j]){ // 比较 保留较小值 小的覆盖大的
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int every:arr) { // 输出
            System.out.print(every+" ");
        }

        System.out.println();
        int[] arr1 = {1,2,3,4,56,67,78,0};
        Arrays.sort(arr1); // 排序方法
        System.out.println(Arrays.toString(arr1)); // 数组输出方法 Arrays.toString(arr1)







    }
}
