package basejava.day5.work;

import java.util.Arrays;

public class Work3 {
    // 定义方法完成删除数组中某个元素
    public static int [] delNum(int [] numArray,int num){
        for (int i = 0; i < numArray.length; i++) { // 遍历数组 不考虑数组中存在0的情况，如果考虑,将循环条件减去删除元素的个数
            //删除操作
            if (numArray[i] == num){
                for (int j = i; j < numArray.length-1; j++) { // 前移
                    numArray[j] = numArray[j+1];
                }
                numArray[numArray.length-1] = 0; // 执行删除后，末尾元素置0
                i--; // 防止连续元素漏删
            }
        }
        return numArray; // 返回删除后的数组
    }
        // 调用
        public static void main(String[] args) {
            System.out.println("删除后的数组"+ Arrays.toString(Work3.delNum(new int [] {0,1,2,2,3,2,0,4,5},2)));
        }
}
