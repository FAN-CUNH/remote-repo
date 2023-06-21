package javase.day14.work.work3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @ClassName Test
 * @Description 定义集合存放学生信息，学生类使用课上的Student;将前3个学生中年龄大于25岁的学生信息全部遍历出来；跳过前4个学生将学号是纯数字的所有学生个数打印出来；尝试通过Stream完成将所有学生的年龄都+1最后打印学生信息
 * @Author Cunhao Fan
 * @Date 2023/4/23 16:36
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student(26,"01");
        Student student1 = new Student(19,"02");
        Student student2 = new Student(25,"03");
        Student student3 = new Student(23,"01");
        Student student4 = new Student(19,"0fgd2");
        Student student5 = new Student(25,"03");
        ArrayList<Student> stuList = new ArrayList<Student>(Arrays.asList(student,student1,student2,student3,student4,student5));
        /*获取stream流*/
        Stream<Student> studentStream = stuList.stream();
        /*调用limit()方法 括号中填写要取的个数 取流的前三个,然后再调用forEach()遍历年龄大于25的学生*/
        Predicate<Student> predicate = everyStudet -> everyStudet.getAge() > 25;
        studentStream.limit(3).forEach(everystudent -> {
            if (predicate.test(everystudent)){
                System.out.println(everystudent.getAge()+" ");
            }
        });
        studentStream.close();
        Stream<Student> studentStream1 = stuList.stream();
        /*使用Skip()方法 括号中是跳过的个数*/
        studentStream1.skip(4).filter(student6 -> student6.getStuNo().matches(("\\d+"))).forEach(System.out::println);
    }
}
