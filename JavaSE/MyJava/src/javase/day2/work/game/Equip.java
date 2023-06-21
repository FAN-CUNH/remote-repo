package javase.day2.work.game;

public class Equip {
    private String name; // 昵称
    private int level; // 级别
    private String color; // 颜色
    private String kind; // 类别
    private int power; // 攻击力
    private int defence; // 防御力

    // 构造方法

    public Equip() {
    }

    public Equip(String name, int level, String color, String king, int power, int defence) {
        this.name = name;
        this.level = level;
        this.color = color;
        this.kind = king;
        this.power = power;
        this.defence = defence;
    }

    // setget方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKing() {
        return kind;
    }

    public void setKing(String king) {
        this.kind = king;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    @Override
    public String toString() {
        return "当前装备信息[" +
                "昵称:" + name +
                ", 等级:" + level +
                ", 颜色:" + color +
                ", 类别:" + kind +
                ", 攻击力:" + power +
                ", 防御力:" + defence +
                ']';
    }


    // 获取装备信息
    public String show(){
        return "当前装备信息[" +
                "昵称:" + name +
                ", 等级:" + level +
                ", 颜色:" + color +
                ", 类别:" + kind +
                ", 攻击力:" + power +
                ", 防御力:" + defence +
                ']';
    }
}
