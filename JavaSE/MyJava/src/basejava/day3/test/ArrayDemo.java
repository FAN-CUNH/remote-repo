package basejava.day3.test;

public class ArrayDemo {
    public static void main(String[] args) {
        // 第一种定义方式
        // 数组数据类型[] 数组名 = new 数据的数据类型[数据的个数]
        int[] arr = new int[100]; // 数组中没有值 预留4*100个字节
        // 第二种
        // 数组数据类型[] 数组名 = {数值1，数值2，数值3};
        int[] arr1 = {1,2,3};

        System.out.println("arr的长度："+arr.length);
        System.out.println("arr的长度："+arr1.length);
        System.out.println("第二个数"+arr1[1]);

        // 数值的赋值和取值 注意！！！下标别越界
        // 将1-100放入第一个数组
        for (int i = 0; i <= arr.length-1; i++) { // 表示数组的标
            arr[i] = i + 1; // 给每个元素赋值
            System.out.print(arr[i]+" ");
        }
        System.out.println(arr[2]);
        for (int evershu:arr) {
            System.out.print(evershu+" ");
        }
    }
}
