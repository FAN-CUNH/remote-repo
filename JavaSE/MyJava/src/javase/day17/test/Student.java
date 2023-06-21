package javase.day17.test;

/**
 * @ClassName Student
 * @Description 学生模板类
 * @Author Cunhao Fan
 * @Date 2023/4/26 11:23
 * @Version 1.0
 */
public class Student {
    private String stuNo;
    private String stuName;
    private int stuAge;
    private double stuStature;

    public Student(String stuNo, String stuName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
    }

    public Student(String stuNo, int stuAge) {
        this.stuNo = stuNo;
        this.stuAge = stuAge;
    }

    public Student() {
    }

    public Student(String stuNo, String stiName, int stuAge) {
        this.stuNo = stuNo;
        this.stuName = stiName;
        this.stuAge = stuAge;
    }

    public Student(int stuAge, double stuStature) {
        this.stuAge = stuAge;
        this.stuStature = stuStature;
    }

    public Student(String stuNo, String stuName, int stuAge, double stuStature) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuStature = stuStature;
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

    public void setStuName(String stiName) {
        this.stuName = stiName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", stuStature=" + stuStature +
                '}';
    }
}
