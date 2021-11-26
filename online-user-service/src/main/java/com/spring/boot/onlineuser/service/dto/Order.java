package com.spring.boot.onlineuser.service.dto;

public class Order {

    private int orderId;
    private int quantity;

    public Order(int orderId, int quantity) {
        this.orderId = orderId;
        this.quantity = quantity;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
