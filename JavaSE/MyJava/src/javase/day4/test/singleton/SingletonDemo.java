package javase.day4.test.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        // 懒汉式
        Singleton singleton = new Singleton();
        Singleton singleton1 = new Singleton();
        System.out.println(singleton.equals(singleton1));
        // 饿汉式
        Singleton2 singleton2 = new Singleton2();
        Singleton2 singleton21 = new Singleton2();
        System.out.println(singleton2.equals(singleton21));
    }
}
