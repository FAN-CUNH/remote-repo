package javase.day2.work.stucou;

import java.util.Arrays;

public class Student {

    //组合关系
    private Course[] courses;//声明一个类数组course[]存放学生选择的课程
    private int courseCount = 0;
    private String[] courNames = {"语文","数学","英语","Java"}; // 可以选择的课程

    public void setCourse(Course[] course) {
        this.courses = course;
    }

    public Course[] getCourse() {
        return courses;
    }

    public Student() {
        courses = new Course[5];
    }

    public Student(Course[] course) {
        this.courses = new  Course[5];
    }

    //选课   依赖关系

    public void addCourse(Course course){
        if (course != null && (course.getCouName().equals("英语") || course.getCouName().equals("数学") || course.getCouName().equals("语文") ||course.getCouName().equals("Java"))) {
            boolean isExist = false; // 假设此课未选
            for (int i = 0; i < courseCount; i++) {
                if (course.getCouName().equals(courses[i].getCouName())) {
                    isExist = true;
                }
            }
            if (!isExist) {
                courses[courseCount] = course;
                courseCount++;
            }
        }
    }

    //退选
    public void removeCourse(Course course){//要退选的课程
        //所有属性都是放在对象中
        if (course != null){ // 当前参数对象不能为空 否则 空指针报错
            for (int i = 0; i < this.courseCount; i++) { // 当前对象不能为空 否则 空指针报错
                if ( this.courses[i].getCouName().equals(course.getCouName())
                        && this.courses[i].getCouNo().equals(course.getCouNo())){
                    for (int j = i; j < courseCount-1; j++) {
                        courses[j] = courses[j+1]; // 前移
                    }
                    courses[courseCount-1] = null; // 补位
                    courseCount--;
                }
            }
        }else {
            System.out.println("没有此课程，无法删除!!!");
        }

    }

    // 重写toString方法

    @Override
    public String toString() {
        return "{" + Arrays.toString(courses) + ", 课程数" + courseCount +
                '}';
    }
}
