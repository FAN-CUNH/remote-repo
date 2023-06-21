package com.fch.bean;


public class Product {

  private String pid;
  private String pname;
  private double market_price;
  private double shop_price;
  private String pimage;
  private String is_hot;
  private String cid;
  private Category category;

  public Product() {
  }

  public Product(String pid, String pname, double market_price, double shop_price, String pimage, String is_hot, String cid, Category category) {
    this.pid = pid;
    this.pname = pname;
    this.market_price = market_price;
    this.shop_price = shop_price;
    this.pimage = pimage;
    this.is_hot = is_hot;
    this.cid = cid;
    this.category = category;
  }

  /**
   * 获取
   * @return pid
   */
  public String getPid() {
    return pid;
  }

  /**
   * 设置
   * @param pid
   */
  public void setPid(String pid) {
    this.pid = pid;
  }

  /**
   * 获取
   * @return pname
   */
  public String getPname() {
    return pname;
  }

  /**
   * 设置
   * @param pname
   */
  public void setPname(String pname) {
    this.pname = pname;
  }

  /**
   * 获取
   * @return market_price
   */
  public double getMarket_price() {
    return market_price;
  }

  /**
   * 设置
   * @param market_price
   */
  public void setMarket_price(double market_price) {
    this.market_price = market_price;
  }

  /**
   * 获取
   * @return shop_price
   */
  public double getShop_price() {
    return shop_price;
  }

  /**
   * 设置
   * @param shop_price
   */
  public void setShop_price(double shop_price) {
    this.shop_price = shop_price;
  }

  /**
   * 获取
   * @return pimage
   */
  public String getPimage() {
    return pimage;
  }

  /**
   * 设置
   * @param pimage
   */
  public void setPimage(String pimage) {
    this.pimage = pimage;
  }

  /**
   * 获取
   * @return is_hot
   */
  public String getIs_hot() {
    return is_hot;
  }

  /**
   * 设置
   * @param is_hot
   */
  public void setIs_hot(String is_hot) {
    this.is_hot = is_hot;
  }

  /**
   * 获取
   * @return cid
   */
  public String getCid() {
    return cid;
  }

  /**
   * 设置
   * @param cid
   */
  public void setCid(String cid) {
    this.cid = cid;
  }

  /**
   * 获取
   * @return category
   */
  public Category getCategory() {
    return category;
  }

  /**
   * 设置
   * @param category
   */
  public void setCategory(Category category) {
    this.category = category;
  }

  public String toString() {
    return "Product{pid = " + pid + ", pname = " + pname + ", market_price = " + market_price + ", shop_price = " + shop_price + ", pimage = " + pimage + ", is_hot = " + is_hot + ", cid = " + cid + ", category = " + category + "}";
  }
}
