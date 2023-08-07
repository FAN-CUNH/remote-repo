package com.fch.chainofresponsibility.handle;

import com.fch.chainofresponsibility.request.PurchaseRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * @packageName com.fch.chainofresponsibility
 * @ClassName DepartmentApprove
 * @Description TODO 具体处理者
 * @Author Fan-CUNH
 * @Date 2023/8/7 14:49
 * @Version 1.0
 */
@Slf4j
public class DepartmentApprove extends Approve {
    /**
     * 构造器
     *
     * @param name 当前处理者的名字
     */
    public DepartmentApprove(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000) {
            log.info(" 请求编号ID = " + purchaseRequest.getId() + " 被 " + this.name + "处理");
        } else {
            approve.processRequest(purchaseRequest);
        }
    }
}
