package mylambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName Lambda_02
 * @Description 使用Lambda表达式进行排序
 * @Author Cunhao Fan
 * @Date 2023/5/11 14:26
 * @Version 1.0
 */
public class Lambda_02 {
    public static void main(String[] args) {
        /*数组遍历：创建一个数组，存放三个字符串类型水果的英文名*/
        String[] fruitArr = {"apple", "banana", "orange"};

        Arrays.sort(fruitArr);
        System.out.println(Arrays.toString(fruitArr));
        /*集合遍历：创建一个集合，存放三个字符串类型水果的英文名*/
        List<String> fruitArrList = Arrays.asList("apple", "banana", "orange");
        /*未使用lambda表达式*/
        fruitArrList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                /*return o2.length() - o1.length();*/
                return o1.compareTo(o2);
            }
        });
        System.out.println(fruitArrList);
        System.out.println("===================================");
        /*使用lambda表达式*/
        /*fruitArrList.sort((o1, o2) -> o1.compareTo(o2));*/
        fruitArrList.sort(String::compareTo);
        System.out.println(fruitArrList);
    }
}
