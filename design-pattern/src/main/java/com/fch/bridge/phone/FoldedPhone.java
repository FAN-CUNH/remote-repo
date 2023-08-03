package com.fch.bridge.phone;

import com.fch.bridge.brand.Brand;

/**
 * @packageName com.fch.bridge.phone
 * @ClassName FoldedPhone
 * @Description TODO 折叠式手机
 * @Author Fan-CUNH
 * @Date 2023/8/3 11:32
 * @Version 1.0
 */
public class FoldedPhone extends Phone {
    /**
     * @param brand 品牌
     */
    public FoldedPhone(Brand brand) {
        super(brand);
    }

    /**
     * 开机
     */
    @Override
    public void open() {
        super.open();
        System.out.println(" 折叠样式手机 ");
    }

    /**
     * 关机
     */
    @Override
    public void close() {
        super.close();
        System.out.println(" 折叠样式手机 ");
    }

    /**
     * 打电话
     */
    @Override
    public void call() {
        super.call();
        System.out.println(" 折叠样式手机 ");
    }
}
