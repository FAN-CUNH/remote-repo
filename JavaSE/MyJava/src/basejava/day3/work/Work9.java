package basejava.day3.work;

public class Work9 {
    public static void main(String[] args) {
        // 将100以内的所有素数放置到数组，最后通过forEach和普通for循环打印所有元素
        boolean flag = false;
        int count = 0,x = 1;
        int [] arr = new int[100];

        for (int i = 2; i < 100; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    flag = true; // 非素数
            }
            if (!flag){
                arr[count] = i;
                System.out.print(arr[count]+" ");
                count++;
            }
            flag = false;
        }

        System.out.println();

        for (int arr1:arr) {
            if(arr1 == 0)
                continue;
            System.out.print(arr1+" ");

        }

    }
}
