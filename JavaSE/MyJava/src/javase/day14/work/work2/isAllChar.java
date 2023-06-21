package javase.day14.work.work2;

import java.util.Scanner;
import java.util.function.Predicate;

/**
 * @ClassName isAllChar
 * @Description 使用函数式接口完成判断键盘录入的数值是否是纯字母并且首字母是否是_
 * @Author Cunhao Fan
 * @Date 2023/4/23 13:56
 * @Version 1.0
 */
public class isAllChar {
    public static void main(String[] args) {
        /*Predicate*/
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Predicate<String> predicate = s -> s.matches("^[_]{1}[a-zA-Z]+");
        boolean isAllChar = predicate.test(str);
        System.out.println(isAllChar);
    }
}
