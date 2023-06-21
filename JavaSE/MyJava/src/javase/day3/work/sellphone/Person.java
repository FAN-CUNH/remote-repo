package javase.day3.work.sellphone;


public class Person {
    // 属性
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // 卖手机行为
    public Phone sellPhone(Phone phone){
        return phone;
    }
}
