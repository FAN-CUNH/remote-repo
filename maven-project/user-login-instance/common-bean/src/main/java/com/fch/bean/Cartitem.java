package com.fch.bean;


public class Cartitem {

  private String cartitemId;
  private String pid;
  private String cartId;
  private String pname;
  private String pimage;
  private double shop_price;
  private double subTotal;
  private int count;


  public Cartitem() {
  }

  public Cartitem(String cartitemId, String pid, String cartId, String pname, String pimage, double shop_price, double subTotal, int count) {
    this.cartitemId = cartitemId;
    this.pid = pid;
    this.cartId = cartId;
    this.pname = pname;
    this.pimage = pimage;
    this.shop_price = shop_price;
    this.subTotal = subTotal;
    this.count = count;
  }

  /**
   * 获取
   * @return cartitemId
   */
  public String getCartitemId() {
    return cartitemId;
  }

  /**
   * 设置
   * @param cartitemId
   */
  public void setCartitemId(String cartitemId) {
    this.cartitemId = cartitemId;
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
   * @return cartId
   */
  public String getCartId() {
    return cartId;
  }

  /**
   * 设置
   * @param cartId
   */
  public void setCartId(String cartId) {
    this.cartId = cartId;
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
   * @return subTotal
   */
  public double getSubTotal() {
    return subTotal;
  }

  /**
   * 设置
   * @param subTotal
   */
  public void setSubTotal(double subTotal) {
    this.subTotal = subTotal;
  }

  /**
   * 获取
   * @return count
   */
  public int getCount() {
    return count;
  }

  /**
   * 设置
   * @param count
   */
  public void setCount(int count) {
    this.count = count;
  }

  public String toString() {
    return "Cartitem{cartitemId = " + cartitemId + ", pid = " + pid + ", cartId = " + cartId + ", pname = " + pname + ", pimage = " + pimage + ", shop_price = " + shop_price + ", subTotal = " + subTotal + ", count = " + count + "}";
  }
}
