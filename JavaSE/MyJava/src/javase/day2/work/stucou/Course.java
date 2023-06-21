package javase.day2.work.stucou;

public class Course {
    private String couNo;
    private String couName;

    public Course(String couNo, String couName) {
        this.couNo = couNo;
        this.couName = couName;
    }

    public Course() {
    }

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

    // 重写toString方法

    @Override
    public String toString() {
        return "{" +
                "课程编号" + couNo +
                ", 课程名" + couName +
                '}';
    }

}
