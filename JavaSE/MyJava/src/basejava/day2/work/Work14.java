package basejava.day2.work;

public class Work14 {
    public static void main(String[] args) {
        /*
        *
        * 分析：
        什么是水仙花数呢?
        所谓的水仙花数是指一个三位数[100,999]，其各位数字的立方和等于该数本身。
        举例：153就是一个水仙花数。
        153 = 1*1*1 + 5*5*5 + 3*3*3
        for循环实现统计水仙花的个数
        *
        */
        int count = 0;
        for (int i=100; i < 999; i++) {
            int hei = i / 100,mid = i % 100 /10,low = i % 10;
            if (i == hei*hei*hei+mid*mid*mid+low*low*low){
                count++;
                System.out.print(i);
                System.out.print(" ");
            }
        }
        System.out.println("水仙花树个数："+count);
    }
}
