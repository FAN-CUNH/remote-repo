package javase.day2.test.test1;

public class Student {
    //     // 封装学生类信息和要求同word文档，封装课程类信息和要求同word文档；
    //    // 在学生中定义成员变量存储学生可以选择的一门课程，编写方法完成zhan
    //    // gsan选择语文这门课程；最后调用方法测试

    // 声明5个私有成员变量
    private String stuNo;
    private String stuName;
    private String stuSex;
    private double stuHight;
    private int  stuAge;
    private Course selCou;
    //setget

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

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public double getStuHight() {
        return stuHight;
    }

    public void setStuHight(double stuHight) {
        this.stuHight = stuHight;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public Course getSelCou() {
        return selCou;
    }

    public void setSelCou(Course selCou) {
        this.selCou = selCou;
    }
    // 构造器

    public Student() {
    }

    public Student(String stuNo, String stuName, String stuSex, double stuHight, int stuAge, Course selCou) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuHight = stuHight;
        this.stuAge = stuAge;
        this.selCou = selCou;
    }
    // 选择课程行为
    public void selCou(){
        System.out.println(this.stuName+"选择"+this.selCou.getCouName()+"这门课程");
    }
}
