package javase.day4.test.singleton;

public class Singleton {
    // 懒汉式
    // 1.构造方法私有 2.提供静态方法返回本类对象 3.提供静态的成员变量代表本类对象信息
    /*private static Singleton singleton1;
    private Singleton(){};
    public static Singleton getInstance(){
        if (singleton1 == null){
            singleton1 = new Singleton();
        }
        return singleton1;
    }*/
}
