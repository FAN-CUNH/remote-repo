package javase.day4.work.work1;

public class B extends A{ // 实体类继承抽象类，必须实现他的的抽象方法
    @Override
    public void out() {
        System.out.println("我是子类实现的out");
    }

    @Override
    public void out1() {
        System.out.println("我是子类实现的out1");
    }
}
