package javase.day2.work.game;

public class gameApp {
    public static void main(String[] args) {
        // 实例化英雄类对象
        Hero hero = new Hero("马可波罗",5,100,15,15,"人族",null,0);
        // 实例化怪兽类对象
        Monster monster = new Monster("小兵",7,100,20,25,"小兵");
        // 实例化装备类对象
        Equip equip1 = new Equip("末世",2,"红色","攻速",5,0);
        Equip equip2 = new Equip("电刀",2,"黄色","攻速",5,0);
        Equip equip3 = new Equip("破晓",2,"红色","攻速",10,0);

        int count = 1; // 回合计数
        hero.addEquip(equip1); // 调用添加装备方法
        hero.addEquip(equip2); // 调用添加装备方法
        hero.addEquip(equip3); // 调用添加装备方法
        hero.addEquip(equip3); // 调用添加装备方法
        //System.out.println(equip1.show()); // 调用获取装备方法
        while (true){
            System.out.println("第"+count+"回合");
            monster.attack(hero); // 英雄攻击 地址传递，不需要返回值 （引用数据类型的地址传递）
            hero.attack(monster); // 怪物攻击
            System.out.println(hero.show()); // 获取英雄信息
            System.out.println(monster.show()); // 获取怪兽信息
            if (hero.isDead() || monster.isDead()){
                if(hero.isDead() && monster.isDead()) {
                    System.out.println("结果为:" + monster.getName() +"和"+ hero.getName() + "都死亡！！！");
                }
                else if (hero.isDead()){
                        System.out.println(hero.getName()+"死亡！！！");
                }else {
                    System.out.println("结果为:"+monster.getName()+"死亡！！！");
                }
                break;
            }

            count++;

        }


    }
}
