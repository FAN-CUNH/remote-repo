package javase.day4.work.work2;

public class ServiceDao implements Service{
    @Override
    public void print() {
        System.out.println("打印");
    }

    @Override
    public void print1() {
        System.out.println("打印1");
    }
}
