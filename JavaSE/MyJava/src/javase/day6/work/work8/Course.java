package javase.day6.work.work8;

/**
 * @ClassName Course
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/13 20:43
 * @Version 1.0
 */
public class Course {
    /*私有成员变量*/
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
        return "Course{" +
                "couNo='" + couNo + '\'' +
                ", couName='" + couName + '\'' +
                '}';
    }
}
