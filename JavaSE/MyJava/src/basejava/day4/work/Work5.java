package basejava.day4.work;

public class Work5 {
    public static void main(String[] args) {
        // 定义一个字符串数组，得到长度是3并且值不等于"lil"的元素个数
        String [] arr = {"lil","ili","ll","lit"};
        int count = 0;
        for (int i = 0; i < arr.length; i++) { // 遍历数组
            if (arr[i].length() == 3 && !(arr[i].equals("lil"))){ // 查找长度是3并且值不等于"lil"的元素
                count++; // 计数
            }
        }
        System.out.println("长度是3并且值不等于\"lil\"的元素个数"+count);
    }
}
