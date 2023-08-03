package com.fch.adapter.objectadapter;

/**
 * @packageName com.fch.adapter.classadapter
 * @ClassName VoltageAdapter
 * @Description TODO 电压适配器 -> 对象适配器
 * @Author Fan-CUNH
 * @Date 2023/8/2 21:04
 * @Version 1.0
 */
public class VoltageAdapter implements IVoltage5V {

    private Voltage220V voltage220V;

    public VoltageAdapter(Voltage220V voltage220V) {
        this.voltage220V = voltage220V;
    }

    /**
     * 输出5V电压接口
     *
     * @return 电压
     */
    @Override
    public int output5V() {
        // 获取 220V 电压
        int src = 0;
        if (voltage220V != null) {
            src = voltage220V.output220V();
        }

        // 输出 5V 电压
        int dst = src / 44;

        return dst;
    }
}
