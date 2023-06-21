package javase.day1.work2;

public class Course {

    // 声明4个成员变量
    private String couNo;
    private String couName;
    private String couTime;
    private String couDescrption;

    // 无参构造方法
    public Course(){

    }
    // 有参构造方法
    public Course(String couNo,String couName,String couTime,String couDescrption){
        this.couNo = couNo;
        this.couName = couName;
        this.couTime = couTime;
        this.couDescrption = couDescrption;
    }

    // setget方法

    public String getCouNo() {
        return couNo;
    }

    public void setCouNo(String couNo) {
        this.couNo = couNo;
    }

    public String getCouName() {
        return couName;
    }

    public void setCouName(String couName) {
        this.couName = couName;
    }

    public String getCouTime() {
        return couTime;
    }

    public void setCouTime(String couTime) {
        this.couTime = couTime;
    }

    public String getCouDescrption() {
        return couDescrption;
    }

    public void setCouDescrption(String couDescrption) {
        this.couDescrption = couDescrption;
    }
}
