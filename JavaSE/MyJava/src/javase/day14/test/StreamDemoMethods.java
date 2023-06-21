package javase.day14.test;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDemoMethods {
    public static void main(String[] args) {
        //1 定义集合，存放3个学生信息
        ArrayList<Student> students = new ArrayList<Student>();
        Student student = new Student(23, "01");
        Student student1 = new Student(19, "02");
        Student student2 = new Student(25, "03");
        students.add(student);
        students.add(student1);
        students.add(student2);
        //获取Stream
        Stream stream = students.stream();
        // 2 查看学生的基本信息
       /* stream.forEach((everyStu)->{
            System.out.println(everyStu);
        });*/
        // stream.forEach(System.out::println);
        //Consumer<Student> consumer = everyStu-> System.out.println(everyStu.getStuNo());

        //everyStu：Object是默认类型
        stream.forEach(everyStu -> System.out.println(((Student) everyStu).getStuNo()));
        stream.close();//关闭流

        //获取Stream
        Stream stream1 = students.stream();
        //count方法
        long count = stream1.count();
        stream1.close();
        System.out.println("stream流中操作的元素的个数：" + count);
        //  统计年龄大于20岁的元素的人数:filter
        Stream stream2 = students.stream();
        Predicate<Student> predicate = (everyStu) -> everyStu.getAge() > 20;
        long count2 = stream2.filter(predicate).count();
        System.out.println("年龄大于20的人数：" + count2);

        //打印  年龄大于23同时，学号中没有字母的所有学生信息？？？

    }
}
