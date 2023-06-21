package javase.day25.entity;

/**
 * @author CunHao Fan
 */
public class SavingAccount extends Account{

  private String name;
  private String personId;
  private String email;

  public SavingAccount() {
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

  public void setPersonId(String personId) {
    this.personId = personId;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public String toString() {
    return "储蓄账户   " +
            "账号：" + getId() +
            "  密码：" + getPassword() +
            "  姓名：" + name +
            "  身份证号码：" + personId +
            "  邮箱：" + email +
            "  余额：" + getBalance();
  }
}
