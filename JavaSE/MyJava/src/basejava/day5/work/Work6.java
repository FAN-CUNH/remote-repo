package basejava.day5.work;

import java.util.Arrays;
import java.util.Scanner;

public class Work6 {
         // 选做：编写页面测试上方6个方法：
         // 主界面：1 数组初始化  2 退出
    public static void main(String[] args) {
        // 主界面
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("欢迎进入主界面：1-->数组初始化  2-->退出");
            int sign1 = scanner.nextInt();
            if (sign1 == 1){
                System.out.println("请选择以下服务：");
                System.out.println("1-->统计数组中某个数出现的次数  2-->判断某个数组中某个元素是否出现过  3-->求数组中所有元素的和  4-->删除数组中某个元素");
                System.out.println("5-->数组从小到大排序          6-->以拼接字符1形式修改某个元素      7-->退出（返回上一级）");
                int sign2 = scanner.nextInt();
                int [] arr = {1,2,3,4,5};
                switch (sign2){
                    case 1:
                        Work0.existCount(arr);
                        break;
                    case 2:
                        Work1.isExist(arr,2);
                        break;
                    case 3:
                        System.out.println("数组元素之和为："+ Work2.numSum(arr));
                        break;
                    case 4:
                        System.out.println("删除后数组"+ Arrays.toString(Work3.delNum(arr,2)));
                        break;
                    case 5:
                        System.out.println("从小到大排序后的数组"+ Arrays.toString(Work4.arraySort(arr)));
                        break;
                    case 6:
                        System.out.println("修改后的数组："+Arrays.toString(Work5.addString(arr,2)));
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("该终端不提供此服务！！！请重新选择");
                        break; // 结束该层循环 返回上一层
                }
            }else if (sign1 == 2){
                break; // 结束循环
            }else {
                System.out.println("该终端不提供此服务！！！请重新选择");
            }

        }
    }
}
