package javase.day6.work.work6;


import java.util.Date;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/13 19:14
 * @Version 1.0
 */
public class Person {
    /*私有成员变量*/
    private String name;
    private String personId;
    private Date birthday;
    private Sex sex;

    /*setget方法*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
    /*构造方法*/

    public Person(String name, String personId, Date birthday, Sex sex) {
        this.name = name;
        this.personId = personId;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "个人信息{" +
                "姓名:" + name +
                ", 身份证号:" + personId +
                ", 出生日期:" + birthday +
                ", 性别:" + sex.sex +
                '}';
    }
}
