package javase.day3.work.call;

public class Person {
    private String name;
    private int age;
    private Phone phone;

    public Person(String name, int age, Phone phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }


    // 打电话方法
    public void callTo(Person person){
        System.out.println(age+"岁的"+name+"使用"+this.phone.getPrice()+"元的"+phone.getBrand()+"手机给"+ this.phone.call("羽凡"));
    }
}
