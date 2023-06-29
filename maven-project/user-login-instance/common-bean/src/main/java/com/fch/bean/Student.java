package com.fch.bean;


import java.util.List;

public class Student {

  private String stu_no;
  private String password;
  private String stu_name;
  private long stu_age;
  private String birthday;
  private List<Course> courses;

  public Student() {
  }

  public Student(String stu_no, String password, String stu_name, long stu_age, String birthday, List<Course> courses) {
    this.stu_no = stu_no;
    this.password = password;
    this.stu_name = stu_name;
    this.stu_age = stu_age;
    this.birthday = birthday;
    this.courses = courses;
  }

  /**
   * 获取
   * @return stu_no
   */
  public String getStu_no() {
    return stu_no;
  }

  /**
   * 设置
   * @param stu_no
   */
  public void setStu_no(String stu_no) {
    this.stu_no = stu_no;
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
   * @return stu_name
   */
  public String getStu_name() {
    return stu_name;
  }

  /**
   * 设置
   * @param stu_name
   */
  public void setStu_name(String stu_name) {
    this.stu_name = stu_name;
  }

  /**
   * 获取
   * @return stu_age
   */
  public long getStu_age() {
    return stu_age;
  }

  /**
   * 设置
   * @param stu_age
   */
  public void setStu_age(long stu_age) {
    this.stu_age = stu_age;
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
    return "Student{stu_no = " + stu_no + ", password = " + password + ", stu_name = " + stu_name + ", stu_age = " + stu_age + ", birthday = " + birthday + ", courses = " + courses + "}";
  }
}
