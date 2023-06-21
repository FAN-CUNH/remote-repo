package basejava.day6.test;

public class Test1 {
    // 将字符串中所有的小写i全改成大写
    // 将字符串转化成字符数组
    // 修改数组
    // 将数组转换成字符串
       // 给定字符串，要求统计字符串中数字个数，同时遇到数字删除，打印删除后的新字符串
    public  static void delLetter (String string){
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9'){
                string = string.replace(""+string.charAt(i),"");
                count++;
                i--;

                }
            }
        System.out.println(string);
        }
    public static void main(String[] args) {
        String str = "ab12c3";
        delLetter(str);
    }
}

