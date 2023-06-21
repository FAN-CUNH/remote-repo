package javase.day2.work.game;

import java.util.Arrays;

public class Hero {
    // 声明私有成员属性
    private String name; // 昵称
    private int level; // 等级
    private int blood; // 血量
    private int power; // 攻击力
    private int defence; // 防御力
    private String kind; // 种族
    private Equip [] equips; // 装备数组
    private int equipCount = 0; // 表示现有装备,初始没有装备

    // 构造方法
    public Hero() {
        equips = new Equip[3]; // 实例化数组，最多三个装备  --> 类的组合关系
    }

    public Hero(String name, int level, int blood, int power, int defence, String kind, Equip[] equip, int equipCount) {
        this.equips = new Equip[3];
        this.name = name;
        this.level = level;
        this.blood = blood;
        this.power = power;
        this.defence = defence;
        this.kind = kind;
        this.equipCount = equipCount;
    }

    // setget行为

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

    public Equip[] getEquip() {
        return equips;
    }

    public void setEquip(Equip[] equip) {
        this.equips = equip;
    }

    public int getEquipCount() {
        return equipCount;
    }

    public void setEquipCount(int equipCount) {
        this.equipCount = equipCount;
    }

    // 攻击怪兽方法
    public void attack (Monster monster){ // Hero类和Monster是依赖关系，方法调用对象操作参数对象
        if (monster.getBlood() >= 0 && (this.power-monster.getDefence()) >= 0){ // 攻击对象血量大于0并且当前对象攻击力大于0才算攻击
            monster.setBlood(monster.getBlood()-(this.power-monster.getDefence()));
        }
    }

    // 死亡判定方法  考察对象和属性的关系-->对象包含属性
    public boolean isDead(){
        boolean isDead = false; // 假设没有死亡
        if (this.blood <= 0){
            isDead = true;
        }
        return isDead;
    }

    // 获取角色信息方法
    public String show(){
        return "[" +
                "昵称:" + name +
                ", 等级:" + level +
                ", 血量:" + blood +
                ", 攻击力:" + power +
                ", 防御力:" + defence +
                ", 种族:" + kind +
                ", 装备:" + Arrays.toString(equips) +
                ", 装备个数:" + equipCount +
                ']';
    }

    // 添加装备
    public void addEquip (Equip equip){
        if (equipCount < 3){
            equips[equipCount] = equip;
            this.power = this.power + equip.getPower(); // 装备装备时，刷新英雄攻击力
            this.equipCount++;
        }
        else {
            System.out.println("穿戴失败，装备超出数量！！！");
        }
    }
}
