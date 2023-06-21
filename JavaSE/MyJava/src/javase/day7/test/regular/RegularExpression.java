package javase.day7.test.regular;

/**
 * @ClassName RegularExpression
 * @Description 正则表达式学习
 * @Author Cunhao Fan
 * @Date 2023/4/14 15:14
 * @Version 1.0
 */
public class RegularExpression {
    public static void main(String[] args) {
        /*首字母必须是字母，中间不能出现数字，以下划线结尾*/
        String regex = "[a-zA-Z]+[^0-9]*[_]+";
        String str = "asfs_";
        boolean isRight = str.matches(regex);
        System.out.println(isRight);
    }
}
