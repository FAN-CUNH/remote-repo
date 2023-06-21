package javase.day7.work.studentmanagementsystem;

public class Course {
    private String couNo;
    private String couName;
    /*构造方法*/

    public Course(String couNo, String couName) {
        this.couNo = couNo;
        this.couName = couName;
    }

    public Course() {
    }
    /*setget方法*/

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

    @Override
    public String toString() {
        return couName+" ";
    }
}
