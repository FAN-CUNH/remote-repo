package javase.day5.work.school;

public abstract class Person {
    // 私有成员变量
    private String name;
    private int age;
    // 抽象方法
    public abstract void eat();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    // setget方法

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
