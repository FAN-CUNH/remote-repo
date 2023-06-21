package javase.day3.test.test3_2;

public class Test {
    public static void main(String[] args) {
        GrilFriend grilFriend = new GrilFriend("范冰冰",20);
        Person person = new Person("李晨",48,grilFriend);
        person.shopping();
    }
}
