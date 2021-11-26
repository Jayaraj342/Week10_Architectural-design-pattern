package com.spring.boot.festivesale.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/surabi-restaurant")
public class FestiveSaleController {

    @GetMapping("/discount")
    public String discount(int discount) {
        return discount + " % discount applied";
    }

}
