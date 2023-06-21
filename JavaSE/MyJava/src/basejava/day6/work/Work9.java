package basejava.day6.work;

public class Work9 {
    // 删除字符串中所有的空格：提示：“”替换空格
    public static String delEle(String str){
        return str = str.replace(" ","");
        // System.out.println(str); // 要么再此处输出str 要么将此方法改成有返回值的
    }


    public static void main(String[] args) {
        String str = "1 2 34";
        delEle(str);
        // str = delEle(str); 将返回的str存入str中 因为字符串是不支持修改的 所以要重新存入
        System.out.println(str); // 此处输出有空格是因为 方法中的str是局部变量 若是想要此处发生变化 则需要在delEle的方法中加入返回值 然后此处System.out.println(delEle（str）);
    }
}
