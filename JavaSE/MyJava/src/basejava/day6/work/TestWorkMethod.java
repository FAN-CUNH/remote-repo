package basejava.day6.work;

public class TestWorkMethod {
    // 1 通过方法+数组结合实现完成判断键盘录入的数值是否是回文数，如果是打印是回文数，如果不是打印不是回文数，假设不知道是几位数
    public static void isPalin(int num) {
        int sum = 0;
        int yuanshu = num;
        while (num != 0){
            int weishu = num % 10;
            num = num / 10;
            sum = (sum * 10) + weishu;
        }
        System.out.println(sum);
        if (yuanshu == sum) {
            System.out.println(yuanshu  + "是");
        } else
            System.out.println(yuanshu + "不是");
    }

    //2 通过方法+数组实现键盘录入一个学生的姓名和密码；姓名不能出现_和字母；密码必须是纯数字6位，如果不符合要求可以一直输入；符合要求打印姓名是某某，密码是某某
    public static boolean adminAndPass(String admin,String password){
        // 判断是否存在下划线和字母
        boolean adminAndPass = false;
        boolean isCharExist = true;
        boolean isNum = true;
        for (int i = 0; i < admin.length(); i++) {
            char c = admin.charAt(i);
            if (c == '_' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'){
                isCharExist = false;
            }
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (c >= '9' || c <= '0'){
                isNum = false;
            }
        }

        if (isCharExist && (isNum && password.length()==6)){
            adminAndPass = true;
        }
        return adminAndPass;
    }

    // 3 通过方法+数组实现数组的反转
    // 数组元素逆置
    public static void reverseArray (int [] arr){
        // 让第一位和最后一位交换位置，第二位和倒数第二位交换
        for (int i = 0; i < arr.length / 2; i++) { // 只循环数组的一半即可
            int temp = arr[i];
            arr[i] = arr[arr.length-(i+1)];
            arr[arr.length-(i+1)] = temp;
        }
    }

    // 4 通过方法+数组实现将某个数组中所有的素数求和
    public static int getSum(int [] numArray){
        int sum = 0;
        boolean isSuShu = false;
        for (int i = 0; i < numArray.length; i++) {
            int j = 2;
            for (; j < numArray[i]; j++) { // 判断是否是素数
                if (numArray[i] % j == 0)
                    break;
            }
                if (!(j < numArray[i])){
                    isSuShu = true;
                    sum = sum + numArray[i];
                }

        }
        return sum;
    }
    
    // 5 通过方法+字符串实现打印信息：打印字符串中每种元素出现的次数
    public static void getEleCount(String str){
        char [] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            // 判断当前元素是否出现过
            boolean isExist = false; // 假设没出现
            for (int j = 0; j < i; j++) {
                if (c[j] == c[i]){
                    isExist = true;// 假设不成立
                    break;// 结束循环
                }
            }
            if (!isExist){// 假设成立，则需要统计个数
            int targetEleCount = 0; // 计数器
                char target = c[i]; // 目标元素
                for (int j = 0; j < c.length; j++) {
                    if (target == c[j]){
                        targetEleCount++;
                    }
                }
                System.out.println(target+"出现的次数为："+targetEleCount);
            }
        }

    }



    // 给定字符串表示用户名称，验证用户名称是否符合要求只能由字母，数字，_,$组成的长度是8到16位的字符串，否则提示不符合要求

    public static boolean isSucAdmin (String string){ //
        boolean isSuccess = false; // 假设不符合
        // 遍历字符串
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9' || c == '_' || c == '&'){
                isSuccess = true;
            }
        }
        return isSuccess && (string.length() >= 8 && string.length() <= 16);
    }

    // 给定字符串http://localhost:8080/common/TestCommon.action获取请求名称，
    // 并且打印请求名称中是否出现连续3个a字符组合[请求名就是最后一个/之后最后一个.之前的内容]

    public static String getReqName(String string){
       String str = string.substring(string.lastIndexOf('/')+1,string.lastIndexOf('.')); // 将最后一个/之后.之前的字符串截取出来
       boolean isExist = str.contains("aaa"); // 存在isExist为真否则为假
       if (isExist){
           System.out.println("出现aaa");
       }
       else {
           System.out.println("未出现aaa");
       }
       return str;
    }


}