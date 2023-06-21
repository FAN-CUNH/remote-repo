package javase.day3.test.test3_1;

public class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 洗衣服方法washing
    public void washing(Clothes clothes){
        System.out.println(age+"岁的"+name+"正在洗一件"+clothes.getColor()+"的"+clothes.getBrand()+"牌的衣服");
    }
}
