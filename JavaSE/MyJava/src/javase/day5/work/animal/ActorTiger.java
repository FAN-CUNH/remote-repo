package javase.day5.work.animal;

public class ActorTiger extends Tiger implements Actor{
    public ActorTiger(String color, int age) {
        super(color, age);
    }

    public ActorTiger() {
    }

    @Override
    public void paly() {
        System.out.println(getAge()+"岁的"+getColor()+"老虎在表演穿火圈");
    }
}
