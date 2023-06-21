package javase.day4.work.work4;

import java.util.Arrays;

public class StuSerIntConTest { // 测试
    public static void main(String[] args) {
        // 实例化学生接口控制器
        StudentController studentController = new StudentController();
        // 实例化学生
        Student student1 = new Student("张三","001");
        Student student2 = new Student("李四","002");
        Student student3 = new Student("王2","003");
        Student student4 = new Student("王二","003");
        Student student5 = new Student("麻子","004");
        System.out.println("测试类的学生对象："+student1);

        studentController.addStudent(student1);
        studentController.addStudent(student2);
        studentController.addStudent(student3);
        studentController.addStudent(student5);
        System.out.println("添加操作后："+Arrays.toString(studentController.student));

        studentController.deleteStudent("001");
        System.out.println("删除操作后："+Arrays.toString(studentController.student));

        studentController.updateStudent(student4);
        System.out.println("更新操作后："+Arrays.toString(studentController.student));

        studentController.searchStudent("003");
    }
}
