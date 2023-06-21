package com.fch.bean;


/**
 * 商品类
 * @author CunHao Fan
 */
public class Product {

  private String pid;
  private String pname;
  private double market_price;
  private double shop_price;
  private String pimage;
  private java.sql.Date pdate;
  private long isHot;
  private String pdesc;
  private long pflag;
  private String cid;


  public String getPid() {
    return pid;
  }

  public void setPid(String pid) {
    this.pid = pid;
  }


  public String getPname() {
    return pname;
  }

  public void setPname(String pname) {
    this.pname = pname;
  }


  public double getMarket_price() {
    return market_price;
  }

  public void setMarket_price(double market_price) {
    this.market_price = market_price;
  }




  public String getPimage() {
    return pimage;
  }

  public void setPimage(String pimage) {
    this.pimage = pimage;
  }


  public java.sql.Date getPdate() {
    return pdate;
  }

  public void setPdate(java.sql.Date pdate) {
    this.pdate = pdate;
  }


  public long getIsHot() {
    return isHot;
  }

  public void setIsHot(long isHot) {
    this.isHot = isHot;
  }


  public String getPdesc() {
    return pdesc;
  }

  public void setPdesc(String pdesc) {
    this.pdesc = pdesc;
  }


  public long getPflag() {
    return pflag;
  }

  public void setPflag(long pflag) {
    this.pflag = pflag;
  }


  public String getCid() {
    return cid;
  }

  public void setCid(String cid) {
    this.cid = cid;
  }

  @Override
  public String toString() {
    return "Product{" +
            "pid='" + pid + '\'' +
            ", market_price=" + market_price +
            ", shop_price =" + shop_price +
            ", pimage='" + pimage + '\'' +
            '}';
  }

  public double getShop_price() {
    return shop_price;
  }

  public void setShop_price(double shop_price) {
    this.shop_price = shop_price;
  }
}
