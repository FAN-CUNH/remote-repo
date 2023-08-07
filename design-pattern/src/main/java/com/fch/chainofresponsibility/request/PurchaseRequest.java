package com.fch.chainofresponsibility.request;

/**
 * @packageName com.fch.chainofresponsibility
 * @ClassName PurchaseRequest
 * @Description TODO 购买请求
 * @Author Fan-CUNH
 * @Date 2023/8/7 14:38
 * @Version 1.0
 */
public class PurchaseRequest {
    /**
     * 请求类型
     */
    private Integer type = 0;
    /**
     * 请求金额
     */
    private float price = 0.0f;
    /**
     * 请求ID
     */
    private Integer id = 0;

    public PurchaseRequest(Integer type, float price, Integer id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public Integer getId() {
        return id;
    }
}
