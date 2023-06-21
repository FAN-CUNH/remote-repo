package basejava.day4.test;

public class ArrayChange {
    public static void main(String[] args) {
        // 给定数组存放字母，大写变小写，否则不动。
        // 定义数组
        char[] arr = {'A','a','c','Z','z'};

        // 赋值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z'){
                arr[i] = (char)(arr[i] + 32) ;
            }
        }
        // 遍历
        for (char every:arr
             ) {
            System.out.print(every+" ");
        }

        // 将数组上的数据（数字）只保留最后一位重新放入数组

        // 删除： 给定数组，要求删除第一个2

        int [] arr1 = {2,3,4,5,6,2,2,4,8};
        // 遍历查找第一个2
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == 2){
                System.out.println("下标为："+i);
            }
            // 前移覆盖
            for (int j = 0; j < arr1.length-1; j++) { // 数组元素个数减1
                arr1[j] = arr1[j+1];
            }
            arr1[arr1.length-1] = 0; // 最后一个元素置0
            break;
        }
        // 遍历输出
        for (int every:arr1) {
            System.out.print(every+" ");
        }

        System.out.println();

        // 删除第三个2

        int [] arr2 = {1,2,3,2,2,5,2,2,7,9};
        int count = 0; // 计数器
        for (int i = 0; i < arr2.length; i++) { // 遍历数组

            if (arr2[i] == 2){ // 查找所有的数字2

                count++; // 计数
                if (count == 3){ // 找到第三个2
                    System.out.println(i); // 输出第三个2的下标

                    for (int j = i; j < arr2.length-1; j++) { // 前移
                        arr2[j] = arr2[j+1];
                    }
                    arr2[arr2.length-1] = 0; // 置0
                }

            }

        }

        for (int every:arr2) {
            System.out.print(every+" ");
        }

        System.out.println();

        // 删除所有的2

        int [] arr3 = {1,3,2,4,5,6,4,2,2,3,2,9};

        for (int i = 0; i < arr3.length; i++) { // 循环遍历

            if (arr3[i] == 2){ // 找到数组元素为2的下标

                for (int j = i; j < arr3.length-1; j++) { // 循环前移覆盖
                    arr3[j] = arr3[j+1];
                }

                arr3[arr3.length-1] = 0; // 尾数置0
                i--; // 为防止连续的2漏查 下标前移

            }

        }

        for (int every:arr3) {
            System.out.print(every+" ");
        }

    }
}
