package basejava.day5.work;

import java.util.Scanner;

public class Work10 {
    // 键盘录入密码，要求必须是纯数字6位

    // 创建isNum方法
    public static boolean passwordIsNum (String str){
        // 判断接收的密码是否全为数字
        boolean isNum = true; // 假设全是数字
        for (int i = 0; i < str.length(); i++) { // 遍历字符串,验证是否存在非数字
            if (str.charAt(i) > '9' || str.charAt(i) < '0'){ // 找数字两边 或的关系
                    isNum = false;
                    break; // 找到非数字就跳出循环
                }
            }
            return isNum && str.length() == 6; // 纯数字且六位
        }
        // 主方法
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入密码：");
            String str = scanner.next();
            if (passwordIsNum(str)) {
                System.out.println("你输入密码格式正确！");
            }
            else {
                System.out.println("你输入的密码格式不正确！！！");
            }
        }

    }
