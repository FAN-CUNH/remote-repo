package javase.day6.work.work8;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/13 20:44
 * @Version 1.0
 */
public class Student {
    /*私有成员变量*/
    private String stuNo;
    private String stuName;
    private Course[] courses; // 存放学生选择课程
    /*构造方法*/
    public Student(String stuNo, String stuName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.courses = new Course[3];
    }
    public Student() {
        courses = new Course[3];
    }
    /*setget方法*/

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

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    /*选课方法*/
    int courseCount = 0;
    public void addCourse (Course course){
        /*判断course是否存在课程数组中*/
        boolean isExist = false;
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCouName().equals(course.getCouName())){
                System.out.println("已经选课，不能重选");
                isExist = true;
                break;
            }
        }
        if (!isExist){
            courses[courseCount] = course;
            courseCount++;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
