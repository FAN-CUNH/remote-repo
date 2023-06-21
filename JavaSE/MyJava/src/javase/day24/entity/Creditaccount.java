package com.sample;


public class Creditaccount {

  private long id;
  private String password;
  private String name;
  private String personid;
  private String email;
  private double balance;
  private double ceiling;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPersonid() {
    return personid;
  }

  public void setPersonid(String personid) {
    this.personid = personid;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }


  public double getCeiling() {
    return ceiling;
  }

  public void setCeiling(double ceiling) {
    this.ceiling = ceiling;
  }

}
