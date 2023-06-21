package basejava.day1.work;

public class Work6 {
    public static void main(String[] args) {
        /*
        将56转化成二进制
        56(32+16+8) -> 00111000

        将00000111转化成十进制
        00000111 -> 7(4+2+1)
        */
        int a = 56;
        System.out.println(Integer.toBinaryString(a)); // 调用API函数
        /*
            思路 ：
                1：a对2取余
                2：对a进行整除2，的到的结果在赋给a
                3：将得到的结果再进行1,2操作，直到a为0
         */
        String str = "";
        while (a != 0){
            str = (a % 2) + str;
            a = a / 2;
        }
        System.out.println(str);
    }
}
