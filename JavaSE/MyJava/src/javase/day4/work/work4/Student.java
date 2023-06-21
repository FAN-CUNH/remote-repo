package javase.day4.work.work4;

public class Student {
    // 私有成员变量
    private String stuName;
    private String stuNo;
    // 构造方法

    public Student(String stuName, String stuNo) {
        this.stuName = stuName;
        this.stuNo = stuNo;
    }

    public Student() {
    }

    // setget方法 设置/获取成员变量的值

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getstuNo() {
        return stuNo;
    }

    public void setstuNo(String stuNo) {
        this.stuNo = stuNo;
    }
    // 重写toString

    @Override
    public String toString() {
        return "{" +
                "姓名：" + stuName +
                ", 学号：" + stuNo +
                '}';
    }
}
