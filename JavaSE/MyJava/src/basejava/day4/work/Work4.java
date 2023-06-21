package basejava.day4.work;

public class Work4 {
    public static void main(String[] args) {
        // 定义一个字符串数组，统计所有字母出现的次数假定字符串如果是字母只能是单个字母
        // 提示：将单字母字符串转换为字符的方法：char c = "a".charAt(0);
        // System.out.println(c >= 'A');
        String[] mess = {"A", "B", "56", "5", "78", "78", "a"};

        letterCount:
        for (int i = 0; i < mess.length; i++) { // 遍历数组
            if (mess[i].length() == 1) {
                // 判断当前字符有没有出现过，如果已出现则不继续统计 --> 此处有问题！！！
                for (int k = 0; k < i; k++) {
                    if (mess[i].charAt(0) == mess[k].charAt(0) && mess[k].length() == 1)
                        continue letterCount;
                }

                int existCount = 0; // 计数 字符出现的次数
                // 统计A-Z字母出现的次数
                if (mess[i].charAt(0) >= 'A' && mess[i].charAt(0) <= 'Z') {
                    for (int k = i; k < mess.length; k++) {
                        if (mess[i].charAt(0) == mess[k].charAt(0)) { // 取字符串数组每个元素里的每个字符进行比较 如果相同就加1
                            existCount++;
                        }
                    }
                }
                // 统计0-9数字出现的次数
                if (mess[i].charAt(0) >= '0' && mess[i].charAt(0) <= '9') {
                    for (int k = i; k < mess.length; k++) {
                        if (mess[i].charAt(0) == mess[k].charAt(0)) {
                            existCount++;
                        }
                    }
                }
                // 打印结果
                System.out.println(mess[i].charAt(0) + "出现的次数为：" + existCount);
            }
        }


    }
}
