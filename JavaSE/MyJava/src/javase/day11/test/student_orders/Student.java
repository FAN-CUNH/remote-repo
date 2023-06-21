package javase.day11.test.student_orders;

public class Student {
    String stuNo;
    String stuName;

    public Student(String stuNo, String stuName) {
        this.stuNo = stuNo;
        this.stuName = stuName;
    }

    public Student() {
    }

    /*setget*/
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
