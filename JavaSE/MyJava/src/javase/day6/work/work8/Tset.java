package javase.day6.work.work8;

import java.util.Arrays;

/**
 * @ClassName Tset
 * @Description 测试类：实例化3门课，3个学生；3个学生放入班级；3门课程分别给每个学生即放入类数组；统计最终班级中选择了语文的学生人数
 * @Author Cunhao Fan
 * @Date 2023/4/13 20:46
 * @Version 1.0
 */
public class Tset {
    public static void main(String[] args) {
        /*实例化3门课*/
        Course course1 = new Course("001","语文");
        Course course2 = new Course("002","数学");
        Course course3 = new Course("003","英语");
        /*实例化3个学生*/
        Student student1 = new Student("001","张三");
        Student student2 = new Student("002","李四");
        Student student3 = new Student("003","王二");
        /*实例化3各班级*/
        StudentClass studentClass = new StudentClass("001","三年一班");


        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);
        student2.addCourse(course1);
        student2.addCourse(course2);
        student2.addCourse(course3);
        student3.addCourse(course1);
        student3.addCourse(course2);
        student3.addCourse(course3);
        System.out.println(Arrays.toString(student1.getCourses()));
        System.out.println(Arrays.toString(student2.getCourses()));
        System.out.println(Arrays.toString(student3.getCourses()));
        studentClass.addStudent(student1);
        studentClass.addStudent(student2);
        studentClass.addStudent(student3);
        System.out.println(Arrays.toString(studentClass.getStudents()));

        int count = 0;
        for (int i = 0; i < studentClass.getStudents().length; i++) {
           Student student = studentClass.getStudents()[i];
            for (int j = 0; j < student.getCourses().length; j++) {
                if (student.getCourses()[i].getCouName().equals("语文")){
                    count++;
                }
            }
        }
        studentClass.printAllCoursesName();
        System.out.println(count);


    }
}
