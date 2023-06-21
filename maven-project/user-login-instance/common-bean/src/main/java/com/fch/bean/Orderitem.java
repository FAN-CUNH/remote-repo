package com.fch.bean;

public class Orderitem {

  private String itemid;
  private long count;
  private double subtotal;
  private String pid;
  private String oid;


  public String getItemid() {
    return itemid;
  }

  public void setItemid(String itemid) {
    this.itemid = itemid;
  }


  public long getCount() {
    return count;
  }

  public void setCount(long count) {
    this.count = count;
  }


  public double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(double subtotal) {
    this.subtotal = subtotal;
  }


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  @Override
  public String toString() {
    return "Orderitem{" +
            "itemid='" + itemid + '\'' +
            ", count=" + count +
            ", subtotal=" + subtotal +
            ", pid='" + pid + '\'' +
            ", oid='" + oid + '\'' +
            '}';
  }
}
