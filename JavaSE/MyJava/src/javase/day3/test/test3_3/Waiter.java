package javase.day3.test.test3_3;

public class Waiter extends Person{
    public Waiter(String name, int age) {
        super(name, age);
    }

    public Waiter() {
    }

    // 上菜行为
    public void serving(){
        System.out.print("上菜");
    }
}
