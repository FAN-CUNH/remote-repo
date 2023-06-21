package com.fch.bean;


import java.util.List;

public class Cart {

  private String cartId;
  private double total;
  private String userId;
  private List<Cartitem> cartitems;

  public Cart() {
  }

  public Cart(String cartId, double total, String userId, List<Cartitem> cartitems) {
    this.cartId = cartId;
    this.total = total;
    this.userId = userId;
    this.cartitems = cartitems;
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
   * @return total
   */
  public double getTotal() {
    return total;
  }

  /**
   * 设置
   * @param total
   */
  public void setTotal(double total) {
    this.total = total;
  }

  /**
   * 获取
   * @return userId
   */
  public String getUserId() {
    return userId;
  }

  /**
   * 设置
   * @param userId
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * 获取
   * @return cartitems
   */
  public List<Cartitem> getCartitems() {
    return cartitems;
  }

  /**
   * 设置
   * @param cartitems
   */
  public void setCartitems(List<Cartitem> cartitems) {
    this.cartitems = cartitems;
  }

  public String toString() {
    return "Cart{cartId = " + cartId + ", total = " + total + ", userId = " + userId + ", cartitems = " + cartitems + "}";
  }
}
