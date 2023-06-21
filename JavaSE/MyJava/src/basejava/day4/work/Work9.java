package basejava.day4.work;

import java.util.Arrays;

public class Work9 {
        // 尝试使用二分法查找查找某个数值在数组中出现的位置：参照课上代码选做实现
    public static int binarySearch (int [] numArray,int num){
        // 先将数组第一个元素下标存入left，数组最后一个元素存入right
        Arrays.sort(numArray); // 数组排序
        int index = -1; // 被查找元素的下标，初始化为-1
        // 二分法查找思想:数值一个和中间值比较，若果大于，往右边找，反之亦然
        int left = 0,right = numArray.length;
        while (left <= right){ // 当left > right 循环结束
            int mid = (left + right) / 2; // 每次循环取出中间值
            if (num == numArray[mid]){ // 如果中间值正好等于我们要找的数则直接跳出循环
                index = mid;
                break;
            }else if (num > numArray[mid]){ // 中间值比我们要找的数大，则往后找
                left = mid + 1; // 将leftx下标改为当前中间值的后一位
            }else { // 中间值比我们要找的值小，则往前找
                right = mid - 1; // 将right下标值改为mid—1
            }
        }
        return index;
    }
    public static void main(String[] args) {
        // 二分法查找，需要先将数组排序
        int [] arr = {2,4,5,1,3};
        System.out.println("出现在第"+(binarySearch(arr,3)+1)+"位");
    }
}
