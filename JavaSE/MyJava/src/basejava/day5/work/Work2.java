package basejava.day5.work;

public class Work2 {
    // 定义方法完成得到某个数组中所有元素的和
    public static int numSum (int [] numArray){
        // 求和
        int sum = 0;
        for (int i = 0; i < numArray.length; i++) {
            sum = sum + numArray[i];
        }
        return sum;
    }

    // 调用方法
    public static void main(String[] args) {
        System.out.println("数组元素之和为："+numSum(new int [] {1,2,3,4,5}));
    }
}
