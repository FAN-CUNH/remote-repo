package javase.day3.test.singleton;

public class Singlton {
    //成员变量：就是它自己
    static Singlton sinltonDemo = null;

    private Singlton(){
        System.out.println("创建一个对象");
    }

    //定义一个方法创建或者产生对象
    public static Singlton newInstance(){
        if(sinltonDemo == null) {
            sinltonDemo = new Singlton();
        }

        return  sinltonDemo;
    }

    public static void main(String[] args) {
        newInstance();
    }
}