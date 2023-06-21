package basejava.day6.work;

public class Work7 {
    // 将某个字符串中所有的数字删除：选做
    public static String delNum(String string){
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) >= '0' && string.charAt(i) <= '9'){
                string = string.replace(""+string.charAt(i),"");
            }
        }
        return string;
    }

    public static void main(String[] args) {
        String str = "a1b2c";
        System.out.println(delNum(str));
    }
}
