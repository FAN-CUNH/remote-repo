package basejava.day4.work;

import java.util.Arrays;

public class Work3 {
    public static void main(String[] args) {
        //  定义一个数字数组，将数组中所有出现数小于2的数值全部删除，最后从小到大排序打印
        int [] arr = {1,2,4,5,2,5,1,0,3};
        for (int i = 0; i < arr.length; i++) { // 遍历数组
            if (arr[i] < 2){
                for (int j = i; j < arr.length-1; j++) {
                    arr[j] = arr[j+1]; // 前移覆盖
                }
                arr[arr.length-1] = 999999; // 将尾数置成最大值
                i--;
            }
        }
        System.out.println(Arrays.toString(arr));


    }
}
