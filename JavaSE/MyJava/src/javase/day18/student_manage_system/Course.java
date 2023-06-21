package javase.day18.student_manage_system;

/**
 * @ClassName Course
 * @Description 课程模板类
 * @Author Cunhao Fan
 * @Date 2023/4/28 10:15
 * @Version 1.0
 */
public class Course {
    /*私有成员变量*/
    private String couNo;
    private String couName;
    private double couScore; // 课程分数
    /*构造方法*/

    public Course(String couNo, String couName, double couScore) {
        this.couNo = couNo;
        this.couName = couName;
        this.couScore = couScore;
    }

    public Course() {
    }
    /*setget方法 对属性进行获取和赋值*/
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

    public double getCouScore() {
        return couScore;
    }

    public void setCouScore(double couScore) {
        this.couScore = couScore;
    }
    /*重写toString方法*/
    @Override
    public String toString() {
        return "Course{" +
                "couNo='" + couNo + '\'' +
                ", couName='" + couName + '\'' +
                ", couScore=" + couScore +
                '}';
    }
}
