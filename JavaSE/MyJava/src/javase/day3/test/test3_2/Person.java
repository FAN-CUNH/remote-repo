package javase.day3.test.test3_2;

public class Person {
    private String name;
    private int age;
    private GrilFriend grilFriend;

    public Person(String name, int age, GrilFriend grilFriend) {
        this.name = name;
        this.age = age;
        this.grilFriend = grilFriend;
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

    public GrilFriend getGrilFriend() {
        return grilFriend;
    }

    public void setGrilFriend(GrilFriend grilFriend) {
        this.grilFriend = grilFriend;
    }

    // 逛街
    public void shopping(){
        System.out.println(age+"岁的大男孩"+this.name+"有一个"+grilFriend.getAge()+"岁的女朋友,"+name+"在和"+grilFriend.getName()+"逛街");
    }
}
