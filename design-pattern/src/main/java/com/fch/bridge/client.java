package com.fch.bridge;

import com.fch.bridge.brand.Xiaomi;
import com.fch.bridge.phone.FoldedPhone;

/**
 * @packageName com.fch.bridge
 * @ClassName client
 * @Description TODO 客户端
 * @Author Fan-CUNH
 * @Date 2023/8/3 11:36
 * @Version 1.0
 */
public class client {
    public static void main(String[] args) {
        // 获取折叠样式手机（品牌+样式）
        FoldedPhone foldedPhone = new FoldedPhone(new Xiaomi());
        foldedPhone.open();
        foldedPhone.close();
        foldedPhone.call();
    }
}
