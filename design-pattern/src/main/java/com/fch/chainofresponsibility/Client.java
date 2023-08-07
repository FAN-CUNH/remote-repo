package com.fch.chainofresponsibility;

import com.fch.chainofresponsibility.handle.CollegeApprove;
import com.fch.chainofresponsibility.handle.DepartmentApprove;
import com.fch.chainofresponsibility.handle.PrincipalApprove;
import com.fch.chainofresponsibility.handle.VicePrincipalApprove;
import com.fch.chainofresponsibility.request.PurchaseRequest;

/**
 * @packageName com.fch.chainofresponsibility
 * @ClassName Client
 * @Description TODO 客户端
 * @Author Fan-CUNH
 * @Date 2023/8/7 15:00
 * @Version 1.0
 */
public class Client {
    public static void main(String[] args) {
        // 请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 30001, 1);
        PurchaseRequest purchaseRequest1 = new PurchaseRequest(2, 1000, 2);

        // 处理者
        DepartmentApprove departmentApprove = new DepartmentApprove("张主任");
        CollegeApprove collegeApprove = new CollegeApprove("李院长");
        VicePrincipalApprove vicePrincipalApprove = new VicePrincipalApprove("王副校长");
        PrincipalApprove principalApprove = new PrincipalApprove("麻校长");

        // 建立处理者之间的关系 环形结构
        departmentApprove.setApprove(collegeApprove);
        collegeApprove.setApprove(vicePrincipalApprove);
        vicePrincipalApprove.setApprove(principalApprove);
        principalApprove.setApprove(departmentApprove);

        // 处理请求
        departmentApprove.processRequest(purchaseRequest);

        principalApprove.processRequest(purchaseRequest1);
    }
}
