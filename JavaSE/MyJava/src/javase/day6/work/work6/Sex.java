package javase.day6.work.work6;

/**
 * @ClassName Sex
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/13 19:17
 * @Version 1.0
 */
public enum Sex {
    /*枚举常量*/
    BOY("男",0),GIRl("女",1);
    /*成员变量*/
    public String sex;
    public int sexValue;
    /*构造方法*/
    Sex(String sex, int sexValue) {
        this.sex = sex;
        this.sexValue = sexValue;
    }
}
