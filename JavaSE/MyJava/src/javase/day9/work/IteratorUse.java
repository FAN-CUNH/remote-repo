package javase.day9.work;

import java.util.*;

/**
 * @ClassName IteratorUse
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/17 19:37
 * @Version 1.0
 */
/*自定义学生类*/
class Student{
    private String name;
    private int age;
    private int grades;

    public Student(String name, int age, int grades) {
        this.name = name;
        this.age = age;
        this.grades = grades;
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

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }
}
public class IteratorUse {
    public static void main(String[] args) {
        /*实例化并且初始集合*/
        List<String>arrayList = new ArrayList<String>(Arrays.asList("abc1","abc2","abc3","abc4"));
        /*获取集合的迭代器*/
        Iterator<String> iterator = arrayList.iterator();
        /*循环遍历集合元素，条件hasNext()不为空(即下一个元素存在)*/
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.print(str+" ");
        }
        System.out.println();
        /*实例化五个学生对象*/
        Student student1 = new Student("张三",23,88);
        Student student2 = new Student("李四",22,99);
        Student student3 = new Student("王二",21,55);
        Student student4 = new Student("麻子",24,77);
        Student student5 = new Student("尼古拉斯赵六",22,100);
        /*实例化studentList*/
        List<Student>studentList = new ArrayList<Student>(Arrays.asList(student1,student2,student3,student4,student5));
        /*获取迭代器*/
        Iterator<Student>iterator1 = studentList.iterator();
        /*定义总分，最高分，最低分*/
        int getScoreSum,maxScore,minScore,averageScore;
        getScoreSum = maxScore = minScore = averageScore = 0;
        /*使用迭代器判断是否有下一个学生，有则获取学生对象的成绩*/
        while (iterator1.hasNext()){
            /*总分*/
            getScoreSum = getScoreSum + iterator1.next().getGrades();
        }
        /*判断是不是最大值*/
        for (int i = 0; i < studentList.size(); i++) {
           /*假设第一位就是最大值/最小值*/
            if (studentList.get(maxScore).getGrades() < studentList.get(i).getGrades()){
                maxScore = i;
            }
            if (studentList.get(minScore).getGrades() > studentList.get(i).getGrades()){
                minScore = i;
            }
        }
        averageScore = getScoreSum / studentList.size();
        System.out.println("总成绩为："+getScoreSum+" "+"最高分："+studentList.get(maxScore).getGrades()+" "+"最低分："+studentList.get(minScore).getGrades()+" "+"平均分："+averageScore);
    }
}
