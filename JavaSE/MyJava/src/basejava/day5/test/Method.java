package basejava.day5.test;

public class Method {

    public static void printMess (){ // 无参无返回值
        System.out.println("This is Mess!");
    }

    public static void printGetMess (String str){ // 有参无返回值
        System.out.println(str);
    }

    public static int printGetSum (int a,int b){ // 有参有返回值
        return a + b;
    }
    public static void main(String[] args) {
        // 方法的定义 [ 权限修饰符 static 返回值  方法名（数据类型 形参，数据类型 形参）{完成的功能} ]
        // 修饰符：public  返回值： void --> 没有返回值  有返回值 --> 返回值类型
        // 参数:有参 --> 数据类型 变量名,数据类型 变量名,类型 变量名……,类型 变量名 无参数 不写
        // 调用:类名.方法名(实参，实参...，实参);
       Method.printMess(); // 类名.方法名(实参，实参...，实参);
       Method.printGetMess("Get this Mess!");
       System.out.println("a+b="+Method.printGetSum(5,6));


    }
}
