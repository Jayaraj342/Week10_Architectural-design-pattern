package com.spring.boot.onlineuser.service.controller;

import com.spring.boot.onlineuser.service.dto.Bill;
import com.spring.boot.onlineuser.service.dto.Order;
import com.spring.boot.onlineuser.service.entity.Item;
import com.spring.boot.onlineuser.service.service.OnlineUserService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/surabi-restaurant")
public class OnlineUserController {

    private final OnlineUserService onlineUserService;

    public OnlineUserController(OnlineUserService onlineUserService) {
        this.onlineUserService = onlineUserService;
    }

    @GetMapping("/book-seat")
    public String bookSeat(@RequestParam(defaultValue = "2021-11-28") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        return onlineUserService.bookSeat(date);
    }

    @GetMapping("/view-menu")
    public List<Item> viewMenu() {
        return onlineUserService.getAllItems();
    }

    @PostMapping("/order")
    public String order(@RequestBody List<Order> orders) {
        List<Item> items = onlineUserService.selectItems(orders);
        int totalPrice = 0;
        for (Item item : items) {
            Order current = orders
                    .stream()
                    .filter(order -> order.getOrderId() == item.getId())
                    .findFirst()
                    .orElse(new Order(0, 0));
            totalPrice += item.getPrice() * current.getQuantity();
        }
        return items + " selected & Final bill is ₹" + totalPrice;
    }

    @GetMapping("/pay-bill")
    public String payBill(Bill bill) {
        return "bill payed using " + bill;
    }

    @GetMapping("/feedback")
    public String feedback(String feedback) {
        if(!feedback.matches("[a-zA-Z0-9]+")) {
            return "feedback should only contain characters and numbers!";
        }
        return "feedback noted!";
    }
}
