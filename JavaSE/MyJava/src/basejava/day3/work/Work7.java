package basejava.day3.work;

public class Work7 {
    public static void main(String[] args) {
        //将100以内的偶数放置到数组，并且打印数组的第6个元素；并且通过普通for循环和forEach打印数组的全部元素
        int [] arr = new int[50];

        int j = 0;

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){

                // System.out.print(i+" ");
                arr[j] = i; // 将得到的每个偶数存入数组
                System.out.print(arr[j]+" ");
                j++; // 数组下标自增
            }
        }
        System.out.println();
        System.out.println("第六个元素是"+arr[5]); //输出第六个元素

        for (int arr1:arr) { // forEach输出数组
            System.out.print(arr1+" ");
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
