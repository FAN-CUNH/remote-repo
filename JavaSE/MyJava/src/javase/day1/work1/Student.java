package javase.day1.work1;

public class Student {
    // 封装Student类，成员变量private String stuName;private String stuNo;private
    // int stuAge;编写setget方法；封装StudentTest完成实例化1个学生对象，并且同时完成给成
    // 员变量赋值；最后打印学生对象的成员变量值

    // 声明了3个私有成员变量，分别表示学生姓名，学生编号，学生年龄
    private String stuName;
    private String stuNo;
    private int stuAge;
    // 构造方法
    public Student(){

    }

    // setget 方法
    public void setStuName(String stuName){ //
        this.stuName = stuName;
    }
    public String getStuName(){
        return stuName;
    }
    public void setStuNo(String stuNo){
        this.stuNo = stuNo;
    }
    public String getStuNo(){
        return stuNo;
    }
    public void setStuAge(int stuAge){
        this.stuAge = stuAge;
    }
    public int getStuAge(){
        return stuAge;
    }
}
