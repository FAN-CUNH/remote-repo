package javase.day1.work2;

public class Teacher {
    // 声明5个私有成员变量,表示教师编号，姓名，性别，年龄，课程
    private String teaNo;
    private String teaName;
    private String teaSex;
    private int teaAge;
    private String teaCourse;
    // 有参构造方法 完成实例初始化的同时变量初始化
    public Teacher(String teaNo,String teaName,String teaSex,int teaAge,String teaCourse){
        this.teaNo = teaNo;
        this.teaName = teaName;
        this.teaSex = teaSex;
        this.teaAge = teaAge;
        this.teaCourse = teaCourse;
    }
    // 无参构造方法
    public Teacher(){

    }
    // setget方法

    public String getTeaNo() {
        return teaNo;
    }

    public void setTeaNo(String teaNo) {
        this.teaNo = teaNo;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getTeaSex() {
        return teaSex;
    }

    public void setTeaSex(String teaSex) {
        this.teaSex = teaSex;
    }

    public int getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(int teaAge) {
        this.teaAge = teaAge;
    }

    public String getTeaCourse() {
        return teaCourse;
    }

    public void setTeaCourse(String teaCourse) {
        this.teaCourse = teaCourse;
    }
}
