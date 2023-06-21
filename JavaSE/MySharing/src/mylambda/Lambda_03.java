package mylambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Lambda_03
 * @Description 使用Lambda表达式进行集合过滤
 * @Author Cunhao Fan
 * @Date 2023/5/11 15:48
 * @Version 1.0
 */
public class Lambda_03 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        List<String> filteredList1 = new ArrayList<String> ();
        for (String fruit : list) {
            if (fruit.startsWith("a")) {
                filteredList1.add(fruit);
            }
        }
        System.out.println(filteredList1);

        List<String> filteredList2 = list.stream().filter(fruit -> fruit.startsWith("a")).collect(Collectors.toList());
        System.out.println(filteredList2);
    }
}
