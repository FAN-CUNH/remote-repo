package basejava.day5.work;

public class Work1 {
    // 定义方法完成判断某个数组中某个元素是否出现过
    public static void isExist (int [] numArray,int num){
        for (int i = 0; i < numArray.length; i++) { // 遍历数组

            boolean isExist = false; // 假设未出现
                if (numArray[i] == num){ // 值相等 则说明数组中出现了这个数
                    isExist = true;
                    break; // 结束循环
                }
            if (!isExist){
                System.out.println(num+"  is exist!");
            }
        }
        // 返回值为布尔类型
    }

    public static boolean isExistPlus (int [] numArray,int num){
        boolean isExist = false; // 假设未出现
        for (int i = 0; i < numArray.length; i++) { // 遍历数组

            if (numArray[i] == num){ // 值相等 则说明数组中出现了这个数
                isExist = true;
                break; // 结束循环
            }
        }
        return isExist;
        // 返回值为布尔类型
    }
    public static void main(String[] args) {
        isExist(new int[] {1,2,3,4,5,6,2,4},2);
        if (isExistPlus(new int[] {1,2,3,4,5,6,2,4},9)){
            System.out.println("存在");
        }
        else {
            System.out.println("不存在");
        }
    }
}
