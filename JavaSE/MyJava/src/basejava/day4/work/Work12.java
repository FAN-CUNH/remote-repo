package basejava.day4.work;

import java.util.Arrays;

public class Work12 {
        // 定义一个数字数组，将数组中次数出现偶数位的数字修改为原数字的位数放入，通过forEach循环打印
    public static int [] eleChange (int [] numArray){
        // 遍历数组
        for (int i = 0; i < numArray.length; i++) {
            // 统计前先判断该数字统计前是否已经被统计
            boolean isExist = false; // 假设未被统计
            for (int j = 0; j < i; j++) { // 验证假设
                if (numArray [i] == numArray[j]){
                    isExist = true; // 验证得到假设不成立
                    break; // 结束循环
                }
            }
            // 假设成立，执行统计操作
            int existCount = 0; // 出现次数计数器
            if (!isExist){
                for (int j = i; j < numArray.length; j++) {
                    if (numArray[i] == numArray[j]){
                        existCount++;
                    }
                }
                System.out.println(Arrays.toString(numArray));
                System.out.println(numArray[i]+"出现"+existCount);
            }
            if (!isExist){
                if (existCount % 2 == 0){
                   int num = numArray[i]; // 储存当前数值
                    for (int j = 0; j < numArray.length; j++) {
                        if (numArray[j] == num) {
                            numArray[j] = String.valueOf(num).length();
                        }
                    }
                }
            }
        }
        return numArray;
    }
    public static void main(String[] args) {
        int [] arr = {11,11,3,4,5,5,5,5,1234,56};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(eleChange(arr)));
    }
}
