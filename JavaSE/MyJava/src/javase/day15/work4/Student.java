package javase.day15.work4;

import java.io.Serializable;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/24 20:14
 * @Version 1.0
 */
/*序列化学生模版类*/
public class Student implements Serializable {
    private String stuNo;
    private String stuName;

    public Student(String stuNo, String stuName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
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

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", stuName='" + stuName + '\'' +
                '}';
    }
}
