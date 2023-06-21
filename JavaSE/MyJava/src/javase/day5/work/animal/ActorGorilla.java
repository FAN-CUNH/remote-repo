package javase.day5.work.animal;

public class ActorGorilla extends Gorilla implements Actor{
    public ActorGorilla(String color, int age) {
        super(color, age);
    }

    public ActorGorilla() {
    }

    @Override
    public void paly() {
        System.out.println(getAge()+"岁的"+getColor()+"大猩猩在表演骑自行车");
    }
}
