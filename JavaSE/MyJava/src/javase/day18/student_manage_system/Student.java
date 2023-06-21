package javase.day18.student_manage_system;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Student
 * @Description 学生模板类
 * @Author Cunhao Fan
 * @Date 2023/4/28 10:25
 * @Version 1.0
 */
public class Student {
    /*私有成员变量*/
    private String stuNo;
    private String stuName;
    private int stuAge;
    private Sex stuSex;
    private List<Course> courses = new ArrayList<Course>(); // 用于存放学生已选择的课程
    /*构造方法*/
    public Student(String stuName, int stuAge, Sex stuSex, List<Course> courses) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuSex = stuSex;
        this.courses = courses;
    }

    public Student() {
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Sex getStuSex() {
        return stuSex;
    }

    public void setStuSex(Sex stuSex) {
        this.stuSex = stuSex;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
    
    /*成员方法*/
    /**
    * @Description: 
    * @Param: [course]
    * @Return: void 
    * @Author: Cunhao Fan
    * @Data: 2023/4/28 13:03
    */
    public void addCousre(Course course) {
        if (courses.contains(course)){
            System.out.println("该课程已选！");
        }else {
            courses.add(course);
            System.out.println(course.getCouName()+"选择成功！");
        }
    }
    /**
    * @Description: 封装删除学生课程
    * @Param: [course]
    * @Return: void
    * @Author: Cunhao Fan
    * @Data: 2023/4/28 16:41
    */
    public void delCousre(Course course) {
        if (courses.contains(course)){
            courses.remove(course);
        }else {
            System.out.println(course.getCouName()+"没有选择过该课程，不可退课！");
        }
    }

    /*重写toString*/
    @Override
    public String toString() {
        return "Student{" +
                "stuNo=" + stuNo +
                ", stuName='" + stuName +
                ", stuAge=" + stuAge +
                ", sex=" + stuSex +
                ", courses=" + courses +
                '}';
    }
}
