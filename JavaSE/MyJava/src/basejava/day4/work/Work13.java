package basejava.day4.work;

import java.util.Arrays;

public class Work13 {
    //  定义一个数字数组，将数组中所有出现次数小于3的数值全部删除，最后从小到大排序打印

    // 创建delElement方法
    public static int [] delElement (int [] numArray){

        // 遍历数组，删除数组元素出现次数小于3的元素
        int delCount = 0; // 删除元素个数计数器

        for (int i = 0; i < numArray.length-delCount; i++) {

            // 统计前先判断当前元素是否被统计过，若未统计，则统计
            //判断是否被统计操作
            boolean isExist = false; // 假设未被统计
            for (int j = 0; j < i; j++) {
                if (numArray[i] == numArray[j]) {
                    isExist = true;
                    break;// 被统计过则结束循环
                }
            }

            //统计、删除操作
            if (!isExist){ // 未被统计执行统计操作

                // 统计操作
                int existCount = 0; // 出现个数计数器
                for (int j = i; j < numArray.length; j++) {
                    if (numArray[i] == numArray [j]){
                        existCount++;
                    }
                }
                int num = numArray[i];
                System.out.println(numArray[i]+""+existCount);
                // 删除操作
                if (existCount < 3){ // 删除次数小于3的
                    delCount++;  // 删除元素计数
                    // 删除操作
                    for (int k = i; k < numArray.length-1; k++) {
                        numArray[k] = numArray[k+1]; // 前移
                    }
                    numArray[numArray.length-1] = 0; // 数组尾元素置0
                    i--; // 防止连续的元素漏删
                }
                System.out.println("删除步骤:"+Arrays.toString(numArray));
            }
        }

        // 排序操作
        for (int i = 0; i < numArray.length; i++) { // 被比较数下标
            for (int j = i+1; j < numArray.length; j++) { // 比较数的下标
                if (numArray[i] > numArray[j]){ // 从小到大排序
                    int temp = numArray[i];
                    numArray[i] = numArray [j];
                    numArray[j] = temp;
                }
            }
        }

        return numArray;
    }
    // 主函数
    public static void main(String[] args) {
        int [] arr = {0,1,2,3,2,3,4,4,4,0};
        System.out.println("删除之前:"+Arrays.toString(arr));
        System.out.println("删除之后:"+Arrays.toString(delElement(arr)));
    }


}
