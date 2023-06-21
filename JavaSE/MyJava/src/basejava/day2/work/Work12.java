package basejava.day2.work;

public class Work12 {
    public static void main(String[] args) {
        // 键盘录入某个数，判断某个数是否是素数，如果是打印是素数，如果不是打印不是素数（选做）
    /*    Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scanner.nextInt();
        int i;
        for (i = 2; i < num; i++) {
            if (num % i == 0)
                break;
        }
        if (i < num) { // 说明这个数被除去1和它自身的其他数整除 不是质数
            System.out.println(num+"不是质数");
        }else {
            System.out.println(num+"是质数");
        }

        // 标记思想写法：验证某一段代码是否发生
        boolean flag = false;
        int j;
        for (j = 2; j < num; j++) {
            if (num % j == 0)
                flag = true;
        }
        if (flag) { // 说明这个数被除去1和它自身的其他数整除 不是质数
            System.out.println(num+"不是质数");
        }else {
            System.out.println(num+"是质数");
        }
*/
        // 找到1000以内的所有素数和个数
        boolean flag1 = false; // 标记
        int count = 0; // 计数器
        for (int k = 2; k < 1000; k++) {  // 第一层循环确定数的范围
            for (int l = 2; l < k; l++) { // 第二层循环判断是否是质数
                if (k % l == 0)
                    flag1 = true; // 如果不是质数则将flag值标记为true
            }
            if (!flag1) { // 如果flag未触发 即是质数
                count++;
                System.out.print(k);
                System.out.print(" ");
            }
            flag1 = false; // 重置
        }
        System.out.println();
        System.out.println("个数:"+count);
    }
}
