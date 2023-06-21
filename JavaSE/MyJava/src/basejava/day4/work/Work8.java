package basejava.day4.work;

import java.util.Arrays;
import java.util.Random;

public class Work8 {
    public static void main(String[] args) {
        // 给定数值数组，将数组中所有大于89的全部全部从小到大排序，其他元素位置不变，最后通过Arrays.toString方法将其打印出来

        int [] arr = new int[5];
        Random random = new Random(); // 随机数
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(50)+70; // 随机赋值给数组范围在120以内
        }
        System.out.println("排序前："+Arrays.toString(arr));

        // 排序 数组中所有大于89的全部全部从小到大排序，其他元素位置不变
        for (int i = 0; i < arr.length; i++) { // 比较数的下标
            if (arr[i] > 89){
                for (int j = i+1; j < arr.length; j++) { // 被比较数的下标
                    if (arr[j] > 89){
                        if (arr[i] > arr[j]){
                            int temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                        }
                    }
                }
            }
        }
        System.out.println("排序后："+Arrays.toString(arr));
    }
}
