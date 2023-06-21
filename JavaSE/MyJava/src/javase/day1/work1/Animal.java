package javase.day1.work1;

public class Animal {
    // 封装Animal类，成员变量private String aniName;private int aniAge;为其编写setget方法；
    // 以及无参数构造器和有参数构造器完成给2个成员变量赋值；最后封装AnimalTest完成分别使用无参构造器
    // 和有参数构造器分别实例化Animal对象，并且打印对象的属性信息

    // 私有成员变量
    private String aniName; // 声明了一个私有的字符型变量表示动物名
    private int aniAge; // // 声明了一个私有的字符型变量表示动物年龄

    // set get方法 --> 操作私有成员变量
    public String getAnimal() {
        return aniName;
    }

    public void setAniAge(int aniAge) {
        this.aniAge = aniAge;
    }
    public void setAniName(String aniName) {
        this.aniName = aniName;
    }

    public int getAniAge() {
        return aniAge;
    }

    // 构造方法
    public Animal(){ // 无参构造器   setget方法时创建

    }

    public Animal(String aniName,int aniAge){ // 有参构造器  在被调用时可以完成变量初始化
        this.aniName = aniName;
        this.aniAge = aniAge;
    }
}