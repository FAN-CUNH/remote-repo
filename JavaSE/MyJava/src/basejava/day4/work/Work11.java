package basejava.day4.work;

public class Work11 {
    // 在课上代码基础上实现：将数值数组中次数出现偶数个的全部元素打印出来，格式为12出现4次

    // 创建evenPrint方法
    public static void evnePrint (int [] numArray){
        // 遍历数组
        for (int i = 0; i < numArray.length; i++) {
            // 判断当前数字是否被统计
            boolean isExist = false; // 假设未被统计
            for (int j = 0; j < i; j++) { // 验证假设
                if (numArray[i] == numArray[j]) { // 假设不成立
                    isExist = true;
                    break; // 只要发现前面出现过就结束循环
                }
            }
            if (!isExist){ // 假设成立
                // 统计操作
                int eleCount = 0;
                for (int j = i; j < numArray.length; j++) {
                    if (numArray[i] == numArray [j]){
                        eleCount++;
                    }
                }
                //
                if (eleCount % 2 == 0){
                    System.out.println(numArray[i]+"出现"+eleCount+"次");
                }

            }
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,1,2,3,4,4,4,5,4,3,2,1};
        evnePrint(arr);

    }
}
