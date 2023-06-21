package javase.day13.test;

import java.util.function.Supplier;

/**
 * @ClassName SupplierDemo
 * @Description Supplier <T>  供给型接口 返回为T的对象
 * @Author Cunhao Fan
 * @Date 2023/4/21 13:44
 * @Version 1.0
 */
/*自定义数组工具类，调用常用函数式接口*/
class ArrayUtil{
    public void getMax(Supplier <Integer> supplier){
        System.out.println("数组最大值："+supplier.get());
    }
}
public class SupplierDemo {
    public static void main(String[] args) {
        /*编写方法，求数组元素的最大值，使用Supplier接口作为方法参数类型，通过Lambda表达式求出Int型数组中的最大值*/
        int[] numArray = {1, 2, 3, 4, 5};
        /*实例化数组工具类*/
        ArrayUtil arrayUtil = new ArrayUtil();
        /*方法1 用匿名内部类，不缩写*/
        arrayUtil.getMax(new Supplier<Integer>() {
            @Override
            public Integer get() {
                int maxIndex = 0; // 用于存放数组中的最大值下标，默认第一个位置的值最大
                for (int i = 0; i < numArray.length; i++) {
                    if (numArray[maxIndex] < numArray[i]) {
                        maxIndex = i;
                    }
                }
                return numArray[maxIndex];
            }
        });

        /*方法2 缩写*/
        arrayUtil.getMax(() -> {
            int maxIndex = 0; // 用于存放数组中的最大值下标，默认第一个位置的值最大
            for (int i = 0; i < numArray.length; i++) {
                if (numArray[maxIndex] < numArray[i]) {
                    maxIndex = i;
                }
            }
            return numArray[maxIndex];
        });
    }
}
