package basejava.day5.work;

import java.util.Arrays;

public class Work4 {
    // 定义方法完成数组的排序
    public static int [] arraySort (int [] numArray){
        // 排序
        for (int i = 0; i < numArray.length; i++) { // 被比较数的下标
            for (int j = i; j < numArray.length; j++) { // 比较数的下标
                if (numArray[i] > numArray[j]){ // 从小到大排序
                    int temp = numArray[i]; // 交换两数的值
                    numArray[i] = numArray[j];
                    numArray[j] =temp;
                }
            }
        }
        return numArray;
    }
    // 调用
    public static void main(String[] args) {
        System.out.println("从小到大排序后的数组"+ Arrays.toString(arraySort(new int [] {1,3,5,7,2,4,6,8})));
    }
}
