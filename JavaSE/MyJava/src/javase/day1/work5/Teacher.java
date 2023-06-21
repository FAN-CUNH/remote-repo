package javase.day1.work5;

public class Teacher {
    // 声明三个私有成员变量
    private String teaName;
    private int teaAge;
    private String teaCont;
    // 构造方法

    public Teacher() {

    }
    public Teacher(String teaName, int teaAge, String teaCont) {
        this.teaName = teaName;
        this.teaAge = teaAge;
        this.teaCont = teaCont;
    }

    // setget方法
    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public int getTeaAge() {
        return teaAge;
    }

    public void setTeaAge(int teaAge) {
        this.teaAge = teaAge;
    }

    public String getTeaCont() {
        return teaCont;
    }

    public void setTeaCont(String teaCont) {
        this.teaCont = teaCont;
    }

    // 吃饭行为
    public void eat (){
        System.out.println("年龄为"+this.teaAge+"的"+this.teaName+"老师正在吃饭");
    }
    // 讲课行为
    public void lecture(){
        System.out.println("年龄为"+this.getTeaAge()+"的"+this.getTeaName()+"老师正在亢奋的讲着"+this.getTeaCont());
    }
}
