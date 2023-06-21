package javase.day1.work5;

public class Student {
    // 声明3个私有成员变量
    private String stuName;
    private int stuAge;
    private String stuContent;
    // 构造方法

    public Student() {

    }

    public Student(String stuName, int stuAge, String stuContent) {
        this.stuName = stuName;
        this.stuAge = stuAge;
        this.stuContent = stuContent;
    }
    // setget方法

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

    public String getStuContent() {
        return stuContent;
    }

    public void setStuContent(String stuContent) {
        this.stuContent = stuContent;
    }
    // 吃饭行为
    public void eat(){
        System.out.println("年龄为"+this.getStuAge()+"的"+this.getStuName()+"同学正在吃饭");
    }
    // 学习行为
    public void study(){
        System.out.println("年龄为"+this.getStuAge()+"的"+this.getStuName()+"同学正在专心致志的听着"+this.getStuContent());
    }

}
