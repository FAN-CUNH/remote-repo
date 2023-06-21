package basejava.day1.work;

public class Work4 {
    public static void main(String[] args) {
        int a = 1234,b,c,d,e;
        b = (a%10); // 1234对10取余得4
        c = (a%100/10); // 1234先对100取余得34，在对34进行对10整除得3
        d = (a%1000/100);// 1234先对1000取余得234，在将234对100进行整除的2
        e = (a/1000); //  1234整除1000得1
        System.out.println(a+","+b+","+c+","+d+","+e);
    }
}
