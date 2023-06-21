package javase.day10.work.doudizhu;

/**
 * @ClassName Cards
 * @Description 扑克牌模板类 扑克牌牌面值  扑克牌权重值  扑克牌花色
 * @Author Cunhao Fan
 * @Date 2023/4/19 9:56
 * @Version 1.0
 */
public class Cards {
    /*扑克牌牌面值 扑克牌权重值 扑克牌花色*/
    private String cardName;
    private int num;
    private String color;
    /*构造方法*/
    public Cards(String cardName, int num, String color) {
        this.cardName = cardName;
        this.num = num;
        this.color = color;
    }
    public Cards() {
    }
    /*setget方法*/

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
