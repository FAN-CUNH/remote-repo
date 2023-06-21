package mylambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Lambda_04
 * @Description 使用Lambda表达式进行集合映射
 * @Author Cunhao Fan
 * @Date 2023/5/11 22:18
 * @Version 1.0
 */
public class Lambda_04 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        List<Integer> lengths1 = new ArrayList<Integer>();
        for (String fruit : list) {
            lengths1.add(fruit.length());
        }

        System.out.println(lengths1);

        List<Integer> lengths2 = list.stream()
                .map(fruit -> fruit.length())
                .collect(Collectors.toList());

        System.out.println(lengths2);
    }
}
