package com.fch.adapter.objectadapter;

/**
 * @packageName com.fch.adapter.classadapter
 * @ClassName Voltage220V
 * @Description TODO 输出 220V 的电压
 * @Author Fan-CUNH
 * @Date 2023/8/2 20:57
 * @Version 1.0
 */
public class Voltage220V {
    /**
     * 输出220V电压
     *
     * @return 电压
     */
    public int output220V() {
        int src = 220;
        System.out.println(" 电压 = " + src + "伏 ");
        return src;
    }
}
