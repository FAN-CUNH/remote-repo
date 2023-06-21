package com.entity;


public class Course {

  private String couno;
  private String couname;


  public String getCouno() {
    return couno;
  }

  public void setCouno(String couno) {
    this.couno = couno;
  }


  public String getCouname() {
    return couname;
  }

  public void setCouname(String couname) {
    this.couname = couname;
  }

  @Override
  public String toString() {
    return "Course{" +
            "couno='" + couno + '\'' +
            ", couname='" + couname + '\'' +
            '}';
  }
}
