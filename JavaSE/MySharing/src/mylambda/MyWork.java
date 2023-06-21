package mylambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

/**
 * @ClassName MyWork
 * @Description TODO
 * @Author Cunhao Fan
 * @Date 2023/5/13 14:17
 * @Version 1.0
 */
public class MyWork {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-15", "周芷若-16", "赵敏-15");
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                String[] arr = s.split("-");
                String ageString = arr[1];
                return Integer.parseInt(ageString);
            }
        }).forEach(System.out::println);

        System.out.println("==================================");

        list.stream().map(s -> Integer.parseInt(s.split("-")[1])).forEach(System.out::println);
    }
}
