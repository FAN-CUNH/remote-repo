package basejava.day2.test;

public class ForFor {
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++){ // 行数
            for (int j = 0;j <= 3; j++){ // 每行个数
                System.out.print("*");
            }
            System.out.println(); // 换行
        }
        System.out.println();//换行
        System.out.println();//换行

        for(int i = 1; i <= 4; i++){ // 四行
            for (int j =1;j<= i*2-1; j++){ // 判断条件为每行个数最大值
                System.out.print("*"); // 打印
            }
            System.out.println(); // 换行
        }
        System.out.println(); // 换行
        // 0+1+2+....+100 = ???
        int sum = 0;
        for (int i =0;i <= 100;i++){ // 传统算法
            sum = sum + i;
        }
        System.out.println(sum);

        // 加数 add  被加数 aug
        // 结果以0+1+2+...+100形式显示
        int add = 0;
        for (int aug = 1;aug <= 100;aug++){
            add = add + aug;
            System.out.print(aug);
            if (aug < 100){
                System.out.print("+");
            }
            else {
                System.out.print("=");
            }
        }
        System.out.println(add);

    }
}
