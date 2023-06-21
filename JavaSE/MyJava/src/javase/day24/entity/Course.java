package javase.day24.entity;

/**
 * CunHao Fan
 */
public class Course {

  private String couNo;
  private String couName;


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
