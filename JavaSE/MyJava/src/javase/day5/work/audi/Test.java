package javase.day5.work.audi;

public class Test {
    public static void main(String[] args) {
        // 实例化奥迪车对象
        Audi audi = new Audi();
        audi.run();

        SmartAudi smartAudi = new SmartAudi();
        smartAudi.automaticDrive();
        smartAudi.automaticParking();

        Audi audi1 = smartAudi;
        audi1.run();

        if (audi1 instanceof SmartAudi){
            SmartAudi smartAudi1 = (SmartAudi)audi1;
            smartAudi1.automaticParking();
            smartAudi1.automaticDrive();
        }
        SmartInterface smartInterface = smartAudi;
        smartInterface.automaticDrive();
        smartInterface.automaticParking();
        // smartInterface.run(); 不能调用调用run（）
    }
}
