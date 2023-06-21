package javase.day16.studentmanage;

/**
 * @ClassName Student
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/25 19:20
 * @Version 1.0
 */
public class Student {
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
        return "[" + "stuNo=" +stuNo+","+"stuName=" + stuName + ']';
    }
}

