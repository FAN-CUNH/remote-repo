package javase.day4.work.work5;

public class Singleton1 {
    // 懒汉式
    private static Singleton1 singleton1;
    private Singleton1 (){};
    // 方法
    public static Singleton1 singleton1(){
        if (singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
