package javase.day3.test.test3_3;

public class Test {
    public static void main(String[] args) {
        Waiter waiter = new Waiter("景甜",18);
        System.out.print(waiter.getAge()+"的服务员"+waiter.getName());
        waiter.speck();
        waiter.serving();
    }
}
