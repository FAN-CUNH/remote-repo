package javase.day1.work1;

public class AnimalObject {
    public static void main(String[] args) {
        // 实例化动物对象
        Animal myDog = new Animal();
        Animal myCat = new Animal("好运",1); // 实例化的同时初始化
        // 给对象设置姓名和年龄
        //setget方法
        myDog.setAniName("旺财");
        myDog.setAniAge(2);
        String aniName = myDog.getAnimal(); // 初始化
        int aniAge =  myDog.getAniAge(); // 初始化

        System.out.println("我的狗叫"+aniName+"已经"+aniAge+"岁了！");
        System.out.println("我的猫叫"+myCat.getAnimal()+"已经"+myCat.getAniAge()+"岁了！");
    }
}
