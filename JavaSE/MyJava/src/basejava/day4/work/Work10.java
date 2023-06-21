package basejava.day4.work;

import java.util.Arrays;

public class Work10 {
    public static void main(String[] args) {
        // 通过二维数组定义一个字符二维数组存放静夜思这首古诗；
        // char[][] shi = {{'床','前','明','月','光'}，{}，{}，{}}
        // 要求通过二维数组的遍历将古诗每个字逗号隔开打印出来
        // 升级选做：将古诗每个字逗号隔开竖着打印出来

        char[][] arr = {{'床','前','明','月','光'},{'疑','是','地','上','霜'},{'举','头','望','明','月'},{'低','头','思','故','乡'}};
        for (int i = 0; i < arr.length; i++) { // 正常打印
            System.out.println(Arrays.toString(arr[i]));
        }

        for (int j = 0; j < arr[0].length; j++) { // 竖着打印
            for (int k = 0; k < arr.length; k++) {
                System.out.print(arr[k][j]);
                if (k < arr.length-1){
                    System.out.print(",");
                }
            }
            System.out.println();
        }

    }
}
