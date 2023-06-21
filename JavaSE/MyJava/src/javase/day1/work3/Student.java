package javase.day1.work3;

public class Student {
    // 声明5个私有成员变量
    private String stuNo;
    private String stuName;
    private String stuSex;
    private double stuHight;
    private int  stuAge;
    // 无参构造方法
    public Student(){

    }
    // 有参构造方法
    public Student(String stuNo,String stuName,String stuSex,double stuHight,int stuAge){
        this.stuNo = stuNo;
        this.stuSex = stuSex;
        this.stuName = stuName;
        this.stuHight = stuHight;
        this.stuAge = stuAge;
    }
    // setget方法

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
}
