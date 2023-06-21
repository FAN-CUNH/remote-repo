package javase.day18.unit_work.reflect_work;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/3 15:52
 * @Version 1.0
 */
public class Student {
    private String name;
    private int age;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
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

    public void show(String s) {
        System.out.println(s);
    }

    public void run() {
        System.out.println("welcome to igeek!");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
