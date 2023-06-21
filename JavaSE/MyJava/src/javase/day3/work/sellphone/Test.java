package javase.day3.work.sellphone;

public class Test {
    // 实例化手机和人物的匿名对象
    public static void main(String[] args) {
        Person person = new Person("小王");
        System.out.println(person.getName()+"卖出了"+person.sellPhone(new Phone("iphone",6000)));
    }
}
