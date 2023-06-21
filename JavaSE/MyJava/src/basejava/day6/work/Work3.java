package basejava.day6.work;

public class Work3 {
    // 不死神兔问题(斐波那契数列问题) 1 1 2 3 5 8.....
    // 每对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问第二十个月的兔子对数为多少？
    // 创建immortalRabbit
    public static int immortalRabbit(int month){
        if (month ==  1){
            return  1;
        }
        if (month ==2)
        return 1;
        return immortalRabbit(month-2)+immortalRabbit(month-1); // 递归调用
    }

    public static void main(String[] args) {
        System.out.println(immortalRabbit(5));
    }
}
