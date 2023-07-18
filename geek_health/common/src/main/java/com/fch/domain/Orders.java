package com.fch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
public class Orders implements Serializable {

    public static final String ORDER_TYPE_TELEPHONE = "电话预约";
    public static final String ORDER_TYPE_WEIXIN = "微信预约";
    public static final String ORDER_STATUS_YES = "已就诊";
    public static final String ORDER_STATUS_NO = "未就诊";

    private Integer id;

    private Integer memberId;

    private Date orderDate;

    private String orderType;

    private String orderStatus;

    private Integer setmealId;

    public Orders() {
    }

    public Orders(Integer memberId, Date orderDate, String orderType, String orderStatus, Integer setmealId) {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.setmealId = setmealId;
    }

    public Orders(Integer id, Integer memberId, Date orderDate, String orderType, String orderStatus, Integer setmealId) {
        this.id = id;
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.setmealId = setmealId;
    }
}