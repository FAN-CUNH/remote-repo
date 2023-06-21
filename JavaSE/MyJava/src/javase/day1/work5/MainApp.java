package javase.day1.work5;

public class MainApp {
    public static void main(String[] args) {
        // 实例化教师对象和学生对象
        Teacher myTea = new Teacher("周志鹏",30,"Java基础中面向对象的知识");
        Student myStu = new Student("韩光",18,"面向对象的知识");
        myTea.eat();
        myTea.lecture();
        myStu.eat();
        myStu.study();
    }
}
