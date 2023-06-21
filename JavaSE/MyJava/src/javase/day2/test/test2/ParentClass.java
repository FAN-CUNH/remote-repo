package javase.day2.test.test2;

public class ParentClass {
    // 属性
    String name;
    // 行为

    // setget行为
    public ParentClass() {
    }

    public ParentClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 自定义行为
    public void test(){
        System.out.println("我是父类的行为"+name);
    }

}
