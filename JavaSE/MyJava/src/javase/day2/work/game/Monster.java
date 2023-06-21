package javase.day2.work.game;

public class Monster {
    private String name; // 昵称
    private int level; // 等级
    private int blood; // 血量
    private int power; // 攻击力
    private int defence; // 防御力
    private String kind; // 种族

    // 构造方法
    public Monster() {
    }

    public Monster(String name, int level, int blood, int power, int defence, String kind) {
        this.name = name;
        this.level = level;
        this.blood = blood;
        this.power = power;
        this.defence = defence;
        this.kind = kind;
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

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    // 怪兽的基本攻击方法
    public void attack (Hero hero){
        if (hero.getBlood() >= 0 && (this.power-hero.getDefence()) >= 0){ // 血量大于0
            hero.setBlood(hero.getBlood()-(this.power-hero.getDefence()));
        }
    }

    // 死亡判定方法
    public boolean isDead(){
        boolean isDead = false; // 假设没有死亡
        if (this.blood <= 0){
            isDead = true;
        }
        return isDead;
    }

    // 获取怪兽信息
    public String show(){
        return "当前怪兽信息[" +
                "昵称:" + name +
                ", 等级:" + level +
                ", 血量:" + blood +
                ", 攻击力:" + power +
                ", 防御力:" + defence +
                ", 种族:" + kind +
                ']';
    }
}
