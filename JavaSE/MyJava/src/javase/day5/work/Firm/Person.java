package javase.day5.work.Firm;

public class Person {
    // 声明私有成员变量
    private String name; // 姓名
    private String address; // 地址

    // 构造方法
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Person() {
    }

    // setget方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
