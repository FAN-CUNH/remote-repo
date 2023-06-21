package com.fch.bean;

import java.util.List;

public class Student {

  private String stuNo;
  private String stuName;
  private long stuAge;
  private String birthday;
  private String password;
  private List<Course> courses;


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

  public void setStuAge(long stuage) {
    this.stuAge = stuAge;
  }


  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }
}
