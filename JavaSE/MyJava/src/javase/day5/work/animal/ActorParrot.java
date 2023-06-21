package javase.day5.work.animal;

public class ActorParrot extends Parrot implements Actor{
    public ActorParrot(String color, int age) {
        super(color, age);
    }

    public ActorParrot() {
    }

    @Override
    public void paly() {
        System.out.println(getAge()+"岁的"+getColor()+"鹦鹉在表演过跷跷板");
    }
}
