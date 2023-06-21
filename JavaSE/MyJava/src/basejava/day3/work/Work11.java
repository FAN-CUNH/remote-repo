package basejava.day3.work;

import java.util.Scanner;

public class Work11 {
    public static void main(String[] args) {
        // 定义一个数组存放键盘录入的6个数值，通过forEach打印所有的素数:选做
        int[] arr = new int[6];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            int num = scanner.nextInt();
            arr[i] = num;

        }

/*        for (int i = 0; i < arr.length; i++) {

            if (arr[i]  == 2)
                System.out.print(arr[i]+" ");

            for (int j = 2; j < arr[i]; j++) {

                if (arr[i] % j == 0)
                    break;
                if (j == arr[i] - 1)
                    System.out.print(arr[i]+" ");
            }
            */
            for (int arr1:arr) {
                int j = 2;
                for (; j < arr1 ; j++) {
                    if (arr1 % j == 0){
                        break;
                    }
                }
                if (arr1 == 1)
                    continue;
                if(j>=arr1){
                    System.out.print(arr1+" ");
                }
//            System.out.print(arr1+" ");
        }

        }



    }


