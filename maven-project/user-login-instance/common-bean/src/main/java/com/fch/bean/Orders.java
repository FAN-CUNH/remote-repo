package com.fch.bean;


public class Orders {

  private String oid;
  private String ordertime;
  private double total;
  private long state;
  private String address;
  private String name;
  private String telephone;
  private String userId;


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }


  public String getOrdertime() {
    return ordertime;
  }

  public void setOrdertime(String ordertime) {
    this.ordertime = ordertime;
  }


  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "Orders{" +
            "oid='" + oid + '\'' +
            ", ordertime=" + ordertime +
            ", total=" + total +
            ", state=" + state +
            ", address='" + address + '\'' +
            ", name='" + name + '\'' +
            ", telephone='" + telephone + '\'' +
            ", userId='" + userId + '\'' +
            '}';
  }
}
