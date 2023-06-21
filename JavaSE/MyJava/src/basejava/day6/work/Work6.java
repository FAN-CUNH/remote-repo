package basejava.day6.work;

public class Work6 {
    // 将某个字符串中的所有小写字母i和k变成大写字母：使用new String(char[]) 和toCharArray()
    public static String leCount (String str){
        char [] charArr = str.toCharArray(); // 将字符串转换成一个新的字符数组
        for (int i = 0; i < str.length(); i++) {
            if (charArr[i] == 'i' || charArr[i] == 'k'){
                str = str.replace(""+charArr[i],""+(char)(charArr[i]-32)); // replace替换
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String str = "aibkc";
        System.out.println(str.toCharArray());
        System.out.println(leCount(str).toCharArray());

    }
}
