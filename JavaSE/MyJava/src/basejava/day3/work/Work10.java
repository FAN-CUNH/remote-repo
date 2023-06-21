package basejava.day3.work;

public class Work10 {
    public static void main(String[] args) {
        // 定义一个数组存放5个无规律数值，通过普通for循环和forEach将数组中所有的偶数打印出来
        int [] arr = {1,14,12,5,7};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        System.out.println();

        for (int arr1:arr) {
            System.out.print(arr1+" ");
        }
    }
}
