package javase.day25.entity;

/**
 *
 * @author 58238
 */
public class CreditAccount extends Account{

  private String name;
  private String personId;
  private String email;
  private double ceiling;

  public CreditAccount() {
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }


  public String getPersonId() {
    return personId;
  }

  public void setPersonid(String personId) {
    this.personId = personId;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }



  public double getCeiling() {
    return ceiling;
  }

  public void setCeiling(double ceiling) {
    this.ceiling = ceiling;
  }

  @Override
  public String toString() {
    return "信用账户   " +
            "账号：" + getId() +
            "  密码：" + getPassword() +
            "  姓名：" + name +
            "  身份证号码：" + personId +
            "  邮箱：" + email +
            "  余额：" + getBalance() +
            "  信用额度：" + ceiling;
  }
}
