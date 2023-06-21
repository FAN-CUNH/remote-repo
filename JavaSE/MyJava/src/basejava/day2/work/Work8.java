package basejava.day2.work;

public class Work8 {
    public static void main(String[] args) { // 打印1-100以内的奇数
        int sum = 0;
        for (int i = 1; i < 100; i+=2) {
            System.out.println(i);
            sum = sum + i;
        }
        System.out.println("1-100内的奇数和为："+sum);
    }
}
