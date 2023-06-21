package javase.day4.work.work5;

public class Singleton2 {
    // 饿汉式
    private static final Singleton2 singleton = new Singleton2();
    private Singleton2(){};
    public static Singleton2 getInstance(){
        return singleton;
    }
}
