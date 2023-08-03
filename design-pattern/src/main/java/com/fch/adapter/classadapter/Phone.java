package com.fch.adapter.classadapter;

/**
 * @packageName com.fch.adapter.classadapter
 * @ClassName Phone
 * @Description TODO 手机
 * @Author Fan-CUNH
 * @Date 2023/8/2 21:11
 * @Version 1.0
 */
public class Phone {
    /**
     * 手机充电方法
     *
     * @param iVoltage5V 输出5V 接口类
     */
    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println(" 电压为5V, 可以充电 ");
        } else {
            System.out.println(" 电压 > 5V, 不可以充电 ");
        }
    }
}
