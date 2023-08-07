package com.fch.chainofresponsibility.handle;

import com.fch.chainofresponsibility.request.PurchaseRequest;

/**
 * @packageName com.fch.chainofresponsibility
 * @ClassName Approve
 * @Description TODO 抽象处理者
 * @Author Fan-CUNH
 * @Date 2023/8/7 14:43
 * @Version 1.0
 */
public abstract class Approve {
    /**
     * 后继者 下一个处理者
     */
    Approve approve;

    String name;

    /**
     * 构造器
     *
     * @param name 当前处理者的名字
     */
    public Approve(String name) {
        this.name = name;
    }

    /**
     * @param approve 下一个处理者
     */
    public void setApprove(Approve approve) {
        this.approve = approve;
    }

    public abstract void processRequest(PurchaseRequest purchaseRequest);
}
