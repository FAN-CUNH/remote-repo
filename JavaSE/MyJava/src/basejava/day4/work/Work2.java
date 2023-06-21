package basejava.day4.work;

public class Work2 {
    public static void main(String[] args) {
        // 定义一个数字数组，将数组中所有的水仙花数打印出来并且求和打印，格式如下：
        //  153+.....=和
        int [] arr = new int[4];
//        for (int i = 100; i < 999; i++) { // 给数组存入900个数
//            arr[i-100] = i;
//        }
        // 求水仙花数
        int dig,sum = 0; // dig 每个位的数
        int count = 0; // 计数器-->作为数组元素下标使用
        for (int i = 100; i < 999; i++) {
            int num = i; // 中间值
            int mul = 0; // 存各个位的数的立方和
            for (int j = 0; j < 3; j++) {
                dig = num % 10; // 取每个位的数
                num = num / 10;
                mul += dig*dig*dig; // 各个位的数的立方和
            }
            if (i == mul){ // 是水仙花数
                System.out.print(i+" ");
                sum = sum + i;
                arr[count] = i; // 存入数组
                count++; // 下标后移
            }
        }
        System.out.println();
        String str = "+",str1 = "=";
        // 153+370+371+407=
        for (int l = 0; l < arr.length; l++) {
            System.out.print(arr[l]);
            if (l < arr.length-1){  // 不是最后一个数字 打印 “+”
                System.out.print(str);
            }
            if (l == arr.length-1){ // 最后一个数字 打印 “=”
                System.out.print(str1+sum);
            }
        }


    }
}
