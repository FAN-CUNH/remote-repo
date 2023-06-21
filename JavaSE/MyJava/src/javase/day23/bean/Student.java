package javase.day23.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @packageName javase.day23.bean
 * @ClassName Student
 * @Description 学生类
 * @Author CunHao Fan
 * @Date 2023/5/15 19:10
 * @Version 1.0
 */
public class Student {
    /**
     * 学号
     */
    private String stuNo;

    /**
     * 姓名
     */
    private String stuName;


    /**
     * 年龄
     */
    private int stuAge;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 有参构造方法
     * @param stuNo 学号
     * @param stuName 姓名
     * @param birthday 生日
     */
    public Student(String stuNo, String stuName,int stuAge, Date birthday) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.birthday = birthday;
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

    public String getBirthday() {
        /*转换成字符串形式*/
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
