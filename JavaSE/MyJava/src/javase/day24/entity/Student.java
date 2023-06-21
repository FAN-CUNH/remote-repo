package javase.day24.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * @author CunHao Fan
 */
public class Student {

  private String stuNo;
  private String stuName;
  private long stuAge;
  private String birthday;
  private ArrayList<Course> courses;

  public ArrayList<Course> getCourses() {
    return courses;
  }

  public void setCourses(ArrayList<Course> courses) {
    this.courses = courses;
  }

  public String getStuNo() {
    return stuNo;
  }

  public void setStuNo(String stuNo) {
    this.stuNo = stuNo;
  }


  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }


  public long getStuAge() {
    return stuAge;
  }

  public void setStuAge(long stuAge) {
    this.stuAge = stuAge;
  }


  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  @Override
  public String toString() {
    return "Student{" +
            "stuNo='" + stuNo + '\'' +
            ", stuName='" + stuName + '\'' +
            ", stuAge=" + stuAge +
            ", birthday='" + birthday + '\'' +
            ", courses=" + courses +
            '}';
  }
}
