package com.entity;

import java.util.Arrays;
import java.util.List;

public class Student {

  private String stuno;
  private String stuname;
  private long stuage;
  private String birthday;
  private String password;
  private List<Course> courses;

  public List<Course> getCourses() {
    return courses;
  }

  public void setCourses(List<Course> courses) {
    this.courses = courses;
  }

  public String getStuno() {
    return stuno;
  }

  public void setStuno(String stuno) {
    this.stuno = stuno;
  }


  public String getStuname() {
    return stuname;
  }

  public void setStuname(String stuname) {
    this.stuname = stuname;
  }


  public long getStuage() {
    return stuage;
  }

  public void setStuage(long stuage) {
    this.stuage = stuage;
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

  @Override
  public String toString() {
    return "Student{" +
            "stuno='" + stuno + '\'' +
            ", stuname='" + stuname + '\'' +
            ", stuage=" + stuage +
            ", birthday='" + birthday + '\'' +
            ", password='" + password + '\'' +
            ", courses=" + courses +
            '}';
  }
}
