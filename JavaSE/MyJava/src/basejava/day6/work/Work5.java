package basejava.day6.work;

public class Work5 {
    // 数组反转
    // (1)键盘录入5个int类型的数据存储数组arr中
    // (2)定义方法将arr数组中的内容反转
    // (3)定义方法对反转后的数组进行遍历

    // 数组元素逆置
    public static int [] reverseArray (int [] arr){
        // 让第一位和最后一位交换位置，第二位和倒数第二位交换
        for (int i = 0; i < arr.length / 2; i++) { // 只循环数组的一半即可
                int temp = arr[i];
                arr[i] = arr[arr.length-(i+1)];
                arr[arr.length-(i+1)] = temp;
        }
        return arr;
    }

    // 打印数组
    public static void printArray(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        int [] arr = {2,1,3,5,4};
        printArray(arr);
        System.out.println();
        printArray(reverseArray(arr));
    }
}
