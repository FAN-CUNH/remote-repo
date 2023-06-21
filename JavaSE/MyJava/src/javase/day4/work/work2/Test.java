package javase.day4.work.work2;

public class Test {
    public static void main(String[] args) {
        // 实例化接口对象
        Service service = new ServiceDao();
        service.print();
        service.print1();
    }
}
