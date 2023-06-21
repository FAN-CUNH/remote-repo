package com.fch.bean;


import java.util.List;

public class Student {

  private String stuNo;
  private String password;
  private String stuName;
  private long stuAge;
  private String birthday;
  private List<Course> courses;

  public Student() {
  }

  public Student(String stuNo, String password, String stuName, long stuAge, String birthday, List<Course> courses) {
    this.stuNo = stuNo;
    this.password = password;
    this.stuName = stuName;
    this.stuAge = stuAge;
    this.birthday = birthday;
    this.courses = courses;
  }

  /**
   * 获取
   * @return stuNo
   */
  public String getStuNo() {
    return stuNo;
  }

  /**
   * 设置
   * @param stuNo
   */
  public void setStuNo(String stuNo) {
    this.stuNo = stuNo;
  }

  /**
   * 获取
   * @return password
   */
  public String getPassword() {
    return password;
  }

  /**
   * 设置
   * @param password
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * 获取
   * @return stuName
   */
  public String getStuName() {
    return stuName;
  }

  /**
   * 设置
   * @param stuName
   */
  public void setStuName(String stuName) {
    this.stuName = stuName;
  }

  /**
   * 获取
   * @return stuAge
   */
  public long getStuAge() {
    return stuAge;
  }

  /**
   * 设置
   * @param stuAge
   */
  public void setStuAge(long stuAge) {
    this.stuAge = stuAge;
  }

  /**
   * 获取
   * @return birthday
   */
  public String getBirthday() {
    return birthday;
  }

  /**
   * 设置
   * @param birthday
   */
  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  /**
   * 获取
   * @return courses
   */
  public List<Course> getCourses() {
    return courses;
  }

  /**
   * 设置
   * @param courses
   */
  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public String toString() {
    return "Student{stuNo = " + stuNo + ", password = " + password + ", stuName = " + stuName + ", stuAge = " + stuAge + ", birthday = " + birthday + ", courses = " + courses + "}";
  }
}
