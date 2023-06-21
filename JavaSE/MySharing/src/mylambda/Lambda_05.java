package mylambda;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Lambda_05
 * @Description 使用Lambda表达式进行集合归约
 * @Author Cunhao Fan
 * @Date 2023/5/11 22:26
 * @Version 1.0
 */
public class Lambda_05 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int sum1 = 0;
        for (int i : list) {
            sum1 += i;
        }

        System.out.println(sum1);

        int sum2 = list.stream().reduce(0, (a, b) -> a + b);

        System.out.println(sum2);
    }
}
