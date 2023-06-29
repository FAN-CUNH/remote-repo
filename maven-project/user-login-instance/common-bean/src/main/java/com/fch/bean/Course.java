package com.fch.bean;


public class Course {

  private String cou_no;
  private String cou_name;

  public Course() {
  }

  public Course(String cou_no, String cou_name) {
    this.cou_no = cou_no;
    this.cou_name = cou_name;
  }

  /**
   * 获取
   * @return cou_no
   */
  public String getCou_no() {
    return cou_no;
  }

  /**
   * 设置
   * @param cou_no
   */
  public void setCou_no(String cou_no) {
    this.cou_no = cou_no;
  }

  /**
   * 获取
   * @return cou_name
   */
  public String getCou_name() {
    return cou_name;
  }

  /**
   * 设置
   * @param cou_name
   */
  public void setCou_name(String cou_name) {
    this.cou_name = cou_name;
  }

  public String toString() {
    return "Course{cou_no = " + cou_no + ", cou_name = " + cou_name + "}";
  }
}
