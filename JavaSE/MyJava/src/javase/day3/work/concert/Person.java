package javase.day3.work.concert;

public class Person {
    // 声明1个私有成员属性
    private String perName;
    // 构造方法

    public Person() {
    }

    public Person(String perName) {
        this.perName = perName;
    }

    // setget方法

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    // 唱歌行为
    public void sing(String song){
        System.out.println(this.perName+"正在演唱"+song+"歌曲!!!");
    }
}
