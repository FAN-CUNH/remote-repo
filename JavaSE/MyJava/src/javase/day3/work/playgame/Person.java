package javase.day3.work.playgame;

public class Person {
    // 声明2两个私有成员属性变量
    private String perName;
    private int perAge;

    // 构造方法

    public Person() {
    }

    public Person(String perName, int perAge) {
        this.perName = perName;
        this.perAge = perAge;
    }

    // setget方法

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public int getPerAge() {
        return perAge;
    }

    public void setPerAge(int perAge) {
        this.perAge = perAge;
    }

    // 重写toString方法

    @Override
    public String toString() {
        return "Person{" +
                "perName='" + perName + '\'' +
                ", perAge=" + perAge +
                '}';
    }

    // 自定义方法
   public void usePhone(Phone phone){
       System.out.println(this.perAge+"的"+this.perName+"正在使用"+phone.getBrand()+phone.playGame());
   }
}
