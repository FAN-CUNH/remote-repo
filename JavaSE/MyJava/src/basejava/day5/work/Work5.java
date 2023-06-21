package basejava.day5.work;

import java.util.Arrays;

public class Work5 {
    // 定义数组完成将数组中某个位置的元素修改为原数值拼接1比如12就变成121
    public static int [] addString (int [] numArray,int index){
        // 修改数组元素的值
        for (int i = 0; i < numArray.length; i++) {
            if (i == index){
                numArray[i] = Integer.parseInt(numArray[i]+"1");
                break;
            }
        }
        return numArray;
    }
    // 调用
    public static void main(String[] args) {
        System.out.print("修改后的数组:"+Arrays.toString(addString(new int [] {1,2,3,4,5},2)));
        // 优化：index 大于数组长度 或者 为负数


    }
}
