package com.fch.adapter.classadapter;

/**
 * @packageName com.fch.adapter.classadapter
 * @ClassName VoltageAdapter
 * @Description TODO 电压适配器 -> 类适配器
 * @Author Fan-CUNH
 * @Date 2023/8/2 21:04
 * @Version 1.0
 */
public class VoltageAdapter extends Voltage220V implements IVoltage5V {
    /**
     * 输出5V电压接口
     *
     * @return 电压
     */
    @Override
    public int output5V() {
        // 获取 220V 电压
        int src = super.output220V();

        // 输出 5V 电压
        int dst = src / 44;

        return dst;
    }
}
