package javase.day6.test.enumdemo;

public enum Sex {
    //枚举
    BOY("男",0), GIRL("女",1);


    //成员变量
    public String name;
    public int sexValue;

    Sex(String name, int sexValue) {
        this.name = name;
        this.sexValue = sexValue;
    }
}
