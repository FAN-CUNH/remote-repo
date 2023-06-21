package javase.day3.work.call;

public class Test {
    public static void main(String[] args) {
        Phone iphone = new Phone("iphone",8000);
        Person person1 = new Person("白百何",38,iphone);
        Person person2 = new Person();
        person2.setName("羽凡");
        person1.callTo(person2);
    }
}
