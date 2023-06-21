package javase.day2.work.stucou;

public class StudentDemo {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();

        //课程
        Course course1 = new Course("01","语文");
        Course course2 = new Course("02","数学");
        Course course3 = new Course("03","英语");
        Course course4 = new Course("04","Java");

        //选课
        student1.addCourse(course1);
        student1.addCourse(course2);
        student1.addCourse(course3);
        student1.addCourse(course4);
        student2.addCourse(course4);
        System.out.println("学生1的信息为:"+student1);
        System.out.println("学生2的信息为:"+student2);
        //退选
        student1.removeCourse(course1);
        student1.removeCourse(course3);
        student2.removeCourse(course2);
        System.out.println("学生1的信息为:"+student1);
        System.out.println("学生2的信息为:"+student2);

    }
}
