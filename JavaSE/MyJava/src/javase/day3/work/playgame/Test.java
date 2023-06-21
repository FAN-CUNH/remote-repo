package javase.day3.work.playgame;

public class Test {
    public static void main(String[] args) {
        // 实例化手机对象和人物对象
        Phone phone = new Phone("iphone");
        Person person = new Person("景甜",18);
        // 调用方法
        person.usePhone(phone);
    }
}
