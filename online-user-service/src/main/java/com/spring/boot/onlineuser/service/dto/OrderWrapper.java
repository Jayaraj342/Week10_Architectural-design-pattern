package com.spring.boot.onlineuser.service.dto;

import java.util.List;

public class OrderWrapper {
    private List<Order> persons;

    public List<Order> getOrders() {
        return persons;
    }

    public void setOrders(List<Order> persons) {
        this.persons = persons;
    }
}
