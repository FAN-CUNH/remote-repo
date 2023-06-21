package mylambda;

import javax.xml.transform.Source;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName Lambda_06
 * @Description 使用Lambda表达式进行分组
 * @Author Cunhao Fan
 * @Date 2023/5/13 13:19
 * @Version 1.0
 */
public class Lambda_06 {
    public static void main(String[] args) {
        List<String> arrayList = Arrays.asList("apple", "banana", "orange");
        Map<Integer, ArrayList<String>> grouped = new HashMap<>();
        for (String fruit : arrayList) {
            int length = fruit.length();
            if (!grouped.containsKey(length)) {
                grouped.put(length, new ArrayList<>());
            }
            grouped.get(length).add(fruit);
        }
        System.out.println(grouped);
        System.out.println("============================================");

        Map<Integer, List<String>> grouped2 = arrayList.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(grouped2);
    }
}
