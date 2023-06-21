package javase.day9.work;

/**
 * @ClassName DiGui
 * @Description  递归实现1-100之间的数值的累乘；选做打印1*2*3*4*5.*100=结果实现
 * @Author Cunhao Fan
 * @Date 2023/4/17 16:18
 * @Version 1.0
 */
public class DiGui {
    /*累乘递归方法*/
    public int getCul(int num){
        if (num == 1){
            return 1;
        }else {
            System.out.print(num +"*");
            return num * getCul(num -1);
        }
    }
    public static void main(String[] args) {
        /*实例化递归对象*/
        DiGui diGui = new DiGui();
        int cul = diGui.getCul(10);
        System.out.print("1" +"=");
        System.out.println(cul);
    }
}
