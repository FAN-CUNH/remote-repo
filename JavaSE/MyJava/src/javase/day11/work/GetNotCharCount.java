package javase.day11.work;

import java.util.LinkedHashMap;

/**
 * @ClassName GetNotCharCount
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/19 18:54
 * @Version 1.0
 */
public class GetNotCharCount {
    public static void main(String[] args) {
        String str = "sd1231dgdfs";
        String regex = "[a-zA-Z]{1}";
        /*实例化1个集合用来存放非数字字符*/
        LinkedHashMap <String,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            /*假设没有被统计过*/
            boolean isExist = false;
            int count = 0;
            if ((str.charAt(i)+"").matches(regex)){
                /*判断当前字符是否被统计过*/
                if (map.containsKey(str.charAt(i)+"")){
                    isExist = true;
                }
                if (!isExist){
                    System.out.println(str.charAt(i));
                    for (int j = i; j < str.length(); j++) {
                        if (str.charAt(i) == str.charAt(j)){
                            count++;
                            map.put(str.charAt(i)+"",count);
                        }
                    }
                }
            }
        }
        System.out.println(map);
    }
}
