package com.fch.bean;


public class Course {

  private String couNo;
  private String couName;


  public Course() {
  }

  public Course(String couNo, String couName) {
    this.couNo = couNo;
    this.couName = couName;
  }

  /**
   * 获取
   * @return couNo
   */
  public String getCouNo() {
    return couNo;
  }

  /**
   * 设置
   * @param couNo
   */
  public void setCouNo(String couNo) {
    this.couNo = couNo;
  }

  /**
   * 获取
   * @return couName
   */
  public String getCouName() {
    return couName;
  }

  /**
   * 设置
   * @param couName
   */
  public void setCouName(String couName) {
    this.couName = couName;
  }

  public String toString() {
    return "Course{couNo = " + couNo + ", couName = " + couName + "}";
  }
}
