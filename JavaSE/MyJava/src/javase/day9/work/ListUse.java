package javase.day9.work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ListUse
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/4/17 20:24
 * @Version 1.0
 */
public class ListUse {
    /*frequency(ArrayList arr, String key)方法*/
    int keyCount = 0;
    public int frequency(ArrayList strList, String key){
        for (Object everyString:strList
             ) {
            if (everyString.equals(key)){
                keyCount++;
            }
        }
        return keyCount;
    }
    public static void main(String[] args) {
        /*实例化集合*/
        List <String> strList = new ArrayList<String>(Arrays.asList("a","b","c","c","a","b","b","b","a"));
        /*实例化本类对象*/
        ListUse listUse = new ListUse();
        System.out.println(listUse.frequency((ArrayList) strList,"a"));
    }
}
