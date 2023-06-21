package javase.day14.test;

import java.util.ArrayList;
import java.util.Collections;


public class StaticMethod_ShiLiMethod {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        Student student = new Student(23,"01");
        Student student1 = new Student(19,"02");
        Student student2 = new Student(25,"03");
        students.add(student);
        students.add(student1);
        students.add(student2);
        //集合排序
        //labda
        Collections.sort(students,((o1, o2) -> o1.getAge() - o2.getAge()));
        //方法调用
        Collections.sort(students,((o1, o2) -> StaticMethod_ShiLiMethod.compareAge(o1,o2) ));
        //1   静态方法调用
        Collections.sort(students,StaticMethod_ShiLiMethod::compareAge);
        //查看有没有排序
        System.out.println("字符串表示形式："+students);
        //查看学生的年龄是否被排序了
/*
        Consumer<Student> consumer = (everyStu)-> System.out.println(everyStu.getAge());
*/
        //2 实例方法调用
        students.forEach((everyStu)-> System.out.println(everyStu));
        students.forEach(System.out::println);//




    }
    //静态方法
    public static int compareAge(Student o1,Student o2){
        return o1.getAge() - o2.getAge();
    }
}
