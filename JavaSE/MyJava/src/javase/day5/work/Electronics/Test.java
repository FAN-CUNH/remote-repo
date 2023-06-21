package javase.day5.work.Electronics;

public class Test {
    public static void main(String[] args) {
        Phone njy = new Phone("诺基亚",100); // 实例化手机对象
        njy.call("景甜");
        njy.sendMessage("景甜");

        SmartPhone sp = new SmartPhone("华为",3000); // 实例化智能手机对象
        sp.call("林思意");
        sp.sendMessage("林思意");
        sp.playGaem();

        Pad p = new Pad("iPad",2000); // 实例化平板对象
        p.listenMusic();
        p.playGaem();
    }
}
