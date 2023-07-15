package com.fch.domain;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class Ordersetting implements Serializable {
    private Integer id;

    /**
     * 预约数量
     */
    private Date orderDate;

    /**
     * 可预约数量
     */
    private Integer number;

    /**
     * 已预约数量
     */
    private Integer reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getReservations() {
        return reservations;
    }

    public void setReservations(Integer reservations) {
        this.reservations = reservations;
    }

    public Ordersetting() {
    }

    public Ordersetting(Date orderDate, Integer number, Integer reservations) {
        this.orderDate = orderDate;
        this.number = number;
        this.reservations = reservations;
    }
}