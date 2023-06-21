package basejava.day3.work;

public class Work6 {
    public static void main(String[] args) {
        // 通过数组的第一种定义方式定义一个可以存放50个数据的数组，然后将1-50放入数组，最后打印第23个数值
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println(arr[22]);
    }
}
