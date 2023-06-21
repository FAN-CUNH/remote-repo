package javase.day20.unitwork;

import java.util.concurrent.Exchanger;

/**
 * @ClassName Exchange_work
 * @Description 使用Exchange完成使用2个线程将不同的2个学生对象完成交换并打印对象信息
 * @Author Cunhao Fan
 * @Date 2023/5/7 17:49
 * @Version 1.0
 */
class Student {
    /*声明一个成员变量name,用于表示学生姓名*/
    private String name;
    /*声明一个成员变量age,用于表示学生年龄*/
    private int age;

    /*构造方法*/
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Student() {
    }

    @Override
    public String toString() {
        return "name=" + name + ", age=" + age;
    }
}

class Mythread1 extends Thread {
    /*声明Exchange成员变量,用于和其他线程交换信息*/
    Exchanger<Student> exchanger;
    Student student;

    /*构造方法*/
    public Mythread1(String name, Exchanger<Student> exchanger, Student student) {
        super(name);
        this.exchanger = exchanger;
        this.student = student;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程1的到线程2的值"+exchanger.exchange(student));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}class Mythread2 extends Thread {
    /*声明Exchange成员变量,用于和其他线程交换信息*/
    Exchanger<Student> exchanger;
    Student student;

    /*构造方法*/
    public Mythread2(String name, Exchanger<Student> exchanger, Student student) {
        super(name);
        this.exchanger = exchanger;
        this.student = student;
    }

    @Override
    public void run() {
        try {
            System.out.println("线程2得到线程1的值"+exchanger.exchange(student));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Exchange_work {
    public static void main(String[] args) {
        /*实例化两个学生*/
        Exchanger<Student> exchanger = new Exchanger<>();
        Student student1 = new Student("刘子龙", 23);
        Student student2 = new Student("曹乘博", 24);

        /*实例化两个线程*/
        Mythread1 mythread1 = new Mythread1("改名", exchanger, student1);
        Mythread2 mythread2 = new Mythread2("改年龄", exchanger, student2);

        /*启动线程*/
        mythread1.start();
        mythread2.start();
    }
}
