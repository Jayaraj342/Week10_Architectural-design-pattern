package com.spring.boot.onlineuser.service.service;

import com.spring.boot.onlineuser.service.dto.Order;
import com.spring.boot.onlineuser.service.entity.Item;
import com.spring.boot.onlineuser.service.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnlineUserService {
    private final ItemRepository itemRepository;

    public OnlineUserService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public String bookSeat(Date date) {
        if (date.before(getTwoDaysAfterToday().getTime())) {
            return "Rejected! should book 2 days before!";
        }
        return "Success!";
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> selectItems(List<Order> orders) {
        List<Integer> ids = orders.stream().map(Order::getOrderId).collect(Collectors.toList());
        return ids.stream().map(itemRepository::getOne).collect(Collectors.toList());
    }

    public String getLastBill() {
        return "bill";
    }

    public Calendar getTwoDaysAfterToday() {
        Calendar twoDaysAfterToday = getStartOfToday();
        twoDaysAfterToday.add(Calendar.DATE, 2);
        return twoDaysAfterToday;
    }

    private Calendar getStartOfToday() {
        Calendar today = new GregorianCalendar();
        today.setTime(new Date());
        today.set(Calendar.HOUR, 0);
        today.set(Calendar.HOUR_OF_DAY, 0);
        today.set(Calendar.MINUTE, 0);
        today.set(Calendar.SECOND, 0);
        today.set(Calendar.MILLISECOND, 0);
        return today;
    }
}
