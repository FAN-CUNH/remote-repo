package javase.day5.work.audi;

public class SmartAudi extends Audi implements SmartInterface{ // 单继承+多实现

    @Override
    public void automaticParking() {
        System.out.println("智能奥迪车在自动泊车");
    }

    @Override
    public void automaticDrive() {
        System.out.println("智能奥迪车在无人驾驶");
    }
}
