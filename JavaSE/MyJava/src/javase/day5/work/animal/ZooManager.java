package javase.day5.work.animal;

public class ZooManager {
    private String name;
    private int age;
    // 行为
    public void feed(Animal myAni){
        myAni.eat();
    }
    public void letItShow(Actor a){
        a.paly();
        if (a instanceof Parrot){
            ((Parrot) a).say(); // 向下转型
        }
    }

    public ZooManager(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public ZooManager() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
