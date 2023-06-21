package basejava.day5.work;

public class Work0 {
        // 定义方法完成数组中某个元素出现出现次数的统计
    public static void existCount (int [] numArray){ // 统计数组中某个元素的次数，并返回次数
        // existCount:
        for (int i = 0; i < numArray.length; i++) { // 被统计数下标
            // 判断是进行统计操作
            boolean isExist = false; // 假设当前数前面没出现，则进行统计
            for (int j = 0; j < i; j++) {
                if (numArray[i] == numArray[j]){
                    isExist = true; // 当前数已出现
                    //continue existCount;
                    break ; // 结束循环
                }
            }
            if (!isExist){ // 没出现过才统计
                // 统计元素个数
                int count = 0; // 计数
                for (int j = i; j < numArray.length; j++) { // 当前统计数的下标
                    if (numArray[i] == numArray[j]){ // 被统计数与统计数相同才执行
                        count++; // 计数
                    }
                }
                System.out.print(numArray[i]+"出现的次数"+count+" "+" "); // 打印结果
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,3,2,1};
        existCount(arr); // 调用方法

    }
}
